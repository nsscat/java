package com.kh.example.map.model.compare;

import java.util.Comparator;

public class SnackComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		String standard = (String) o1;
		String object = (String) o2;
		return -standard.compareTo(object);
	}

}
