package com.bendyk.roasteriesmap.repository;

import org.springframework.stereotype.Repository;

import com.bendyk.roasteriesmap.model.Roastery;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoasteryRepository extends JpaRepository<Roastery, Integer> {
    Roastery findRoasteryById(int id);
    Roastery findRoasteryByName(String name);
}
