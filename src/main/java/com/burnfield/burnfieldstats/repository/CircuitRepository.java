package com.burnfield.burnfieldstats.repository;

import com.burnfield.burnfieldstats.entity.Circuit;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface CircuitRepository extends JpaRepository<Circuit, BigInteger> {

    List<Circuit> findCircuitsByCountry(String country);

}
