package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PubgGameServiceV2 {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

    public void updateGameStats(long gameScore, long gameRewardPoints, long kills, boolean isWin) {
        GameStats stats = (GameStats) applicationContext.getBean("theGameStats");
        stats.setKills(kills);
        stats.setGameCount(stats.getGameCount() + 1);
        stats.setTotalRewardPoints(stats.getTotalRewardPoints() + gameRewardPoints);
        stats.setTotalScore(stats.getTotalScore() + gameScore);
        if(isWin) {
            stats.setNoOfChickenDinners(stats.getNoOfChickenDinners() + 1);
        }
        System.out.println("Game statics updated successfully!!");
    }
}
