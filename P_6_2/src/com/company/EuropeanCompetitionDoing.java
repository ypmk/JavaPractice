package com.company;

import com.company.EuropianCompetition.EuropeanCompetitionTeam;

public class EuropeanCompetitionDoing {
    public static void main(String[] args) {
        CompetitionTeamFactory competitionTeamFactory = new EuropeanCompetitionTeam();
        IceSkater iceSkater = competitionTeamFactory.getIceSkater();
        Runner runner = competitionTeamFactory.getRunner();
        Swimmer swimmer = competitionTeamFactory.getSwimmer();

        System.out.println("Выступаем на чемпионате Европы:");
        iceSkater.skating();
        runner.run();
        swimmer.swim();
    }
}
