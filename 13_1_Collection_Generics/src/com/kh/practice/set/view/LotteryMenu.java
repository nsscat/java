package com.kh.practice.set.view;

import java.util.Scanner;

import com.kh.practice.set.controller.LotteryController;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryMenu {
	private Scanner sc = new Scanner(System.in);
	private LotteryController lc = new LotteryController();

	public void mainMenu() {
		System.out.println("========== KH ��÷ ���α׷� ========== ");
		while (true) {
			System.out.println("=====***** ���� �޴� *****=====");
			System.out.println("1. ��÷ ��� �߰�");
			System.out.println("2. ��÷ ��� ����");
			System.out.println("3. ��÷ ��� Ȯ��");
			System.out.println("4. ���ĵ� ��÷ ��� Ȯ��");
			System.out.println("5. ��÷ ��� �˻�");
			System.out.println("9. ����\n");
			System.out.print("�޴� ��ȣ �Է� : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				insertObject();
				break;
			case 2:
				deleteObject();
				break;
			case 3:
				winObject();
				break;
			case 4:
				sortedWinObject();
				break;
			case 5:
				searchWinner();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	public void insertObject() {
//		�߰��� ��÷ ��� ���� �Է� �޾� �Է��� ����ŭ  ��÷�� �̸�(String name)�� ��÷�� �ڵ��� ��ȣ(String phone)�� �ް�,
//		�Ű����� �����ڸ� �̿��� Lottery ��ü�� ��÷�� ���� ����.    
//		Lottery ��ü�� lc(LotteryController)�� insertObject�� �����ϴµ� 
//		��, �ߺ��� ��÷ ��� �Է��߰ų� �Ǵ� �̹� ��÷ Set�� ����� �ִ� ��� ���ߺ��� ����Դϴ�. �ٽ� �Է��ϼ���.�� ��� �� �̾ �ٽ� ��ü �Է�.
//		��� �Է��� �Ϸ�Ǹ� ���߰� �Ϸ�Ǿ����ϴ١� ���.
		System.out.print("�߰� ��÷ ��� �� : ");
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < num; i++) {
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			System.out.print("�ڵ��� ��ȣ('-'����) : ");
			String phone = sc.nextLine();
			System.out.println();

			Lottery l = new Lottery(name, phone);
			lc.insertObject(l);
		}
		System.out.println(num + "�� �߰� �Ϸ�Ǿ����ϴ�.");
	}

	public void deleteObject() {
//		������ ����� �̸��� �ڵ��� ��ȣ�� �ް� �Ű����� �ִ� Lottery �����ڸ� �̿��� ��ü�� ������ ��� lc�� ��ü�� ����.
//		���� ����� ���� true�� ������ �Ϸ� �Ǿ����ϴ�.��, false�� ���������� �ʴ� ����Դϴ�.�� ��� 
	}

	public void winObject() {
//		lc���� �޾ƿ� Set��ü�� println()�޼ҵ带 ���� ��� 
	}

	public void sortedWinObject() {
//		lc���� �޾ƿ� Set��ü�� Iterator�� ���� ��� 
	}

	public void searchWinner() {
//		�˻��� ����� �̸��� �ڵ��� ��ȣ�� �ް� �Ű����� �ִ� Lottery �����ڸ� �̿���   ��ü�� ������ ��� lc�� ��ü�� ����.
//		���� ����� ���� true�� �������մϴ�. ��÷ ��Ͽ� �����մϴ�.��,   false�� ����Ÿ������ ��÷ ��Ͽ� �������� �ʽ��ϴ�.�� ���  
	}
}
