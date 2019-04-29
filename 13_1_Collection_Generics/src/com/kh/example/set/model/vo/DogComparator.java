package com.kh.example.set.model.vo;

import java.util.Comparator;

public class DogComparator implements Comparator {

	// 몸무게 오름차순
	// 만일 몸무게가 같다면, 이름으로 오름 차순

	@Override
	public int compare(Object o1, Object o2) {

		double standard = ((Dog) o1).getWeight(); // 비교주체
		double object = ((Dog) o2).getWeight(); // 비교 대상

		if (standard > object) {
			return 1;
			// 1(양수)은 오름차순
		} else if (standard == object) {

			String standName = ((Dog) o1).getName();
			String objName = ((Dog) o2).getName();

			return standName.compareTo(objName);
		} else {
			return -1;
			// -1(음수)은 내림차순, 같으면 0
		}
	}

}