/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A1;

import java.util.List;

/**
 *
 * @author miche
 */
public class Question {
    private Professor prof;
    private Student student;
    private String questionPrompt;
    private List<String> choices;
    private int numOfchoices;

    public Question(Professor prof, String questionPrompt, int choiceCount, List<String> choices) {
        setProf(prof);
        setQuestionPrompt(questionPrompt);
        setChoiceCount(choiceCount);
        setChoices(choices);
    }

    public Professor getProf() {
        return prof;
    }

    private void setProf(Professor prof) {
        this.prof = prof;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        if (getStudent() == null || getStudent() == student) {
            this.student = student;
        }
        else{
            throw new RuntimeException("Cannot change the voter of the question.");
        }
    }

    public List<String> getChoices() {
        return choices;
    }

    private void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public int getChoiceCount() {
        return numOfchoices;
    }

    private void setChoiceCount(int numOfchoices) {
        this.numOfchoices = numOfchoices;
    }

    public String getQuestionPrompt() {
        return questionPrompt;
    }

    private void setQuestionPrompt(String questionPrompt) {
        this.questionPrompt = questionPrompt;
    }
    
    /*
    public Question copy(Question question){
        
        Question copyQuestion;
        if(question instanceof SCQuestion){
            copyQuestion = new SCQuestion(question.getProf(),
                    question.getQuestionPrompt(), question.getChoiceCount(), question.getChoices());
        }
        else {
            copyQuestion = new MCQuestion(question.getProf(),
                    question.getQuestionPrompt(), question.getChoiceCount(), question.getChoices());
        }   
        
        return copyQuestion;
    }
    */
    
}
