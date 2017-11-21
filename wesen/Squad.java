package ex3.wesen;
import java.util.ArrayList;

/**
 * Squad mit ArrayList für Wesen, Startkapital und Lebenspunkten für einen Spieler
 * @param name Name des Squads
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 */

public class Squad {
	private String name;
	protected ArrayList<Spielwesen> wesen = new ArrayList<Spielwesen>();
	protected int geld = 2000;
	protected int lebenspunkte = 0;
	
	public Squad(String name) {
		this.name = name;
	}

	
	// Methoden
	/**
	 * 
	 * @param betrag Betrag, um den das Kapital verringert werden soll
	 */
	public void geldReduzieren(int betrag) {
		this.geld -= betrag;
	}

	
	// Getter und Setter
	/**
	 * @return Name des Squads
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Name des Squads
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param i Stelle, welche zurckgegeben werden soll
	 * @return Wesen an der Stelle i
	 */
	public Spielwesen getWesen(int i) {
		return this.wesen.get(i);
	}
	
	/**
	 * Gibt die ArrayList zurück, da diese private ist
	 */
	public ArrayList<Spielwesen> getWesen() {
		return this.wesen;
	}
	
	/**
	 * @return Aktueller Geldbetreg des Spielers
	 */
	public int getGeld() {
		return this.geld;
	}
}
