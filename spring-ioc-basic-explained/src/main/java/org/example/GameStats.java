package org.example;

public class GameStats {

    private long playerId;

    private long gameCount;

    private long totalScore;

    private long totalRewardPoints;

    private long kills;

    private long noOfChickenDinners;

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getGameCount() {
        return gameCount;
    }

    public void setGameCount(long gameCount) {
        this.gameCount = gameCount;
    }

    public long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(long totalScore) {
        this.totalScore = totalScore;
    }

    public long getTotalRewardPoints() {
        return totalRewardPoints;
    }

    public void setTotalRewardPoints(long totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }

    public long getKills() {
        return kills;
    }

    public void setKills(long kills) {
        this.kills = kills;
    }

    public long getNoOfChickenDinners() {
        return noOfChickenDinners;
    }

    public void setNoOfChickenDinners(long noOfChickenDinners) {
        this.noOfChickenDinners = noOfChickenDinners;
    }
}
