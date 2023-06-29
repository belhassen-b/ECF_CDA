-- Insertion des rôles
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('USER');
INSERT INTO role (name) VALUES ('PLAYER');

-- Insertion des utilisateurs
# INSERT INTO user (username, password, email, first_name, last_name, role_name)
# VALUES ('john.doe', 'password123', 'john.doe@example.com', 'John', 'Doe', 'ADMIN');
#
# INSERT INTO user (username, password, email, first_name, last_name, role_name)
# VALUES ('jane.smith', 'password456', 'jane.smith@example.com', 'Jane', 'Smith','USER');
# VALUES ('jane.smith', 'password456', 'jane.smith@example.com', 'Jane', 'Smith','PLAYER');