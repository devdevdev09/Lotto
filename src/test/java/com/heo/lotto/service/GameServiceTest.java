package com.heo.lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.heo.lotto.entity.RankType;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

@SpringBootTest
@TestComponent
public class GameServiceTest {

    GameService gameService = new GameService();

    @Test
    // 등수 체크
    public void isWinRank(){
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,6};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(1, result);
    }

    @Test
	void 등수_1등_체크하기(){
		
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,6};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(1, result);
	}

	@Test
	void 등수_2등_체크하기(){
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,8};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(2, result);
	}

	@Test
	void 등수_3등_체크하기(){
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,5,7};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(3, result);
	}

	@Test
	void 등수_4등_체크하기(){
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,4,8,7};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(4, result);
	}

	@Test
	void 등수_5등_체크하기(){
		int[] target = {1,2,3,4,5,6};
		int[] input = {1,2,3,9,8,7};
		int bonus = 8;

		int result = gameService.isWinRank(target, input, bonus);
		assertEquals(5, result);
	}

}
