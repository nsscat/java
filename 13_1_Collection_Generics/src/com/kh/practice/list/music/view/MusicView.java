package com.kh.practice.list.music.view;

import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();

	public void mainMenu() {
		while (true) {
			System.out.println("=====***** 메인메뉴 *****=====");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 수정");
			System.out.println("7. 곡 명 오름차순 정렬");
			System.out.println("8. 가수 명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("\n메뉴 번호 입력 : ");
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
				System.out.println("프로그램 종료.");
				return;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ****** ");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		int check = mc.addList(new Music(title, singer));
		if (check == 1) {
			System.out.println("추가 성공\n");
		} else {
			System.out.println("추가 실패\n");
		}
	}

	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ****** ");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		int check = mc.addAtZero(new Music(title, singer));
		if (check == 1) {
			System.out.println("추가 성공\n");
		} else {
			System.out.println("추가 실패\n");
		}
	}

	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ****** ");
		// MusicController에 printAll()의 값에 따라 (성공을 1로 둔다)
		// 성공 시 “출력 성공”, 실패 시 “출력 실패” 콘솔 창에 출력
		if (mc.printAll() == 1) {
			System.out.println("출력성공");
		} else {
			System.out.println("출력실패");
		}
	}

	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ****** ");
		// 사용자에게 곡 이름을 받고 MusicController에 있는 searchMusic으로 값을 넘긴다.
		// searchMusic()의 반환값에 따라 반환 값이 없으면 “검색한 곡이 없습니다.”
		// 반환 값이 있으면 “검색한 곡은 000(곡 명, 가수 명) 입니다.” 콘솔창에 출력
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		Music ms = mc.searchMusic(title);
		if (ms == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println(ms);
		}
		System.out.println();
	}

	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ****** ");
		// 사용자에게 삭제할 곡의 이름을 직접 받고 MusicController에 removeMusic으로 값을 넘긴다. removeMusic()의
		// 반환 값에 따라 반환 값이 없으면 “ 삭제할 곡이 없습니다.” 반환 값이 있으면 “000(곡 명, 가수 명)을 삭제 했습니다” 콘솔 창에
		// 출력
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		Music ms = mc.removeMusic(title);
		if (ms == null) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			System.out.println(ms + "을(를) 삭제했습니다.");
		}
		System.out.println();
	}

	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ****** ");
		// 사용자에게 수정할 곡을 입력 하여 MusicController에 setMusic으로 검색 할 수 있게 값을 넘기며 수정할 곡 명과 가수
		// 명을 받아 setMusic으로 값을 넘긴다. 검색 결과 값이 없으면 “수정할 곡이 없습니다.”, 검색 결과 값이 있고 수정 했으면
		// “000(곡 명, 가수 명)의 값이 변경 되었습니다.” 콘솔 창에 출력
		System.out.print("검색할 곡 명 : ");
		String title_s = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String title_m = sc.nextLine();
		System.out.print("수장할 가수 명 : ");
		String singer_m = sc.nextLine();
		Music music = new Music(title_m, singer_m);
		Music ms = mc.setMusic(title_s, music);
		if (ms == null) {
			System.out.println("수정할 곡이 없습니다.");
		} else {
			System.out.println(ms + "의 값이 변경되었습니다.");
		}
		System.out.println();
	}

	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ****** ");
		// MusicController에 ascTitle()의 값에 따라 성공 시 “정렬 성공”, 실패 시 “정렬 실패”
		if (mc.ascTitle() == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}

	public void descSinger() {
		System.out.println("****** 가수 명 내림차순 정렬 ****** ");
		// musicController에 descSinger()의 값에 따라 성공 시 “정렬 성공”, 실패 시 “정렬 실패”
		if (mc.descSinger() == 1) {
			System.out.println("정렬 성공");
		} else {
			System.out.println("정렬 실패");
		}
	}
}
