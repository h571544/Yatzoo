package no.hvl.dat109.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import no.hvl.dat109.RegelBok;
import no.hvl.dat109.Terning;
import no.hvl.dat109.TerningSett;

class UnitTestRegler {
	private TerningSett ts = new TerningSett(5);
	private RegelBok regler = new RegelBok();

	
	@Test
	void testDyr() {
		for(Terning t: ts.getTerningSett()) {
			t.setDyr("love");
		}
		assertEquals(regler.dyr(ts, "love"), 5);
		assertFalse(regler.dyr(ts, "love") == 4);
	}
	
	@Test
	void testNLike() {
		for(Terning t: ts.getTerningSett()) {
			t.setDyr("love");
		}
		//assertTrue(regler.nLike(ts, 3));
		//assertTrue(regler.nLike(ts, 4));
		//assertTrue(regler.nLike(ts, 5));
	}
	
	@Test
	void testToPar() {
		
		for(int i = 0; i < ts.getTerningSett().size() - 1; i++) {
			if(i < ts.getTerningSett().indexOf(3)) {
				ts.getTerningSett().get(i).setDyr("love");
			} else {
				ts.getTerningSett().get(i).setDyr("slange");
			}
		}
		assertTrue(regler.toPar(ts));
	}
	
	@Test
	void testHus() {
		
	}
	
	

}
