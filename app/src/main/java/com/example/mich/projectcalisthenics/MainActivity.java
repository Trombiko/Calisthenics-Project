package com.example.mich.projectcalisthenics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity{

    ImageView CaliLife;
    ImageView InfoButton1, InfoButton2, InfoButton3, InfoButton4;
    ImageView WorkoutButton1, WorkoutButton2, WorkoutButton3, WorkoutButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CaliLife = (ImageView) findViewById(R.id.imageViewLifeStyle);
        InfoButton1 = (ImageView) findViewById(R.id.imageViewInfoButton1);
        InfoButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoClass.class);
                int x = 1;
                intent.putExtra("key", x);
                startActivity(intent);
            }
        });

        WorkoutButton1 = (ImageView) findViewById(R.id.imageViewWorkOutButton1);
        WorkoutButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseLevel.class);
                int x = 1;
                intent.putExtra("key", x);
                startActivity(intent);
            }
        });

        InfoButton2 = (ImageView) findViewById(R.id.imageViewInfoButton2);
        InfoButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoClass.class);
                int x = 2;
                intent.putExtra("key", x);
                startActivity(intent);
            }
        });

        WorkoutButton2 = (ImageView) findViewById(R.id.imageViewWorkOutButton2);
        WorkoutButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseLevel.class);
                int x = 2;
                intent.putExtra("key", x);
                startActivity(intent);
            }
        });


        InfoButton3 = (ImageView) findViewById(R.id.imageViewInfoButton3);
        InfoButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoClass.class);
                int x = 3;
                intent.putExtra("key", x);
                startActivity(intent);
            }
        });
        WorkoutButton3 = (ImageView) findViewById(R.id.imageViewWorkOutButton3);
        WorkoutButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseLevel.class);
                int x = 3;
                intent.putExtra("key", x);
                startActivity(intent);
            }
        });

        InfoButton4 = (ImageView) findViewById(R.id.imageViewInfoButton4);
        InfoButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoClass.class);
                int x = 4;
                intent.putExtra("key", x);
                startActivity(intent);
            }
        });


        WorkoutButton4 = (ImageView) findViewById(R.id.imageViewWorkOutButton4);
        WorkoutButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChooseLevel.class);
                int x = 4;
                intent.putExtra("key", x);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // Docelowo miało być Popup Menu, lecz nie udało się osiągnąć zamierzonego celu

        switch (item.getItemId()) {
            case R.id.item1:
                Intent intent = new Intent(MainActivity.this, HistoryTraining.class);
                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
