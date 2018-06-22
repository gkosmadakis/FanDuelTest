package com.fanDuel.FanDuelTest;

import java.math.BigDecimal;

public interface Participant {

	public String getName();

	public int getScore();

	// Prizes represent money using scale of 2 for cents
	public BigDecimal getPrize();

	public void setPrize(BigDecimal prize);
}
