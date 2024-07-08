UPDATE VUCE.PROCESO_BPM_WS
SET   
       WSDL_PROCESO_BPM         = 'http://srvvldsoabpm.senasa.gob.pe:7011/soa-infra/services/BPM_SENASA/BpmTUPA/IniciarSolicitudCanalVUCE.service?WSDL',
       PROCESO_BPM_PROXY_CLASE  = 'com.oracle.bpmn.process.bpmtupa.IniciarSolicitudCanalVUCEService',
       PROCESO_BPM_PROXY_METODO = 'start'
WHERE  ID                       =  'SOLTUPA';

-- LIMPIAR COLAS
DECLARE
po dbms_aqadm.aq$_purge_options_t;
BEGIN
    DBMS_AQADM.PURGE_QUEUE_TABLE(
        queue_table => 'Q_NOTIF_VUCE',
        purge_condition => NULL, -- Si se especifica NULL, se purga toda la cola
        purge_options => po
    );
END;
/

DECLARE
po dbms_aqadm.aq$_purge_options_t;
BEGIN
    DBMS_AQADM.PURGE_QUEUE_TABLE(
        queue_table => 'Q_NOTIF_VUCE_04',
        purge_condition => NULL, -- Si se especifica NULL, se purga toda la cola
        purge_options => po
    );
END;
/
---------------------------------------------------------------------------------

DECLARE 
  P_FORMATO VARCHAR2(32767);
  P_COD_SERVICIO VARCHAR2(32767);
  P_NUMERO_DOCUMENTO VARCHAR2(32767);
  P_NUMERO_DOCUMENTO_REF VARCHAR2(32767);

BEGIN 
  P_FORMATO := 'SNS022';
  P_COD_SERVICIO := '014';
  P_NUMERO_DOCUMENTO := '220210003319';
  P_NUMERO_DOCUMENTO_REF := 'O2022197788';

  VUCE.PCKG_COLA_PROCESO_BPM.SP_INSTANCIAR_PROCESO ( P_FORMATO, P_COD_SERVICIO, P_NUMERO_DOCUMENTO, P_NUMERO_DOCUMENTO_REF );
  COMMIT; 
END; 
