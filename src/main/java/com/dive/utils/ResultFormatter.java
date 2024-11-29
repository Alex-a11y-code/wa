package com.dive.utils;

import com.dive.lib.Player;
import com.dive.lib.Result;

import java.util.List;

public class ResultFormatter {

    public String formatPlayers(List<Player> players) {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            // 运动员信息的输出结果
            sb.append("Full Name: ").append(player.getPreferredLastName()).append(" ").append(player.getPreferredFirstName()).append("\n");
            sb.append("Gender: ").append(player.getGender()).append("\n");
            sb.append("Country: ").append(player.getCountryName()).append("\n");
            sb.append("-----\n");
        }
        return sb.toString();
    }

    public String formatEventResult(List<Result> results) {
        StringBuilder sb = new StringBuilder();
        for (Result result : results) {
            //比赛的输出结果
            sb.append("Full Name: ").append(result.getFullName()).append("\n");
            sb.append("Rank: ").append(result.getRank()).append("\n");
            sb.append("TotalScore: ").append(result.getTotalPoints()).append("\n");
            sb.append("-----\n");
        }
        return sb.toString();
    }

    public String formatDetailedResult(Result result) {
        return "Full Name: " + result.getFullName() + "\n" +
                "Rank: " + result.getRank() + "\n" +
                "TotalScore: " + result.getTotalPoints();
    }
}
