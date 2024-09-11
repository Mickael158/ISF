package com.example.isf.service;

import com.example.isf.model.Cours;
import com.example.isf.model.Ecolage;
import com.example.isf.model.Etudiant;
import com.example.isf.model.PrixEcolage;
import com.example.isf.repository.CoursRepository;
import com.example.isf.repository.EcolageRepository;
import com.example.isf.repository.EtudiantRepository;
import com.example.isf.repository.PrixEcolageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EcolageService {
    @Autowired
    private EcolageRepository ecolageRepository;

    @Autowired
    private PrixEcolageRepository prixEcolageRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private CoursRepository coursRepository;

    public Ecolage enregistreEcolage(Ecolage ecolage) {
        return this.ecolageRepository.save(ecolage);
    }

    public Optional<Ecolage> select_Last_ecolage_payer(int  idEtudiant , int idCours) {
        return this.ecolageRepository.select_Last_ecolage_payer_By_idEtudiant_IdCours(idEtudiant , idCours);
    }
    public String ajouterMois(Date dateStr, int moisAAjouter) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Conversion de Date en LocalDate
        LocalDate date = dateStr.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        // Ajout du nombre de mois
        LocalDate dateModifiee = date.plusMonths(moisAAjouter);

        // Retour de la nouvelle date sous forme de chaîne
        return dateModifiee.format(formatter);
    }
    public List<Ecolage> devis_ecolage(int  id , int mois , int idCours) {
        List<Ecolage> devis = new ArrayList<>();
        Optional<Cours> cours = this.coursRepository.findById(idCours);
        Optional<PrixEcolage> prixEcolage = this.prixEcolageRepository.select_last_prix_ecolage_by_niveau(cours.get().getId_niveaux().getId_niveaux());
        Optional<Ecolage> laste_payement = this.ecolageRepository.select_Last_ecolage_payer_By_idEtudiant_IdCours(id , idCours);
        Optional<Etudiant> etudiant = this.etudiantRepository.findById(id);
        for (int i = 0; i < mois ; i++){
            Ecolage ecolage = new Ecolage();
            Date newDate = Date.valueOf(this.ajouterMois(laste_payement.get().getDates() , i));
            if (cours.get().getDate_debut().after(newDate) && cours.get().getDate_fin().before(newDate)){
                ecolage.setDates(newDate);
                ecolage.setDate_payement(new Date(new java.util.Date().getTime()));
                ecolage.setPrix(prixEcolage.get().getValeur());
                ecolage.setEtudiant_id(etudiant.get());
                ecolage.setId_cours(cours.get());
                devis.add(ecolage);
            }
        }
        return devis;
    }
}
