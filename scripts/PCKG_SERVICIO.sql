DROP PACKAGE FINALBPM.PCKG_SERVICIO;

CREATE OR REPLACE PACKAGE FINALBPM.Pckg_Servicio
IS
   FUNCTION Fn_Obtener_Firma (p_Cod_Servicio         IN VARCHAR2,
                              p_Cod_Centro_Tramite   IN VARCHAR2,
                              p_Tipo_Firma           IN VARCHAR2)
      RETURN VARCHAR2;

   PROCEDURE Sp_Requsitos_Documentarios (
      p_Cod_Servicio   IN     VARCHAR2,
      Reg                 OUT SYS_REFCURSOR);

   PROCEDURE Sp_Requsitos_Documentarios_Exp (
      pCodExpediente   IN     VARCHAR2,
      Reg                 OUT SYS_REFCURSOR);

   PROCEDURE Sp_Requsitos_Doc_Salida (Pcodexpediente   IN     VARCHAR2,
                                      Reg                 OUT SYS_REFCURSOR,
                                      cerrado             OUT VARCHAR2);

   PROCEDURE Sp_Obtener_Requsitos_Propios (
      p_Cod_Servicio   IN     VARCHAR2,
      Reg                 OUT SYS_REFCURSOR);

   PROCEDURE Sp_Servicios_Por_Clase (p_Cod_Clase   IN     VARCHAR2,
                                     Reg              OUT SYS_REFCURSOR);

   FUNCTION Fn_Cantidad_Inspecciones (p_Cod_Expediente   IN VARCHAR2,
                                      p_Cod_Servicio     IN VARCHAR2)
      RETURN NUMBER;

   FUNCTION Fn_Tipo_Servicio (p_Cod_Expediente   IN VARCHAR2,
                              p_Cod_Servicio     IN VARCHAR2)
      RETURN NUMBER;
END Pckg_Servicio;

/


CREATE OR REPLACE PUBLIC SYNONYM PCKG_SERVICIO FOR FINALBPM.PCKG_SERVICIO;


GRANT EXECUTE, DEBUG ON FINALBPM.PCKG_SERVICIO TO R_FINALBPM;

GRANT EXECUTE ON FINALBPM.PCKG_SERVICIO TO R_FINALBPM_RO;

GRANT EXECUTE ON FINALBPM.PCKG_SERVICIO TO VUCE;
DROP PACKAGE BODY FINALBPM.PCKG_SERVICIO;

