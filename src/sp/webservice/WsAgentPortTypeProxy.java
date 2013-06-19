package sp.webservice;

public class WsAgentPortTypeProxy implements sp.webservice.WsAgentPortType {
  private String _endpoint = null;
  private sp.webservice.WsAgentPortType wsAgentPortType = null;
  
  public WsAgentPortTypeProxy() {
    _initWsAgentPortTypeProxy();
  }
  
  public WsAgentPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsAgentPortTypeProxy();
  }
  
  private void _initWsAgentPortTypeProxy() {
    try {
      wsAgentPortType = (new sp.webservice.WsAgentLocator()).getWsAgentHttpSoap11Endpoint();
      if (wsAgentPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsAgentPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsAgentPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsAgentPortType != null)
      ((javax.xml.rpc.Stub)wsAgentPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public sp.webservice.WsAgentPortType getWsAgentPortType() {
    if (wsAgentPortType == null)
      _initWsAgentPortTypeProxy();
    return wsAgentPortType;
  }
  
  public sp.webservice.xsd.WsData select(java.lang.String s) throws java.rmi.RemoteException{
    if (wsAgentPortType == null)
      _initWsAgentPortTypeProxy();
    return wsAgentPortType.select(s);
  }
  
  public java.lang.String[] sel(java.lang.String key, java.lang.String s) throws java.rmi.RemoteException{
    if (wsAgentPortType == null)
      _initWsAgentPortTypeProxy();
    return wsAgentPortType.sel(key, s);
  }
  
  public java.lang.String excute(java.lang.String key, java.lang.String s) throws java.rmi.RemoteException{
    if (wsAgentPortType == null)
      _initWsAgentPortTypeProxy();
    return wsAgentPortType.excute(key, s);
  }
  
  
}