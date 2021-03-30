package personnes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//Cette classe permet de récuperer les questions et réponses utiliser dans le jeu
// Décomposition : idPersonnage  => noDiscussion  => noQuestion  => idQuestion
//Fonctionnement :On recuperre les question restant selon le noDiscussion dans la table Personnage qui correspond a la dernière discussion (non réaliser)
//Une discussion est réaliser losque tout les noQuestion ont étaient poser
//Le joueur choisi toujours entre 3 questions a poser
//Toujours utiliser la méthode aDemander() quand le joueur pose une question

public class Interraction {
    ArrayList<ArrayList<String[]>> question;
    ArrayList<ArrayList<String[]>> reponse;
    Integer[] noQuestion = new Integer[10];
    //Pour chaque indice de l'arrayliste principale ( qui correspond à l'idPersonnage), on a une arrayliste de string qui contient les question (4°) dont les indice corresponde a noQuestion
    //Chaque question comporte 3 choix de question pour le joueur
	DAOJeu monDAO = new DAOJeu();

    //Début des méthodes privée

	public Interraction () 
	{
		question = new ArrayList<ArrayList<String[]>>();
	    reponse = new ArrayList<ArrayList<String[]>>();
	    for(int i=0; i<10; i++)
	    {
	    	noQuestion[i]=0;
	    }
		//Pour chaque personnage la liste de question-reponse est remplie
		for(int i = 2; i<13 ; i++)
		{
			int verif = this.verifNoDiscussion(i);
			switch (verif) {
			case 1:
				this.getQR(i,1);
				break;
			case 2:
				this.getQR(i,2);
				break;
			} 	
		}
		/*ArrayList<String[]> aff = this.question.get(0);
		for(int i=0; i<4; i++)
	    {
	    	String[] affiche = aff.get(i);
	    	System.out.println("noQuestion = " + (i+1));
		    for(int j=0; j < 3; j++)
			{
			    	System.out.println("Tab : "+ affiche[j]);
			}
	    }
		*/
		/*ArrayList<String[]> litsQ = this.question.get(0);
		ArrayList<String[]>  litsR = this.reponse.get(0);
		String[] quest = litsQ.get(0);
		String[] rep = litsR.get(0);
		for(int i=0; i<3; i++)
		{
			System.out.println(quest[i]);
		}
		*/
		
	}
	
    
    //Méthode récuperrant les question selon le idPersonnage et le noQuestion
    private void getQR(int idPersonnage, int noDiscussion)
    {
    	monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3306/bdjeu", "root", "");
    	
    	Random rand = new Random();
    	ResultSet resQuestion; 
    	String requette;
	    int nbAleaQuestion;
	    ArrayList<String[]> listeQuestion = new ArrayList<String[]>();
	    ArrayList<String[]> listeReponse = new ArrayList<String[]>();
	    
	    //Parmis 4 noQuestion
	    for(int noQuestion=0; noQuestion < 4; noQuestion++)
	    {
	    	int[] verif = new int[3];
	    	String[] questionTemp = new String[3];
	    	String[] reponseTemp = new String[3];
	    	//Il y a trois question aux choix du joueur
	    	for(int choix=0; choix < 3; choix++)
	    	{
	    		//Verification si la question est deja attribuer
	    		do
		    	{
	    			nbAleaQuestion = rand.nextInt(6);
		    	}while(verif[0]==nbAleaQuestion || verif[1]==nbAleaQuestion || verif[2]==nbAleaQuestion);
	    		verif[choix]=nbAleaQuestion;
	    		
		    	requette = "SELECT question, reponse FROM bankQuestion WHERE noQuestion =" + (noQuestion+1) +" AND idPersonnage = " + idPersonnage +" AND idQuestion = " + nbAleaQuestion + " AND noDiscussion = " + noDiscussion;
		    	resQuestion = monDAO.doSearch(requette);
		    	try {
					if(resQuestion.next()!=false)
					{
						questionTemp[choix] = resQuestion.getString("question");
						reponseTemp[choix] = resQuestion.getString("reponse");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
	    	}
	    	
	    	listeQuestion.add(noQuestion, questionTemp);
		    listeReponse.add(noQuestion, reponseTemp);
	    }
	    
	    //Ajout a la liste de question et reponse courante
        this.question.add(idPersonnage-2, listeQuestion);
		this.reponse.add(idPersonnage-2, listeReponse);
		
    }
    
    private int verifNoDiscussion(int idPersonnage)       //OK
    {
    	monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3306/bdjeu", "root", "");
    	String requette = "Select noDiscussion From personnage where idPersonnage = " + idPersonnage;
    	ResultSet res = monDAO.doSearch(requette);
    	int noDiscussion = 0;
    	try {
			if(res.next()!=false)
			{
				noDiscussion = res.getInt("noDiscussion");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return noDiscussion;
    }
    
    private void changeDiscussion(int idPersonnage)      //OK
    {
    	monDAO.getConnect("org.mariadb.jdbc.Driver", "jdbc:mariadb://localhost:3306/bdjeu", "root", "");
    	int noDiscussion = this.verifNoDiscussion(idPersonnage+2);
    	String requette;
    	
    	noDiscussion++;
    	
    	//MAJ du noDiscussion dans la BD
	    requette = ("UPDATE personnage SET noDiscussion = " + (noDiscussion) + " WHERE idPersonnage =" + (idPersonnage+2));   
        monDAO.doUpdate(requette);
        
        //MAJ de la liste question courrante
        if(noDiscussion==2)
        {
        	this.getQR((idPersonnage+2), noDiscussion);
        }
    }
    
    //Permet d'augmenter le noQuestion et de changer de discussion si besoin
    private void aDemander(int idPersonnage)       //OK
    {
    	Integer noQ;
    	noQ = this.noQuestion[idPersonnage];
    	noQ++;
    	if(noQ==4)
    	{
    		this.noQuestion[idPersonnage] = 0;
    		this.changeDiscussion(idPersonnage);
    	}
    	else
    		this.noQuestion[idPersonnage] = noQ; 	
    }
    //Fin méthodes privées
    //Début méthodes Public :
    
    //Methode renvoyant une arrayliste de 3 element correspondant aux choix de question a poser. Cahque élement est composer d'un tableau.
    //tab[0] = Question
    //tab[1] = Reponse
    public ArrayList<String[]> poserQ(int idPersonnage)
    {
		int noQTemp = this.noQuestion[idPersonnage-2];
		int verif = this.verifNoDiscussion(idPersonnage);
		
		ArrayList<String[]> listeQR = new ArrayList<String[]>();
		if(verif==1 || verif==2)
		{
			ArrayList<String[]> qTemp = this.question.get(idPersonnage-2);
			ArrayList<String[]> rTemp = this.reponse.get(idPersonnage-2);
			String[] choixQuestion = qTemp.get(noQTemp);
			String[] choixReponse = rTemp.get(noQTemp);
			for(int i=0; i<3; i++)
			{
				String[] temp = new String[2];
				temp[0]= choixQuestion[i];
				temp[1]= choixReponse[i];
				listeQR.add(i, temp);
			}
	    	this.aDemander(idPersonnage-2);
	    	return listeQR;	    	
		}
		else
			return null;
    	
    }    
    //Fin méthodes Public.
}