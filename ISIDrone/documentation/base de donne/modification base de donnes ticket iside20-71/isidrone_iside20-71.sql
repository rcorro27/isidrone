use isidrone;
ALTER TABLE `isidrone`.`user` 
ADD COLUMN `userRole` INT NOT NULL DEFAULT '2' AFTER `id`;
INSERT INTO address (`no`, `appt`, `street`, `zip`, `city`, `state`, `country`) VALUES (622, 6, 'miami', 'h3t 3u5', 'florida', 'florida', 'unites states');
INSERT INTO USER (`userRole`,`lastName`, `firstName`, `email`, `password`, `ship_address_id`) VALUES ( 1, 'admin', 'admin', 'admin@email.com', '46a0a09119a77850caad0bdfffcef8f059c9c0f1', 'id a AJOUTER APRES AVOIR AJOUTER LA ADRESSE , VOUS RECUPERER LE ID DE LA ADRESSE DANS LA TABLE ADRESSE ET VU LA INSERER ICI DANS LES ('') ' );

