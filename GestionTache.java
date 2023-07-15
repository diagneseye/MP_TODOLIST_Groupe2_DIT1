import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class GestionTache {

	static Scanner sc = new Scanner(System.in);
	static int choix;
	static GestionnaireTache gestionnaireTache;

	public static void main(String[] args) {
		gestionnaireTache = new GestionnaireTache(50);
		afficherMenuPrincipal();

	}

	public static void afficherMenuPrincipal() {

		System.out.println("--------------Menu---------------\n");
		String menuPrincipal = "1. Ajouter \n";
		menuPrincipal += "2. Modifier \n";
		menuPrincipal += "3. Supprimer \n";
		menuPrincipal += "4. Liste de toutes les taches \n";
		menuPrincipal += "5. liste tache en cours \n";
		menuPrincipal += "6. liste tache terminees \n";
		menuPrincipal += "7. liste tache prevues \n";

		do {
			System.out.println(menuPrincipal);
			choix = sc.nextInt();
		} while (choix <= 0 || choix > 7);

		switch (choix) {
		case 1:
			AfficherAjout();
			break;
		case 2:
			AfficherMenuModif();
			break;
		case 3:
			AfficherMenuSupprim();
			break;
		case 4:
			AfficherToutesLesTaches();
			break;
		case 5:
			AfficherTachesEnCours();
			break;
		case 6:
			AfficherTachesTerminees();
			break;
		case 7:
			AfficherTachesPrevues();
			break;

		default:

			break;
		}
	}

	private static void AfficherAjout() {
		// TODO Auto-generated method stub
		String titre = "", etat = "";
		String dateCreationText = "";
		Tache t;

		System.out.println("--------------Ajout Tache---------------");
		System.out.println("Donnez le titre de la Tache : ");
		titre = sc.next();
		System.out.println("Voulez vous renseigner l'etat  (taper o \\n) : ");
		if (sc.next().equals("o")) {
			System.out.println("Donnez l'état : ");
			etat = sc.next();
			System.out.println("Voulez vous renseigner la date  (taper o\\n) : ");

			if (sc.next().equals("o")) {
				System.out.println("Donnez la date de creation (format ): ");
				dateCreationText = sc.next();
			}
		}
		if (etat.isEmpty()) {
			t = new Tache(titre);
		} else if (dateCreationText.isEmpty()) {
			t = new Tache(titre, etat);
			System.out.println(t.toString());
		} else {
			LocalDate date = LocalDate.parse(dateCreationText, DateTimeFormatter.ISO_DATE);

			t = new Tache(titre, etat);
			System.out.println(t.toString());
		}

		if (gestionnaireTache.ajouter(t)) {
			System.out.println("Tache ajoutée avec success!!!!!!!! ");
			System.out.println("..Pour ajouter une autre tache (o) - tapez sur ");
			if (sc.next().equals("o"))
				AfficherAjout();
			else
				afficherMenuPrincipal();
		} else {
			System.out.println("Warning!!!! Ajout tache a echoue !!!!! ");
			afficherMenuPrincipal();
		}

	}

	private static void AfficherMenuModif() {
		// TODO Auto-generated method stub

	}

	private static void AfficherMenuSupprim() {
		// TODO Auto-generated method stub

		System.out.println("--------------Suppression Tache---------------");
		System.out.println("Donnez l'identifiant de la Tache à supprimer: ");
		int id = sc.nextInt();
		if (gestionnaireTache.supprimer(id)) {
			System.out.println("Suppression avec success!");
		} else {
			System.out.println("Warning!!!! Suppression a echoue ! ");
			afficherMenuPrincipal();
		}
		System.out.println("Supprimer une autre tache tapez (o) , tapez une autre touche pour revenir au menu");
		if (sc.next().equals("o"))
			AfficherAjout();
		else
			afficherMenuPrincipal();
	}

	private static void AfficherToutesLesTaches() {
		// TODO Auto-generated method stub
		if (gestionnaireTache.getNombreTache() == 0) {
			System.out.println("Liste de tache vide!!!!!!!!");
		} else {
			System.out.println("--------------Liste de toutes les Taches---------------");
			for (Tache tache : gestionnaireTache.lister()) {
				System.out.println("......");
				System.out.println(tache.toString());
			}

		}

		System.out.println("..Retourner au menu principal Tapez r");
		if (sc.next().equals("r"))
			afficherMenuPrincipal();
	}

	private static void AfficherTachesPrevues() {
		System.out.println("--------------Liste des Taches PREVUES ---------------");
		if (gestionnaireTache.getNombreTache() == 0) {
			System.out.println("Liste de tache vide!!!!!!!!");
		} else {

			for (Tache tache : gestionnaireTache.lister("PREVU")) {
				System.out.println("......");
				System.out.println(tache.toString());
			}
		}

		System.out.println("..Retourner au menu principal Tapez r");
		if (sc.next().equals("r"))
			afficherMenuPrincipal();

	}

	private static void AfficherTachesTerminees() {
		// TODO Auto-generated method stub
		if (gestionnaireTache.getNombreTache() == 0) {
			System.out.println("..Liste de tache vide!!!!!!!!");
		} else {
			System.out.println("--------------Liste des Taches TERMINEES ---------------");
			for (Tache tache : gestionnaireTache.lister("TERMINE")) {
				System.out.println("......");
				System.out.println(tache.toString());
			}

		}

		System.out.println("..Retourner au menu principal Tapez r");
		if (sc.next().equals("r"))
			afficherMenuPrincipal();
	}

	private static void AfficherTachesEnCours() {
		// TODO Auto-generated method stub
		if (gestionnaireTache.getNombreTache() == 0) {
			System.out.println("Liste de tache vide!!!!!!!!");
		} else {
			System.out.println("--------------Liste des Taches EN COURS ---------------");
			for (Tache tache : gestionnaireTache.lister("En_COURS")) {
				System.out.println("......");
				System.out.println(tache.toString());
			}

		}

		System.out.println("..Retourner au menu principal Tapez r");
		if (sc.next().equals("r"))
			afficherMenuPrincipal();
	}

	public static void initialiserTableau() {
		int dimension;
		do {
			System.out.println("Donnez la taille maximale du tableau : ");
			dimension = sc.nextInt();
		} while (dimension < 0);

	}

}
