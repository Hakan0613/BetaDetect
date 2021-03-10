Create DATABASE Utilisateur;
Use Utilisateur; 

--   ==> Les tables VARIABLE :
--Table utilisateur :

CREATE TABLE utilisateur
(idConnexion INT AUTO_INCREMENT,
motsPasse int,
score int,
pseudo VARCHAR(25),
PRIMARY KEY (idConnexion)
)ENGINE=INNODB CHARACTER SET utf8;

--Table partie :
--Remarque un joueur peut avoir plusieur parties 
CREATE TABLE partie
(idPartie INT AUTO_INCREMENT,
idConnexion int not null,
progressionPartie int,
tempJouer TIME(fsp),
nomPartie VARCHAR(25),
positionJoueur INT,
CONSTRAINT idParti PRIMARY KEY (idConnexion,idPartie),
FOREIGN KEY (idConnexion) REFERENCES utilisateur(idConnexion)
)ENGINE=INNODB CHARACTER SET utf8;

--Table inventaire :
--Ici sont stocker les id des objets que le joueurs a récuperrer
CREATE TABLE inventaire
(idPartie INT NOT NULL,
idObjet int,
CONSTRAINT idInventaire PRIMARY KEY (idObjet,idPartie),
FOREIGN KEY (idPartie) REFERENCES partie(idPartie),
FOREIGN KEY (idObjet) REFERENCES objet(idObjet)
)ENGINE=INNODB CHARACTER SET utf8;

--Table map
--La map est composé d'un ensemble de position désigner chacun par un int. La position du joueur est récuerer de la table partie.
CREATE TABLE map
(idPartie INT NOT NULL ,
coordonneeXY int,
CONSTRAINT idMap PRIMARY KEY (coordonneeXY,idPartie),
FOREIGN KEY (idPartie) REFERENCES partie(idPartie)
)ENGINE=INNODB CHARACTER SET utf8;

--Table personnage :
--Remarque : Le nom et prenom sont selectionner aléatoirement depuis les banques de donnée dédier et donc differe entre chaque partie.
CREATE TABLE personnage
(idPersonnage INT NOT NULL,
idPartie INT NOT NULL,
positionPersonnage INT NOT NULL,
nomPersonnage VARCHAR(25),
prenomPersonnage VARCHAR(25),
culpabilite BOOLEAN, 
infosPersonnage VARCHAR(300),
CONSTRAINT idPersonne PRIMARY KEY (idPersonnage,idPartie),
FOREIGN KEY (idPartie) REFERENCES partie(idPartie)
)ENGINE=INNODB CHARACTER SET utf8;


--   ==> Les tables FIXE :

--Table banque d'OBJET :

CREATE TABLE objet
(idObjet INT NOT NULL,
nomObjet VARCHAR(30),
infos VARCHAR(300),
positionObjet INT NOT NULL,
PRIMARY KEY (idObjet)
)ENGINE=INNODB CHARACTER SET utf8;

--Table banque de QUESTION :

CREATE TABLE bankQuestion
(idPersonnage INT NOT NULL,
idQuestion INT NOT NULL,
question VARCHAR(200),
CONSTRAINT idAsk PRIMARY KEY (idPersonnage,idQuestion)
)ENGINE=INNODB CHARACTER SET utf8;

--Table banque de REPONSE :

CREATE TABLE bankReponse
(idQuestion INT NOT NULL,
idReponse INT NOT NULL,
reponse VARCHAR(200),
CONSTRAINT idAnswer PRIMARY KEY (idQuestion,idReponse),
FOREIGN KEY (idQuestion) REFERENCES bankQuestion(idQuestion)
)ENGINE=INNODB CHARACTER SET utf8;

--Table banque de NOM et PRENOM :
--Selection aléa du nom et prénom selon l'id (un entier), indépendemment pour l'un et l'autre
CREATE TABLE bankNomPrenom
(genre INT NOT NULL,
id INT NOT NULL,
nom VARCHAR(25),
prenom VARCHAR(25),
CONSTRAINT idPersonne PRIMARY KEY (id)
)ENGINE=INNODB CHARACTER SET utf8;

