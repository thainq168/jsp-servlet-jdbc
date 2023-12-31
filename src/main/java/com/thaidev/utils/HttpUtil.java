package com.thaidev.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	public <T> T toModel (Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static HttpUtil of (BufferedReader bufferedReader) {
	    StringBuilder builder = new StringBuilder();
	    String line;
	    try {
			while ((line = bufferedReader.readLine()) != null) {
			    builder.append(line + "\n");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new HttpUtil(builder.toString());
	}
}
