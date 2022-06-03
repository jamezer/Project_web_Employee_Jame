package org.tempuri;

public class Service_V2SoapProxy implements org.tempuri.Service_V2Soap {
  private String _endpoint = null;
  private org.tempuri.Service_V2Soap service_V2Soap = null;
  
  public Service_V2SoapProxy() {
    _initService_V2SoapProxy();
  }
  
  public Service_V2SoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initService_V2SoapProxy();
  }
  
  private void _initService_V2SoapProxy() {
    try {
      service_V2Soap = (new org.tempuri.Service_V2Locator()).getService_V2Soap();
      if (service_V2Soap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)service_V2Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)service_V2Soap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (service_V2Soap != null)
      ((javax.xml.rpc.Stub)service_V2Soap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.Service_V2Soap getService_V2Soap() {
    if (service_V2Soap == null)
      _initService_V2SoapProxy();
    return service_V2Soap;
  }
  
  public org.tempuri.AuthenResponse authen(org.tempuri.AuthenRequest authenRequest) throws java.rmi.RemoteException{
    if (service_V2Soap == null)
      _initService_V2SoapProxy();
    return service_V2Soap.authen(authenRequest);
  }
  
  
}