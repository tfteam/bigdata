package com.bigdata.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BaseService {
	
	protected String genJsonString(Object object) {
		if ("ArrayList".equals(object.getClass().getSimpleName())) {
			JSONArray json = JSONArray.fromObject(object);
			return json.toString();
		} else {
			JSONObject json = JSONObject.fromObject(object);
			return json.toString();
		}
	}
}
