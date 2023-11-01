package com.burnfield.burnfieldstats.repository;

import com.burnfield.burnfieldstats.entity.RaceResults;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
@Repository
@Transactional
public interface RaceResultsRepository extends JpaRepository<RaceResults, BigInteger> {

    RaceResults findRaceResultsByRaceId(String raceId);

}
