/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.service.facade;

import com.fst.Bibleotheque.bean.Client;
import java.util.List;

/**
 *
 * @author dell
 */
public interface ServiceClient {
    public Client findByCne(String cne);
    public List<Client> findBypointFiabliteLessthan(int x);
    public List<Client> trouver5PointFiablites();
}
