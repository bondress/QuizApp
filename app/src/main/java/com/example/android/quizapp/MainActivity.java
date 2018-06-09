package com.example.android.quizapp;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * Declare global variables used in the addListenerOnButton method and resetAll method
     */
    int finalScore = 0;
    RadioGroup radioQuestion1;
    RadioButton radioQ1ButtonCorrect;
    RadioGroup radioQuestion2;
    RadioButton radioQ2ButtonCorrect;
    CheckBox checkQ3ButtonCorrect1;
    CheckBox checkQ3ButtonCorrect2;
    CheckBox checkQ3ButtonWrong;
    EditText editTextQ4;
    String stringQ4Answer;
    CheckBox checkQ5ButtonCorrect1;
    CheckBox checkQ5ButtonCorrect2;
    CheckBox checkQ5ButtonWrong;
    RadioGroup radioQuestion6;
    RadioButton radioQ6ButtonCorrect;
    EditText editTextQ7;
    String stringQ7Answer;
    RadioGroup radioQuestion8;
    RadioButton radioQ8ButtonCorrect;
    RadioGroup radioQuestion9;
    RadioButton radioQ9ButtonCorrect;
    EditText editTextQ10;
    String stringQ10Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Calls the listener method attached to the submit button
        addListenerOnButton();
    }

    /**
     * Adds a listener to the submit button and carries out the grading logic for the quiz
     */
    public void addListenerOnButton() {
        radioQuestion1 = findViewById(R.id.radioQuestion1);
        radioQuestion2 = findViewById(R.id.radioQuestion2);
        radioQ1ButtonCorrect = findViewById(R.id.radio_q1_option2);
        radioQ2ButtonCorrect = findViewById(R.id.radio_q2_option2);
        checkQ3ButtonCorrect1 = findViewById(R.id.check_q3_option2);
        checkQ3ButtonCorrect2 = findViewById(R.id.check_q3_option3);
        checkQ3ButtonWrong = findViewById(R.id.check_q3_option1);
        editTextQ4 = findViewById(R.id.question4_edit_text);
        stringQ4Answer = getString(R.string.edit_text_q4_answer);
        checkQ5ButtonCorrect1 = findViewById(R.id.check_q5_option1);
        checkQ5ButtonCorrect2 = findViewById(R.id.check_q5_option3);
        checkQ5ButtonWrong = findViewById(R.id.check_q5_option2);
        radioQuestion6 = findViewById(R.id.radioQuestion6);
        radioQ6ButtonCorrect = findViewById(R.id.radio_q6_option1);
        editTextQ7 = findViewById(R.id.question7_edit_text);
        stringQ7Answer = getString(R.string.edit_text_q7_answer);
        radioQuestion8 = findViewById(R.id.radioQuestion8);
        radioQ8ButtonCorrect = findViewById(R.id.radio_q8_option2);
        radioQuestion9 = findViewById(R.id.radioQuestion9);
        radioQ9ButtonCorrect = findViewById(R.id.radio_q9_option3);
        editTextQ10 = findViewById(R.id.question10_edit_text);
        stringQ10Answer = getString(R.string.edit_text_q10_answer);
        Button submitButton = findViewById(R.id.submitAnswers);

        //Add some sound effects
        final MediaPlayer booSound = MediaPlayer.create(this, R.raw.boo);
        final MediaPlayer cheerSound = MediaPlayer.create(this, R.raw.cheer);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //Ensure that all questions have been attempted before computing final answer.
                //The app will scroll to the ignored question and demand an answer before moving on.
                if (radioQuestion1.getCheckedRadioButtonId() == -1) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question1header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    Toast.makeText(MainActivity.this, R.string.q1_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioQuestion2.getCheckedRadioButtonId() == -1) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question2header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    Toast.makeText(MainActivity.this, R.string.q2_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!checkQ3ButtonCorrect1.isChecked() && !checkQ3ButtonCorrect2.isChecked() && !checkQ3ButtonWrong.isChecked()) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question3header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    Toast.makeText(MainActivity.this, R.string.q3_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                //Ensure that the user checks at least two checkboxes
                //if (checkQ3ButtonCorrect1.isChecked() && checkQ3ButtonCorrect2.isChecked()){
                //   checkQ3ButtonWrong.setChecked(false);
                //    Toast.makeText(MainActivity.this, R.checkbox_error1, Toast.LENGTH_SHORT).show();
                //    return;
                //}
                //Ensure that the user cannot check more than two checkboxes
                //if (checkQ3ButtonCorrect1.isChecked() && !checkQ3ButtonCorrect2.isChecked() && !checkQ3ButonWrong.isChecked()){
                //    Toast.makeText(MainActivity.this, R.checkbox_error1, Toast.LENGTH_SHORT).show();
                //    return;
                //}
                if (editTextQ4.getText().toString().length() == 0) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question4header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    editTextQ4.setError(getString(R.string.edittext_error));
                    return;
                }
                if (!checkQ5ButtonCorrect1.isChecked() && !checkQ5ButtonCorrect2.isChecked() && !checkQ5ButtonWrong.isChecked()) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question5header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    Toast.makeText(MainActivity.this, R.string.q5_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioQuestion6.getCheckedRadioButtonId() == -1) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question6header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    Toast.makeText(MainActivity.this, R.string.q6_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editTextQ7.getText().toString().length() == 0) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question7header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    editTextQ7.setError(getString(R.string.edittext_error));
                    return;
                }
                if (radioQuestion8.getCheckedRadioButtonId() == -1) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question8header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    Toast.makeText(MainActivity.this, R.string.q8_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (radioQuestion9.getCheckedRadioButtonId() == -1) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question9header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    Toast.makeText(MainActivity.this, R.string.q9_error, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (editTextQ10.getText().toString().length() == 0) {
                    //Create a variable to reference the TextView related to this question
                    TextView targetView = findViewById(R.id.question10header_text_view);
                    //Get the app to focus on this question
                    targetView.getParent().requestChildFocus(targetView, targetView);
                    editTextQ10.setError(getString(R.string.edittext_error));
                    return;
                }
                //Increase the final score by one point based on number of correct answers
                if (radioQ1ButtonCorrect.isChecked()) {
                    finalScore += 1;
                }
                if (radioQ2ButtonCorrect.isChecked()) {
                    finalScore += 1;
                }
                if (checkQ3ButtonCorrect1.isChecked() && checkQ3ButtonCorrect2.isChecked() && !checkQ3ButtonWrong.isChecked()) {
                    finalScore += 1;
                }
                if (editTextQ4.getText().toString().equalsIgnoreCase(stringQ4Answer)) {
                    finalScore += 1;
                }
                if (checkQ5ButtonCorrect1.isChecked() && checkQ5ButtonCorrect2.isChecked() && !checkQ5ButtonWrong.isChecked()) {
                    finalScore += 1;
                }
                if (radioQ6ButtonCorrect.isChecked()) {
                    finalScore += 1;
                }
                if (editTextQ7.getText().toString().equalsIgnoreCase(stringQ7Answer)) {
                    finalScore += 1;
                }
                if (radioQ8ButtonCorrect.isChecked()) {
                    finalScore += 1;
                }
                if (radioQ9ButtonCorrect.isChecked()) {
                    finalScore += 1;
                }
                if (editTextQ10.getText().toString().equalsIgnoreCase(stringQ10Answer)) {
                    finalScore += 1;
                }
                //Display the results based on number of correct answers
                Toast.makeText(MainActivity.this, finalScore + "\\10!", Toast.LENGTH_LONG).show();

                if (finalScore <= 6) {
                    Toast.makeText(MainActivity.this, R.string.try_again, Toast.LENGTH_LONG).show();
                    //Play appropriate sound and reset score variable
                    booSound.start();
                    finalScore = 0;
                }
                if (finalScore <= 9 && finalScore > 6) {
                    Toast.makeText(MainActivity.this, R.string.good_job, Toast.LENGTH_LONG).show();
                    //Play appropriate sound and reset score variable
                    cheerSound.start();
                    finalScore = 0;
                }
                if (finalScore == 10) {
                    Toast.makeText(MainActivity.this, R.string.excellent, Toast.LENGTH_LONG).show();
                    //Play appropriate sound and reset score variable
                    cheerSound.start();
                    finalScore = 0;
                }
                //Scroll to the beginning of the quiz
                ScrollView mainView = findViewById(R.id.root_view);
                mainView.fullScroll(ScrollView.FOCUS_UP);
                //Display the correct answers where wrong answers were selected
                if (!radioQ1ButtonCorrect.isChecked()) {
                    radioQ1ButtonCorrect.setTextColor(Color.GREEN);
                }
                if (!radioQ2ButtonCorrect.isChecked()) {
                    radioQ2ButtonCorrect.setTextColor(Color.GREEN);
                }
                if (!checkQ3ButtonCorrect1.isChecked() && !checkQ3ButtonCorrect2.isChecked()
                        || checkQ3ButtonCorrect1.isChecked() && checkQ3ButtonWrong.isChecked()
                        || checkQ3ButtonCorrect2.isChecked() && checkQ3ButtonWrong.isChecked()
                        || checkQ3ButtonCorrect1.isChecked() && !checkQ3ButtonCorrect2.isChecked() && !checkQ3ButtonWrong.isChecked()
                        || !checkQ3ButtonCorrect1.isChecked() && checkQ3ButtonCorrect2.isChecked() && !checkQ3ButtonWrong.isChecked()
                        || !checkQ3ButtonCorrect1.isChecked() && !checkQ3ButtonCorrect2.isChecked() && checkQ3ButtonWrong.isChecked()) {
                    checkQ3ButtonCorrect1.setTextColor(Color.GREEN);
                    checkQ3ButtonCorrect2.setTextColor(Color.GREEN);
                }
                if (!editTextQ4.getText().toString().equalsIgnoreCase(stringQ4Answer)) {
                    editTextQ4.setText(R.string.edit_text_q4_answer, TextView.BufferType.EDITABLE);
                    editTextQ4.setTextColor(Color.GREEN);
                }
                if (!checkQ5ButtonCorrect1.isChecked() && !checkQ5ButtonCorrect2.isChecked()
                        || checkQ5ButtonCorrect1.isChecked() && checkQ5ButtonWrong.isChecked()
                        || checkQ5ButtonCorrect2.isChecked() && checkQ5ButtonWrong.isChecked()
                        || checkQ5ButtonCorrect1.isChecked() && !checkQ5ButtonCorrect2.isChecked() && !checkQ5ButtonWrong.isChecked()
                        || !checkQ5ButtonCorrect1.isChecked() && checkQ5ButtonCorrect2.isChecked() && !checkQ5ButtonWrong.isChecked()
                        || !checkQ5ButtonCorrect1.isChecked() && !checkQ5ButtonCorrect2.isChecked() && checkQ5ButtonWrong.isChecked()) {
                    checkQ5ButtonCorrect1.setTextColor(Color.GREEN);
                    checkQ5ButtonCorrect2.setTextColor(Color.GREEN);
                }
                if (!radioQ6ButtonCorrect.isChecked()) {
                    radioQ6ButtonCorrect.setTextColor(Color.GREEN);
                }
                if (!editTextQ7.getText().toString().equalsIgnoreCase(stringQ7Answer)) {
                    editTextQ7.setText(R.string.edit_text_q7_answer, TextView.BufferType.EDITABLE);
                    editTextQ7.setTextColor(Color.GREEN);
                }
                if (!radioQ8ButtonCorrect.isChecked()) {
                    radioQ8ButtonCorrect.setTextColor(Color.GREEN);
                }
                if (!radioQ9ButtonCorrect.isChecked()) {
                    radioQ9ButtonCorrect.setTextColor(Color.GREEN);
                }
                if (!editTextQ10.getText().toString().equalsIgnoreCase(stringQ10Answer)) {
                    editTextQ10.setText(R.string.edit_text_q10_answer, TextView.BufferType.EDITABLE);
                    editTextQ10.setTextColor(Color.GREEN);
                }
            }
        });
    }

    /**
     * Resets all checkboxes, radio buttons and edit text fields
     */
    public void resetAll(View v) {
        radioQuestion1.clearCheck();
        radioQ1ButtonCorrect.setTextColor(Color.rgb(0, 0, 0));
        radioQuestion2.clearCheck();
        radioQ2ButtonCorrect.setTextColor(Color.rgb(0, 0, 0));
        checkQ3ButtonCorrect1.setChecked(false);
        checkQ3ButtonCorrect1.setTextColor(Color.rgb(0, 0, 0));
        checkQ3ButtonCorrect2.setChecked(false);
        checkQ3ButtonCorrect2.setTextColor(Color.rgb(0, 0, 0));
        checkQ3ButtonWrong.setChecked(false);
        editTextQ4.setText("");
        editTextQ4.setTextColor(Color.rgb(0, 0, 0));
        checkQ5ButtonCorrect1.setChecked(false);
        checkQ5ButtonCorrect1.setTextColor(Color.rgb(0, 0, 0));
        checkQ5ButtonCorrect2.setChecked(false);
        checkQ5ButtonCorrect2.setTextColor(Color.rgb(0, 0, 0));
        checkQ5ButtonWrong.setChecked(false);
        radioQuestion6.clearCheck();
        radioQ6ButtonCorrect.setTextColor(Color.rgb(0, 0, 0));
        editTextQ7.setText("");
        editTextQ7.setTextColor(Color.rgb(0, 0, 0));
        radioQuestion8.clearCheck();
        radioQ8ButtonCorrect.setTextColor(Color.rgb(0, 0, 0));
        radioQuestion9.clearCheck();
        radioQ9ButtonCorrect.setTextColor(Color.rgb(0, 0, 0));
        editTextQ10.setText("");
        editTextQ10.setTextColor(Color.rgb(0, 0, 0));
        finalScore = 0;
    }
}