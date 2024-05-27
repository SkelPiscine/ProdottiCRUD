package com.settannim.esercizio2.client;

import com.settannim.esercizio2.client.model.UtenteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "http://localhost:8081" , name = "utente-client")
public interface UtenteClient {
    @GetMapping("/api/prodotti/{id}")
    public ResponseEntity<UtenteDTO> findById(@PathVariable int id);
}
