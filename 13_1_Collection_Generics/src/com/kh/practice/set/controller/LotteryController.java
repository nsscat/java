package com.kh.practice.set.controller;

import java.util.HashSet;

import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet lottery = new HashSet();
	private HashSet win = new HashSet();

	public boolean insertObject(Lottery l) {
		// 추첨 대상을 담을 HashSet 객체 생성(lottery)
		// 당첨 대상을 담을 HashSet 객체 생성(win) 
	}

	public boolean deleteObject(Lottery l) {
	}

	public HashSet windObject() {

	}

	public boolean searchWinner(Lottery l) {
	}
}
