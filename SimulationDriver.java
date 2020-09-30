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
public class SimulationDriver {
    private VotingService iVote;
    private Professor prof = new Professor("01234abcd");
    private Question question;
    
    public void VotingServiceStart(){
        iVote = new VotingService();
    }
    
    public void createStudents(int count){
        for (int s = 0; s < count; s++) {
            Student student = new Student(iVote.nextStudentID());
            iVote.registerStudent(student);
        }
    }
    
    public void createQuestion(){
        question = prof.createQuestion();
        iVote.submitQ(prof.getID(), question);
    }

    public void votingRound(int round){
        System.out.println("\nQuestion # " + round);
        List<Student> students = iVote.getStudents();
        for(Student student: students){
            student.castVote(prof.getID());
        }
    }

    public void getStudentStatistics(){
        System.out.println("Statistics:");
        iVote.getStudentStatistics(prof.getID(), question);
    }

    public void endVoting(){
        iVote.endVote(prof.getID());
    }

    public static void main(String[] args) {
        
        SimulationDriver driver = new SimulationDriver();
        driver.VotingServiceStart();
        driver.createStudents((int)(Math.random()*(50-15+1)+15));
        driver.createQuestion();
        driver.votingRound(1);
        driver.getStudentStatistics();
        System.out.println();
        driver.votingRound(2);
        driver.getStudentStatistics();
        driver.endVoting();
    }
}
