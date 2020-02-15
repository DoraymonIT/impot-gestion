package com.gestionimpot.service.facade;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import java.util.List;

public interface EmployeService {

    Employe findBynNumeroEmploye(Long numeroEmploye);

    List<Employe> findAll();

    List<Employe> finfByCin(String cin);

    List<Employe> findBySalaire(double salaire);

    List<Employe> findBysocieteNom(Societe societe);

    int save(Employe employe);
    
    
}
