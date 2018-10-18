package com.example.android.courtcounter;

import android.arch.lifecycle.ViewModel;

public class CountScoreViewModel extends ViewModel {

    private CourtCountRulesSingleton countRule = CourtCountRulesSingleton.getInstance();
   // Tracks the score for Team A
    int scoreTeamA = 0;

   // Tracks the score for Team B
     int scoreTeamB = 0;

    private int getScoreTeamA() {
        return scoreTeamA;
    }

    void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    protected int getScoreTeamB() {
        return scoreTeamB;
    }

    void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }

    int  addOneForTeamA() {
      return  countRule.addOneForTeamARule();

   }
   int  addTwoForTeamA() {
     return  countRule.addTwoForTeamA();

   }

   int  addThreeForTeamA() {
      return  countRule.addThreeForTeamA();

   }


   int  addOneForTeamB() {
      return  countRule.addOneForTeamB();

   }
   int  addTwoForTeamB() {
      return  countRule.addTwoForTeamB();

   }

   int  addThreeForTeamB() {
      return  countRule.addThreeForTeamB();

   }



}