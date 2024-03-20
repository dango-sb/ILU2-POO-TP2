package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		int choixUtilisateur;
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("“Je suis désolée" + nomAcheteur
					+ "mais il faut être un habitant "
					+ "de notre village pour commercer ici");
		}
		else {
			System.out.println("Quel produit voulez-vous acheter?");
			String produit = scan.next();
			if (!controlAcheterProduit.produitPresente(produit)) {
				System.out.println("Desole, personne ne vend ce produit au marche.");
			}
			else {
				System.out.println("Chez quel commercant  voulez-vous acheter des fleurs?");
				Gaulois[] vendeurs = controlAcheterProduit.getVendeurs(produit); 
				for (int i = 0; i<vendeurs.length; i++) {
					Integer si = new Integer(i);
					System.out.println(si.toString() + " - " + vendeurs[i].getNom());
				}
				choixUtilisateur = Clavier.entrerEntier("\n");
				System.out.println(nomAcheteur + " se deplace jusqu'a l'etal du vendeur" + vendeurs[choixUtilisateur].getNom());
				
			}
		}
	}
}
