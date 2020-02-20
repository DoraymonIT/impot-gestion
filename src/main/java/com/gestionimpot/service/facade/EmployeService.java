package com.gestionimpot.service.facade;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import java.util.List;

public interface EmployeService {



    List<Employe> findAll();

    Employe findByCin(String cin);

    List<Employe> findBySalaire(double salaire);

    int save(Employe employe);
    
    
}
