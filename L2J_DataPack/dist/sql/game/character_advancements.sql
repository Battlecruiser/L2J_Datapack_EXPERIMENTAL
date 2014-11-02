CREATE TABLE IF NOT EXISTS `character_advancement` (
  `charId` int unsigned NOT NULL DEFAULT '0',
  `class_index` tinyint unsigned NOT NULL DEFAULT '0',
  `class_id` tinyint unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`charId`,`class_index`,`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
