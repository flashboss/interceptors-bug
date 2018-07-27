package it.vige.injection.service;

import java.util.List;

import javax.interceptor.Interceptors;

import it.vige.injection.interceptors.NotOKInterceptor;
import it.vige.injection.interceptors.OK;

public class ItemServiceBean {

	@OK
	public void create(String item) {
	}

	@Interceptors({ NotOKInterceptor.class })
	public List<String> getExcludedList() {
		return null;
	}

}
