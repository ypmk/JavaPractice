package com.company;

import com.company.EuropianCompetition.EuropeanCompetitionTeam;
import com.company.OlimpicGames.OlimpicCompetitionTeam;

public class OlimpicGamesDoing {
    public static void main(String[] args) {
        CompetitionTeamFactory competitionTeamFactory = new OlimpicCompetitionTeam();
        IceSkater iceSkater = competitionTeamFactory.getIceSkater();
        Runner runner = competitionTeamFactory.getRunner();
        Swimmer swimmer = competitionTeamFactory.getSwimmer();

        System.out.println("Выступаем на Олимпийских играх:");
        iceSkater.skating();
        runner.run();
        swimmer.swim();
    }
}
