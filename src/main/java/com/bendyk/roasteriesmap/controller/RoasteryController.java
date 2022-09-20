package com.bendyk.roasteriesmap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bendyk.roasteriesmap.model.Roastery;
import com.bendyk.roasteriesmap.service.RoasteryService;

@RestController
public class RoasteryController {
    
    private RoasteryService roasteryService;

    @Autowired
    public RoasteryController(RoasteryService roasteryService) {
        this.roasteryService = roasteryService;
    }

    @GetMapping("/roasteries")
    public List<Roastery> findAllRoasteries() {
        return roasteryService.findAllRoasteries();
    }

    @PostMapping("/roasteries")
    public void addRoastery(@RequestBody @Valid Roastery roastery) {
        roasteryService.addRoastery(roastery);
    }
}
