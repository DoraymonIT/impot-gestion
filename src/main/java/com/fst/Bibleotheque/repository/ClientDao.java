
package com.fst.Bibleotheque.repository;

import com.fst.Bibleotheque.bean.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long>{
    public Client findByCne(String cne);
    public List<Client> findBypointFiabliteLessthan(int x);
    
}
