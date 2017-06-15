package com.molly.ai.zillow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.molly.ai.zillow.entity.ZillowResponseObject;

@Component
public class ZillowIntegration {
	
	public static void main(String[] args){
		new ZillowIntegration().getListings("10251 Miller Ave");
	}
private final String State = "Cupertino";
private final String zipCode = "95014";
	public void getListings(String address){
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("https://www.zillow.com/webservice/GetDeepSearchResults.htm");

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("zws-id", "X1-ZWz1990cliztaj_9bpwi"));
		params.add(new BasicNameValuePair("address", address +", "+State));
		params.add(new BasicNameValuePair("citystatezip", zipCode));
		try {
			httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Execute and get the response.
		HttpResponse response = null;
		ZillowResponseObject zillowResponse = null;
		try {
			response = httpclient.execute(httppost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity entity = response.getEntity();
		if (entity != null) {
		    InputStream instream=null;
			try {
				instream = entity.getContent();
			} catch (UnsupportedOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
		        // do something useful
		    	BufferedReader br = new BufferedReader(new InputStreamReader(instream, "UTF-8"));
		    	String line = null;
		    	line = br.readLine();
		    	XmlObject xmlPayload = XmlObject.Factory.parse(line);
		    	System.out.println(xmlPayload);
		    	/*DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    	XmlOptions options = new XmlOptions();
	               options.setCharacterEncoding("UTF-8");
		    	Document doc = dBuilder.parse(xmlPayload.newInputStream(options));
		    	System.out.println(doc.getElementsByTagName("address"));*/
		    	JAXBContext jc = JAXBContext.newInstance(ZillowResponseObject.class);
		        Unmarshaller unmarshaller = jc.createUnmarshaller();
		        zillowResponse = (ZillowResponseObject) unmarshaller.unmarshal(xmlPayload.newInputStream());
		    } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XmlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		        try {
					instream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
	}
	}
}
