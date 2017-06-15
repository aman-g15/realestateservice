package com.molly.ai.ps.params;

import org.springframework.stereotype.Component;

@Component
public class Parameters {
private String address;
private String areaTypes;
private String clients;
private String date;
private String[] property;
private String price;
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getAreaTypes() {
	return areaTypes;
}
public void setAreaTypes(String areaTypes) {
	this.areaTypes = areaTypes;
}
public String getClients() {
	return clients;
}
public void setClients(String clients) {
	this.clients = clients;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String[] getProperty() {
	return property;
}
public void setProperty(String[] property) {
	this.property = property;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

}
