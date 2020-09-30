/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miche
 */
public class VotingService{
    private List<Student> students = new ArrayList<Student>();
    private static int studentCount = 1;
    private boolean allAnswers;
    private int answers[];
    
    public VotingService(){
    }
    
    public VotingService(Question question) {
        setQuestion(question);
    }
     
    public String nextStudentID(){
        String studentID = 's' + Integer.toString(studentCount);
        studentCount++;
        return studentID;
    }

    void registerStudent(Student student){
        this.students.add((Student)student);
    }
   

    public void getStudentStatistics(String profID, Question question){
        VotingService stats = new VotingService(question);
        for(Student student : students){
            stats.countVote(profID, student);
        }
        stats.displayStatistics(question);
    }

    public void endVote(String profID){
        for(Student student : students){
            student.removeQ(profID);
        }
    }

    public List<Student> getStudents(){
        return students;
    }

    private void setQuestion(Question question){
        if(question instanceof SCQuestion){
            setSingleAnswerQuestion(question);
        }
        else if(question instanceof MCQuestion){
            setMultipleAnswerQuestion(question);
        }
    }

    private void setSingleAnswerQuestion(Question question){
        setAllAnswers(false);
        answers = new int[question.getChoiceCount()];
        setAnswers(answers);
    }

    private void setMultipleAnswerQuestion(Question question){
        setAllAnswers(true);
        answers = new int[question.getChoiceCount()];
        setAnswers(answers);
    }

    public void countVote(String profID, Student student){
        if(isAllAnswers()){
            MCQuestion question = (MCQuestion)student.submitVote(profID);
            question.getStudentAnswer(this);
        }
        else{
            SCQuestion question = (SCQuestion)student.submitVote(profID);
            question.getStudentAnswer(this);
        }
    }

    public void displayStatistics(Question question){
        System.out.println("Question:\n" + question.getQuestionPrompt());
        List<String> choices = question.getChoices();
        for(int i = 0; i < question.getChoiceCount(); i++){
            System.out.printf("%3d votes: %2s\n", answers[i], choices.get(i));
        }
    }
    
    public void submitQ(String profID, Question question) {
        QuestionCopier questionCopier = new QuestionCopier();
        for (Student student : students) {
            Question copyQuestion = questionCopier.copy(question);
            student.addQ(profID, copyQuestion);
        }
    }

    public boolean isAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(boolean allAnswers) {
        this.allAnswers = allAnswers;
    }

    public int[] getAnswers() {
        return answers;
    }

    public void setAnswers(int[] answers) {
        this.answers = answers;
    }
    
}
