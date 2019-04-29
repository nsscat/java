package com.kh.practice.list.music.model.vo;

public class Music implements Comparable {
	private String title;
	private String singer;

	public Music() {
	}

	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getSinger() {
		return singer;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title + " - " + singer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((singer == null) ? 0 : singer.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (singer == null) {
			if (other.singer != null)
				return false;
		} else if (!singer.equals(other.singer))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		String other = ((Music)o).getSinger();
		return -singer.compareTo(other);
	}

}
