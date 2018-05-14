package com.mrbcoding.ebaytool.controllers;

import org.springframework.http.ResponseEntity;
import java.util.Map;

public interface Controller<TYPE> {
	ResponseEntity<Map<String, TYPE>> getAll();
	ResponseEntity<TYPE> update(TYPE obj);
	ResponseEntity<TYPE> delete(String id);
	ResponseEntity<TYPE> create(TYPE obj);

}
