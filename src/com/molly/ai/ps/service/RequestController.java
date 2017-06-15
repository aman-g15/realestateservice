package com.molly.ai.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.molly.ai.ps.delegator.RequestDelegator;
import com.molly.ai.ps.params.RequestObject;
import com.molly.ai.ps.params.ResponseObject;

@RestController
@PropertySource("classpath:molly.properties")
public class RequestController {
	@Autowired
	private RequestDelegator requestDelegator;
	@Autowired
	private ResponseObject response;

	// @RequestMapping(name="/post")
	// public void tryPost(){
	// System.out.println("Inside your service. POST");
	// }

	@RequestMapping(name = "/get", method = RequestMethod.GET)
	public String tryGet() {
		return "You are inside the GET method";
	}

	@RequestMapping(name = "/getListings", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseObject getListings(@RequestBody RequestObject request) {
		String action = request.getResult().getAction();
		response = requestDelegator.delegate(action,response,request);
		

		// String response = RequestDelegator.getListingPrice(env);
		return response;
	}

}
