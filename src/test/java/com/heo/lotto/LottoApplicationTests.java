package com.heo.lotto;

import com.heo.lotto.service.GameService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LottoApplicationTests {

	@Test
	void contextLoads() {
	}

	GameService gameService;

	@Test
	void checkTest(){
		gameService = new GameService();
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,7};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		if(result == 1)
			System.out.println("test");

	}

}
