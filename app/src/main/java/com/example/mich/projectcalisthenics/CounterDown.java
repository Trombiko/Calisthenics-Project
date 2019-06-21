package com.example.mich.projectcalisthenics;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CounterDown extends MainActivity{

    Button StartTraining, FinishWork, ButtonQuit, FinishALL;
    TextView TimeTextView, GetReady, TextPushUp;
    ImageView PushUp1;
    Vibrator vibrator;

    private CountDownTimer countDownTimer;
    private long timeLeftInMilliseconds = 6000;
    private boolean timerRunning;
    int ClickFinishWork = 0;
    int HowManyCounters = 0;
    int whatNumberWePush = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count_down);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        ButtonQuit = (Button) findViewById(R.id.buttonQuit);
        PushUp1 = (ImageView) findViewById(R.id.pushUp1); PushUp1.setVisibility(View.GONE);
        StartTraining = (Button) findViewById(R.id.buttonStart);
        FinishWork = (Button) findViewById(R.id.finishWork); FinishWork.setVisibility(View.GONE);
        TimeTextView = (TextView) findViewById(R.id.textView);
        TextPushUp = (TextView) findViewById(R.id.textPushUp1);TextPushUp.setVisibility(View.GONE);
        GetReady = (TextView) findViewById(R.id.getReadyText); GetReady.setVisibility(View.GONE);
        FinishALL = (Button) findViewById(R.id.finishALL);FinishALL.setVisibility(View.GONE);


        int whatNumberDidIGet = getIntent().getIntExtra("key",0);
        if(whatNumberDidIGet == 1) {whatNumberWePush = 1;}else if(whatNumberDidIGet == 2){whatNumberWePush = 2;}
        else if(whatNumberDidIGet == 3){whatNumberWePush = 3;}else if(whatNumberDidIGet == 4){whatNumberWePush = 4;}
        else if(whatNumberDidIGet == 5){whatNumberWePush = 5;}else if(whatNumberDidIGet == 6){whatNumberWePush = 6;}
        else if(whatNumberDidIGet == 7){whatNumberWePush = 7;}else if(whatNumberDidIGet == 8){whatNumberWePush = 8;}
        else if(whatNumberDidIGet == 9){whatNumberWePush = 9;}


        StartTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
                GetReady.setVisibility(View.VISIBLE);
                StartTraining.setVisibility(View.GONE);
                TimeTextView.setVisibility(View.VISIBLE);
            }
        });

        FinishWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClickFinishWork++;
                timeLeftInMilliseconds = 1000; // TU DOCELOWO MA BYĆ 11000 !!!
                if(ClickFinishWork %2 == 1){Toast.makeText(CounterDown.this, "Click once more if you sure", Toast.LENGTH_SHORT).show();}
                startStop();

                if(ClickFinishWork %2 == 0)
                {
                    FinishWork.setVisibility(View.GONE);
                    TextPushUp.setVisibility(View.GONE);
                    TimeTextView.setVisibility(View.VISIBLE);
                    GetReady.setVisibility(View.VISIBLE);
                    GetReady.setText("Take some rest!");
                }else{
                    FinishWork.setVisibility(View.VISIBLE);
                    GetReady.setVisibility(View.GONE);
                }

            }
        });

        FinishALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CounterDown.this, AfterTraining.class);
                if(whatNumberWePush == 1) {
                    String sendAfter = "\n Incline push ups  x5 \n L-sit raises  x4 \n Push ups on the knees  x6 \n Dips  x4 \n Knee raises  x5";
                    intent.putExtra("key", sendAfter);
                }else if(whatNumberWePush == 2)
                {
                    String sendAfter = "\n Dips  x7 \n L-sit raises  x5  \n Knee raises  x7 \n Incline push ups  x10 \n Push ups on the knees  x8";
                    intent.putExtra("key", sendAfter);
                }else if(whatNumberWePush == 3)
                {
                    String sendAfter = "\n L-sit raises  x6 \n Push ups  x5  \n Australian push ups  x5 \n Dips  x10 \n Incline push ups  x8";
                    intent.putExtra("key", sendAfter);
                }else if(whatNumberWePush == 4)
                {
                    String sendAfter = "\n Pull ups  x5 \n Push ups  x8  \n Dips  x6 \n Sweden push ups  x5 \n Bar dips  x5";
                    intent.putExtra("key", sendAfter);
                }else if(whatNumberWePush == 5)
                {
                    String sendAfter = "\n Pull ups  x20 \n Dips  x20  \n Push ups  x30 \n L-sit raises  x10 \n Push ups in L-sit position  x4";
                    intent.putExtra("key", sendAfter);
                }else if(whatNumberWePush == 6)
                {
                    String sendAfter = "\n Knee raises  x5 \n Dips  \n Push ups  x10 \n Australian push ups  x5 \n Sweden push ups  x5";
                    intent.putExtra("key", sendAfter);
                }else if(whatNumberWePush == 7)
                {
                    String sendAfter = "\n Dips  x5 \n Push ups  x10  \n Pull ups  x5 \n Bar dips  x5 \n L-sit raises  x5";
                    intent.putExtra("key", sendAfter);
                }else if(whatNumberWePush == 8)
                {
                    String sendAfter = "\n Pull ups  x15 \n Dips  x15  \n Bar dips  x10 \n Diamonds push ups  x10 \n L-sit pull ups  x7";
                    intent.putExtra("key", sendAfter);
                }else if(whatNumberWePush == 9)
                {
                    String sendAfter = "\n Muscle ups  >x3 \n Pull ups  x10  \n Dips  x15 \n Push ups  x10";
                    intent.putExtra("key", sendAfter);
                }
                finish();
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() // on start Activity
    {
        super.onStart();

        ButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogQuit();
            }
        });
    }





    public void DialogQuit()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(CounterDown.this);

        builder.setTitle("Please confirm");
        builder.setMessage("Are you sure that you want quit your session?");

        builder.setPositiveButton("NO", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(CounterDown.this, ChooseLevel.class);
                finish();
                startActivity(intent);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }






    public void startStop()
    {
        if(timerRunning)
        {
            stopTimer();
        }else
        {
            startTimer();
        }
    }

    public void startTimer() // Timer zainspirowany przykładami z internetu
    {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                PushUp1.setVisibility(View.GONE);
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish()
            {
                HowManyCounters++;
                TimeTextView.setVisibility(View.GONE);
                GetReady.setVisibility(View.GONE);
                FinishWork.setVisibility(View.VISIBLE);
                TextPushUp.setVisibility(View.VISIBLE);
                PushUp1.setVisibility(View.VISIBLE);
                vibrator.vibrate(200);



                if(whatNumberWePush ==1)
                {
                    if (HowManyCounters == 1) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinapodwyzszeniu));
                        TextPushUp.setText("Incline push ups  x5");
                    } else if (HowManyCounters == 2) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.lsitraises));
                        TextPushUp.setText("L-sit raises  x4 ");
                    } else if (HowManyCounters == 3) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinakolanach));
                        TextPushUp.setText("Push ups on the knees  x6");
                    } else if (HowManyCounters == 4) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  x4");
                    } else if (HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.krzeselka));
                        TextPushUp.setText("Knee raises  x5");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);

                        //try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                    }
                }else if(whatNumberWePush == 2)
                {
                    if (HowManyCounters == 1) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  x7");
                    }else if (HowManyCounters == 2) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.lsitraises));
                        TextPushUp.setText("L-sit raises  x5 ");
                    }else if (HowManyCounters == 3) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.krzeselka));
                        TextPushUp.setText("Knee raises  x7");
                    } else if (HowManyCounters == 4) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinapodwyzszeniu));
                        TextPushUp.setText("Incline push ups  x10");
                    }else if (HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinakolanach));
                        TextPushUp.setText("Push ups on the knees  x8");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);
                    }
                }else if(whatNumberWePush == 3) {
                    if (HowManyCounters == 1) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.lsitraises));
                        TextPushUp.setText("L-sit raises  x6");
                    } else if (HowManyCounters == 2) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinormalne));
                        TextPushUp.setText("Push up  x5 ");
                    } else if (HowManyCounters == 3) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciagnieciaaustralijskie));
                        TextPushUp.setText("Australian push ups  x5");
                    } else if (HowManyCounters == 4) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  x10");
                    } else if (HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinapodwyzszeniu));
                        TextPushUp.setText("Incline push ups  x8");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);
                    }
                }else if(whatNumberWePush == 4)
                {
                    if (HowManyCounters == 1) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciaganienachwytem));
                        TextPushUp.setText("Pull ups  x5");
                    } else if (HowManyCounters == 2) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinormalne));
                        TextPushUp.setText("Push ups  x8 ");
                    } else if (HowManyCounters == 3) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  x6");
                    } else if (HowManyCounters == 4) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.szwedki));
                        TextPushUp.setText("Sweden push ups  x5");
                    } else if (HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.bardip));
                        TextPushUp.setText("Bar dips  x5");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);
                    }
                }else if(whatNumberWePush == 5)
                {
                    if (HowManyCounters == 1 || HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciaganienachwytem));
                        TextPushUp.setText("Pull ups  x10");
                    } else if (HowManyCounters == 2 || HowManyCounters == 6) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  x10");
                    } else if (HowManyCounters == 3 || HowManyCounters == 7) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinormalne));
                        TextPushUp.setText("Push ups  x15");
                    } else if (HowManyCounters == 4 || HowManyCounters == 8) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.lsitraises));
                        TextPushUp.setText("L-sit raises  x5");
                    } else if (HowManyCounters == 9) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciaganiawlsicie));
                        TextPushUp.setText("Push ups in L-sit position  x4");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);
                    }
                }else if(whatNumberWePush == 6)
                {
                    if (HowManyCounters == 1) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.krzeselka));
                        TextPushUp.setText("Knee raises  x5");
                    } else if (HowManyCounters == 2) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  MAX ");
                    } else if (HowManyCounters == 3) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinormalne));
                        TextPushUp.setText("Push ups  x10");
                    } else if (HowManyCounters == 4) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciagnieciaaustralijskie));
                        TextPushUp.setText("Australian push ups  x5");
                    } else if (HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.szwedki));
                        TextPushUp.setText("Sweden push ups  x5");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);
                    }
                }else if(whatNumberWePush == 7)
                {
                    if (HowManyCounters == 1) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  x5");
                    } else if (HowManyCounters == 2) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinormalne));
                        TextPushUp.setText("Push ups  x10 ");
                    } else if (HowManyCounters == 3) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciaganienachwytem));
                        TextPushUp.setText("Pull ups  x5");
                    } else if (HowManyCounters == 4) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.bardip));
                        TextPushUp.setText("Bar dips  x5");
                    } else if (HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.lsitraises));
                        TextPushUp.setText("L-sit raises  x5");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);
                    }
                }else if(whatNumberWePush == 8)
                {
                    if (HowManyCounters == 1) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciaganienachwytem));
                        TextPushUp.setText("Pull ups  x15");
                    } else if (HowManyCounters == 2) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  x15");
                    } else if (HowManyCounters == 3) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.bardip));
                        TextPushUp.setText("Bar dips  x10");
                    } else if (HowManyCounters == 4) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkidiamonds));
                        TextPushUp.setText("Diamonds push ups  x10");
                    } else if (HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciaganiawlsicie));
                        TextPushUp.setText("L-sit pull ups  x7");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);
                    }
                }else if(whatNumberWePush == 9)
                {
                    if (HowManyCounters == 1) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.mymuscleup));
                        TextPushUp.setText("Muscle ups  x3");
                    } else if (HowManyCounters == 2) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciaganienachwytem));
                        TextPushUp.setText("Pull ups  x10");
                    } else if (HowManyCounters == 3) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.dipy));
                        TextPushUp.setText("Dips  x15");
                    } else if (HowManyCounters == 4) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.pompkinormalne));
                        TextPushUp.setText("Push ups  x10");
                    } else if (HowManyCounters == 5) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.podciaganienachwytem));
                        TextPushUp.setText("Pull ups  x10");
                    } else if (HowManyCounters == 6) {
                        PushUp1.setImageDrawable(getResources().getDrawable(R.drawable.mymuscleup));
                        TextPushUp.setText("Muscle ups  MAX");
                        FinishALL.setVisibility(View.VISIBLE);
                        FinishWork.setVisibility(View.GONE);
                    }
                }

            }
        }.start();

        StartTraining.setVisibility(View.GONE);
        timerRunning = true;
    }

    public void stopTimer()
    {
        countDownTimer.cancel();
        StartTraining.setText("START");
        timerRunning = false;
    }

    public void updateTimer()  // Aktualizacja Timer'a zainspirowany internetowymi przykladami
    {
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeftText;

        if(timeLeftInMilliseconds <= 10999)
        {
            timeLeftText = "" + seconds;
            TimeTextView.setText(timeLeftText);
        }else {
            timeLeftText = "" + minutes;
            timeLeftText += ":";

            if (seconds < 11) timeLeftText += "0";
            timeLeftText += seconds;

            TimeTextView.setText(timeLeftText);

        }
     }


}
