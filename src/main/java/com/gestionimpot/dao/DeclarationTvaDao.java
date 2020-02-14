package com.gestionimpot.dao;

import com.gestionimpot.bean.DeclarationTva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclarationTvaDao extends JpaRepository<DeclarationTva , Long> {
public  List<DeclarationTva> findBySociete( String societe) ;

}
