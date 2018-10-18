package com.example.android.courtcounter;

import android.app.Activity;
import android.widget.TextView;

import java.io.Serializable;

//Singleton view allows the activity to get the same View object every time it refers
//to the  view through out implicit or explicit lifecycle events

public class DumbScoreViewSingleton implements Serializable {

    private static volatile DumbScoreViewSingleton sSoleInstance = new DumbScoreViewSingleton();


    private Activity currentActivity;
    //View contentView;

    private DumbScoreViewSingleton() {
        //Prevent form the reflection api.
        if (sSoleInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }


    public static DumbScoreViewSingleton getInstance() {
        //Double check locking pattern
        if (sSoleInstance == null) { //Check for the first time

            synchronized (CourtCountRulesSingleton.class) {   //Check for the second time.
                //if there is no instance available... create new one
                if (sSoleInstance == null) sSoleInstance = new DumbScoreViewSingleton();
            }
        }
        return sSoleInstance;

    }

    //Make singleton from serialize and deserialize operation.
    protected DumbScoreViewSingleton readResolve() {
        return getInstance();
    }


    public void setActivity(MainActivity UIController) {
        currentActivity = UIController;
        //  mviewModel = ViewModelProviders.of(UIController).get(CountScoreViewModel.class);

    }

    void setContentView(int rest) {
        currentActivity.setContentView(rest);


    }

    void displayForTeamA(int score) {
        TextView scoreView = currentActivity.findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the given score for Team B.
     */
    void displayForTeamB(int score) {
        TextView scoreView = currentActivity.findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }


}