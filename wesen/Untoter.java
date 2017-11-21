package ex3.wesen;

/**
 * Spezialisierung von Spielwesen": Rasse Untoter
 * @param lebenspunkte, schaden, geschwindigkeit, ruestung
 *
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 * 
 */

public class Untoter extends Spielwesen {
    public static final int KOSTEN = 70;  
    
    @Override
    public int getKosten() {
        return KOSTEN;
    }

    // Konstruktor
	public Untoter() {
		super(120, 16, 2, 0.3);
	}
}
