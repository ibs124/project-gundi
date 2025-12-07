INSERT INTO `users` (`username`, `full_name`, `password`) VALUES
('rob','Robb Stark','pass123'),
('ned','Eddard Stark','pass123'),
('robert','Robert Baratheon','pass123'),
('jon_arryn','Jon Arryn','pass123'),
('jon','Jon Snow','pass123'),
('daenerys','Daenerys Targaryen','pass123'),
('bran','Bran Stark','pass123'),
('sansa','Sansa Stark','pass123'),
('cersei','Cersei Lannister','pass123'),
('jaime','Jaime Lannister','pass123'),
('samwell','Samwell Tarly','pass123'),
('brienne','Brienne of Tarth','pass123'),
('sandor','Sandor Clegane','pass123'),
('jorah','Jorah Mormont','pass123'),
('theon','Theon Greyjoy','pass123'),
('yara','Yara Greyjoy','pass123'),
('melisandre','Melisandre','pass123'),
('varys','Varys','pass123'),
('drogo','Khal Drogo','pass123'),
('missandei','Missandei','pass123'),

('tywin','Tywin Lannister','pass123'),
('stannis','Stannis Baratheon','pass123'),
('renly','Renly Baratheon','pass123'),
('joffrey','Joffrey Baratheon','pass123'),
('tyrion','Tyrion Lannister','pass123'),
('catelyn','Catelyn Stark','pass123'),
('aegon','Aegon Targaryen','pass123'),
('rickon','Rickon Stark','pass123'),
('eddard','Eddard Stark','pass123'),
('lyanna','Lyanna Stark','pass123'),
('marillion','Marillion Tarth','pass123'),
('doran','Doran Martell','pass123'),
('oberyn','Oberyn Martell','pass123'),
('aresa','Aresa Martell','pass123'),
('aron','Aron Greyjoy','pass123'),
('aeron','Aeron Greyjoy','pass123'),
('theon2','Theon Greyjoy II','pass123'),
('yara2','Yara Greyjoy II','pass123'),
('garlan','Garlan Tyrell','pass123'),
('margaery','Margaery Tyrell','pass123'),

('loras','Loras Tyrell','pass123'),
('meera','Meera Reed','pass123'),
('wylla','Wylla Reed','pass123'),
('howland','Howland Reed','pass123'),
('roose','Roose Bolton','pass123'),
('ramsey','Ramsey Bolton','pass123'),
('walder','Walder Frey','pass123'),
('lothar','Lothar Frey','pass123'),
('rhaegar','Rhaegar Targaryen','pass123'),
('viserys','Viserys Targaryen','pass123'),
('jon2','Jon Targaryen II','pass123'),
('aegon2','Aegon Targaryen II','pass123'),
('salladhor','Salladhor Saan','pass123'),
('beric','Beric Dondarrion','pass123'),
('thoros','Thoros Dondarrion','pass123'),
('davos','Davos Seaworth','pass123'),
('bronn','Bronn','pass123'),
('gilly','Gilly','pass123'),
('sam2','Samwell Tarly II','pass123'),
('shae','Shae','pass123'),

('renly2','Renly Baratheon II','pass123'),
('ellaria','Ellaria Sand','pass123'),
('tyene','Tyene Sand','pass123'),
('obara','Obara Sand','pass123'),
('nymeria','Nymeria Sand','pass123'),
('jaqen','Jaqen Hghar','pass123'),
('arya2','Arya Stark II','pass123'),
('podrick','Podrick Payne','pass123'),
('robin','Robin Arryn','pass123'),
('lysa','Lysa Arryn','pass123'),
('marillion2','Marillion Tarth II','pass123'),
('doran2','Doran Martell II','pass123'),
('oberyn2','Oberyn Martell II','pass123'),
('aresa2','Aresa Martell II','pass123'),
('aron2','Aron Greyjoy II','pass123'),
('aeron2','Aeron Greyjoy II','pass123'),
('garlan2','Garlan Tyrell II','pass123'),
('margaery2','Margaery Tyrell II','pass123'),
('loras2','Loras Tyrell II','pass123'),
('meera2','Meera Reed II','pass123'),

('wylla2','Wylla Reed II','pass123'),
('howland2','Howland Reed II','pass123'),
('roose2','Roose Bolton II','pass123'),
('ramsey2','Ramsey Bolton II','pass123'),
('walder2','Walder Frey II','pass123'),
('lothar2','Lothar Frey II','pass123'),
('rhaegar2','Rhaegar Targaryen II','pass123'),
('viserys2','Viserys Targaryen II','pass123'),
('jon3','Jon Targaryen III','pass123'),
('aegon3','Aegon Targaryen III','pass123'),
('salladhor2','Salladhor Saan II','pass123'),
('beric2','Beric Dondarrion II','pass123'),
('thoros2','Thoros Dondarrion II','pass123'),
('davos2','Davos Seaworth II','pass123'),
('bronn2','Bronn II','pass123'),
('gilly2','Gilly II','pass123'),
('sam3','Samwell Tarly III','pass123'),
('shae2','Shae II','pass123'),
('ellaria2','Ellaria Sand II','pass123'),
('arya','Arya Stark','pass123');

UPDATE `users` 
SET 
    `password` = '$2a$12$rsH4xQP6BT.9f508L9Qiru2OtjvVfmYw16p/bD3VYHtacjH0Vyz5K',
    `enabled` = 1;

INSERT INTO `user_roles` (`type`) VALUES ('ROOT'), ('ADMIN'), ('USER');

INSERT INTO `users_roles_map` (`user_id`, `role_id`)
SELECT `id`, 1 FROM `users` WHERE `id` = 1;

INSERT INTO `users_roles_map` (`user_id`, `role_id`)
SELECT `id`, 2 FROM `users` WHERE `id` BETWEEN 1 AND 4;

INSERT INTO `users_roles_map` (`user_id`, `role_id`)
SELECT `id`, 3 FROM `users`;

INSERT INTO `emails` (`user_id`, `name`, `verified_at`, `is_primary`)
SELECT `id`, CONCAT(`username`, '@example.com'), CURRENT_TIMESTAMP, 1 
FROM `users`;
