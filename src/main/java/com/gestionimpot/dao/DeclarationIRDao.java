package com.gestionimpot.dao;

import com.gestionimpot.bean.DeclarationIR;
import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.bean.TauxDeIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationIRDao extends JpaRepository<DeclarationIR , Long> {
    public  DeclarationIR findByRef(String ref);

    public List<DeclarationIR> findBySalaire(Double salaire);
    public List<DeclarationIR> findByMontantDeclaration(Double montantDeclaration );
    public List<DeclarationIR> findAll();




}
