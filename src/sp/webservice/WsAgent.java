/**
 * WsAgent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sp.webservice;

public interface WsAgent extends javax.xml.rpc.Service {
    public java.lang.String getWsAgentHttpSoap12EndpointAddress();

    public sp.webservice.WsAgentPortType getWsAgentHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException;

    public sp.webservice.WsAgentPortType getWsAgentHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getWsAgentHttpSoap11EndpointAddress();

    public sp.webservice.WsAgentPortType getWsAgentHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public sp.webservice.WsAgentPortType getWsAgentHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
