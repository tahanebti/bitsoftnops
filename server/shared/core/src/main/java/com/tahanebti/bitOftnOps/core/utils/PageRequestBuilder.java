package com.tahanebti.bitOftnOps.core.utils;


import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;


public class PageRequestBuilder  {

	private PageRequestBuilder() {
		
	}
	

	public static PageRequest getPageRequest(Integer _limit, Integer _offset, String _sort) {

		  Sort sort = Sort.unsorted();
		    if (_sort != null) {
		      sort = Sort.by(_sort);
		    }
		    return PageRequest.of(_offset / _limit, _limit, sort);
	}


	private static Order getOrder(String value) {

		if (StringUtils.startsWith(value, "-")) {
			return new Order(Direction.DESC, StringUtils.substringAfter(value, "-"));
		} else if (StringUtils.startsWith(value, "+")) {
			return new Order(Direction.ASC, StringUtils.substringAfter(value, "+"));
		} else {
			// Sometimes '+' from query param can be replaced as ' '
			return new Order(Direction.ASC, StringUtils.trim(value));
		}

	}
	 
	 
}
