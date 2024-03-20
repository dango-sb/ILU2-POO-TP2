package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomVendeur) {
		return village.trouverHabitant(nomVendeur)!=null;
	}
	
	public boolean produitPresente(String produit) {
		return village.rechercherVendeursProduit(produit) != null;
	}
	
	public Gaulois[] getVendeurs(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	//TODO a completer
}
