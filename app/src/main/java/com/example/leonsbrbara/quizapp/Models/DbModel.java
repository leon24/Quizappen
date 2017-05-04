package com.example.leonsbrbara.quizapp.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;



public class DbModel extends SQLiteAssetHelper{

    private static final String DATABASE_NAME = "quizappen.db";
    private static final int DATABASE_VERSION = 1;

    public DbModel(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    public Cursor getQuestionandanswers(){

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"_id","question","answer","alternativ1","alternativ2,alternativ3"};
        String tables = "QustionAnswer";

        qb.setTables(tables);
         Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);

        c.moveToFirst();

        return c;
    }

    public Question QuestiontoSting(Cursor c){

        int idIndex = c.getColumnIndexOrThrow("_id");
        int questIndex = c.getColumnIndexOrThrow("question");
        int answerIndex = c.getColumnIndex("answer");
        int alternativ1Index = c.getColumnIndex("alternativ1");
        int alternativ2Index = c.getColumnIndex("alternativ2");
        int alternativ3Index = c.getColumnIndex("alternativ3");
        Long id = c.getLong(idIndex);
        String question = c.getString(questIndex);
        String answer = c.getString(answerIndex);
        String alternativ1 = c.getString(alternativ1Index);
        String alternativ2 = c.getString(alternativ2Index);
        String alternativ3 = c.getString(alternativ3Index);
        return new Question(id,question,answer,alternativ1,alternativ2,alternativ3);
    }
    public void saveToDatabase (long resultat){

        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        String column = "AllaResultat";
        String table = "Resultat";
        values.put(column,resultat);

        db.insert(table,null,values);

    }
    public long getResultastFromDb(){


        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"_id","question","answer","alternativ1","alternativ2,alternativ3"};
        String tables = "QustionAnswer";

        qb.setTables(tables);
        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);

        c.moveToFirst();

        int ResulatIndex = c.getColumnIndexOrThrow("AllaResultat");
        long Resultatet = c.getLong(ResulatIndex);

        return Resultatet;

    }

}
