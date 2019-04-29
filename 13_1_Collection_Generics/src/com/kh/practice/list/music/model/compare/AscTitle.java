package com.kh.practice.list.music.model.compare;

import java.util.Comparator;

import com.kh.practice.list.music.model.vo.Music;

public class AscTitle implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {

		Music standard = (Music) o1;
		Music object = (Music) o2;

		int num = standard.getTitle().compareTo(object.getTitle());

		if (num == 0) {
			num = standard.getSinger().compareTo(object.getTitle());
		}

		return num;
		// String standard = ((Music)o1).getTitle();
//		String object = ((Music)o2).getTitle();
//		
//		if(Integer.parseInt(standard) > Integer.parseInt(object)) {
//			return -1; // 내림차순이어서 음수 반환
//		}
//		else if(Integer.parseInt(standard) == Integer.parseInt(object)) {
//			return 0;
//		}
//		else {
//			return 1;
//		}
	}
}
