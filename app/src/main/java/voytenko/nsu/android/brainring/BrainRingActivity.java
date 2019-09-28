package voytenko.nsu.android.brainring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BrainRingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_ring);

        setupQuestions();
        configureView();

        showNextQuestion();
    }

    private void setupQuestions(){
        QuestionsManager questionsManager = new QuestionsManager();
        questions = questionsManager.questions();
    }

    private void configureView(){
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setMax(questions.size());

        questionProgressNumberTextView = findViewById(R.id.question_progress_number);
        currentQuestionTitleTextView = findViewById(R.id.current_question_title);
        questionTextView = findViewById(R.id.question_text);

        radioGroup = findViewById(R.id.rb_group);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);

        rbOption1 = findViewById(R.id.rb_option_1);
        rbOption2 = findViewById(R.id.rb_option_2);
        rbOption3 = findViewById(R.id.rb_option_3);
        rbOption4 = findViewById(R.id.rb_option_4);

        nextButton = findViewById(R.id.button_next);
        nextButton.setOnClickListener(onNextButtonClickListener);
    }

    private void showNextQuestion(){
        if (++currentQuestionIndex < questions.size()){
            currentQuestion = questions.get(currentQuestionIndex);
            progressBar.setProgress(currentQuestionIndex + 1);

            String currentProgressNumber = (currentQuestionIndex + 1) + "/" + questions.size();
            questionProgressNumberTextView.setText(currentProgressNumber);

            String currentQuestionTitle = "№" + (currentQuestionIndex + 1);
            currentQuestionTitleTextView.setText(currentQuestionTitle);

            questionTextView.setText(currentQuestion.getQuestionText());

            radioGroup.clearCheck();

            rbOption1.setText(currentQuestion.getOption1());
            rbOption2.setText(currentQuestion.getOption2());
            rbOption3.setText(currentQuestion.getOption3());
            rbOption4.setText(currentQuestion.getOption4());


        }
        else {
            Log.d(LOG_TAG, "test passed !");
        }
    }

    private View.OnClickListener onNextButtonClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_next:
                    showNextQuestion();
                    break;
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedOptionId) {

            final String answer;

            switch (checkedOptionId){
                case R.id.rb_option_1:
                    answer = rbOption1.getText().toString();
                    break;

                case R.id.rb_option_2:
                    answer = rbOption2.getText().toString();
                    break;

                case R.id.rb_option_3:
                    answer = rbOption3.getText().toString();
                    break;

                case R.id.rb_option_4:
                    answer = rbOption4.getText().toString();
                    break;

                default:
                    answer = "";
                    break;
            }

            if(currentQuestion.getCorrectAnswer().equalsIgnoreCase(answer)){
                Log.d(LOG_TAG, "correct answer! +100");
            }

        }
    };

    private static final String LOG_TAG = "BrainRingActivity";

    private int currentQuestionIndex = -1;
    private Question currentQuestion;
    private ArrayList<Question> questions;

    /* UI Outlets */
    private RadioGroup radioGroup;
    private RadioButton rbOption1, rbOption2, rbOption3, rbOption4;
    private Button nextButton;
    private ProgressBar progressBar;
    private TextView questionProgressNumberTextView;
    private TextView currentQuestionTitleTextView;
    private TextView questionTextView;
    /* End */
}
