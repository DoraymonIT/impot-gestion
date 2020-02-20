package com.gestionimpot.service.facade;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import java.util.List;

public interface EmployeService {

    public List<Employe> findAll();

    public List<Employe> findByNom(String nom );

    public List<Employe> findByPrenom(String prenom);

    public List<Employe> findByAdresseHabit(String adresseHabit);

    public List<Employe> findByAdresseMail(String adresseMail);

    public List<Employe> findBySexe(String sexe);

    public List<Employe> findByPrime(double prime);

    public Employe findByCin(String cin);

    public List<Employe> findBySalaire(double salaire);

    public List<Employe> findBySociete(String societe);

    public int save(Employe employe);

    public int deleteByCin(String cin);
    
}
