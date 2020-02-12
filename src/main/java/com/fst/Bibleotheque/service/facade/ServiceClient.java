/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.service.facade;

import com.fst.Bibleotheque.bean.Client;
import java.util.List;

public interface ServiceClient {
    public Client findByCin(String cne);
    public List<Client> findBypointFiabliteLessThan(int x);
    public List<Client> trouver5PointFiablites();
        public int save(Client client);
}
