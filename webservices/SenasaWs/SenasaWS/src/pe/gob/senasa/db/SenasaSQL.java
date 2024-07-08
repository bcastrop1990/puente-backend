package pe.gob.senasa.db;


public class SenasaSQL {
    
	public static final String DATA_SOURCE_INSPEC_VERIF = "pruebaDS";
    public static final String DATA_SOURCE_INSPECTOR = "pruebaDS";
    public static final String DATA_SOURCE_PAGOS = "pruebaDS";
    public static final String DATA_SOURCE_PERMFITOEXPO = "pruebaDS";
    public static final String DATA_SOURCE_PERMFITOIMPO = "pruebaDS";
    public static final String DATA_SOURCE_PERMZOOIMPO = "pruebaDS";
    public static final String DATA_SOURCE_PRODUCTO = "pruebaDS";
    public static final String dsAgenteAduana = "pruebaDS";
    public static final String dsAnalisisUCDSV = "pruebaDS";
    public static final String dsLugarProd = "pruebaDS";
    public static final String dsCertPlantas = "pruebaDS";
    public static final String dsDirectorio = "pruebaDS";
    public static final String dsDocumentos = "pruebaDS";
    public static final String dsExpoZoo = "pruebaDS";
    public static final String dsFuncionario = "pruebaDS";
    public static final String dsGeneral = "pruebaDS";
    public static final String dsGeografia = "pruebaDS";
    public static final String dsInspeccion = "pruebaDS";
    
    public static final String dsRegistroCPE = "pruebaDS";
    public static final String dsReqDoc = "pruebaDS";
    public static final String dsServicioTUPA = "pruebaDS";
    public static final String dsSolicitante = "pruebaDS";
    public static final String dsTramDocu = "pruebaDS";
    public static final String dsTratamiento = "pruebaDS";
    public static final String dsVerificaCierre = "pruebaDS";

    public static final String OBTENER_ADJUNTOS_VUCE =
        "call Pckg_General.Sp_Obtener_Adjuntos_Vuce(?,?)";

    /////////////////////////////////////////////////////////////////////////////////////
    ////        Solicitud UCDSV /////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////


    public static final String CONSULTAR_FIRMANTE =
        "select ssf.nomencla,ssf.lugar,xp.usuario from  servicio_sede_firma ssf,xpersonas xp\n" +
        " where ssf.persona_id=xp.persona_id \n" +
        " and ssf.codigo_centro_tramite=? \n" +
        " and ssf.codigo_servicio=? ";


    public static final String CONSULTAR_CENTRO_TRAMITE =
        " select codigo_centro_tramite,descripcion_centro_tramite,direccion_centro_tramite from centro_tramite where codigo_centro_tramite = ? ";

    public static final String OBTENER_PREFIJO_CENTRO_TRAMITE =
        " select prefijo_recibo from centro_tramite where codigo_centro_tramite = ? ";

    public static final String CREAR_SOLICITUD_UCDSV =
        "{ call sigsve.pkg_bpm_solicitud_ucdsv.bpm_crea_solicitud_ucdsv (?,?) }";
    public static final String CREAR_DETALLE_SOLICITUD_UCDSV =
        "{ call sigsve.pkg_bpm_solicitud_ucdsv.bpm_detalle_solicitud_ucdsv (?,?) }";
    public static final String GENERAR_SOLICITUD_UCDSV =
        "{ call sigsve.pkg_bpm_solicitud_ucdsv.bpm_genera_solicitud_ucdsv (?) }";

    public static final String OBTENER_RESULTADO_SOLICITUD_UCDSV =
        "{ call sigsve.pkg_bpm_solicitud_ucdsv.bpm_resultado_solicitud_ucdsv (?,?,?) }";

    public static final String OBTENER_CENTRO_TRAMITES_POR_PRODUCTO =
        " select t.codigo_centro_tramite,c.descripcion_centro_tramite from producto_sede t," +
        " centro_tramite c\n" +
        " where t.codigo_centro_tramite=c.codigo_centro_tramite \n" +
        " and t.codigo_producto=? and t.codi_pais_tpa=? and t.codigo_lugar_produccion=?\n" +
        " and t.estado='ACTIVO'";

    public static final String OBTENER_CANT_RECIBOS_X_PREFIJO =
        " select count(*) from recibo where codigo_centro_tramite = ? and prefijo = ?";

    /////////////////////////////////////////////////////////////////////////////////////
    ////        agencia de aduanas /////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String OBTENER_AGENCIA_ADUANA_X_RUC =
        "select " + "  per.ruc, per.nombre_razon_social, per.direccion" +
        ", per.nombres, per.apellido_paterno, per.apellido_materno" +
        ", p.cdesprov provincia, depa.cdesprov departamento, d.cdesdist distrito" +
        ", per.telefono, per.telefono_movil, aa.persona_id " +
        ", per.correo_electronico " +
        "  from agencia_aduanas aa inner join persona per on aa.persona_id = per.persona_id " +
        "      left join departamento depa on  per.departamento_id = depa.ccoddep " +
        "      left join provincias p      on (per.departamento_id = p.ccoddep and per.provincia_id = p.ccodprov) " +
        "      left join distritos d        on (per.departamento_id = d.ccoddep and per.provincia_id = d.ccodprov and per.distrito_id = d.ccoddist) " +
        "  where per.ruc =  ?";

    public static final String OBTENER_AGENCIA_ADUANA_X_IDPERSONA =
        "select " + "  per.ruc, per.nombre_razon_social, per.direccion" +
        ", per.nombres, per.apellido_paterno, per.apellido_materno" +
        ", p.cdesprov provincia, depa.cdesprov departamento, d.cdesdist distrito" +
        ", per.telefono, per.telefono_movil, aa.persona_id " +
        ", per.correo_electronico " +
        "  from agencia_aduanas aa inner join persona per on aa.persona_id = per.persona_id " +
        "      left join departamento depa on  per.departamento_id = depa.ccoddep " +
        "      left join provincias p      on (per.departamento_id = p.ccoddep and per.provincia_id = p.ccodprov) " +
        "      left join distritos d        on (per.departamento_id = d.ccoddep and per.provincia_id = d.ccodprov and per.distrito_id = d.ccoddist) " +
        "  where aa.persona_id =  ?";


    /////////////////////////////////////////////////////////////////////////////////////
    ////        TramiteDocumentarioDAO /////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////


    public static final String OBTENER_IMPRESORA_X_SEDE =
        "select ct.impresora_ticket from centro_tramite ct where ct.codigo_centro_tramite = ? and ct.estado='ACTIVO' ";

    /////////////////////////////////////////////////////////////////////////////////////
    ////        GEOGRAFIA /////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String OBTENER_PUERTOS =
        "select p.codigo_puerto,p.codi_pais_tpa,p.descripcion_puerto from puerto p order by p.descripcion_puerto";

    public static final String OBTENER_DEPARTAMENTOS_SQL =
        "select td.codi_depa_dpt,td.nomb_dpto_dpt from tdepartamentos td order by td.nomb_dpto_dpt";

    public static final String OBTENER_PROVINCIAS_X_DEP_SQL =
        "select tpro.codi_prov_tpr,tpro.nomb_prov_tpr from tprovincias tpro where tpro.codi_depa_dpt = ? order by tpro.nomb_prov_tpr ";

    public static final String OBTENER_PROVINCIAS_SQL =
        "select tpro.codi_prov_tpr,tpro.nomb_prov_tpr from tprovincias tpro order by tpro.nomb_prov_tpr";

    public static final String OBTENER_DISTRITOS_X_PROV_SQL =
        " select dist.codi_dist_tdi,dist.nomb_dist_tdi from tdistritos dist " +
        " where dist.codi_depa_dpt = ? and dist.codi_prov_tpr = ?  order by dist.nomb_dist_tdi ";

    public static final String OBTENER_DISTRITOS_SQL =
        "select dist.codi_dist_tdi,dist.nomb_dist_tdi from tdistritos dist order by dist.nomb_dist_tdi ";

    public static final String OBTENER_PAIS =
        "select tp.codi_pais_tpa,tp.nomb_pais_tpa from tpaises tp order by tp.nomb_pais_tpa ";
    public static final String OBTENER_PAIS_GERMP_CPE =
        "{ call Pckg_Registros.Sp_Obtener_Paises_CPE_Germo(?,?,?) } ";


    public static final String OBTENER_LUGARES_PRODUCCION =
        " select lp.codigo_lugar_produccion,lp.descripcion_lugar_produccion " +
        " from lugar_produccion lp " + " where codi_pais_tpa = ? " +
        " order by lp.descripcion_lugar_produccion";

    /////////////////////////////////////////////////////////////////////////////////////
    ////       TRATAMIENTO /////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////


    public static final String OBTENER_PLAGAS =
        "select ce.codigo_especie,ce.nombre_cientifico from catalogo_especie ce inner join catalogo_especie_clasificacion cec on ce.codigo_especie=cec.codigo_especie";
    public static final String OBTENER_EMPRESAS_FUMIGADORAS =
        "select e.persona_id,p.nombre_razon_social from empresa_fumigadora e inner join persona p on e.persona_id=p.persona_id";
    public static final String OBTENER_TRATAMIENTOS =
        "select t.codigo_tratamiento,tt.descripcion_tipo_tratamiento,t.descripcion_tratamiento from tratamiento t inner join tipo_tratamiento tt on t.codigo_tipo_tratamiento = tt.codigo_tipo_tratamiento";

    public static final String OBTENER_MOTIVOS_TRATAMIENTO =
        "select  v.codigo_motivo,v.descripcion_motivo,v.uso from motivo v where v.uso='TRATAMIENTO'";

    public static final String OBTENER_TIPOS_TRATAMIENTOS_X_CLASE =
        "call pckg_tratamiento.sp_obtener_tipos(?,?)";

    public static final String OBTENER_AREAS_LABORATORIO =
        "call Pckg_General.Sp_Lista_Area_Laboratorio(?,?)";

    public static final String OBTENER_TIPO_MUESTRA_ANIMAL =
        "call Pckg_General.sp_lista_tipo_muestra_animal(?,?)";

    public static final String OBTENER_TIPO_MUESTRA_VEGETAL =
        "call Pckg_General.sp_lista_tipo_muestra_vegetal(?)";

    public static final String OBTENER_LIST_PROC_ORIGEN_MUESTRA =
        "call pckg_general.sp_lista_proc_origen_muestra(?)";

    public static final String OBTENER_SERVICIO_ANALISIS_VEGETAL =
        "call Pckg_General.Sp_Lista_Serv_Analisis_Vegetal(?,?)";

    public static final String OBTENER_SERVICIO_ANALISIS_ANIMAL =
        "call Pckg_General.sp_lista_serv_analisis_animal(?,?)";

    public static final String OBTENER_LIST_TIPO_ESPC_ANIMAL =
        "call Pckg_General.sp_lista_tipo_especie_animal(?)";

    public static final String OBTENER_LIST_MOTIVO =
        "call pckg_general.sp_lista_motivo(?)";

    public static final String OBTENER_LIST_SEXO =
        "call pckg_general.Sp_Lista_Sexo(?)";

    public static final String OBTENER_LIST_TIPO_IDENTF_ANIMAL =
        "call pckg_general.Sp_Lista_Tipo_Identificacion(?)";

    public static final String OBTENER_LIST_TIPO_RECHAZO =
        "call pckg_general.Sp_Lista_Dictamen(?,?)";

    public static final String OBTENER_LIST_RAZA =
        "call pckg_general.Sp_Lista_Raza(?,?)";

    public static final String OBTENER_LIST_TIPO_CRIANZA =
        "call pckg_general.Sp_Lista_Tipo_Crianza(?)";

    public static final String OBTENER_LIST_UNIDAD_MEDIDA =
        "call pckg_general.Sp_Lista_Unidad_Medida(?)";

    public static final String OBTENER__TRATAMIENTOS_X_CLASE_TIPO =
        "call pckg_tratamiento.Sp_Obtener(?,?,?)";

    public static final String OBTENER__LIST_PLAGA_TRATAMIENTO =
        "call pckg_general.sp_lista_plaga_tratamiento(?,?,?)";

    public static final String OBTENER__LIST_MOTIVO_TRATAMIENTO =
        "call pckg_general.sp_lista_motivo_tratamiento(?)";

    public static final String OBTENER__EMPRESA_FUMIGADORA =
        "call pckg_general.Sp_Obtener_Empresa_Tratamiento(?,?)";

    ///////////////////////////////////////////////////////////////////////////////////////
    ////  INSPECCION TRATAMIENTO /////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    public static final String INSERTAR_INSPECCION_TRATAMIENTO =
        "call Pckg_Expediente_Tratamiento.Sp_Insertar(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String ACTUALIZAR_INSPECCION_TRATAMIENTO =
        "call pckg_general.Sp_Obtener_Empresa_Tratamiento(?,?)";

    public static final String OBTENER_INSPECCION_TRATAMIENTO =
        "call Pckg_Expediente_Tratamiento.Sp_Consultar(?,?,?)";

    ///////////////////////////////////////////////////////////////////////////////////////
    ////  INSPECCION /////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    public static final String REGISTRAR_INSPECCION =
        "call pckg_inspeccion.sp_insertar_inspeccion(?,?,?,?,?)";

    public static final String ACTUALIZAR_PRODUCTO_INSPECCION =
        "call pckg_Inspeccion.sp_Actualizar_Producto_Insp(?,?,?,?,?)";

    public static final String INSERTAR_LOTE =
        "call pckg_Inspeccion.sp_Insertar_Lote(?,?,?,?,?,?,?,?,?)";

    public static final String ACTUALIZAR_LOTE =
        "call pckg_Inspeccion.sp_Actualizar_Lote(?,?,?,?,?)";

    public static final String CONSULTAR_LOTE =
        "call pckg_inspeccion.sp_consultar_lote(?,?)";

    public static final String INSERTAR_CONCEPTO =
        "call pckg_Inspeccion.sp_Insertar_Concepto(?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String ACTUALIZAR_CONCEPTO =
        "call pckg_Inspeccion.sp_Actualizar_Concepto(?,?,?,?,?,?)";

