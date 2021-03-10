package personnes;
import java.util.*;
//Les nom et prénom des personne seront selectionner aléatoirement depuis la table BankPrénom de la BD Partie
public class NomPrenom {
	private String nom;
    private String prenom; 
	

    //Constructeur qui permet la selection aleatoire du nom et prénom d'un personnage pour un id Personnage donnée.

	private personnage (int genre)
	{
		Random rand = new Random();
		int nbAleaPrenom = rand.nextInt(100);     //la valeur 100 doit etre remplacer par une requette SQL qui compte le nombre de prenom dispo dans la BD
        this.prenom = this.setPrenom(nbAleaPrenom, genre);
        int nbAleaNom = rand.nextInt(100);     //la valeur 100 doit etre remplacer par une requette SQL qui compte le nombre de nom dispo dans la BD
        this.nom = this.setNom(nbAleaNom, genre);
	}


    //Méthode permettant de récuperer le prenom depuis la BD
    private String setPrenom(int nbalea, int genre)
    {
        String requette = "SELECT prenom FROM bankNomPrenom WHERE numero =" + (String) nbalea +"AND genre = " + (String) genre;
        RequetteBD prenomBD = new RequetteBD;     //Class requette BD à crée pour execution
        String prenom = prenomBD.execute(requette);
        return prenom;        
    }

    //Méthode permettant de récuperer le nom depuis la BD
    private String setNom(int nbalea, int genre)
    {
        String requette = "SELECT nom FROM bankNomPrenom WHERE numero =" + (String) nbalea +"AND genre = " + (String) genre;
        RequetteBD nomBD = new RequetteBD;     //Class requette BD à crée pour execution
        String nom = nomBD.execute(requette);
        return nom;
    }

    
    //Les deux getter :

    public String getPrenom()
    {
        return this.prenom;
    }

    public String getNom()
    {
        return this.nom;
    }	
}
