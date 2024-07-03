package com.winter.app.robot;

//객체생성 @controller, @Service @Repository @Component
//@Component // new Robot
public class Robot {
	// 로봇은 오른쪽팔을 가지고 있다.

	// 팔을 담겠다 선언
	// @Autowired // robot.setRightArm(rightArm); 주입해달라
	// @Qualifier("ra")
	private Arm rightArm;// bean 의 이름은 class명의 첫글자를 소문자로 바꾼것
	// @Autowired
	private Arm leftArm;

	private int age;
	private String company;

	public Arm getRightArm() {
		return rightArm;
	}

	public void setRightArm(Arm rightArm) {
		this.rightArm = rightArm;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