    public static final String CONSULTAR_CONCEPTO =
        "call pckg_inspeccion.sp_consultar_concepto(?,?)";


    /////////////////////////////////////////////////////////////////
    /////// ANALISIS DE LABORATORIO
    /////////////////////////////////////////////////////////////////

    public static final String SOLICITUD_ANALISIS_LAB_ANIMAL =
        "call sigsve.pkg_bpm.bpm_genera_solicitud_ucdsa(?,?,?)";

    public static final String RESPUESTA_ANALISIS_LAB_ANIMAL =
        "call sigsve.pkg_bpm.bpm_resultado_solicitud_ucdsa(?,?,?,?,?)";

    public static final String SOLICITUD_ANALISIS_LAB_VEGETAL =
        "call sigsve.pkg_bpm.bpm_genera_solicitud_ucdsv(?,?,?)";

    public static final String RESPUESTA_ANALISIS_LAB_VEGETAL =
        "call sigsve.pkg_bpm.bpm_resultado_solicitud_ucdsv(?,?,?,?,?)";

    /////////////////////////////////////////////////////////////////////////////////////
    ////       PRODUCTO ////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String OBTENER_SEDES =
        " select ct.codigo_centro_tramite,ct.descripcion_centro_tramite , tct.nombre_tipo_centro_tramite " +
        " from centro_tramite ct inner join tipo_centro_tramite tct on ct.codigo_tipo_centro_tramite = tct.codigo_tipo_centro_tramite " +
        " where tct.codigo_tipo_centro_tramite = '01' or tct.codigo_tipo_centro_tramite = '02' and ct.estado = 'ACTIVO' " +
        " order by ct.descripcion_centro_tramite ";
    /*
    public static final String OBTENER_SEDES =
      " select ct.codigo_centro_tramite,ct.descripcion_centro_tramite , tct.nombre_tipo_centro_tramite " +
      " from centro_tramite ct inner join tipo_centro_tramite tct on ct.codigo_tipo_centro_tramite = tct.codigo_tipo_centro_tramite " +
      " where ct.estado = 'ACTIVO' " +
      " order by ct.descripcion_centro_tramite ";
   */
    public static final String OBTENER_PUESTOS_DE_CONTROL =
        " select ct.codigo_centro_tramite,ct.descripcion_centro_tramite , tct.nombre_tipo_centro_tramite, ct.codigo_medio_transporte" +
        " from centro_tramite ct inner join tipo_centro_tramite tct on ct.codigo_tipo_centro_tramite = tct.codigo_tipo_centro_tramite " +
        " where tct.codigo_tipo_centro_tramite = '03' and ct.estado='ACTIVO' " +
        " order by ct.descripcion_centro_tramite ";

    public static final String VALIDAR_GERMOPLASMA_PRODUCTO =
        "select count(p.codigo_producto) from producto p where p.codigo_producto = ? and  p.indicador_cuarentena  is not null and p.codigo_crf in ('03','04','05')";

    public static final String VALIDAR_REGISTROCPE =
        "select count(rp.codigo_producto) from requ_sani_importacion_producto rp where rp.codigo_producto = ? and rp.indicador_cpe is not null";

    public static final String VALIDAR_MUESTRA =
        "select count(p.codigo_producto) from producto p where   p.codigo_producto = ? AND ?  <= p.cantidad_muestra";

    public static final String OBTENER_ANIMALES_VIVOS =
        "select av.codigo_animal,av.desc_animal from animales_vivos av";

    public static final String OBTENER_ANEXO =
        "select p.codigo_producto , p.nombre_comercial_producto, p.nombre_cientifico_producto, p.codigo_clase, p.codigo_crf ,\n" +
        "partaran.partida_arancelaria , 0 as tiene_anexos, \n" +
        "p1.codigo_producto as codigo_padre , p1.nombre_comercial_producto as desc_padre, \n" +
        "p1.nombre_cientifico_producto as nombre_tec_padre, partaran1.partida_arancelaria as partida_aran_padre \n" +
        "from producto p inner join producto_grupo pg1 on pg1.codigo_producto_hijo = p.codigo_producto \n" +
        "inner join partida_arancelaria partaran on p.codigo_partida_arancelaria = partaran.codigo_partida_arancelaria \n" +
        "inner join producto p1 on p1.codigo_producto = pg1.codigo_producto_padre \n" +
        "inner join partida_arancelaria partaran1 on p1.codigo_partida_arancelaria = partaran1.codigo_partida_arancelaria  \n" +
        "where p.codigo_producto = ?";

    public static final String OBTENER_USODESTINO =
        "select  ap.codigo_aplicacion , ap.descripcion_aplicacion from aplicacion_uso ap where ap.codigo_clase = ? order by ap.descripcion_aplicacion ";

    public static final String OBTENER_MEDIOS_TRANSPORTE =
        "select mt.codigo_medio_transporte, mt.descripcion_medio_transporte from medio_transporte mt order by  mt.descripcion_medio_transporte";

    public static final String OBTENER_UNIDAD_MEDIDA =
        "select codi_unid_med, desc_unid_med from unidad_medida where ccodcla=? order by desc_unid_med";

    public static final String OBTENER_UNIDAD_MEDIDA_XPROD =
        "call Pckg_General.Sp_Lista_Unid_Med_Producto(?,?)";


    public static final String OBTENER_LIST_UNID_TIEMPO =
        "select codi_unid_med, desc_unid_med from unidad_medida where ccodcla=? order by desc_unid_med";

    public static final String OBTENER_LUGAR_INSPECCION =
        "select li.codigo_lugar_inspeccion,li.nombre_lugar_inspeccion from lugar_inspeccion li where li.estado='ACTIVO' order by li.nombre_lugar_inspeccion ";

    public static final String OBTENER_ANEXOS_X_PADRE =
        "select  p.codigo_producto , p.nombre_comercial_producto, p.nombre_cientifico_producto, p.codigo_clase, p.codigo_crf , par.partida_arancelaria ,'' as tiene_anexos, p.indicador_cuarentena,p.indicador_germoplasma,p.indicador_guardacustodia \n" +
        "from producto p left join partida_arancelaria par on par.codigo_partida_arancelaria = p.codigo_partida_arancelaria\n" +
        "left join producto_grupo p1 on p.codigo_producto = p1.codigo_producto_hijo \n" +
        "where p1.codigo_producto_padre = ? ";

    public static final String OBTENER_TIPO_ENVASE =
        "select te.codigo_tipo_envase, te.descripcion_tipo_envase from tipo_envase te \n" +
        "where te.codigo_clase = ? " + " order by te.descripcion_tipo_envase ";


    public static final String OBTENER_PRODUCTO_ARRIBA =
        "select p.codigo_producto , p.nombre_comercial_producto, p.nombre_cientifico_producto, p.codigo_clase, p.codigo_crf, par.partida_arancelaria , count(p1.codigo_producto_padre) as tiene_anexos, p.indicador_cuarentena,p.indicador_germoplasma,p.indicador_guardacustodia \n" +
        "from producto p \n" +
        "left join producto_grupo p1 on p.codigo_producto = p1.codigo_producto_padre \n" +
        "left join partida_arancelaria par on p.codigo_partida_arancelaria = par.codigo_partida_arancelaria";
    public static final String WHERE_X_CODIGO_PRODUCTO =
        "where p.codigo_producto = ?";
    public static final String OBTENER_PRODUCTO_ABAJO =
        " group by p.codigo_producto, p.nombre_comercial_producto, p.nombre_cientifico_producto, p.codigo_clase, p.codigo_crf, par.partida_arancelaria, p.indicador_cuarentena,p.indicador_germoplasma,p.indicador_guardacustodia \n" +
        " order by p.nombre_comercial_producto ";
    public static final String OBTENER_REQUISITOS_SANITARIOS_IMPO_FITO_2 =
        "SELECT\n" +
        "rsep.CODIGO_PRODUCTO,\n" +
        "rsep.CODIGO_APLICACION,\n" +
        "rsep.CODIGO_REQUISITO_SANITARIO,\n" +
        "rsep.CODIGO_TRATAMIENTO,\n" +
        "rsep.CODIGO_ESPECIE_ENFERMEDAD,\n" +
        "rsep.CODIGO_REQU_IMPO_PRODUCTO,\n" +
        "rs.DESCRIPCION_REQUISITO_SANITARI\n" +
        "FROM\n" +
        "REQU_SANI_IMPORTACION_PRODUCTO rsep\n" +
        "left join requisitos_sanitarios rs on rsep.CODIGO_REQUISITO_SANITARIO=rs.CODIGO_REQUISITO_SANITARIO\n" +
        "where codigo_producto =?";

    /*
    public static final String OBTENER_REQUISITOS_SANITARIOS_IMPO_FITO = "select rs.descripcion_requisito_sanitari " +
      " from requ_sani_importacion_producto rsep " +
      " left join requisitos_sanitarios rs on rsep.codigo_requisito_sanitario=rs.codigo_requisito_sanitario" +
      " where codigo_producto = ? ";
    */

    public static final String OBTENER_REQUISITOS_SANITARIOS_IMPO_FITO =
        "  \n" +
        "   select  req.codigo_requ_impo_producto \n" +
        "  , req.codigo_tratamiento, t.descripcion_tratamiento\n" +
        "  , req.codigo_requisito_sanitario, s.descripcion_requisito_sanitari\n" +
        "  , req.codigo_especie_enfermedad, e.desc_espe_esp\n" +
        "  from \n" +
        "  requ_sani_importacion_producto req \n" +
        "  left join tratamiento t on req.codigo_tratamiento = t.codigo_tratamiento\n" +
        "  left join requisitos_sanitarios s on req.codigo_requisito_sanitario = s.codigo_requisito_sanitario\n" +
        "  left join catalogo_especie e on req.codigo_especie_enfermedad = e.codigo_especie\n";
    //    "  , requ_sani_impo_pais_origen pais\n" +
    //    "  where req.codigo_requ_impo_producto = pais.codigo_requ_impo_producto\n" +
    //    "  and pais.codi_pais_tpa_origen = ?       \n" +
    //    "  and pais.codigo_lugar_produccion = ?    \n" ;

    public static final String OBTENER_REQUISITOS_SANITARIOS_IMPO_FITO_WHERE =
        "  \n" +
        "      req.codigo_producto = ?             \n" +
        "  and req.codigo_aplicacion = ?           \n" +
        "  and req.codi_pais_tpa_procedencia = ?   \n";


    /////////////////////////////////////////////////////////////////////////////////////
    ////       RequisitosDocumentalesDAO ///////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String OBTENER_REQUISITOS_DOCUMENTALES =
        "select doc.codigo_documento,doc.descripcion_documento,doc.sub_tipo,doc.ruta_check_in,rs.indicador_obligatorio,rs.indicador_vuce from requisito_servicio rs \n" +
        " inner join documento doc on doc.codigo_documento = rs.codigo_documento \n" +
        " where rs.codigo_servicio = ?";

    /////////////////////////////////////////////////////////////////////////////////////
    ////       SolicitanteDAO ///////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    public static final String OBTENER_IMPORTADORES_X_PAIS =
        "select * from importadores where estado='ACTIVO' and codi_pais_tpa = ? order by nombre_importador asc";

    /*
    public static final String OBTENER_SOLICITANTE_X_NUMERO_CERTIFICADO = "  select per.persona_id, per.documento_numero\n" +
    "       , per.documento_tipo, per.nombre_razon_social, per.direccion\n" +
    "       , per.telefono, per.telefono_movil, per.correo_electronico\n" +
    "       , per.departamento_id, per.provincia_id, per.distrito_id\n" +
    "       , per.estado, rep.apellido_materno, rep.apellido_paterno, rep.nombres, rep.documento_numero dniRepLegal\n" +
    "       , senasa.f_departamentos(per.departamento_id) departamento_nombre\n" +
    "       , senasa.f_provincias(per.departamento_id,per.provincia_id) provincia_nombre\n" +
    "       , senasa.f_distritos(per.departamento_id,per.provincia_id,per.distrito_id) distrito_nombre\n" +
    "       from persona per left join persona_representante_legal prl on per.persona_id = prl.persona_id \n" +
    "       left join persona rep on prl.representante_id = rep.persona_id\n" +
    "       left join permiso_pfi pfi on per.persona_id = pfi.persona_id\n" +
    "       where  pfi.numero_permiso = ?";*/

    public static final String OBTENER_SOLICITANTE_X_NUMERO_CERTIFICADO =
        "  select per.persona_id,per.persona_tipo, per.documento_numero\n" +
        "       , per.documento_tipo, per.nombre_razon_social, per.direccion\n" +
        "       , per.telefono, per.telefono_movil, per.correo_electronico\n" +
        "       , per.departamento_id, per.provincia_id, per.distrito_id\n" +
        "       , per.estado, rep.apellido_materno, rep.apellido_paterno, rep.nombres, rep.documento_numero dniRepLegal\n" +
        "       , senasa.f_departamentos(per.departamento_id) departamento_nombre\n" +
        "       , senasa.f_provincias(per.departamento_id,per.provincia_id) provincia_nombre\n" +
        "       , senasa.f_distritos(per.departamento_id,per.provincia_id,per.distrito_id) distrito_nombre\n" +
        "   from permiso_pfi pfi\n" +
        "   inner join persona per on pfi.persona_id=per.persona_id\n" +
        " left join persona_representante_legal prl on pfi.representante_id=prl.representante_id\n" +
        " left join persona rep on rep.persona_id = prl.persona_id\n" +
        "       where  pfi.numero_permiso = ?";
    
