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
public class MCQuestion extends Question implements StudentAnswer{
    
    private int[] studentAnswers;

    public MCQuestion(Professor prof, String questionPrompt, int numOfchoices, List<String> choices) {
        super(prof, questionPrompt, numOfchoices, choices);
        studentAnswers = new int[numOfchoices];
    }


    public void setStudentAnswer(Student student, boolean simulation){
        // select: number of choices voter selects from 2 to total number of choices
        // choice: a random int from first to last choice of question
        if(student == getStudent() && simulation){
            Random random = new Random();
            int select = random.nextInt((this.getChoiceCount() - 1)) + 2;
            for(int i = 0; i < select; i++){
                int choice = random.nextInt(this.getChoiceCount()) + 1;
                // keep picking a random choice, if previously chosen
                while(studentAnswers[choice-1] == 1){
                    choice = random.nextInt(this.getChoiceCount()) + 1;
                }
                studentAnswers[choice-1]++;
            }
        }
        else if (student == getStudent()){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter each choice on a line:");
            int choice = (int) Integer.parseInt(keyboard.nextLine());
            while(choice != -1) {
                studentAnswers[choice-1]++;
                choice = (int) Integer.parseInt(keyboard.nextLine());
            }
        }
        else {
            throw new RuntimeException("Not authorized to vote on question.");
        }

    }

    public void getStudentAnswer(VotingService stats){
        int[] answers = stats.getAnswers();
        for(int i = 0; i < studentAnswers.length; i++){
            if(studentAnswers[i] != 0){
                answers[i]++;
                studentAnswers[i] = 0;
            }
        }
        stats.setAnswers(answers);
    }
    
}
