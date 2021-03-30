-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 30 mars 2021 à 22:11
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdjeu`
--

-- --------------------------------------------------------

--
-- Structure de la table `banknomprenom`
--

CREATE TABLE `banknomprenom` (
  `genre` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `banknomprenom`
--

INSERT INTO `banknomprenom` (`genre`, `id`, `nom`, `prenom`) VALUES
(0, 1, 'SMITH', 'EMMA'),
(0, 2, 'JADE', 'JOHNSON'),
(0, 3, 'WILLIAMS', 'LOUISE'),
(0, 4, 'JONES', 'ALICE'),
(0, 5, 'BROWN', 'LINA'),
(0, 6, 'DAVIS', 'ROSE'),
(0, 7, 'MILLER', 'LEA'),
(0, 8, 'WILSON', 'AMBRE'),
(0, 9, 'MOORE', 'ANNA'),
(0, 10, 'TAYLOR', 'JULIA'),
(0, 11, 'ANDERSON', 'LENA'),
(0, 12, 'THOMAS', 'EVA'),
(0, 13, 'HARRIS', 'CLARA'),
(0, 14, 'JACKSON', 'SARAH'),
(0, 15, 'MARTIN', 'ELENA'),
(0, 16, 'THOMPSON', 'LANA'),
(0, 17, 'MARTINEZ', 'EMY'),
(0, 18, 'ROBINSON', 'LISA'),
(0, 19, 'CLARK', 'EMMY'),
(0, 20, 'LEWIS', 'JENNA'),
(0, 21, 'LEE', 'ASHLEY'),
(0, 22, 'WALKER', 'ABBY'),
(0, 23, 'ALLEN', 'ARIANA'),
(0, 24, 'KING', 'LILLY'),
(0, 25, 'SCOTT', 'SUZIE'),
(1, 26, 'BROCK', 'Lenny'),
(1, 27, '	Ethan', 'WILKERSON'),
(1, 28, 'Tom', 'BRIDGES'),
(1, 29, 'ALLISON', 'Nolan'),
(1, 30, 'MCGUIRE', 'Tobby'),
(1, 31, 'PHELPS', 'Evan'),
(1, 32, 'LUNA', 'Alex'),
(1, 33, 'MCKENZIE', 'Jacob'),
(1, 34, 'UNDERWOOD', 'Christian'),
(1, 35, 'BRYAN', 'Jason'),
(1, 36, 'CAIN', 'Andy'),
(1, 37, 'WILKINS', 'Zack'),
(1, 38, 'SINGLETON', 'Matthew'),
(1, 39, 'CLARKE', 'Tyler'),
(1, 40, 'BOONE', 'Lewis'),
(1, 41, 'HARRINGTON', 'Stan'),
(1, 42, 'ROBERSON', 'Tony'),
(1, 43, 'BOWERS', 'Warren'),
(1, 44, 'SPARKS', 'Marlon'),
(1, 45, 'MORTON', 'Joshua'),
(1, 46, 'OWEN', 'Hayden'),
(1, 47, 'FRANK', 'Charlie'),
(1, 48, 'BROCK', 'Lenny'),
(1, 49, 'ALLISON', 'Nolan'),
(1, 50, 'MCGUIRE', 'Tobby');

-- --------------------------------------------------------

--
-- Structure de la table `bankquestion`
--

CREATE TABLE `bankquestion` (
  `idPersonnage` int(11) NOT NULL,
  `noDiscussion` int(11) NOT NULL,
  `noQuestion` int(22) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  `question` varchar(200) NOT NULL,
  `reponse` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `bankquestion`
--

INSERT INTO `bankquestion` (`idPersonnage`, `noDiscussion`, `noQuestion`, `idQuestion`, `question`, `reponse`) VALUES
(2, 1, 1, 1, 'Bonjour, comment aller vous ?', 'J\'essai de me remettre de la situation.'),
(2, 1, 1, 2, 'Bonjour, avez vous un instant à m\'accordez ?', 'Oui, mais faites vite !'),
(2, 1, 1, 3, 'Bonjour, Je peux vous parler deux minutes ?', 'Ok, a quel sujet ?'),
(2, 1, 1, 4, 'Bonjour, J\'ai besoin de vous parler de quelque chose.', 'Oui de quoi ?'),
(2, 1, 1, 5, 'Bonjour, J\'ai besoin d\'information s\'il vous plais ?', 'Que voulez vous savoir ?'),
(2, 1, 1, 6, 'Bonjour, je suis ravi de vous voir !', 'Oui ?'),
(2, 1, 2, 1, 'Je voulais savoir si votre époux aller souvent au casino ?', 'Je ne sait pas. Il était très excité de l\'arriver du bebe. '),
(2, 1, 2, 2, 'J\'ai trouver un ticket de retrait d\'argent important chez vous. Est ce que vous savez où est passer cette argent ?', 'Non, j\'ai constater cela sur mon relever de compte bancaire. L\'argent n\'a pas été retrouver.'),
(2, 1, 2, 3, 'Saviez vous ce que fessait avec 5000 dollars votre époux  le jour du drame.', 'Non, je ne sais même pas où est passer cette argent.'),
(2, 1, 2, 4, 'Avez vous les 5000 dollars retirer par votre époux le jour du crime ?', 'Non, je ne sais pas où ils sont passer.'),
(2, 1, 2, 5, 'Saviez vous que votre marie avez retirer 5000 dollars le jour du crime ?', 'Oui, je m\'en suis rendu compte récemment à lecture du relever de compte bancaire. Je ne sais pas où est passer cette argent.'),
(2, 1, 2, 6, 'Etes vous au courrant des 5000 dollars retirer sur votre compte ?', 'Oui, je m\'en suis rendu compte récemment à lecture du relever de compte bancaire. Je ne sais pas où est cette argent.'),
(2, 1, 3, 1, 'Avez vous remarquer quelque chose d\'anormale chez votre époux le jour du meurtre ?', 'Non, il étais juste excité comme d\'habitude. C\'étais son premier enfant que nous allions avoir.'),
(2, 1, 3, 2, 'Comment étais votre époux le jour du crime ? ', 'Il étais juste excité comme d\'habitude. C\'étais son premier enfant que nous allions avoir.'),
(2, 1, 3, 3, 'Pouvez vous m\'en dire plus sur le soir du crime ?', 'Je n\'ai rien de particulier à vous dire. Il m\'a déposer sourire au lèvres à l\'aéroport.'),
(2, 1, 3, 4, 'Avez vous quelque chose à me dire à propos de votre mari ?', 'On étais bien heureux tout les deux, avant qu\'il nous quittent.'),
(2, 1, 3, 5, 'Votre mari vous a-t-il dit quelque chose de particulier le soir du crime ?', 'Non, il m\'a déposer à l\'aéroport et tout sembler bien.'),
(2, 1, 3, 6, 'Avez vous quelque chose en particulier à me signaler ?', 'Non.'),
(2, 1, 4, 1, 'Ok, Je me charge de la suite.', 'Au revoir !'),
(2, 1, 4, 2, 'Merci pour vos réponse !', 'Au revoir !'),
(2, 1, 4, 3, 'D\'accord, je vais faire le nécessaire ne vous inquiété pas.', 'Au revoir !'),
(2, 1, 4, 4, 'Au revoir.', 'Au revoir !'),
(2, 1, 4, 5, 'Je vais retrouver les véritable coupable ne vous inquiété pas.', 'Au revoir !'),
(2, 1, 4, 6, 'Merci pour ces informations !', 'Au revoir !'),
(2, 2, 1, 1, 'Bonjour, comment aller vous ?', 'Bonjour !'),
(2, 2, 1, 2, 'Bonjour, avez vous un instant à m\'accordez ?', 'Bonjour, oui ?'),
(2, 2, 1, 3, 'Bonjour, Je peux vous parler deux minutes ?', 'Bonjour, oui ?'),
(2, 2, 1, 4, 'Bonjour, J\'ai besoin de vous parler de quelque chose.', 'Bonjour, je vous écoute.'),
(2, 2, 1, 5, 'Bonjour, J\'ai besoin d\'information s\'il vous plais ?', 'Bonjour, que voulez vous savoir ?'),
(2, 2, 1, 6, 'Bonjour, je suis ravi de vous voir !', 'Bonjour !'),
(2, 2, 2, 1, 'Je voulez savoir si vous connaissez Alex  ', 'Oui, c\'est l\'ami de mon mari. '),
(2, 2, 2, 2, 'Connaissez vous Alex ?', 'Oui, c\'est l\'ami de mon mari. '),
(2, 2, 2, 3, 'Je voudrai des informations au sujet d\'Alex ?', 'Il s\'agit du meilleur ami de mon mari.'),
(2, 2, 2, 4, 'Qui est Alex James s\'il vous plais ?', 'Un ami de mon mari.'),
(2, 2, 2, 5, 'Je cherche a savoir qui est Alex ', 'Il s\'agit d\'un ami de mon mari.'),
(2, 2, 2, 6, 'Pouvez vous me dire qui est Alex.', 'Alex ! C\'est un ami de mon mari.'),
(2, 2, 3, 1, 'Je voulez savoir si vous connaissez Le grand Jack ?', 'Non je ne connais pas.'),
(2, 2, 3, 2, 'Connaissez vous Le grand Jack ?', 'Non je ne connais pas.'),
(2, 2, 3, 3, 'Je voudrai des informations au sujet du grand Jack?', 'Non je ne connais pas.'),
(2, 2, 3, 4, 'Qui est Le grand Jack s\'il vous plais ?', 'Non je ne connais pas.'),
(2, 2, 3, 5, 'Je cherche a savoir qui est Le grand Jack ?', 'Non je ne connais pas.'),
(2, 2, 3, 6, 'Pouvez vous me dire qui est Le grand Jack ?.', 'Non je ne connais pas.'),
(2, 2, 4, 1, 'Dernière question, est ce que votre mari était endetter ?', 'A ma connaissance non.'),
(2, 2, 4, 2, 'Vous attendez une fille ou un garçon ?', 'Une petite fille. Comme ce que mon mari prédisais.'),
(2, 2, 4, 3, 'J\'ai encore une question, est ce que votre avez des dettes ?', 'Il me semble pas qu\'il en avais.'),
(2, 2, 4, 4, 'Il vous reste combien de mois à attendre pour le bebe ?', 'Encore 4 mois.'),
(2, 2, 4, 5, 'Est ce votre mari jouer beaucoup au Casino ?', 'Non, il était au travaille toute les journées au travaille et à côté de moi le reste du temp. '),
(2, 2, 4, 6, 'Avez vous rencontre des gens que vous connaissiez pas après la mort de votre mari ?', 'Oui, il y eu son banquier qui ma contacter soldé son crédit emprunter.');

-- --------------------------------------------------------

--
-- Structure de la table `inventaire`
--

CREATE TABLE `inventaire` (
  `idPartie` int(11) NOT NULL,
  `idObjet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `objet`
