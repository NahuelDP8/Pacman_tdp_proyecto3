package ranking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopPlayers implements Serializable{
	private List<Player>  rankingL;
	private int cant;
	
	public TopPlayers() {
		this.rankingL = new ArrayList<Player>();
		cant=0;
	}
	
	public void addPlayer (Player p) {
		if(p!=null) {
			this.rankingL.add(p);
			cant++;
			Collections.sort(this.rankingL,Collections.reverseOrder());
			this.ElimarExceso10();
		}
	}
	
	//Elimina del rankingL si hay mas de 10 players en la lista
	//Nuestra lista de topPlayers es de 10 Players
	private void ElimarExceso10() {
		if(!rankingL.isEmpty() && rankingL.size()>10) {
			rankingL.remove(10);
			cant--;
			}
		}
	
	//Preguntar si esta bien
	public int size() {
		return cant;
	}
	
	public boolean isEmpty() {
		return cant==0;
	}
	public Player getPlayer(int i) {
		return rankingL.get(i);
	}
}
