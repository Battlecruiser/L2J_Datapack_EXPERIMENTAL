DROP TABLE `character_lov_bonus`;
ALTER TABLE `characters` DROP `PcPoint`;
ALTER TABLE `characters` DROP `pccafe_points`;
ALTER TABLE `character_premium_items` DROP `itemElementType`;
ALTER TABLE `character_premium_items` DROP `itemElementValue`;
ALTER TABLE `character_premium_items` DROP `itemEnchantLevel`;
ALTER TABLE `character_premium_items` DROP `itemAugumentSkillId`;
ALTER TABLE `character_premium_items` DROP `itemAugumentSkillLevel`;
ALTER TABLE `character_summons` DROP INDEX `Index 1`, ADD PRIMARY KEY (`ownerId`,`summonSkillId`);
ALTER TABLE `characters` MODIFY `vitality_points` mediumint unsigned NOT NULL DEFAULT 0;
ALTER TABLE `raidboss_spawnlist` MODIFY `currentHp` decimal(30,0) DEFAULT NULL;
ALTER TABLE `raidboss_spawnlist` MODIFY `currentMp` decimal(30,0) DEFAULT NULL;