  public static final String OBTENER_SOLICITANTE_X_NUMERO_CERTIFICADOII =
      "select per.persona_id,per.persona_tipo, per.documento_numero\n" + 
      ", per.documento_tipo, per.nombre_razon_social, per.direccion\n" + 
      ", per.telefono, per.telefono_movil, per.correo_electronico\n" + 
      ", per.departamento_id, per.provincia_id, per.distrito_id\n" + 
      ", per.estado, rep.apellido_materno, rep.apellido_paterno, rep.nombres, rep.documento_numero dniRepLegal\n" + 
      ", senasa.f_departamentos(per.departamento_id) departamento_nombre\n" + 
      ", senasa.f_provincias(per.departamento_id,per.provincia_id) provincia_nombre\n" + 
      ", senasa.f_distritos(per.departamento_id,per.provincia_id,per.distrito_id) distrito_nombr\n" + 
      "from permiso_pfti pfi\n" + 
      "inner join persona per on pfi.persona_id=per.persona_id\n" + 
      "left join persona rep on rep.persona_id = pfi.agente_id\n" + 
      "where  pfi.numero_permiso =?";
    
    

    /*public static final String OBTENER_SOLICITANTE_X_NUMERO_CERTIFICADO_PZI = "  select per.persona_id, per.documento_numero\n" +
  "       , per.documento_tipo, per.nombre_razon_social, per.direccion\n" +
  "       , per.telefono, per.telefono_movil, per.correo_electronico\n" +
  "       , per.departamento_id, per.provincia_id, per.distrito_id\n" +
  "       , per.estado, rep.apellido_materno, rep.apellido_paterno, rep.nombres, rep.documento_numero dniRepLegal\n" +
  "       , senasa.f_departamentos(per.departamento_id) departamento_nombre\n" +
  "       , senasa.f_provincias(per.departamento_id,per.provincia_id) provincia_nombre\n" +
  "       , senasa.f_distritos(per.departamento_id,per.provincia_id,per.distrito_id) distrito_nombre\n" +
  "       from persona per left join persona_representante_legal prl on per.persona_id = prl.persona_id \n" +
  "       left join persona rep on prl.representante_id = rep.persona_id\n" +
  "       left join permiso_pzi pfi on per.persona_id = pfi.persona_id\n" +
  "       where  pfi.numero_permiso = ?";*/

    public static final String OBTENER_SOLICITANTE_X_NUMERO_CERTIFICADO_PZI =
        "  select per.persona_id,per.persona_tipo, per.documento_numero\n" +
        "       , per.documento_tipo, per.nombre_razon_social, per.direccion\n" +
        "       , per.telefono, per.telefono_movil, per.correo_electronico\n" +
        "       , per.departamento_id, per.provincia_id, per.distrito_id\n" +
        "       , per.estado, rep.apellido_materno, rep.apellido_paterno, rep.nombres, rep.documento_numero dniRepLegal\n" +
        "       , senasa.f_departamentos(per.departamento_id) departamento_nombre\n" +
        "       , senasa.f_provincias(per.departamento_id,per.provincia_id) provincia_nombre\n" +
        "       , senasa.f_distritos(per.departamento_id,per.provincia_id,per.distrito_id) distrito_nombre\n" +
        "       from permiso_pzi pzi\n" +
        " inner join persona per on pzi.persona_id=per.persona_id\n" +
        " left join persona_representante_legal prl on pzi.representante_id=prl.representante_id\n" +
        " left join persona rep on rep.persona_id = prl.persona_id\n" +
        "       where  pzi.numero_permiso = ?";


    public static final String OBTENER_PREDIOS_X_NUM_DOC_SOLICITANTE =
        "select cd1.nombre_predio , cd1.secuencial from persona p \n" +
        "inner join expediente ex on ex.persona_id = p.persona_id\n" +
        "inner join registro_cpe_fito recpe on  recpe.codigo_expediente = ex.codigo_expediente\n" +
        "inner join registro_cpe_fito_predio cd1 on recpe.codigo_cpe = cd1.codigo_cpe\n" +
        "where p.documento_numero = ?";

    public static final String VALIDAR_ALMACENGUARDACUSTODIA =
        "select count(p.persona_id) from persona p \n" +
        "inner join registro_guardacustodia gc on p.persona_id = gc.persona_id \n" +
        "where p.documento_numero = ? and gc.codigo_expediente = ?";

    public static final String VALIDAR_REGISTRO_CPE =
        "select count(p.persona_id) from persona p \n" +
        "inner join expediente ex on p.persona_id = ex.persona_id \n" +
        "inner join registro_cpe_fito cd on cd.codigo_expediente = ex.codigo_expediente \n" +
        "where p.documento_numero = ? and ex.codigo_expediente = ?";

    public static final String VALIDAR_GERMOPLASMA_PERSONA =
        "select count(per.persona_id) from persona per \n" +
        "inner join expediente ex on ex.persona_id = per.persona_id \n" +
        "inner join registro_germoplasma reger on reger.codigo_expediente = ex.codigo_expediente \n" +
        "where per.documento_numero = ? and ex.codigo_expediente = ?";

    public static final String OBTENER_TIPOS_DOCUMENTOS =
        "select tdi.tipo_docu_ide,tdi.nomb_docu_ide,tdi.long_docu_ide from tipos_documentos_identidad tdi";

    public static final String OBTENER_TIPOS_FILTRO_PERSONA =
        "call Pckg_General.Sp_Filtros_Buscar_Persona(?)";

    public static final String OBTENER_SOLICITANTES_FILTRADOS =
        "call Pckg_General.Sp_Buscar_Persona(?,?,?)";

    public static final String OBTENER_SOLICITANTE = "select \n" +
        "      per.persona_id, per.persona_tipo, per.documento_numero\n" +
        "    , per.documento_tipo, per.nombre_razon_social, per.direccion\n" +
        "    , per.telefono, per.telefono_movil, per.correo_electronico\n" +
        "    , per.departamento_id, per.provincia_id, per.distrito_id\n" +
        "    , Nvl(per.Estado_Juridico, per.Estado_Natural) estado, rep.apellido_materno, rep.apellido_paterno, rep.nombres, rep.documento_numero dniRepLegal\n" +
        "    , Dep.Nomb_Dpto_Dpt departamento_nombre\n" +
        "    , Pro.Nomb_Prov_Tpr provincia_nombre\n" +
        "    , Dis.Nomb_Dist_Tdi distrito_nombre\n" +
        "    from persona per left join persona_representante_legal prl on per.persona_id = prl.persona_id \n" +
        "    left join persona rep on prl.representante_id = rep.persona_id \n" +
        "     LEFT JOIN Tdepartamentos Dep \n" +
        "  ON (Dep.Codi_Depa_Dpt = per.Departamento_Id) \n" +
        "   LEFT JOIN Tprovincias Pro \n" +
        "  ON (Pro.Codi_Depa_Dpt = per.Departamento_Id AND Pro.Codi_Prov_Tpr = per.Provincia_Id) \n" +
        "   LEFT JOIN Tdistritos Dis \n" +
        "  ON (Dis.Codi_Depa_Dpt = per.Departamento_Id AND Dis.Codi_Prov_Tpr = per.Provincia_Id AND \n" +
        "     Dis.Codi_Dist_Tdi = per.Distrito_Id) \n" +
        "  where per.documento_tipo = ?  and per.documento_numero = ? \n" +
        "     and (Nvl(per.Estado_Juridico, per.Estado_Natural) = 'ACTIVO' or Nvl(per.Estado_Juridico, per.Estado_Natural) is null) ";
    /* "select \n" +
        "      per.persona_id, per.documento_numero\n" +
        "    , per.documento_tipo, per.nombre_razon_social, per.direccion\n" +
        "    , per.telefono, per.telefono_movil, per.correo_electronico\n" +
        "    , per.departamento_id, per.provincia_id, per.distrito_id\n" +
        "    , per.estado, rep.apellido_materno, rep.apellido_paterno, rep.nombres, rep.documento_numero dniRepLegal\n" +
        "    , senasa.f_departamentos(per.departamento_id) departamento_nombre\n" +
        "    , senasa.f_provincias(per.departamento_id,per.provincia_id) provincia_nombre\n" +
        "    , senasa.f_distritos(per.departamento_id,per.provincia_id,per.distrito_id) distrito_nombre\n" +
        "    from persona per left join persona_representante_legal prl on per.persona_id = prl.persona_id \n" +
        "    left join persona rep on prl.representante_id = rep.persona_id \n" +
        " where per.documento_tipo = ?  and per.documento_numero = ? \n" +
        "     and (per.estado = 'ACTIVO' or per.estado is null) ";*/
    //cambiado el 09/07/2011 porque se modifico el campo ACTIVO por ACTIVO_JURIDICO y ACTIVO_NATURAL Y se cambiaron LAS FUNCIONES DE UBIGEO

    public static final String OBTENER_SOLICITANTE_X_IDPERSONA = "select \n" +
        "      per.persona_id, per.persona_tipo, per.documento_numero\n" +
        "    , per.documento_tipo, per.nombre_razon_social, per.direccion\n" +
        "    , per.telefono, per.telefono_movil, per.correo_electronico\n" +
        "    , per.departamento_id, per.provincia_id, per.distrito_id\n" +
        "    , per.estado, rep.apellido_materno, rep.apellido_paterno, rep.nombres, rep.documento_numero dniRepLegal\n" +
        "    , senasa.f_departamentos(per.departamento_id) departamento_nombre\n" +
        "    , senasa.f_provincias(per.departamento_id,per.provincia_id) provincia_nombre\n" +
        "    , senasa.f_distritos(per.departamento_id,per.provincia_id,per.distrito_id) distrito_nombre\n" +
        "    from persona per left join persona_representante_legal prl on per.persona_id = prl.persona_id \n" +
        "    left join persona rep on prl.representante_id = rep.persona_id \n" +
        " where per.persona_id = ? \n" +
        "     and (per.estado = 'ACTIVO' or per.estado is null) ";

    public static final String INSERTAR_SOLICITANTE =
        "insert into persona (documento_tipo,documento_numero,nombre_razon_social,direccion,departamento_id,provincia_id,distrito_id,telefono,telefono_movil,correo_electronico,persona_tipo)  values (?,?,?,?,?,?,?,?,?,?,?)";

    public static final String INSERTAR_PERSONA =
        "insert into persona (documento_tipo,documento_numero,nombre_razon_social,persona_tipo,nombres,apellido_paterno) values (?,?,?,?,?,?)";
    public static final String INSERTAR_PERSONA_SP =
        "{? = CALL sistemas.pckg_persona.Fn_Registrar_Persona(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static final String OBTENER_REEMPLAZO =
        "{ CALL Pckg_Usuario.Sp_Obtener_Reemplazo(?,?) }";

    public static final String OBTENER_REPRESENTANTE_LEGAL =
        "{ call Pckg_General.Sp_Obtener_Representante_Legal(?,?) }";


    /////////////////////////////////////////////////////////////////////////////////////
    ////       InspectorDAO ////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////


    public static final String OBTENER_INSPECTORES =
        "select p.documento_numero,p.nombre_razon_social \n" +
        "from inpector_sede ins inner join persona p on p.persona_id = ins.persona_id \n" +
        "inner join centro_tramite ct on ct.codigo_centro_tramite = ins.codigo_centro_tramite\n" +
        "where ins.codigo_centro_tramite = ?";

    public static final String OBTENER_INSPECTORES_UBIGEO =
        "call Pckg_General.Sp_InspectoresPorUbigeo(?,?,?,?)";

    public static final String OBTENER_INSPECTORES_CENTRO_TRAMITE =
        "call Pckg_General.Sp_Inspectores_Centro_Tramite(?,?,?)";

    public static final String OBTENER_INSPECTORES_DEPARTAMENTO =
        "call Pckg_General.Sp_Inspectores_Departamento(?,?,?)";

    public static final String OBTENER_INSPECTOR_SEDE =
        "call Pckg_General.Sp_Inspectores_Sede(?,?)";


    /////////////////////////////////////////////////////////////////////////////////////
    ////       SaldoClienteDAO /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String PERSONA_EXISTE =
        "select per.persona_id from persona per \n" +
        "inner join saldo_persona sp on per.persona_id = sp.persona_id\n" +
        "where per.documento_numero = ?";

    public static final String OBTENER_ID_PERSONA =
        "select per.persona_id from persona per where per.documento_numero = ?";

    public static final String GUARDAR_SALDO_PERSONA =
        "insert into saldo_persona (persona_id,saldo_favor,saldo_contra)  values  (?,?,?)";

    public static final String OBTENER_SALDO_PERSONA =
        "{? = CALL SIGA01.TES_PAGOS_INGRESO.get_saldo_cliente(?)}";

    public static final String ABONAR_SALDO_FAVOR =
        "update saldo_persona set saldo_favor  = ? + saldo_favor where persona_id = ?";

    public static final String DESCONTAR_SALDO_FAVOR =
        "update saldo_persona set saldo_favor  = saldo_favor - ? where persona_id = ?";

    public static final String ACTUALIZAR_SALDO_CONTRA =
        "update saldo_persona set saldo_contra  = ? + saldo_contra where persona_id = ?";

    public static final String OBTENER_SALDO_FAVOR_CLIENTE =
        "{CALL Pckg_Recibo.Sp_Consultar_Saldo_a_Favor(?,?)}";

    /////////////////////////////////////////////////////////////////////////////////////
    ////       ServicioTUPADAO /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////
    public static final String OBTENER_SERVICIOS_TUPA =
        "select s.codigo_servicio,s.descripcion_servicio from servicio_tupa s";

    public static final String OBTENER_SERVICIO_TUPA =
        " select s.codigo_servicio,s.descripcion_servicio,s.indicador_cobro_por_producto from servicio_tupa s where s.codigo_servicio = ?";


    //public static final String OBTENER_NUMERO_EXPEDIENTE = "call  pkg_servicios_tupa.crear_numero_expediente(?,?,?)";
    public static final String OBTENER_NUMERO_EXPEDIENTE =
        "call  pkg_servicios_tupa.crear_numero_expediente(?,?,?,?)";

    public static final String OBTENER_NUMERO_CERTIFICADO =
        "call pkg_servicios_tupa.crear_numero_certificado(?,?,?)";

    public static final String OBTENER_INFO_SERVICIO =
        "call Pckg_Servicios_Tupa.Sp_Obtener_Servicio_Total(?,?)";

