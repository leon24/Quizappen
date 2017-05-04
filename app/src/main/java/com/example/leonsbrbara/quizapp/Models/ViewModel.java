package com.example.leonsbrbara.quizapp.Models;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;


import com.android.databinding.library.baseAdapters.BR;
import com.example.leonsbrbara.quizapp.ListViewActivity;
import com.example.leonsbrbara.quizapp.QuestionActivity;
import com.example.leonsbrbara.quizapp.ScoreScreenActivity;
import com.example.leonsbrbara.quizapp.menuActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class ViewModel extends BaseObservable{
    private Cursor QustionsandAnswers;
    private DbModel db;
    private Question q;
    private ArrayList<Question> questionList = new ObservableArrayList<>();
    private ArrayList<String> questions = new ArrayList<>();

    private ArrayList<String>[] alternativs = new ArrayList[]{new ArrayList<String>(),new ArrayList<String>(),new ArrayList<String>(),new ArrayList<String>()};
    private int[] combnation = new int[] {1,2,3,4,1,2,4,3,1,3,2,4,1,3,4,2,1,4,2,3,1,4,3,2,2,1,4,
            3,2,1,3,4,2,3,4,1,2,3,1,4,2,4,3,1,2,4,1,3,3,1,2,4,3,1,4,2,3,2,1,4,3,2,4,1,3,4
            ,1,2,3,4,2,1,4,1,3,2,4,1,2,3,4,2,3,1,4,2,1,3,4,3,2,1,4,3,1,2};



    private String question;
    private String answer;
    private String alternativ1;
    private String alternativ2;
    private String alternativ3;
    Random ran = new Random();


    @Bindable
    public String getAlternativ4() {
        return alternativ4;
    }

    public void setAlternativ4(String alternativ4) {
        this.alternativ4 = alternativ4;
        notifyPropertyChanged(BR.alternativ4);
    }

    private String alternativ4;
    private int counter = 0;

    private static ViewModel ourInstance = new ViewModel();

    public static ViewModel getInstance() {
        return ourInstance;
    }

    private ViewModel() {
    }

    @Bindable
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
        notifyPropertyChanged(BR.question);
    }
    @Bindable
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
        notifyPropertyChanged(BR.answer);
    }
    @Bindable
    public String getAlternativ1() {
        return alternativ1;
    }

    public void setAlternativ1(String alternativ1) {
        this.alternativ1 = alternativ1;
        notifyPropertyChanged(BR.alternativ1);
    }
    @Bindable
    public String getAlternativ2() {
        return alternativ2;
    }

    public void setAlternativ2(String alternativ2) {
        this.alternativ2 = alternativ2;
        notifyPropertyChanged(BR.alternativ2);
    }
    @Bindable
    public String getAlternativ3() {
        return alternativ3;
    }

    public void setAlternativ3(String alternativ3) {
        this.alternativ3 = alternativ3;
        notifyPropertyChanged(BR.alternativ3);
    }

    @Bindable
    public long getResultat() {
        return resultat;
    }

    private long resultat;




    public void startButtonPressed(View view){
        db = new DbModel(view.getContext());
        QustionsandAnswers = db.getQuestionandanswers();
        q = db.QuestiontoSting(QustionsandAnswers);
        Log.i("AndroidExample",""+ q.getQuestion());
        clearAllList();

        for(int i = 0; i < QustionsandAnswers.getCount(); i++){
            q = db.QuestiontoSting(QustionsandAnswers);
            questionList.add(new Question(q.getId(),q.getQuestion(),q.getAnswer(),q.getAlternativ1(),q.getAlternativ2(),q.getAlternativ3()));
            QustionsandAnswers.moveToNext();
        }
        Collections.shuffle(questionList);
        for (Question question : questionList) {
            questions.add(question.getQuestion());
            alternativs[3].add(question.getAnswer());
            alternativs[0].add(question.getAlternativ1());
            alternativs[1].add(question.getAlternativ2());
            alternativs[2].add(question.getAlternativ3());
        }


        Intent intent = new Intent(view.getContext(),QuestionActivity.class);
        view.getContext().startActivity(intent);

        setNewQuestion();
        Log.i("Androidexmple","Questio:"+question);



    }
    public void button1Pressed(View view){
        if (alternativ1.equals(answer)){
            resultat++;
        }
        counter++;
        if (counter == 10){
            startScorescreenActivity(view);
        }
        else {
            setNewQuestion();
        }



    }
    public void button2Pressed(View view){
        if (alternativ2.equals(answer)){
            resultat++;
        }
        counter++;
        if (counter == 10){
            startScorescreenActivity(view);
        }
        else {
            setNewQuestion();
        }


    }
    public void button3Pressed(View view){
        if (alternativ3.equals(answer)){
            resultat++;
        }
        counter++;
        if (counter == 10){
            startScorescreenActivity(view);
        }
        else {
            setNewQuestion();
        }


    }
    public void button4Pressed(View view){
        if (alternativ4.equals(answer)){
            resultat++;
        }
        counter++;
        if (counter == 10){
            startScorescreenActivity(view);
        }
        else {
            setNewQuestion();
        }

    }
    public void returnToMenu(View view){
        db = new DbModel(view.getContext());
        db.saveToDatabase(resultat);
        Intent intent = new Intent(view.getContext(),menuActivity.class);
        view.getContext().startActivity(intent);
    }
    public void startScorescreenActivity(View view){
        Intent intent = new Intent(view.getContext(),ScoreScreenActivity.class);
        view.getContext().startActivity(intent);

    }
    public void setNewQuestion(){
        setQuestion(questions.get(counter));
        setAnswer(alternativs[3].get(counter));
        int n = ran.nextInt(24);
        for (int i = 0; i<4; i++) {
            if (combnation[i+n*4]==1) {
                setAlternativ1(alternativs[i].get(counter));
            }
            else if (combnation[i+n*4]==2) {
                setAlternativ2(alternativs[i].get(counter));
            }
            else if (combnation[i+n*4]==3) {
                setAlternativ3(alternativs[i].get(counter));
            }
            else if (combnation[i+n*4]==4) {
                setAlternativ4(alternativs[i].get(counter));
            }
        }
    }
    public void clearAllList(){
        resultat = 0;
        questionList.clear();
        counter = 0;
        questions.clear();
        alternativs[0].clear();
        alternativs[1].clear();
        alternativs[2].clear();
        alternativs[3].clear();

    }
    public void ResultButton(View view){


        Intent intent = new Intent(view.getContext(),ListViewActivity.class);
        view.getContext().startActivity(intent);

    }

    public ViewModel(Context context){
    }

}


