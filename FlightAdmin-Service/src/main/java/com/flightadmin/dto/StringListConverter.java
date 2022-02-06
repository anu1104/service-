package com.flightadmin.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;

public class StringListConverter implements AttributeConverter<List<String>, String>{
	
	 private static final String SPLIT_CHAR = ";";
	 List<String> emptyList = new ArrayList<>();

	  @Override
	    public String convertToDatabaseColumn(List<String> stringList) {
	        return stringList != null ? String.join(SPLIT_CHAR, stringList) : "";
	    }

	    @Override
	    public List<String> convertToEntityAttribute(String string) {
	        return string != null ? Arrays.asList(string.split(SPLIT_CHAR)) : emptyList;
	    }

}
