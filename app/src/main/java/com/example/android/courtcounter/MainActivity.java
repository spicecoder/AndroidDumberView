/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {


    CountScoreViewModel mViewModel;
    DumbScoreViewSingleton dummbScoreView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dummbScoreView = DumbScoreViewSingleton.getInstance();
        dummbScoreView.setActivity(this);
        dummbScoreView.setContentView(R.layout.counter_layout);

        mViewModel = ViewModelProviders.of(this).get(CountScoreViewModel.class);
        CourtCountRulesSingleton court = CourtCountRulesSingleton.getInstance();
        court.setViewModel(mViewModel);
        dummbScoreView.displayForTeamA(mViewModel.scoreTeamA);
        dummbScoreView.displayForTeamB(mViewModel.scoreTeamB);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
         dummbScoreView = null ;
    }

    public void clickFreeForTeamA(View v) {

        dummbScoreView.displayForTeamA(mViewModel.addOneForTeamA());
    }


    public void clickTwoForTeamA(View v) {

        dummbScoreView.displayForTeamA(mViewModel.addTwoForTeamA());

    }

    public void clickThreeForTeamA(View v) {
        dummbScoreView.displayForTeamA(mViewModel.addThreeForTeamA());
    }

    public void clickFreeForTeamB(View v) {
        dummbScoreView.displayForTeamB(mViewModel.addOneForTeamB());
    }

    public void clickTwoForTeamB(View v) {
        dummbScoreView.displayForTeamB(mViewModel.addTwoForTeamB());
    }

    public void clickThreeForTeamB(View v) {
        dummbScoreView.displayForTeamB(mViewModel.addThreeForTeamB());
    }

    public void resetScoreClicked(View v) {
        mViewModel.setScoreTeamA(0);
        mViewModel.setScoreTeamB(0);
        dummbScoreView.displayForTeamA(0);
        dummbScoreView.displayForTeamB(0);
    }


}
