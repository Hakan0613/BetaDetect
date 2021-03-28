package personnes;
import java.sql.SQLException;
import java.util.*;

//Les nom et prénom sont selctionner aléatoirement depuis la classe NomPrenom et ajouté à la table personnage de la BD 
//(pour qu'elle reste sauvegarder)
//toute les données personnages seront stocker dans la BD

public class Personnage {
	private ArrayList<String[]> personne; 
    /*Description de la variable personne:
      -L'index de l'arrayList correspond à l'id du personnage
      -Le premier élement du tableau de String est le nom et prénom
      -Dans l'ordre la suite : lien du personnage avec le PP (ou role), culpabilté (1 si vrai, 0 si faux), description (Concaténation des infos trouver par le joueur)
      Pour la liste des personnage voire plus bas dans le code
    */

    //Connection à la BD
    
    
    //Construteur : l'ensemble des nom et prénom sont sélectionner aléatoirement puis ajouter (Set) dans la BD
    //Les trois premiers ID sont destiner à la famille du PP
    public Personnage()
    { 
	    personne = new ArrayList<String[]>();
	    //Debut géneration des nom et prenom et renseignement des infos
	    NomPrenom creeNomPrenom = new NomPrenom();
	    try {
			creeNomPrenom.initPersonnage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ArrayList<String> listePseudo = creeNomPrenom.getListePseudo();
	    String[] lien = {"Personnage Principale", "Epouse", "Soeur", "Assistante", "Voisine", "Ami", "Agent de police", "Employé du Casino", "Gerant du Casino", "Preteur sur gage", "Medecin légiste", "Employe de banque", "Le joueur"};
	    String[] culpabilité = {"0","0","0","0","0","0","0","0","0","1","0","0","0",};
	    
	    
	    for(int i = 0; i<13; i++)
	    {
	    	String[] temp = new String[3];
	    	temp[0]= listePseudo.get(i);
	        temp[1] = lien[i];
	        temp[2] = culpabilité[i];
	        this.personne.add(i, temp);
	        
	    }
	    //Fin : personnage renseigner
    }
    
    //Les getteur : au choix

    public String[] getListePersonnage(int idPersonnage)
    {
    	return this.personne.get(idPersonnage-1);
    }
    
    //Attention la liste vas de 0 à 12 !
    public ArrayList<String[]> getListePersonnage()
    {
    	return this.personne;
    }
    
}




/*Dans l'odre les personnages :
id=1 => Personnage principal (PP)
id=2 => Epouse du PP
id=3 => Soeur du PP
id=4 => Assistante du joueur (détective)
id=5 => Voisine du PP
id=6 => Ami du PP
id=7 => Agent de police
id=8 => Employé du casino
id=9 => Gerant du casino
id=10 => Preteur sur gage
id=11 => Medecin légiste
id=12 => Employé de banque
id=13 => Le joueur (Nom Prénom choisit par le joueur)
...
*/