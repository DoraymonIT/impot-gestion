
package com.fst.Bibleotheque.ws.rest;

import com.fst.Bibleotheque.bean.Client;
import com.fst.Bibleotheque.service.facade.ServiceClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("bibleo/client")
@RestController
public class ClientRestController {
    @Autowired
    private ServiceClient serviceClient;

    public Client findByCin(String cne) {
        return serviceClient.findByCin(cne);
    }

    public List<Client> findBypointFiabliteLessThan(int x) {
        return serviceClient.findBypointFiabliteLessThan(x);
    }

    public List<Client> clientNonFiable() {
        return serviceClient.clientNonFiable();
    }

    public List<Client> findAll() {
        return serviceClient.findAll();
    }

   
}
