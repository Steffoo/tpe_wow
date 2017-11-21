package ex3.wesen;

/**
 * Spezialisierung von Spielwesen": Rasse Nachtelf
 * @param lebenspunkte, schaden, geschwindigkeit, ruestung
 *
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 * 
 */

public class Nachtelf extends Spielwesen {
 
    public static final int KOSTEN = 145;    
     
    @Override
    public int getKosten() {
        return KOSTEN;
    }
    
    // Konstruktor
	public Nachtelf() {
		super(120, 15, 3, 0.2);
	}
}
