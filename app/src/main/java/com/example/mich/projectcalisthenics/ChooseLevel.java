package com.example.mich.projectcalisthenics;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ChooseLevel extends MainActivity
{
    Button ButtonQuit;
    TextView textView, textView2, textView3;
    ImageView WorkOutButton1, WorkOutButton2, WorkOutButton3;
    int whatNumberWePush = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_level);

        ButtonQuit = (Button) findViewById(R.id.buttonQuit);
        WorkOutButton1 = (ImageView) findViewById(R.id.workOutButton1);
        WorkOutButton2 = (ImageView) findViewById(R.id.workOutButton2);
        WorkOutButton3 = (ImageView) findViewById(R.id.workOutButton3);WorkOutButton3.setVisibility(View.GONE);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);

        int whatNumberDidIGet = getIntent().getIntExtra("key",0);
        if(whatNumberDidIGet == 1) {whatNumberWePush = 1;}
        else if(whatNumberDidIGet == 2){whatNumberWePush = 2;}
        else if(whatNumberDidIGet == 3){whatNumberWePush = 3;}
        else if(whatNumberDidIGet == 4){whatNumberWePush = 4;}

    }

    @Override
    protected  void onStart()
    {
        super.onStart();
        if(whatNumberWePush == 1)
        {
            WorkOutButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 1;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
            WorkOutButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 2;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
        }else if(whatNumberWePush == 2)
        {
            WorkOutButton3.setVisibility(View.VISIBLE);
            textView.setText("I want to learn how to do pull ups");
            textView2.setText("I want to practise my pull up skills");
            textView3.setText("Hard training with pull ups");
            WorkOutButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 3;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
            WorkOutButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 4;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
            WorkOutButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 5;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
        }else if(whatNumberWePush == 3)
        {
            textView.setText("I want to learn how to do dips");
            textView2.setText("I want to practise my dips skills");
            WorkOutButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 6;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
            WorkOutButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 7;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
        }else if(whatNumberWePush == 4)
        {
            textView.setText("I want to learn how to do muscle ups");
            textView2.setText("I want to practise my muscle up skills");
            WorkOutButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 8;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
            WorkOutButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChooseLevel.this, CounterDown.class);
                    int x = 9;
                    intent.putExtra("key", x);
                    startActivity(intent);
                }
            });
        }

        ButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogQuit();
            }
        });
    }






    public void DialogQuit()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ChooseLevel.this);

        builder.setTitle("Please confirm");
        builder.setMessage("Don't you want to practise this exercise?");

        builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(ChooseLevel.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
