package com.mrbcoding.ebaytool.repositories;

import java.util.List;
import java.util.Map;

public interface Repository<KEY, TYPE> {

	TYPE add(TYPE obj);
	TYPE update(TYPE obj);
	void update(List<TYPE> obj);
	TYPE read(KEY key);
	void delete(KEY key);
	Map<KEY, TYPE> readAll();
}
