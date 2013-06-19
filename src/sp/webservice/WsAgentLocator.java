/**
 * WsAgentLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sp.webservice;

public class WsAgentLocator extends org.apache.axis.client.Service implements sp.webservice.WsAgent {

    public WsAgentLocator() {
    }


    public WsAgentLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsAgentLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WsAgentHttpSoap12Endpoint
    private java.lang.String WsAgentHttpSoap12Endpoint_address = "http://172.168.1.103:8080/pktws/services/WsAgent.WsAgentHttpSoap12Endpoint/";

    public java.lang.String getWsAgentHttpSoap12EndpointAddress() {
        return WsAgentHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WsAgentHttpSoap12EndpointWSDDServiceName = "WsAgentHttpSoap12Endpoint";

    public java.lang.String getWsAgentHttpSoap12EndpointWSDDServiceName() {
        return WsAgentHttpSoap12EndpointWSDDServiceName;
    }

    public void setWsAgentHttpSoap12EndpointWSDDServiceName(java.lang.String name) {
        WsAgentHttpSoap12EndpointWSDDServiceName = name;
    }

    public sp.webservice.WsAgentPortType getWsAgentHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WsAgentHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWsAgentHttpSoap12Endpoint(endpoint);
    }

    public sp.webservice.WsAgentPortType getWsAgentHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sp.webservice.WsAgentSoap12BindingStub _stub = new sp.webservice.WsAgentSoap12BindingStub(portAddress, this);
            _stub.setPortName(getWsAgentHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWsAgentHttpSoap12EndpointEndpointAddress(java.lang.String address) {
        WsAgentHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for WsAgentHttpSoap11Endpoint
    private java.lang.String WsAgentHttpSoap11Endpoint_address = "http://172.168.1.103:8080/pktws/services/WsAgent.WsAgentHttpSoap11Endpoint/";

    public java.lang.String getWsAgentHttpSoap11EndpointAddress() {
        return WsAgentHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WsAgentHttpSoap11EndpointWSDDServiceName = "WsAgentHttpSoap11Endpoint";

    public java.lang.String getWsAgentHttpSoap11EndpointWSDDServiceName() {
        return WsAgentHttpSoap11EndpointWSDDServiceName;
    }

    public void setWsAgentHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        WsAgentHttpSoap11EndpointWSDDServiceName = name;
    }

    public sp.webservice.WsAgentPortType getWsAgentHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WsAgentHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWsAgentHttpSoap11Endpoint(endpoint);
    }

    public sp.webservice.WsAgentPortType getWsAgentHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            sp.webservice.WsAgentSoap11BindingStub _stub = new sp.webservice.WsAgentSoap11BindingStub(portAddress, this);
            _stub.setPortName(getWsAgentHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWsAgentHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        WsAgentHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (sp.webservice.WsAgentPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                sp.webservice.WsAgentSoap12BindingStub _stub = new sp.webservice.WsAgentSoap12BindingStub(new java.net.URL(WsAgentHttpSoap12Endpoint_address), this);
                _stub.setPortName(getWsAgentHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (sp.webservice.WsAgentPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                sp.webservice.WsAgentSoap11BindingStub _stub = new sp.webservice.WsAgentSoap11BindingStub(new java.net.URL(WsAgentHttpSoap11Endpoint_address), this);
                _stub.setPortName(getWsAgentHttpSoap11EndpointWSDDServiceName());
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
        if ("WsAgentHttpSoap12Endpoint".equals(inputPortName)) {
            return getWsAgentHttpSoap12Endpoint();
        }
        else if ("WsAgentHttpSoap11Endpoint".equals(inputPortName)) {
            return getWsAgentHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.sp", "WsAgent");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.sp", "WsAgentHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://webservice.sp", "WsAgentHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WsAgentHttpSoap12Endpoint".equals(portName)) {
            setWsAgentHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("WsAgentHttpSoap11Endpoint".equals(portName)) {
            setWsAgentHttpSoap11EndpointEndpointAddress(address);
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
