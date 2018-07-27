package it.vige.injection.service;

import java.util.List;

public interface ItemService {
	void create(String item);
	List<String> getExcludedList();
}
