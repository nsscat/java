package com.kh.practice.list.library.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice.list.library.controller.BookController;
import com.kh.practice.list.library.model.vo.Book;

public class BookMenu {
	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();

	public void mainMenu() {
		System.out.println("== Welcome KH Library ==");
		while (true) {
			System.out.println();
			System.out.println("***** ���� �޴� ******");
			System.out.println("1. �� ���� �߰�");
			System.out.println("2. ���� ��ü ��ȸ ");
			System.out.println("3. ���� �˻� ��ȸ");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� �� �������� ����");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				insertBook();
				break;
			case 2:
				selectList();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				ascBook();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");

			}
		}
	}

	public void insertBook() {
//		String title, String autor, String category, int price
//		1. ������ �Է¹ޱ� (String title)
//		2. ���ڸ� �Է¹ޱ� (String author)
//		3. �帣 �Է¹ޱ� (int category) --> ���ڷ� �Է¹ޱ� (1.�ι� / 2.�ڿ����� / 3.�Ƿ� / 4.��Ÿ)
//		4. ���� �Է¹ޱ� (int price)
//		5. �Ű����� �����ڸ� �̿��Ͽ� Book ��ü ����
//		(��ü ���� �� �帣 ��ȣ ���� ���ǽ� �̿��� �帣��ȣ�� �ƴ� �帣 ������ �� �Ѱܾ� ��)
//		6. bc(BookController)�� insertBook���� ���� Book ��ü ����
		System.out.println("==== ������ �߰� ====");
		System.out.println("å ������ �Է����ּ���.");
		System.out.print("���� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String autor = sc.nextLine();
		System.out.print("�帣��ȣ ( 1. �ι� / 2. ���� / 3. �ܱ��� / 4. ��Ÿ ) : ");
		int cate = sc.nextInt();
		String category = "";
		switch (cate) {
		case 1:
			category = "�ι�";
			break;
		case 2:
			category = "����";
			break;
		case 3:
			category = "�ܱ���";
			break;
		case 4:
			category = "��Ÿ";
			break;
		}
		System.out.print("���� : ");
		int price = sc.nextInt();

		bc.insertBook(new Book(title, autor, category, price));

	}

	public void selectList() {
//		1. bc(BookController)�� selectList() �޼ҵ带 ȣ�� ��
//		 --> ��� ���� ������ ����Ʈ(ArrayList<Book> bookList)�� ����
//		2. ���ǽ� �̿��ؼ�
//		 2_1. bookList�� "����ִ� ���" --> "�����ϴ� ������ �����ϴ�." ��� �˶� ���� ���
//		 2_2. bookList�� "������� ���� ���" --> �ݺ����� ���� bookList ���� Book ��ü�� ���

		ArrayList<Book> bookList = bc.selectList();
		int num = bookList.size();
		if (num != 0) {
			System.out.println("==== ���� ��ü ��ȸ ====");
			for (int i = 0; i < num; i++) {
				Book bk = bookList.get(i);
				System.out.println("\t" + bk);
			}
		} else {
			System.out.println("\n**�����ϴ� ������ �����ϴ�!!**\n");
		}

	}

	public void searchBook() {
//		1. �˻��� ������ Ű����� �Է� �ޱ� (String keyword)
//		2. bc(BookController)�� searchBook() �޼ҵ�� ���� keyword �� ���� ��
//		 --> ��� ���� ������ ����Ʈ(ArrayList<Book> searchList)�� ����
//		 ** ��� ���� �� ������ Book ��ü�� �ƴ϶� ����Ʈ�� ����
//		 ���� ���α׷����� �˻� �� �� Ǯ ������ �ļ� �˻����� �ʰ� Ű����� �˻�
//		 ��, Ű���带 ������ ����� �ϳ��� �ƴ� ���� ���� �� �ֱ� ������ ����Ʈ�� �ޱ�
//		3. ���ǽ� �̿��ؼ�
//		 3_1. searchList�� "����ִ� ���" --> "�˻� ����� �����ϴ�."��� �˶� ���� ���
//		 3_2. searchList�� "������� ���� ���" --> �ݺ������� searchList ���� Book ��ü�� ���
		System.out.println("==== ���� �˻� ====");
		System.out.print("�˻� Ű���� : ");
		String keyword = sc.nextLine();
		ArrayList<Book> searchList = bc.searchBook(keyword);
		if (searchList.size() == 0) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			for (Book i : searchList) {
				System.out.println(i);
			}
		}
	}

	public void deleteBook() {
//		1. ������ ������ �Է� �ޱ� (String title)
//		2. ������ ���ڸ� �Է� �ޱ� (String author)
//		** ������� ���ڸ��� ���� �Է� �޴� ����
//		 --> ���� �������̶�� �ص� ���ڸ��� �ٸ� ������ ���� �� �ֱ� ������
//		3. bc(BookConroller)�� deleteBook() �޼ҵ�� ���� title, autor �� ���� ��
//		--> ��� ���� ������ Book(Book remove)�� ����
//		4. ���ǽ� �̿��ؼ�
//		 4_1. remove�� �����ϴ� ��� --> "���������� �����Ǿ����ϴ�."��� ���� ���
//		 4_2. remove�� �������� ���� ��� --> "������ ������ ã�� ���߽��ϴ�."��� ���� ���
//		}
//		}
		// 5. ���� �� �������� ���Ŀ� view �޼ҵ�
		System.out.println("==== ���� ���� ====");
		System.out.print("���� �� ���� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� ���� �� :");
		String author = sc.nextLine();

		if (bc.deleteBook(title, author) != null) {
			System.out.println("���������� �����Ǿ����ϴ�.");
		} else {
			System.out.println("������ ������ ã�� ���߽��ϴ�.");
		}
	}

	public void ascBook() {
//		bc(BookController)�� ascBook() �޼ҵ� ���� ����
//		���� �� �����Ŀ� �����Ͽ����ϴ�.��, ���� �� �����Ŀ� �����Ͽ����ϴ�.�� ���
		if (bc.ascBook() > 0) {
			System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		}else {
			System.out.println("���Ŀ� �����Ͽ����ϴ�.");
		}
	}
}
