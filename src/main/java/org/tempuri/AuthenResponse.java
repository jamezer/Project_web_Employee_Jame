/**
 * AuthenResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class AuthenResponse  implements java.io.Serializable {
    private java.lang.String errorCode;

    private java.lang.String errorMessage;

    private java.lang.String employeeID;

    private java.lang.String employeeName;

    private java.lang.String employeeMail;

    private java.lang.String employeeDepartment;

    private java.lang.String requestDate;

    private java.lang.String loginType;

    public AuthenResponse() {
    }

    public AuthenResponse(
           java.lang.String errorCode,
           java.lang.String errorMessage,
           java.lang.String employeeID,
           java.lang.String employeeName,
           java.lang.String employeeMail,
           java.lang.String employeeDepartment,
           java.lang.String requestDate,
           java.lang.String loginType) {
           this.errorCode = errorCode;
           this.errorMessage = errorMessage;
           this.employeeID = employeeID;
           this.employeeName = employeeName;
           this.employeeMail = employeeMail;
           this.employeeDepartment = employeeDepartment;
           this.requestDate = requestDate;
           this.loginType = loginType;
    }


    /**
     * Gets the errorCode value for this AuthenResponse.
     * 
     * @return errorCode
     */
    public java.lang.String getErrorCode() {
        return errorCode;
    }


    /**
     * Sets the errorCode value for this AuthenResponse.
     * 
     * @param errorCode
     */
    public void setErrorCode(java.lang.String errorCode) {
        this.errorCode = errorCode;
    }


    /**
     * Gets the errorMessage value for this AuthenResponse.
     * 
     * @return errorMessage
     */
    public java.lang.String getErrorMessage() {
        return errorMessage;
    }


    /**
     * Sets the errorMessage value for this AuthenResponse.
     * 
     * @param errorMessage
     */
    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }


    /**
     * Gets the employeeID value for this AuthenResponse.
     * 
     * @return employeeID
     */
    public java.lang.String getEmployeeID() {
        return employeeID;
    }


    /**
     * Sets the employeeID value for this AuthenResponse.
     * 
     * @param employeeID
     */
    public void setEmployeeID(java.lang.String employeeID) {
        this.employeeID = employeeID;
    }


    /**
     * Gets the employeeName value for this AuthenResponse.
     * 
     * @return employeeName
     */
    public java.lang.String getEmployeeName() {
        return employeeName;
    }


    /**
     * Sets the employeeName value for this AuthenResponse.
     * 
     * @param employeeName
     */
    public void setEmployeeName(java.lang.String employeeName) {
        this.employeeName = employeeName;
    }


    /**
     * Gets the employeeMail value for this AuthenResponse.
     * 
     * @return employeeMail
     */
    public java.lang.String getEmployeeMail() {
        return employeeMail;
    }


    /**
     * Sets the employeeMail value for this AuthenResponse.
     * 
     * @param employeeMail
     */
    public void setEmployeeMail(java.lang.String employeeMail) {
        this.employeeMail = employeeMail;
    }


    /**
     * Gets the employeeDepartment value for this AuthenResponse.
     * 
     * @return employeeDepartment
     */
    public java.lang.String getEmployeeDepartment() {
        return employeeDepartment;
    }


    /**
     * Sets the employeeDepartment value for this AuthenResponse.
     * 
     * @param employeeDepartment
     */
    public void setEmployeeDepartment(java.lang.String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }


    /**
     * Gets the requestDate value for this AuthenResponse.
     * 
     * @return requestDate
     */
    public java.lang.String getRequestDate() {
        return requestDate;
    }


    /**
     * Sets the requestDate value for this AuthenResponse.
     * 
     * @param requestDate
     */
    public void setRequestDate(java.lang.String requestDate) {
        this.requestDate = requestDate;
    }


    /**
     * Gets the loginType value for this AuthenResponse.
     * 
     * @return loginType
     */
    public java.lang.String getLoginType() {
        return loginType;
    }


    /**
     * Sets the loginType value for this AuthenResponse.
     * 
     * @param loginType
     */
    public void setLoginType(java.lang.String loginType) {
        this.loginType = loginType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AuthenResponse)) return false;
        AuthenResponse other = (AuthenResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.errorCode==null && other.getErrorCode()==null) || 
             (this.errorCode!=null &&
              this.errorCode.equals(other.getErrorCode()))) &&
            ((this.errorMessage==null && other.getErrorMessage()==null) || 
             (this.errorMessage!=null &&
              this.errorMessage.equals(other.getErrorMessage()))) &&
            ((this.employeeID==null && other.getEmployeeID()==null) || 
             (this.employeeID!=null &&
              this.employeeID.equals(other.getEmployeeID()))) &&
            ((this.employeeName==null && other.getEmployeeName()==null) || 
             (this.employeeName!=null &&
              this.employeeName.equals(other.getEmployeeName()))) &&
            ((this.employeeMail==null && other.getEmployeeMail()==null) || 
             (this.employeeMail!=null &&
              this.employeeMail.equals(other.getEmployeeMail()))) &&
            ((this.employeeDepartment==null && other.getEmployeeDepartment()==null) || 
             (this.employeeDepartment!=null &&
              this.employeeDepartment.equals(other.getEmployeeDepartment()))) &&
            ((this.requestDate==null && other.getRequestDate()==null) || 
             (this.requestDate!=null &&
              this.requestDate.equals(other.getRequestDate()))) &&
            ((this.loginType==null && other.getLoginType()==null) || 
             (this.loginType!=null &&
              this.loginType.equals(other.getLoginType())));
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
        if (getErrorCode() != null) {
            _hashCode += getErrorCode().hashCode();
        }
        if (getErrorMessage() != null) {
            _hashCode += getErrorMessage().hashCode();
        }
        if (getEmployeeID() != null) {
            _hashCode += getEmployeeID().hashCode();
        }
        if (getEmployeeName() != null) {
            _hashCode += getEmployeeName().hashCode();
        }
        if (getEmployeeMail() != null) {
            _hashCode += getEmployeeMail().hashCode();
        }
        if (getEmployeeDepartment() != null) {
            _hashCode += getEmployeeDepartment().hashCode();
        }
        if (getRequestDate() != null) {
            _hashCode += getRequestDate().hashCode();
        }
        if (getLoginType() != null) {
            _hashCode += getLoginType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AuthenResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "AuthenResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ErrorCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errorMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ErrorMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "EmployeeID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "EmployeeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeMail");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "EmployeeMail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("employeeDepartment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "EmployeeDepartment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "RequestDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "LoginType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
