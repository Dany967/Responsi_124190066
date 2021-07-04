package com.upnyk.coronavirus.pojo.corona;

import com.google.gson.annotations.SerializedName;

public class CoronaResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private Data data;

	public int getStatusCode(){
		return statusCode;
	}

	public Data getData(){
		return data;
	}
}