package ex3.anfuehrer;
import ex3.wesen.Ork;

/**
 * Spezialisierung von "Ork": Anführer
 * @param lebenspunkte, schaden, geschwindigkeit, ruestung
 *
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 * 
 */

public class Farseer extends Ork {
	private static final double BONUSFAKTOR = 1.2;
	private static final String B_ELEMENT = "";	// Beherrschtes Element
	public static final int KOSTEN = 300;
	
	// Konstruktor
	public Farseer() {
		super();
	}
	
	// Methoden
	/**
	 * @return Informationen zu dieser Instanz
	 */
	@Override
	public String toString() {
		return (super.toString()+ ", Bonusfaktor " +this.getBonusfaktor()
		        + ", Beherrschtes Element: " + this.getB_element());
	}
	
    /**
     * Berechnet Schaden mit Bonusfaktor
     * @return double Schaden mit Bonusfaktor
     */   
	@Override
	protected double calcDamage() {
		return super.calcDamage() * getBonusfaktor();
	}
	
	// Getter und Setter
	/**
	 * @return Bonusfaktor dieses Anführers
	 */
	public double getBonusfaktor() {
		return BONUSFAKTOR;
	}
	
	/**
     * @return beherschtes Element
     */
	 private String getB_element(){
	        return B_ELEMENT;
	 }
	 
     /**
	  * Getter für Kosten des Farseer
	  * @return int Kosten für Farseer
	  */   
	 @Override
	    public int getKosten() {
	        return KOSTEN;
	 }
}
