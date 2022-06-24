package com.truecorp.soad.spring.web.controller.model;

public interface QrunServiceCaller {

	String queryCondition_CUSTOMER_ORDER = null;

	FTTHWorkOrderResponseModel callFTTHWorkOrder(String customerOrderNo);

	FTTHCustomerOrderResponseModel callFTTHCustomerOrder(String queryconditionCustomerOrder, String snNo);

}