    /*
    public static final String OBTENER_AREA_GESTION = " select codigo_area_gestion,descripcion_area_gestion ,codigo_clase \n" +
    "from area_gestion order by codigo_clase desc,codigo_area_gestion";
    */
    public static final String OBTENER_AREA_GESTION =
        "call Pckg_General.Sp_Areas_Gestion(?)";

    public static final String OBTENER_CENTRO_TRAMITE_TODOS =
        "call Pckg_Centro_Tramite.Sp_Todos(?)";

    public static final String OBTENER_CENTRO_POR_DEPARTAMENTO =
        "call Pckg_Centro_Tramite.Sp_Centro_Por_Departamento(?,?)";

    public static final String OBTENER_SERVICIO_X_CENTROTRAMITE =
        "call Pckg_Centro_Tramite.Sp_Obtener_Servicios(?,?,?) ";
    /*public static final String OBTENER_SERVICIO_X_CENTROTRAMITE = " select r.descripcion_servicio,r.codigo_servicio, s.descripcion_centro_tramite, s.codigo_centro_tramite, \n" +
                 "r.codigo_clase,r.importacion_exportacion \n" +
                "from CENTRO_TRAMITE s, TIPO_SERVICIO_CENTRO_TRAMITE v, tipo_centro_tramite ts, servicio_tupa r \n" +
                "where s.codigo_tipo_centro_tramite=ts.codigo_tipo_centro_tramite \n" +
                "and v.codigo_servicio=r.codigo_servicio \n" +
                "and v.codigo_tipo_centro_tramite=ts.codigo_tipo_centro_tramite \n" +
                "and s.codigo_centro_tramite=? \n" +
                "and r.estado='ACTIVO' \n" +
                "and r.codigo_area_gestion=? \n" +
                "order by r.descripcion_servicio " ;
    */
    public static final String OBTENER_REQUISITOS_X_SERVICIO =
        "call Pckg_Servicio.Sp_Requsitos_Documentarios(?,?) ";
    /*
    * public static final String OBTENER_REQUISITOS_X_SERVICIO = " select rs.codigo_servicio,s.descripcion_servicio ,d.codigo_documento,d.descripcion_documento ,rs.indicador_obligatorio \n" +
                  "from requisito_servicio rs, servicio_tupa s, documento d \n" +
                  "where rs.codigo_servicio = s.codigo_servicio \n" +
                  "and d.codigo_documento = rs.codigo_documento \n" +
                  "and s.estado='ACTIVO' \n" +
                  "and d.estado='ACTIVO' \n" +
                  "and s.codigo_servicio= ? \n" +
                  "order by s.descripcion_servicio, rs.indicador_obligatorio ";
    */
    public static final String OBTENER_EXPEDIENTE_PERSONANATURAL =
        "call Pckg_Expediente.Sp_Usuario_Persona_Natural(?,?) ";
    public static final String OBTENER_EXPEDIENTE_PERSONAJURIDICA =
        "call Pckg_Expediente.Sp_Usuario_Persona_Juridica(?,?) ";

    public static final String OBTENER_OPERADORLOGISTICO_NATURAL =
        "call Pckg_General.Sp_Operador_Logistico_Natural(?) ";
    public static final String OBTENER_OPERADORLOGISTICO_JURIDICA =
        "call Pckg_General.Sp_Operador_Logistico_Juridico(?) ";

    public static final String OBTENER_EXPEDIENTE_CLASE_X_SERVICIO =
        "call Pckg_Expediente.Sp_Clase_Expediente(?,?) ";
    public static final String OBTENER_SERVICIO_CLASE =
        "call Pckg_Servicio.Sp_Servicios_Por_Clase(?,?) ";

    public static final String OBTENER_NUMERO_INSPECCIONES =
        "select Pckg_Servicio.Fn_Cantidad_Inspecciones(?,?) from dual";
    public static final String OBTENER_TIPO_SERVICIO =
        "select Pckg_Servicio.Fn_Tipo_Servicio(?,?) from dual";
    public static final String OBTENER_PUNTOSINGRESO_EXPEDIENTE =
        "call Pckg_Expediente.Sp_Puntos_Ingreso(?,?,?)";
    public static final String OBTENER_PRODUCTOS =
        "call Pckg_Expediente.Sp_Obtener_Productos(?,?,?)";
    public static final String OBTENER_PRODUCTOS_INSPECCION =
        "call Pckg_Inspeccion.Sp_Obtener_Productos(?,?,?)";
    public static final String OBTENER_PRODUCTOS_INSPECCION_EXP =
        "call pckg_inspeccion.sp_consultar_productos_exped(?,?)";

    public static final String OBTENER_DATOS_EXPEDIENTE =
        "CALL Pckg_Expediente.Sp_Obtener_Expediente(?,?)";

    public static final String OBTENER_DATOS_OPERADOR =
        "CALL Pckg_General.Sp_Obtener_Operador(?,?,?)";
    public static final String OBTENER_VACUNAS =
        "CALL Pckg_General.Sp_Obtener_Lista_Vacunas(?)";
    public static final String OBTENER_ANALISIS =
        "CALL Pckg_General.Sp_Obtener_Lista_Analisis(?)";
    public static final String OBTENER_SOLICITANTE_EXP =
        "CALL Pckg_Expediente.Sp_Obtener_Solicitante(?,?)";

    public static final String ANULAR_EXPEDIENTE =
        "CALL Pckg_Expediente.Sp_Anular(?)";
    public static final String OBTENER_SERVICIOS_EXP =
        "CALL Pckg_Expediente.Sp_Obtener_Servicios(?,?)";

    public static final String OBTENER_RECIBOS =
        "{ call Pckg_Recibo.Sp_Obtener_Recibos(?,?,?) } ";

    public static final String ANULAR_BOLETA =
        "{CALL Pckg_Recibo.Sp_Anular_Recibo(?)}";

    public static final String ANULAR_SERVICIOS_EXP =
        "CALL Pckg_Expediente.Sp_Anular_Servicio(?,?)";

    //"{ call PKG_SERVICIOS_TUPA.Sp_ObtieneDatosReciboPago(?,?) } ";
    /////////////////////////////////////////////////////////////////////////////////////
    ////       RegistroCPEDAO /////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String INGRESAR_CPE =
        " call Pckg_Registro_Cpe_Fito.Sp_Registrar_Registro_Cpe(?,?,?,?,?,?,?,?)";

    public static final String INGRESAR_PRODUCTO_CPE =
        "call Pckg_Registro_Cpe_Fito.Sp_Registrar_Producto(?,?,?,?,?,?,?,?,?,?)";

    public static final String INGRESAR_EQUIPO_TECNICO_CPE =
        "call Pckg_Registro_Cpe_Fito.Sp_Registrar_Persona(?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String INGRESAR_LUGAR_PRODUCCION_CPE =
        "call Pckg_Registro_Cpe_Fito.Sp_Registrar_Predio(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String OBTENER_CODIGO_CPE =
        "{ ?=call Pckg_Registro_Cpe_Fito.Fn_Generar_Codigo(?)}";

    /*
    public static final String OBTENER_REGISTRO_CPE ="select regcpe.codigo_expediente,regcpe.codigo_cpe,regcpe.codigo_centro_tramite,regcpe.persona_id,per.documento_numero \n" +
    "from registro_cpe_fito regcpe \n" +
    "inner join persona per on regcpe.persona_id = per.persona_id\n" +
    "where per.documento_numero = ? and regcpe.estado = 'ACTIVO'";
    */
    public static final String OBTENER_REGISTRO_CPE =
        "select cpe.codigo_expediente,cpe.codigo_cpe,cpe.codigo_centro_tramite,cpe.persona_id,ct.descripcion_centro_tramite,ct.direccion_centro_tramite,cpe.url_registro_cpe \n" +
        "from registro_cpe_fito cpe inner join centro_tramite ct\n" +
        "on cpe.codigo_centro_tramite=ct.codigo_centro_tramite\n" +
        "where cpe.codigo_cpe = ?";
    public static final String OBTENER_REGISTRO_CPE_X_EXPEDIENTE =
        "select cpe.codigo_expediente,cpe.codigo_cpe,cpe.codigo_centro_tramite,cpe.persona_id,ct.descripcion_centro_tramite,ct.direccion_centro_tramite,cpe.url_registro_cpe, cpe.estado \n" +
        "from registro_cpe_fito cpe inner join centro_tramite ct\n" +
        "on cpe.codigo_centro_tramite=ct.codigo_centro_tramite\n" +
        "where cpe.codigo_expediente = ?";

    public static final String OBTENER_PRODUCTOS_CPE_GERMP_GC =
        "{ call Pckg_Registros.Sp_Obtener_Registros(?,?,?,?)}";
    public static final String OBTENER_REG_PRODUCTOS_CPE_GERMP =
        "{ call Pckg_Registros.Sp_Obtener_Productos_CPE_Germo(?,?,?,?)}";
    public static final String OBTENER_REG_PRODUCTOS_CPE =
        "{ call Pckg_Registros.Sp_Obtener_Productos_CPE(?,?)}";

    public static final String OBTENER_PRODUCTOS_CPE =
        "select regpro.secuencial, regpro.codigo_producto,regpro.codi_pais_tpa,tp.nomb_pais_tpa,regpro.cantidad_producto,regpro.parte_planta,\n" +
        "p.nombre_cientifico_producto,p.nombre_comercial_producto,pa.partida_arancelaria, regpro.flag_vuce \n" +
        "from tpaises tp inner join registro_cpe_fito_producto regpro \n" +
        "on tp.codi_pais_tpa=regpro.codi_pais_tpa \n" +
        "left join producto p \n" +
        "on regpro.codigo_producto=p.codigo_producto\n" +
        "left join partida_arancelaria pa \n" +
        "on p.codigo_partida_arancelaria=pa.codigo_partida_arancelaria \n" +
        "where regpro.codigo_cpe = ? and regpro.Estado = 'ACTIVO'";

    public static final String OBTENER_LUGARES_PRODUCCION_CPE =
        "select lug.secuencial,lug.NOMBRE_PREDIO,lug.DIRECCION_PREDIO,lug.AREA_PREDIO,lug.CODI_DEPA_DPT,lug.CODI_PROV_TPR,lug.CODI_DIST_TDI,\n" +
        "senasa.f_departamentos(lug.CODI_DEPA_DPT) departamiento_nombre,\n" +
        "senasa.f_provincias(lug.CODI_DEPA_DPT, lug.CODI_PROV_TPR) provincia_nombre,\n" +
        "senasa.f_distritos(lug.CODI_DEPA_DPT, lug.CODI_PROV_TPR, lug.CODI_DIST_TDI) distrito_nombre, lug.flag_vuce,lug.Tipo_Predio \n" +
        "from registro_cpe_fito_predio lug where lug.CODIGO_CPE = ? and lug.Estado = 'ACTIVO'";

    public static final String OBTENER_EQUIPO_TECNICO_CPE =
        "select regper.secuencial,regper.cargo_profesional_tecnico,regper.numero_de_titulo,per.nombres,per.apellido_paterno ||' '|| per.apellido_materno as apellidos,per.documento_numero, regper.persona_id, regper.flag_vuce \n" +
        "from registro_cpe_fito_persona regper \n" +
        "inner join persona per on regper.persona_id = per.persona_id \n" +
        "where regper.codigo_cpe = ? and regper.Estado = 'ACTIVO'";

    public static final String BUSCAR_CPE_NO_CERTIFICADO =
        "select count(rcpe.codigo_cpe) from registro_cpe_fito rcpe where rcpe.codigo_cpe = ?";

    public static final String ELIMINAR_REGISTRO_CPE =
        "delete from registro_cpe_fito where codigo_cpe = ?";
    public static final String ELIMINAR_EQUIPO_TECNICO_CPE =
        "delete from registro_cpe_fito_persona where codigo_cpe = ?";
    public static final String ELIMINAR_PRODUCTOS_REGISTRO_CPE =
        "delete from registro_cpe_fito_producto where codigo_cpe = ?";
    public static final String ELIMINAR_LUGARES_PRODUCCION_CPE =
        "delete from registro_cpe_fito_predio where codigo_cpe = ?";

    /////////////////////////////////////////////////////////////////////////////////////
    ////       ExportacionZooSanitariaDAO //////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String OBTENER_REQUISITOS_SANITARIOS_EXPO_ZOO =
        "select rs.descripcion_requisito_sanitari from requ_sani_exportacion_producto rep " +
        " left join requisitos_sanitarios rs on rep.codigo_requisito_sanitario=rs.codigo_requisito_sanitario " +
        " where rep.codigo_producto= ? and rep.codigo_aplicacion = ? and rep.codi_pais_tpa_origen= ? ";

    public static final String OBTENER_CERT_EXPOZOO_CABECERA =
        "select cez.codigo_centro_tramite_solicita,cez.codigo_certificado_zoo_expo,cez.codigo_expediente,cez.urcl_cez_definitivo,cez.codigo_lugar_inspeccion,cez.fecha_inspeccion,cez.hora_emision,cez.fecha_embarque,cez.fecha_desembarque,cez.codigo_aplicacion,cez.codi_pais_tpa_destino,cez.codi_pais_tpa_origen,cez.codigo_medio_transporte,cez.codigo_centro_tramite_salida,cez.codigo_puerto,cez.lugar_ubicacion_envio\n" +
        " from certificado_zoo_exportacion cez \n" +
        " where cez.codigo_certificado_zoo_expo = ?";

