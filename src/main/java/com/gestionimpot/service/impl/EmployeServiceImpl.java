package com.gestionimpot.service.impl;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.EmployeDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.EmployeService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeDao employeDao;

    @Autowired
    private SocieteDao societeDao;

    @Override
    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    @Override
    public List<Employe> findByNom(String nom) {
        return employeDao.findByNom(nom);
    }

    @Override
    public List<Employe> findByPrenom(String prenom) {
        return employeDao.findByPrenom(prenom);
    }

    @Override
    public List<Employe> findByAdresseHabit(String adresseHabit) {
        return employeDao.findByAdresseHabit(adresseHabit);
    }

    @Override
    public List<Employe> findByAdresseMail(String adresseMail) {
        return employeDao.findByAdresseMail(adresseMail);
    }

    @Override
    public List<Employe> findBySexe(String sexe) {
        return employeDao.findBySexe(sexe);
    }

    @Override
    public List<Employe> findByPrime(double prime) {
        return employeDao.findByPrime(prime);
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
    public List<Employe> findBySociete(String societe) {
        return employeDao.findAll().stream().filter(s -> societe.equals(s.getSociete().getRef())).collect(Collectors.toList());
    }

    @Override
    public int save(Employe employe) {
        Employe foundedEmploye = employeDao.findByCin(employe.getCin());
        Societe foundedSociete = societeDao.findByRef(employe.getSocieteRef());

        if (foundedEmploye != null) {
            return -1;
        }
        if (foundedSociete == null) {
            return -2;
        } else {
            employe.setSociete(foundedSociete);
            employeDao.save(employe);
            return 1;
        }
    }

    @Override
    public int deleteByCin(String cin) {
        Employe foundedEmploye = employeDao.findByCin(cin);
        if (foundedEmploye == null) {
            return -1;
        } else {
            employeDao.delete(foundedEmploye);
            return 1;
        }
    }

    @Override
    public int updateSalaire(String cne, double nouveauSalaire) {
        Employe EmplyeFounded = findByCin(cne);
        if (EmplyeFounded == null) {
            return -1;
        } else {
            EmplyeFounded.setSalaire(nouveauSalaire);
            employeDao.save(EmplyeFounded);
            return 1;
        }
    }
}
