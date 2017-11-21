package ex3.spiel;

/**
 * Simulation, startet das Spiel und lässt die Squads bis zum bitteren Ende
 * gegeneinander kämpfen
 *
 * @author Steffen Bartsch (1515374), Julian Braasch (1512359)
 */
public class Simulation {
    public static void main(String[] args) {
        GameController g = new GameController(); 
        
        /**
         * Startet die Simulation
         * @param name, name
         */
        g.runGame("Steffen", "Julian");
    }
}
