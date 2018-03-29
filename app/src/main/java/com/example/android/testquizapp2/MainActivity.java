package com.example.android.testquizapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }


    public int score = 0;
    //use these to add answers if a question isn't right
    boolean question1IsRight = false;
    boolean question2IsRight = false;
    boolean question3IsRight = false;
    boolean question4IsRight = false;
    boolean question5IsRight = false;


    public void displayScore(View view) {
        //setting up the intent to launch a new activity
        Intent intent = new Intent(this, Main2Activity.class);
        //setting a variable for the submit button
        Button button1 = findViewById(R.id.submit_button);

        //coding for the radiogroup for multiple cases
        RadioGroup mySelection = findViewById(R.id.see_things_radiogroup);
        int radioButtonId = mySelection.getCheckedRadioButtonId();


        switch (radioButtonId)
        {
            case R.id.lidar_radio_button:
                score ++;
                question1IsRight = true;

                ImageView question1rightCheck = findViewById(R.id.question_1_checkmark);
                question1rightCheck.setVisibility(View.VISIBLE);


        }

        CheckBox question2answer1 = findViewById(R.id.stop_at_red_lights);
        CheckBox question2answer2 = findViewById(R.id.slow_at_yellow_lights);
        CheckBox question2answer3 = findViewById(R.id.remember_things);
        CheckBox question2Wrong1 = findViewById(R.id.go_anywhere);

        if (question2answer1.isChecked() && question2answer2.isChecked() && question2answer3.isChecked() && question2Wrong1.isChecked()==false)
        {
            question2IsRight = true;
            score ++;

            ImageView question2rightCheck = findViewById(R.id.question_2_checkmark);
            question2rightCheck.setVisibility(View.VISIBLE);
        }


        RadioGroup question3 = findViewById(R.id.most_cars_radiogroup);
        int question3RadiobuttonId = question3.getCheckedRadioButtonId();


        switch (question3RadiobuttonId)
        {
            case R.id.arizona_radio_button:
                score ++;
                question3IsRight = true;

                ImageView question3rightCheck = findViewById(R.id.question_3_checkmark);
                question3rightCheck.setVisibility(View.VISIBLE);


        }

        EditText carPermits = findViewById(R.id.number_of_self_driving_cars_editText);
        String carPermitsString = carPermits.getText().toString();

        if (carPermitsString.contains("52"))
        {
            score ++;
            question4IsRight = true;
            ImageView question4rightCheck = findViewById(R.id.question_4_checkmark);
            question4rightCheck.setVisibility(View.VISIBLE);
        }

        CheckBox question5answer1 = findViewById(R.id.question_5_answer_1);
        CheckBox question5answer2 = findViewById(R.id.question_5_answer_2);
        CheckBox question5wrong1 = findViewById(R.id.question_5_wrong_1);
        CheckBox question5wrong2 = findViewById(R.id.question_5_wrong_2);


        if (question5answer1.isChecked() && question5answer2.isChecked() && question5wrong1.isChecked() == false && question5wrong2.isChecked()==false)
        {
            question5IsRight = true;
            score ++;


            ImageView question5rightCheck = findViewById(R.id.question_5_checkmark);
            question5rightCheck.setVisibility(View.VISIBLE);
        }

//logging the score

        Log.i("score" , "the score is " + score);

        Toast scoreToast = Toast.makeText(getApplicationContext(),"Your score is: " + score ,Toast.LENGTH_SHORT);
        View toastView22 = findViewById(R.id.toastView11);

        scoreToast.show();

        score = 0;
    }
    }


