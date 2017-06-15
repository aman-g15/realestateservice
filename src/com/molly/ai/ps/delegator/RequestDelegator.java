package com.molly.ai.ps.delegator;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.molly.ai.ps.params.RequestObject;
import com.molly.ai.ps.params.ResponseObject;
import com.molly.ai.zillow.ZillowIntegration;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class RequestDelegator {
	private static String ACCOUNT_SID = "ACeec294dc4f766cc5de08e79094f3a57b";
	private static final String AUTH_TOKEN = "ab7d54a2f1f33df0e9d2fc1f666f7377";
	
	@Autowired
	ResponseObject response;
	
	@Autowired
	ZillowIntegration zillowIntegration;

	private static Map<String, String> listingsMap;
	
	private static Map<String, String> quotesMap;
	
	private static int count=1;

	@Autowired
	public RequestDelegator() {
		listingsMap = new HashMap<String, String>();
		quotesMap = new HashMap<String, String>();
    	InputStream input = null;
    	Properties prop = new Properties();
    	input = RequestDelegator.class.getClassLoader().getResourceAsStream("molly.properties");
    	if(null!=input){
    		try {
				prop.load(input);
				listingsMap.put("1023", prop.getProperty("property1.price"));
				listingsMap.put("1210", prop.getProperty("property2.price"));
				listingsMap.put("1990", prop.getProperty("property3.price"));
				quotesMap.put("quote1", prop.getProperty("motivational.quotes1"));
				quotesMap.put("quote2", prop.getProperty("motivational.quotes2"));
			} catch (IOException e) {
				System.err.println("Error getting property value from the peroperty file.");
			}
    	}
    	
	}

	public ResponseObject delegate(String action, ResponseObject response, RequestObject request){
		
		if("get-listing-price".equals(action)){
			//String price = getListingPrice(request.getResult().getParameters().getAddress());
			zillowIntegration.getListings(request.getResult().getParameters().getAddress());
			populateResponseObjectLitingPrice(response,request,"");
		}else if("get-motivational-quotes".equals(action)){
			String quote = getMotivation();
			populateResponseObjectMotivation(response,request,quote);
		}else if("send-sms".equals(action)){
			String quote = sendMessage();
			populateResponseObjectMotivation(response,request,quote);
		}
		return this.response;
			
	}
	public String getListingPrice(String address) {
		String price = listingsMap.get(address);
		return price;
	}
	private ResponseObject populateResponseObjectMotivation(ResponseObject response,RequestObject request, String quote){
		response.setSource("http://www.google.com/");
		response.setSpeech(quote);
		response.setDisplayText("Some more information goes here");
		String[] contextOut = { "context1", "context2" };
		response.setContextOut(contextOut);
		List<String> aList = new ArrayList<String>();
		aList.add("data1");
		response.setData(aList);
		return response;
	}
	
	private ResponseObject populateResponseObjectLitingPrice(ResponseObject response, RequestObject request, String price){
		response.setSource("http://www.google.com/");
		response.setSpeech("The price of " + request.getResult().getParameters().getAddress() + " "
				+ request.getResult().getParameters().getAreaTypes() + " is " + price);
		response.setDisplayText("Some more information goes here");
		String[] contextOut = { "context1", "context2" };
		response.setContextOut(contextOut);
		List<String> aList = new ArrayList<String>();
		aList.add("data1");
		response.setData(aList);
		return response;
	}
	
private String getMotivation(){
	String quote = (String)quotesMap.get("quote"+count);
	count++;
	return quote;
}
	

private String sendMessage(){
	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	Message message = Message.creator(new PhoneNumber("+919873056636"), new PhoneNumber("+14243206636"),
			"Your phone has been hacked. I repeat, phone has been hacked Bitch!!").setBody("Your phone has been hacked. I repeat, phone has been hacked Bitch!!").create();
	return "Message sent to Aman" +" Message id: "+message;
}
}
