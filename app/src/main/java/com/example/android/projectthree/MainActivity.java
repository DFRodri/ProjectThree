package com.example.android.projectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //holds the score, question number
    int[] score = {0, 0};

    //holds the answers given in the checkbox
    Boolean[] checkBoxOne = new Boolean[4];

    //holds the answer given in the radio (forces a change to true on the selected)
    Boolean[] radioOption = {false, false, false, false, false};

    //holds the answers given by the player
    Boolean[] answers = new Boolean[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void agree(View view) {
        RelativeLayout intro = this.findViewById(R.id.intro);
        intro.setVisibility(View.GONE);

        question();
    }

    public void question() {

        if (score[1] == 0) {

            LinearLayout buttonQuestion = this.findViewById(R.id.button);
            buttonQuestion.setVisibility(View.VISIBLE);

            TextView textButton = this.findViewById(R.id.questionButton);

            Button buttonA = this.findViewById(R.id.buttonA);
            Button buttonB = this.findViewById(R.id.buttonB);
            Button buttonC = this.findViewById(R.id.buttonC);
            Button buttonD = this.findViewById(R.id.buttonD);

            textButton.setText(getString(R.string.questionOne));
            buttonA.setText(getString(R.string.answer1_1));//correct answer
            buttonB.setText(getString(R.string.answer1_2));
            buttonC.setText(getString(R.string.answer1_3));
            buttonD.setText(getString(R.string.answer1_4));

        }

        if (score[1] == 1) {
            LinearLayout buttonQuestion = this.findViewById(R.id.checkbox);
            buttonQuestion.setVisibility(View.VISIBLE);

            TextView textButton = this.findViewById(R.id.questionRadio);

            CheckBox checkBoxA = this.findViewById(R.id.checkA);
            CheckBox checkBoxB = this.findViewById(R.id.checkB);
            CheckBox checkBoxC = this.findViewById(R.id.checkC);
            CheckBox checkBoxD = this.findViewById(R.id.checkD);

            textButton.setText(getString(R.string.questionTwo));
            checkBoxA.setText(getString(R.string.answer2_1));
            checkBoxB.setText(getString(R.string.answer2_2));
            checkBoxC.setText(getString(R.string.answer2_3));//correct answer
            checkBoxD.setText(getString(R.string.answer2_4));
        }

        if (score[1] == 2) {
            LinearLayout buttonQuestion = this.findViewById(R.id.checkbox);
            buttonQuestion.setVisibility(View.VISIBLE);

            TextView textButton = this.findViewById(R.id.questionRadio);

            RadioButton radioA = this.findViewById(R.id.radioA);
            RadioButton radioB = this.findViewById(R.id.radioB);
            RadioButton radioC = this.findViewById(R.id.radioC);
            RadioButton radioD = this.findViewById(R.id.radioD);
            RadioButton radioE = this.findViewById(R.id.radioE);

            textButton.setText(getString(R.string.questionThree));
            radioA.setText(getString(R.string.answer3_1));//correct answer
            radioB.setText(getString(R.string.answer3_2));
            radioC.setText(getString(R.string.answer3_3));
            radioD.setText(getString(R.string.answer3_4));
            radioE.setText(getString(R.string.answer3_5));
        }

    }

    public void buttonA(View view) {
        if (score[0] == 0) {
            answers[0] = true;
        }

        solveQuestion();
    }

    public void buttonB(View view) {
        if (score[0] == 0) {
            answers[0] = false;
        }

        solveQuestion();
    }

    public void buttonC(View view) {
        if (score[0] == 0) {
            answers[0] = false;
        }

        solveQuestion();
    }

    public void buttonD(View view) {
        if (score[0] == 0) {
            answers[0] = false;
        }

        solveQuestion();
    }

    public void solveQuestion() {
        score[1]++;
        question();
    }

    public void checkAnswer(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.checkA:
                if (checked) {
                    checkBoxOne[0] = true;
                } else if (!checkBoxOne[0]) {
                    checkBoxOne[0] = false;
                }
                break;
            case R.id.checkB:
                if (checked) {
                    checkBoxOne[1] = true;
                } else if (!checkBoxOne[1]) {
                    checkBoxOne[1] = false;
                }
                break;
            case R.id.checkC:
                if (checked) {
                    checkBoxOne[2] = true;
                } else if (!checkBoxOne[2]) {
                    checkBoxOne[2] = false;
                }
                break;
            case R.id.checkD:
                if (checked) {
                    checkBoxOne[3] = true;
                } else if (!checkBoxOne[3]) {
                    checkBoxOne[3] = false;
                }
                break;
        }
    }

    public void checkSolution(View view) {
        if (score[1] == 1) {
            Boolean[] solutionOne = {false, true, false, false};
            if (checkBoxOne == solutionOne) {
                answers[1] = true;
            } else {
                answers[1] = false;
            }
        }

        score[1]++;
        question();
    }

    public void radioAnswer(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.radioA:
                if (checked) {
                    radioOption[0] = true;
                } else if (!radioOption[0]) {
                    radioOption[0] = false;
                }
                break;
            case R.id.radioB:
                if (checked) {
                    radioOption[1] = true;
                } else if (!radioOption[1]) {
                    radioOption[1] = false;
                }
                break;
            case R.id.radioC:
                if (checked) {
                    radioOption[2] = true;
                } else if (!radioOption[2]) {
                    radioOption[2] = false;
                }
                break;
            case R.id.radioD:
                if (checked) {
                    radioOption[3] = true;
                } else if (!radioOption[3]) {
                    radioOption[3] = false;
                }
                break;
            case R.id.radioE:
                if (checked) {
                    radioOption[4] = true;
                } else if (!radioOption[4]) {
                    radioOption[4] = false;
                }
                break;
        }

    }

    public void radioSolution(View view) {
        if (score[1] == 2) {
            Boolean[] solutionTwo = {true, false, false, false, false};
            if (radioOption == solutionTwo) {
                answers[2] = true;
            } else {
                answers[2] = false;
            }
        }

        score[1]++;
        question();
    }

}
