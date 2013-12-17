/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_modelisation_probs;

/**
 *
 * @author Admin
 */
public class main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		ArbreNAire<Integer> arbre = createArbre(3,2);
		depthSearch(arbre);
		arbre.goToRacine();
		minMax(arbre);
	}
	
	private static ArbreNAire<Integer> createArbre(int largeur, int profondeur) {
		ArbreNAire<Integer> arbre = new ArbreNAire<>(1);
		createArbre(arbre, largeur, profondeur);
		arbre.goToRacine();
		return arbre;
	}
	
	private static void createArbre(ArbreNAire<Integer> arbre, int largeur, int profondeur) {
		if (profondeur > 0) {
			for (int i = 0; i < largeur; i++) {
				int number = arbre.getItem() * 10 + i;
				arbre.addFils(arbre.getItem() * 10 + i);
				
				arbre.goToFils(i);
				arbre.setHeuristique(number);
				createArbre(arbre, largeur, profondeur - 1);
				arbre.goToPere();
			}
		}
	}
	
	private static void depthSearch(ArbreNAire<Integer> arbre) {
		if (!arbre.isRacine()) {
			System.err.print(" - ");
		}
		for (int i = 0; i < arbre.getNbFils(); i++) {
			arbre.goToFils(i);
			System.err.print(arbre.getItem());
			depthSearch(arbre);
			arbre.goToPere();
		}
	}
	
	private static void minMax(ArbreNAire<Integer> arbre) {
		int min = -1;
		int max = -1;
		int MaxHeuristique = -1;
		for (int i = 0; i < arbre.getNbFils(); i++) {
			
			arbre.goToFils(i);
			int nbFils = arbre.getNbFils();
			
			for (int j = 0; j < nbFils; j++) {
				arbre.goToFils(j);
				if (min == -1 || min > arbre.getHeuristique()) {
					min = arbre.getHeuristique();
				}
				arbre.goToPere();
			}
			
			
			if (max == -1 || max < min) {
				max = min;
				MaxHeuristique = i;
			}
			
			arbre.goToPere();
			min = -1;
		}
		arbre.goToFils(MaxHeuristique);
	}

	
}
