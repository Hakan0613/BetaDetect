package personnes;
import java.util.*;
//Les nom et prénom des personne seront selectionner aléatoirement depuis la table BankPrénom de la BD Partie
public class NomPrenom {
	private String nom;
    private String prenom; 
	DAOJeu monDAO = new DAOJeu();
    monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3307/projetjeujava", "root", "");

    //Constructeur qui permet la selection aleatoire du nom et prénom d'un personnage pour un id Personnage donnée.

	private personnage (int genre)     //genre == 1 si c'est un homme, 0 sinon
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
        String requette = "SELECT prenom FROM bankNomPrenom WHERE id =" + (String) nbalea +"AND genre = " + (String) genre;
        String prenom = monDAO.dosearch(requette);
        return prenom;        
    }

    //Méthode permettant de récuperer le nom depuis la BD
    private String setNom(int nbalea, int genre)
    {
        String requette = "SELECT nom FROM bankNomPrenom WHERE id =" + (String) nbalea +"AND genre = " + (String) genre;
        String prenom = monDAO.dosearch(requette);
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
