-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.1.36-community-log - MySQL Community Server (GPL)
-- SE du serveur:                Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de données de la table ruview_db.assignments : 3 rows
DELETE FROM `assignments`;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` (`Id`, `ProjectId`, `ProjectDuration`, `ResourceId`, `Commitment`, `StartDate`, `EndDate`) VALUES
	(1, 3, 3, 3, 1.00, '2021-03-09', '2022-11-15'),
	(2, 4, 4, 5, 1.00, '2018-12-01', '2018-12-25'),
	(3, 2, 2, 1, 0.25, '2018-11-10', '2055-02-23');
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;

-- Export de données de la table ruview_db.membership_grouppermissions : 3 rows
DELETE FROM `membership_grouppermissions`;
/*!40000 ALTER TABLE `membership_grouppermissions` DISABLE KEYS */;
INSERT INTO `membership_grouppermissions` (`permissionID`, `groupID`, `tableName`, `allowInsert`, `allowView`, `allowEdit`, `allowDelete`) VALUES
	(1, 2, 'assignments', 1, 3, 3, 3),
	(2, 2, 'resources', 1, 3, 3, 3),
	(3, 2, 'projects', 1, 3, 3, 3);
/*!40000 ALTER TABLE `membership_grouppermissions` ENABLE KEYS */;

-- Export de données de la table ruview_db.membership_groups : 2 rows
DELETE FROM `membership_groups`;
/*!40000 ALTER TABLE `membership_groups` DISABLE KEYS */;
INSERT INTO `membership_groups` (`groupID`, `name`, `description`, `allowSignup`, `needsApproval`) VALUES
	(1, 'anonymous', 'Anonymous group created automatically on 2018-11-07', 0, 0),
	(2, 'Admins', 'Admin group created automatically on 2018-11-07', 0, 1);
/*!40000 ALTER TABLE `membership_groups` ENABLE KEYS */;

-- Export de données de la table ruview_db.membership_userpermissions : 0 rows
DELETE FROM `membership_userpermissions`;
/*!40000 ALTER TABLE `membership_userpermissions` DISABLE KEYS */;
/*!40000 ALTER TABLE `membership_userpermissions` ENABLE KEYS */;

-- Export de données de la table ruview_db.membership_userrecords : 12 rows
DELETE FROM `membership_userrecords`;
/*!40000 ALTER TABLE `membership_userrecords` DISABLE KEYS */;
INSERT INTO `membership_userrecords` (`recID`, `tableName`, `pkValue`, `memberID`, `dateAdded`, `dateUpdated`, `groupID`) VALUES
	(1, 'resources', '1', 'admin', 1541602335, 1541602335, 2),
	(2, 'resources', '2', 'admin', 1541602345, 1541602345, 2),
	(3, 'resources', '3', 'admin', 1541602349, 1541602349, 2),
	(4, 'resources', '4', 'admin', 1541602362, 1541602362, 2),
	(5, 'projects', '1', 'admin', 1541602434, 1541602434, 2),
	(6, 'projects', '2', 'admin', 1541602523, 1541603128, 2),
	(7, 'projects', '3', 'admin', 1541602568, 1541602568, 2),
	(8, 'assignments', '1', 'admin', 1541602655, 1541602655, 2),
	(9, 'resources', '5', 'admin', 1541602689, 1541602689, 2),
	(10, 'assignments', '2', 'admin', 1541602731, 1541602984, 2),
	(11, 'projects', '4', 'admin', 1541602774, 1541602970, 2),
	(12, 'assignments', '3', 'admin', 1541603082, 1541603082, 2);
/*!40000 ALTER TABLE `membership_userrecords` ENABLE KEYS */;

-- Export de données de la table ruview_db.membership_users : 2 rows
DELETE FROM `membership_users`;
/*!40000 ALTER TABLE `membership_users` DISABLE KEYS */;
INSERT INTO `membership_users` (`memberID`, `passMD5`, `email`, `signupDate`, `groupID`, `isBanned`, `isApproved`, `custom1`, `custom2`, `custom3`, `custom4`, `comments`, `pass_reset_key`, `pass_reset_expiry`) VALUES
	('guest', NULL, NULL, '2018-11-07', 1, 0, 1, NULL, NULL, NULL, NULL, 'Anonymous member created automatically on 2018-11-07', NULL, NULL),
	('admin', '21232f297a57a5a743894a0e4a801fc3', 'adminruview@yopmail.com', '2018-11-07', 2, 0, 1, NULL, NULL, NULL, NULL, 'Admin member created automatically on 2018-11-07', NULL, NULL);
/*!40000 ALTER TABLE `membership_users` ENABLE KEYS */;

-- Export de données de la table ruview_db.projects : 4 rows
DELETE FROM `projects`;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` (`Id`, `Name`, `StartDate`, `EndDate`) VALUES
	(1, 'Tour Montparnasse Infernale', '2019-01-01', '2020-01-01'),
	(2, 'Objectif Mars', '2018-01-07', '2055-12-12'),
	(3, 'A390', '2021-03-08', '2023-11-16'),
	(4, 'Cadeaux', '2018-12-01', '2018-12-25');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;

-- Export de données de la table ruview_db.resources : 5 rows
DELETE FROM `resources`;
/*!40000 ALTER TABLE `resources` DISABLE KEYS */;
INSERT INTO `resources` (`Id`, `Name`, `Available`) VALUES
	(1, 'Tintin', '1'),
	(2, 'Toto', '1'),
	(3, 'Tata', '1'),
	(4, 'Tutu', '1'),
	(5, 'Papa Noel', '1');
/*!40000 ALTER TABLE `resources` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
