package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2) {
	
		/*
		 * ���� ��������
		 * ���������� ��
		 * �� ��ü�� �� ��󺸴� ũ�� ���
		 * �� ��ü�� �� ��󺸴� ������ ����
		 * �� ��ü�� �� ���� ������ 0��ȯ
		 */
		int standard = ((Student)o1).getScore(); // �� ��ü
		int object = ((Student)o2).getScore(); // �� ���
		
		if(standard > object) {
			return -1; // ���������̾ ���� ��ȯ
		}
		else if(standard == object) {
			return 0;
		}
		else {
			return 1;
		}
	}

}
