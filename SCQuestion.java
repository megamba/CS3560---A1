/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A1;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class SCQuestion extends Question implements StudentAnswer{
    private SCQuestion copy;
    private int studentAnswer;

    public SCQuestion(Professor prof, String questionPrompt, int numOfchoices, List<String> choices) {
        super(prof, questionPrompt, numOfchoices, choices);
    }

    public void setStudentAnswer(Student student, boolean simulation){
        // voterAnswer: a random int from first to last choice of question
        if(student == getStudent() && simulation){
            Random random = new Random();
            this.studentAnswer = random.nextInt(this.getChoiceCount()) + 1;
            //System.out.printf("Voter %4s choice : %2d\n", voter.getID(), voterAnswer);
        }
        else if (student == getStudent()){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter the choice # of the answer:");
            this.studentAnswer = (int) Integer.parseInt(keyboard.nextLine());
        }
        else {
            throw new RuntimeException("Not authorized to vote on question.");
        }

    }

    public void getStudentAnswer(VotingService stats){
        int[] answers = stats.getAnswers();
        answers[studentAnswer-1]++;
        stats.setAnswers(answers);
    }
    
}
