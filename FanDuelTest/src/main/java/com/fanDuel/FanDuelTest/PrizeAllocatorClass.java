package com.fanDuel.FanDuelTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrizeAllocatorClass implements PrizeAllocator {

	private StringBuilder outputResults = new StringBuilder();

	public void awardPrizes(List<Participant> participants, Map<Integer, BigDecimal> prizes) {

		/* scores is an arrayList of integers where i store all the scores */
		ArrayList<Integer> scores = new ArrayList<Integer>();
		/*
		 * the map groupedParticipants has key as score, value is a list with
		 * participants
		 */
		LinkedHashMap<Integer, List<Participant>> groupedParticipants = new LinkedHashMap<Integer, List<Participant>>();

		for (int i = 0; i < participants.size(); i++) {

			scores.add(participants.get(i).getScore());

		}
		/*
		 * I sort the scores in descending order so that the first will be the
		 * higher score
		 */
		Collections.sort(scores, Collections.reverseOrder());

		/*
		 * Here I group the participants based on their score. End up with:
		 * [100, [Par1, Par2]] [90, [Par3]]...etc I store them in the map
		 * groupedParticipants
		 */
		for (int j = 0; j < scores.size(); j++) {

			List<Participant> list = new ArrayList<Participant>();

			for (int i = 0; i < participants.size(); i++) {

				if (participants.get(i).getScore() == scores.get(j)) {

					list.add(participants.get(i));

					groupedParticipants.put(scores.get(j), list);
				}
			}
		}

		int counterPositionCovered = 1;

		/*
		 * Iterate the groupedParticipants map, the first entry on the for loop
		 * is the highest score. Add up the prize money which is the prize in $,
		 * based on the amount of participants and the position we've traversing
		 * now. counterPositionCovered cannot be more than the total amount of
		 * prizes position
		 */
		for (Map.Entry<Integer, List<Participant>> entry : groupedParticipants.entrySet()) {

			BigDecimal prizeMoney = new BigDecimal(0.0);

			for (int i = 0; counterPositionCovered < prizes.size() + 1
					&& i < entry.getValue().size(); counterPositionCovered++, i++) {

				prizeMoney = prizeMoney.add(new BigDecimal(prizes.get(counterPositionCovered).doubleValue()));

			}
			/*
			 * On this for loop set the prize for every participant, divide
			 * prizeMoney with the number of participants.
			 */
			for (Participant p : entry.getValue()) {

				/*
				 * Here i recommend and assume for the cases like prizeMoney=10$
				 * and three winners tied on this prize that 3.33$ will be given
				 * to each participant. The remainder of 1 cent could be taken
				 * from the company. For cases like prizeMoney=80$ and three
				 * participants tied on this prize, 26.66$ will be given to each
				 * participant and the remainder of 2 cents could be taken from
				 * the company.
				 */
				BigDecimal numberOfParticipants = new BigDecimal(entry.getValue().size());

				p.setPrize(prizeMoney.divide(numberOfParticipants, 2, RoundingMode.DOWN));

				System.out.println(p.getName() + " " + p.getScore() + " " + p.getPrize());
				/*
				 * append the results to the stringBuilder and format the
				 * columns
				 */
				outputResults.append(String.format("%-10s %3s %5s\n", p.getName(), p.getScore(), p.getPrize()));

			}

		}
		outputResults.append("\n");
	}

	public String getOutputResults() {

		return this.outputResults.toString();
	}

}