--

CREATE TABLE `objet` (
  `idObjet` int(11) NOT NULL,
  `nomObjet` varchar(30) DEFAULT NULL,
  `infos` varchar(300) DEFAULT NULL,
  `positionObjet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `partie`
--

CREATE TABLE `partie` (
  `idPartie` int(11) NOT NULL,
  `idConnexion` int(11) NOT NULL,
  `nomPartie` varchar(25) DEFAULT NULL,
  `positionJoueur` int(11) DEFAULT NULL,
  `progression` int(100) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `partie`
--

INSERT INTO `partie` (`idPartie`, `idConnexion`, `nomPartie`, `positionJoueur`, `progression`) VALUES
(1, 1, 'test', NULL, 4);

-- --------------------------------------------------------

--
-- Structure de la table `personnage`
--

CREATE TABLE `personnage` (
  `idPersonnage` int(11) NOT NULL,
  `idPartie` int(11) NOT NULL,
  `positionPersonnage` int(11) DEFAULT 0,
  `pseudoPersonnage` varchar(50) DEFAULT NULL,
  `culpabilite` int(1) DEFAULT NULL,
  `infosPersonnage` varchar(300) DEFAULT NULL,
  `noDiscussion` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personnage`
--

INSERT INTO `personnage` (`idPersonnage`, `idPartie`, `positionPersonnage`, `pseudoPersonnage`, `culpabilite`, `infosPersonnage`, `noDiscussion`) VALUES
(1, 1, NULL, 'Nolan  WALKER', 0, NULL, 1),
(2, 1, NULL, 'ROSE  THOMAS', 0, NULL, 1),
(3, 1, NULL, 'JULIA  THOMAS', 0, NULL, 1),
(4, 1, NULL, 'ANNA  ALLEN', 0, NULL, 1),
(5, 1, NULL, 'ABBY  LEE', 0, NULL, 1),
(6, 1, NULL, 'Lenny  JACKSON', 0, NULL, 1),
(7, 1, NULL, 'Tobby  ROBINSON', 0, NULL, 1),
(8, 1, NULL, 'Tony  JACKSON', 0, NULL, 1),
(9, 1, NULL, 'Alex  MILLER', 0, NULL, 1),
(10, 1, NULL, 'Tobby  LEWIS', 1, NULL, 1),
(11, 1, NULL, 'Jacob  ALLEN', 0, NULL, 1),
(12, 1, NULL, 'Alex  SMITH', 0, NULL, 1),
(13, 1, NULL, 'Tyler  BROWN', 0, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idConnexion` int(11) NOT NULL,
  `motsPasse` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `pseudo` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idConnexion`, `motsPasse`, `score`, `pseudo`) VALUES
(1, 1234, NULL, 'admin');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `banknomprenom`
--
ALTER TABLE `banknomprenom`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `bankquestion`
--
ALTER TABLE `bankquestion`
  ADD UNIQUE KEY `idPersonnage` (`idPersonnage`,`noDiscussion`,`noQuestion`,`idQuestion`);

--
-- Index pour la table `inventaire`
--
ALTER TABLE `inventaire`
  ADD PRIMARY KEY (`idObjet`,`idPartie`),
  ADD KEY `idPartie` (`idPartie`);

--
-- Index pour la table `objet`
--
ALTER TABLE `objet`
  ADD PRIMARY KEY (`idObjet`);

--
-- Index pour la table `partie`
--
ALTER TABLE `partie`
  ADD PRIMARY KEY (`idPartie`),
  ADD UNIQUE KEY `nomPartie` (`nomPartie`),
  ADD KEY `idConnexion` (`idConnexion`);

--
-- Index pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD PRIMARY KEY (`idPersonnage`,`idPartie`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idConnexion`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `banknomprenom`
--
ALTER TABLE `banknomprenom`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- AUTO_INCREMENT pour la table `partie`
--
ALTER TABLE `partie`
  MODIFY `idPartie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idConnexion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `inventaire`
--
ALTER TABLE `inventaire`
  ADD CONSTRAINT `inventaire_ibfk_1` FOREIGN KEY (`idPartie`) REFERENCES `partie` (`idPartie`);

--
-- Contraintes pour la table `partie`
--
ALTER TABLE `partie`
  ADD CONSTRAINT `partie_ibfk_1` FOREIGN KEY (`idConnexion`) REFERENCES `utilisateur` (`idConnexion`);

--
-- Contraintes pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD CONSTRAINT `personnage_ibfk_1` FOREIGN KEY (`idPartie`) REFERENCES `partie` (`idPartie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
