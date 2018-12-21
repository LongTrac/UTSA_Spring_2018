/**
 *@author Long Trac 
 * This class is a grade calculate for the application programming course
 */
import java.util.*;
public class GradeCalculator{
	
	private final int size =10;
	
	private double midTerm  ;
	private double finalTest ;
	private double project ;
	private double[] quiz;
	private double[] assignment;
	
	/**
	 * This is the constructor that takes no parameters
	 */
	public GradeCalculator( ) 
	{	midTerm = 0;
		finalTest = 0;
		project = 0;
		quiz = new double [size];
		assignment = new double[size];
	}
	
	
	
	/**
	 * This is a toString function that takes no parameters and return 
	 * a string representation of the student summary
	 * 
	 * @return String - a formatted summary of all the grade of a student
	 */
	public String toString()
	{
		return String.format("\r\n" + 
				"Lab average:" + this.calAvgAssignment() +" \r\n"+ 
				"Quiz average:"+ this.calAvgQuiz() + "\r\n" +
				"Team project:"+ this.getProject()+ "\r\n" + 
				"Midterm exam:"+ this.getMidterm()+"\r\n" + 
				"Final exam:"+this.getFinal() +"\r\n" + 
				"-------------------\r\n" + 
				"Final grade in *this course is "+ this.calculateLetterGrade() +
				" (" + Math.round(this.calculateFinalGrade()*100.0)/100.0 +"). ");
				// a little bit rounding for 2 decimal point format

	}
	
	/**
	 * This function's purpose is to calculate the average quiz grade.
	 * This function takes no parameters and returns a quiz average
	 * @return double - an average value of 10 quizzes
	 */
	public double calAvgQuiz()
	{
	
		double total =0;
		for(int i = 0; i<quiz.length; i++)
		{
			total += quiz[i];
		}
		return (total/quiz.length);
	}
	
	/**
	 * This function's purpose is to calculate the average assignment grade.
	 * This function takes no parameters and returns an assignment average
	 * @return double - an average value of 10 assignments
	 */
	public double calAvgAssignment()
	{
		double total =0;
		for(int i = 0; i<assignment.length; i++)
		{
			total += assignment[i];
		}
		return (total/assignment.length);
	}
	
	/**
	 * This function's purpose is to calculate the average of the course.
	 * This function takes no parameters and returns the course average
	 * @return double - an average gradefor the whole course
	 */
	public double calculateFinalGrade()
	{
		return ((midTerm *0.2)+(finalTest*0.25)+(project*0.2)+
				(calAvgQuiz()*0.1)+(calAvgAssignment()*0.25));
	}
	
	/**
	 * This function's purpose is to assign the letter grade.
	 * This function takes no parameters and returns a char
	 * @return char - a letter grade for the course
	 */
	public char calculateLetterGrade()
	{
		if(calculateFinalGrade()<60)
			return ('F');
		else if(calculateFinalGrade()<70)
			return ('D');
		else if(calculateFinalGrade()<80)
			return ('C');
		else if(calculateFinalGrade()<90)
			return ('B');
		else
			return ('A');
		
	}


/////////////////////setter and getter //////////////////////////
	/**
	 * This setter function set the value for the Mid Term
	 * @param inputMid - value of the mid term score
	 */
	public void setMidterm (double inputMid)
	{
		midTerm =inputMid;
	}
	
	/**
	 * This setter function set the value for the Final
	 * @param inputFinal - value of the Final score
	 */
	public void setFinal (double inputFinal)
	{
		finalTest = inputFinal;
	}
	
	/**
	 * This setter function set the value for the project
	 * @param inputProject - value of the project score
	 */
	
	public void setProject(double inputProject)
	{
		project = inputProject;
	}
	
	/**
	 * This setter function set the value for quiz array
	 * @param quizList - an array full of quiz scores
	 */
	public void setquiz (double[] quizList)
	{
		for(int i = 0; i< quizList.length; i++)
		{
			quiz[i]= quizList[i];
		}
	}
	
	/**
	 * This setter function set the value for the assignment array
	 * @param assignList - an array full of assignment scores
	 */
	public void setassignment (double[] assignList)
	{
		for(int i = 0; i< assignList.length; i++)
		{
			assignment[i]= assignList[i];
		}
	}
		
	/**
	 * this	getter function return the score of the mid term 
	 * @return midTerm - the score of midterm
	 */
	public double getMidterm ()
	{
		return midTerm;
	}
	
	/**
	 * this	getter function return the score of the final
	 * @return finalTest - the score of the final
	 */
	public double getFinal()
	{
		return finalTest;
	}
	
	/**
	 * this	getter function return the score of the project
	 * @return project - the score of the project
	 */
	public double getProject()
	{
		return project;
	}
	
	/**
	 * this	getter function return the quiz array
	 * @return quiz - the quiz array
	 */
	public double[] getquiz()
	{
		return quiz;
	}
	
	/**
	 * this	getter function return the assignment array
	 * @return assignment - the assignment array
	 */
	public double[] getassignment()
	{
		return assignment;
	}
}
