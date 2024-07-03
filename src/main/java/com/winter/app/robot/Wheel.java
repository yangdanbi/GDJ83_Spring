package com.winter.app.robot;

public class Wheel {
	// robot에 부착할거임
	private int size;
	private String brand;
	private int count;

	// 게터만 있어서 꺼낼순 있지만 값을 집어넣을 순 없음

	// 생성자
	public Wheel(int size, String brand, int count) {
		this.size = size;
		this.brand = brand;
		this.count = count;
	}

	public int getSize() {
		return size;
	}

	public String getBrand() {
		return brand;
	}

	public int getCount() {
		return count;
	}

}
