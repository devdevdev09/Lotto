package com.heo.lotto;

import com.heo.lotto.service.GameService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LottoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void checkTest(){
		GameService gameService = new GameService();
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,8};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		if(result == 1)
			System.out.println("1등");
		else
			System.out.println("result : " + result);

	}

}