    public static final String OBTENER_PRODUCTO_PZE =
        " select distinct pr.codigo_producto,pr.nombre_comercial_producto,pr.nombre_cientifico_producto,sg.codigo_partida_arancelaria,dcz.codigo_pais_proce,dcz.codigo_aplicacion,dcz.espe_anim_ani,dcz.sexo_animal,dcz.edad_animal,dcz.raza_anim_raz,dcz.numero_identificacion_animal,dcz.codigo_tipo_envase,dcz.cantidad_envase,dcz.cantidad_peso,count(pg.codigo_producto_padre )\n" +
        " from cert_zoo_expo_producto dcz inner join producto pr on pr.codigo_producto = dcz.codigo_producto\n" +
        " inner join partida_arancelaria sg on sg.codigo_partida_arancelaria = pr.codigo_partida_arancelaria\n" +
        " left join producto_grupo pg on pg.codigo_producto_padre = pr.codigo_producto\n" +
        " where dcz.codigo_certificado_zoo_expo = ? \n" +
        " group by pr.codigo_producto, pr.nombre_comercial_producto, pr.nombre_cientifico_producto, sg.codigo_partida_arancelaria, dcz.codigo_pais_proce, dcz.codigo_aplicacion, dcz.espe_anim_ani, dcz.sexo_animal, dcz.edad_animal, dcz.raza_anim_raz, dcz.numero_identificacion_animal, dcz.codigo_tipo_envase, dcz.cantidad_envase, dcz.cantidad_peso";

    public static final String OBTENER_ANEXOS_PZE =
        "select distinct pr.codigo_producto,pr.nombre_comercial_producto,pr.nombre_cientifico_producto,sg.partida_arancelaria, propadre.codigo_producto,propadre.nombre_comercial_producto,propadre.nombre_cientifico_producto,sg2.partida_arancelaria,dcz.cod_pais_procedencia,dcz.codigo_aplicacion,dcz.codigo_tipo_envase,dcz.cantidad_envase,dcz.cantidad_peso\n" +
        "     from cert_zoo_expo_prod_anexo dcz \n" +
        "     inner join producto pr on pr.codigo_producto = dcz.codigo_producto\n" +
        "     inner join partida_arancelaria sg on sg.codigo_partida_arancelaria = pr.codigo_partida_arancelaria\n" +
        "     left join producto_grupo pg on pg.codigo_producto_hijo = pr.codigo_producto\n" +
        "     left join producto propadre on pg.codigo_producto_padre = propadre.codigo_producto\n" +
        "     left join partida_arancelaria sg2 on sg2.codigo_partida_arancelaria = propadre.codigo_partida_arancelaria\n" +
        "     where dcz.codigo_certificado_zoo_expo = ?";

    public static final String OBTENER_CERTIFICADOS_X_CLIENTE =
        " select ez.codigo_certificado_zoo_expo,uc.documento_numero from persona uc \n" +
        "     inner join expediente ex on ex.persona_id = uc.persona_id\n" +
        "     inner join certificado_zoo_exportacion  ez on ez.codigo_expediente = ex.codigo_expediente \n" +
        "     where uc.documento_numero = ? ";

    public static final String GUARDAR_CERT_EXPO_ZOO =
        "{call Pckg_Cert_Zoo_Exportacion.Sp_Insertar_Certificado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static final String GUARDAR_PRODUCTO_EXPO_ZOO =
        "call Pckg_Cert_Zoo_Exportacion.Sp_Insertar_Producto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String GUARDAR_ANEXO_EXPO_ZOO =
        "call Pckg_Cert_Zoo_Exportacion.Sp_Insertar_Producto_Anexo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String GUARDAR_ANEXO_PZE =
        "insert into cert_zoo_expo_prod_anexo  ( CODIGO_CERTIFICADO_ZOO_EXPO,CODIGO_APLICACION,CANTIDAD_PESO,CODIGO_PRODUCTO,CODIGO_TIPO_ENVASE,CANTIDAD_ENVASE,COD_PAIS_PROCEDENCIA, codi_unid_med ) VALUES (?,?,?,?,?,?,?,?)";

    public static final String BUSCAR_CERT_EXPO_ZOO_NO_CERTIFICADO =
        "select count(cer.codigo_certificado_zoo_expo) from certificado_zoo_exportacion cer where cer.codigo_certificado_zoo_expo = ?";

    public static final String ELIMINAR_PRODUCTOS_EXPO_ZOO =
        "delete from cert_zoo_expo_producto where codigo_certificado_zoo_expo = ?";
    public static final String ELIMINAR_ANEXOS_EXPO_ZOO =
        "delete from cert_zoo_expo_prod_anexo where codigo_certificado_zoo_expo = ?";
    public static final String ELIMINAR_CERTIFICADO_EXPO_ZOO =
        "delete from certificado_zoo_exportacion where codigo_certificado_zoo_expo = ?";
    public static final String GUARDAR_IMPORTADOR =
        "insert into importadores  (codi_pais_tpa,nombre_importador,direccion_importador)  values  (?,?,?)";
    public static final String CREAR_CERTIFICADO_EXPO_ZOO =
        "{? = call Pckg_Cert_Zoo_Exportacion.Fn_Generar_Codigo_Certificado(?)}";

    /////////////////////////////////////////////////////////////////////////////////////
    ////       PermisoZooSanitarioImportacionDAO ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    //public static final String GUARDAR_PZSI = "insert into permiso_pzi  (numero_permiso,persona_id,codigo_expediente,fecha_probable_embarque,fecha_probable_arribo,url_pzi_definitivo,centro_tramite_llegada,codigo_puerto,centro_tramite_solicitud,fecha_emision,estado,indicador_ampliacion) values (?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String GUARDAR_PZSI =
        "{ call Pckg_Permiso_Zoo_Impo.Sp_Registrar_Permiso(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    public static final String BUSCAR_PERMISO_PZI =
        "select count(numero_permiso) from permiso_pzi where numero_permiso = ?";

    public static final String ELIMINAR_PERMISO_PZI =
        "delete from permiso_pzi where numero_permiso = ?";
    public static final String ELIMINAR_PRODUCTOS_PZI =
        "delete from permiso_pzi_producto where numero_permiso = ?";
    public static final String ELIMINAR_ANEXOS_PZI =
        "delete from permiso_pzi_producto_anexo where numero_permiso = ?";
    public static final String ELIMINAR_PAISES_ORIGEN_PZI =
        "delete from permiso_pzi_pais_origen where numero_permiso = ?";

    public static final String OBTENER_NUMERO_PERMISO_PZI =
        "select pzi.numero_permiso from permiso_pzi pzi where pzi.numero_permiso = ?";

    //public static final String GUARDAR_PRODUCTO_PZI = "insert into permiso_pzi_producto (numero_permiso,codi_pais_tpa_procedencia,codigo_producto,codigo_aplicacion,codigo_tipo_envase,cantidad_peso_permiso,cantidad_envase)  values  (?,?,?,?,?,?,?)";
    public static final String GUARDAR_PRODUCTO_PZI =
        "{ call Pckg_Permiso_Zoo_Impo.Sp_Registrar_Producto(?,?,?,?,?,?,?,?,?,?,?,?)}";

    //public static final String GUARDAR_ANEXOS_PZI =  "insert into permiso_pzi_producto_anexo  (numero_permiso,codigo_producto,codigo_tipo_envase,cantidad_envase,cantidad_peso,codi_pais_tpa_procedencia) values (?,?,?,?,?,?)";
    public static final String GUARDAR_ANEXOS_PZI =
        "{ call Pckg_Permiso_Zoo_Impo.Sp_Registrar_Producto_Anexo(?,?,?,?,?,?,?,?,?,?,?,?)}";

    //public static final String GUARDAR_PAIS_ORIGEN_PZI = "insert into permiso_pzi_pais_origen  (codi_pais_tpa_origen,numero_permiso,codigo_producto,codigo_tipo_envase,indicador_anexo) values (?,?,?,?,?)";
    public static final String GUARDAR_PAIS_ORIGEN_PZI =
        "{ call Pckg_Permiso_Zoo_Impo.Sp_Registrar_Pais_Origen(?,?,?,?,?,?)}";

    public static final String OBTENER_PZI_X_NoCERTIFICADO =
        "select pzi.codigo_expediente as folio,pzi.numero_permiso as nocertificado,pzi.url_pzi_definitivo," +
        "pzi.centro_tramite_llegada,pzi.fecha_probable_arribo,pzi.codigo_puerto,pzi.fecha_probable_embarque," +
        "pzi.centro_tramite_solicitud,pzi.numero_permiso," +
        "pzi.indicador_ampliacion,pzi.fecha_emision,pzi.codigo_requ_impo_producto\n" +
        "from permiso_pzi pzi \n" +
        "where pzi.numero_permiso = ? ";

    public static final String OBTENER_PRODUCTOPZI_X_COD_EXP =
        "select p.codigo_producto,p.nombre_comercial_producto,sg.partida_arancelaria,p.nombre_cientifico_producto,pxe.codi_pais_tpa_procedencia,p.codigo_clase,pxe.codigo_aplicacion,pxe.codigo_tipo_envase,pxe.cantidad_envase,pxe.cantidad_peso_permiso,count(pg.codigo_producto_padre),\n" +
        "        umed.codi_unid_med,umed.desc_unid_med,tenv.descripcion_tipo_envase,p.indicador_animal_vivo, \n" +
        "        pxe.raza_anim_raz idRaza,razanim.nomb_raza_raz, \n" +
        "        nvl(pxe.edad_animal,0)edad_animal, \n" +
        "        pxe.codigo_sexo,sexanim.descripcion_sexo \n" +
        "        from permiso_pzi_producto pxe \n" +
        "        inner join producto p on p.codigo_producto = pxe.codigo_producto \n" +
        "        inner join partida_arancelaria sg on p.codigo_partida_arancelaria = sg.codigo_partida_arancelaria \n" +
        "       left join unidad_medida umed on pxe.codi_unid_med=umed.codi_unid_med\n" +
        "        inner join tipo_envase tenv on tenv.codigo_tipo_envase=pxe.codigo_tipo_envase\n" +
        "        left join producto_grupo pg on pg.codigo_producto_padre = p.codigo_producto\n" +
        "        Left join Razas_Animales razanim on pxe.raza_anim_raz=razanim.raza_anim_raz\n" +
        "        Left join Sexo_Animal sexanim on pxe.codigo_sexo=sexanim.codigo_sexo\n" +
        "        where pxe.numero_permiso = ? \n" +
        "        group by p.codigo_producto, p.nombre_comercial_producto, sg.partida_arancelaria, p.nombre_cientifico_producto, " +
        "        pxe.codi_pais_tpa_procedencia, p.codigo_clase, pxe.codigo_aplicacion, pxe.codigo_tipo_envase, " +
        "       pxe.cantidad_envase, pxe.cantidad_peso_permiso,umed.codi_unid_med,umed.desc_unid_med,tenv.descripcion_tipo_envase,p.indicador_animal_vivo,\n" +
        "       pxe.raza_anim_raz,razanim.nomb_raza_raz,edad_animal,pxe.codigo_sexo,descripcion_sexo\n";

    public static final String OBTENER_ANEXOS_PZI =
        "select ap.codigo_producto,sg2.partida_arancelaria,p2.nombre_comercial_producto,p2.nombre_cientifico_producto, ap.codigo_tipo_envase as envase,ap.cantidad_envase as cantidad,ap.cantidad_peso as peso, p.codigo_producto,sg.partida_arancelaria,p.nombre_cientifico_producto,p.nombre_comercial_producto,ap.codi_pais_tpa_procedencia,umed.codi_unid_med,umed.desc_unid_med,tenv.descripcion_tipo_envase,p.indicador_animal_vivo,\n" +
        "       ap.raza_anim_raz idRaza,razanim.nomb_raza_raz, nvl(ap.edad_animal,0)edad_animal, \n" +
        "        ap.codigo_sexo,sexanim.descripcion_sexo \n" +
        "        from permiso_pzi_producto_anexo ap \n" +
        "        inner join producto_grupo pg on pg.codigo_producto_hijo = ap.codigo_producto\n" +
        "        inner join producto p on pg.codigo_producto_padre = p.codigo_producto\n" +
        "        inner join permiso_pzi_producto pzp1 on p.codigo_producto = pzp1.codigo_producto and pzp1.numero_permiso = ap.numero_permiso \n" +
        "        inner join producto p2 on pg.codigo_producto_hijo = p2.codigo_producto\n" +
        "        inner join partida_arancelaria sg on sg.codigo_partida_arancelaria = p.codigo_partida_arancelaria\n" +
        "        inner join partida_arancelaria sg2 on sg2.codigo_partida_arancelaria = p2.codigo_partida_arancelaria\n" +
        "        inner join unidad_medida umed on ap.codi_unid_med=umed.codi_unid_med \n" +
        "        inner join tipo_envase tenv on tenv.codigo_tipo_envase=ap.codigo_tipo_envase\n" +
        "        Left join Razas_Animales razanim on ap.raza_anim_raz=razanim.raza_anim_raz\n" +
        "        Left join Sexo_Animal sexanim on ap.codigo_sexo=sexanim.codigo_sexo\n" +
        "        where ap.numero_permiso = ?";

    public static final String OBTENER_PERMISOS_PZI_X_CLIENTE =
        "select pzi.numero_permiso from persona per \n" +
        "            inner join expediente ex on ex.persona_id = per.persona_id\n" +
        "            inner join permiso_pzi  pzi on pzi.codigo_expediente = ex.codigo_expediente\n" +
        "            where per.documento_numero = ?";


    public static final String OBTENER_PAIS_ORIGEN_PZI =
        "select par.partida_arancelaria,pzi.codigo_producto,pro.nombre_comercial_producto,pro.nombre_cientifico_producto ,\n" +
        "pzi.codigo_tipo_envase,pzi.codi_pais_tpa_origen,p.nomb_pais_tpa \n" +
        "from siga.tpaises p\n" +
        "inner join permiso_pzi_pais_origen pzi\n" +
        "on pzi.codi_pais_tpa_origen=p.codi_pais_tpa\n" +
        "inner join producto pro on pzi.codigo_producto = pro.codigo_producto\n" +
        "inner join partida_arancelaria par on par.codigo_partida_arancelaria = pro.codigo_partida_arancelaria \n" +
        "where numero_permiso = ?";
    // "where numero_permiso = ? and pzi.indicador_anexo = ?";


    /////////////////////////////////////////////////////////////////////////////////////
    ////       ExpedienteDAO ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String OBTENER_CLIENTE_X_EXPEDIENTE =
        "select ex.persona_id from expediente ex where ex.codigo_expediente = ?";


