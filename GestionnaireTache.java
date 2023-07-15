public class GestionnaireTache {
    private Tache [] taches; 
    private int nombreTache = 0;
    
	public GestionnaireTache (int nombreMax){
        this.taches = new Tache[nombreMax];
    }
    public boolean ajouter(Tache tache){
        if(nombreTache<taches.length){
            taches[nombreTache] = tache;
            nombreTache++;
            return true;
        }else
            return false;
    }

    public boolean modifier(Tache tache){
        int idTacheToUpdate = tache.getIdentifiant();
        boolean isUpdate = false;
        for(int i =0; i<nombreTache; i++){
            if(taches[i].getIdentifiant() == idTacheToUpdate){
                taches[i] = tache;
                isUpdate =true;
                break;
            }
        }
        return isUpdate;
    }
    public boolean supprimer(int id){
        boolean isDelete = false;
        for(int i =0; i<nombreTache; i++){
            if(taches[i].getIdentifiant() == id){
                //taches[i].;
                nombreTache--;
                this.arrangerTableau(i);
                isDelete =true;
                break;
            }
        }
        return isDelete;
    }
    
    public Tache[] lister() {
    	Tache[] listeTaches = new Tache[nombreTache];
    	for(int i =0; i<nombreTache; i++){
            listeTaches[i] = taches[i];
        }
    	return listeTaches;
    }
    

    
    public Tache[] lister(String etat) {
    	int nbTacheTrouver =this.compterTachePourEtat(etat);
    	Tache[] listeTaches = null; 
    	if(nbTacheTrouver!=0) {
    		listeTaches = new Tache[nbTacheTrouver];
        	
        	int j = 0;
        	for(int i =0; i<nbTacheTrouver; i++){
                while(j<nombreTache){
                	if(taches[j].getEtat().equals(etat)) {
                		listeTaches[i] = taches[j];
                		j++;
                		break;
                	}
                    
                }
            }
    	}
    	return listeTaches;
    }
    
    public int compterTachePourEtat(String etat) {
    	int nbTacheTrouver =0;
    	
    	for(int i =0; i<nombreTache; i++)
    		if(taches[i].getEtat().equals(etat))
    			nbTacheTrouver++;
    	
    	return nbTacheTrouver;
    }
    
    
    
    public void arrangerTableau(int depart) {
    	for(int i= depart;i<nombreTache; i++)
    		taches[i]=taches[i+1];
    }
    
    public int getNombreTache() {
		return nombreTache;
	}
}
