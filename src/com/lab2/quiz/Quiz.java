package com.lab2.quiz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Quiz class which allows users to pass simple tests.
 * @author Artem Meniak
 * @version 1.0
 */
public class Quiz {
    /** ArrayList object for storing questions. */
    private ArrayList <String> questions = new ArrayList<>();

    /** ArrayList object for storing answers. */
    private ArrayList <String> answers = new ArrayList<>();

    /** Scanner object for reading from stream. */
    private Scanner scanner = new Scanner(System.in);

    /** Variable for storing students mark. */
    private int mark = 0;

    /**
     * Constructor, which creates object with predefined questions.
     */
    Quiz() {
        addPredefinedQuestions();
    }

    /**
     * Method for adding questions and answers.
     */
    public void addQuestion() {
        System.out.print("Enter your question: ");
        questions.add(scanner.nextLine());
        System.out.print("Enter answer: ");
        answers.add(scanner.nextLine());
    }

    /**
     *  Method for getting list of all questions.
     */
    public void getAllQuestions() {
        System.out.println("Here is all questions:");
        for (String question:questions) {
            System.out.println((questions.indexOf(question) + 1) + ": " + question);
        }
    }

    /**
     * Method for reading answer from input stream.
     * @return String which is read from stream.
     */
    private String getAnswer() {
        System.out.print("Your answer is: ");
        return scanner.nextLine();
    }

    /**
     * Method for checking one answer. If <b>answer</b> param is
     * equal to <b>answers</b> element at <b>index</b> - the answer is
     * correct and <b>mark</b> is incremented.
     * @param answer String which contains students answer.
     * @param index Index of the question.
     */
    private void checkAnswer(String answer, int index) {
        if (answer.equals(answers.get(index))) {
            mark++;
        }
    }

    /**
     * Method for getting mark in percentage.
     * @return String value of percents.
     */
    private String getPercents() {
        return mark * 100 / questions.size() + "%";
    }

    /**
     * Method for adding some predefined questions for the test.
     */
    private void addPredefinedQuestions() {
        questions.add("Amount of angles is triangle");
        answers.add("3");
        questions.add("PI number");
        answers.add("3.14");
        questions.add("Authors name");
        answers.add("Artem");
    }

    /**
     * Method for testing students knowledge.
     */
    public void startTesting() {
        if (questions.size() != answers.size()) {
            System.out.println("Wrong amount of questions or answers!");
            System.exit(0);
        }
        for (String question:questions) {
            System.out.println((questions.indexOf(question) + 1)  + ": " + question);
            checkAnswer(getAnswer(), questions.indexOf(question));
        }
        System.out.println("Thank you for attention! You gained " + getPercents() + "!");
    }
}
