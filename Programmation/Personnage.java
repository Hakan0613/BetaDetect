package personnes;
import java.util.*;

//Les nom et pr�nom sont selctionner al�atoirement depuis la classe NomPrenom et ajout� � la table personnage de la BD 
//(pour qu'elle reste sauvegarder)
//toute les donn�es personnages seront stocker dans la BD

public class Personnage {
	private ArrayList<String[]> personne; 
    /*Description de la var personne:
      -L'index de l'arrayList correspond � l'id du personnage
      -Le premier �lement du tableau de String est le nom et pr�nom
      -Dans l'ordre la suite : lien du personnage avec le PP, culpabilt� (1 si vrai, 0 si faux), description (Concat�nation des infos trouver par le joueur)
      Pour la liste des personnage voire plus bas dans le code
    */

    //Connection � la BD
    DAOJeu monDAO = new DAOJeu();
    monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3307/projetjeujava", "root", "");

    //Construteur : l'ensemble des nom et pr�nom sont s�lectionner al�atoirement puis ajouter (Set) dans la BD
    //Les trois premiers ID sont destiner � la famille du PP
    private personnage() 
    {
        ArrayList<String> personne = new ArrayList<String>();    
        NomPrenom creeNomPrenom = new NomPrenom;
        creeNomPrenom.initPresonnage();
        

    





    }
}
/*Dans l'odre les personnages :
id=1 => Personnage principal (PP)
id=2 => Epouse du PP
id=3 => Soeur du PP
id=4 => Assistante du joueur (d�tective)
id=5 => Voisine du PP
id=6 => Ami du PP
id=7 => Agent de police
id=8 => Employ� du casino
id=9 => Gerant du casino
id=10 => Preteur sur gage
id=11 => Medecin l�giste
id=12 => Employ� de banque
id=13 => Le joueur (Nom Pr�nom choisit par le joueur)
...
*/