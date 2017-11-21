package ex3.spiel;
import ex3.anfuehrer.Daemonenjaeger;
import ex3.anfuehrer.Erzmagier;
import ex3.anfuehrer.Farseer;
import ex3.anfuehrer.Lich;
import ex3.wesen.Mensch;
import ex3.wesen.Nachtelf;
import ex3.wesen.Ork;
import ex3.wesen.Spielwesen;
import ex3.wesen.Squad;
import ex3.wesen.Untoter;

/**
 * Spiel-Klasse, die alle anderen Klassen nutzt
 *
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 * 
 */

public class GameController {
    /**
	 * Spiellogik
	 */
	public void runGame(String nameS1, String nameS2) {
		Squad squad_sp1 = new Squad(nameS1);
		Squad squad_sp2 = new Squad(nameS2);
		int runde = 1;
		
		// Squads füllen
		fuelleSquad(squad_sp1);
		fuelleSquad(squad_sp2);
		System.out.println();
		
		
		do {
			System.out.println("+++++ Runde " +runde+ " +++++");
			System.out.println();
			
			// Ausgaben der Lebenspunkte vor Angriff
			System.out.println("Lebenspunkte " +squad_sp1.getName()+ ": " +berechneLebenspunkte(squad_sp1));
			System.out.println("Lebenspunkte " +squad_sp2.getName()+ ": " +berechneLebenspunkte(squad_sp2));
			
			int zufall_angreifer = ((int) (Math.random() * squad_sp1.getWesen().size()));
			int zufall_verteidiger = ((int) (Math.random() * squad_sp2.getWesen().size()));
			Spielwesen angreifer = squad_sp1.getWesen(zufall_angreifer);
			Spielwesen verteidiger = squad_sp2.getWesen(zufall_verteidiger);

			
			String angr = angreifer.getClass().getSimpleName()+ " (Squad " +squad_sp1.getName();
			String vert = verteidiger.getClass().getSimpleName()+ " (Squad " +squad_sp2.getName();
			
			
			// One gegen One Kampf, bis einer tot ist
			do {
				System.out.println(angr+ ", " +angreifer.getLebenspunkte()+ " LP) "
								  + "greift " +vert+ ", " +verteidiger.getLebenspunkte()+ " LP) an");
				System.out.println("Schaden für " +vert+ "): " +angreifer.attack(verteidiger));

				// Kann der Verteidiger sich wehren?
				if (verteidiger.isLebendig()) {
					System.out.println(vert+ ", " +verteidiger.getLebenspunkte()+ " LP) "
									  + "greift " +angr+ ", " +angreifer.getLebenspunkte()+ " LP) an");
					System.out.println("Schaden für " +angr+ "): " +verteidiger.attack(angreifer));
					verteidiger.attack(angreifer);
				}
			} while (angreifer.isLebendig() && verteidiger.isLebendig());
			
			// Gewinner des Kampfes ausgeben
			if (!angreifer.isLebendig()) {
				System.out.println(vert+ ") hat den Kampf gewonnen");
				squad_sp1.getWesen().remove(zufall_angreifer);
			}
			
			if (!verteidiger.isLebendig()) {
				System.out.println(angr+ ") hat den Kampf gewonnen");
				squad_sp2.getWesen().remove(zufall_verteidiger);
			}
			System.out.println();
			runde++;
		} while (!squad_sp1.getWesen().isEmpty() && !squad_sp2.getWesen().isEmpty());
		
		// Gewinner ausgeben
		if (berechneLebenspunkte(squad_sp1) > 0) {
			System.out.println("Squad " +squad_sp1.getName()+ " hat gewonnen");
		}
		
		if (berechneLebenspunkte(squad_sp2) > 0) {
			System.out.println("Squad " +squad_sp2.getName()+ " hat gewonnen");
		}
	}
	
		
	/**
	 * @param sq Squad, für welches die Lebenspunkte berechnet werden sollen
	 * @return Ergebnis der Berechnung der Lebenspunkte Ergebnis auf 2 Nachkommastellen gerundet)
	 */

	public double berechneLebenspunkte(Squad s) {
		double lp_neu = 0;
		for (int i = 0; i < s.getWesen().size(); i++) {
			lp_neu += s.getWesen(i).getLebenspunkte();
		}
		return Math.round(lp_neu*100)/100.0;
	}
	
