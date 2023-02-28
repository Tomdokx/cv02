--changeset Tomdok:2
CREATE TABLE task (
   id int4 PRIMARY KEY,
   title varchar(255) ,
   description text ,
   creation_date DATE,
   update_date DATE,
   author_id INT REFERENCES app_user(id)
);
CREATE TABLE role (
   id int4 PRIMARY KEY,
   name varchar(255)
);

CREATE TABLE app_user_role(
    app_user_id INT REFERENCES app_user(id),
    role_id INT REFERENCES role(id)
);