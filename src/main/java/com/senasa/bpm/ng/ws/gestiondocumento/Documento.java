package com.senasa.bpm.ng.ws.gestiondocumento;

public class Documento  implements java.io.Serializable {
	
    private java.lang.String id;

    private java.lang.String nombre;

    private java.lang.String url;

    private Version[] versiones;
    
    private String confidencial;

    public Documento() {
    }

    public Documento(
           java.lang.String id,
           java.lang.String nombre,
           java.lang.String url,
           java.lang.String confidencial,
           Version[] versiones) {
           this.id = id;
           this.nombre = nombre;
           this.url = url;
           this.versiones = versiones;
           this.confidencial = confidencial;
    }


    /**
     * Gets the id value for this Documento.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Documento.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the nombre value for this Documento.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Documento.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the url value for this Documento.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this Documento.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }


    /**
     * Gets the versiones value for this Documento.
     * 
     * @return versiones
     */
    public Version[] getVersiones() {
        return versiones;
    }


    /**
     * Sets the versiones value for this Documento.
     * 
     * @param versiones
     */
    public void setVersiones(Version[] versiones) {
        this.versiones = versiones;
    }

    public Version getVersiones(int i) {
        return this.versiones[i];
    }

    public void setVersiones(int i, Version _value) {
        this.versiones[i] = _value;
    }
    
    /**
     * Gets the confidencial value for this Documento.
     * 
     * @return confidencial
     */
    public java.lang.String getConfidencial() {
        return confidencial;
    }
  
  
    /**
     * Sets the confidencial value for this Documento.
     * 
     * @param confidencial
     */
    public void setConfidencial(java.lang.String confidencial) {
        this.confidencial = confidencial;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Documento)) return false;
        Documento other = (Documento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl()))) &&
            ((this.confidencial==null && other.getConfidencial()==null) || 
             (this.confidencial!=null &&
              this.confidencial.equals(other.getConfidencial()))) &&
            ((this.versiones==null && other.getVersiones()==null) || 
             (this.versiones!=null &&
              java.util.Arrays.equals(this.versiones, other.getVersiones())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        if (getConfidencial() != null) {
            _hashCode += getConfidencial().hashCode();
        }
        if (getVersiones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVersiones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVersiones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Documento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://gestiondocumento.ws.senasa.gob.pe", "documento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confidencial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "confidencial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("versiones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "versiones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://gestiondocumento.ws.senasa.gob.pe", "version"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
