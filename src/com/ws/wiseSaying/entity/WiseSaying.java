package com.ws.wiseSaying.entity;

public class WiseSaying {//와이즈세잉 클래스
	private int id;//와이즈세이 클래스에서만 볼 수 있는 아이디 명언 작가
	private String content;
	private String author;

	public WiseSaying(int id, String content, String author) {
		this.id = id;//해당 객체의 아이디 명언 작가
		this.content = content;
		this.author = author;
	}

	public int getId() {
		return id;//인트타입의 겟아이디 메서드에 해당 객체 번호 리턴
	}

	public void setId(int id) {
		this.id = id;//보이드타입 셋아이디 메서드에 정수 타입 아이디 매개변수에 들어가는 아이디를 해당 객체 아이디에 넣음
	}

	public String getContent() {
		return content;//스트링타입 겟콘텐트 메서드에 해당 객체 명언 리턴
	}

	public void setContent(String content) {
		this.content = content;//셋콘텐트 메서드에 스트링타입 콘텐트 매개변수에 들어가는 명언을 해당 객체 콘텐트에 넣음
	}

	public String getAuthor() {
		return author;//스트링타입 겟작가 메서드에 해당 객체 작가 리턴
	}

	public void setAuthor(String author) {
		this.author = author;//스트링타입 겟작가 메서드에 스트링타입 작가 매개변수에 들어가는 작가를 해당 객체 작가에 넣음
	}

}