package com.kyc.aggregate.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kyc.aggregate.exception.KycAggregateException;
import com.kyc.aggregate.repo.model.KycRequest;
import com.kyc.aggregate.repo.model.KycResponse;
import com.kyc.aggregate.util.Constants;

@Service
public class KycAggregateService {
	
	Log LOGGER = LogFactory.getLog(KycAggregateService.class);
	
	//@Value("${credit-check-generic-istio-url}")
	String crdChkUnspecifiedIstioUrl;
	
	//@Value("${credit-check-basic-istio-url}")
	String crdChkBasicIstioUrl;
	
	//@Value("${credit-check-advanced-istio-url}")
	String crdChkAdvancedIstioUrl;
	
	@Value("${istio-gateway-port}")
	String istioGatewayPort;
	
	@Value("${istio-base-url}")
	String istioBaseUrl;
	
	@Value("${credit-check-basic-uri}")
	String creditCheckBasicUri;
	
	@Value("${credit-check-advanced-uri}")
	String creditCheckAdvancedUri;
	
	@Value("${credit-check-unspecified-uri}")
	String creditCheckUnspecifiedUri;
	
	@Value("${credit-check-report-uri}")
	String creditCheckReportUri;
	

	public KycResponse processKyc(KycRequest kycReq, String type) throws KycAggregateException  
	{
		KycResponse kycResponse = new KycResponse();
		
		try 
		{	
		    if(Constants.CREDIT_CHECK_TYPE_BASIC_REPORT.equals(type))
		    {
		    	crdChkBasicIstioUrl = istioBaseUrl + istioGatewayPort + creditCheckBasicUri;
		    	LOGGER.info("\n----  Istio redirection - credit check basic - url : "+crdChkBasicIstioUrl);
		    	kycResponse = invokeService(kycReq, crdChkBasicIstioUrl);
		    }
		    else if(Constants.CREDIT_CHECK_TYPE_ADVANCED_REPORT.equals(type))
		    {
		    	crdChkAdvancedIstioUrl = istioBaseUrl + istioGatewayPort + creditCheckAdvancedUri;
		    	LOGGER.info("\n----  Istio redirection - credit check advanced - url : "+crdChkAdvancedIstioUrl);
		    	kycResponse = invokeService(kycReq, crdChkAdvancedIstioUrl);	
		    }
		    else
		    {
		    	String crdChkReportIstioUrl = istioBaseUrl + istioGatewayPort + creditCheckReportUri;
		    	LOGGER.info("\n----  Istio weight distribution between credit check basic & advanced - url : "+crdChkReportIstioUrl);
		    	kycResponse = invokeService(kycReq, crdChkReportIstioUrl);
		    }
		    /*else
		    {
		    	crdChkUnspecifiedIstioUrl = istioBaseUrl + istioGatewayPort + creditCheckUnspecifiedUri;
		    	LOGGER.info("\n----  Istio weight distribution between credit check basic & advanced - url : "+crdChkUnspecifiedIstioUrl);
		    	kycResponse = invokeService(kycReq, crdChkUnspecifiedIstioUrl);
		    }*///end else
		    
		     kycResponse.setBackgroundCheckPass(true);
		     return kycResponse;
		     
		} 
		catch (Exception e) 
		{
			LOGGER.error(Constants.ERROR_MSG_KYC_PROCESSING_OPER_FAILED + " : " +e);
			throw new KycAggregateException(Constants.ERROR_MSG_KYC_PROCESSING_OPER_FAILED +" - "+ e.getMessage());
		}
	}

	private KycResponse invokeService(KycRequest kycReq, String url) 
	{
		RestTemplate restTemplate = new RestTemplate();	
		KycResponse kycResponse;
		ResponseEntity<KycResponse> response;
		
		LOGGER.info("\n----************* url : "+ url);	
		
		//response = restTemplate.postForEntity(url, kycReq, KycResponse.class);
		response = restTemplate.getForEntity(url, KycResponse.class);
		kycResponse = response.getBody();
		
		LOGGER.info("\n----************* kycResponse : "+ kycResponse);
		return kycResponse;
	}	
	
}
