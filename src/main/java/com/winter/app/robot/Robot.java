package com.winter.app.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//객체생성 @controller, @Service @Repository @Component
@Component // new Robot
public class Robot {
	// 로봇은 오른쪽팔을 가지고 있다.

	// 팔을 담겠다 선언
	@Autowired // robot.setRightArm(rightArm); 주입해달라
	@Qualifier("ra")
	private Arm rightArm;// bean 의 이름은 class명의 첫글자를 소문자로 바꾼것
	@Autowired
	private Arm la;

	public Arm getRa() {
		return rightArm;
	}

	public void setRa(Arm ra) {
		this.rightArm = ra;
	}

	public Arm getLa() {
		return la;
	}

	public void setLa(Arm la) {
		this.la = la;
	}

}
