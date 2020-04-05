package com.gestionimpot.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FactureGain extends Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
        private String ref ;
        
        private String clientCne ;

    public String getSocieteRef() {
        return societeRef;
    }
    
    public void setSocieteRef(String societeRef) {
        this.societeRef = societeRef;
    }
        
    
	@ManyToOne
	private Client client;
        

        public String getRef() {
        return ref;
        }

        public void setRef(String ref) {
        this.ref = ref;
        }
        
	public String getClientCne() {
		return clientCne;
	}

	public void setClientCne(String clientCne) {
		this.clientCne = clientCne;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}