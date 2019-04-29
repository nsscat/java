package com.kh.example.list.model.vo;

public class Student implements Comparable {
	private String name;
	private int score;
	
	public Student() {
		
	}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	
	@Override
	public String toString() {
		return "( " + name + ", " + score + " )";
	}
	
	@Override
	public boolean equals(Object obj) {
		/*
		 *  내 자신과 매개변수로 들어온 obj가 같다면 
		 *  당연히 우리는 동일하다
		 */
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			/*
			 * 매개변수로 들어온 obj가 null이라면
			 * 당연히 우리는 동일하지않다
			 */
			return false;
		}
		if(getClass() != obj.getClass()) {
			/*
			 * 내 클래스 정보와 obj의 클래스 정보가 같지 않다면
			 * 우리는 당연히 동일하지 않다
			 */
			return false;
		}
		
		Student other = (Student)obj; // 다형성 다운 캐스팅
		if(name == null) { // 내 안에 있는 name 값이 없을 때 (null일 때)
			if(other.name != null) { // 나는  null인데 매개변수의 name은 값이 있다?
				return false; // 다른애,,,
			}
		}
		else if(!name.equals(other.name)) { // name값이 있을 대
			return false;
		}
		
		if(score != other.score) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() { // equals를하면 hashCode도 같이하는게 약속
		final int prime = 31; // 컴퓨터가 계산할때 적당히 큰 소수가 31
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		
		return result;
	}
	
	@Override
	public int compareTo(Object o) {
		//                비교 대상 (나(this) : 비교 주체)
		// 이름 오름차순
		
		String other = ((Student)o).getName();
		
		// int result = -name.compareTo(other) 내림차순
		int result = name.compareTo(other);
		//			String클래스에 있는 compareTo메소드로 비교
		return result; // -result 붙이면 내림차순
		/*
		 * 비교 주체가 비교 대상과 같으면 0반환
		 * 비교 주체가 비교 대상보다 크면 1반환
		 * 비교 주체가 비교 대상보다 작으면 -1반환
		 */
	}
}
