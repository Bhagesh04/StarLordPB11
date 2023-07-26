package com.example.quiz_assignment;
import java.util.ArrayList;

public class QuestionModel {
    private ArrayList<Question_Item> questionList;
    private ArrayList<Integer> colorList;

    // Constructor for QuestionModel
    public QuestionModel(ArrayList<Question_Item> questionList, ArrayList<Integer> colorList) {
        this.questionList = questionList;
        this.colorList = colorList;
    }

    // Method to get the list of questions
    public ArrayList<Question_Item> getQuestionList() {
        return questionList;
    }

    // Method to get the list of colors
    public ArrayList<Integer> getColorList() {
        return colorList;
    }
}
