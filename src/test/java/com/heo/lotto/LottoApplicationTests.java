package com.heo.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


}
