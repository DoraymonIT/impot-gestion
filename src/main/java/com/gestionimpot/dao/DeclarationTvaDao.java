package com.gestionimpot.dao;

import com.gestionimpot.bean.DeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationTvaDao extends JpaRepository<DeclarationTva , Long> {
    public DeclarationTva findByRef(String ref);
    public List<DeclarationTva> findBySociete(String societe) ;
    public List<DeclarationTva> findByTotalTva(Double totalTva);
    public List<DeclarationTva> findByAnnee(int annee);
    public List<DeclarationTva> findAll();
    public Object save(DeclarationTva declarationTva);
    public Long DeleteByRef(String ref);
}
