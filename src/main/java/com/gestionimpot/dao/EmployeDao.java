package com.gestionimpot.dao;

import com.gestionimpot.bean.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {
    public  Employe findByCin ( String cin );

}
