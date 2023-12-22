package com.ws;

import java.util.Scanner;//스캐너 사용을 위한 임포트 불러오기

public class Container {//컨테이너 클래스
	private static Scanner sc;

	// 공통적으로 사용되는 자원들을 모아두는 공간 초기화
	public static void init() {
		sc = new Scanner(System.in);
	}

	// 공통적으로 사용되는 자원들을 모아두는 공간 자원 해제
	public static void close() {
		sc.close();
	}

	public static Scanner getScanner() {
		return sc;
	}
}