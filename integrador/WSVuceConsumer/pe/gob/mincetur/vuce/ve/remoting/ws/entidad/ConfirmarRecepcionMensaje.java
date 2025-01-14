
package pe.gob.mincetur.vuce.ve.remoting.ws.entidad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para confirmarRecepcionMensaje complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="confirmarRecepcionMensaje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTransaccion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="error" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="errores" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmarRecepcionMensaje", propOrder = {
    "idTransaccion",
    "error",
    "errores"
})
public class ConfirmarRecepcionMensaje {

    protected int idTransaccion;
    protected int error;
    protected String errores;

    /**
     * Obtiene el valor de la propiedad idTransaccion.
     * 
     */
    public int getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Define el valor de la propiedad idTransaccion.
     * 
     */
    public void setIdTransaccion(int value) {
        this.idTransaccion = value;
    }

    /**
     * Obtiene el valor de la propiedad error.
     * 
     */
    public int getError() {
        return error;
    }

    /**
     * Define el valor de la propiedad error.
     * 
     */
    public void setError(int value) {
        this.error = value;
    }

    /**
     * Obtiene el valor de la propiedad errores.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrores() {
        return errores;
    }

    /**
     * Define el valor de la propiedad errores.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrores(String value) {
        this.errores = value;
    }

}
