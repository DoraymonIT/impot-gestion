package com.gestionimpot.service.impl;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.dao.EmployeDao;
import com.gestionimpot.service.facade.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeServiceImpl implements EmployeService {

    @Autowired
    EmployeDao employeDao ;

    @Override
    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }
}
