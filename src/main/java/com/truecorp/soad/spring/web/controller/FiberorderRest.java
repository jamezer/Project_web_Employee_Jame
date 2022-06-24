package com.truecorp.soad.spring.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.truecorp.soad.spring.web.controller.model.FTTHCustomerOrderResponseModel;
import com.truecorp.soad.spring.web.controller.model.FTTHWorkOrderResponseModel;
import com.truecorp.soad.spring.web.controller.model.QrunServiceCaller;
import com.truecorp.soad.spring.web.controller.model.QueryFTTHCustomerOrderResponseModel;
import com.truecorp.soad.spring.web.controller.model.QueryFTTHWorkOrderResponseModel;

public class FiberorderRest {
	
	private static final String PATH_GET_FIBERORDER = "/FiberOrderList";
	
	@Resource(name = "QrunHttpServiceCaller")
	private QrunServiceCaller qrunCaller;
	
	@RequestMapping(value=PATH_GET_FIBERORDER,method = RequestMethod.POST)
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response,String snNo) {
		ModelAndView mv = null;
		
		try {
			
			if(snNo == null)	{
				mv = new ModelAndView("noauthorized");	
				mv.addObject("msg", "please access on with right methology");
			}else {
				mv = new ModelAndView("index");	
				
				//Model
				QueryFTTHCustomerOrderResponseModel queryFTTHCustomerOrderResponseModel = null;
				QueryFTTHWorkOrderResponseModel queryFTTHWorkOrderResponseModel = null;
				
				//API Model
				
				//QueryFTTHCustomerOrderResponse queryFTTHCustomerOrderResponse = null;
				//QueryFTTHWorkOrderResponse queryFTTHWorkOrderResponse = null;
				
				FTTHCustomerOrderResponseModel responseModel = null;
				
				FTTHWorkOrderResponseModel workResponseModel = null;
				
				try {
					if(snNo != null && snNo.length() > 0) {
//						logger.info("custOrderNo = "+snNo);
						snNo = snNo.trim();
						
						responseModel =  qrunCaller.callFTTHCustomerOrder(QrunServiceCaller.queryCondition_CUSTOMER_ORDER,  snNo);
						//queryFTTHCustomerOrderResponse = qrunWebService.callWebserviceCustomerOrder(GlobalConfig.QRUN_ENDPOINT, 
						//		QrunWebService.queryCondition_CUSTOMER_ORDER, custOrderNo);
						//queryFTTHCustomerOrderResponse =   getDataByFiberNo(CUSTOMER_ORDER,custOrderNo);	
						mv.addObject("custOrderNoParam", snNo);
						
					}else {
						mv.addObject("Message", "Customer order No./Access Number Not Found !!!");
					}
					
					if(responseModel.getResultCode().equals("0") && responseModel.getCustomerOrderNo() != null
							&& responseModel.getCustomerOrderNo().length() > 0 ){
					
					//QueryFTTHWorkOrder queryFTTHWorkOrder = new QueryFTTHWorkOrder();
				
					
//					Calendar start  =TimeTag.createCalendar() ;
					//queryFTTHWorkOrderResponse = qrunWebService.callWebServiceWorkOrderNo(GlobalConfig.QRUN_ENDPOINT, queryFTTHCustomerOrderResponse.getCUST_ORDER_NO()) ;
					//queryFTTHWorkOrderResponse = service.queryFTTHWorkOrder(queryFTTHWorkOrder);
					workResponseModel = qrunCaller.callFTTHWorkOrder(responseModel.getCustomerOrderNo());
					
//					Calendar finish  =TimeTag.createCalendar() ;
//					TimeTag.logQueryTimeTag(logger, responseModel.getCustomerOrderNo()+" queryFTTHWorkOrder" , start, finish);
					
				}
					
				} catch (Exception e) {
					e.printStackTrace();
					
					mv.addObject("Message", "error "+e.getMessage());
					
					return mv;
				}
			}
			
//			if(responseModel != null & responseModel.getResultCode().equals("0")){
//				queryFTTHCustomerOrderResponseModel = ViewObjectMapping.mapping(responseModel);
//				
//				FillCallVerStatus(queryFTTHCustomerOrderResponseModel);
//				
//				mv.addObject("QueryFTTHCustomerOrderResponse", queryFTTHCustomerOrderResponseModel);
//				
//				if(workResponseModel != null && workResponseModel.getResultCode().length()>0 
//						&& workResponseModel.getResultCode().equals("0")) {
//					
//					queryFTTHWorkOrderResponseModel = ViewObjectMapping.mapping(workResponseModel);
//					mv.addObject("QueryFTTHWorkOrderResponse", queryFTTHWorkOrderResponseModel);
//					mv.addObject("LastWorkorder", queryFTTHWorkOrderResponseModel.getWorkOrderList().get(0));				
//			
//				}
//				
//			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
		
	}

}
