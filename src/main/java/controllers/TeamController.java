package controllers;

import com.shammy.ipldashboard.model.Team;
import com.shammy.ipldashboard.repository.MatchRepository;
import com.shammy.ipldashboard.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;
    
    @Autowired
    private MatchRepository matchRepository;

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){

        Team team = teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findByLatestMatchesByTeam(teamName, 4));

        return team;
    }
    
}
