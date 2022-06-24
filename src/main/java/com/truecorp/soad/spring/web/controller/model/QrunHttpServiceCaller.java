package com.truecorp.soad.spring.web.controller.model;

import java.io.IOException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service(value = "QrunHttpServiceCaller")
public class QrunHttpServiceCaller implements QrunServiceCaller{
	
	public FTTHCustomerOrderResponseModel callFTTHCustomerOrder(String accessType ,  String condition) {
		
		FTTHCustomerOrderResponseModel res = null;
		
		String request = QrunServiceRequest.getFTTHCustomerOrderRequest(accessType, condition);
		
//		try {
//			
//			String response = HTTPService.post(GlobalConfig.QRUN_ENDPOINT, request, HTTPService.XML);
//			
//			FTTHCustomerEnvelope envelope = mapper.readValue(response, FTTHCustomerEnvelope.class);
//			res = envelope.getBody().getResponseModel();
//			
//		} catch (IOException e) {
//		
//			e.printStackTrace();
//		}
		
		
		return res;
	}

	@Override
	public FTTHWorkOrderResponseModel callFTTHWorkOrder(String customerOrderNo) {
		
		FTTHWorkOrderResponseModel res  = null;
		
		String request = QrunServiceRequest.getFTTHWorkOrderNoRequest(customerOrderNo);
		
//		TimeTag.sysout("Endpoint = "+GlobalConfig.QRUN_ENDPOINT);
//		TimeTag.sysout("request = "+request);
//		logger.info("Endpoint = "+GlobalConfig.QRUN_ENDPOINT);
//		logger.info("request = "+request);
		
//		try {
//			String response = HTTPService.post(GlobalConfig.QRUN_ENDPOINT, request, HTTPService.XML);
//			
////			TimeTag.sysout(customerOrderNo+" response = "+response);
////			logger.info(customerOrderNo+" response = "+response);
//			XmlMapper mapper = new XmlMapper();		
//			FTTHWorkOrderEnvelope envelope = mapper.readValue(response, FTTHWorkOrderEnvelope.class);
//			res = envelope.getBody().getResponseModel();
//		} catch (IOException e) {
//		
//			e.printStackTrace();
//		}
		
		
		return res;
	}

}
