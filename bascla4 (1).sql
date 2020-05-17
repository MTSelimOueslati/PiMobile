-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 17 mai 2020 à 19:20
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bascla4`
--

-- --------------------------------------------------------

--
-- Structure de la table `association`
--

DROP TABLE IF EXISTS `association`;
CREATE TABLE IF NOT EXISTS `association` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Logo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Location` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Website` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `association`
--

INSERT INTO `association` (`id`, `Name`, `Description`, `Logo`, `Location`, `Website`) VALUES
(31, 'association 10', 'aaaa', '6efb12255ec53e73977d906dd4fd7e3d.jpeg', 'aaaaa', ''),
(34, 'association 8', 'klllll', 'defb7c02299fb7616fed58beb03e235e.jpeg', 'llllllllllllll', 'https://web.facebook.com'),
(35, 'association 44', 'ddescription de l\'association 44', '31188f884bbc425d269174b6f636bbba.png', 'Ariana', 'http://127.0.0.1:8000/ajouterAssociation'),
(39, 'association 10', 'sdqs', 'c99a4d50da723da5c4d6795011608287.png', 'sssss', 'sssss'),
(40, 'association 15', 'Desc 15', '457f56d8f95507fea0e1cd7b340520af.jpeg', 'Ariana', 'https://web.facebook.com'),
(41, 'association15', 'description de l\'association15', '6efb12255ec53e73977d906dd4fd7e3d.jpeg', 'ariana', 'web'),
(42, 'association 50', 'description de l\'ass', '6efb12255ec53e73977d906dd4fd7e3d.jpeg', 'Ariana', 'www.bascla.com'),
(43, 'association 21', 'desc', '6efb12255ec53e73977d906dd4fd7e3d.jpeg', 'ariana', 'website'),
(44, 'association 107', 'deeded', '0ee8082f11d66eea91653272bae2662c.jpeg', 'ezrezrezr', 'http://127.0.0.1:8000/ajouterAssociation'),
(45, 'association 10', 'qsdsqd', 'cd204f28c7e5eaebfbe202c670cb1c1c.jpeg', 'qsdqsdsq', 'qsdqsdqsd'),
(46, 'association15', 'description de l\'association15', '6efb12255ec53e73977d906dd4fd7e3d.jpeg', 'ariana', 'web');

-- --------------------------------------------------------

--
-- Structure de la table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `Id_Bill` int(11) NOT NULL AUTO_INCREMENT,
  `Ammount` float NOT NULL,
  `Id_Item` int(11) NOT NULL,
  `Price` float NOT NULL,
  `Id_client` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_Bill`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bill`
--

INSERT INTO `bill` (`Id_Bill`, `Ammount`, `Id_Item`, `Price`, `Id_client`, `Name`, `Last_Name`) VALUES
(11, 255, 128812, 179689, 2323500, 'ines', 'jeddey');

-- --------------------------------------------------------

--
-- Structure de la table `fos_user`
--

DROP TABLE IF EXISTS `fos_user`;
CREATE TABLE IF NOT EXISTS `fos_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(180) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `confirmation_token` varchar(180) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `tel` int(11) DEFAULT NULL,
  `facebook_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `facebook_access_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_957A647992FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_957A6479A0D96FBF` (`email_canonical`),
  UNIQUE KEY `UNIQ_957A6479C05FB297` (`confirmation_token`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `fos_user`
--

INSERT INTO `fos_user` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `confirmation_token`, `password_requested_at`, `roles`, `tel`, `facebook_id`, `facebook_access_token`) VALUES
(1, 'mahdi', 'mahdi', 'mahdi@esprit', 'mahdi@esprit', 1, NULL, '$2y$13$zVo3OEFWZE88WSUS2dW8VeHkGCO.4e.1gLShEKqgT7szsJGd9shlm', NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL),
(2, 'aaa', 'aaa', 'aaa', 'aaa', 1, NULL, '$2y$13$4nR2h0b6XyLJ3M2R2cfStuO.QPBRp9P5oPB44Vp5ZyyWQ5WyhVArC', NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL),
(3, 'taieb', 'taieb', 'test@test.com', 'test@test.com', 1, NULL, '$2y$13$rSYngf.HacZPSeP2wtUSNO59uNXCb.MS15cbmrem1VpF5mlAZXKkm', NULL, NULL, NULL, 'a:0:{}', 0, NULL, NULL),
(4, 'mehdi', 'mehdi', 'zzzz@az.com', 'zzzz@az.com', 1, NULL, '$2y$13$4hkOETZEMol1I4u6Id.Z0.IjXSdPrGnvhripsWZBZOGvt/3LTPAhq', '2020-05-17 16:11:44', NULL, NULL, 'a:0:{}', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `order`
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `Id_Order` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Number` int(11) NOT NULL,
  `nbrOrder` int(11) DEFAULT NULL,
  `Date` varchar(30) DEFAULT NULL,
  `IdePanier` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Order`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `order`
--

INSERT INTO `order` (`Id_Order`, `Name`, `Last_Name`, `Email`, `Number`, `nbrOrder`, `Date`, `IdePanier`) VALUES
(1, 'test', 'test5', 'zzz', 5, 0, '', 0),
(45, 'zz', 'zzz', 'zzz', 25352, NULL, NULL, NULL),
(46, 'jeddey', 'ines', 'ines@gmail.com', 2535245, NULL, NULL, NULL),
(47, 'jeddey', 'ines', 'ines@gmail.com', 2535245, NULL, NULL, NULL),
(48, 'jeddey', 'ines', 'ines@gmail.com', 2345525, NULL, NULL, NULL),
(49, 'j', 'i', 'i', 5454454, NULL, NULL, NULL),
(50, 'j', 'i', 'i', 5454454, NULL, NULL, NULL),
(51, 'jeddey', 'ines', 'ines@gmail.com', 2535545, NULL, NULL, NULL),
(52, 'jeddey', 'ines', 'ines@gmail.com', 5454545, NULL, NULL, NULL),
(53, 'mehdi', 'bs', 'aaa', 888, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `shoppingcart`
--

DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE IF NOT EXISTS `shoppingcart` (
  `Id_Panier` int(11) NOT NULL AUTO_INCREMENT,
  `Ammount` double NOT NULL,
  `ide_produit` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id_Panier`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `shoppingcart`
