package ex3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ex3.anfuehrer.Daemonenjaeger;
import ex3.anfuehrer.Erzmagier;
import ex3.anfuehrer.Farseer;
import ex3.anfuehrer.Lich;
import ex3.spiel.GameController;
import ex3.wesen.Mensch;
import ex3.wesen.Nachtelf;
import ex3.wesen.Ork;
import ex3.wesen.Squad;
import ex3.wesen.Untoter;

public class JUnitTest {
	private static final double PRECISION = 0.0001;
	private static final int STANDART_LP= 500;
	
	@Test
	public void testMensch() {
		Mensch m = new Mensch();
		
		
		// Eigenschaften des Menschen
		assertEquals(140, m.getLebenspunkte(), PRECISION);
		assertEquals(40, m.getSchaden());
		assertEquals(2, m.getGeschwindigkeit());
		assertEquals(0.4, m.getRuestung(), PRECISION);
		assertEquals(110, m.getKosten());
		
		
		// Objekt muss vor einem Kampf lebendig sein
		assertTrue(m.isLebendig());
	}
	
	@Test
	public void testNachtelf() {
		Nachtelf n = new Nachtelf();
		
		
		// Eigenschaften des Nachtelf
		assertEquals(120, n.getLebenspunkte(), PRECISION);
		assertEquals(15, n.getSchaden());
		assertEquals(3, n.getGeschwindigkeit());
		assertEquals(0.2, n.getRuestung(), PRECISION);
		assertEquals(145, n.getKosten());
		
		
		// Objekt muss vor einem Kampf lebendig sein
		assertTrue(n.isLebendig());
	}
	
	@Test
	public void testOrk() {
		Ork o = new Ork();
		
		
		// Eigenschaften des Ork
		assertEquals(100, o.getLebenspunkte(), PRECISION);
		assertEquals(33, o.getSchaden());
		assertEquals(1, o.getGeschwindigkeit());
		assertEquals(0.3, o.getRuestung(), PRECISION);
		assertEquals(150, o.getKosten());

		
		// Objekt muss vor einem Kampf lebendig sein
		assertTrue(o.isLebendig());
	}
	
	@Test
	public void testUntoter() {
		Untoter u = new Untoter();
		
		
		// Eigenschaften des Untoten
		assertEquals(120, u.getLebenspunkte(), PRECISION);
		assertEquals(16, u.getSchaden());
		assertEquals(2, u.getGeschwindigkeit());
		assertEquals(0.3, u.getRuestung(), PRECISION);
		assertEquals(70, u.getKosten());
		
		
		// Objekt muss vor einem Kampf lebendig sein
		assertTrue(u.isLebendig());
	}
	
	@Test
	public void testDaemonenjaeger() {
		Daemonenjaeger d = new Daemonenjaeger();
		Nachtelf n = new Nachtelf();
		
		
		// Eigenschaften des Dämonenjägers
		assertEquals(120, d.getLebenspunkte(), PRECISION);
		assertTrue(d.getLebenspunkte() == n.getLebenspunkte());
		
		assertEquals(15, d.getSchaden());
		assertTrue(d.getSchaden() == n.getSchaden());
		
		assertEquals(3, d.getGeschwindigkeit());
		assertTrue(d.getGeschwindigkeit() == n.getGeschwindigkeit());
		
		assertEquals(0.2, d.getRuestung(), PRECISION);
		assertTrue(d.getRuestung() == n.getRuestung());
		
		assertEquals(290, d.getKosten());
		assertFalse(d.getKosten() == n.getKosten());
		
		assertEquals(3.0, d.getBonusfaktor(), PRECISION);
		
		
		// Objekt muss vor einem Kampf lebendig sein
		assertTrue(d.isLebendig());
		assertTrue(n.isLebendig());
	}
	
	@Test
	public void testErzmagier() {
		Erzmagier e = new Erzmagier();
		Mensch m = new Mensch();
		
		
		// Eigenschaften des Erzmagiers
		assertEquals(140, e.getLebenspunkte(), PRECISION);
		assertTrue(e.getLebenspunkte() == m.getLebenspunkte());
		
		assertEquals(40, e.getSchaden());
		assertTrue(e.getSchaden() == m.getSchaden());
		
		assertEquals(2, e.getGeschwindigkeit());
		assertTrue(e.getGeschwindigkeit() == m.getGeschwindigkeit());
		
		assertEquals(0.4, e.getRuestung(), PRECISION);
		assertTrue(e.getRuestung() == m.getRuestung());
		
		assertEquals(220, e.getKosten());
		assertFalse(e.getKosten() == m.getKosten());
		
		assertEquals(5.0, e.getBonusfaktor(), PRECISION);
		
		
		// Objekt muss vor einem Kampf lebendig sein
		assertTrue(e.isLebendig());
		assertTrue(m.isLebendig());
	}
	
