INSERT INTO user_roles (id,type) VALUES (1,'ROOT'), (2,'ADMIN'), (3,'USER');

INSERT INTO users (id,username,email,full_name,password) VALUES
(1,'aegon','aegon.targaryen@example.com','Aegon Targaryen','aaa'),
(2,'tywin','tywin.lannister@example.com','Tywin Lannister','aaa'),
(3,'ned','ned.stark@example.com','Eddard Stark','aaa'),
(4,'arya','arya.stark@example.com','Arya Stark','aaa'),
(5,'jon','jon.snow@example.com','Jon Snow','aaa'),
(6,'daenerys','daenerys.targaryen@example.com','Daenerys Targaryen','aaa');

INSERT INTO users_roles (user_id,role_id) VALUES (1,1),(2,2),(3,2),(4,3),(5,3),(6,3);