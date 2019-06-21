package com.example.mich.projectcalisthenics;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AfterTraining extends AppCompatActivity {

    SQLiteDatabase base;
    int ClickedTimes = 0;
    TextView Session;

    Button btnAdd, btnView;

    public SQLiteDatabase getBase() {
        return base;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_training);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnView = (Button)findViewById(R.id.btnViewHistory);

        Intent intent = getIntent();
        String whatIGet = intent.getExtras().getString("key");

        Session = (TextView) findViewById(R.id.textView);

        Session.setText(whatIGet);




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ClickedTimes == 0)
                {
                    addTraining();
                }else
                {
                    Toast.makeText(AfterTraining.this, "You have already added this training", Toast.LENGTH_LONG).show();
                }
                ClickedTimes++;
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AfterTraining.this, HistoryTraining.class);
                finish();
                startActivity(intent);
            }
        });
    }

    public void onClick3(View view)
    {
        Intent intent = new Intent(AfterTraining.this, ChooseLevel.class);
        finish();
        startActivity(intent);
    }



    public void addTraining() // Zainspirowane programami znalezionymi w internecie
    {
            base = openOrCreateDatabase("TrainingSessions", MODE_PRIVATE, null);

            String sqlExists = "CREATE TABLE IF NOT EXISTS TrainingSessions(Training VARCHAR)";
            base.execSQL(sqlExists);

            String sqlCount = "SELECT count(*) FROM TrainingSessions";
            Cursor cursor = base.rawQuery(sqlCount, null);
            cursor.moveToLast();
            cursor.close();


            String sqlSession = "INSERT INTO TrainingSessions VALUES(?)";
            SQLiteStatement statement = base.compileStatement(sqlSession);

            statement.bindString(1, Session.getText().toString());
            statement.executeInsert();
            Toast.makeText(this, "Your training session has been saved", Toast.LENGTH_LONG).show();

    }




}
