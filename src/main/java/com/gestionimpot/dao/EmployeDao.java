package com.gestionimpot.dao;

import com.gestionimpot.bean.Employe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {


    public List<Employe> findByNom(String nom);

    public List<Employe> findByPrenom(String prenom);

    public List<Employe> findByAdresseHabit(String adresseHabit);

    public List<Employe> findByAdresseMail(String adresseMail);

    public List<Employe> findBySexe(String sexe);

    public List<Employe> findByPrime(double prime);

    public Employe findByCin(String cin);

    public List<Employe> findBySalaire(double salaire);

    @Query("update Employe set salaire = nouveauSalaire where cne = 'cne'")
    int updateSalaire(String cne, double nouveauSalaire);
    
    

}