--

INSERT INTO `shoppingcart` (`Id_Panier`, `Ammount`, `ide_produit`) VALUES
(130, 5, NULL),
(131, 5, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `task`
--

INSERT INTO `task` (`id`, `name`, `status`) VALUES
(1, 'Create a new symfony project', 1),
(2, 'Test the application with PostMan', 0),
(3, 'Add new Task', 0),
(4, 'Create your next mobileapp', 0);

-- --------------------------------------------------------

--
-- Structure de la table `velovendre`
--

DROP TABLE IF EXISTS `velovendre`;
CREATE TABLE IF NOT EXISTS `velovendre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prix` int(11) NOT NULL,
  `marque` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Path_photo` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` int(11) NOT NULL,
  `verif` int(11) DEFAULT 1,
  `longt` double NOT NULL,
  `altd` double NOT NULL,
  `categorie` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'professionnel',
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Déchargement des données de la table `velovendre`
--

INSERT INTO `velovendre` (`id`, `prix`, `marque`, `Path_photo`, `description`, `nombre`, `verif`, `longt`, `altd`, `categorie`, `username`) VALUES
(66, 3, 'dd', 'f_5eb373ec87cc7.jpg', 'ddd', 3, 0, -74.005973, 43.71435300000002, 'professionnel', 'farah'),
(89, 12, 'bo', 'f_5eae0a15e7d72.jpg', 'j', 0, 0, -74.005973, 43.71435300000002, 'professionnel', 'farah'),
(90, 10, 'mmm', 'f_5eb3730c342c4.jpg', 'ddd', 3, 0, -74.005973, 43.71435300000002, 'professionnel', 'mahdi');

-- --------------------------------------------------------

--
-- Structure de la table `velovendree`
--

DROP TABLE IF EXISTS `velovendree`;
CREATE TABLE IF NOT EXISTS `velovendree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double NOT NULL,
  `marque` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Path_photo` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
