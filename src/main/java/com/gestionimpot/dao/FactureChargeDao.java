package com.gestionimpot.dao;

import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.bean.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureChargeDao extends JpaRepository<FactureCharge , Long> {

    public  FactureCharge findByRef(String ref );
}