	/**
	 * Squads zufällig mit Wesen füllen <br>
	 * zufall(sq) liefert eine Zahl (=ein Wesen), welches aufgrund der Spielregeln noch gewählt werden darf
	 * (Nur 4 Anführer, jeder Anführer nur ein Mal, andere Wesen so oft wie gewünscht) <br>
	 * Vor jedem Hinzufügen wird geprüft, ob der Spieler noch genug Geld hat <br>
	 * 1: Mensch, 2: Nachtelf, 3: Ork, 4: Untoter, 5: Dämonenjäger, 6. Erzmagier, 7: Farseer, 8: Lich
	 * 
	 * @param sq Squad des jeweiligen Spielers
	 */
	private void fuelleSquad(Squad sq) {
		boolean[] gesetzt = new boolean[8];
		System.out.println("Squad " +sq.getName()+ " kauft: ");
	    do {
	    	int auswahl = zufall_index(sq, gesetzt);
	        switch (auswahl) {
	            case 1	:	if (sq.getGeld() >= Mensch.KOSTEN) {
	            				Mensch m = new Mensch();
	            				// Mensch zum Squad hinzufügen
		            			sq.getWesen().add(m);
		            			// Kosten für Mensch vom Kapital des Spielers abziehen
		            			sq.geldReduzieren(110);
	            			}	
	            			break;
	            			
	            			
	            case 2	:	if (sq.getGeld() >= Nachtelf.KOSTEN) {
	            				Nachtelf n = new Nachtelf();
	            				// Nachtelf zum Squad hinzufügen
	            				sq.getWesen().add(n);
	            				// Kosten für Nachtelf vom Kapital des Spielers abziehen
	            				sq.geldReduzieren(145);
	            			}
	            			break;
	            			
	            case 3	:	if (sq.getGeld() >= Ork.KOSTEN) {
	            				Ork o = new Ork();
	            				// Ork zum Squad hinzufügen
	            				sq.getWesen().add(o);
	            				// Kosten für Ork vom Kapital des Spielers abziehen
	            				sq.geldReduzieren(150);
	            			}
	            			break;
	            			
	            case 4	:	if (sq.getGeld() >= Untoter.KOSTEN) {
	            				Untoter u = new Untoter();
	            				// Untoten zum Squad hinzufügen
	            				sq.getWesen().add(u);
	            				// Kosten für Untoten vom Kapital des Spielers abziehen
	            				sq.geldReduzieren(70);
	            			}
	            			break;
	            			
	            case 5	:	if (sq.getGeld() >= Daemonenjaeger.KOSTEN) {
	            				Daemonenjaeger d = new Daemonenjaeger();
	            				// Dämonenjäger zum Squad hinzufügen
	            				sq.getWesen().add(d);
	            				// Kosten für Dämonenjäger vom Kapital des Spielers abziehen
	            				sq.geldReduzieren(290);
	            				gesetzt[4] = true;
	            			}
	            			break;
	            			
	            case 6	:	if (sq.getGeld() >= Erzmagier.KOSTEN) {
	            				Erzmagier e = new Erzmagier();
	            				// Erzmagier zum Squad hinzufügen
	            				sq.getWesen().add(e);
	            				// Kosten für Erzmagier vom Kapital des Spielers abziehen
	            				sq.geldReduzieren(220);
	            				gesetzt[5] = true;
	            			}
	            			break;
	            			
	            case 7	:	if (sq.getGeld() >= Farseer.KOSTEN) {
	            				Farseer f = new Farseer();
	            				// Farseer zum Squad hinzufügen
	            				sq.getWesen().add(f);
	            				// Kosten für Farseer vom Kapital des Spielers abziehen
	            				sq.geldReduzieren(300);
	            				gesetzt[6] = true;
	            			}
	            			break;
	            			
	            case 8	:	if (sq.getGeld() >= Lich.KOSTEN) {
	            				Lich l = new Lich();
	            				// Lich zum Squad hinzufügen
	            				sq.getWesen().add(l);
	            				// Kosten für Lich vom Kapital des Spielers abziehen
	            				sq.geldReduzieren(140);
	            				gesetzt[7] = true;
	            			}
	            			break;
	        }
	        
	        // Name des gekauften Wesen
	        System.out.print(sq.getWesen(sq.getWesen().size()-1).getClass().getSimpleName()+ " ");
	        System.out.print("(Restgeld: " +sq.getGeld()+ "), ");
	    } while (sq.getGeld() > 70);	// Nur solange der Spieler noch genug Geld hat, um das günstigste Wesen zu kaufen
	    
	    System.out.println();
	    
	    // Für Spieler 2 zurücksetzen
	    gesetzt = new boolean[8];
	}   
	
	/**
	 * Wenn bereits ein Anführer im Squad vorkommt, darf dieser nicht mehr erneut erzeugt werden. <br>
	 * Dazu erzeugt diese methode eine zufällige Zahl und überprüft anhand eines Boolean-Arrays, ob dieser Anführer schon existriert. <br>
	 * Falls ja, wird eine neue Zahl erzeugt.<br>
	 * Falls nein, wird diese Zahl zurückgegeben.<br>
	 * @param sq
	 * @return <b>(index+1)</b> Wesen, welches den Regeln entsprechend gewählt werden darf
	 */
	private int zufall_index(Squad sq, boolean[] gesetzt) {
		int index = 0;
		do {
			index = ((int) (Math.random()*8));
		} while (gesetzt[index] == true);
		
		return (index+1);
	}
}
