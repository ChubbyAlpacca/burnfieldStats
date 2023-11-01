package com.burnfield.burnfieldstats.repository;

import com.burnfield.burnfieldstats.entity.Circuit;
import com.burnfield.burnfieldstats.entity.Constructor;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ConstructorRepository extends JpaRepository<Constructor, BigInteger> {

    Optional<Constructor> findConstructorByName(String name);

}
