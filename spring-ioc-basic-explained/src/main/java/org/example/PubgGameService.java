package org.example;

public class PubgGameService {

    // Here we see the PubgGameService is dependent on GameStats to update the statistics
    // Here we are manging the object creation without using the inversion of control
    // In the PubgGameService we will be using Spring IOC for
    private  GameStats stats = new GameStats();


    public void updateGameStats(long gameScore, long gameRewardPoints, long kills, boolean isWin) {
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
