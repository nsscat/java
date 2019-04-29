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
		Set set = new HashSet();// 다형성
		set.add(new Dog("멍멍", 2.2));
		set.add(new Dog("왈왈", 3.3));
		set.add(new Dog("몽이", 5.0));
		System.out.println(set);
		// 순서가 유지되자 않음(set의 특징1)

		set.add(new Dog("몽이", 5.0));
		System.out.println(set);
		// 같음에도 불구하고 다시 저장이됨! ->new연산자로 인해서!

		// Set은 동일 객체 뿐 아니라 동등 객체까지 중복 저장하지 않는다.
		// 동일 객체 : 객체의 주소값이 같은 경우
		// 동등 객체 : 같은 값을 가지고 있는 경우
		// ==> 실제 담긴 값이 같은 것까지 중복으로 본다는것

		set.add(new String("예시1"));
		set.add(new String("예시2"));
		set.add(new String("예시1"));
		set.add(new Integer(100));
		set.add(new Integer(50));
		set.add(new Integer(100));
		System.out.println(set);
		// String, Integer 안에는 동일객체 동등객체 비교하는것이 들어있기때문에 중복 x
		// 몽이가 계속 나온 이유는 hashcode equal 을 오버라이딩 해주지 않았기때문

		System.out.println();

		// LinkedHashSet : 순서 유지해주는 Set
		Set<Dog> set2 = new LinkedHashSet<Dog>();
		// 순서가 변하지 않음!
		set2.add(new Dog("초코", 2.1));
		set2.add(new Dog("콩이", 8.3));
		set2.add(new Dog("두부", 5.0));
		System.out.println(set2);
		set2.add(new Dog("초코", 2.1));
		System.out.println(set2);

		// tree set!!!!!
		Set<Dog> set3 = new TreeSet<Dog>();
		set3.add(new Dog("초코", 2.1));
		set3.add(new Dog("콩이", 8.3));
		set3.add(new Dog("두부", 5.0));
		set3.add(new Dog("초코", 2.1));
		set3.add(new Dog("로이", 6.1));
		set3.add(new Dog("공주", 5.2));
		set3.add(new Dog("왕자", 9.5));
		set3.add(new Dog("조이", 12.5));
		System.out.println("set3 :" + set3);

		Set<Dog> set4 = new TreeSet<Dog>(new DogComparator());
		set4.add(new Dog("초코", 6.1));
		set4.add(new Dog("콩이", 8.3));
		set4.add(new Dog("두부", 5.0));
		set4.add(new Dog("초코", 2.1));
		set4.add(new Dog("로이", 6.1));
		set4.add(new Dog("공주", 5.2));
		set4.add(new Dog("왕자", 9.5));
		set4.add(new Dog("조이", 12.5));
		System.out.println("set4 : " + set4);

		// 1. Set을 List화 시키기

		// interface import 해야함!
		List<Dog> list = new ArrayList<Dog>();
		list.addAll(set4);
		// set이 list 화됨.
		System.out.println("\nset을 list화 시킴 ");
		System.out.println("list.get(3) : "+list.get(3));

		// 2. Iterator 사용
		System.out.println("Iterator - (단방향 출력) - 두번 출력했으나 출력되지않음");
		Iterator<Dog> it = set4.iterator();
		while (it.hasNext()) {// 다음 객체가 있냐?
			System.out.println(it.next());// 객체 반환
		}
		//이부분은 출력되지 않음므
		while (it.hasNext()) {
			System.out.println("re : " + it.next());
		} // Iterator 가 단방향이기 대문에 위에 while문에서 끝에 도달하여 다시 가져올 수 없음!
		
		System.out.println();
		System.out.println("ListIterator : 양방향인 Iterator, list에서만 사용");
		System.out.println("ListIterator - (양방향 출력) : hasNext & next ");
		// ListIterator : 양방향인 Iterator, list에서만 사용
		ListIterator<Dog> lit = list.listIterator();
		while(lit.hasNext()) {
			System.out.println(lit.next());
		}
		System.out.println("ListIterator - (양방향 출력) : hasPrevious & previous");
		while(lit.hasPrevious()) {//내 앞에 값이 존재하니?
			System.out.println(lit.previous());
		}
		
	}
}
