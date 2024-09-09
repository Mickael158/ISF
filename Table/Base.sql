CREATE TABLE institut(
    id_Institut SERIAL PRIMARY KEY,
    Logo VARCHAR(100) NOT NULL
);

CREATE TABLE role (
    id_role SERIAL PRIMARY KEY,
    nom VARCHAR
);
CREATE TABLE FORMATION(
    id_Formation SERIAL PRIMARY KEY,
    Nom_Formation VARCHAR(100) NOT NULL);

CREATE TABLE FILIERE(
    id_Filiere SERIAL PRIMARY KEY,
    CodeF VARCHAR(20) NOT NULL,
    Filiere VARCHAR(100) NOT NULL);

CREATE TABLE SEMESTRE(
     id_Semestre SERIAL PRIMARY KEY,
     Semestre VARCHAR(100)
);
CREATE TABLE PROMOTION(
      id_Promotion SERIAL PRIMARY KEY,
      CodeP VARCHAR(20) NOT NULL,
      Anne_Promotion VARCHAR(20) NOT NULL,
      Filiere_id  INT REFERENCES FILIERE(id_filiere),
      Formation_id  INT REFERENCES FORMATION(id_Formation)
);
CREATE TABLE personne(
     id_personne SERIAL PRIMARY KEY,
     Nom VARCHAR(100) NOT NULL,
     Prenom VARCHAR(100) NOT NULL,
     Telephone VARCHAR(16) NOT NULL
);
CREATE TABLE ETUDIANT(
     id_Etudiant SERIAL PRIMARY KEY,
     Matricule VARCHAR(10) ,
     id_personne INT REFERENCES personne(id_personne),
     promotion_id INT REFERENCES promotion(id_Promotion)
);
CREATE TABLE Utilisateur(
    id_utilisateur SERIAL PRIMARY KEY,
    Password VARCHAR(100) NOT NULL,
    idRole INT REFERENCES role(id_role),
    id_personne INT REFERENCES personne(id_personne)
);
CREATE TABLE niveaux(
    id_niveaux SERIAL PRIMARY KEY,
    nom VARCHAR
);
CREATE TABLE COURS(
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
CREATE TABLE ECOLAGE(
    id_Ecolage SERIAL PRIMARY KEY,
    dates Date ,
    date_payement date,
    prix float,
    id_Cours INT REFERENCES cours(id_cours),
    Etudiant_id INT REFERENCES Etudiant(id_Etudiant)
);


///////////////////////////////////////////////////////////////////////////////////////////


CREATE TABLE PROFESSEUR(
   id_Professeur SERIAL PRIMARY KEY,
   id_personne INT REFERENCES personne(id_personne)
);
CREATE TABLE MATIERE(
    id_Matiere SERIAL PRIMARY KEY,
    Nom_Matiere VARCHAR(100) NOT NULL,
    Coeff INT
);

CREATE TABLE PROFESSEUR_MATIERE(
   Professeur_id INT REFERENCES PROFESSEUR(id_Professeur),
   Matiere_id INT REFERENCES MATIERE(id_Natiere)
);

CREATE TABLE NOTE(
                     id_Note SERIAL NOT NULL,
                     Note INT,
                     Matiere_id INT REFERENCES MATIERE(id_Matiere),
                     Examen_id INT REFERENCES EXAMEN(id_Examen),
                     Etudiant_id INT REFERENCES ETUDIANT(id_Etudiant)
);

CREATE TABLE RESULTAT_EXAMEN(
                                id_Resultat SERIAL PRIMARY KEY,
                                Total FLOAT,
                                Moyen_General FLOAT,
                                Examen_Id INT REFERENCES EXAMEN(id_Examen),
                                Etudiant_Id INT REFERENCES ETUDIANT(id_Etudiant)
);


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



