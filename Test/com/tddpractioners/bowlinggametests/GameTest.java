package com.tddpractioners.bowlinggametests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tddpractioners.bowlinggame.Game;

class GameTest {

	private Game game;

	@BeforeEach
	public void setup() {
		game = new Game();
	}

	@Test
	public void should_not_score_for_gutterball() {

		Testroll(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

		assertEquals(game.score(), 0);
	}

	@Test
	public void should_score_one() {

		Testroll(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);

		assertEquals(game.score(), 20);
	}

	@Test
	public void should_score_A_spare5and5_followedBy_three_And_bonusOF_lastscoredPOINt3() {

		Testroll(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);

		assertEquals(game.score(), 16);
	}
	
	@Test
	public void should_score_A_Strike_10_and_add_scoresofthe_next_Frame_10_3_3() {
		Testroll(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
		assertEquals(game.score(), 22);
	}
	
	@Test
	public void should_score_perfectGame_10InAllThrows() {
		
		Testroll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
		assertEquals(game.score(), 300);
	}

	private void Testroll(int...rolls) {
		for (int pinsdown:rolls) {
			game.roll(pinsdown);
		}
	}
}
