package com.kh.practice.list.music.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.practice.list.music.model.compare.AscTitle;
import com.kh.practice.list.music.model.vo.Music;

public class MusicController {
	private List<Music> list = new ArrayList();

	public int addList(Music music) {
		// ������ ����Ʈ�� ��ü ����, 1 ����
		list.add(music);
		return 1;
	}

	public int addAtZero(Music music) {
		// ù ��° ����Ʈ�� ��ü ����, 1 ����
		list.add(0, music);
		return 1;
	}

	public int printAll() {
		// ��� ��ü �ܼ� â�� ���, 1 ����
		System.out.println(list);
		return 1;
	}

	public Music searchMusic(String title) {
		// �� ������ ��ü �˻�, ��ü�� ������ ��ü ���� ����, ������ null ����
		Music ms = null;
		for (Music i : list) {
			if (i.getTitle().contains(title)) {
				ms = i;
			}
		}
		return ms;
	}

	public Music removeMusic(String title) {
		// �� ������ ��ü �˻�, ��ü�� ������ ��ü ���� ����, ������ null ����
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
		// �� ������ ��ü �˻�, ��ü�� ������ ��ü ���� ����, ������ null ����
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
		// ����Ʈ �� �� �������� ����, ������ ������ ���� ������ �������� ����, 1 ����
		list.sort(new AscTitle());
		return 1;
	}

	public int descSinger() {
		// ����Ʈ ���� �� �������� ����, 1 ����
		Collections.sort(list);
		return 1;
	}
}
