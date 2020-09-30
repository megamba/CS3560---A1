/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A1;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author miche
 */
public class Student{
    private String id;
    private int studentAnswer;
    private Map<String, Question> questions = new HashMap<String, Question>();
    
    public Student(String id){
        setID(id);
    }
    
    public void setID(String id) {
        if (this.id == null) {
        String suuid = UUID.randomUUID().toString();
        id = suuid;
        } else {
            throw new RuntimeException("Cannot set id twice.");
        }
    }
    
    public String getID() {
        return this.id;
    }
    
    public int setStudentMCAnswer(){
        studentAnswer = (int)(Math.random()*(3-0+1)+0); //0=A, 1=B, 2=C, 3=D
        return studentAnswer;
    }
    
    public int setStudentSCAnswer(){
        studentAnswer = (int)(Math.random()*(1-0+1)+0); //0=True 1=False
        return studentAnswer;
    }
    
    public void addQ(String ID, Question question){
        question.setStudent(this);
        questions.put(ID, question);
    }

    public void castVote(String ID) {
        
        StudentAnswer a = (StudentAnswer)questions.get(ID);
        a.setStudentAnswer(this, true);
        questions.put(ID, (Question) a);
        
    }

    public Question submitVote(String ID){
        return questions.get(ID);
    }

    public void removeQ(String ID){
        questions.remove(ID);
    }

    
}
