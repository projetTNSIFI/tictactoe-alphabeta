package com;

import base.Joueur;

public class Ordinateur extends Joueur{
	
	protected int profondeur;
	
	//Tour de l'ordinateur.
	public Ordinateur(String nom, int pion, int profondeur)
	{
		super(nom,pion);
		this.profondeur = profondeur;
	}
	
	public void jouer(Plateau plateau)
	{
		System.out.println("Tour du joueur " + nom);
		
		//Le noeud racine correspond toujours au tour de l'adversaire.
		Noeud racine = new Noeud(plateau, Jeu.O);
		Noeud prochain_coup;
		
		//G�n�ration d'un arbre de recherche d'une profondeur de 2.
		Evaluation.genererArbre(racine, 2);
		
		//Evaluation des noeuds
		Evaluation.evaluer_noeuds(racine, profondeur);
		
		//AFFICHAGE
		System.out.println("Voici les solutions possibles envisag�es par l'ordinateur : ");
		Evaluation.afficherArbre(racine);
				
		//FIN AFFICHAGE
				
		//Jouer le noeud le plus int�ressant.
		prochain_coup = racine.filsMax();
		plateau.setPlateau(prochain_coup.plateau);
		
		System.out.println("Coup jou� : ");
		plateau.Afficher();
	}
	
	public void setProfondeur(int profondeur)
	{
		this.profondeur = profondeur;
	}
}
