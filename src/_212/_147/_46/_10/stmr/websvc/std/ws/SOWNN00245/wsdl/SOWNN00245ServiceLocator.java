/**
 * SOWNN00245ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl;

public class SOWNN00245ServiceLocator extends org.apache.axis.client.Service implements _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245Service {

    public SOWNN00245ServiceLocator() {
    }


    public SOWNN00245ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SOWNN00245ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SOWNN00245Port
    private java.lang.String SOWNN00245Port_address = "http://10.46.147.212:3002/stmr/websvc/std/ws";

    public java.lang.String getSOWNN00245PortAddress() {
        return SOWNN00245Port_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SOWNN00245PortWSDDServiceName = "SOWNN00245Port";

    public java.lang.String getSOWNN00245PortWSDDServiceName() {
        return SOWNN00245PortWSDDServiceName;
    }

    public void setSOWNN00245PortWSDDServiceName(java.lang.String name) {
        SOWNN00245PortWSDDServiceName = name;
    }

    public _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245PortType getSOWNN00245Port() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SOWNN00245Port_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOWNN00245Port(endpoint);
    }

    public _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245PortType getSOWNN00245Port(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245BindingStub _stub = new _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245BindingStub(portAddress, this);
            _stub.setPortName(getSOWNN00245PortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSOWNN00245PortEndpointAddress(java.lang.String address) {
        SOWNN00245Port_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (_212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245BindingStub _stub = new _212._147._46._10.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245BindingStub(new java.net.URL(SOWNN00245Port_address), this);
                _stub.setPortName(getSOWNN00245PortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SOWNN00245Port".equals(inputPortName)) {
            return getSOWNN00245Port();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://10.46.147.212:3002/stmr/websvc/std/ws/SOWNN00245/wsdl", "SOWNN00245Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://10.46.147.212:3002/stmr/websvc/std/ws/SOWNN00245/wsdl", "SOWNN00245Port"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SOWNN00245Port".equals(portName)) {
            setSOWNN00245PortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
