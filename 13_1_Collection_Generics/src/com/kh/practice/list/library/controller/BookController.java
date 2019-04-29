package com.kh.practice.list.library.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.library.model.vo.Book;

public class BookController {
	private List<Book> list = new ArrayList();

	public BookController() {
		// �ʱ� �� 4�� �߰�
		list.add(new Book("�ڹ��� ����", "���� ��", "��Ÿ", 20000));
		list.add(new Book("���� ���� �˰���", "������", "��Ÿ", 15000));
		list.add(new Book("��ȭ�� ���", "������", "�ι�", 17500));
		list.add(new Book("�� ������", "�ڽſ�", "�Ƿ�", 21000));
	}

	public void insertBook(Book bk) {
		// ���� ���� bk�� bookList�� �߰�
		list.add(bk);
	}

	public ArrayList selectList() {
		// �ش� bookList�� �ּ� �� ��ȯ
		return (ArrayList) list;
	}

	public ArrayList searchBook(String keyword) {
		// �˻� ��� ����Ʈ�� ����� ����Ʈ(ArrayList searchList) ���� �� ����
		// �ݺ����� ���� list�� å �� å �� ���� ���� keyword�� ���ԵǾ��ִ� ���
		// searchList�� �ش� å �߰��ϰ� searchList ��ȯ
		ArrayList searchList = new ArrayList();
		for (Book i : list) {
			if (i.getTitle().contains(keyword)) {
				searchList.add(i);
			}
		}
		return searchList;
	}

	public Book deleteBook(String title, String author) {
		// ������ ������ ���� Book��ü (Book removeBook) ���� �� null�� �ʱ�ȭ
		// �ݺ����� ���� bookList�� å �� å ���� ���� ���� title�� �����ϰ�
		// ���� ���� ���� ���� author�� ������ ��� �ش� �ε��� ���� ���� �� ��������
		// �� �� �ش� �ε��� ������ removeBook�� ���� �� removeBook ��ȯ
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
		// å �̸����� �������� �� 1 ��ȯ 
		 Collections.sort(list);
		 return 1;
	}
	
}
