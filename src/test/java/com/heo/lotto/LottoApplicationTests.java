package com.heo.lotto;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.heo.lotto.service.DateService;
import com.heo.lotto.service.FileService;
import com.heo.lotto.service.GameService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LottoApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void 숫자만_추출하기(){
		String str = "[02][05][12][15][32][39]";
		FileService fs = new FileService(new DateService());
		String result = fs.getReplaceStr(str);

		assertEquals("02,05,12,15,32,39", result);
	}

	@Test
	void 게임회차_숫자_분리하기(){
		String str = "9982 : [02][05][12][15][32][39]";
		FileService fs = new FileService(new DateService());
		String[] result = fs.splitGameNumber(str);
		
		assertEquals(result[0], "9982");
		assertEquals(result[1], "[02][05][12][15][32][39]");
	}

	@Test
	void 로그1줄_데이터_분리하기(){
		String str = "2020-12-26 00:05:26.215  INFO 22075 --- [http-nio-8080-exec-3] com.heo.lotto.controller.GameController  : CREATE GAME NUMBER : 9998 : [15][21][28][29][34][35]";
		FileService fs = new FileService(new DateService());
		String[] result = fs.splitRow(str);

		assertEquals(result[0], "9998");
		assertEquals(result[1], "[15][21][28][29][34][35]");
	}

	@Test
	void 로그를_숫자_배열로(){
		String str = "12,17,25,37,39,40";
		FileService fs = new FileService(new DateService());
		int[] result = fs.logToNum(str);
		int[] exp = {12,17,25,37,39,40};

		assertArrayEquals(result, exp);
	}

	@Test
	void 컨트롤러_테스트(){
		// TODO...
	}



}

