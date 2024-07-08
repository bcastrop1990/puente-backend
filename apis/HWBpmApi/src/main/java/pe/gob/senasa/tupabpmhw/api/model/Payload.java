package pe.gob.senasa.tupabpmhw.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payload {
    
    private String numeroSolicitud;
    private String numeroExpediente;
    private String estadoSolicitud;
    private String estadoExpediente;
    private String codigoSede;
    private String codigoCentroTramite;
    private String codigoProcedimiento;
    private String codigoClase;
    private boolean flagRequiereInspeccion;
    private boolean flagModificacionCertificado;
    private int canal;
    private String usuarioMesaPartes;
    private String usuarioResponsable;
    private String codigoRecibo;
    private String codigostddoc;
    private String descripcionservicio;
    private String nombreResponsable;
    private int secuencial;
    private String plazo;
    private String areaRemitente;
    private String subAreaRemitente;
    private String usuarioDestinatario;
    private String nombreDestinatario;
    private String areaDestinatario;
    private String subAreaDestinatario;
    private String observaciones;
    private String ucmidDerivacion;
    protected String cfeUcmId;
    protected String cfeNombre;
    List<DocumentoAdjunto> documentos;    
            	    
}