    /////////////////////////////////////////////////////////////////////////////////////
    ////       PermisoFitoSanitarioImportacionDAO ///////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    /*
    public static final String GUARDAR_PFI =
        "insert into permiso_pfi   (persona_id,numero_permiso,codigo_expediente,url_pfi_definitivo,centro_tramite_solicitud,fecha_emision,estado,indicador_ampliacion) values (?,?,?,?,?,?,?,?)";
   */
    public static final String GUARDAR_PFI =
        "insert into permiso_pfi   (persona_id,numero_permiso,codigo_expediente,url_pfi_definitivo,centro_tramite_solicitud,fecha_emision,estado,indicador_ampliacion, codigo_requ_impo_producto) values (?,?,?,?,?,?,?,?,?)";

    public static final String GUARDAR_PRODUCTO_PFI =
        "insert into permiso_pfi_producto( numero_permiso,codi_pais_tpa_procedencia,codigo_producto,codigo_aplicacion,codigo_tipo_envase,cantidad_envase,cantidad_peso_permiso,codi_unid_med) values (?,?,?,?,?,?,?,?)";

    public static final String GUARDAR_ANEXOS_PFI =
        "insert into permiso_pfi_producto_anexo  (numero_permiso,codigo_producto,codigo_tipo_envase,cantidad_envase,cantidad_peso,codi_pais_tpa_procedencia)  values  (?,?,?,?,?,?)";

    public static final String GUARDAR_PUNTO_INGRESO =
        "insert into permiso_pfi_producto_ct  (numero_permiso,codigo_producto,indicador_anexo,codigo_tipo_envase,codigo_aplicacion,cantidad_envase,cantidad_peso_permiso,codigo_centro_tramite, codi_unid_med) values (?,?,?,?,?,?,?,?,?)";

    public static final String GUARDAR_PAIS_ORIGEN =
        "insert into permiso_pfi_pais_origen  (numero_permiso,codi_pais_tpa_origen,indicador_anexo,codigo_tipo_envase,codigo_producto) values (?,?,?,?,?)";

    public static final String GUARDAR_LUGARES_PRODUCCION =
        "insert into permiso_pfi_lugar_de_produc  (numero_permiso,codigo_lugar_produccion,codigo_producto,indicador_anexo,codigo_tipo_envase) values (?,?,?,?,?)";
    /*-------------------------------------------------------------------*/
    //public static final String GUARDAR_RECIBO =
    //  "insert into recibo (codigo_recibo,prefijo, numero_recibo, fecha_recibo, codigo_centro_tramite, persona_id, codigo_expediente, monto_pagado, monto_recibo, monto_saldo, estado, observacion, url_recibo) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String GUARDAR_RECIBO =
        "{ call PKG_SERVICIOS_TUPA.grabar_recibo(?,?,?,?,?,?,?,?,?,?,?,?,?) } ";


    public static final String GUARDAR_RECIBO_SERVICIO =
        "insert into recibo_servicio (codigo_recibo, codigo_servicio, monto_servicio, cantidad) values (?,?,?,?)";

    //--------------------------------------------------------------------
    public static final String CREAR_RECIBO =
        "{ call Pckg_Recibo.Sp_Crear_Recibo(?,?,?,?,?,?,?) } ";

    public static final String CREAR_RECIBO_DETALLE =
        "{ call Pckg_Recibo.Sp_Crear_Recibo_Detalle(?,?,?,?) } ";

    public static final String REGISTRAR_PAGO =
        "{ call Pckg_Recibo.Sp_Registrar_Pago(?,?,?,?,?,?,?) } ";

    public static final String COMPLETAR_PAGO =
        "{ call Pckg_Recibo.Sp_Completar_Recibo(?) } ";

    //--------------------------------------------------------------------
    public static final String OBTENER_RECIBO_DATOS =
        "{ call Pckg_Recibo.Sp_Obtener_Recibo_Detallado(?,?,?) } ";
    //"{ call PKG_SERVICIOS_TUPA.Sp_ObtieneDatosReciboPago(?,?) } ";

    public static final String ACTUALIZA_URL_RECIBO =
        "{ call Pckg_Recibo.Sp_Actualizar_Recibo(?,?,?,?) } ";
    // "{ call PKG_SERVICIOS_TUPA.Sp_ActualizaUrlReciboPago(?,?,?) } ";

    public static final String OBTENER_TIPO_PAGOS =
        "{ call Pckg_Recibo.Sp_Obtener_Tipos_Pago(?) } ";

    public static final String OBTENER_SERVICIOS_ASOCIADOS =
        "{ call Pckg_Servicios_Tupa.Sp_Obtener_Servicios_Asociados(?,?) } ";

    public static final String CALCULAR_TARIFA =
        "{?=call Pckg_Tarifario.Fn_Calcular_Tasa_Servicio(?,?,?,?,?)}";


    /*-------------------------------------------------------------------*/

    public static final String BUSCAR_PFI =
        "select count(pfi.codigo_expediente) from permiso_pfi pfi where pfi.numero_permiso = ?";

    public static final String OBTENER_PFI_X_NoCERTIFICADO =
        "select  pfi.codigo_expediente,pfi.numero_permiso,pfi.centro_tramite_solicitud,pfi.url_pfi_definitivo,pfi.indicador_ampliacion,pfi.fecha_emision,pfi.codigo_requ_impo_producto,pfi.periodo_vegetativo,pfi.numero_inspecciones " +
        "from permiso_pfi pfi where pfi.numero_permiso = ?";


    public static final String OBTENER_PRODUCTOS_PFI =
        "select p.codigo_producto,p.nombre_comercial_producto,sg.partida_arancelaria,p.nombre_cientifico_producto,pxe.codi_pais_tpa_procedencia,pxe.codigo_aplicacion,pxe.codigo_tipo_envase,pxe.cantidad_plantas,pxe.cantidad_envase,pxe.cantidad_peso_permiso,count(p1.codigo_producto_padre) as tiene_anexos,ppf.codi_unid_med,umed.desc_unid_med,tenv.descripcion_tipo_envase \n" +
        " from permiso_pfi_producto pxe \n" +
        " inner join producto p on p.codigo_producto = pxe.codigo_producto \n" +
        " inner join partida_arancelaria sg on p.codigo_partida_arancelaria = sg.codigo_partida_arancelaria \n" +
        " inner join unidad_medida umed on pxe.codi_unid_med=umed.codi_unid_med\n" +
        " inner join tipo_envase tenv on tenv.codigo_tipo_envase=pxe.codigo_tipo_envase\n" +
        " left join producto_grupo p1 on p.codigo_producto = p1.codigo_producto_padre\n" +
        " left join permiso_pfi_producto_ct ppf on pxe.numero_permiso = ppf.numero_permiso " +
        "  where pxe.numero_permiso = ? \n" +
        " group by p.codigo_producto, p.nombre_comercial_producto,pxe.cantidad_plantas, sg.partida_arancelaria, p.nombre_cientifico_producto, pxe.codi_pais_tpa_procedencia, pxe.codigo_aplicacion, pxe.codigo_tipo_envase, pxe.cantidad_envase, pxe.cantidad_peso_permiso,ppf.codi_unid_med,umed.desc_unid_med,tenv.descripcion_tipo_envase";

  public static final String OBTENER_PRODUCTOS_PFIII =
      "select p.codigo_producto,p.nombre_comercial_producto,sg.partida_arancelaria,p.nombre_cientifico_producto,pxe.codi_pais_tpa_procedencia,pxe.codigo_aplicacion,\n" + 
      "pxe.codigo_tipo_envase,pxe.cantidad_plantas,pxe.cantidad_envase,pxe.cantidad_peso_permiso,count(p1.codigo_producto_padre) as tiene_anexos,ppf.codi_unid_med,umed.desc_unid_med,tenv.descripcion_tipo_envase \n" + 
      "from permiso_pfti_producto pxe\n" + 
      "inner join producto p on p.codigo_producto = pxe.codigo_producto \n" + 
      "inner join partida_arancelaria sg on p.codigo_partida_arancelaria = sg.codigo_partida_arancelaria \n" + 
      "inner join unidad_medida umed on pxe.codi_unid_med=umed.codi_unid_med\n" + 
      "inner join tipo_envase tenv on tenv.codigo_tipo_envase=pxe.codigo_tipo_envase\n" + 
      "left join producto_grupo p1 on p.codigo_producto = p1.codigo_producto_padre\n" + 
      "left join permiso_pfti_producto_ct ppf on pxe.numero_permiso = ppf.numero_permiso \n" + 
      "where pxe.numero_permiso = ? \n" + 
      "group by p.codigo_producto, p.nombre_comercial_producto,pxe.cantidad_plantas, sg.partida_arancelaria, p.nombre_cientifico_producto, pxe.codi_pais_tpa_procedencia, \n" + 
      "pxe.codigo_aplicacion, pxe.codigo_tipo_envase, pxe.cantidad_envase, pxe.cantidad_peso_permiso,ppf.codi_unid_med,umed.desc_unid_med,tenv.descripcion_tipo_envase";


    public static final String OBTENER_CODIGOS_PRODUCTO_PFI =
        "select distinct codigo_producto from permiso_pfi_producto where numero_permiso = ?";
    
  public static final String OBTENER_CODIGOS_PRODUCTO_PFIII =
      "select distinct codigo_producto from permiso_pfti_producto where numero_permiso = ?";
    

    public static final String OBTENER_ANEXOS_PFI =
        "select pfi_anx.codigo_producto,par2.partida_arancelaria,p2.nombre_comercial_producto,p2.nombre_cientifico_producto, pfi_anx.codigo_tipo_envase,pfi_anx.cantidad_peso,pfi_anx.cantidad_envase, p.codigo_producto,par1.partida_arancelaria,p.nombre_cientifico_producto,p.nombre_comercial_producto,pfi_anx.codi_pais_tpa_procedencia,umed.codi_unid_med,umed.desc_unid_med,tenv.descripcion_tipo_envase,pfi_anx.cantidad_plantas \n" +
        "        from permiso_pfi_producto_anexo pfi_anx\n" +
        "        inner join producto_grupo pg on pg.codigo_producto_hijo = pfi_anx.codigo_producto\n" +
        "        inner join producto p on pg.codigo_producto_padre = p.codigo_producto\n" +
        "        inner join permiso_pfi_producto pfp on p.codigo_producto = pfp.codigo_producto and pfp.numero_permiso = pfi_anx.numero_permiso\n" +
        "        inner join producto p2 on pg.codigo_producto_hijo = p2.codigo_producto\n" +
        "        inner join partida_arancelaria par1 on par1.codigo_partida_arancelaria = p.codigo_partida_arancelaria\n" +
        "        inner join partida_arancelaria par2 on par2.codigo_partida_arancelaria = p2.codigo_partida_arancelaria\n" +
        "        inner join unidad_medida umed on pfi_anx.codi_unid_med=umed.codi_unid_med\n" +
        "        inner join tipo_envase tenv on tenv.codigo_tipo_envase=pfi_anx.codigo_tipo_envase\n" +
        "        where pfi_anx.numero_permiso = ?";

    public static final String OBTENER_LUGARES_PRODUCCION_PFI =
        "select plp.codigo_producto,plp.codigo_tipo_envase,plp.codigo_lugar_produccion\n" +
        "    from permiso_pfi_lugar_de_produc plp \n" +
        "    where plp.numero_permiso = ? and plp.indicador_anexo = ?";
    //"    where plp.numero_permiso = ?";

    public static final String OBTENER_LUGARES_PRODUCCION_PFI_PRODUCTO =
        "select plp.codigo_producto,plp.codigo_tipo_envase,plp.codigo_lugar_produccion,lp.descripcion_lugar_produccion \n" +
        "from permiso_pfi_lugar_de_produc plp inner join lugar_produccion lp\n" +
        "on plp.codigo_lugar_produccion=lp.codigo_lugar_produccion \n" +
        "where plp.numero_permiso = ?";


  public static final String OBTENER_LUGARES_PRODUCCION_PFI_PRODUCTOII =
      "select plp.codigo_producto,plp.codigo_tipo_envase,plp.codigo_lugar_produccion,lp.descripcion_lugar_produccion \n" +
      "from permiso_pfti_lugar_de_produc plp inner join lugar_produccion lp\n" +
      "on plp.codigo_lugar_produccion=lp.codigo_lugar_produccion \n" +
      "where plp.numero_permiso = ?";
  
    public static final String OBTENER_PUNTOS_INGRESO =
        "select pea.codigo_producto,pea.codigo_tipo_envase,pea.cantidad_envase,pea.cantidad_peso_permiso,pea.codigo_centro_tramite \n" +
        "    from permiso_pfi_producto_ct pea \n" +
        "    where pea.numero_permiso = ? and pea.indicador_anexo  = ?";
    //"    where pea.numero_permiso = ?";
    //
    public static final String OBTENER_PUNTOS_INGRESO_PRODUCTO =
        "select pea.codigo_producto,pea.codigo_tipo_envase,pea.cantidad_envase,pea.cantidad_peso_permiso,pea.codigo_centro_tramite \n" +
        "    from permiso_pfi_producto_ct pea \n" +
        "    where pea.numero_permiso = ?";

    public static final String OBTENER_NUMERO_PERMISO_PFI =
        "{ ?=call Pckg_Permiso_Fito_Impo.Fn_Generar_Numero_Permiso(?) }";

    public static final String OBTENER_PAISES_ORIGEN =
        "select der.codi_pais_tpa_origen,der.codigo_tipo_envase,der.codigo_producto,der.indicador_anexo\n" +
        "from permiso_pfi_pais_origen der \n" +
        "where der.numero_permiso = ? and der.indicador_anexo = ?";
    //"where der.numero_permiso = ?";
    public static final String OBTENER_PAISES_ORIGEN_PRODUCTO =
        "select der.codi_pais_tpa_origen,der.codigo_tipo_envase,der.codigo_producto,der.indicador_anexo,plp.codigo_lugar_produccion,\n" +
        "lp.descripcion_lugar_produccion\n" +
        "from permiso_pfi_pais_origen der left join permiso_pfi_lugar_de_produc plp\n" +
        "on der.numero_permiso=plp.numero_permiso\n" +
        "left join lugar_produccion lp\n" +
        "on plp.codigo_lugar_produccion=lp.codigo_lugar_produccion\n" +
        "where der.numero_permiso = ?";

