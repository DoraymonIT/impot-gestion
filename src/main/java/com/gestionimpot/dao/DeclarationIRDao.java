package com.gestionimpot.dao;

import com.gestionimpot.bean.DeclarationIR;
import com.gestionimpot.bean.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationIRDao extends JpaRepository<DeclarationIR , Long> {
public List<DeclarationIR> findByEmploye(Employe employe);
public  Long removeByRef(String ref);

}
