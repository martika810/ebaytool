package com.mrbcoding.ebaytool.controllers;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface Controller<TYPE> {
	ResponseEntity<List<TYPE>> getAll();
	ResponseEntity<TYPE> update(TYPE obj);
	ResponseEntity<List<TYPE>> update(List<TYPE> list);
	ResponseEntity<TYPE> delete(String id);
	ResponseEntity<TYPE> create(TYPE obj);

}
