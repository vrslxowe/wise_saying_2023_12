package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService; //프라이빗 타입으로 해당클래스에서만 볼 수 있다

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService();//와이즈세잉서비스 객체를 담을 수 있는 와이즈세잉서비스 변수
	}

	public void write() {//등록 메서드
		System.out.print("명언 : "); // 메서드가 실행되면 명언:이 보여지고 옆에 글자를 입력할 수 있음
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");// 메서드가 실행되면 작가:가 보여지고 옆에 글자를 입력할 수 있음
		String author = Container.getScanner().nextLine().trim();

		int id = wiseSayingService.write(content, author); //정수만 담을 수 있는 id 변수에 와이즈세잉서비스 객체의 라이트 담기

		System.out.printf("%d번 명언이 등록되었습니다.\n", id); // 입력이 되면 번호와 함께 출력 문장이 뜬다
	}

	public void list() {
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();// 와이즈세잉서비스의 파인드올 기능을 와이즈세잉스리스트에 담기

		System.out.println("번호  /  작가  /  명언  ");// 출력문장
		System.out.println("=".repeat(30));// =를 30번 출력

		for (int i = wiseSayings.size() - 1; i >= 0; i--) {// 와이즈세잉스의 사이즈-1을 i에 넣음 사이즈가 0보다 크거나 같으면 i 1감소
			WiseSaying ws = wiseSayings.get(i);//와이즈세잉스의 i값을 와이즈세잉 타입의 ws변수에 담음

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent());//ws 변수의 번호 작가 명언 차례로 넣음 타입은 번호 문장 문장
		}
	}

	public void remove(Rq rq) {

		int id = rq.getIntParam("id", -1);//정수만 담을 수 있는 id변수에 rq클래스의 매개변수 담기 

		if (id == -1) { //id가 -1과 같을 때 실행
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;// 위의 출력값 리턴
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);//와이즈세잉타입의 와이즈세잉변수 와이즈세잉서비스의 파인드바이아이디 담기 매개변수 id

		if (wiseSaying == null) { //와이즈세잉이 널(비어있음)과 같을 때 실행
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return; //id의 타입은 정수이기때문에 데시멀써서 출력
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying); // 와이즈세잉서비스의 리무브 와이즈새잉 실행

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);//id타입 정수 데시멀과 같이 출력

	}

	public void modify(Rq rq) {// 수정하는 기능
		int id = rq.getIntParam("id", -1);//삭제와 동일한 기능

		if (id == -1) {//삭제와 동일한 기능
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);//수정해야하기때문에 원래 있던 명언번호를 입력하면 파인올을 해서 번호 찾음

		if (wiseSaying == null) {//파인드바이아이디의 id번호가 비어있을 때 실행
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;//id는 정수 번호이기때문에 입력한 번호와 함께 출력
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());// 파인바이아이디에 저장되어있는 번호의 기존 명언 불러옴
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());// 파인바이아이디에 저장되어있는 번호의 기존 작가 불러옴

		System.out.print("명언 : ");// 수정할 명언을 입력
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");// 수정할 작가 입력
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author); //와이즈세잉서비스의 모디파이와 매개변수 와이즈세잉번호 명언 작가 입력

		System.out.printf("%d번 명언이 수정되었습니다.\n", id); //파인바이아이디의 번호와 함ㄲㅔ 문장 출력

	}

}