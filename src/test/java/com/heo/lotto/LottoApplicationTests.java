package com.heo.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

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
	void 등수_1등_체크하기(){
		GameService gameService = new GameService();
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,6};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(1, result);
	}

	@Test
	void 등수_2등_체크하기(){
		GameService gameService = new GameService();
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,8};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(2, result);
	}

	@Test
	void 등수_3등_체크하기(){
		GameService gameService = new GameService();
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,7};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(3, result);
	}

	@Test
	void 등수_4등_체크하기(){
		GameService gameService = new GameService();
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,8,7};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(4, result);
	}

	@Test
	void 등수_5등_체크하기(){
		GameService gameService = new GameService();
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,9,8,7};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(5, result);
	}

	@Test
	void 숫자만_추출하기(){
		String str = "[02][05][12][15][32][39]";
		FileService fs = new FileService();
		String result = fs.getReplaceStr(str);

		assertEquals("02,05,12,15,32,39", result);
	}

	@Test
	void 게임회차_숫자_분리하기(){
		String str = "9982 : [02][05][12][15][32][39]";
		FileService fs = new FileService();
		String[] result = fs.splitGameNumber(str);
		
		assertEquals(result[0], "9982");
		assertEquals(result[1], "[02][05][12][15][32][39]");
	}

	@Test
	void 로그1줄_데이터_분리하기(){
		String str = "2020-12-26 00:05:26.215  INFO 22075 --- [http-nio-8080-exec-3] com.heo.lotto.controller.GameController  : CREATE GAME NUMBER : 9998 : [15][21][28][29][34][35]";
		FileService fs = new FileService();
		String[] result = fs.splitRow(str);

		assertEquals(result[0], "9998");
		assertEquals(result[1], "[15][21][28][29][34][35]");
	}

	@Test
	void 리소스_텍스트_읽어오기(){
		FileService fs = new FileService();
		List<String> result = fs.getFileRead("files/test.txt");

		assertEquals(3, result.size());
	}



}

