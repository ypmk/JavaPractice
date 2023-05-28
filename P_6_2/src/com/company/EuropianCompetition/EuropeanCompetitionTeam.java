package com.company.EuropianCompetition;


import com.company.OlimpicGames.LongRunner;
import com.company.OlimpicGames.LongSwimmer;
import com.company.OlimpicGames.ManIceSkater;
import com.company.Runner;
import com.company.Swimmer;
import com.company.CompetitionTeamFactory;

public class EuropeanCompetitionTeam implements CompetitionTeamFactory {
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
