package com.kh.example.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import com.kh.example.set.model.vo.Dog;
import com.kh.example.set.model.vo.DogComparator;

public class SetController {
	public void doSet() {
		Set set = new HashSet();// ������
		set.add(new Dog("�۸�", 2.2));
		set.add(new Dog("�п�", 3.3));
		set.add(new Dog("����", 5.0));
		System.out.println(set);
		// ������ �������� ����(set�� Ư¡1)

		set.add(new Dog("����", 5.0));
		System.out.println(set);
		// �������� �ұ��ϰ� �ٽ� �����̵�! ->new�����ڷ� ���ؼ�!

		// Set�� ���� ��ü �� �ƴ϶� ���� ��ü���� �ߺ� �������� �ʴ´�.
		// ���� ��ü : ��ü�� �ּҰ��� ���� ���
		// ���� ��ü : ���� ���� ������ �ִ� ���
		// ==> ���� ��� ���� ���� �ͱ��� �ߺ����� ���ٴ°�

		set.add(new String("����1"));
		set.add(new String("����2"));
		set.add(new String("����1"));
		set.add(new Integer(100));
		set.add(new Integer(50));
		set.add(new Integer(100));
		System.out.println(set);
		// String, Integer �ȿ��� ���ϰ�ü ���ü ���ϴ°��� ����ֱ⶧���� �ߺ� x
		// ���̰� ��� ���� ������ hashcode equal �� �������̵� ������ �ʾұ⶧��

		System.out.println();

		// LinkedHashSet : ���� �������ִ� Set
		Set<Dog> set2 = new LinkedHashSet<Dog>();
		// ������ ������ ����!
		set2.add(new Dog("����", 2.1));
		set2.add(new Dog("����", 8.3));
		set2.add(new Dog("�κ�", 5.0));
		System.out.println(set2);
		set2.add(new Dog("����", 2.1));
		System.out.println(set2);

		// tree set!!!!!
		Set<Dog> set3 = new TreeSet<Dog>();
		set3.add(new Dog("����", 2.1));
		set3.add(new Dog("����", 8.3));
		set3.add(new Dog("�κ�", 5.0));
		set3.add(new Dog("����", 2.1));
		set3.add(new Dog("����", 6.1));
		set3.add(new Dog("����", 5.2));
		set3.add(new Dog("����", 9.5));
		set3.add(new Dog("����", 12.5));
		System.out.println("set3 :" + set3);

		Set<Dog> set4 = new TreeSet<Dog>(new DogComparator());
		set4.add(new Dog("����", 6.1));
		set4.add(new Dog("����", 8.3));
		set4.add(new Dog("�κ�", 5.0));
		set4.add(new Dog("����", 2.1));
		set4.add(new Dog("����", 6.1));
		set4.add(new Dog("����", 5.2));
		set4.add(new Dog("����", 9.5));
		set4.add(new Dog("����", 12.5));
		System.out.println("set4 : " + set4);

		// 1. Set�� Listȭ ��Ű��

		// interface import �ؾ���!
		List<Dog> list = new ArrayList<Dog>();
		list.addAll(set4);
		// set�� list ȭ��.
		System.out.println("\nset�� listȭ ��Ŵ ");
		System.out.println("list.get(3) : "+list.get(3));

		// 2. Iterator ���
		System.out.println("Iterator - (�ܹ��� ���) - �ι� ��������� ��µ�������");
		Iterator<Dog> it = set4.iterator();
		while (it.hasNext()) {// ���� ��ü�� �ֳ�?
			System.out.println(it.next());// ��ü ��ȯ
		}
		//�̺κ��� ��µ��� ������
		while (it.hasNext()) {
			System.out.println("re : " + it.next());
		} // Iterator �� �ܹ����̱� �빮�� ���� while������ ���� �����Ͽ� �ٽ� ������ �� ����!
		
		System.out.println();
		System.out.println("ListIterator : ������� Iterator, list������ ���");
		System.out.println("ListIterator - (����� ���) : hasNext & next ");
		// ListIterator : ������� Iterator, list������ ���
		ListIterator<Dog> lit = list.listIterator();
		while(lit.hasNext()) {
			System.out.println(lit.next());
		}
		System.out.println("ListIterator - (����� ���) : hasPrevious & previous");
		while(lit.hasPrevious()) {//�� �տ� ���� �����ϴ�?
			System.out.println(lit.previous());
		}
		
	}
}
