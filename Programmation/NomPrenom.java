package personnes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//Les nom et prénom des personne seront selectionner aléatoirement depuis la table BankPrénom de la BD Partie
//Voir tout en bas pour la liste des personnage
public class NomPrenom {
    ArrayList<String> pseudoPersonnage = new ArrayList<String>();
    ArrayList<String> prenomTemp = new ArrayList<String>();
    ArrayList<String> nomTemp = new ArrayList<String>();
	DAOJeu monDAO = new DAOJeu();

    
    //Constructeur qui permet la selection aleatoire du nom et prénom d'un personnage pour un id Personnage donnée.

	public void initPersonnage () throws SQLException    
	{
		monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3306/bdjeu", "root", "");
		
		//Verification si les nom et prenom sont déjà renseigner en BD
    	String requette = "SELECT progression FROM Partie";
        ResultSet res;
        res = monDAO.doSearch(requette);   //Renvoie un resulSET
		int reponseServeur = 0;
		try {
			if(res.next()!=false)
			{
			reponseServeur = res.getInt("progression");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		if(reponseServeur>=3)    //Cas où les nom et prenom sont déjà renseigner
        {
        	for(int i=0; i<13; i++)
        	{
	        	//récupération du nom et prenom
        		requette = "SELECT pseudoPersonnage FROM personnage WHERE idPersonnage = " + (i+1);
	            res = monDAO.doSearch(requette);
	            String pseudoTemp = null;
				try {
					if(res.next()!=false)
					{
						pseudoTemp = res.getString("pseudoPersonnage");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            this.pseudoPersonnage.add(i, pseudoTemp);
        	}
        }
		
        else  //Cas d'une première génération des nom et prenom
        {
			int[] genre = {1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};    //genre dans l'odre (voir liste personnage) 
			String nomTemp = null;
			String prenomTemp = null;
			String pseudoTemp = null;
			for(int i=0; i<13; i++)
			{
				
				prenomTemp = this.newNomPrenom(genre[i], 0);
				if(i!=2)     //Pour que l'épouse du PP est le meme nom de famille
				{
					nomTemp = this.newNomPrenom(genre[i], 1);
				}
				pseudoTemp = prenomTemp + "  " + nomTemp;
				this.pseudoPersonnage.add(i, pseudoTemp);
				this.setNomPernom(pseudoTemp, i+1);
			}
			
        }
	}
	
	//Début des méthodes privée

    //Méthode permettant de récuperer le prenom ou nom selon le type donner depuis la BD
	//type => type = 1 nom sinon type = 0 prenom 
	//genre => genre = 1 homme sinon 0 = femme
    private String newNomPrenom(int genre, int type) 
    {
    	
    	monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3306/bdjeu", "root", "");
    	String typeTemp = null;
    	String specialPrenom = "";   //Permet de prendre en compte le genre quand il s'agit d'un prenom
    	if(type==1)
    	{
    		typeTemp="nom";
    	}
    	else
    	{
    		typeTemp="prenom";
    		specialPrenom = " AND genre = " + genre ;
    	}
    	
    	Random rand = new Random();
    	String nomPrenomBD = null;
    	ResultSet res;
    	boolean flag = false;
    	
    	do
        {
	    	int nbAleaPreNom =  rand.nextInt(25);
	    	if(typeTemp=="prenom" && genre == 1)
	    	{
	    		nbAleaPreNom= nbAleaPreNom + 25;
	    	}
	    	String requette = "SELECT " + typeTemp + " FROM bankNomPrenom WHERE id =" + nbAleaPreNom + specialPrenom;
	    	res = monDAO.doSearch(requette);
	        try {
	        	if(res.next()!=false)
	        	{
	        		nomPrenomBD = res.getString(typeTemp);
	        	}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(this.prenomTemp.contains(nomPrenomBD) || this.nomTemp.contains(nomPrenomBD))
	        {
	        	flag=true;
	        }
        }while(flag!=false);
    	
        return nomPrenomBD;        
    }
    
    
    
    //Méthode permettant de sauvergarder le nom prenom dans la BD
    private void setNomPernom(String ajout, int idPersonnage)  
    {
    	String requette = ("UPDATE personnage SET pseudoPersonnage = '" + ajout + "' WHERE idPersonnage = " + idPersonnage);
    	System.out.println(requette);
        monDAO.doUpdate(requette);
    }
    //Fin méthodes privées
    
    
    
    //Début méthodes Public :
    
    //Les deux getter :

    public ArrayList<String> getListePseudo()
    {
        return this.pseudoPersonnage;
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