package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
	    if (!controlAcheterProduit.verifierIdentiteClient(nomAcheteur)) {
	        afficherMessageErreurIdentite(nomAcheteur);
	        return;
	    }

	    System.out.println("Quel produit voulez-vous acheter ?");
	    String produit = scan.next();
	    String[] vendeursProduit = controlAcheterProduit.chercherVendeurs(produit);

	    if (vendeursProduit == null || vendeursProduit.length == 0) {
	        System.out.println("Désolé, personne ne vend ce produit au marché.\n");
	        return;
	    }

	    afficherChoixVendeurs(produit, vendeursProduit);
	    int choix = scan.nextInt();

	    if (choix > 0 && choix <= vendeursProduit.length) {
	        String nomVendeur = vendeursProduit[choix - 1];
	        effectuerAchat(nomAcheteur, produit, nomVendeur);
	    } else {
	        System.out.println("Vous devez entrer un chiffre entre 1 et " + vendeursProduit.length);
	    }
	}

	private void afficherMessageErreurIdentite(String nomAcheteur) {
	    System.out.println("Je suis désolé " + nomAcheteur
	            + " mais il faut être un habitant du village pour commercer ici.\n");
	}

	private void afficherChoixVendeurs(String produit, String[] vendeursProduit) {
	    StringBuilder choixcomm = new StringBuilder("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
	    for (int i = 0; i < vendeursProduit.length; i++) {
	        choixcomm.append((i + 1) + " - " + vendeursProduit[i] + "\n");
	    }
	    System.out.println(choixcomm.toString());
	}

	private void effectuerAchat(String nomAcheteur, String produit, String nomVendeur) {
	    System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur
	            + ".\nBonjour " + nomAcheteur + ".\nCombien de " + produit + " voulez-vous acheter ?\n");
	    int quantite = scan.nextInt();
	    int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur,quantite);
	    afficherDetailsAchat(nomAcheteur, produit, nomVendeur, quantite, quantiteAchetee);
	}

	private void afficherDetailsAchat(String nomAcheteur, String produit, String nomVendeur, int quantite, int quantiteAchetee) {
	    StringBuilder achat = new StringBuilder();
	    if (quantiteAchetee == quantite) {
	        achat.append(nomAcheteur + " achète " + quantite + " " + produit + " à " + nomVendeur + ".\n");
	    } else {
	        achat.append(nomAcheteur + " veut acheter " + quantite + " " + produit);
	        if (quantiteAchetee == 0) {
	            achat.append(", malheureusement il n'y en a plus !\n");
	        } else {
	            achat.append(", malheureusement " + nomVendeur + " n'en a plus que " + quantiteAchetee
	                    + ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".\n");
	        }
	    }
	    System.out.println(achat.toString());
	}
}
