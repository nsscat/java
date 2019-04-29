package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.library.model.vo.Book;

public class BookController {
	private List<Book> list = new ArrayList();

	public BookController() {
		// 초기 값 4개 추가
		list.add(new Book("자바의 정석", "남궁 성", "기타", 20000));
		list.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
		list.add(new Book("대화의 기술", "강보람", "인문", 17500));
		list.add(new Book("암 정복기", "박신우", "의료", 21000));
	}

	public void insertBook(Book bk) {
		// 전달 받은 bk를 bookList에 추가
		list.add(bk);
	}

	public ArrayList selectList() {
		// 해당 bookList의 주소 값 반환
		return (ArrayList) list;
	}

	public ArrayList searchBook(String keyword) {
		// 검색 결과 리스트를 담아줄 리스트(ArrayList searchList) 선언 및 생성
		// 반복문을 통해 list의 책 중 책 명에 전달 받은 keyword가 포함되어있는 경우
		// searchList에 해당 책 추가하고 searchList 반환
		ArrayList searchList = new ArrayList();
		for (Book i : list) {
			if (i.getTitle().contains(keyword)) {
				searchList.add(i);
			}
		}
		return searchList;
	}

	public Book deleteBook(String title, String author) {
		// 삭제된 도서를 담을 Book객체 (Book removeBook) 선언 및 null로 초기화
		// 반복문을 통해 bookList의 책 중 책 명이 전달 받은 title과 동일하고
		// 저자 명이 전달 받은 author와 동일한 경우 해당 인덱스 도서 삭제 후 빠져나감
		// 이 때 해당 인덱스 도서를 removeBook에 대입 후 removeBook 반환
		Book removeBook = null;
		for (int i = 0 ; i < list.size();i++) {
			if (list.get(i).getTitle().equals(title) && list.get(i).getAutor().equals(author)) {
				removeBook = list.get(i);
				list.remove(i);
			}
		}
		return removeBook;
	}


	public int ascBook() {
		// 책 이름으로 오름차순 후 1 반환 
		 Collections.sort(list);
		 return 1;
	}
	
}
