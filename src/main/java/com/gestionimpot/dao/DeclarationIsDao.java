
package com.gestionimpot.dao;

import com.gestionimpot.bean.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeclarationIsDao extends JpaRepository<DeclarationIS, Long> {
    public DeclarationIS findByReference(String reference);
    public List<DeclarationIS> findAll();

}
