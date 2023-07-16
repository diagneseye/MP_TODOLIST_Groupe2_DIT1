import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestionTache {

	static Scanner sc = new Scanner(System.in);
	static int choix;
	static GestionnaireTache gestionnaireTache;

	public static void main(String[] args) {
		gestionnaireTache = new GestionnaireTache(50);
		System.out.println("######## TO DO LIST APP - By Cheikh Amadou D SEYE && Ismaila DIATTA######\n");
		afficherMenuPrincipal();

	}

	public static void afficherMenuPrincipal() {
		System.out.println("--------------Menu---------------");
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
			AfficherModifier();
			break;
		case 3:
			AfficherSupprimer();
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
			System.out.println("Etat tache (PREVU \\ TERMINE \\ EN_COURS): ");
			etat = sc.next();
			System.out.println("Voulez vous renseigner la date  (taper o\\n) : ");

			if (sc.next().equals("o")) {
				System.out.println("Date de creation (format dd/MM/yyyy): ");
				dateCreationText = sc.next();
			}
		}
		if (etat.isEmpty()) {
			t = new Tache(titre);
		} else if (dateCreationText.isEmpty()) {
			t = new Tache(titre, etat);
			System.out.println(t.toString());
		} else {
			Date date = null;
			try {
				date = new SimpleDateFormat("dd/MM/yyyy").parse(dateCreationText);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			t = new Tache(titre, etat,date);
		}

		if (gestionnaireTache.ajouter(t)) {
			System.out.println("Tache ajoutée avec success!!!!!!!! ");
			System.out.println(t.toString());
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

	private static void AfficherModifier() {
		// TODO Auto-generated method stub

	}

	private static void AfficherSupprimer() {
		// TODO Auto-generated method stub

		System.out.println("--------------Suppression Tache---------------");
		System.out.println("..Donnez l'identifiant de la Tache à supprimer: ");
		int id = sc.nextInt();
		if (gestionnaireTache.supprimer(id)) {
			System.out.println("Suppression avec success!");
		} else {
			System.out.println("Warning!!!! Suppression a echoue ! ");
			afficherMenuPrincipal();
		}
		System.out.println("..Pour supprimer une autre tache tapez (o) , tapez une autre touche pour revenir au menu");
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

		System.out.println("..Pour retourner au menu principal Tapez r :");
		if (sc.next().equals("r"))
			afficherMenuPrincipal();
	}

	private static void AfficherTachesPrevues() {
		Tache[] tachePrevues = gestionnaireTache.lister("PREVU");
		if (tachePrevues == null) {
			System.out.println("..Liste de taches PREVU est vide!!!!!!!!");
		} else {

			System.out.println("--------------Liste de Taches PREVU  ---------------");
			for (Tache tache : tachePrevues) {
				System.out.println("......");
				System.out.println(tache.toString());
			}
		}

		System.out.println("..Pour retourner au menu principal Tapez r");
		if (sc.next().equals("r"))
			afficherMenuPrincipal();

	}

	private static void AfficherTachesTerminees() {
		// TODO Auto-generated method stub
		Tache[] tachesTermines = gestionnaireTache.lister("TERMINE");
		if (tachesTermines == null) {
			System.out.println("..Liste de taches TERMINE est vide!!!!!!!!");
		} else {
			System.out.println("--------------Liste des Taches TERMINEES ---------------");
			for (Tache tache : tachesTermines) {
				System.out.println("......");
				System.out.println(tache.toString());
			}

		}

		System.out.println("..Pour retourner au menu principal Tapez r");
		if (sc.next().equals("r"))
			afficherMenuPrincipal();
	}

	private static void AfficherTachesEnCours() {
		// TODO Auto-generated method stub
		Tache[] tachesEnCours = gestionnaireTache.lister("EN_COURS");
		if (tachesEnCours == null) {
			System.out.println("Liste de taches EN COURS est vide!!!!!!!!");
		} else {
			System.out.println("--------------Liste des Taches EN COURS ---------------");
			for (Tache tache : tachesEnCours) {
				System.out.println("......");
				System.out.println(tache.toString());
			}

		}

		System.out.println("..Pour retourner au menu principal Tapez r");
		if (sc.next().equals("r"))
			afficherMenuPrincipal();
	}

	

}
