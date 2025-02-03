package org.generation.jaita138.demo10.demo10.db.repo;

import org.generation.jaita138.demo10.demo10.db.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkRepo extends JpaRepository<Park,Long> {

}
