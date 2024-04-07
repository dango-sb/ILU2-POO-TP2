package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentiteClient(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] chercherVendeurs(String produit) {
		Gaulois vendeursgau[] = village.rechercherVendeursProduit(produit);
		if (vendeursgau == null) {
			return null;
		}
		String[] vendeurs = new String[vendeursgau.length];
		String vendeur;
		for (int i = 0; i < vendeursgau.length; i++) {
			vendeur = vendeursgau[i].getNom();
			vendeurs[i] = vendeur;
		}
		return vendeurs;
	}

	public int acheterProduit(String nomVendeur,int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal != null) {
			return (etal.acheterProduit(quantite));
		} else {
			return (-1);
		}
	}
}