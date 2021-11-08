package ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TopPlayers implements Serializable{
	private List<Player>  rankingL;
	
	public TopPlayers() {
		this.rankingL = new ArrayList<Player>();
	}
	
	public void addPlayer (Player p) {
		this.rankingL.add(p);
	}
	
	//Elimina del rankingL si hay mas de 10 players en la lista
	//Nuestra lista de topPlayers es de 10 Players
	private void ElimarExceso10() {
		if(!rankingL.isEmpty() && rankingL.size()>10) {
			for(int i=10;i<rankingL.size();i++) {
			rankingL.remove(i);
			}
		}
	}
}
