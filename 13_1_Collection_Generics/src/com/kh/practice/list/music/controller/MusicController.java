package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList();

	public int addList(Music music) {
		// 마지막 리스트에 객체 저장, 1 리턴
		list.add(music);
		return 1;
	}

	public int addAtZero(Music music) {
		// 첫 번째 리스트에 객체 저장, 1 리턴
		list.add(0, music);
		return 1;
	}

	public int printAll() {
		// 모든 객체 콘솔 창에 출력, 1 리턴
		System.out.println(list);
		return 1;
	}

	public Music searchMusic(String title) {
		// 곡 명으로 객체 검색, 객체가 있으면 객체 정보 리턴, 없으면 null 리턴
		Music ms = null;
		for (Music i : list) {
			if (i.getTitle().contains(title)) {
				ms = i;
			}
		}
		return ms;
	}

	public Music removeMusic(String title) {
		// 곡 명으로 객체 검색, 객체가 있으면 객체 정보 삭제, 없으면 null 리턴
		Music ms = null;
		for (Music i : list) {
			if (i.getTitle().contains(title)) {
				ms = i;
				list.remove(i);
			}
		}
		return ms;
	}

	public Music setMusic(String title, Music music) {
		// 곡 명으로 객체 검색, 객체가 있으면 객체 정보 수정, 없으면 null 리턴
		Music ms = null;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTitle().contains(title)) {
				ms = list.get(i);
				list.set(i, music);
			}
		}

//		int index = 0;
//		for (Music i : list) {
//			if (i.getTitle().contains(title)) {
//				ms = i;	
//				list.remove(i);
//				list.add(index, music);
//			}
//			index++;
//		}
		return ms;
	}

	public int ascTitle() {
		// 리스트 곡 명 오름차순 정렬, 제목이 같으면 가수 명으로 오름차순 정렬, 1 리턴
		list.sort(new AscTitle());
		return 1;
	}

	public int descSinger() {
		// 리스트 가수 명 내림차순 정렬, 1 리턴
		Collections.sort(list);
		return 1;
	}
}
