/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp1_modelisation_probs;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Noeud <T> {
	private T info;
	private Noeud<T> pere;
	private final ArrayList<Noeud<T>> fils  = new ArrayList<>();

	public Noeud(T info) {
		this.info = info;
	}
	
	public void Noeud(T item, Noeud<T> pere) {
		this.info = item;
		this.pere = pere;
	}

	public Noeud(T info, Noeud<T> pere) {
		this.info = info;
		this.pere = pere;
	}
	
	public void addFils(T item) {
		this.fils.add(new Noeud(item, this));
	}
		
	public boolean isRacine() {
		return null == pere;
	}
	
	public boolean isNoeudFeuille() {
		return fils.isEmpty();
	}
	
	public int getNbFils() {
		return fils.size();
	}

	public Noeud<T> getPere() {
		return pere;
	}
	
	public Noeud<T> getFils(int i) {
		return this.fils.get(i);
	}
	
	public void suppressNoeud() {
		if (this.getNbFils() > 0) {
			for (Noeud n : fils) {
				n.suppressNoeud();
				n = null;
			}
		}
	}
}
