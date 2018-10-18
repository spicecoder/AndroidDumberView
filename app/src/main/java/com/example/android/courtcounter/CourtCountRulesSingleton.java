package com.example.android.courtcounter;

import java.io.Serializable;
//Singleton RuleSingleton allows the Viewmodel to bind to the same instance
//through out lifecycle events,implicit or explicit

public class CourtCountRulesSingleton implements Serializable {

    private static volatile CourtCountRulesSingleton sSoleInstance = new CourtCountRulesSingleton();
    private CountScoreViewModel score_viewModel;

    //private constructor.
    private CourtCountRulesSingleton() {
        //Prevent form the reflection api.
        if (sSoleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }


    public static CourtCountRulesSingleton getInstance() {
        //Double check locking pattern
        if (sSoleInstance == null) { //Check for the first time

            synchronized (CourtCountRulesSingleton.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (sSoleInstance == null) sSoleInstance = new CourtCountRulesSingleton();
            }
        }
        return sSoleInstance;

    }

    //Make singleton from serialize and deserialize operation.
    protected CourtCountRulesSingleton readResolve() {
        return getInstance();
    }

    void setViewModel(CountScoreViewModel score_viewModel) {
        this.score_viewModel = score_viewModel;

    }

    int addOneForTeamARule() {
        score_viewModel.scoreTeamA = score_viewModel.scoreTeamA + 1;
        return score_viewModel.scoreTeamA;
    }

    int addTwoForTeamA() {
        score_viewModel.scoreTeamA = score_viewModel.scoreTeamA + 2;
        return score_viewModel.scoreTeamA;
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    int addThreeForTeamA() {
        score_viewModel.scoreTeamA = score_viewModel.scoreTeamA + 3;
        return score_viewModel.scoreTeamA;
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    int addOneForTeamB() {
        score_viewModel.scoreTeamB = score_viewModel.scoreTeamB + 1;
        return score_viewModel.scoreTeamB;
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    int addTwoForTeamB() {
        score_viewModel.scoreTeamB = score_viewModel.scoreTeamB + 2;
        return score_viewModel.scoreTeamB;
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    int addThreeForTeamB() {
        score_viewModel.scoreTeamB = score_viewModel.scoreTeamB + 3;
        return score_viewModel.scoreTeamB;
    }


}