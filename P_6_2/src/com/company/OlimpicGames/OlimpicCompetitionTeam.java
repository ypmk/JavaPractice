package com.company.OlimpicGames;

import com.company.CompetitionTeamFactory;
import com.company.Runner;
import com.company.Swimmer;

public class OlimpicCompetitionTeam implements CompetitionTeamFactory {
    @Override
    public Swimmer getSwimmer(){
        return new LongSwimmer();
    }

    @Override
    public Runner getRunner(){
        return new LongRunner();
    }

    @Override
    public ManIceSkater getIceSkater(){
        return new ManIceSkater();
    }

}