    public static final String OBTENER_PERMISOS_PFI_X_CLIENTE =
        "select pfi.numero_permiso from permiso_pfi pfi inner join persona per on per.persona_id = pfi.persona_id  where per.documento_numero = ?";

    public static final String ELIMINAR_PAISES_ORIGEN =
        "delete from permiso_pfi_pais_origen where numero_permiso =?";
    public static final String ELIMINAR_LUGAR_PRODUCCION =
        "delete from permiso_pfi_lugar_de_produc where numero_permiso = ?";
    public static final String ELIMINAR_PUNTO_INGRESO =
        "delete from permiso_pfi_producto_ct where numero_permiso =  ?";
    public static final String ELIMINAR_ANEXOS =
        "delete from permiso_pfi_producto_anexo where numero_permiso = ?";
    public static final String ELIMINAR_PRODUCTOS_PFI =
        "delete from permiso_pfi_producto where numero_permiso = ?";
    public static final String ELIMINAR_EXPEDIENTE_PFI =
        "delete from permiso_pfi where numero_permiso = ?";
    public static final String AMPLIAR_PFI =
        "update permiso_pfi set indicador_ampliacion = 'Y' where numero_permiso = ?";
    public static final String AMPLIAR_PZI =
        "update permiso_pzi set indicador_ampliacion = '1' where numero_permiso = ?";

    /*
     * Se ha cambiado la funcion a solicitud de un requerimiento para el ingreso de papeletas:
     */
    //public static final String CREAR_PAPELETA_I = "{ CALL SIGA01.TES_PAGOS_INGRESO.abonar_cliente (  ?,?,?,?,?,? ) }";
    public static final String CREAR_PAPELETA_I =
        "{ CALL SIGA01.TES_PAGOS_INGRESO.crear_papeleta (  ?,?,?,?,?,?,? ) }";

    public static final String ABONAR_SALDO_PAPELETA =
        "{ CALL SIGA01.TES_PAGOS_INGRESO.crear_nota_abono_de_papeleta(?,?,?,?) }";

    public static final String ABONAR_SALDO_NOTA_ABONO =
        " { call SIGA01.TES_PAGOS_INGRESO.crear_nota_abono_de_nota(?,?,?,?) } ";

    public static final String OBTENER_TIPOS_UCM =
        " select ddoctype,ddescription from cs_user.doctypes   order by ddescription  asc ";

    public static final String OBTENER_SUBTIPOS_UCM =
        "CALL Pckg_General.Sp_Obtener_Lista_Sub_Tipo_Doc(?,?)";
    //" select codigosubtipo,descripcionsubtipo,ddoctype from cs_user.xsubtipos where 1=1 <filter>   order by descripcionsubtipo  asc ";

    public static final String OBTENER_AREAS =
        " select cod_area, nombre_area, abreviatura from siga.xareas where estado='ACTIVO' order by nombre_area  asc ";
    public static final String OBTENER_SUB_AREAS =
        " select cod_subarea, nombre_subarea, abreviatura from siga.xsubareas where codigo_area=? and estado='ACTIVO' order by nombre_subarea  asc  ";

    public static final String OBTENER_FUNCIONARIOS =
        " select persona_id, nombre_persona, email, codi_jefe , usuario from siga.xpersonas where codigo_area=? and estado='ACTIVO' <filter>   order by nombre_persona  asc ";
    public static final String OBTENER_FUNCIONARIOS_CARG =
        "CALL Pckg_General.Sp_Obtener_Lista_Funcionario(?,?,?)";
    public static final String OBTENER_ENTIDADES =
        "select persona_id, nombre_persona, email from siga.xentidad where estado = 'ACTIVO'  order by nombre_persona asc";
    public static final String OBTENER_ENTIDADES_BY_FILTER =
        "{ call Pckg_General.Sp_Obtener_Entid_Nombre_Ruc(?,?,?) }";
    public static final String OBTENER_SUB_ENTIDADES =
        "select persona_id, descripcion_entidad, secuencial from siga.xsubentidad where estado = 'ACTIVO' and persona_id=? order by descripcion_entidad asc";
    public static final String OBTENER_FUNCIONARIOS_SUBORDINADOS =
        " select  xp.persona_id, xp.nombre_persona, xp.email, xp.codi_jefe from siga.xpersonas xp where  xp.estado='ACTIVO' and  xp.codigo_area=? and xp.codigo_subarea = ?  and xp.codi_jefe in (?) ";
    public static final String OBTENER_FUNCIONARIO_POR_ID =
        " select  xp.persona_id, xp.nombre_persona, xp.email, xp.codi_jefe, xp.usuario from siga.xpersonas xp where  xp.estado='ACTIVO' and  TRIM(xp.persona_id)=? ";
    public static final String OBTENER_FUNCIONARIO_POR_USERNAME =
        "  select  xp.persona_id, xp.nombre_persona, xp.email, xp.codi_jefe, xp.usuario ,\n" +
        "  xp.codigo_area , xp.codigo_subarea , xa.abreviatura as abre_area , xs.abreviatura as abre_sub_area,  xa.nombre_area, xs.nombre_subarea \n" +
        "  from siga.xpersonas xp , siga.xareas xa, siga.xsubareas xs\n" +
        "  where  xp.estado='ACTIVO'\n" +
        "  and xp.codigo_area = xa.cod_area\n" +
        "  and xp.codigo_subarea = xs.cod_subarea\n" +
        "  and   upper(TRIM(xp.usuario))= upper(?) ";

    public static final String OBTENER_FUNCIONARIO_POR_NOMBRE =
        "  select  xp.persona_id, xp.nombre_persona, xp.email, xp.codi_jefe, xp.usuario ,\n" +
        "  xp.codigo_area , xp.codigo_subarea , xa.abreviatura as abre_area , xs.abreviatura as abre_sub_area,  xa.nombre_area \n" +
        "  from siga.xpersonas xp , siga.xareas xa, siga.xsubareas xs\n" +
        "  where  xp.estado='ACTIVO'\n" +
        "  and xp.codigo_area = xa.cod_area\n" +
        "  and xp.codigo_subarea = xs.cod_subarea\n" +
        "  and upper(TRIM(xp.nombre_persona))= upper(?) ";

    public static final String OBTENER_FUNCIONARIO_POR_ID_PERSONA =
        " select  xp.persona_id, xp.nombre_persona, xp.email, xp.codi_jefe, xp.usuario ,\n" +
        "  xp.codigo_area , xp.codigo_subarea , xa.abreviatura as abre_area , xs.abreviatura as abre_sub_area,  xa.nombre_area \n" +
        "  from siga.xpersonas xp , siga.xareas xa, siga.xsubareas xs\n" +
        "  where  xp.estado='ACTIVO'\n" +
        "  and xp.codigo_area = xa.cod_area\n" +
        "  and xp.codigo_subarea = xs.cod_subarea\n" +
        "  and (TRIM(xp.persona_id)) = ?";


    public static final String OBTENER_JEFE_INMEDIATO =
        " select xp.persona_id, xp.nombre_persona, xp.email, xp.codi_jefe, xp.usuario from siga.xpersonas xp " +
        " where xp.persona_id in (select prs.codi_jefe from siga.xpersonas prs where upper(TRIM(prs.usuario)) = upper(?))";

    public static final String OBTENER_JEFE_SEDE =
        "call Pckg_Usuario.Sp_Obtener_Jefes_Por_Sede(?,?,?)";

    public static final String OBTENER_JEFE_DEPARTAMENTO =
        "call Pckg_Usuario.Sp_Obtener_Jefe_Departamento(?,?,?)";

    public static final String OBTENER_FUNCIONARIO =
        "select persona_id, nombre_persona, email, codi_jefe , usuario from xpersonas where estado='ACTIVO' and persona_id = '<idCliente>'";

    public static final String CARGAR_SALDO =
        "{ CALL siga01.tes_pagos_ingreso.cargar_saldo(?,?,?) }";

    public static final String OBTENER_TIPO_DOCTYPE =
        "CALL Pckg_General.Sp_Obtener_Lista_Tipo_Doc(?,?)";

    /////////////////////////////////////////////////////////////////////////////////////
    ////       ExpoFitoSanitario ////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////

    public static final String OBTENER_VARIEDAD_EXPORTACION =
        "{ CALL Pckg_Producto.Sp_Obtener_Variedad(?,?) }";
    public static final String OBTENER_SOLICITUD_EXPORTACION =
        "{ CALL SIIMF.PCKG_EXPORTACION.Sp_solicitud_exportacion(?,?) }";
    public static final String OBTENER_REQUISITOS_EXPOFITO =
        "{ CALL PCKG_REQUISITOS.Pr_Requisito_Expo(?,?,?,?,?,?,?) }";
    public static final String OBTENER_PROCEDIMIENTOS_ESPECIFICOS =
        "{ CALL Pckg_Cert_Fito_Exportacion.Sp_Tipo_Cert_Proc_Esp(?,?,?,?,?) }";
    public static final String CONSULTAR_CERTIFICADO_EXPO_FITO =
        "{ CALL Pckg_Cert_Fito_Exportacion.Sp_Consultar_Cert_Expo_Fito(?,?,?,?) }";
    public static final String EJECUTAR_SIIMF =
        "{ CALL pkg_bpm.bpm_genera_sol_exportacion(?,?,?) }";
    public static final String RESPUESTA_SIIMF =
        "{ CALL Pckg_Cert_Fito_Exportacion.Sp_Obtener_Certificado_Cerrado(?,?,?) }";
    //27/03/2012
    public static final String OBTENER_RUTA_SIIMF =
        "{ call Pckg_Requ_Sani_Exportacion.Sp_va_siimf(?,?,?) }";

    public static final String INSERTAR_CERTIFICADO_EXPO_FITO =
        "{ CALL Pckg_Cert_Fito_Exportacion.Sp_Insertar_Cert_Expo_Fito(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    //public static final String ACTUALIZAR_CERTIFICADO_EXPO_FITO =  "{ CALL Pckg_Cert_Fito_Exportacion.Sp_Obtener_Certificado_Cerrado(?,?,?,?,?,?,?,?) }";
    public static final String ACTUALIZAR_CERTIFICADO_EXPO_FITO =
        "{ CALL Pckg_Cert_Fito_Exportacion.Sp_Actualizar_Cert_Fito_Expo(?,?,?,?,?,?,?) }";
    public static final String ACTUALIZAR_CERTIFICADO_PRODUCTO_EXPO_FITO =
        "{ CALL Pckg_Cert_Fito_Exportacion.Sp_Act_Cert_Fito_Expo_Prod(?,?,?,?,?,?) }";
    public static final String ACTUALIZAR_CERTIFICADO_PRODUCTO_ANEXO_EXPO_FITO =
        "{ CALL Pckg_Cert_Fito_Exportacion.Sp_Act_Cert_Fito_Expo_Prod_Anx(?,?,?,?,?,?) }";

    /////////////////////////////////////////////////////////////////////////////////////////
    ////// CIERRE DE PROCESO ///////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    public static final String SOLICITUD_EN_ESPERA =
        "SELECT Pckg_Solicitud.Fn_Solicitud_En_Espera(?) FROM DUAL";
    /////////////////////////////////////////////////////////////////////////////////////////
    ////// REQUISITOS PROPIOS ///////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////
    public static final String OBTENER_REQUISITOS_PROPIOS =
        "{ CALL Pckg_Servicio.Sp_Obtener_Requsitos_Propios(?,?) }";
    //public static final String VALIDAR_REQUISITO_PROPIO =  "{? = call Pckg_Documento_Resolutivo.Fn_Validar_Documento(?,?,?,?) }";
    public static final String VALIDAR_REQUISITO_PROPIO =
        "{? = call pckg_documento_resolutivo.fn_validar_documento(?,?,?,?) }";

    public static final String OBTENER_LISTA_PREDIOS =
        "{ CALL Pckg_General.Sp_Obtener_Lista_Predios(?,?) }";


    /////////////////////////////////////////////////////////////////////////////////////////
    ////// GENERICOS ///////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    //public static final String GENERA_EXPEDIENTE_TMPDEF =  "{ CALL Pckg_Expediente.Sp_Generar_Codigo(?,?,?,?) }";
    public static final String GENERA_EXPEDIENTE_DEFINITIVO =
        "{ CALL Pckg_Expediente.Sp_Actualizar(?,?,?) }";
    public static final String GENERA_NUMERO_SOLICITUD =
        "{ CALL Pckg_Solicitud.Sp_Iniciar_Solicitud(?,?,?,?,?) }";

    public static final String REGISTRAR_TRAZABILIDAD =
        "{ CALL pckg_trazabilidad.Sp_Registrar(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
    public static final String ACTUALIZAR_TRAZABILIDAD =
        "{ CALL pckg_trazabilidad.Sp_Actualizar_Id(?,?) }";
    public static final String CONSULTA_TRAZA =
        "{ CALL pckg_trazabilidad.Sp_Consultar(?,?) }";
    public static final String GUARDAR_EXPEDIENTE_TMP =
        "{ CALL Pckg_Expediente.Sp_Registrar(?,?,?,?,?,?,?) }";
    public static final String ACTUALIZA_INDICADOR_BPM =
        "{CALL Pckg_Solicitud.Sp_Actualizar_Indicador_Bpm(?,?,?)}";

    public static final String CALCULAR_FECHA =
        "{ ?=call Pckg_Calculo_Dias.Calcular_Fecha(?,?,?,?)}";

    public static final String REGISTRAR_SERVICIO =
        "{ call Pckg_Expediente.Sp_Registrar_Servicio(?,?,?,?,?)}";

    /////////////////////////////////////////////////////////////////////////////////////////
    ////// REPORTES - CONSULTAS ///////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////

