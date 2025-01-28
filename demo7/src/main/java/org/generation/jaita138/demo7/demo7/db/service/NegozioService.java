package org.generation.jaita138.demo7.demo7.db.service;

import java.util.List;

import org.generation.jaita138.demo7.demo7.db.entity.Negozio;
import org.generation.jaita138.demo7.demo7.db.repo.NegozioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegozioService {

    @Autowired
    private NegozioRepo negozioRepo;

    public void save(Negozio negozio) {

        negozioRepo.save(negozio);
    }

    public void delete(Negozio negozio) {

        negozioRepo.delete(negozio);
    }

    public List<Negozio> findAll() {

        return negozioRepo.findAll();
    }

    public Negozio findById(Long id) {

        return negozioRepo.findById(id).orElse(null);
    }

    public List<Negozio> TrovaPerLettera(String carattere){
        return negozioRepo.findByNomeStartingWith(carattere);

    }

    public List<Negozio> CreditoMaggioreA(int credito){
        return negozioRepo.findByCreditoGreaterThan(credito);

    }

    public List <Negozio> NomeNullCognomeNull(){
        return negozioRepo.findByNomeIsNullOrCognomeIsNull();
    }

    public List<Negozio> Utenti0e10(int min,int max){
        return negozioRepo.findByCreditoGreaterThanAndCreditoLessThan(min,max);
    }
}
