package com.example.leonsbrbara.quizapp;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.leonsbrbara.quizapp.Models.ViewModel;
import com.example.leonsbrbara.quizapp.databinding.ActivityListViewBinding;
import com.example.leonsbrbara.quizapp.databinding.ActivityMenuBinding;

public class ListViewActivity extends AppCompatActivity {

    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = viewModel.getInstance();
        ActivityListViewBinding binder = DataBindingUtil.setContentView(this,R.layout.activity_list_view);
        binder.setViewmodel(viewModel);

    }
}
