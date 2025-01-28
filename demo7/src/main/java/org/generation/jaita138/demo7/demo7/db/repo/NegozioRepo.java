package org.generation.jaita138.demo7.demo7.db.repo;


import java.util.List;

import org.generation.jaita138.demo7.demo7.db.entity.Negozio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NegozioRepo extends JpaRepository<Negozio,Long> {

    List<Negozio> findByNomeStartingWith(String carattere);
    List<Negozio> findByCreditoGreaterThan(int credito);
    List<Negozio> findByNomeIsNullOrCognomeIsNull();
    List<Negozio> findByCreditoGreaterThanAndCreditoLessThan(int min, int max);


}