    public static final String CONSULTA_GENERAL =
        " select distinct(id_original),id_proceso,secuencial,fecha_hora,descripcion_asunto, remitente_entidad, remitente_persona, destinatario_entidad, destinatario_persona,accion,estado_traza,fech_crea from trazabilidad t where t.id_proceso= 'STD' %filter% ";

    /////////////////////////////////////////////////////////////////////////////////////////
    ////// GRABAR NUEVO PFI ///////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////
    public static final String REGISTRAR_PERMISO_PFI =
        "{ call Pckg_Permiso_Fito_Impo.Sp_Registrar_Permiso(?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String REGISTRAR_PRODUCTO_PFI =
        "{ call Pckg_Permiso_Fito_Impo.Sp_Registrar_Producto(?,?,?,?,?,?,?,?,?,?)}";
    //Obtener Periodo CPE 19/10/2011
    public static final String OBTENER_PERIODO_CPE =
        "{ call Pckg_Requ_Sani_importacion.Sp_Obtener_Periodo_Inspeccion(?,?)}";
    public static final String OBTENER_CODIGO_REQU_IMP_PRODUCTO =
        "{ ?= call Pckg_Requisitos.Fn_Obtener_Cod_Requ_Impo_Prod(?,?,?,?,?,?)}";
    public static final String REGISTRAR_PTO_INGRESO_PFI =
        "{ call Pckg_Permiso_Fito_Impo.Sp_Registrar_Punto_Ingreso(?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String REGISTRAR_PAIS_ORIGEN_PFI =
        "{ call Pckg_Permiso_Fito_Impo.Sp_Registrar_Pais_Origen(?,?,?,?,?,?)}";
    public static final String REGISTRAR_LUGAR_PRODUCCION_PFI =
        "{ call Pckg_Permiso_Fito_Impo.Sp_Registrar_Lugar_Produccion(?,?,?,?,?,?)}";
    public static final String REGISTRAR_PRODUCTO_ANEXO =
        "{ call Pckg_Permiso_Fito_Impo.Sp_Registrar_Producto_Anexo(?,?,?,?,?,?,?,?,?,?)}";

    public static final String GENERA_CERTIFICADO_PZI =
        "{ ?=call Pckg_Permiso_Zoo_Impo.Fn_Generar_Numero_Permiso(?)}";
    public static final String VALIDAR_CONEXION_DB =
        "{ ?=call Pckg_Seguridad.Fn_Validar_Conexion_Bd(?,?) }";
    public static final String OBTENER_FIRMA =
        "{ ?=call Pckg_Servicio.Fn_Obtener_Firma(?,?,?) }";
    public static final String CREAR_DOCUMENTO =
        "{ ?=call Pckg_Documento_STD.Fn_Crear_Documento(?,?,?,?) }";
    public static final String ELIMINAR_DOCUMENTO =
        "{ call Pckg_Documento_STD.Sp_Eliminar_Documento(?) }";

    public static final String PAGOS_OBTENERNOMBRESERVICIO =
        "select descripcion_servicio from servicio_tupa where codigo_servicio = ? ";
    public static final String VERIFICA_NUMEROBOLETA =
        "{ ?=call Pckg_Recibo.Sp_Verificar_Existe_Boleta(?)}";
    public static final String VERIFICAR_ESTADO_PERMISO =
        "{ ?=call Pckg_Inspeccion.Fn_Verificar_Estado_Permiso(?)}";
    public static final String CALCULAR_FECHA_AMPLIACION =
        "{ call Pckg_Calculo_Dias.Calcular_Dias(?,?,?,?)}";

    //PFI Indices:

    public static final String OBTENER_REQPROD_AUTORIZACION =
        "{ ?=call Pckg_Requ_Sani_Importacion.Fn_Obtener_Ind_Autorizacion(?)}";
    public static final String OBTENER_REQPROD_CPE =
        "{ ?=call Pckg_Requ_Sani_Importacion.Fn_Obtener_Ind_Cpe(?)}";

    ///////////////////////////////////////////////////////////////////////////////////////
    ////////// SENTENCIAS METODOS VUCE ////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    public static final String OBTENER_DATOS_GUARDACUSTODIA =
        "{call Pckg_Registro_Guardacustodia.Sp_Consultar_Reg_Guard(?,?,?)}";
    public static final String OBTENER_DATOS_PFTI =
        "{call Pckg_Permiso_Fito_Tran.Sp_Consultar_PFTI(?,?,?,?,?,?,?)}";
    public static final String OBTENER_DATOS_AUTORIZACION_ESTABLECIMIENTO =
        "{call Pckg_Registros.Sp_Obtener_Recinto_Estab(?,?,?,?)}";
    public static final String OBTENER_CODIGO_FORMATO_DOCUMENTO =
        "select cod_formato from vuce.documento where doc_ref_numero=?";

    //////////////////////////// OBTENER DATOS PFI VUCE ///////////////////////
    public static final String OBTENER_DATOS_PFI_X_EXPEDIENTE =
        "select pfi.codigo_expediente,pfi.numero_permiso,pfi.centro_tramite_solicitud,ct.descripcion_centro_tramite,pfi.url_pfi_definitivo,\n" +
        "pfi.indicador_ampliacion,pfi.fecha_emision,pfi.codigo_requ_impo_producto,pfi.periodo_vegetativo,pfi.numero_inspecciones \n" +
        "from permiso_pfi pfi left join centro_tramite ct\n" +
        "on pfi.centro_tramite_solicitud=ct.codigo_centro_tramite\n" +
        "where pfi.codigo_expediente = ?";
    
  public static final String OBTENER_DATOS_PFI_X_EXPEDIENTEII =
      "select pfi.codigo_expediente,pfi.numero_permiso,pfi.centro_tramite_solicitud,ct.descripcion_centro_tramite,pfi.url_pfti_definitivo,\n" + 
      "pfi.indicador_ampliacion,pfi.fecha_emision,pfi.codigo_requ_tran_producto,pfi.periodo_vegetativo,pfi.numero_inspecciones \n" + 
      "from permiso_pfti pfi left join centro_tramite ct\n" + 
      "on pfi.centro_tramite_solicitud=ct.codigo_centro_tramite\n" + 
      "where pfi.codigo_expediente = ?";
    

    public static final String OBTENER_PTOS_INGRESO_PRODUCTO_PFI_VUCE =
        "select distinct pc.codigo_centro_tramite,ct.descripcion_centro_tramite from permiso_pfi_producto_ct pc \n" +
        "inner join centro_tramite ct \n" +
        "on pc.codigo_centro_tramite=ct.codigo_centro_tramite\n" +
        "where pc.numero_permiso = ?";
    
  public static final String OBTENER_PTOS_INGRESO_PRODUCTO_PFI_VUCEII =
      "select distinct pc.codigo_centro_tramite_ing,ct.descripcion_centro_tramite from permiso_pfti_producto_ct pc \n" + 
      "inner join centro_tramite ct\n" + 
      "on pc.codigo_centro_tramite_ing=ct.codigo_centro_tramite\n" + 
      "where pc.numero_permiso =?";

    public static final String OBTENER_PAIS_ORIGEN_PRODUCTO_PFI_VUCE =
        "select distinct po.codi_pais_tpa_origen,tp.nomb_pais_tpa,po.codigo_lugar_produccion,lp.descripcion_lugar_produccion from permiso_pfi_pais_origen po\n" +
        "inner join siga.tpaises tp\n" +
        "on po.codi_pais_tpa_origen=tp.codi_pais_tpa\n" +
        "left join lugar_produccion lp\n" +
        "on po.codigo_lugar_produccion=lp.codigo_lugar_produccion\n" +
        "where po.numero_permiso = ?";

  public static final String OBTENER_PAIS_ORIGEN_PRODUCTO_PFI_VUCEII =
      "select distinct po.codi_pais_tpa_origen,tp.nomb_pais_tpa,po.codigo_lugar_produccion,lp.descripcion_lugar_produccion from permiso_pfti_pais_origen po\n" + 
      "inner join siga.tpaises tp\n" + 
      "on po.codi_pais_tpa_origen=tp.codi_pais_tpa\n" + 
      "left join lugar_produccion lp\n" + 
      "on po.codigo_lugar_produccion=lp.codigo_lugar_produccion\n" + 
      "where po.numero_permiso = ?";


    ////////////////////////OBTENER DATOS PZI VUCE ///////////////////////////////////////////////////////////////
    public static final String OBTENER_DATOS_PZI_X_EXPEDIENTE =
        "select pzi.codigo_expediente as folio,pzi.numero_permiso as nocertificado,pzi.url_pzi_definitivo,\n" +
        "pzi.centro_tramite_llegada,pzi.fecha_probable_arribo,pzi.codigo_puerto,pzi.fecha_probable_embarque,\n" +
        "pzi.centro_tramite_solicitud,ct.descripcion_centro_tramite,pzi.indicador_ampliacion,pzi.fecha_emision,pzi.codigo_requ_impo_producto\n" +
        "from permiso_pzi pzi left join centro_tramite ct\n" +
        "on pzi.centro_tramite_solicitud=ct.codigo_centro_tramite\n" +
        "where pzi.codigo_expediente = ? ";

    public static final String OBTENER_PTOS_INGRESO_PRODUCTO_PZI_VUCE =
        "select distinct pc.codigo_centro_tramite,ct.descripcion_centro_tramite from permiso_pzi_producto_ct pc \n" +
        "inner join centro_tramite ct \n" +
        "on pc.codigo_centro_tramite=ct.codigo_centro_tramite\n" +
        "where pc.numero_permiso = ?";

    public static final String OBTENER_PAIS_ORIGEN_PRODUCTO_PZI_VUCE =
        "select distinct po.codi_pais_tpa_origen,tp.nomb_pais_tpa from permiso_pzi_pais_origen po\n" +
        "inner join siga.tpaises tp \n" +
        "on po.codi_pais_tpa_origen=tp.codi_pais_tpa \n" +
        "where po.numero_permiso = ?";

    public static final String OBTENER_RECIBO_VUCE =
        "{ CALL vuce.Pckg_Bpm_Recibo.Sp_Obtener_Datos_Recibo(?,?,?,?,?) }";

    public static final String OBTENER_REQUISITOS_IMPO_FITO_TRAN =
        "{ call Pckg_Requisitos.Pr_Requisito_Transito(?,?,?,?,?,?,?,?) }";

    public static final String BUSCAR_USUARIO_PREDICTIVO =
        "{CALL finalbpm.Pckg_Usuario.Sp_Buscar_Usuario_Predictivo(?,?)}";

    public static final String BUSCAR_USUARIO_DESTINATARIO =
        "{CALL finalbpm.Pckg_Grabar.Sp_Buscar_Destinatario(?,?,?)}";

    public static final String BUSCAR_ASISTENTES =
        "{CALL Finalbpm.Pckg_Bpm_asistentes.sp_obtener_asistente(?,?)}";


//////////////////////////////////////////////////////USUARIO POR DIRECTORIO////////////////////////////////////////////////
    
     public static final String DIRECTORIO_POR_USUARIO =
        "{CALL Finalbpm.Pckg_Soporte_Ldap.Sp_Obtener_Usuarios_Grupos(?,?)}";   
    
 	 //PSIFUENTES 13/08/2015
     
     public static final String CARGAR_DATOS_PFTI =
     "{call Pckg_Permiso_Fito_Tran.Sp_Obtener_Pfti(?,?,?,?,?,?,?,?)}";
    
/////////////////////////////////////////////////////////////////////////////////////
////  Certificado Fitosanitario Lugar de Produccion o su Modificacion///////////////
///////////////////////////////////////////////////////////////////////////////////
    public static final String REGISTRAR_SOLI_LUGAR_PRODUCCION = "{ call finalbpm.PCKG_CERT_LUGAR_PROD.Sp_Registrar_Soli_Lug_Prod(?, ?, ?) }";
/////////////////////////////////////////////////////////////////////////////////////

    public static final String OBTENER_UCMID_POR_EXPEDIENTE = "{ call finalbpm.pckg_general.sp_obtener_ucm_iiv(?,?) }";
    
  /////////////////////////////////////////////////////////////////////////////////////////////////////   
  ////////////////////////////////////////Certificado de Plantas/////////////////////////////////////////
  ////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String REGISTRAR_PLANTAS = "{ call finalbpm.PCKG_BPM_PLANTA.Sp_Reg_Solic_Planta(?, ?, ?) }";
    
    
  public static final String ACTUALIZAR_CODIGO_TUPA_CPE = "{ call FINALBPM.Pckg_Registro_Cpe_Fito.Sp_Update_vuce_codproctupa(?, ?, ?) }";
  
  public static final String ADJUNTAR_DOCUMENTOS_PRESENTADOS ="{?= call VUCE.Pckg_Gestion_Documento.Fn_Activar(?)}";
  
    /////////////////////////////////////////////// FIRMA ELECTRONICA //////////////////////////////////////////////////
    public static final String OBTENER_PASSWORD_FIRMANTE_ELECTRONICO =
        "{ call FINALBPM.Pckg_Firma_Electronica.sp_obtener_password_firmador(?, ?) }";

    /////////////////////////////////////////////// DOCUMENTO STD //////////////////////////////////////////////////
    public static final String GRABAR_DOCUMENTO_STD_HIJO =
        "{ call FINALBPM.PCKG_GRABAR.Sp_Grabar_Std_Documento_Hijo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

    public static final String OBTENER_COD_DOCUMENTO_STD_PADRE =
        "{ call FINALBPM.PCKG_GRABAR.Sp_Get_Cod_Documento_Std_Padre(?,?)}";
  
   public static final String VALIDAR_CONFIDENCIAL01 ="{call FINALBPM.Pckg_Documento_Std.Sp_Info_Documento(?,?)}"; 
  
  public static final String VALIDAR_CONFIDENCIAL02 ="{?= call FINALBPM.Pckg_Documento_STD.Fn_Consultar_Participacion(?,?)}"; 
  
  
  
  
  


public static String con;
}
