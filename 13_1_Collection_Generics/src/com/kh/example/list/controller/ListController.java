
package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	
	public void doList() {
		/*
		 * List �迭�� Ư¡
		 * 1. ���� ����
		 * 2. �ߺ� ���� ����
		 */
		
		List exList = new ArrayList(); // ������ 
		// ũ�� 10��¥�� ArrayList ����
		
		List<Student> list = new ArrayList<>(); //List�� Student�� ����
		// ũ�Ⱑ 3��¥�� ArrayList ����
		
		// 1. add(E e) : ����Ʈ ���� ������ e �߰�
		list.add(new Student("�׽�Ʈ", 0));
		list.add(new Student("�����", 60));
		
		System.out.println("list : " + list);
		
		list.add(new Student("������", 90));
		list.add(new Student("����ȣ", 85));
		
		System.out.println("list : " + list);
		
		// ����1. ���� ũ�⿡ ������ ����
		
		list.add(new Student("���̹�", 66));
		System.out.println("list : " + list);
		System.out.println("list�� ��� element ���� : " + list.size());
		// size() : ����Ʈ�� �ִ� element�� ���� ��ȯ
		
		// add(int index, E e) : index��° �ε����� e �߰�
		list.add(0, new Student("�����", 100));
		System.out.println("list : " + list);
		
		list.add(3, new Student("���ǰ�", 40));
		System.out.println("list : " + list);
		
		/*
		 * remove(Object o) : �ش�o ��ü ����
		 * remove(int index) : �ش� index��° �ε����� �ִ� ��ü ����
		 */
		list.remove(new Student("�׽�Ʈ", 0));
		System.out.println("list : " +list);
		
		list.remove(1);
		               
		
		// ���� ��� 1. Collections �̿�
		Collections.sort(list);
		System.out.println("list : " + list);
		
		// ���� ��� 2. List�ȿ� �ִ� sort() �̿�
		list.sort(new StudentComparator());
		System.out.println("list : " + list);
		
		// ����3. �������� Ÿ���� �����ִ�.
		//list.add("��"); => list�� Student�� ���� �����߱⶧���� ������
		System.out.println("list : " + list);
		
		
		// set(int index, E e) : index��° �ε����� �ִ� ��Ҹ� E��ҷ� ����
		
		list.set(2, new Student("�����", 31));
		System.out.println("list : " + list);
		
		// get(int index) : index��° �ε����� �ִ� ��Ҹ� ������ ��
		//Student s = (Student)list.get(2); //get�ؼ� �޾ƿ��� ���� object�̱⶧����
		Student s = list.get(2);
		System.out.println(s);

		/*
		 *  subList(int index1, int index2)
		 *  index1��° �ε������� index2��° �ε����� ����Ʈ ��ȯ
		 */
		
		List copyList = new ArrayList(list.subList(2,  5));
		System.out.println("copyList : " + copyList);
		
		/*
		 *  contains(Object o) : o�� ����Ʈ�� �����Ѵٸ� true��ȯ
		 *  indexOf(Object o) : o�� ����Ʈ�� ��ġ�ϴ� �ε��� ��ȣ ��ȯ
		 *                      o�� �������� ������ -1 ��ȯ
		 */
		
		
		if(list.contains(new Student("������", 90))){
			int index = list.indexOf(new Student("������", 90)); // �������� �ʴ� ����̸� -1 ��ȯ
			//if(list.indexOf() == -1) �̷��� �ص� ��  
			Student ss = list.get(index);
			System.out.println(ss);
		}
		
		// clear() : ����� ��� ��ü ����
		// isEmpty() : ����Ʈ�� ����� �� ture ��ȯ
		list.clear();
		System.out.println("list : " + list);
		
		System.out.println("list�� ������� ? " + list.isEmpty());
	}

}
