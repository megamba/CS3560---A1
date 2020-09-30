/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A1;

/**
 *
 * @author miche
 */
public class Professor{
    private ProfQuestion profq;
    private final String profID;

    public Professor(String profID) {
        this.profID = profID;
        profq = new ProfQuestion();
    }
    
    public String getID() {
        return this.profID;
    }

    public Question createQuestion() {
        Question question = profq.getQuestion(this);
        return question;
    }
}
