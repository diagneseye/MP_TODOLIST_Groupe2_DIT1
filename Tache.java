import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Tache {
    static int dernierId = 1;
    
    private int identifiant;
    private String titre;
    private String etat;
    private Date dateCreation;
    
    public Tache() {

    }
    public Tache(String titre) {
        this.identificationUnique();
        this.titre = titre;
        this.etat = "PREVU";
        this.dateCreation = new Date(System.currentTimeMillis());
    }

    public Tache(String titre, String etat) {
        this.identificationUnique();
        this.titre = titre;
        this.setEtat(etat);
        this.dateCreation = new Date(System.currentTimeMillis());
    }

    public Tache(String titre, String etat, Date dateCreation) {
        this.identificationUnique();
        this.titre = titre;
        this.setEtat(etat);
        this.dateCreation = dateCreation;
    }

    private void identificationUnique(){
        this.identifiant = dernierId;
        dernierId ++;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    public void setEtat(String etat) {
        if(etat.equals("EN_COURS") || etat.equals("TERMINE") || etat.equals("PREVU")){
            this.etat = etat;
        }
    }

    public String getEtat() {
        return etat;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public String toString() {
    	String description = "Id : " + this.identifiant +"\n";
    	description += "Titre : " + this.titre +"\n";
    	description += "Etat : " + this.etat +"\n";
    	description += "Date de création : " + this.dateCreation +"\n";
        return description;
    }
}