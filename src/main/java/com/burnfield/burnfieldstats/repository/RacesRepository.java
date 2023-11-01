package com.burnfield.burnfieldstats.repository;

import com.burnfield.burnfieldstats.entity.Constructor;
import com.burnfield.burnfieldstats.entity.Races;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface RacesRepository extends JpaRepository<Races, BigInteger> {

    Races getRacesByRoundAndRaceYear(int round, int year);

    List<Races> getRacesByRaceYear(int year);


}
