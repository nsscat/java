package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2) {
	
		/*
		 * 점수 내림차순
		 * 오름차순일 때
		 * 비교 주체가 비교 대상보다 크면 양수
		 * 비교 주체가 비교 대상보다 작으면 음수
		 * 비교 주체가 비교 대상과 같으면 0반환
		 */
		int standard = ((Student)o1).getScore(); // 비교 주체
		int object = ((Student)o2).getScore(); // 비교 대상
		
		if(standard > object) {
			return -1; // 내림차순이어서 음수 반환
		}
		else if(standard == object) {
			return 0;
		}
		else {
			return 1;
		}
	}

}
