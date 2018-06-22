package com.fanDuel.FanDuelTest;

import java.math.BigDecimal;

public class ParticipantClass implements Participant {

	public String name;
	public int score;
	public BigDecimal prize;

	/* A constructor that takes the name of the participant and the score */
	public ParticipantClass(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/* Getters and setters */
	public String getName() {

		return this.name;
	}

	public int getScore() {

		return this.score;
	}

	public BigDecimal getPrize() {

		return this.prize;
	}

	public void setPrize(BigDecimal prize) {

		this.prize = prize;
	}

}
