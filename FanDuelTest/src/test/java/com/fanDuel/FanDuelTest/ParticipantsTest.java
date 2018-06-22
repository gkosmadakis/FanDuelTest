package com.fanDuel.FanDuelTest;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Participants. There are 7 test scenarios for the the test cases
 * exist in the main class These are : oneFirstOneSecondOneThird,
 * twoFirstOneSecond, oneFirstTwoSecond, twoFirstTwoSecond, threeFirst,
 * oneFirstThreeSecond, oneFirstOneSecondThreeThird
 */
public class ParticipantsTest {
	Map<Integer, BigDecimal> prizes;
	PrizeAllocatorClass prizeAllocator;

	@Before
	public void setup() {
		prizes = new HashMap<Integer, BigDecimal>();
		BigDecimal firstPrize = new BigDecimal(50.00);
		BigDecimal secondPrize = new BigDecimal(20.00);
		BigDecimal thirdPrize = new BigDecimal(10.00);
		prizes.put(1, firstPrize);
		prizes.put(2, secondPrize);
		prizes.put(3, thirdPrize);
		prizeAllocator = new PrizeAllocatorClass();
	}

	@Test
	public void testOneFirstOneSecondOneThird() {

		TournamentMain.oneFirstOneSecondOneThird(prizeAllocator, prizes);
		assertTrue(prizeAllocator.getOutputResults().contains("Adam       100 50.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Lily        90 20.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Megan       87 10.00"));
	}

	@Test
	public void testTwoFirstOneSecond() {

		TournamentMain.twoFirstOneSecond(prizeAllocator, prizes);
		assertTrue(prizeAllocator.getOutputResults().contains("George     100 35.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("John       100 35.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Lily        90 10.00"));
	}

	@Test
	public void testOneFirstTwoSecond() {

		TournamentMain.oneFirstTwoSecond(prizeAllocator, prizes);
		assertTrue(prizeAllocator.getOutputResults().contains("George     100 50.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Lily        90 15.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("John        90 15.00"));
	}

	@Test
	public void testTwoFirstTwoSecond() {

		TournamentMain.twoFirstTwoSecond(prizeAllocator, prizes);
		assertTrue(prizeAllocator.getOutputResults().contains("Mike       100 35.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("George     100 35.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Lily        90  5.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("John        90  5.00"));
	}

	@Test
	public void testThreeFirst() {

		TournamentMain.threeFirst(prizeAllocator, prizes);
		assertTrue(prizeAllocator.getOutputResults().contains("Mike       100 26.66"));
		assertTrue(prizeAllocator.getOutputResults().contains("Lily       100 26.66"));
		assertTrue(prizeAllocator.getOutputResults().contains("George     100 26.66"));
	}

	@Test
	public void testOneFirstThreeSecond() {

		TournamentMain.oneFirstThreeSecond(prizeAllocator, prizes);
		assertTrue(prizeAllocator.getOutputResults().contains("George     100 50.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Mike        90 10.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Lily        90 10.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Megan       90 10.00"));
	}

	@Test
	public void testOneFirstOneSecondThreeThird() {

		TournamentMain.oneFirstOneSecondThreeThird(prizeAllocator, prizes);
		assertTrue(prizeAllocator.getOutputResults().contains("George     100 50.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Lily        90 20.00"));
		assertTrue(prizeAllocator.getOutputResults().contains("Mike        87  3.33"));
		assertTrue(prizeAllocator.getOutputResults().contains("Sally       87  3.33"));
		assertTrue(prizeAllocator.getOutputResults().contains("Megan       87  3.33"));
	}

}
