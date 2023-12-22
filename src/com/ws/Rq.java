package com.ws;

import java.util.HashMap;
import java.util.Map; //해쉬맵과 맵을 사용하기 위한 임포트 불러오기

// Rq == Request(요청)
public class Rq {// Rq 클래스
	private String actionCode;//해당 클래스에서만 볼 수 있는 스트링 타입의 액션코드
	private Map<String, String> params;//

	public Rq(String cmd) {//
		String[] cmdBits = cmd.split("\\?", 2);

		actionCode = cmdBits[0];

		params = new HashMap<>();

		if (cmdBits.length == 1) {
			return;
		}

		String[] paramBits = cmdBits[1].split("&");

		for (String paramStr : paramBits) {
			String[] paramStrBits = paramStr.split("=", 2);

			if (paramStrBits.length == 1) {
				continue;
			}

			String key = paramStrBits[0];
			String value = paramStrBits[1];
			params.put(key, value);
		}

	}

	public String getActionCode() {
		return actionCode;
	}

	public String getParam(String name) {
		return params.get(name);
	}

	public int getIntParam(String name, int defaultValue) {
		try {
			return Integer.parseInt(getParam(name));
		} catch (NumberFormatException e) {

		}
		return defaultValue;
	}

}