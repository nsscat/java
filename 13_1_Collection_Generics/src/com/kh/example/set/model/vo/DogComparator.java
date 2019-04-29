package com.kh.example.set.model.vo;

import java.util.Comparator;

public class DogComparator implements Comparator {

	// ������ ��������
	// ���� �����԰� ���ٸ�, �̸����� ���� ����

	@Override
	public int compare(Object o1, Object o2) {

		double standard = ((Dog) o1).getWeight(); // ����ü
		double object = ((Dog) o2).getWeight(); // �� ���

		if (standard > object) {
			return 1;
			// 1(���)�� ��������
		} else if (standard == object) {

			String standName = ((Dog) o1).getName();
			String objName = ((Dog) o2).getName();

			return standName.compareTo(objName);
		} else {
			return -1;
			// -1(����)�� ��������, ������ 0
		}
	}

}