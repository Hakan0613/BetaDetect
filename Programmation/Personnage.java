package personnes;
import java.util.*;

//Les nom et prénom sont selctionner aléatoirement depuis la classe NomPrenom et ajouté à une nouvel table de la BD 
//(pour qu'elle reste sauvegarder)
//toute les données personnages seront stocker dans la BD

public class Personnage {
    private int idPersonnage;
    private String nomPersonnage;
    private String prenomPersonnage;
	private String lien; // Lien avec le PP : Epouse, soeur, preteur sur gage, ami, victime, médecin, gérant
	private boolean culpabilite; // Désigne false s'il est innocent et true dans le cas contraire
	private String description; // Age, groupe sangain, alibi, Se met à jour au fur et à mesure de l'enquete
	
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

    //Connection à la BD
    DAOJeu monDAO = new DAOJeu();
    monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3307/projetjeujava", "root", "");

    //Construteur : l'ensemble des nom et prénom sont sélectionner aléatoirement puis ajouter (Set) dans la BD
    //Les trois premiers ID sont destiner à la famille du PP
    private personnage() 
    {
        //Initialisation de la famille
            //Set du nom de famille du PP et son épouse
        NomPrenom nomFamillePP = new NomPrenom(1);
        String nomFamille = nomFamillePP.getNom();
        String requette = ("UPDATE personnage SET nom = " + nomFamille + "WHERE id IN (1,2)");   
        monDAO.doUpdate(requette);
        
            //Set du prenom du PP
        String prenom = nomFamillePP.getPrenom();
        String requette = ("UPDATE personnage SET prenom = " + prenom +"WHERE id IN 1"); 
        monDAO.doUpdate(requette);  
        
            //Set du prenom de l'épouse du PP
        NomPrenom nomFamillePP = new NomPrenom(0);
        String prenom = nomFamillePP.getPrenom();
        String requette = ("UPDATE personnage SET nom = " + prenom +"WHERE id IN 2");  
        monDAO.doUpdate(requette);
        //Fin initialisation de la famille du PP

        //Initialisation des personnage féminin
        for(int i = 3, i <=5, i++ )
        {
            Boolean existe = True;
            //Verifcation s'il le nom a était déjà attribuer
            while (existe)
            {
                NomPrenom newPersonnage = new NomPrenom(0);
                String prenom = newPersonnage.getPrenom();
                String requette = ("SELECT idPersonnage FROM personnage WHERE prenom = " + prenom);
                Int verif = monDAO.dosearch(requette);
                if(verif != 1)
                {
                    existe = False;
                }
            }
            String nom = newPersonnage.getNom();
            String requette = ("UPDATE personnage SET prenom = " + prenom + ", nom = " + nom + " WHERE id = " + i);
            monDAO.doUpdate(requette);
        }
        //Fin initialisation des personnage féminin

        //Initialisation des personnage masculin
        for(int i = 6, i <=12, i++ )
        {
            NomPrenom newPersonnage = new NomPrenom(1);
            String prenom = newPersonnage.getPrenom();
            String nom = newPersonnage.getNom();
            String requette = ("UPDATE personnage SET prenom = " + prenom + ", nom = " + nom + " WHERE id = " + i);
            monDAO.doUpdate(requette);
        }
        //Fin initialisation des personnage masculin





    }
}