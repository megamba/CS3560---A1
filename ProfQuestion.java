/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class ProfQuestion {
    private Scanner keyboard;

    public ProfQuestion() {
    }

    //prompts user to make a question type, number of users, and a correct answer
    public Question getQuestion(Professor prof){
        keyboard = new Scanner(System.in);
        String questionPrompt = questionPrompt();
        int type = questionType();
        int numOfchoices = numberOfChoices();
        List<String> choices = questionChoices(numOfchoices);
        Question question = getQuestion(prof, questionPrompt, type, numOfchoices, choices);
        return question;
    }

    //prompts user to write a new question
    private String questionPrompt(){
        System.out.println("\nEnter question:\n");
        String questionPrompt = keyboard.nextLine();
        return questionPrompt;
    }
    
    //promts user to submit a question type: multiple answers or single answer
    private int questionType(){
        System.out.println("\nType of question:\n" +
                            "1. Single Answer\n" +
                            "2. Multiple Answers");
        int type = Character.getNumericValue(keyboard.nextLine().charAt(0));
        if (type != 1 && type != 2){
            System.out.println(type + " invalid");
        }
        return type;
    }

    //prompts user to input the number of choices this question will have
    private int numberOfChoices(){
        System.out.println("\nEnter number of choices:");
        int numOfchoices = (int)Integer.parseInt(keyboard.nextLine());
        if (numOfchoices < 2 || numOfchoices > 7){
            System.out.println(numOfchoices + " invalid");
        }
        return numOfchoices;
    }
   
    // a list of all the choices in this question
    private List<String> questionChoices(int numOfchoices){
        List<String> choices = new ArrayList<String>(numOfchoices);
        for (int i = 0; i < numOfchoices; i++) {
            System.out.println("Enter choice #" + (i+1));
            String choice = keyboard.nextLine();
            choices.add(choice);
        }
        return choices;
    }

    //makes the question based on all the information gathered from the other methods in this class
    public Question getQuestion(Professor prof, String questionPrompt, int type, int numOfchoices, List<String> choices){
       Question question;
        if(type == 1){
            question = new SCQuestion(prof, questionPrompt, numOfchoices, choices);
        }
        else{
            question = new MCQuestion(prof, questionPrompt, numOfchoices, choices);
        }
        return question;
    }
}