	@Test
	public void testFarseer() {
		Farseer f = new Farseer();
		Ork o = new Ork();
		
		
		// Eigenschaften des Farseer
		assertEquals(100, f.getLebenspunkte(), PRECISION);
		assertTrue(f.getLebenspunkte() == o.getLebenspunkte());
		
		assertEquals(33, f.getSchaden());
		assertTrue(f.getSchaden() == o.getSchaden());
		
		assertEquals(1, f.getGeschwindigkeit());
		assertTrue(f.getGeschwindigkeit() == o.getGeschwindigkeit());
		
		assertEquals(0.3, f.getRuestung(), PRECISION);
		assertTrue(f.getRuestung() == o.getRuestung());
		
		assertEquals(300, f.getKosten());
		assertFalse(f.getKosten() == o.getKosten());
		
		assertEquals(1.2, f.getBonusfaktor(), PRECISION);
		
		
		// Objekt muss vor einem Kampf lebendig sein
		assertTrue(f.isLebendig());
		assertTrue(o.isLebendig());
	}
	
	@Test
	public void testLich() {
		Lich l = new Lich();
		Untoter u = new Untoter();
		
		
		// Eigenschaften des Farseer
		assertEquals(120, l.getLebenspunkte(), PRECISION);
		assertTrue(l.getLebenspunkte() == u.getLebenspunkte());
		
		assertEquals(16, l.getSchaden());
		assertTrue(l.getSchaden() == u.getSchaden());
		
		assertEquals(2, l.getGeschwindigkeit());
		assertTrue(l.getGeschwindigkeit() == u.getGeschwindigkeit());
		
		assertEquals(0.3, l.getRuestung(), PRECISION);
		assertTrue(l.getRuestung() == u.getRuestung());
		
		assertEquals(140, l.getKosten());
		assertFalse(l.getKosten() == u.getKosten());
		
		assertEquals(2.3, l.getBonusfaktor(), PRECISION);
		
		
		// Objekt muss vor einem Kampf lebendig sein
		assertTrue(l.isLebendig());
		assertTrue(u.isLebendig());
	}
	
	/**
	 * Berechnet die Lebenspunkte eines Squads
	 */
	@Test
	public void testLP() {
	    GameController gc = new GameController();
	    Squad sq = new Squad(null);
	    Mensch m = new Mensch();
        Nachtelf n = new Nachtelf();
        Ork o = new Ork();
        Untoter u = new Untoter();
        Daemonenjaeger d = new Daemonenjaeger();
	    
        sq.getWesen().add(m);
        sq.getWesen().add(n);
        sq.getWesen().add(o);
        sq.getWesen().add(u);
        sq.getWesen().add(d);

	    assertEquals(600, gc.berechneLebenspunkte(sq), PRECISION);
	}
	
