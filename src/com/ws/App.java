package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1;

	public App() {

	}

	public void run() {
		System.out.println("== 명언 앱 실행 =="); // 실행했을 때 메인클래스에서 앱이 실행됐기때문에 콘솔에 가장 먼저 출력되는 문장

		SystemController systemController = new SystemController(); //시스템컨트롤러 타입의 시스템컨트롤러 객체만 담는 변수를 만듦
		WiseSayingController wiseSayingController = new WiseSayingController();// 동일하게 와이즈세잉컨트롤러 객체만 담는 변수를 만듦

		while (system_status == 1) { //시스템스타터스가 1과 같다면 실행
			System.out.print("명령어 ) "); // 위의 조건이 참일 때 출력
			String cmd = Container.getScanner().nextLine().trim();//스트링타입만 담는 cmd라는 변수에 컨테이너의 겟스캐너 실행 콘솔에 입력 기능
			Rq rq = new Rq(cmd); //rq타입의 rq객체만 담을 수 있는 변수 rq 인자 cmd

			switch (rq.getActionCode()) {
			case "종료":
				systemController.exit();
				system_status = 0;
				break; // 콘솔창에 종료를 입력하면 시스템컨트롤러의 엑시트가 실행
			case "등록":
				wiseSayingController.write();
				break;// 콘솔창에 등록을 입력하면 시스템컨트롤러의 롸이트가 실행
			case "목록":
				wiseSayingController.list();
				break;//콘솔창에 목록을 입력하면 와이즈세잉컨트롤러의 리스트가 실행
			case "삭제":
				wiseSayingController.remove(rq);
				break;// 콘솔창에 삭제를 입력하면 와이즈세잉컨트롤러의 리무브가 실행됨
			case "수정":
				wiseSayingController.modify(rq);
				break;// 콘솔창에 수정을 와이즈세잉컨트롤러의 모디파이가 실행됨
			default:
				System.out.println("존재하지 않는 명령어입니다");
				break; //위의 입력들 말고 다른 문장이나 단어, 문자를 입력했을 시 기본으로 출력되는 문장
			}
		}

	}
}