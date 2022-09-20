package com.bluni.bluni.models.repository;
import com.bluni.bluni.models.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Computer WHERE board LIKE %?1" +
            " OR color LIKE %?1" +
            " OR disco_duro LIKE  %?1" +
            " OR grafica LIKE  %?1" +
            " OR mac LIKE %?1" +
            " OR marca LIKE %?1" +
            " OR modelo LIKE %?1" +
            " OR ram LIKE %?1" +
            " OR tipo LIKE %?1" +
            " OR procesador LIKE %?1")
    List<Computer> findAll(String palabraClave);
}
