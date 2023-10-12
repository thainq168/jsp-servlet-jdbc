package com.thaidev.paging;

import com.thaidev.sort.Sorter;

public interface Pageable {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
