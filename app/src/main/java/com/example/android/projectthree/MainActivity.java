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

public class MainActivity extends AppCompatActivity {

    //holds the score, question number
    int[] score = {0, 1};

    //holds the answers given in the checkbox
    Boolean[] checkBoxOne = new Boolean[4];

    //holds the answer given in the radio (forces a change to true on the selected)
    Boolean[] radioOption = {false, false, false, false, false};

    //holds the answers given by the player (first one, answers[0], is ignored to make it easier to work with)
    Boolean[] answers = new Boolean[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //we're working with a single activity so let's make things easy by playing with setVisibility gone and visible

    //first method ("screen") is a small intro to the quiz
    public void agree(View view) {
        RelativeLayout intro = this.findViewById(R.id.intro);
        intro.setVisibility(View.GONE);

        question();
    }

    //second method handles the questions, answers and their display
    //each if handles a different screen
    //and it also handles the display of the score after all the questions are answered since it can be done with a quick follow up
    public void question() {

        if (score[1] == 1 || score[1] == 7) {

            LinearLayout buttonQuestion = this.findViewById(R.id.button);
            buttonQuestion.setVisibility(View.VISIBLE);

            TextView textButton = this.findViewById(R.id.questionButton);

            Button buttonA = this.findViewById(R.id.buttonA);
            Button buttonB = this.findViewById(R.id.buttonB);
            Button buttonC = this.findViewById(R.id.buttonC);
            Button buttonD = this.findViewById(R.id.buttonD);

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

            LinearLayout checkQuestion = this.findViewById(R.id.checkbox);
            checkQuestion.setVisibility(View.VISIBLE);

            TextView textCheck = this.findViewById(R.id.questionCheck);

            CheckBox checkBoxA = this.findViewById(R.id.checkA);
            CheckBox checkBoxB = this.findViewById(R.id.checkB);
            CheckBox checkBoxC = this.findViewById(R.id.checkC);
            CheckBox checkBoxD = this.findViewById(R.id.checkD);

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
            LinearLayout radioQuestion = this.findViewById(R.id.radio);
            radioQuestion.setVisibility(View.VISIBLE);

            TextView textRadio = this.findViewById(R.id.questionRadio);

            RadioButton radioA = this.findViewById(R.id.radioA);
            RadioButton radioB = this.findViewById(R.id.radioB);
            RadioButton radioC = this.findViewById(R.id.radioC);
            RadioButton radioD = this.findViewById(R.id.radioD);
            RadioButton radioE = this.findViewById(R.id.radioE);

            if (score[1] == 3) {

                textRadio.setText(getString(R.string.questionThree));
                radioA.setText(getString(R.string.answer3_1));//correct answer
                radioB.setText(getString(R.string.answer3_2));
                radioC.setText(getString(R.string.answer3_3));
                radioD.setText(getString(R.string.answer3_4));
                radioE.setText(getString(R.string.answer3_5));
            }
            if (score[1] == 6) {

                textRadio.setText(getString(R.string.questionSix));
                radioA.setText(getString(R.string.answer6_1));
                radioB.setText(getString(R.string.answer6_2));
                radioC.setText(getString(R.string.answer6_3));
                radioD.setText(getString(R.string.answer6_4));
                radioE.setText(getString(R.string.answer6_5));//correct answer

            }
        }

        if (score[1] == 4 || score[1] == 8) {
            LinearLayout editQuestion = this.findViewById(R.id.editText);
            editQuestion.setVisibility(View.VISIBLE);

            TextView textEdit = this.findViewById(R.id.questionEdit);

            if (score[1] == 4) {
                textEdit.setText(getString(R.string.questionFour));
            }
            if (score[1] == 8) {
                textEdit.setText(getString(R.string.questionEight));
            }
        }

        if (score[1] == 9) {
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
            score[0] *= 12.5;

            Toast.makeText(this, getString(R.string.finalScore) + score[0] + getString(R.string.maxScore), Toast.LENGTH_LONG).show();
        }
    }

    //the following four methods handle the button presses on the screen with button choices
    public void buttonA(View view) {

        if (score[1] == 1) {
            answers[1] = true;
        }
        if (score[1] == 7) {
            answers[1] = false;
        }

        solveQuestion();
    }

    public void buttonB(View view) {

        if (score[1] == 1) {
            answers[1] = false;
        }
        if (score[1] == 7) {
            answers[1] = true;
        }

        solveQuestion();
    }

    public void buttonC(View view) {

        if (score[1] == 1) {
            answers[1] = false;
        }
        if (score[1] == 7) {
            answers[1] = false;
        }

        solveQuestion();
    }

    public void buttonD(View view) {

        if (score[1] == 1) {
            answers[1] = false;
        }
        if (score[1] == 7) {
            answers[1] = false;
        }

        solveQuestion();
    }

    //and this method is the follow up to them
    //the mid-term man that takes care to make it jump to the next question after hiding this "screen"
    public void solveQuestion() {

        score[1]++;

        LinearLayout buttonQuestion = this.findViewById(R.id.button);
        buttonQuestion.setVisibility(View.GONE);

        question();
    }

    //method to handle the checkbox questions
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

    //and this one is the follow up to see if the player got it right or not
    //also takes care of hiding this "screen" after being used and jumps back to the question method
    public void checkSolution(View view) {

        if (score[1] == 2) {
            Boolean[] solutionTwo = {false, true, false, false};
            if (checkBoxOne == solutionTwo) {
                answers[2] = true;
            } else {
                answers[2] = false;
            }
        }

        if (score[1] == 5) {
            Boolean[] solutionFive = {true, true, false, false};
            if (checkBoxOne == solutionFive) {
                answers[5] = true;
            } else {
                answers[5] = false;
            }
        }

        score[1]++;

        LinearLayout checkQuestion = this.findViewById(R.id.checkbox);
        checkQuestion.setVisibility(View.GONE);

        question();
    }

    /**Falta tratar do resto das descrições e testar a app para ver se tudo funciona bem**/
    public void radioAnswer(View view) {

        boolean checked = ((RadioButton) view).isChecked();

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

        if (score[1] == 3) {
            Boolean[] solutionThree = {true, false, false, false, false};
            if (radioOption == solutionThree) {
                answers[3] = true;
            } else {
                answers[3] = false;
            }
        }

        if (score[1] == 6) {
            Boolean[] solutionSix = {false, false, false, false, true};
            if (radioOption == solutionSix) {
                answers[6] = true;
            } else {
                answers[6] = false;
            }
        }

        score[1]++;

        LinearLayout radioQuestion = this.findViewById(R.id.radio);
        radioQuestion.setVisibility(View.GONE);

        question();
    }

    public void editSolution(View view) {

        EditText answerGiven = this.findViewById(R.id.editAnswer);
        answerGiven.getText();

        String solutionEdit = String.valueOf(answerGiven);

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

        LinearLayout editQuestion = this.findViewById(R.id.editText);
        editQuestion.setVisibility(View.GONE);

        question();
    }

    public void restart(View view) {

        score[0] = 0;
        score[1] = 1;

        question();

    }

}
