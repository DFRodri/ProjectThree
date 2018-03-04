package com.example.android.projectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //variables related to views
    //Makes use of butterKnife - http://jakewharton.github.io/butterknife/
    @BindView(R.id.intro)
    RelativeLayout intro;
    @BindView(R.id.button)
    LinearLayout buttonQuestion;
    @BindView(R.id.questionButton)
    TextView textButton;
    @BindView(R.id.buttonA)
    Button buttonA;
    @BindView(R.id.buttonB)
    Button buttonB;
    @BindView(R.id.buttonC)
    Button buttonC;
    @BindView(R.id.buttonD)
    Button buttonD;
    @BindView(R.id.checkbox)
    LinearLayout checkQuestion;
    @BindView(R.id.questionCheck)
    TextView textCheck;
    @BindView(R.id.checkA)
    CheckBox checkBoxA;
    @BindView(R.id.checkB)
    CheckBox checkBoxB;
    @BindView(R.id.checkC)
    CheckBox checkBoxC;
    @BindView(R.id.checkD)
    CheckBox checkBoxD;
    @BindView(R.id.radio)
    LinearLayout radioQuestion;
    @BindView(R.id.questionRadio)
    TextView textRadio;
    @BindView(R.id.radioA)
    RadioButton radioA;
    @BindView(R.id.radioB)
    RadioButton radioB;
    @BindView(R.id.radioC)
    RadioButton radioC;
    @BindView(R.id.radioD)
    RadioButton radioD;
    @BindView(R.id.editText)
    LinearLayout editQuestion;
    @BindView(R.id.questionEdit)
    TextView textEdit;
    @BindView(R.id.editAnswer)
    EditText answerGiven;
    @BindView(R.id.restart)
    LinearLayout restart;

    /**
     * NOTE: I don't know if we can or not use butterKnife at this stage so in case we can't, here is the version without it, the rest is at the onCreate
     * <p>
     * variables related to views
     * RelativeLayout intro;
     * <p>
     * LinearLayout buttonQuestion;
     * TextView textButton;
     * Button buttonA;
     * Button buttonB;
     * Button buttonC;
     * Button buttonD;
     * <p>
     * LinearLayout checkQuestion;
     * TextView textCheck;
     * CheckBox checkBoxA;
     * CheckBox checkBoxB;
     * CheckBox checkBoxC;
     * CheckBox checkBoxD;
     * <p>
     * LinearLayout radioQuestion;
     * TextView textRadio;
     * RadioButton radioA;
     * RadioButton radioB;
     * RadioButton radioC;
     * RadioButton radioD;
     * <p>
     * LinearLayout editQuestion;
     * TextView textEdit;
     * EditText answerGiven;
     * <p>
     * LinearLayout restart;
     **/

    //variables to handle rotations
    private static final String SCORE = "scoreAndQuestions";
    private static final String CHECK_OPTIONS = "checkOptions";
    private static final String RADIO_OPTION = "radioOption";
    private static final String ANSWERS = "answers";

    //holds the score, question number (questions only starts on 1 to be easier to code and to rotate)
    int[] score = {0, 1};

    //holds the answers given in the checkbox
    boolean[] checkBoxOptions = {false, false, false, false};

    //holds the answer given in the radio (forces a change to true on the selected)
    int radioOption;

    //holds the answers given by the player (first position, answers[0], is ignored to make it easier to work with overall)
    boolean[] answers = new boolean[9];

    //following two methods take care of variables when a rotation happens
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putIntArray(SCORE, score);
        savedInstanceState.putBooleanArray(CHECK_OPTIONS, checkBoxOptions);
        savedInstanceState.putInt(RADIO_OPTION, radioOption);
        savedInstanceState.putBooleanArray(ANSWERS, answers);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        score = savedInstanceState.getIntArray(SCORE);
        checkBoxOptions = savedInstanceState.getBooleanArray(CHECK_OPTIONS);
        radioOption = savedInstanceState.getInt(RADIO_OPTION);
        answers = savedInstanceState.getBooleanArray(ANSWERS);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //binding call to the views needed
        ButterKnife.bind(this);

        //Because we only need the intro screen once...
        if (score[1] != 0) {
            intro.setVisibility(View.GONE);
            question();
        }

        /**
         *all the calls to the views needed to make the app work
         *intro = findViewById(R.id.intro);
         *
         *buttonQuestion = findViewById(R.id.button);
         *textButton = findViewById(R.id.questionButton);
         *
         *buttonA = findViewById(R.id.buttonA);
         *buttonB = findViewById(R.id.buttonB);
         *buttonC = findViewById(R.id.buttonC);
         *buttonD = findViewById(R.id.buttonD);
         *
         *checkQuestion = findViewById(R.id.checkbox);
         *textCheck = findViewById(R.id.questionCheck);
         *checkBoxA = findViewById(R.id.checkA);
         *checkBoxB = findViewById(R.id.checkB);
         *checkBoxC = findViewById(R.id.checkC);
         *checkBoxD = findViewById(R.id.checkD);
         *
         * radioQuestion = findViewById(R.id.radio);
         *textRadio = findViewById(R.id.questionRadio);
         *radioA = findViewById(R.id.radioA);
         *radioB = findViewById(R.id.radioB);
         *radioC = findViewById(R.id.radioC);
         *radioD = findViewById(R.id.radioD);
         *
         *editQuestion = findViewById(R.id.editText);
         *textEdit = findViewById(R.id.questionEdit);
         *answerGiven = findViewById(R.id.editAnswer);
         *
         *restart = findViewById(R.id.restart);
         **/

    }

    //we're working with a single activity so let's make things easy by playing with setVisibility gone and visible

    //first method ("screen") is a small intro to the quiz
    public void agree(View view) {

        intro.setVisibility(View.GONE);

        question();

    }

    //second method handles the questions, answers and their display
    //each if handles a different screen
    //and it also handles the display of the score after all the questions are answered since it can be done with a quick follow up
    public void question() {

        if (score[1] == 1 || score[1] == 7) {

            buttonQuestion.setVisibility(View.VISIBLE);

            if (score[1] == 1) {
                textButton.setText(getString(R.string.questionOne));
                buttonA.setText(getString(R.string.answer1_1));//correct answer
                buttonB.setText(getString(R.string.answer1_2));
                buttonC.setText(getString(R.string.answer1_3));
                buttonD.setText(getString(R.string.answer1_4));
            }
            if (score[1] == 7) {
                textButton.setText(getString(R.string.questionSeven));
                buttonA.setText(getString(R.string.answer7_1));
                buttonB.setText(getString(R.string.answer7_2));//correct answer
                buttonC.setText(getString(R.string.answer7_3));
                buttonD.setText(getString(R.string.answer7_4));
            }

        }

        if (score[1] == 2 || score[1] == 5) {

            checkQuestion.setVisibility(View.VISIBLE);

            if (score[1] == 2) {
                textCheck.setText(getString(R.string.questionTwo));
                checkBoxA.setText(getString(R.string.answer2_1));
                checkBoxB.setText(getString(R.string.answer2_2));
                checkBoxC.setText(getString(R.string.answer2_3));//correct answer
                checkBoxD.setText(getString(R.string.answer2_4));
            }
            if (score[1] == 5) {
                textCheck.setText(getString(R.string.questionFive));
                checkBoxA.setText(getString(R.string.answer5_1));//correct answer
                checkBoxB.setText(getString(R.string.answer5_2));//correct answer
                checkBoxC.setText(getString(R.string.answer5_3));
                checkBoxD.setText(getString(R.string.answer5_4));
            }
        }

        if (score[1] == 3 || score[1] == 6) {

            radioQuestion.setVisibility(View.VISIBLE);

            if (score[1] == 3) {

                textRadio.setText(getString(R.string.questionThree));
                radioA.setText(getString(R.string.answer3_1));//correct answer
                radioB.setText(getString(R.string.answer3_2));
                radioC.setText(getString(R.string.answer3_3));
                radioD.setText(getString(R.string.answer3_4));
            }
            if (score[1] == 6) {

                textRadio.setText(getString(R.string.questionSix));
                radioA.setText(getString(R.string.answer6_1));
                radioB.setText(getString(R.string.answer6_2));
                radioC.setText(getString(R.string.answer6_3));
                radioD.setText(getString(R.string.answer6_4));//correct answer

            }
        }

        if (score[1] == 4 || score[1] == 8) {

            editQuestion.setVisibility(View.VISIBLE);

            if (score[1] == 4) {
                textEdit.setText(getString(R.string.questionFour));
            }
            if (score[1] == 8) {
                textEdit.setText(getString(R.string.questionEight));
            }
        }

        if (score[1] == 9) {

            restart.setVisibility(View.VISIBLE);

            if (answers[1]) {
                score[0]++;
            }
            if (answers[2]) {
                score[0]++;
            }
            if (answers[3]) {
                score[0]++;
            }
            if (answers[4]) {
                score[0]++;
            }
            if (answers[5]) {
                score[0]++;
            }
            if (answers[6]) {
                score[0]++;
            }
            if (answers[7]) {
                score[0]++;
            }
            if (answers[8]) {
                score[0]++;
            }

            if (score[0] == 0) {
                Toast.makeText(this, getString(R.string.terribleScore), Toast.LENGTH_LONG).show();
            } else if (score[0] > 0 && score[0] < 8) {
                String congratulations = getString(R.string.finalScore) + " " + score[0] + getString(R.string.maxScore) + getString(R.string.decent);
                Toast.makeText(this, congratulations, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, getString(R.string.recordScore), Toast.LENGTH_LONG).show();
            }
        }
    }

    //the following four methods handle the button presses on the screen with button choices
    public void buttonA(View view) {

        if (score[1] == 1) {
            answers[1] = true;
        }
        if (score[1] == 7) {
            answers[7] = false;
        }

        solveQuestion();
    }

    public void buttonB(View view) {

        if (score[1] == 1) {
            answers[1] = false;
        }
        if (score[1] == 7) {
            answers[7] = true;
        }

        solveQuestion();
    }

    public void buttonC(View view) {

        if (score[1] == 1) {
            answers[1] = false;
        }
        if (score[1] == 7) {
            answers[7] = false;
        }

        solveQuestion();
    }

    public void buttonD(View view) {

        if (score[1] == 1) {
            answers[1] = false;
        }
        if (score[1] == 7) {
            answers[7] = false;
        }

        solveQuestion();
    }

    //and this method is the follow up to them
    //the mid-term man that takes care to make it jump to the next question after hiding this "screen"
    public void solveQuestion() {

        score[1]++;

        buttonQuestion.setVisibility(View.GONE);

        question();
    }

    //method to check which checkboxes the player checked in the checkbox questions
    public void checkAnswer(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkA:
                if (checked) {
                    checkBoxOptions[0] = true;
                } else if (!checkBoxOptions[0]) {
                    checkBoxOptions[0] = false;
                }
                break;
            case R.id.checkB:
                if (checked) {
                    checkBoxOptions[1] = true;
                } else if (!checkBoxOptions[1]) {
                    checkBoxOptions[1] = false;
                }
                break;
            case R.id.checkC:
                if (checked) {
                    checkBoxOptions[2] = true;
                } else if (!checkBoxOptions[2]) {
                    checkBoxOptions[2] = false;
                }
                break;
            case R.id.checkD:
                if (checked) {
                    checkBoxOptions[3] = true;
                } else if (!checkBoxOptions[3]) {
                    checkBoxOptions[3] = false;
                }
                break;
        }
    }

    //and this one is the follow up to see if the player got it right or not
    //it also takes care of hiding this "screen" after being used and jumps back to the question method
    public void checkSolution(View view) {

        if (score[1] == 2) {
            boolean[] solutionTwo = {false, true, true, true};
            if (checkBoxOptions == solutionTwo) {
                answers[2] = true;
            } else {
                answers[2] = false;
            }
        }

        if (score[1] == 5) {
            boolean[] solutionFive = {true, true, false, false};
            if (checkBoxOptions == solutionFive) {
                answers[5] = true;
            } else {
                answers[5] = false;
            }
        }

        score[1]++;

        checkBoxA.setChecked(false);
        checkBoxB.setChecked(false);
        checkBoxC.setChecked(false);
        checkBoxD.setChecked(false);

        checkQuestion.setVisibility(View.GONE);

        question();
    }

    //method that checks the answer selected by the player in a radioGroup question
    public void radioAnswer(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioA:
                if (checked) {
                    radioOption = 1;
                }
                break;
            case R.id.radioB:
                if (checked) {
                    radioOption = 2;
                }
                break;
            case R.id.radioC:
                if (checked) {
                    radioOption = 3;
                }
                break;
            case R.id.radioD:
                if (checked) {
                    radioOption = 4;
                }
                break;
        }

    }

    //and this is the follow up to check if the player selected or not the right one
    //it also takes care of hiding this "screen" after being used and jumps back to the question method
    public void radioSolution(View view) {

        if (score[1] == 3) {
            if (radioOption == 1) {
                answers[3] = true;
            } else {
                answers[3] = false;
            }
        }

        if (score[1] == 6) {
            if (radioOption == 4) {
                answers[6] = true;
            } else {
                answers[6] = false;
            }
        }

        score[1]++;

        radioA.setChecked(false);
        radioB.setChecked(false);
        radioC.setChecked(false);
        radioD.setChecked(false);

        radioQuestion.setVisibility(View.GONE);

        question();
    }

    //method that checks if the editText questions got the right answer
    //it also takes care of hiding this "screen" after the answer is submited
    public void editSolution(View view) {

        String solutionEdit = answerGiven.getText().toString();

        if (score[1] == 4) {
            if (solutionEdit.equals(getString(R.string.answer4))) {
                answers[4] = true;
            } else {
                answers[4] = false;
            }
        }
        if (score[1] == 8) {
            if (solutionEdit.equals(getString(R.string.answer8))) {
                answers[8] = true;
            } else {
                answers[8] = false;
            }
        }

        score[1]++;

        answerGiven.setText("");

        editQuestion.setVisibility(View.GONE);

        question();
    }

    //method to restart our quiz
    //we only need to care about one single variable since the rest is overwritten
    public void restart(View view) {

        score[0] = 0;
        score[1] = 1;

        question();

    }

}
