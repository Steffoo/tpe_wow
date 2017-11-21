package ex3.wesen;

/**
 * Spezialisierung von Spielwesen": Rasse Mensch
 * @param lebenspunkte, schaden, geschwindigkeit, ruestung
 *
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 * 
 */

public class Mensch extends Spielwesen {
    
    public static final int KOSTEN = 110;    
   
    @Override
    public int getKosten() {
        return KOSTEN;
    }
    
    // Konstruktor
    public Mensch() {
        super(140, 40, 2, 0.4);
    }
    
    
    
//	protected boolean mojo;
//	
//	public Mensch() {
//		this(false);
//	}
//	
//	// Konstruktor
//	public Mensch(boolean mojo) {
//		super(140, 40, 2, 0.4);
//		this.mojo = mojo;
//		
//		this.setSchaden((int)(this.getSchaden() * (mojo ? 1.2 : 0.9)));	
//	}
}
