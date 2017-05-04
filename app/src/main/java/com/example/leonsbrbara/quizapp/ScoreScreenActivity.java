package com.example.leonsbrbara.quizapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leonsbrbara.quizapp.Models.ViewModel;
import com.example.leonsbrbara.quizapp.databinding.ActivityQuestionBinding;
import com.example.leonsbrbara.quizapp.databinding.ActivityScoreScreenBinding;

public class ScoreScreenActivity extends AppCompatActivity {
    private ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = viewModel.getInstance();
        ActivityScoreScreenBinding binder = DataBindingUtil.setContentView(this,R.layout.activity_score_screen);
        binder.setViewmodel(viewModel);
    }
}
