package pe.gob.senasa.bean;

import java.io.Serializable;


public class DatosIIV  implements Serializable{
    public DatosIIV() {
        super();
    }
    private Persona solicitante ;
    private Persona repLegal ;
    private Persona agente ;
    private String numPFI;
    private String numPFTI;
    private String numPZI;
    private String codPaisDestino;
    private String descPaisDestino;
    private String codPaisProc;
    private String descPaisProc;
    private String codPtoIngreso;
    private String descPtoIngreso;
    private String codPtoSalida;
    private String descPtoSalida;
    private String codLugInspeccion;
    private String descLugInspeccion;  
    private String descLugProduccion;
    private String numDocEmb;
    private String numCPE;
    private String numGCUSTODIA;
    private String numGERMOPLASMA;
    private String codUsoDestino;
    private String descUsoDestino;
    private PaisesOrigen paisesOrigen= new PaisesOrigen();
    private ProductosIIV productos = new ProductosIIV();

    public void setSolicitante(Persona solicitante) {
        this.solicitante = solicitante;
    }

    public Persona getSolicitante() {
        return solicitante;
    }

    public void setRepLegal(Persona repLegal) {
        this.repLegal = repLegal;
    }

    public Persona getRepLegal() {
        return repLegal;
    }

    public void setAgente(Persona agente) {
        this.agente = agente;
    }

    public Persona getAgente() {
        return agente;
    }

    public void setNumPFI(String numPFI) {
        this.numPFI = numPFI;
    }

    public String getNumPFI() {
        return numPFI;
    }

    public void setNumPFTI(String numPFTI) {
        this.numPFTI = numPFTI;
    }

    public String getNumPFTI() {
        return numPFTI;
    }

    public void setNumPZI(String numPZI) {
        this.numPZI = numPZI;
    }
  
    public String getNumPZI() {
        return numPZI;
    }
  
    public void setCodPaisDestino(String codPaisDestino) {
        this.codPaisDestino = codPaisDestino;
    }

    public String getCodPaisDestino() {
        return codPaisDestino;
    }

    public void setDescPaisDestino(String descPaisDestino) {
        this.descPaisDestino = descPaisDestino;
    }

    public String getDescPaisDestino() {
        return descPaisDestino;
    }

    public void setCodPaisProc(String codPaisProc) {
        this.codPaisProc = codPaisProc;
    }

    public String getCodPaisProc() {
        return codPaisProc;
    }

    public void setDescPaisProc(String descPaisProc) {
        this.descPaisProc = descPaisProc;
    }

    public String getDescPaisProc() {
        return descPaisProc;
    }

    public void setCodPtoIngreso(String codPtoIngreso) {
        this.codPtoIngreso = codPtoIngreso;
    }

    public String getCodPtoIngreso() {
        return codPtoIngreso;
    }

    public void setDescPtoIngreso(String descPtoIngreso) {
        this.descPtoIngreso = descPtoIngreso;
    }

    public String getDescPtoIngreso() {
        return descPtoIngreso;
    }

    public void setCodPtoSalida(String codPtoSalida) {
        this.codPtoSalida = codPtoSalida;
    }

    public String getCodPtoSalida() {
        return codPtoSalida;
    }

    public void setDescPtoSalida(String descPtoSalida) {
        this.descPtoSalida = descPtoSalida;
    }

    public String getDescPtoSalida() {
        return descPtoSalida;
    }

    public void setCodLugInspeccion(String codLugInspeccion) {
        this.codLugInspeccion = codLugInspeccion;
    }

    public String getCodLugInspeccion() {
        return codLugInspeccion;
    }

    public void setDescLugInspeccion(String descLugInspeccion) {
        this.descLugInspeccion = descLugInspeccion;
    }

    public String getDescLugInspeccion() {
        return descLugInspeccion;
    }

    public void setDescLugProduccion(String descLugProduccion) {
        this.descLugProduccion = descLugProduccion;
    }
  
    public String getDescLugProduccion() {
        return descLugProduccion;
    }
    public void setNumDocEmb(String numDocEmb) {
        this.numDocEmb = numDocEmb;
    }

    public String getNumDocEmb() {
        return numDocEmb;
    }

    public void setNumCPE(String numCPE) {
        this.numCPE = numCPE;
    }

    public String getNumCPE() {
        return numCPE;
    }

    public void setNumGCUSTODIA(String numGCUSTODIA) {
        this.numGCUSTODIA = numGCUSTODIA;
    }

    public String getNumGCUSTODIA() {
        return numGCUSTODIA;
    }

    public void setNumGERMOPLASMA(String numGERMOPLASMA) {
        this.numGERMOPLASMA = numGERMOPLASMA;
    }

    public String getNumGERMOPLASMA() {
        return numGERMOPLASMA;
    }



    public void setPaisesOrigen(PaisesOrigen paisesOrigen) {
        this.paisesOrigen = paisesOrigen;
    }

    public PaisesOrigen getPaisesOrigen() {
        return paisesOrigen;
    }

   public void setProductos(ProductosIIV productos) {
        this.productos = productos;
    }

    public ProductosIIV getProductos() {
        return productos;
    }


    public void setCodUsoDestino(String codUsoDestino) {
        this.codUsoDestino = codUsoDestino;
    }

    public String getCodUsoDestino() {
        return codUsoDestino;
    }

    public void setDescUsoDestino(String descUsoDestino) {
        this.descUsoDestino = descUsoDestino;
    }

    public String getDescUsoDestino() {
        return descUsoDestino;
    }
}
