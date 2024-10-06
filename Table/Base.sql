CREATE TABLE institut(
    id_Institut SERIAL PRIMARY KEY,
    Logo VARCHAR(100) NOT NULL,
    Nom_Institut VARCHAR(100) NOT NULL,
    Description VARCHAR(500) NOT NULL,
    MotDirecteur VARCHAR(2000) NOT NULL,
    Agrement VARCHAR(200),
    Siege VARCHAR(200)
);
insert into institut(Logo, Nom_Institut, Description, MotDirecteur, Agrement, Siege) VALUES ('AAA','IS-INFO','DESCRIPTION','MOT','AGREMENT','Ampasamadinika');
CREATE TABLE evenement(
    id_evenement SERIAL PRIMARY KEY,
    Date_Evenement date,
    Lieu_Evenement VARCHAR(100),
    Decription VARCHAR(1000) NOT NULL,
    Evenement VARCHAR(200),
    image VARCHAR
);
CREATE TABLE role (
    id_role SERIAL PRIMARY KEY,
    nom VARCHAR(100)
);
insert into role(nom) VALUES('ADMIN');
CREATE TABLE formation(
    id_Formation SERIAL PRIMARY KEY,
    Nom_Formation VARCHAR(100) NOT NULL,
    CodeF VARCHAR(10) NOT NULL);

CREATE TABLE filiere(
    id_Filiere SERIAL PRIMARY KEY,
    CodeF VARCHAR(20) NOT NULL,
    Filiere VARCHAR(100) NOT NULL);

CREATE TABLE semestre(
     id_Semestre SERIAL PRIMARY KEY,
     Semestre VARCHAR(100)
);
CREATE TABLE promotion(
      id_Promotion SERIAL PRIMARY KEY,
      CodeP VARCHAR(20) NOT NULL,
      Anne_Promotion VARCHAR(20) NOT NULL,
      Filiere_id  INT REFERENCES FILIERE(id_filiere),
      Formation_id  INT REFERENCES FORMATION(id_Formation)
);
CREATE TABLE genre(
  id_genre SERIAL PRIMARY KEY ,
  nom VARCHAR(100)
);
insert into genre(nom) VALUES('Masculin');
CREATE TABLE personne(
     id_personne SERIAL PRIMARY KEY,
     Nom VARCHAR(100) NOT NULL,
     Prenom VARCHAR(100) NOT NULL,
     Telephone VARCHAR(16) NOT NULL,
     id_genre INT REFERENCES genre(id_genre),
     email VARCHAR(100),
     adresse VARCHAR(100)
);
INSERT INTO personne(Nom, Prenom, Telephone, id_genre, email, adresse) VALUES('raherimanana','Toky','0343562462',1,'zosephatoky@ggmail.com','FAIV 410 B');
CREATE TABLE etudiant(
     id_Etudiant SERIAL PRIMARY KEY,
     Matricule VARCHAR(10) ,
     id_personne INT REFERENCES personne(id_personne),
     promotion_id INT REFERENCES promotion(id_Promotion)
);
CREATE TABLE utilisateur(
    id_utilisateur SERIAL PRIMARY KEY,
    Password VARCHAR(100) NOT NULL,
    idRole INT REFERENCES role(id_role),
    id_personne INT REFERENCES personne(id_personne)
);
insert into utilisateur(Password,idRole,id_personne) VALUES('123456',1,1);
CREATE TABLE niveaux(
    id_niveaux SERIAL PRIMARY KEY,
    nom VARCHAR(100)
);
CREATE TABLE cours(
      id_Cours SERIAL PRIMARY KEY,
      Date_Debut DATE,
      Date_Fin DATE,
      Promotion_id INT REFERENCES PROMOTION(id_Promotion),
      id_niveaux INT REFERENCES niveaux(id_niveaux)
);
CREATE TABLE Liste_Etudiant_Inscrit_Cours(
    id_Liste_Etudiant_Inscrit_Cours SERIAL PRIMARY KEY,
    id_cours INT REFERENCES COURS(id_Cours),
    id_etudiant INT REFERENCES Etudiant(id_Etudiant)
);

CREATE TABLE prix_ecolage(
     id_prix_ecolage SERIAL PRIMARY KEY,
     valeur float,
     dates date,
     id_niveau INT REFERENCES niveaux(id_niveaux)
);
CREATE TABLE ecolage(
    id_Ecolage SERIAL PRIMARY KEY,
    dates Date ,
    date_payement date,
    prix float,
    id_Cours INT REFERENCES cours(id_cours),
    Etudiant_id INT REFERENCES Etudiant(id_Etudiant)
);
CREATE TABLE professeur(
    id_Professeur SERIAL PRIMARY KEY,
    id_personne INT REFERENCES personne(id_personne)
);
CREATE TABLE matiere(
    id_Matiere SERIAL PRIMARY KEY,
    Nom_Matiere VARCHAR(100) NOT NULL,
    Coeff INT
);
CREATE TABLE professeur_matiere(
    id_professeur_matiere SERIAL PRIMARY KEY ,
    Professeur_id INT REFERENCES PROFESSEUR(id_Professeur),
    Matiere_id INT REFERENCES MATIERE(id_Matiere),
    id_Cours INT REFERENCES COURS(id_Cours)
);

CREATE TABLE examen(
  id_examen SERIAL PRIMARY KEY ,
  date_debut date,
  date_fin date,
  cours_id INT REFERENCES COURS(id_Cours),
  semestre_id INT REFERENCES SEMESTRE(id_Semestre)
);
CREATE TABLE note_examen(
  id_note_examen SERIAL PRIMARY KEY ,
  id_examen INT REFERENCES examen(id_examen),
  id_etudiant INT REFERENCES ETUDIANT(id_Etudiant),
  id_professeur_matiere INT REFERENCES professeur_matiere(id_professeur_matiere),
  note float
);
///////////////////////////////////////////////////////////////////////////////////////////


CREATE TABLE DOSSIER_FOURNIR(
                                id_dossier SERIAL PRIMARY KEY,
                                Dossier VARCHAR(100) NOT NULL
);

CREATE TABLE INSCRIPTION_ATTENTE(
                                    id_inscription SERIAL PRIMARY KEY,
                                    Nom VARCHAR(100) NOT NULL,
                                    Prenom VARCHAR(100) NOT NULL,
                                    Telephone VARCHAR(16) NOT NULL,
                                    Utilisateur_id  INT REFERENCES Utilisateur(id_Utilisateur));


SELECT p.id_personne, p.nom, p.prenom, p.telephone, p.id_genre, p.email, p.adresse
FROM personne p
LEFT JOIN etudiant e ON p.id_personne = e.id_personne
LEFT JOIN professeur pr ON pr.id_personne = p.id_personne
WHERE e.id_personne IS NULL 
AND pr.id_personne IS NULL
AND p.email = 'jeanson@gmail.com';




