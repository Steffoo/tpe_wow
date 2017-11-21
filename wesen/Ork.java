package ex3.wesen;

/**
 * Spezialisierung von Spielwesen": Rasse Ork
 * @param lebenspunkte, schaden, geschwindigkeit, ruestung
 *
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 * 
 */

public class Ork extends Spielwesen {
    
    public static final int KOSTEN = 150;
    
    @Override
    public int getKosten() {
        return KOSTEN;
    }

    // Konstruktor
	public Ork() {
		super(100, 33, 1, 0.3);
	}
  
}
