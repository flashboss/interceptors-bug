package it.vige.injection.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import it.vige.injection.interceptors.NotOKInterceptor;
import it.vige.injection.interceptors.OK;

@Stateless
public class ItemServiceBean implements ItemService {

	@OK
	@Override
	public void create(String item) {
	}

	@Interceptors({ NotOKInterceptor.class })
	@Override
	public List<String> getExcludedList() {
		return null;
	}

}
