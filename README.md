# FanDuelTest

Tournament Settlement

In a tournament, prizes are distributed among the top N places in a tournament of M
players. Players are awarded a prize in order of their score (higher is better). In the case of
tied scores, the prize each receives is an equal share of the prizes for the positions they
cover. For example, if the top 2 players have the same score, they cover positions 1 and 2,
and split the prizes for positions 1 and 2 equally.

Example: First prize $50, Second prize $20, Third prize $10

Some sample outcomes are shown below, where there are four participants, with shading
on the tied scores:

Participant Score Prize

Sally 77 $50

Betty 66 $20

Don 46 $10

Megan 45 $0

Participant Score Prize

Peggy 77 $50

Tom 66 $15

Joan 66 $15

Ken 45 $0

Participant Score Prize

Roger 77 $50

Jane 66 $20

Pete 45 $5

Cooper 45 $5

Participant Score Prize

Harry 77 $50

Lane 45 $10

Stan 45 $10

Henry 45 $10

Participant Score Prize

Ted 77 $35

Trudy 77 $35

Bobby 46 $5

Paul 46 $5


Boilerplate:

public interface Participant {

public String getName();

public int getScore();

// Prizes represent money using scale of 2 for cents

public BigDecimal getPrize();

public void setPrize( BigDecimal prize );

}

public Interface PrizeAllocator {

void awardPrizes(
List<Participant> participants,
Map<Integer,BigDecimal> prizes );
}

The prize map is of the form

1 : first prize

2 : second prize

:

n : n-th prize

Questions:

Please provide a written answer to the questions below. Ideally, you should provide a
working Maven project for your solution to question 3. Be sure to use the interfaces given
so that we can easily test your solution.

1: How would you sort a list of participants by score?

2: What would you recommend when prize divisions have fractional cents (e.g., three
players tie for a $10 prize)?

3: Write a method which sets prizes based on participants’ scores. Where appropriate, use
your answers to the previous questions. You may assume that there are always more
participants than prizes. Note any additional assumptions as comments in your code.
Include unit tests that you think are appropriate.
