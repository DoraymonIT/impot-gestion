
package com.fst.Bibleotheque.ws.rest;

import com.fst.Bibleotheque.bean.Livre;
import com.fst.Bibleotheque.service.facade.ServiceLivre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("bibleo/livre")
public class LivreRestController {
    @Autowired
    private ServiceLivre serviceLivre ;

    @GetMapping("/isbn/{isbn}")
    public List<Livre> findByIsbN(String isbn) {
        return serviceLivre.findByIsbN(isbn);
    }
    
    
}
