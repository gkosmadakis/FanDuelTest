package com.fanDuel.FanDuelTest;

import java.awt.Font;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TournamentMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JTextArea resultsTextArea;

	public static void main(String[] args) {

		/* i initialise a Graphic user interface to show the results */
		createAndShowGui();

		/* i have a map for the prizes */
		Map<Integer, BigDecimal> prizes = new HashMap<Integer, BigDecimal>();

		/* Initialise the three prizes and populate the map prizes */
		BigDecimal firstPrize = new BigDecimal(50.00);
		BigDecimal secondPrize = new BigDecimal(20.00);
		BigDecimal thirdPrize = new BigDecimal(10.00);

		prizes.put(1, firstPrize);
		prizes.put(2, secondPrize);
		prizes.put(3, thirdPrize);

		/*
		 * create an object from the class PrizeAllocator that will be used on
		 * the methods above
		 */
		PrizeAllocatorClass prizeAllocator = new PrizeAllocatorClass();

		/*
		 * Here i have 7 different combinations of winning players. The players
		 * are 6 so i am assuming that the players will be more than the prizes
		 */
		oneFirstOneSecondOneThird(prizeAllocator, prizes);
		twoFirstOneSecond(prizeAllocator, prizes);
		oneFirstTwoSecond(prizeAllocator, prizes);
		twoFirstTwoSecond(prizeAllocator, prizes);
		threeFirst(prizeAllocator, prizes);
		oneFirstThreeSecond(prizeAllocator, prizes);
		oneFirstOneSecondThreeThird(prizeAllocator, prizes);

		/* print the results to the text area */
		resultsTextArea.append(prizeAllocator.getOutputResults());
	}

	private static void createAndShowGui() {

		/* a frame */
		JFrame frame = new JFrame();
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tournament Results");

		/* the text area that contains the results */
		resultsTextArea = new JTextArea();
		resultsTextArea.setFont(new Font("monospaced", Font.PLAIN, 12));

		JScrollPane scrollPane = new JScrollPane(resultsTextArea);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		frame.add(scrollPane);

		frame.setVisible(true);
	}

	protected static void oneFirstOneSecondOneThird(PrizeAllocatorClass prizeAllocator, Map<Integer, BigDecimal> prizes) {

		List<Participant> participantsList = new ArrayList<Participant>();

		participantsList.add(new ParticipantClass("George", 80));
		participantsList.add(new ParticipantClass("Mike", 83));
		participantsList.add(new ParticipantClass("Lily", 90));
		participantsList.add(new ParticipantClass("Adam", 100));
		participantsList.add(new ParticipantClass("Megan", 87));
		participantsList.add(new ParticipantClass("Don", 85));

		prizeAllocator.awardPrizes(participantsList, prizes);

	}

	protected static void twoFirstOneSecond(PrizeAllocatorClass prizeAllocator, Map<Integer, BigDecimal> prizes) {

		List<Participant> participantsList = new ArrayList<Participant>();

		participantsList.add(new ParticipantClass("Mike", 80));
		participantsList.add(new ParticipantClass("Sally", 83));
		participantsList.add(new ParticipantClass("Lily", 90));
		participantsList.add(new ParticipantClass("George", 100));
		participantsList.add(new ParticipantClass("Megan", 87));
		participantsList.add(new ParticipantClass("John", 100));

		prizeAllocator.awardPrizes(participantsList, prizes);

	}

	protected static void oneFirstTwoSecond(PrizeAllocatorClass prizeAllocator, Map<Integer, BigDecimal> prizes) {

		List<Participant> participantsList = new ArrayList<Participant>();

		participantsList.add(new ParticipantClass("Mike", 80));
		participantsList.add(new ParticipantClass("Sally", 83));
		participantsList.add(new ParticipantClass("Lily", 90));
		participantsList.add(new ParticipantClass("George", 100));
		participantsList.add(new ParticipantClass("Megan", 87));
		participantsList.add(new ParticipantClass("John", 90));

		prizeAllocator.awardPrizes(participantsList, prizes);

	}

	protected static void twoFirstTwoSecond(PrizeAllocatorClass prizeAllocator, Map<Integer, BigDecimal> prizes) {

		List<Participant> participantsList = new ArrayList<Participant>();

		participantsList.add(new ParticipantClass("Mike", 100));
		participantsList.add(new ParticipantClass("Sally", 83));
		participantsList.add(new ParticipantClass("Lily", 90));
		participantsList.add(new ParticipantClass("George", 100));
		participantsList.add(new ParticipantClass("Megan", 87));
		participantsList.add(new ParticipantClass("John", 90));

		prizeAllocator.awardPrizes(participantsList, prizes);

	}

	protected static void threeFirst(PrizeAllocatorClass prizeAllocator, Map<Integer, BigDecimal> prizes) {

		List<Participant> participantsList = new ArrayList<Participant>();

		participantsList.add(new ParticipantClass("Mike", 100));
		participantsList.add(new ParticipantClass("Sally", 83));
		participantsList.add(new ParticipantClass("Lily", 100));
		participantsList.add(new ParticipantClass("George", 100));
		participantsList.add(new ParticipantClass("Megan", 87));
		participantsList.add(new ParticipantClass("John", 90));

		prizeAllocator.awardPrizes(participantsList, prizes);

	}

	protected static void oneFirstThreeSecond(PrizeAllocatorClass prizeAllocator, Map<Integer, BigDecimal> prizes) {

		List<Participant> participantsList = new ArrayList<Participant>();

		participantsList.add(new ParticipantClass("Mike", 90));
		participantsList.add(new ParticipantClass("Sally", 83));
		participantsList.add(new ParticipantClass("Lily", 90));
		participantsList.add(new ParticipantClass("George", 100));
		participantsList.add(new ParticipantClass("Megan", 90));
		participantsList.add(new ParticipantClass("John", 85));

		prizeAllocator.awardPrizes(participantsList, prizes);

	}

	protected static void oneFirstOneSecondThreeThird(PrizeAllocatorClass prizeAllocator, Map<Integer, BigDecimal> prizes) {

		List<Participant> participantsList = new ArrayList<Participant>();

		participantsList.add(new ParticipantClass("Mike", 87));
		participantsList.add(new ParticipantClass("Sally", 87));
		participantsList.add(new ParticipantClass("Lily", 90));
		participantsList.add(new ParticipantClass("George", 100));
		participantsList.add(new ParticipantClass("Megan", 87));
		participantsList.add(new ParticipantClass("John", 85));

		prizeAllocator.awardPrizes(participantsList, prizes);

	}
}
