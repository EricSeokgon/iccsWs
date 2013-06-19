/**
 * RequestTypeDATAMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl;

public class RequestTypeDATAMessage  implements java.io.Serializable {
    private _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestTypeDATAMessageBody body;

    public RequestTypeDATAMessage() {
    }

    public RequestTypeDATAMessage(
           _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestTypeDATAMessageBody body) {
           this.body = body;
    }


    /**
     * Gets the body value for this RequestTypeDATAMessage.
     * 
     * @return body
     */
    public _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestTypeDATAMessageBody getBody() {
        return body;
    }


    /**
     * Sets the body value for this RequestTypeDATAMessage.
     * 
     * @param body
     */
    public void setBody(_212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestTypeDATAMessageBody body) {
        this.body = body;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestTypeDATAMessage)) return false;
        RequestTypeDATAMessage other = (RequestTypeDATAMessage) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody())));
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
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestTypeDATAMessage.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.46.147.212:3002/stmr/websvc/std/ws/SOWNN00245/wsdl", ">>RequestType>DATA>message"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("", "body"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.46.147.212:3002/stmr/websvc/std/ws/SOWNN00245/wsdl", ">>>RequestType>DATA>message>body"));
        elemField.setNillable(false);
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
