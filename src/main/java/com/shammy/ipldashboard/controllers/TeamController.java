package com.shammy.ipldashboard.controllers;

import com.shammy.ipldashboard.model.Team;
import com.shammy.ipldashboard.repository.TeamRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeamController {

    
    private TeamRepository teamRepository;
    

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){

        return teamRepository.findByTeamName(teamName);
    }
    
}
