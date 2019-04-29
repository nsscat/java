
package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	
	public void doList() {
		/*
		 * List 계열의 특징
		 * 1. 순서 유지
		 * 2. 중복 저장 가능
		 */
		
		List exList = new ArrayList(); // 다형성 
		// 크기 10개짜리 ArrayList 생성
		
		List<Student> list = new ArrayList<>(); //List에 Student가 들어감당
		// 크기가 3개짜리 ArrayList 생성
		
		// 1. add(E e) : 리스트 끝에 데이터 e 추가
		list.add(new Student("테스트", 0));
		list.add(new Student("도대담", 60));
		
		System.out.println("list : " + list);
		
		list.add(new Student("남나눔", 90));
		list.add(new Student("하현호", 85));
		
		System.out.println("list : " + list);
		
		// 장점1. 저장 크기에 제약이 없다
		
		list.add(new Student("문미미", 66));
		System.out.println("list : " + list);
		System.out.println("list에 담긴 element 개수 : " + list.size());
		// size() : 리스트에 있는 element의 개수 반환
		
		// add(int index, E e) : index번째 인덱스에 e 추가
		list.add(0, new Student("류라라", 100));
		System.out.println("list : " + list);
		
		list.add(3, new Student("강건강", 40));
		System.out.println("list : " + list);
		
		/*
		 * remove(Object o) : 해당o 객체 삭제
		 * remove(int index) : 해당 index번째 인덱스에 있는 객체 삭제
		 */
		list.remove(new Student("테스트", 0));
		System.out.println("list : " +list);
		
		list.remove(1);
		               
		
		// 정렬 방법 1. Collections 이용
		Collections.sort(list);
		System.out.println("list : " + list);
		
		// 정렬 방법 2. List안에 있는 sort() 이용
		list.sort(new StudentComparator());
		System.out.println("list : " + list);
		
		// 장점3. 여러가지 타입이 들어갈수있다.
		//list.add("끝"); => list를 Student만 들어가게 변경했기때문에 에러남
		System.out.println("list : " + list);
		
		
		// set(int index, E e) : index번째 인덱스에 있는 요소를 E요소로 수정
		
		list.set(2, new Student("도대담", 31));
		System.out.println("list : " + list);
		
		// get(int index) : index번째 인덱스에 있는 요소를 가지고 옴
		//Student s = (Student)list.get(2); //get해서 받아오는 값이 object이기때문에
		Student s = list.get(2);
		System.out.println(s);

		/*
		 *  subList(int index1, int index2)
		 *  index1번째 인덱스부터 index2번째 인덱스의 리스트 반환
		 */
		
		List copyList = new ArrayList(list.subList(2,  5));
		System.out.println("copyList : " + copyList);
		
		/*
		 *  contains(Object o) : o가 리스트에 존재한다면 true반환
		 *  indexOf(Object o) : o가 리스트에 위치하는 인덱스 번호 반환
		 *                      o가 존재하지 않으면 -1 반환
		 */
		
		
		if(list.contains(new Student("남나눔", 90))){
			int index = list.indexOf(new Student("남나눔", 90)); // 존재하지 않는 사람이면 -1 반환
			//if(list.indexOf() == -1) 이렇게 해도 됨  
			Student ss = list.get(index);
			System.out.println(ss);
		}
		
		// clear() : 저장된 모든 객체 삭제
		// isEmpty() : 리스트가 비었을 때 ture 반환
		list.clear();
		System.out.println("list : " + list);
		
		System.out.println("list가 비었나요 ? " + list.isEmpty());
	}

}
