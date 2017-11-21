package ex3.wesen;

/**
 * Oberklasse für alle Spielfiguren
 * @param lebenspunkte, schaden, geschwindigkeit, ruestung, kosten
 *
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 */

public abstract class Spielwesen {
	private double lebenspunkte;
	private int schaden;
	private int geschwindigkeit;
	private double ruestung;
	protected static final int KOSTEN = 0;
	
	// Konstruktor
	protected Spielwesen(double lebenspunkte, int schaden, int geschwindigkeit, double ruestung /*, int kosten*/) {
		this.lebenspunkte = lebenspunkte;
		this.schaden = schaden;
		this.geschwindigkeit = geschwindigkeit;
		this.ruestung = ruestung;
//		this.kosten = kosten;
	}
	
    /**
     * Berechnet Schaden 
     * @return double Schaden
     */   
	protected double calcDamage() {
		double damage = this.getGeschwindigkeit() * this.getSchaden();
		
		return damage;
	}
	
	/**
	 * Schaden wird entsprechend der Rüstung des Verteidigers, dem Verteidiger abgezogen
	 * @param verteidiger 
	 * @return Schaden den der Verteidiger abgezogen bekommt
	 */
	public double attack(Spielwesen verteidiger) {
		double damage = calcDamage();
		
		double ruestung_verteidiger = verteidiger.getRuestung();
		damage = damage - (damage * ruestung_verteidiger);
		
		// Lebenspunkte abziehen
		verteidiger.setLebenspunkte(verteidiger.getLebenspunkte() - damage);
		
		return Math.round(damage*100)/100.0;
	}
	
	/**
	 * Testet ob angegriffenes Spielwesen noch lebendig ist
	 * @return <b>true</b> wenn Instanz mehr als 0 Lebenspunkte hat, ansonsten <b>false</b>
	 */
	public boolean isLebendig() {
		return (this.getLebenspunkte() > 0.0 ? true : false);
	}
	
	/**
	 * Liefert Informationen über Attribute und Werte des Spielwesens
	 * @return Informationen zu dieser Instanz
	 */
	@Override
	public String toString() {
		int ruestung_int = ((int) (this.getRuestung()*100));
		
		// Vorderer Teil
		String ergebnis = (this.getClass().getSimpleName()+ ": " +
				          this.getLebenspunkte()+ " Lebenspunkte, " +
				          this.getSchaden()+ " Schadenspunkte, ");
		
		// Syntax: 1 Punkt vs. x Punkte
		if (this.getGeschwindigkeit() == 1) {
			ergebnis += this.getGeschwindigkeit()+ " Geschwindigkeitspunkt, ";
		} else {
			ergebnis += this.getGeschwindigkeit()+ " Geschwindigkeitspunkte, ";
		}
		
		// Hintere Teil
		ergebnis += ruestung_int+ "% Rüstung, kostet "+this.getKosten()+ " Elfendollar";
		
		return ergebnis;
	}
	
	
	// Getter und Setter
	/** 
	 * @return Lebenspunkte dieser Instanz 
	 */
	public double getLebenspunkte() {
		return Math.round(this.lebenspunkte*100)/100.0;
	}
	
	/** 
	 * Neue Lebenspunkte für diese Instanz
	 * @param lebenspunkte
	 */
	public void setLebenspunkte(double lebenspunkte) {
			this.lebenspunkte = lebenspunkte;
	}
	
	/**
	 * @return Schadenspunkte 
	 */
	public int getSchaden() {
		return this.schaden;
	}
	
	/**
	 * Schadenspunkte dieser Instanz
	 * @param schaden
	 */
	public void setSchaden(int schaden) {
		this.schaden = schaden;
	}
	
	/**
	 * @return Geschwindigkeit dieser Instanz
	 */
	public int getGeschwindigkeit() {
		return this.geschwindigkeit;
	}
	
	/**
	 * Geschwindigkeit dieser Instanz
	 * @param geschwindigkeit
	 */
	public void setGeschwindigkeit(int geschwindigkeit) {
		this.geschwindigkeit = geschwindigkeit;
	}
	
	/**
	 * @return Prozentualer Rüstungswert
	 */
	public double getRuestung() {
		return this.ruestung;
	}
	
	/**
	 * Prozentualer Rüstungswert dieser Instanz
	 * @param ruestung
	 */
	public void setRuestung(double ruestung) {
		this.ruestung = ruestung;
	}

	/**
	 * @return Preis dieser Instanz
	 */
	public int getKosten() {
		return KOSTEN;
	}
}
