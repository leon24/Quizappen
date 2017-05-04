package com.example.leonsbrbara.quizapp;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.leonsbrbara.quizapp.Models.DbModel;
import com.example.leonsbrbara.quizapp.Models.Question;
import com.example.leonsbrbara.quizapp.Models.ViewModel;
import com.example.leonsbrbara.quizapp.databinding.ActivityMenuBinding;

import java.util.ArrayList;

public class menuActivity extends AppCompatActivity {

    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = viewModel.getInstance();
        ActivityMenuBinding binder = DataBindingUtil.setContentView(this,R.layout.activity_menu);
        binder.setViewmodel(viewModel);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
