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
		 *  �� �ڽŰ� �Ű������� ���� obj�� ���ٸ� 
		 *  �翬�� �츮�� �����ϴ�
		 */
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			/*
			 * �Ű������� ���� obj�� null�̶��
			 * �翬�� �츮�� ���������ʴ�
			 */
			return false;
		}
		if(getClass() != obj.getClass()) {
			/*
			 * �� Ŭ���� ������ obj�� Ŭ���� ������ ���� �ʴٸ�
			 * �츮�� �翬�� �������� �ʴ�
			 */
			return false;
		}
		
		Student other = (Student)obj; // ������ �ٿ� ĳ����
		if(name == null) { // �� �ȿ� �ִ� name ���� ���� �� (null�� ��)
			if(other.name != null) { // ����  null�ε� �Ű������� name�� ���� �ִ�?
				return false; // �ٸ���,,,
			}
		}
		else if(!name.equals(other.name)) { // name���� ���� ��
			return false;
		}
		
		if(score != other.score) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() { // equals���ϸ� hashCode�� �����ϴ°� ���
		final int prime = 31; // ��ǻ�Ͱ� ����Ҷ� ������ ū �Ҽ��� 31
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		
		return result;
	}
	
	@Override
	public int compareTo(Object o) {
		//                �� ��� (��(this) : �� ��ü)
		// �̸� ��������
		
		String other = ((Student)o).getName();
		
		// int result = -name.compareTo(other) ��������
		int result = name.compareTo(other);
		//			StringŬ������ �ִ� compareTo�޼ҵ�� ��
		return result; // -result ���̸� ��������
		/*
		 * �� ��ü�� �� ���� ������ 0��ȯ
		 * �� ��ü�� �� ��󺸴� ũ�� 1��ȯ
		 * �� ��ü�� �� ��󺸴� ������ -1��ȯ
		 */
	}
}
