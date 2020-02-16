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
    public Employe findBynNumeroEmploye(Long numeroEmploye) {
        return employeDao.findBynNumeroEmploye(numeroEmploye);
    }

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
    public List<Employe> findBysocieteNom(Societe societe) {
        return employeDao.findBysocieteNom(societe);
    }

    @Override
    public int save(Employe employe) {
        // Apres je veux faire les conditions if selon besoin 
        return 1;
    }

}
