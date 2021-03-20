package personnes;
import java.util.*;
//Les nom et prénom des personne seront selectionner aléatoirement depuis la table BankPrénom de la BD Partie
//Voir tout en bas pour la liste des personnage
public class NomPrenom {
    ArrayList<String> nom;
    ArrayList<String> prenom;
    
	DAOJeu monDAO = new DAOJeu();
    monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3307/projetjeujava", "root", "");

    //Début des méthodes privée
    //Constructeur qui permet la selection aleatoire du nom et prénom d'un personnage pour un id Personnage donnée.

	public void initPersonnage ()     //genre == 1 si c'est un homme, 0 sinon
	{
		int[] genre = {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};    //genre dans l'odre (voir liste personnage) 
		String nomTemp;
		String prenomTemp;
		for(int i=1, i<=13, i++)
		{
			prenomTemp = this.newPrenom(genre[i-1]);
			nomTemp = this.newPrenom(genre[i-1]);
			this.nom.add(i, nomTemp);
			this.prenom.add(i, prenomTemp);
			this.setNomPernom(1,nomTemp, i);
			this.setNomPernom(0,nomTemp, i);
		}
		//Pour obtenir le meme nom de famille pour l'épouse du PP
		nomTemp = this.nom.get(1);
		this.setNomPernom(1,nomTemp, 2);
	}

    //Méthode permettant de récuperer le prenom depuis la BD
    private String newPrenom(int genre)
    {
    	Random rand = new Random();
    	do
        {
	    	int nbAleaPrenom = rand.nextInt(100);     //la valeur 100 doit etre remplacer par le nombre de prenom dans la BD
	    	String requette = "SELECT prenom FROM bankNomPrenom WHERE id =" + (String) nbAleaPrenom +"AND genre = " + (String) genre;
	        String prenomBD = monDAO.dosearch(requette);
        }while(this.prenom.contains(prenomBD));
        return prenomBD;        
    }

    //Méthode permettant de récuperer le nom depuis la BD
    private String newNom(int genre)
    {
    	Random rand = new Random();
    	do
        {
        	int nbAleaNom = rand.nextInt(100);     //la valeur 100 doit etre remplacer par le nombre de noms dsipo dans la BD
	    	String requette = "SELECT nom FROM bankNomPrenom WHERE id =" + (String) nbAleaNom +"AND genre = " + (String) genre;
	        String nomBD = monDAO.dosearch(requette);
        }while(this.nom.contains(nomBD));
        return nomBD;
    }
    //Méthode permettant de sauvergarder le nom prenom dans la BD
    private void setNomPernom(int type, String ajout, int idPersonnage)  //type => nom=1 ou prenom=0
    {
    	if(type==1)
    	{
    		String requette = ("UPDATE personnage SET nom = " + ajout + "WHERE id =" + idPersonnage);   
            monDAO.doUpdate(requette);
    	}
    	else
    	{
    		String requette = ("UPDATE personnage SET prenom = " + ajout + "WHERE id =" + idPersonnage);   
            monDAO.doUpdate(requette);
    	}
    }
    //Fin méthodes privées
    
    
    
    //Début méthodes Public :
    
    //Les deux getter :

    public ArrayList<String> getListePrenom()
    {
        return this.prenom;
    }

    public ArrayList<String> String getListeNom()
    {
        return this.nom;
    }
    //Fin méthodes Public.
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