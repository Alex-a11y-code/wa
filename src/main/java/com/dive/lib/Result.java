package com.dive.lib;

public class Result {
    private String fullName;
    private int rank;
    private String totalpoints;


    public String getFullName() {

        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTotalPoints() {
        return totalpoints;
    }
    public void setTotalPoints(String totalpoints) {
        this.totalpoints = totalpoints;
    }
    @Override
    public String toString() {
        return "Result{" +
                "fullName='" + fullName + '\'' +
                ", rank=" + rank +
                ", totalPoints='" + totalpoints + '\'' +
                '}';
    }



}
