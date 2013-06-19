package localhost.stmr.websvc.std.ws.SOWNN00245.wsdl;

public class SOWNN00245PortTypeProxy implements localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245PortType {
  private String _endpoint = null;
  private localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245PortType sOWNN00245PortType = null;
  
  public SOWNN00245PortTypeProxy() {
    _initSOWNN00245PortTypeProxy();
  }
  
  public SOWNN00245PortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOWNN00245PortTypeProxy();
  }
  
  private void _initSOWNN00245PortTypeProxy() {
    try {
      sOWNN00245PortType = (new localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245ServiceLocator()).getSOWNN00245Port();
      if (sOWNN00245PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOWNN00245PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOWNN00245PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOWNN00245PortType != null)
      ((javax.xml.rpc.Stub)sOWNN00245PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.SOWNN00245PortType getSOWNN00245PortType() {
    if (sOWNN00245PortType == null)
      _initSOWNN00245PortTypeProxy();
    return sOWNN00245PortType;
  }
  
  public localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.ResponseType SOWNN00214(localhost.stmr.websvc.std.ws.SOWNN00245.wsdl.RequestType DOCUMENT) throws java.rmi.RemoteException{
    if (sOWNN00245PortType == null)
      _initSOWNN00245PortTypeProxy();
    return sOWNN00245PortType.SOWNN00214(DOCUMENT);
  }
  
  
}