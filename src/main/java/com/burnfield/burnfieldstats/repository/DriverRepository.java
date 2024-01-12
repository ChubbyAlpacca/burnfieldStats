package com.burnfield.burnfieldstats.repository;

import com.burnfield.burnfieldstats.entity.Driver;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
@Transactional
public interface DriverRepository extends JpaRepository<Driver, BigInteger> {

    Optional<Driver> getDriverByDriverId(Long id);

    Optional<Driver> getDriverBySurname(String surname);

}
