ALTER TABLE `isidrone`.`order` 
ADD COLUMN `isShipped` TINYINT NOT NULL DEFAULT 0 AFTER `date`;