package com.example.mich.projectcalisthenics;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryTraining extends AppCompatActivity {


    SQLiteDatabase database;
    Button buttonQuit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_history);

        buttonQuit = (Button)findViewById(R.id.buttonQuit);
        AfterTraining afterTraining = new AfterTraining();
        database = afterTraining.getBase();

        database = openOrCreateDatabase("TrainingSessions", MODE_PRIVATE,null);
        String sqlExists = "CREATE TABLE IF NOT EXISTS TrainingSessions(Training VARCHAR)";
        database.execSQL(sqlExists);

    }

    public void onClick3(View view)
    {
        Intent intent = new Intent(HistoryTraining.this, MainActivity.class);
        finish();
        startActivity(intent);
    }


    public void onClick2(View view)
    {
        DialogDelete();
    }

    public void DialogDelete()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(HistoryTraining.this);

        builder.setTitle("Please confirm");
        builder.setMessage("Are you sure that you want delete all your training sessions?");

        builder.setPositiveButton("    NO    ", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("    YES    ", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                deleteAll();
                showAll();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void deleteAll()
    {

        String sqlDoesNotExist = "DELETE FROM TrainingSessions WHERE Training IS NOT NULL";
        database.execSQL(sqlDoesNotExist);
    }

    public void onClick(View view) {

        showAll();
    }

    public void showAll()
    {
        ArrayList<String> wyniki = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Training FROM TrainingSessions", null);

        if (cursor.moveToFirst()) {
            do {

                String Training = cursor.getString(cursor.getColumnIndex("Training"));
                int i = 1;
                wyniki.add(Training + "\n");
                i++;

            } while (cursor.moveToNext());
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(HistoryTraining.this, android.R.layout.simple_list_item_1, wyniki);
        listView.setAdapter(adapter);
        cursor.close();
    }
}
