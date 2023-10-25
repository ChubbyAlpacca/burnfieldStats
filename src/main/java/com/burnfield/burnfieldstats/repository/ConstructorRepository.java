package com.burnfield.burnfieldstats.repository;

import com.burnfield.burnfieldstats.entity.Circuit;
import com.burnfield.burnfieldstats.entity.Constructor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
@Transactional
public interface ConstructorRepository extends JpaRepository<Constructor, BigInteger> {
}
