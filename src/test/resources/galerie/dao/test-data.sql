-- Initialisation spécifiques pour un jeu de test
INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'King\''s Road, Londres');
INSERT INTO Personne(dtype,id, nom, adresse,biographie) VALUES ('Artiste',1, 'artisteName', '11 Road, Londres','biographie');
INSERT INTO Personne(dtype,id, nom, adresse) VALUES ('Personne', 2 , 'personneName', '111 Road, Londres' );
INSERT INTO tableau(id, hauteur, largeur,support,titre,auteur_id) VALUES (1, 20, 20,'support','titre',1);
INSERT INTO tableau(id, hauteur, largeur,support,titre,auteur_id) VALUES (2, 20, 20,'support','titre',null);
INSERT INTO tableau(id, hauteur, largeur,support,titre,auteur_id) VALUES (11, 20, 20,'support','titre',1);
INSERT INTO exposition(id, debut, duree,intitule,organisateur_id) VALUES (1, TO_DATE('01/02/2021', 'DD/MM/YYYY'), 3,'esposition1',1);
INSERT INTO exposition(id, debut, duree,intitule,organisateur_id) VALUES (11, TO_DATE('01/06/2021', 'DD/MM/YYYY'), 3,'exposition11',1);
INSERT INTO transaction (id, prix_vente, vendu_le,client_id,lieu_de_vente_id,oeuvre_id) VALUES (1,1000000, TO_DATE('01/06/2021', 'DD/MM/YYYY'), 2,1,1);
INSERT INTO transaction (id, prix_vente, vendu_le,client_id,lieu_de_vente_id,oeuvre_id) VALUES (2,1, TO_DATE('01/06/2021', 'DD/MM/YYYY'), 2,1,2);
