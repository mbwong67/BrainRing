package voytenko.nsu.android.brainring;

import java.util.UUID;

public class Question {

    private final UUID uuid;

    private final String correctAnswer;
    private final String questionText;


    private final String option1;
    private final String option2;
    private final String option3;
    private final String option4;

    public Question(String questionText, String correctAnswer,
                    String option1, String option2, String option3, String option4){

        this.uuid = UUID.randomUUID();
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }


}