	/**
	 * Test der Ausgabe der toString()-Methode
	 */
	@Test
	public void testToString() {
		Mensch m = new Mensch();
		assertEquals("Mensch: 140.0 Lebenspunkte, 40 Schadenspunkte, "
		     	+ "2 Geschwindigkeitspunkte, 40% Rüstung, kostet 110 Elfendollar", 
		     	m.toString());
		
		Nachtelf n = new Nachtelf();
		assertEquals("Nachtelf: 120.0 Lebenspunkte, 15 Schadenspunkte, "
		     	+ "3 Geschwindigkeitspunkte, 20% Rüstung, kostet 145 Elfendollar", 
		     	n.toString());
		
		Ork o = new Ork();
		assertEquals("Ork: 100.0 Lebenspunkte, 33 Schadenspunkte, "
		     	+ "1 Geschwindigkeitspunkt, 30% Rüstung, kostet 150 Elfendollar", 
		     	o.toString());

		Untoter u = new Untoter();
		assertEquals("Untoter: 120.0 Lebenspunkte, 16 Schadenspunkte, "
		     	+ "2 Geschwindigkeitspunkte, 30% Rüstung, kostet 70 Elfendollar", 
		     	u.toString());

		Daemonenjaeger d = new Daemonenjaeger();
		assertEquals("Daemonenjaeger: 120.0 Lebenspunkte, 15 Schadenspunkte, "
		     	+ "3 Geschwindigkeitspunkte, 20% Rüstung, kostet 290 Elfendollar, "
		     	+ "Bonusfaktor 3.0, Beherrschtes Element: ", d.toString());

		Erzmagier e = new Erzmagier();
		assertEquals("Erzmagier: 140.0 Lebenspunkte, 40 Schadenspunkte, "
		     	+ "2 Geschwindigkeitspunkte, 40% Rüstung, kostet 220 Elfendollar, "
		     	+ "Bonusfaktor 5.0, Beherrschtes Element: ", e.toString());

		Farseer f = new Farseer();
		assertEquals("Farseer: 100.0 Lebenspunkte, 33 Schadenspunkte, "
		     	+ "1 Geschwindigkeitspunkt, 30% Rüstung, kostet 300 Elfendollar, "
		     	+ "Bonusfaktor 1.2, Beherrschtes Element: ", f.toString());

		Lich l = new Lich();
		assertEquals("Lich: 120.0 Lebenspunkte, 16 Schadenspunkte, "
		     	+ "2 Geschwindigkeitspunkte, 30% Rüstung, kostet 140 Elfendollar, "
		     	+ "Bonusfaktor 2.3, Beherrschtes Element: ", l.toString());
	}
	
