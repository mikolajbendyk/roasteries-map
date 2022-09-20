package com.bendyk.roasteriesmap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bendyk.roasteriesmap.model.Roastery;
import com.bendyk.roasteriesmap.repository.RoasteryRepository;

@Service
public class RoasteryService {

    private RoasteryRepository roasteryRepository;

    @Autowired
    public RoasteryService(RoasteryRepository roasteryRepository) {
        this.roasteryRepository = roasteryRepository;
    }
    
    public List<Roastery> findAllRoasteries() {
        return roasteryRepository.findAll();
    }

    public Roastery findRoasteryById(int id) {
        return roasteryRepository.findRoasteryById(id);
    }

    public Roastery findRoasteryByName(String name) {
        return roasteryRepository.findRoasteryByName(name);
    }

    public void addRoastery(Roastery roastery) {
        roasteryRepository.save(roastery);
    }
}
