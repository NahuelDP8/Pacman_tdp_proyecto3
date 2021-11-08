package ranking;

import java.io.Serializable;

public class Player implements Serializable, Comparable<Player>{
	private String player;
	private Integer score;
	
	public Player(String p, int s) {
		player=p;
		score=s;
	}
	
	@Override
	public int compareTo(Player o) {
		return 0;
		//this.score.compareTo(GET SCORE);
	}
	
	public String getPlayer() {
		return player;
	}
	public int getScore() {
		return score;
	}
	
	public void setPlayer(String p) {
		player=p;
	}
	public void setScore(int s) {
		score=s;
	}
	
	public String toString() {
		return ("jugador: "+player+" tiene un puntaje de: "+ score);
	}
}
