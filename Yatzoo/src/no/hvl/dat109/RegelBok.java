package no.hvl.dat109;

import java.util.ArrayList;
import java.util.HashMap;

public class RegelBok {

	public RegelBok() {

	}

	/**
	 * Poeng for et gitt dyr.
	 * 
	 * @param TerningSett
	 *            terningene, String dyr
	 * @return sum av antall dyr i terningkastet
	 * 
	 * @param TerningSett
	 *            terningene og String navnet paa dyret
	 * 
	 * @return sum av antall dyr i kastet
	 */
	public int dyr(TerningSett terningene, String dyr) {
		int sum = 0;
		for (Terning t : terningene.getTerningSett()) {
			if (t.getDyr().equals(dyr)) {
				sum += 1;
			}
		}
		return sum;
	}

	/**
	 * Finner n-like av terningkast.
	 * 
	 * @param Terningsett
	 *            terningene, int n, for 3,4 og 5 like.
	 * @return hvilket dyr som har n-like.
	 * 
	 * @param TerningsSett:
	 *            terningene
	 * @param int
	 *            n antall like terninger
	 * @return boolean, om det stemmer for terningkastet
	 */
	public boolean nLike(TerningSett terningene, int n) {
		ArrayList<Terning> terninger = terningene.getTerningSett();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int i = 0;
		for (Terning terning : terninger) {
			i = map.getOrDefault(terning.getDyr(), 0);
			i++;
			map.put(terning.getDyr(), i);
		}
		int antallLike = 0;
		int hittilFlestLike = 0;
		for (Terning terning : terninger) {
			antallLike = map.getOrDefault(terning.getDyr(), 0);
			if (hittilFlestLike == 0 || antallLike > hittilFlestLike) {
				hittilFlestLike = antallLike;
			}
		}
		return (hittilFlestLike >= n);
	}

	/**
	 * Sjekker terningsett listen om det er to par der, printer ut de parene
	 * 
	 * @param TerningSett
	 *            terningene
	 * @return boolean om det finnes to unike par i terningSettet.
	 */
	public boolean toPar(TerningSett terningene) {
		ArrayList<Terning> terninger = terningene.getTerningSett();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int i = 0;
		for (Terning terning : terninger) {
			i = map.getOrDefault(terning.getDyr(), 0);
			i++;
			map.put(terning.getDyr(), i);

		}
		int par = 0;
		int antallLike = 0;
		for (Terning terning : terninger) {
			antallLike = map.getOrDefault(terning.getDyr(), 0);
			if (antallLike >= 2) {
				par++;
			}

		}

		return (par / 2) == 2;
	}

	/**
	 * Et par og 3 like i et terningsett
	 * @param TerningSett: terningene.
	 * @return boolean om det stemmer for det gitte terningSettet.
	 */
	public boolean hus(TerningSett terningene) {
		ArrayList<Terning> terninger = terningene.getTerningSett();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		boolean toLike = false;
		boolean treLike = false;
		boolean hus = false;
		int i = 0;
		for (Terning terning : terninger) {
			i = map.getOrDefault(terning.getDyr(), 0);
			i++;
			map.put(terning.getDyr(), i);

		}
		for (Terning terning : terninger) {
			int antallLike = map.getOrDefault(terning.getDyr(), 0);
			if (antallLike == 2) {
				toLike = true;
			} else if (antallLike == 3) {
				treLike = true;
			}
		}

		hus = treLike && toLike;
		return hus;
	}

	/**
	 * Finner ut om alle terningene er unike.
	 * 
	 * @param TerningSett
	 *            terningene
	 * @return boolean enAvHver og finner ut om det stemmer for terningsSettet gitt i parameteret.
	 */
	public boolean enAvHver(TerningSett terningene) {
		ArrayList<Terning> terninger = terningene.getTerningSett();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		boolean enAvhver = true;
		int i = 0;
		for (Terning terning : terninger) {
			i = map.getOrDefault(terning.getDyr(), 0);
			i++;
			map.put(terning.getDyr(), i);

		}
		for (Terning terning : terninger) {
			int antallLike = map.getOrDefault(terning.getDyr(), 0);
			if (antallLike > 1) {
				if (enAvhver) {
					enAvhver = false;
				} else {
					return false;
				}
			}
		}
		return enAvhver;
	}
}
