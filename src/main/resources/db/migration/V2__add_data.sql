INSERT INTO PROFESSEUR(NOM,PRENOM) VALUES ('Clapton', 'Eric');
INSERT INTO PROFESSEUR(NOM,PRENOM) VALUES ('Page', 'Jimmy');
INSERT INTO PROFESSEUR(NOM,PRENOM) VALUES ('Knopfler', 'Mark');
INSERT INTO PROFESSEUR(NOM,PRENOM) VALUES ('Porcaro', 'Mike');


INSERT INTO MATIERE(NOM) VALUES ('Guitare');
INSERT INTO MATIERE(NOM) VALUES ('Basse');

INSERT INTO COURS (ID_MATIERE, ID_PROFESSEUR) VALUES (1,1);
INSERT INTO COURS (ID_MATIERE, ID_PROFESSEUR) VALUES (1,2);
INSERT INTO COURS (ID_MATIERE, ID_PROFESSEUR) VALUES (1,3);
INSERT INTO COURS (ID_MATIERE, ID_PROFESSEUR) VALUES (null,4);
INSERT INTO COURS (ID_MATIERE, ID_PROFESSEUR) VALUES (2,4);


INSERT INTO ETUDIANT (NOM,PRENOM) VALUES ('Richards','Keith');
INSERT INTO ETUDIANT (NOM,PRENOM) VALUES ('Cobain','Kurt');
INSERT INTO ETUDIANT (NOM,PRENOM) VALUES ('Slash',null);

INSERT INTO SUIT_COURS(ID_COURS,ID_ETUDIANT) VALUES (1,1);
INSERT INTO SUIT_COURS(ID_COURS,ID_ETUDIANT) VALUES (1,2);
INSERT INTO SUIT_COURS(ID_COURS,ID_ETUDIANT) VALUES (1,3);
