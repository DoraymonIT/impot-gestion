
package com.fst.Bibleotheque.repository;

import com.fst.Bibleotheque.bean.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientDao extends JpaRepository<Client, Long>{
    public Client findByCin(String cne);
    public List<Client> findBypointFiabliteLessThan(int x);
    
}
