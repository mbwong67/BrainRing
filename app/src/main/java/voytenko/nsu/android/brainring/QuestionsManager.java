package voytenko.nsu.android.brainring;

import java.util.ArrayList;

public final class QuestionsManager {

    public QuestionsManager(){

    }

    public ArrayList<Question> questions() {
        Question question1 = new Question("Кого колобок встретил вторым?",
                "Волк",
                "Заяц",
                "Лиса",
                "Медведь",
                "Волк");

        Question question2 = new Question("Какой ракеты нет на вооружении России?",
                "Баобаб",
                "Тополь",
                "Верба",
                "Баобаб",
                "Багульник");

        Question question3 = new Question("Что измеряется в м/с^2?",
                "Ускорение",
                "Скорость света",
                "Угловая скорость",
                "Ускорение",
                "Сила");

        Question question4 = new Question("Какой доевнегреческий философ любил повторять:\"Я знаю, что ничего не знаю\"?",
                "Сократ",
                "Сократ",
                "Димокрит",
                "Аристотель",
                "Эпикур");

        Question question5 = new Question("Какое произвище было у Ивана IV?",
                "Грозный",
                "Красивый",
                "Грозный",
                "Добрый",
                "Хмурый");

        Question question6 = new Question("Как называется вьетнамская валюта?",
                "Донг",
                "Донг",
                "Вона",
                "Юань",
                "Доллар");

        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);

        return questions;
    }
}
