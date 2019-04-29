package com.kh.practice.list.music.view;

import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {
		while (true) {
			System.out.println("=====***** ���θ޴� *****=====");
			System.out.println("1. ������ ��ġ�� �� �߰�");
			System.out.println("2. ù ��ġ�� �� �߰�");
			System.out.println("3. ��ü �� ��� ���");
			System.out.println("4. Ư�� �� �˻�");
			System.out.println("5. Ư�� �� ����");
			System.out.println("6. Ư�� �� ����");
			System.out.println("7. �� �� �������� ����");
			System.out.println("8. ���� �� �������� ����");
			System.out.println("9. ����");
			System.out.print("\n�޴� ��ȣ �Է� : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("���α׷� ����.");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
		}
	}

	public void addList() {
		System.out.println("****** ������ ��ġ�� �� �߰� ****** ");
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		int check = mc.addList(new Music(title, singer));
		if (check == 1) {
			System.out.println("�߰� ����\n");
		} else {
			System.out.println("�߰� ����\n");
		}
	}

	public void addAtZero() {
		System.out.println("****** ù ��ġ�� �� �߰� ****** ");
		System.out.print("�� �� : ");
		String title = sc.nextLine();
		System.out.print("���� �� : ");
		String singer = sc.nextLine();
		int check = mc.addAtZero(new Music(title, singer));
		if (check == 1) {
			System.out.println("�߰� ����\n");
		} else {
			System.out.println("�߰� ����\n");
		}
	}

	public void printAll() {
		System.out.println("****** ��ü �� ��� ��� ****** ");
		// MusicController�� printAll()�� ���� ���� (������ 1�� �д�)
		// ���� �� ����� ������, ���� �� ����� ���С� �ܼ� â�� ���
		if (mc.printAll() == 1) {
			System.out.println("��¼���");
		} else {
			System.out.println("��½���");
		}
	}

	public void searchMusic() {
		System.out.println("****** Ư�� �� �˻� ****** ");
		// ����ڿ��� �� �̸��� �ް� MusicController�� �ִ� searchMusic���� ���� �ѱ��.
		// searchMusic()�� ��ȯ���� ���� ��ȯ ���� ������ ���˻��� ���� �����ϴ�.��
		// ��ȯ ���� ������ ���˻��� ���� 000(�� ��, ���� ��) �Դϴ�.�� �ܼ�â�� ���
		System.out.print("�˻��� �� �� : ");
		String title = sc.nextLine();
		Music ms = mc.searchMusic(title);
		if (ms == null) {
			System.out.println("�˻��� ���� �����ϴ�.");
		} else {
			System.out.println(ms);
		}
		System.out.println();
	}

	public void removeMusic() {
		System.out.println("****** Ư�� �� ���� ****** ");
		// ����ڿ��� ������ ���� �̸��� ���� �ް� MusicController�� removeMusic���� ���� �ѱ��. removeMusic()��
		// ��ȯ ���� ���� ��ȯ ���� ������ �� ������ ���� �����ϴ�.�� ��ȯ ���� ������ ��000(�� ��, ���� ��)�� ���� �߽��ϴ١� �ܼ� â��
		// ���
		System.out.print("������ �� �� : ");
		String title = sc.nextLine();
		Music ms = mc.removeMusic(title);
		if (ms == null) {
			System.out.println("�˻��� ���� �����ϴ�.");
		} else {
			System.out.println(ms + "��(��) �����߽��ϴ�.");
		}
		System.out.println();
	}

	public void setMusic() {
		System.out.println("****** Ư�� �� ���� ���� ****** ");
		// ����ڿ��� ������ ���� �Է� �Ͽ� MusicController�� setMusic���� �˻� �� �� �ְ� ���� �ѱ�� ������ �� ��� ����
		// ���� �޾� setMusic���� ���� �ѱ��. �˻� ��� ���� ������ �������� ���� �����ϴ�.��, �˻� ��� ���� �ְ� ���� ������
		// ��000(�� ��, ���� ��)�� ���� ���� �Ǿ����ϴ�.�� �ܼ� â�� ���
		System.out.print("�˻��� �� �� : ");
		String title_s = sc.nextLine();
		System.out.print("������ �� �� : ");
		String title_m = sc.nextLine();
		System.out.print("������ ���� �� : ");
		String singer_m = sc.nextLine();
		Music music = new Music(title_m, singer_m);
		Music ms = mc.setMusic(title_s, music);
		if (ms == null) {
			System.out.println("������ ���� �����ϴ�.");
		} else {
			System.out.println(ms + "�� ���� ����Ǿ����ϴ�.");
		}
		System.out.println();
	}

	public void ascTitle() {
		System.out.println("****** �� �� �������� ���� ****** ");
		// MusicController�� ascTitle()�� ���� ���� ���� �� ������ ������, ���� �� ������ ���С�
		if (mc.ascTitle() == 1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}

	public void descSinger() {
		System.out.println("****** ���� �� �������� ���� ****** ");
		// musicController�� descSinger()�� ���� ���� ���� �� ������ ������, ���� �� ������ ���С�
		if (mc.descSinger() == 1) {
			System.out.println("���� ����");
		} else {
			System.out.println("���� ����");
		}
	}
}
