package com.gestionimpot.service.impl;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.EmployeDao;
import com.gestionimpot.service.facade.EmployeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeDao employeDao;

   

    @Override
    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    @Override
    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }

    @Override
    public List<Employe> findBySalaire(double salaire) {
        return employeDao.findBySalaire(salaire);
    }

 

    @Override
    public int save(Employe employe) {
        // Apres je veux faire les conditions if selon besoin 
        Employe empFounded = findByCin(employe.getCin());
        if (empFounded != null) {
            return -1;}
//        } else {
//            for (int i = 0; i < findAll().size(); i++) {
//                Employe em = findAll().get(i);
//                if (employe.getCin().equalsIgnoreCase(em.getCin())) ;
//            }
//            return -2;
//        }
        else if(employe.getSalaire() == 0) {
            return -2;
        } else {
            return 1;
        }
    }

}
