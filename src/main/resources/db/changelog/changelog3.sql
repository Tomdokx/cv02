INSERT INTO app_user(id,username,password,active, creation_date,update_date)
VALUES (1, 'Username1','Password1',true,'1922-02-02','1922-03-02' );
INSERT INTO app_user(id,username,password,active, creation_date,update_date)
VALUES (2, 'Username2','Password2',false,'1925-02-02','1925-03-02' );
INSERT INTO app_user(id,username,password,active, creation_date,update_date)
VALUES (3, 'Username3','Password3',true,'1999-02-02','1999-03-02' );

INSERT INTO role(id,name) VALUES (1, 'Role1');
INSERT INTO role(id,name) VALUES (2, 'Role2');
INSERT INTO role(id,name) VALUES (3, 'Role3');

INSERT INTO task(id,title,description,creation_date,update_date,author_id)
VALUES (1, 'Title1','Description1','1922-02-02','1922-03-02',1);
INSERT INTO task(id,title,description,creation_date,update_date,author_id)
VALUES (2, 'Title2','Description2','1923-02-02','1924-03-02',1);
INSERT INTO task(id,title,description,creation_date,update_date,author_id)
VALUES (3, 'Title3','Description3','1924-02-02','1925-03-02',2);
INSERT INTO task(id,title,description,creation_date,update_date,author_id)
VALUES (4, 'Title4','Description4','1925-02-02','1926-03-02',2);
INSERT INTO task(id,title,description,creation_date,update_date,author_id)
VALUES (5, 'Title5','Description5','1926-02-02','1927-03-02',3);

INSERT INTO app_user_role (app_user_id,role_id) VALUES (1, 1);
INSERT INTO app_user_role (app_user_id,role_id) VALUES (1, 2);
INSERT INTO app_user_role (app_user_id,role_id) VALUES (1, 3);
INSERT INTO app_user_role (app_user_id,role_id) VALUES (2, 2);
INSERT INTO app_user_role (app_user_id,role_id) VALUES (3, 3);