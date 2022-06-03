/**
 * Service_V2Locator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class Service_V2Locator extends org.apache.axis.client.Service implements org.tempuri.Service_V2 {

    public Service_V2Locator() {
    }


    public Service_V2Locator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Service_V2Locator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Service_V2Soap
    private java.lang.String Service_V2Soap_address = "http://10.50.90.92/hrauthen/service_v2.asmx";

    public java.lang.String getService_V2SoapAddress() {
        return Service_V2Soap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Service_V2SoapWSDDServiceName = "Service_V2Soap";

    public java.lang.String getService_V2SoapWSDDServiceName() {
        return Service_V2SoapWSDDServiceName;
    }

    public void setService_V2SoapWSDDServiceName(java.lang.String name) {
        Service_V2SoapWSDDServiceName = name;
    }

    public org.tempuri.Service_V2Soap getService_V2Soap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Service_V2Soap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getService_V2Soap(endpoint);
    }

    public org.tempuri.Service_V2Soap getService_V2Soap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.Service_V2SoapStub _stub = new org.tempuri.Service_V2SoapStub(portAddress, this);
            _stub.setPortName(getService_V2SoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setService_V2SoapEndpointAddress(java.lang.String address) {
        Service_V2Soap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.Service_V2Soap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.Service_V2SoapStub _stub = new org.tempuri.Service_V2SoapStub(new java.net.URL(Service_V2Soap_address), this);
                _stub.setPortName(getService_V2SoapWSDDServiceName());
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
        if ("Service_V2Soap".equals(inputPortName)) {
            return getService_V2Soap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "Service_V2");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "Service_V2Soap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Service_V2Soap".equals(portName)) {
            setService_V2SoapEndpointAddress(address);
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
