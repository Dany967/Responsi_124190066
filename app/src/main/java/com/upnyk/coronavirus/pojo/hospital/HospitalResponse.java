package com.upnyk.coronavirus.pojo.hospital;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HospitalResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private List<DataItem> data;

	public int getStatusCode(){
		return statusCode;
	}

	public List<DataItem> getData(){
		return data;
	}
}