package com.winter.app.robot;

import org.springframework.stereotype.Component;

//bean 이름 직접 설정 가능
@Component("ra") // 객체생성
public class RightArm implements Arm {
	public void info() {

		System.out.println("오른팔 입니다.");
	}

}
