-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 22 Mars 2019 à 13:01
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `orange1`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonnement`
--

CREATE TABLE IF NOT EXISTS `abonnement` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATEFIN` date DEFAULT NULL,
  `CLIENT_ID` bigint(20) DEFAULT NULL,
  `TYPEABONNEMENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ABONNEMENT_CLIENT_ID` (`CLIENT_ID`),
  KEY `FK_ABONNEMENT_TYPEABONNEMENT_ID` (`TYPEABONNEMENT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Contenu de la table `abonnement`
--

INSERT INTO `abonnement` (`ID`, `DATEFIN`, `CLIENT_ID`, `TYPEABONNEMENT_ID`) VALUES
(3, '2019-01-05', 1, 1),
(4, '2019-01-20', 4, 1),
(5, '2019-01-13', 5, 1),
(6, '2019-01-12', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

CREATE TABLE IF NOT EXISTS `achat` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MODE` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `CLIENT_ID` bigint(20) DEFAULT NULL,
  `TYPEACHATS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ACHAT_TYPEACHATS_ID` (`TYPEACHATS_ID`),
  KEY `FK_ACHAT_CLIENT_ID` (`CLIENT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `achat`
--

INSERT INTO `achat` (`ID`, `MODE`, `NOM`, `CLIENT_ID`, `TYPEACHATS_ID`) VALUES
(1, 'Paiement par carte', 'IPhone X', 2, 1),
(2, 'Paiement par chèque', 'Casque Téléphonique', 4, 3),
(3, 'Paiement par chèque', 'IPhone X', 4, 1),
(4, 'Paiement par chèque', 'IPhone X', 2, 1),
(5, 'Paiement par carte', 'CLE USB', 5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `ID` bigint(20) NOT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`ID`, `PASSWORD`, `USERNAME`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE IF NOT EXISTS `agence` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADRESSE` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `VILLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_AGENCE_VILLE_ID` (`VILLE_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Contenu de la table `agence`
--

INSERT INTO `agence` (`ID`, `ADRESSE`, `NOM`, `VILLE_ID`) VALUES
(1, 'GUELIZ', 'OrangeGueliz', 1),
(2, 'Massira 1', 'OrangeMassira', 1),
(3, 'Ain Diab', 'OrangeAinDiab', 2),
(4, 'Sidi Maarouf', 'OrangeSidiMaarouf', 2),
(5, 'Charaf', 'OrangeCharaf', 5),
(6, 'Salam', 'OrangeSalam', 5),
(7, 'Hay Riad', 'OrangeHayRiad', 3),
(8, 'Al Hafa', 'OrangeAlHafa', 4),
(9, 'Menara', 'OrangeMenara', 1),
(10, 'Malabata', 'OrangeMalabata', 4);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `ID` bigint(20) NOT NULL,
  `DATEDENAISSANCE` date DEFAULT NULL,
  `NATIONALITE` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `SEXE` varchar(255) DEFAULT NULL,
  `AGENCE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CLIENT_AGENCE_ID` (`AGENCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`ID`, `DATEDENAISSANCE`, `NATIONALITE`, `NOM`, `PASSWORD`, `PRENOM`, `SEXE`, `AGENCE_ID`) VALUES
(1, '1996-02-12', 'Marocaine', 'TIDRIRI', 'test', 'Khalil', 'H', 1),
(2, '1995-12-08', 'Marocaine', 'CHERRAT', 'test', 'Sara', 'F', 4),
(3, '1989-06-10', 'Marocaine', 'HENNI', 'test', 'Mohammed', 'H', 2),
(4, '1995-11-15', 'Marocaine', 'Ait Khouya', 'test', 'Saad', 'H', 5),
(5, '1994-01-15', 'Marocaine', 'DARARI', 'test', 'Zakaria', 'H', 2);

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(255) DEFAULT NULL,
  `DATEFINPAIEMENT` date DEFAULT NULL,
  `DATEPAIEMENT` date DEFAULT NULL,
  `MODE` varchar(255) DEFAULT NULL,
  `MONTANT` double DEFAULT NULL,
  `CLIENT_ID` bigint(20) DEFAULT NULL,
  `TYPEABONNEMENT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_FACTURE_CLIENT_ID` (`CLIENT_ID`),
  KEY `FK_FACTURE_TYPEABONNEMENT_ID` (`TYPEABONNEMENT_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Contenu de la table `facture`
--

INSERT INTO `facture` (`ID`, `CODE`, `DATEFINPAIEMENT`, `DATEPAIEMENT`, `MODE`, `MONTANT`, `CLIENT_ID`, `TYPEABONNEMENT_ID`) VALUES
(5, 'test', '2019-01-20', '2019-01-13', 'Paiement par carte', 500, 4, 2),
(6, 'test', '2019-01-12', '2019-01-05', 'Paiement par carte', 1250, 2, 1),
(7, 'test', '2019-01-12', '2019-01-05', 'Paiement par carte', 1000, 2, 2),
(8, 'test', '2019-01-12', '2019-01-05', 'Paiement par carte', 750, 1, 1),
(9, 'test', '2019-01-12', '2019-01-05', 'Paiement par carte', 650, 1, 2),
(10, 'test', '2019-01-12', '2019-01-05', 'Paiement par carte', 980, 1, 3),
(11, 'test', '2019-01-12', '2019-01-04', 'Paiement par carte', 750, 5, 1),
(12, 'test', '2019-01-12', '2019-01-04', 'Paiement par carte', 250, 5, 1),
(13, 'test', '2019-01-12', '2019-01-04', 'Paiement par carte', 300, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE IF NOT EXISTS `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '0');

-- --------------------------------------------------------

--
-- Structure de la table `typeabonnement`
--

CREATE TABLE IF NOT EXISTS `typeabonnement` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  `PRIX` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `typeabonnement`
--

INSERT INTO `typeabonnement` (`ID`, `NOM`, `PRIX`) VALUES
(1, 'INTERNET', 250),
(2, 'APPELS', 300),
(3, 'SMS', 150);

-- --------------------------------------------------------

--
-- Structure de la table `typeachats`
--

CREATE TABLE IF NOT EXISTS `typeachats` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  `PRIX` double DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `typeachats`
--

INSERT INTO `typeachats` (`ID`, `NOM`, `PRIX`) VALUES
(1, 'IPhone X', 9500),
(2, 'CLE USB', 60),
(3, 'Casque Téléphonique', 120),
(10, 'SOURIS', 150),
(11, 'Samsung S7 Galaxy', 1800);

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE IF NOT EXISTS `ville` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `ville`
--

INSERT INTO `ville` (`ID`, `NOM`) VALUES
(1, 'Marrakech'),
(2, 'Casablanca'),
(3, 'Rabat'),
(4, 'Tanger'),
(5, 'Agadir'),
(6, 'Fes'),
(7, 'Berrechid');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `abonnement`
--
ALTER TABLE `abonnement`
  ADD CONSTRAINT `FK_ABONNEMENT_CLIENT_ID` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK_ABONNEMENT_TYPEABONNEMENT_ID` FOREIGN KEY (`TYPEABONNEMENT_ID`) REFERENCES `typeabonnement` (`ID`);

--
-- Contraintes pour la table `achat`
--
ALTER TABLE `achat`
  ADD CONSTRAINT `FK_ACHAT_CLIENT_ID` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK_ACHAT_TYPEACHATS_ID` FOREIGN KEY (`TYPEACHATS_ID`) REFERENCES `typeachats` (`ID`);

--
-- Contraintes pour la table `agence`
--
ALTER TABLE `agence`
  ADD CONSTRAINT `FK_AGENCE_VILLE_ID` FOREIGN KEY (`VILLE_ID`) REFERENCES `ville` (`ID`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `FK_CLIENT_AGENCE_ID` FOREIGN KEY (`AGENCE_ID`) REFERENCES `agence` (`ID`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FK_FACTURE_CLIENT_ID` FOREIGN KEY (`CLIENT_ID`) REFERENCES `client` (`ID`),
  ADD CONSTRAINT `FK_FACTURE_TYPEABONNEMENT_ID` FOREIGN KEY (`TYPEABONNEMENT_ID`) REFERENCES `typeabonnement` (`ID`);
SET FOREIGN_KEY_CHECKS=1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
