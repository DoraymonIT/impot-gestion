
package com.gestionimpot.dao;

import com.gestionimpot.bean.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeclarationISDao extends JpaRepository<DeclarationIS, Long> {
    public DeclarationIS findByReference(String reference);
    public List<DeclarationIS> findAll();
    public List<DeclarationIS> findBySocieteRef(String societeRef);
    public List<DeclarationIS> findByDeclarationTvaRef(String declarationTvaRef );
    public List<DeclarationIS> findByTauxDeISRef(String tauxDeISRef );



}
