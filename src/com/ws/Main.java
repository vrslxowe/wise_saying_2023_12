package com.ws; 

public class Main { //실행하면 가장 먼저 찾는 클래스
	public static void main(String[] args) { //실행시 가장 먼자 찾는 메인 메서드
		
		Container.init();// 실행 시 컨테이너의 인잇을 실행 - 스캐너 실행 콘솔 입력을 하기위해서
		
		new App().run(); // 명령어를 입력했을 시 앱에 있는 기능을 실행함

		Container.close();// 컨테이너 공간의 기능들을 종료하는 기능
	}
}