CREATE OR REPLACE PACKAGE BODY FINALBPM.Pckg_Servicio
IS
   FUNCTION Fn_Obtener_Firma (p_Cod_Servicio         IN VARCHAR2,
                              p_Cod_Centro_Tramite   IN VARCHAR2,
                              p_Tipo_Firma           IN VARCHAR2)
      RETURN VARCHAR2
   IS
      l_Firma   VARCHAR2 (100);
   BEGIN
      SELECT Usuario || '-' || Tipo_Firma
        INTO l_Firma
        FROM Firma_Servicio_Ct t
       WHERE     t.Codigo_Servicio = p_Cod_Servicio
             AND t.Codigo_Centro_Tramite = p_Cod_Centro_Tramite
             AND t.Tipo_Firma = p_Tipo_Firma;

      RETURN l_Firma;
   EXCEPTION
      WHEN OTHERS
      THEN
         RETURN '';
   END Fn_Obtener_Firma;

   PROCEDURE Sp_Requsitos_Documentarios (
      p_Cod_Servicio   IN     VARCHAR2,
      Reg                 OUT SYS_REFCURSOR)
   IS
   BEGIN
      OPEN Reg FOR
           SELECT Rs.Codigo_Servicio,
                  s.Descripcion_Servicio,
                  d.Codigo_Documento,
                  d.Descripcion_Documento,
                  Rs.Indicador_Obligatorio,
                  d.Sub_Tipo,
                  d.Ruta_Check_In
             FROM Requisito_Servicio Rs, Servicio_Tupa s, Documento d
            WHERE     Rs.Codigo_Servicio = s.Codigo_Servicio
                  AND d.Codigo_Documento = Rs.Codigo_Documento
                  AND s.Estado = 'ACTIVO'
                  AND d.Estado = 'ACTIVO'
                  AND s.Codigo_Servicio IN (SELECT COLUMN_VALUE
                                              FROM TABLE (
                                                      split (p_Cod_Servicio,
                                                             '|')))
                  AND (Rs.Indicador_Tupa = 'Y' OR Rs.Indicador_Tupa IS NULL)
                  AND rs.indicador_ing_sal = 'I'
         ORDER BY rs.codigo_servicio, rs.orden;
   END Sp_Requsitos_Documentarios;

   PROCEDURE Sp_Requsitos_Documentarios_Exp (
      Pcodexpediente   IN     VARCHAR2,
      Reg                 OUT SYS_REFCURSOR)
   IS
      Pcodigostddoc   VARCHAR2 (12);
      Pnombrestd      VARCHAR2 (2000);
      Pucmid          VARCHAR2 (50);
      cod_sol         VARCHAR2 (12);
   BEGIN
      /*BEGIN
         SELECT s.Codigo_Std_Doc, s.Nombre
           INTO Pcodigostddoc, Pnombrestd
           FROM Std_Documento s
          WHERE     s.Nombre LIKE '%' || Pcodexpediente || '%'
                AND (   s.Codigo_Tipo_Documento = '019'
                     OR s.codigo_tipo_documento IS NULL);
      EXCEPTION
         WHEN OTHERS
         THEN
            Pcodigostddoc := NULL;
      END;*/

      /*IF Pcodigostddoc IS NOT NULL THEN
        SELECT max(r.Ucm_Id)
          INTO Pucmid
          FROM Recibo r
         WHERE r.Codigo_Expediente = Pcodexpediente;

        Pckg_Grabar.Sp_Sys_Registro_Archivo(Pcodigostddoc,
                                            Pnombrestd,
                                            '019',
                                            Pucmid);
      END IF;*/

      SELECT codigo_solicitud
        INTO cod_sol
        FROM (  SELECT ROWNUM, s.codigo_solicitud
                  FROM solicitud s
                 WHERE s.codigo_expediente = Pcodexpediente
              ORDER BY s.fech_crea DESC)
       WHERE ROWNUM = 1;

      /*select max(s.codigo_solicitud)
       into cod_sol
       from solicitud s
      where s.codigo_expediente = Pcodexpediente;*/
      OPEN Reg FOR
           SELECT Rs.Codigo_Servicio,
                  s.Descripcion_Servicio,
                  d.Codigo_Documento,
                  d.Descripcion_Documento,
                  Rs.Indicador_Obligatorio,
                  d.Sub_Tipo,
                  d.Ruta_Check_In
             FROM Requisito_Servicio Rs, Servicio_Tupa s, Documento d
            WHERE     Rs.Codigo_Servicio = s.Codigo_Servicio
                  AND d.Codigo_Documento = Rs.Codigo_Documento
                  AND s.Estado = 'ACTIVO'
                  AND d.Estado = 'ACTIVO'
                  AND s.Codigo_Servicio IN (SELECT DISTINCT e.Codigo_Servicio
                                              FROM Finalbpm.Expediente_Servicios e
                                             --               WHERE e.Codigo_Expediente = Pcodexpediente)
                                             WHERE e.codigo_solicitud = cod_sol)
                  AND (Rs.Indicador_Tupa = 'Y' OR Rs.Indicador_Tupa IS NULL)
                  AND Rs.Indicador_Ing_Sal = 'I'
         ORDER BY Rs.Codigo_Servicio, Rs.Orden;
   END Sp_Requsitos_Documentarios_Exp;

   PROCEDURE Sp_Requsitos_Doc_Salida (Pcodexpediente   IN     VARCHAR2,
                                      Reg                 OUT SYS_REFCURSOR,
                                      cerrado             OUT VARCHAR2)
   IS
      cod_sol         VARCHAR2 (12);
      cont_res        NUMBER;
      cont_res_prov   NUMBER;
   BEGIN
      SELECT codigo_solicitud
        INTO cod_sol
        FROM (  SELECT ROWNUM, s.codigo_solicitud
                  FROM solicitud s
                 WHERE s.codigo_expediente = Pcodexpediente
              ORDER BY s.fech_crea DESC)
       WHERE ROWNUM = 1;

      SELECT COUNT (*)
        INTO cont_res
        FROM documento_resolutivo d
       WHERE d.codigo_solicitud = cod_sol;

      IF cont_res > 0
      THEN
         cerrado := '1';

         OPEN Reg FOR
            SELECT d.ucm_id Ucmid,
                   d.codigo_tipo_documento Codigo_Documento,
                   t.descripcion_documento,
                   d.indicador_obligatorio,
                   t.sub_tipo,
                   t.ruta_check_in,
                   TO_NUMBER (d.archivo_folio) Numfolios,
                   d.confidencial Confidencialidad,
                   d.codigo_documento AS cod_std_doc
              /*,
              (SELECT f.Nume_Regi_Arc
                 FROM Sys_Registro_Archivos_Fisico f
                WHERE trim(f.numerodocumento_ucm) = trim(d.ucm_id)) Numeregiarc,
              null*/
              FROM documento_resolutivo r,
                   documento_resolutivo_detalle d,
                   documento t
             WHERE     r.codigo_doc_resolutivo = d.codigo_doc_resolutivo
                   AND d.codigo_tipo_documento = t.codigo_documento
                   AND r.codigo_solicitud = cod_sol
            UNION
            SELECT a.ucmid,
                   a.codigo_documento,
                   a.descripcion_documento,
                   a.indicador_obligatorio,
                   a.Sub_Tipo,
                   a.ruta_check_in,
                   a.Numfolios,
                   a.Confidencialidad,
                   a.cod_std_doc
              FROM (  SELECT adj.Ucm_Id AS Ucmid,
                             '' AS Codigo_Documento,
                             'CEV (XML) - ' || Pcodexpediente
                                AS descripcion_documento,
                             'N' AS indicador_obligatorio,
                             'DOCUMENTO GENERICO' Sub_Tipo,
                             '' AS ruta_check_in,
                             1 AS Numfolios,
                             'N' AS Confidencialidad,
                             '' AS cod_std_doc
                        FROM vuce.documento d1
                             INNER JOIN vuce.documento d2
                                ON     d1.doc_ref_tipo = d2.doc_tipo
                                   AND d1.doc_ref_numero = d2.doc_numero
                             INNER JOIN vuce.adjunto adj
                                ON adj.id_documento = d2.id
                       WHERE     d1.doc_tipo = 'E'
                             AND d2.doc_tipo = 'DR'
                             AND d1.doc_numero = Pcodexpediente
                             AND (   adj.Nombre LIKE 'CFE%'
                                  OR adj.Nombre LIKE 'CEF%'
                                  OR adj.Nombre LIKE 'CEV%')
                    ORDER BY D2.AUD_FECHACREACION DESC) a
             WHERE ROWNUM = 1
            UNION
            -- MUESTRA LOS CEV ENVIADOS A HOLANDA Y  USA
            SELECT cer.iducm AS Ucmid,
                   '' AS Codigo_Documento,
                   'CEV (XML) -' || Pcodexpediente AS descripcion_documento,
                   'N' AS indicador_obligatorio,
                   'DOCUMENTO GENERICO' Sub_Tipo,
                   '' AS ruta_check_in,
                   1 AS Numfolios,
                   'N' AS Confidencialidad,
                   '' AS cod_std_doc
              FROM bpmtupa.bt_certificado cer
                   INNER JOIN bpmtupa.bt_expediente EXP
                      ON cer.idexpediente = EXP.codigo
             WHERE EXP.numero = Pcodexpediente;
      ELSE
         cerrado := '0';

         SELECT COUNT (*)
           INTO cont_res_prov
           FROM documento_resolutivo_prov d
          WHERE d.codigo_solicitud = cod_sol;

         IF cont_res_prov > 0
         THEN
            OPEN Reg FOR
               SELECT d.ucm_id Ucmid,
                      d.codigo_tipo_documento Codigo_Documento,
                      t.descripcion_documento,
                      d.indicador_obligatorio,
                      t.sub_tipo,
                      t.ruta_check_in,
                      TO_NUMBER (d.archivo_folio) Numfolios,
                      d.confidencial Confidencialidad,
                      d.codigo_documento AS cod_std_doc
                 /*,
                 (SELECT f.Nume_Regi_Arc
                    FROM Sys_Registro_Archivos_Fisico f
                   WHERE trim(f.numerodocumento_ucm) = trim(d.ucm_id)) Numeregiarc,
                 null*/
                 FROM documento_resolutivo_prov r,
                      documento_resolutivo_det_prov d,
                      documento t
                WHERE     r.codigo_doc_resolutivo_prov =
                             d.codigo_doc_resolutivo_prov
                      AND d.codigo_tipo_documento = t.codigo_documento
                      AND r.codigo_solicitud = cod_sol
               UNION
               SELECT r.Ucm_Id Ucmid,
                      '019' Codigo_Documento,
                      (SELECT d.Descripcion_Corta
                         FROM Documento d
                        WHERE d.Codigo_Documento = '019')
                         Descripcion_Documento,
                      'Y' Indicador_Obligatorio,
                      NULL Sub_Tipo,
                      NULL Ruta_Check_In,
                      1 Numfolios,
                      'N' Confidencialidad,
                      NULL /*,
  (SELECT max(s.Nume_Regi_Arc)
     FROM Sys_Registro_Archivos_Fisico s
    WHERE trim(s.Numerodocumento_Ucm) = trim(r.Ucm_Id)) Numeregiarc,
  --                 and s.filename like '' || Pcodexpediente || '%') Numeregiarc,

  NULL*/
                 FROM Recibo r
                WHERE r.codigo_solicitud = cod_sol -- JMROJAS 20/05/2015 -
                      AND r.estado IN ('ACTIVO', 'REGISTRADO')
               UNION
               SELECT a.ucmid,
                      a.codigo_documento,
                      a.descripcion_documento,
                      a.indicador_obligatorio,
                      a.Sub_Tipo,
                      a.ruta_check_in,
                      a.Numfolios,
                      a.Confidencialidad,
                      a.cod_std_doc
                 FROM (  SELECT adj.Ucm_Id AS Ucmid,
                                '' AS Codigo_Documento,
                                'CEV (XML) - ' || Pcodexpediente
                                   AS descripcion_documento,
                                'N' AS indicador_obligatorio,
                                'DOCUMENTO GENERICO' Sub_Tipo,
                                '' AS ruta_check_in,
                                1 AS Numfolios,
                                'N' AS Confidencialidad,
                                '' AS cod_std_doc
                           FROM vuce.documento d1
                                INNER JOIN vuce.documento d2
                                   ON     d1.doc_ref_tipo = d2.doc_tipo
                                      AND d1.doc_ref_numero = d2.doc_numero
                                INNER JOIN vuce.adjunto adj
                                   ON adj.id_documento = d2.id
                          WHERE     d1.doc_tipo = 'E'
                                AND d2.doc_tipo = 'DR'
                                AND d1.doc_numero = Pcodexpediente
                                AND (   adj.Nombre LIKE 'CFE%'
                                     OR adj.Nombre LIKE 'CEF%'
                                     OR adj.Nombre LIKE 'CEV%')
                       ORDER BY D2.AUD_FECHACREACION DESC) a
                WHERE ROWNUM = 1
               UNION
               -- MUESTRA LOS CEV ENVIADOS A HOLANDA Y  USA
               SELECT cer.iducm AS Ucmid,
                      '' AS Codigo_Documento,
                      'CEV (XML) -' || Pcodexpediente
                         AS descripcion_documento,
                      'N' AS indicador_obligatorio,
                      'DOCUMENTO GENERICO' Sub_Tipo,
                      '' AS ruta_check_in,
                      1 AS Numfolios,
                      'N' AS Confidencialidad,
                      '' AS cod_std_doc
                 FROM bpmtupa.bt_certificado cer
                      INNER JOIN bpmtupa.bt_expediente EXP
                         ON cer.idexpediente = EXP.codigo
                WHERE EXP.numero = Pcodexpediente;
         ELSE
            OPEN Reg FOR
               SELECT DISTINCT
                      DECODE (
                         d.Codigo_Documento,
                         '019', (SELECT r.Ucm_Id
                                   FROM Recibo r
                                  --                               WHERE r.Codigo_Expediente = Pcodexpediente),
                                  WHERE     r.codigo_solicitud = cod_sol
                                        -- JMROJAS 20/05/2015 -
                                        AND r.estado IN ('ACTIVO',
                                                         'REGISTRADO')),
                         NULL)
                         Ucmid,
                      d.Codigo_Documento,
                      d.Descripcion_Documento,
                      DECODE (Rs.Indicador_Obligatorio,
                              NULL, 'N',
                              Rs.Indicador_Obligatorio)
                         AS Indicador_Obligatorio,
                      d.Sub_Tipo,
                      d.Ruta_Check_In,
                      1 Numfolios,
                      'N' Confidencialidad,
                      NULL /*,
  Decode(d.Codigo_Documento,
         '019',
         (SELECT f.Nume_Regi_Arc
            FROM Recibo                       r,
                 Sys_Registro_Archivos_Fisico f
           WHERE trim(r.Ucm_Id) =
                 trim(f.Numerodocumento_Ucm)
             AND r.codigo_solicitud = cod_sol),
         NULL) Numeregiarc,
  NULL*/
                 FROM Requisito_Servicio Rs, Servicio_Tupa s, Documento d
                WHERE     Rs.Codigo_Servicio = s.Codigo_Servicio
                      AND d.Codigo_Documento = Rs.Codigo_Documento
                      AND s.Estado = 'ACTIVO'
                      AND d.Estado = 'ACTIVO'
                      AND s.Codigo_Servicio IN /*(SELECT DISTINCT e.Codigo_Servicio
                                                FROM Finalbpm.Expediente_Servicios e
                                               WHERE e.Codigo_Expediente = Pcodexpediente)*/
                          (SELECT DISTINCT e.Codigo_Servicio
                             FROM Finalbpm.Expediente_Servicios e
                            --               WHERE e.Codigo_Expediente = Pcodexpediente)
                            WHERE e.codigo_solicitud = cod_sol)
                      AND (   Rs.Indicador_Tupa = 'Y'
                           OR Rs.Indicador_Tupa IS NULL)
                      AND Rs.Indicador_Ing_Sal = 'S'
               UNION
               SELECT r.Ucm_Id Ucmid,
                      '019' Codigo_Documento,
                      (SELECT d.Descripcion_Corta
                         FROM Documento d
                        WHERE d.Codigo_Documento = '019')
                         Descripcion_Documento,
                      'Y' Indicador_Obligatorio,
                      NULL Sub_Tipo,
                      NULL Ruta_Check_In,
                      1 Numfolios,
                      'N' Confidencialidad,
                      NULL /*,
  (SELECT max(s.Nume_Regi_Arc)
     FROM Sys_Registro_Archivos_Fisico s
    WHERE trim(s.Numerodocumento_Ucm) = trim(r.Ucm_Id)) Numeregiarc,
  --                 and s.filename like '' || Pcodexpediente || '%') Numeregiarc,
  NULL*/
                 FROM Recibo r
                WHERE r.codigo_solicitud = cod_sol -- JMROJAS 20/05/2015 -
                      AND r.estado IN ('ACTIVO', 'REGISTRADO');
         /*         AND r.Codigo_Solicitud IN
         (SELECT t.Codigo_Solicitud
            FROM Solicitud t
           WHERE t.Codigo_Doc_Resolutivo IS NULL);*/
         END IF;
      END IF;
   END Sp_Requsitos_Doc_Salida;

   PROCEDURE Sp_Obtener_Requsitos_Propios (
      p_Cod_Servicio   IN     VARCHAR2,
      Reg                 OUT SYS_REFCURSOR)
   IS
   BEGIN
      OPEN Reg FOR
           SELECT Rs.Codigo_Servicio,
                  s.Descripcion_Servicio,
                  d.Codigo_Documento,
                  d.Descripcion_Documento,
                  Rs.Indicador_Obligatorio,
                  d.Indicador_Req_Predio,
                  d.Sub_Tipo,
                  d.Ruta_Check_In
             FROM Requisito_Servicio Rs, Servicio_Tupa s, Documento d
            WHERE     Rs.Codigo_Servicio = s.Codigo_Servicio
                  AND d.Codigo_Documento = Rs.Codigo_Documento
                  AND s.Estado = 'ACTIVO'
                  AND d.Estado = 'ACTIVO'
                  AND s.Codigo_Servicio = p_Cod_Servicio
                  AND Rs.Indicador_Req_Propio = 'Y'
         ORDER BY s.Descripcion_Servicio, Rs.Indicador_Obligatorio;
   END Sp_Obtener_Requsitos_Propios;

   PROCEDURE Sp_Servicios_Por_Clase (p_Cod_Clase   IN     VARCHAR2,
                                     Reg              OUT SYS_REFCURSOR)
   IS
   BEGIN
      OPEN Reg FOR
           SELECT s.Codigo_Servicio,
                  s.Descripcion_Servicio,
                  s.Indicador_Cobro_Por_Producto,
                  s.Indicador_Servicio_Secundario,
                  s.Codigo_Clase
             FROM Servicio_Tupa s
            WHERE s.Estado = 'ACTIVO' AND s.Codigo_Clase = p_Cod_Clase
         ORDER BY s.Descripcion_Servicio;
   END Sp_Servicios_Por_Clase;

   FUNCTION Fn_Cantidad_Inspecciones (p_Cod_Expediente   IN VARCHAR2,
                                      p_Cod_Servicio     IN VARCHAR2)
      RETURN NUMBER
   IS
      Cant   NUMBER;
   BEGIN
      Cant := 0;

      SELECT COUNT (*)
        INTO Cant
        FROM Informe_Inspeccion_Verificacio
       WHERE     Codigo_Expediente = p_Cod_Expediente
             AND Codigo_Servicio = p_Cod_Servicio;

      RETURN Cant;
   END Fn_Cantidad_Inspecciones;

   FUNCTION Fn_Tipo_Servicio (p_Cod_Expediente   IN VARCHAR2,
                              p_Cod_Servicio     IN VARCHAR2)
      RETURN NUMBER
   IS
      Tipo   NUMBER;
   BEGIN
      SELECT s.Codigo_Tipo_Servicio
        INTO Tipo
        FROM Servicio_Tupa s
       WHERE s.Codigo_Servicio = p_Cod_Servicio;

      RETURN Tipo;
   END Fn_Tipo_Servicio;
END Pckg_Servicio;
/


CREATE OR REPLACE PUBLIC SYNONYM PCKG_SERVICIO FOR FINALBPM.PCKG_SERVICIO;


GRANT EXECUTE, DEBUG ON FINALBPM.PCKG_SERVICIO TO R_FINALBPM;

GRANT EXECUTE ON FINALBPM.PCKG_SERVICIO TO R_FINALBPM_RO;

GRANT EXECUTE ON FINALBPM.PCKG_SERVICIO TO VUCE;
