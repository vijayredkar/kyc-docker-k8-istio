package com.kyc.aggregate.util;
	
	public class Constants {
		
		//--Errors section
		public static final String ERROR_MSG_KYC_PROCESSING_OPER_FAILED = "error occurred when processing KYC" ;
		public static final String ERROR_CODE_KYC_PROCESSING = "KYC-10001" ;
		public static final String ERROR_TYPE_KYC_PROCESSING = "KYC" ;
		
		/*
		 //-- external access from Browser
		public static final String CREDIT_CHECK_WS_URL_BASE = "http://localhost:" ;   //via browser external access
		public static final String CREDIT_CHECK_WS_URL_PORT = "8046" ;//multi eclipse sessions 
		public static final String CREDIT_CHECK_WS_URL_PORT = "8080" ;//via direct springboot call
		//public static final String CREDIT_CHECK_WS_URL_PORT = "8081" ; //via minikube port-forward -  browser access enable
		*/
		
		//-- internal access from minikube NodePort - NodePort
		/*
		public static final String CREDIT_CHECK_WS_URL_BASE = "http://192.168.49.2:" ;//via minikube internal access
		public static final String CREDIT_CHECK_WS_URL_PORT = "31433" ; //via minikube internal access - svc to svc call // http://127.0.0.1:55994   http://192.168.49.2:31331
		
		*/
		
		//-- internal access from minikube LoadBalancer - ClusterIP
		//public static final String CREDIT_CHECK_WS_URL_BASE = "http://192.168.49.2:" ;//via minikube internal access
		//public static final String CREDIT_CHECK_WS_URL_BASE = "http://127.0.0.1:" ;//via minikube internal access
		public static final String CREDIT_CHECK_WS_URL_BASE = "http://kyc-credit-check-svc:" ;//via minikube internal access
		
		//eclipse testing only - remove after tests
		//public static final String CREDIT_CHECK_BASIC_WS_URL_BASE = "http://localhost:8046/credit-check";		
		public static final String CREDIT_CHECK_BASIC_WS_URL_BASE = "http://banknext.com/credit-check" ;//via ingress+minikube internal access     //  ingress config will route to http://kyc-credit-check-basic/credit-check/v1/customer/background
		//public static final String CREDIT_CHECK_GENERIC_WS_URL = "http://192.168.49.2:31019/credit-check/basic" ;//via ingress+minikube internal access     //  ingress config will route to http://kyc-credit-check-basic/credit-check/v1/customer/background
		
		
		
		public static final String CREDIT_CHECK_ADVANCED_WS_URL_BASE = "http://banknext.com/credit-check" ;//via ingress+minikube internal access //  ingress config will route to http://kyc-credit-check-advanced/credit-check/v1/customer/background
		public static final String CREDIT_CHECK_UNSPECIFIED_WS_URL_BASE = "http://banknext.com/credit-check" ;//via ingress+minikube internal access //  ingress config will route to http://kyc-credit-check-advanced/credit-check/v1/customer/background
		
		//eclipse testing only - remove after tests
		//public static final String CREDIT_CHECK_TEST_WS_URL_BASE = "http://localhost:8046/credit-check" ;
		public static final String CREDIT_CHECK_TEST_WS_URL_BASE = "http://banknext.com/credit-check" ;
		
		
 		//kyc-credit-check-svc   ClusterIP      10.110.176.16 


		public static final String CREDIT_CHECK_WS_URL_PORT = "8080" ; //via minikube internal access - svc to svc call http://192.168.49.2:8080
		//public static final String CREDIT_CHECK_BASIC_WS_URL_PORT = "8080" ; //via minikube internal access - svc to svc call http://192.168.49.2:8080
		//public static final String CREDIT_CHECK_ADVANCED_WS_URL_PORT = "8080" ; //via minikube internal access - svc to svc call http://192.168.49.2:8080
		//public static final String CREDIT_CHECK_WS_URL_PORT = "8081" ; //via minikube port-forward -  browser access enable
		//public static final String CREDIT_CHECK_WS_URL_PORT = "59619" ; //via minikube service o/p of kyc-credit-check-svc
		
		
		public static final String CREDIT_CHECK_WS_URL_PATH = "/credit-check/v1/customer/background" ;
		public static final String CREDIT_CHECK_BASIC_WS_URL_PATH = "/basic" ; 		    // istio-ingress config will route to /credit-check-basic/v1/customer/background
		public static final String CREDIT_CHECK_ADVANCED_WS_URL_PATH = "/advanced" ;   //  istio-ingress config will route to /credit-check-advanced/v1/customer/background
		public static final String CREDIT_CHECK_UNSPECIFIED_WS_URL_PATH = "/" ;  //  istio-ingress config will route to /credit-check/  50-50 % to credit-check-basic and credit-check-advanced 
		
		public static final String CREDIT_CHECK_TEST_WS_URL_PATH = "/test" ;
		
		
		public static final String CREDIT_CHECK_TYPE_REPORT = "report" ;
		public static final String CREDIT_CHECK_TYPE_BASIC_REPORT = "basicReport" ;
		public static final String CREDIT_CHECK_TYPE_ADVANCED_REPORT = "advancedReport" ;
		public static final String CREDIT_CHECK_TYPE_UNSPECIFIED = "unspecified" ;
		
		public static final String CREDIT_CHECK_TYPE_TEST = "test" ;
	}