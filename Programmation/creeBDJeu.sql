Create DATABASE BDJeu;
Use BDJeu; 


CREATE TABLE utilisateur
(idConnexion INT AUTO_INCREMENT,
motsPasse int,
score int,
pseudo VARCHAR(25),
PRIMARY KEY (idConnexion)
)ENGINE=INNODB CHARACTER SET utf8;

CREATE TABLE partie
(idPartie INT AUTO_INCREMENT,
idConnexion int not null,
progressionPartie int,
nomPartie VARCHAR(25),
positionJoueur INT,
FOREIGN KEY (idConnexion) REFERENCES utilisateur(idConnexion),
PRIMARY KEY (idPartie)
)ENGINE=INNODB CHARACTER SET utf8;

CREATE TABLE inventaire
(idPartie INT NOT NULL,
idObjet int,
FOREIGN KEY (idPartie) REFERENCES partie(idPartie),
FOREIGN KEY (idObjet) REFERENCES objet(idObjet),
 CONSTRAINT idInventaire PRIMARY KEY (idObjet,idPartie)
)ENGINE=INNODB CHARACTER SET utf8;


CREATE TABLE personnage
(idPersonnage INT NOT NULL,
idPartie INT NOT NULL,
positionPersonnage INT NOT NULL,
nomPersonnage VARCHAR(25),
prenomPersonnage VARCHAR(25),
culpabilite BOOLEAN, 
infosPersonnage VARCHAR(300),
FOREIGN KEY (idPartie) REFERENCES partie(idPartie),
CONSTRAINT idPersonne PRIMARY KEY (idPersonnage,idPartie)
)ENGINE=INNODB CHARACTER SET utf8;

CREATE TABLE objet
(idObjet INT NOT NULL,
nomObjet VARCHAR(30),
infos VARCHAR(300),
positionObjet INT NOT NULL,
PRIMARY KEY (idObjet)
)ENGINE=INNODB CHARACTER SET utf8;

CREATE TABLE bankQuestion
(idPersonnage INT NOT NULL,
idQuestion INT NOT NULL,
question VARCHAR(200),
CONSTRAINT idAsk PRIMARY KEY (idPersonnage,idQuestion)
)ENGINE=INNODB CHARACTER SET utf8;

CREATE TABLE bankReponse
(idQuestion INT NOT NULL,
idReponse INT NOT NULL,
reponse VARCHAR(200),
)ENGINE=INNODB CHARACTER SET utf8;

CREATE TABLE bankNomPrenom
(genre INT NOT NULL,
id INT NOT NULL,
nom VARCHAR(25),
prenom VARCHAR(25),
CONSTRAINT idPersonne PRIMARY KEY (id)
)ENGINE=INNODB CHARACTER SET utf8;