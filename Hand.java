public class Hand {
	Card[] hand;
	public Hand(Card[] hand) {
		this.hand = hand;
	}
	
	public int[] getAllRankings() {
		int[] rankings = new int[hand.length];
		for (int i = 0; i < hand.length; i ++) {
			rankings[i] = hand[i].getRanking();
		}
		return rankings;
	}
	
	public int[] getAllSuites() {
		int[] suites = new int[hand.length];
		for (int i = 0; i < hand.length; i ++) {
			suites[i] = hand[i].getSuite();
		}
		return suites;
	}
	
	public Card[] getAsArray() {
		return hand;
	}

}
