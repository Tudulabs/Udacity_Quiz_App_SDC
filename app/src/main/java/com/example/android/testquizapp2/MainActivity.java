package com.example.android.testquizapp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
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

        //making variables for checkboxes

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

//radiobutton switch for question 3

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

        //question 4 is used to match the inputted string.

        EditText carPermits = findViewById(R.id.number_of_self_driving_cars_editText);
        String carPermitsString = carPermits.getText().toString();

        if (carPermitsString.contains("52"))
        {
            score ++;
            question4IsRight = true;
            ImageView question4rightCheck = findViewById(R.id.question_4_checkmark);
            question4rightCheck.setVisibility(View.VISIBLE);
        }


        //question 5 logic

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


//display the toast for the score

        Toast scoreToast = Toast.makeText(getApplicationContext(),"Your score is: " + score ,Toast.LENGTH_SHORT);
        scoreToast.show();
        //resetting the score to 0 after inputting the answer
        score = 0;
    }
    }