	/**
	 * Jedes Wesen kämpft gegen jedes Wesen
	 */
	@Test
	public void testAttack() {
		Mensch m = new Mensch();
		Nachtelf n = new Nachtelf();
		Ork o = new Ork();
		Untoter u = new Untoter();
		Daemonenjaeger d = new Daemonenjaeger();
		Erzmagier e = new Erzmagier();
		Farseer f = new Farseer();
		Lich l = new Lich();
		
		m.setLebenspunkte(STANDART_LP);
		n.setLebenspunkte(STANDART_LP);
		o.setLebenspunkte(STANDART_LP);
		u.setLebenspunkte(STANDART_LP);
		d.setLebenspunkte(STANDART_LP);
		e.setLebenspunkte(STANDART_LP);
		f.setLebenspunkte(STANDART_LP);
		l.setLebenspunkte(STANDART_LP);
		
		// Mensch gegen Nachtelf
		m.attack(n);
		assertEquals(436, n.getLebenspunkte(), PRECISION);
		n.setLebenspunkte(STANDART_LP);
		
		// Mensch gegen Ork
		m.attack(o);
		assertEquals(444, o.getLebenspunkte(), PRECISION);
		o.setLebenspunkte(STANDART_LP);
		
		// Mensch gegen Untoter
		m.attack(u);
		assertEquals(444, u.getLebenspunkte(), PRECISION);
		u.setLebenspunkte(STANDART_LP);
		
		// Mensch gegen Daemonenjaeger
		m.attack(d);
		assertEquals(436, d.getLebenspunkte(), PRECISION);
		d.setLebenspunkte(STANDART_LP);
		
		// Mensch gegen Erzmagier
		m.attack(e);
		assertEquals(452, e.getLebenspunkte(), PRECISION);
		e.setLebenspunkte(STANDART_LP);
		
		// Mensch gegen Farseer
		m.attack(f);
		assertEquals(444, f.getLebenspunkte(), PRECISION);
		f.setLebenspunkte(STANDART_LP);
		
		// Mensch gegen Lich
		m.attack(l);
		assertEquals(444, l.getLebenspunkte(), PRECISION);
		l.setLebenspunkte(STANDART_LP);
		
		
		
		// Nachtelf gegen Mensch
		n.attack(m);
		assertEquals(473, m.getLebenspunkte(), PRECISION);
		m.setLebenspunkte(STANDART_LP);
		
		// Nachtelf gegen Ork
		n.attack(o);
		assertEquals(468.5, o.getLebenspunkte(), PRECISION);
		o.setLebenspunkte(STANDART_LP);

		// Nachtelf gegen Untoter
		n.attack(u);
		assertEquals(468.5, u.getLebenspunkte(), PRECISION);
		u.setLebenspunkte(STANDART_LP);

		// Nachtelf gegen Dämonenjäger
		n.attack(d);
		assertEquals(464, d.getLebenspunkte(), PRECISION);
		d.setLebenspunkte(STANDART_LP);
		
		// Nachtelf gegen Erzmagier
		n.attack(e);
		assertEquals(473, e.getLebenspunkte(), PRECISION);
		e.setLebenspunkte(STANDART_LP);

		// Nachtelf gegen Farseer
		n.attack(f);
		assertEquals(468.5, f.getLebenspunkte(), PRECISION);
		f.setLebenspunkte(STANDART_LP);

		// Nachtelf gegen Lich
		n.attack(l);
		assertEquals(468.5, l.getLebenspunkte(), PRECISION);
		l.setLebenspunkte(STANDART_LP);


		
		// Ork gegen Mensch
		o.attack(m);
		assertEquals(480.2, m.getLebenspunkte(), PRECISION);
		m.setLebenspunkte(STANDART_LP);

		// Ork gegen Nachtelf
		o.attack(n);
		assertEquals(473.6, n.getLebenspunkte(), PRECISION);
		n.setLebenspunkte(STANDART_LP);
		
		// Ork gegen Untoter
		o.attack(u);
		assertEquals(476.9, u.getLebenspunkte(), PRECISION);
		u.setLebenspunkte(STANDART_LP);
		
		// Ork gegen Dämonenjäger
		o.attack(d);
		assertEquals(473.6, d.getLebenspunkte(), PRECISION);
		d.setLebenspunkte(STANDART_LP);

		// Ork gegen Erzmagier
		o.attack(e);
		assertEquals(480.2, e.getLebenspunkte(), PRECISION);
		e.setLebenspunkte(STANDART_LP);

		// Ork gegen Farseer
		o.attack(f);
		assertEquals(476.9, f.getLebenspunkte(), PRECISION);
		f.setLebenspunkte(STANDART_LP);

		// Ork gegen Lich
		o.attack(l);
		assertEquals(476.9, l.getLebenspunkte(), PRECISION);
		l.setLebenspunkte(STANDART_LP);

		
		
		// Untoter gegen Mensch
		u.attack(m);
		assertEquals(480.8, m.getLebenspunkte(), PRECISION);
		m.setLebenspunkte(STANDART_LP);
		
		// Untoter gegen Nachtelf
		u.attack(n);
		assertEquals(474.4, n.getLebenspunkte(), PRECISION);
		n.setLebenspunkte(STANDART_LP);

		// Untoter gegen Ork
		u.attack(o);
		assertEquals(477.6, o.getLebenspunkte(), PRECISION);
		o.setLebenspunkte(STANDART_LP);

		// Untoter gegen Dämonenjäger
		u.attack(d);
		assertEquals(474.4, d.getLebenspunkte(), PRECISION);
		d.setLebenspunkte(STANDART_LP);

		// Untoter gegen Erzmagier
		u.attack(e);
		assertEquals(480.8, e.getLebenspunkte(), PRECISION);
		e.setLebenspunkte(STANDART_LP);

		// Untoter gegen Farseer
		u.attack(f);
		assertEquals(477.6, f.getLebenspunkte(), PRECISION);
		f.setLebenspunkte(STANDART_LP);
		
		// Untoter gegen Lich
		u.attack(l);
		assertEquals(477.6, l.getLebenspunkte(), PRECISION);
		l.setLebenspunkte(STANDART_LP);
		
		
		
		// Dämonenjäger gegen Mensch
		d.attack(m);
		assertEquals(419, m.getLebenspunkte(), PRECISION);
		m.setLebenspunkte(STANDART_LP);

		// Dämonenjäger gegen Nachtelf
		d.attack(n);
		assertEquals(392, n.getLebenspunkte(), PRECISION);
		n.setLebenspunkte(STANDART_LP);

		// Dämonenjäger gegen Ork
		d.attack(o);
		assertEquals(405.5, o.getLebenspunkte(), PRECISION);
		o.setLebenspunkte(STANDART_LP);

		// Dämonenjäger gegen Untoter
		d.attack(u);
		assertEquals(405.5, u.getLebenspunkte(), PRECISION);
		u.setLebenspunkte(STANDART_LP);

		// Dämonenjäger gegen Erzmagier
		d.attack(e);
		assertEquals(419, e.getLebenspunkte(), PRECISION);
		e.setLebenspunkte(STANDART_LP);

		// Dämonenjäger gegen Farseer
		d.attack(f);
		assertEquals(405.5, f.getLebenspunkte(), PRECISION);
		f.setLebenspunkte(STANDART_LP);

		// Dämonenjäger gegen Lich
		d.attack(l);
		assertEquals(405.5, l.getLebenspunkte(), PRECISION);
		l.setLebenspunkte(STANDART_LP);


		// Erzmagier gegen Mensch
		e.attack(m);
		assertEquals(260, m.getLebenspunkte(), PRECISION);
		m.setLebenspunkte(STANDART_LP);
		
		// Erzmagier gegen Nachtelf
		e.attack(n);
		assertEquals(180, n.getLebenspunkte(), PRECISION);
		n.setLebenspunkte(STANDART_LP);

		// Erzmagier gegen Ork
		e.attack(o);
		assertEquals(220, o.getLebenspunkte(), PRECISION);
		o.setLebenspunkte(STANDART_LP);

		// Erzmagier gegen Untoter
		e.attack(u);
		assertEquals(220, u.getLebenspunkte(), PRECISION);
		u.setLebenspunkte(STANDART_LP);
		
		// Erzmagier gegen Dämonenjäger
		e.attack(d);
		assertEquals(180, d.getLebenspunkte(), PRECISION);
		d.setLebenspunkte(STANDART_LP);

		// Erzmagier gegen Farseer
		e.attack(f);
		assertEquals(220, f.getLebenspunkte(), PRECISION);
		f.setLebenspunkte(STANDART_LP);

		// Erzmagier gegen Lich
		e.attack(l);
		assertEquals(220, l.getLebenspunkte(), PRECISION);
		l.setLebenspunkte(STANDART_LP);

		

		// Farseer gegen Mensch
		f.attack(m);
		assertEquals(476.24, m.getLebenspunkte(), PRECISION);
		m.setLebenspunkte(STANDART_LP);

		// Farseer gegen Nachtelf
		f.attack(n);
		assertEquals(468.32, n.getLebenspunkte(), PRECISION);
		n.setLebenspunkte(STANDART_LP);

		// Farseer gegen Ork
		f.attack(o);
		assertEquals(472.28, o.getLebenspunkte(), PRECISION);
		o.setLebenspunkte(STANDART_LP);

		// Farseer gegen Untoter
		f.attack(u);
		assertEquals(472.28, u.getLebenspunkte(), PRECISION);
		u.setLebenspunkte(STANDART_LP);
		
		// Farseer gegen Dämonenjäger
		f.attack(d);
		assertEquals(468.32, d.getLebenspunkte(), PRECISION);
		d.setLebenspunkte(STANDART_LP);

		// Farseer gegen Erzmagier
		f.attack(e);
		assertEquals(476.24, e.getLebenspunkte(), PRECISION);
		e.setLebenspunkte(STANDART_LP);

		// Farseer gegen Lich
		f.attack(l);
		assertEquals(472.28, l.getLebenspunkte(), PRECISION);
		l.setLebenspunkte(STANDART_LP);

		
		
		// Lich gegen Mensch
		l.attack(m);
		assertEquals(455.84, m.getLebenspunkte(), PRECISION);
		m.setLebenspunkte(STANDART_LP);

		// Lich gegen Nachtelf
		l.attack(n);
		assertEquals(441.12, n.getLebenspunkte(), PRECISION);
		n.setLebenspunkte(STANDART_LP);

		// Lich gegen Ork
		l.attack(o);
		assertEquals(448.48, o.getLebenspunkte(), PRECISION);
		o.setLebenspunkte(STANDART_LP);

		// Lich gegen Untoter
		l.attack(u);
		assertEquals(448.48, u.getLebenspunkte(), PRECISION);
		u.setLebenspunkte(STANDART_LP);
		
		// Lich gegen Dämonenjäger
		l.attack(d);
		assertEquals(441.12, d.getLebenspunkte(), PRECISION);
		d.setLebenspunkte(STANDART_LP);

		// Lich gegen Erzmagier
		l.attack(e);
		assertEquals(455.84, e.getLebenspunkte(), PRECISION);
		e.setLebenspunkte(STANDART_LP);

		// Lich gegen Farseer
		l.attack(f);
		assertEquals(448.48, f.getLebenspunkte(), PRECISION);
		f.setLebenspunkte(STANDART_LP);
	}
}
