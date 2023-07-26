package com.example.quiz_assignment;

public class Question_Item {
    private String question;
    private String answer;

    // Constructor to create a Question_Item object with a question and its answer
    public Question_Item(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Method to get the question from the Question_Item object
    public String getQuestion() {
        return question;
    }

    // Method to get the answer from the Question_Item object
    public String getAnswer() {
        return answer;
    }
}
