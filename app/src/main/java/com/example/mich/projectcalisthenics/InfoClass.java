package com.example.mich.projectcalisthenics;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoClass extends MainActivity {
    TextView InfoText, InfoText2, InfoText3, InfoText4;
    Button ButtonQuit;
    ImageView imageView3;
    int whatNumberWePush = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_class);

        InfoText = (TextView) findViewById(R.id.textView);
        InfoText2 = (TextView) findViewById(R.id.textView2);
        InfoText3 = (TextView) findViewById(R.id.textView3);
        InfoText4 = (TextView) findViewById(R.id.textView4);
        imageView3 = (ImageView) findViewById(R.id.imageView3);

        int whatNumberDidIGet = getIntent().getIntExtra("key",0);
        if(whatNumberDidIGet == 1) {whatNumberWePush = 1;}
        else if(whatNumberDidIGet == 2){whatNumberWePush = 2;}
        else if(whatNumberDidIGet == 3){whatNumberWePush = 3;}
        else if(whatNumberDidIGet == 4){whatNumberWePush = 4;}

        if(whatNumberWePush == 1) {
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.pompkinormalne));

            InfoText2.setText("  Pushups are a basic exercise used in civilian athletic training or physical education and, especially, in military physical" +
                    " training and will develop the pectoral muscles and triceps, with ancillary benefits to the deltoids, serratus anterior, " +
                    "coracobrachialis and the midsection as a whole.\n \n The origins of the pushup are not totally clear, although several known variations" +
                    " have been in existence for centuries. One school of thought is that the pushup as we know it is a joining together of two popular yoga " +
                    "poses - downward-facing dog (Adho Mukha Svanasana) and upward-facing dog (Urdhva Mukha Svanasana). The roots of yoga can be traced back " +
                    "over 3,000 years.");

            InfoText4.setText("  Lie prone on the ground with hands placed as wide or slightly wider than shoulder width. Keeping the body straight, lower body " +
                    "to the ground by bending arms at the elbows. Raise body up off the ground by extending the arms. Repeat.\n\n " +
                    "Body weight should be lifted by the arms; don't be tempted to use your butt, stomach or the lower half of your body to pull yourself up. " +
                    "To maintain correct body alignment, imagine a straight line running from your head down to your ankles.");
        }else if(whatNumberWePush == 2)
        {
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.podciaganienachwytem));

            InfoText.setText("PULL UP - what is it?");
            InfoText3.setText("Instructions for good-form pull ups");

            InfoText2.setText("  The term chin up, traditionally referring to a pull-up with the chin brought over the top of a bar, was used in the 1980's "+
            "to refer to a pronated, or overhand, frip, with a supinated, or underhand, grip being called 'reverse-grip' chin-up. In later decades, this usage "+
            "has inverted, with some using 'chin-up' to refer to a pull-up done with a supinated hand position, while 'pull-up' refers specifically to the " +
            "exercise done with a pronated hand position. \n Pull-ups use many different muscles of the upper body, including the bieps brachii");

            InfoText4.setText("  Standard dead-hang pull up is grasped with an overhand/underhand,alternative-hand grip. Then the body is pulled up intil " +
            "the chin clears the bar, and finished by lowering the body until arms and shoulders are fully extended. Stricter standards would only consider a full " +
            "repetition to be one which the elbows pass behind the coronal plane");

        }else if(whatNumberWePush == 3)
        {
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.dipy));

            InfoText.setText("DIPS - what is it?");
            InfoText3.setText("Instructions for good-form dips");

            InfoText2.setText("  A dip is an upper-body strength exercise. Narrow, shoulder-width dips primarily train the triceps, with major synergists " +
            "being the anterior deltoid, the pectoralis muslces (steranal, clavicular and minor), and the rhomboid muscles of the bach. Wide arm training " +
            "places additional emphasis on the pectoral muslce, similar in respect to the way a wide grip bench press would focus more on the pectorals and less on the triceps.");

            InfoText4.setText("1. Grab the parallel bars and jump up, straighten your arms\n2. Lower your body by ending your arms while leaning forward\n" +
            "3. Dip down until your shoulders are below your elbows\n4. Lift your body up be streightening your arms\n5. Lock your elbows at the top");

        }else if(whatNumberWePush == 4)
        {
            imageView3.setImageDrawable(getResources().getDrawable(R.drawable.mymuscleup));

            InfoText.setText("MUSCLE UP - what is it?");
            InfoText3.setText("Instructions for good-form muscle ups");

            InfoText2.setText("  The muscle-up is an advanced strength training exercise, within the domain of calisthenics. It is a combination routine of a radial " +
            "pull-up followed by a bar-dip. Variations exist for the rings as well as the bar");

            InfoText4.setText("1. Start the kip from the free hang. Be tight and kip aggressively. Swing forward into a solid archer position\n" +
            "2. Swing you body back into the hollow rock position\n3. Engage your lasts. Imagine that you want to pull the bar towards your chest and " +
            "beneath as if it was movable\n4. Engage your hips, push ther towards the bar. A weightless moment should be created by doing so\n" +
            "5. Perform an extremely fast sit up to bring your upper body over the bar");
        }








        ButtonQuit = (Button)findViewById(R.id.buttonQuit);
        ButtonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogQuit();
            }
        });

    }


    public void DialogQuit()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(InfoClass.this);

        builder.setTitle("Please confirm");
        if(whatNumberWePush == 1){builder.setMessage("You know enough about push ups?");}
        else if(whatNumberWePush == 2) {builder.setMessage("You know enough about pull ups?");}
        else if(whatNumberWePush == 3){builder.setMessage("You know enough about dips?");}
        else if(whatNumberWePush == 4){builder.setMessage("You know enough about muslce ups?");}


        builder.setPositiveButton("  NO  ", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("  YES  ", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Intent intent = new Intent(InfoClass.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
