import java.util.Arrays;
public class Lab1{

	public static void main (String[] args)
	{
		GradeCalculator studentA = new GradeCalculator();
		final int size = 10;
		double [] quizArray = new double[size];
		double [] assignmentArray = new double[size];
		
		quizArray[0] = 80;
		quizArray[1] = 100;
		quizArray[2] = 100;
		quizArray[3] = 100;
		quizArray[4] = 90;
		quizArray[5] = 100;
		quizArray[6] = 100;
		quizArray[7] = 100;
		quizArray[8] = 103;
		quizArray[9] = 100;
		
		assignmentArray[0] = 100;
		assignmentArray[1] = 96;
		assignmentArray[2] = 100;
		assignmentArray[3] = 100;
		assignmentArray[4] = 100;
		assignmentArray[5] = 100;
		assignmentArray[6] = 95;
		assignmentArray[7] = 100;
		assignmentArray[8] = 100;
		assignmentArray[9] = 100;
//		
//		Arrays.fill(quizArray,80.0 );
//		Arrays.fill(assignmentArray, 80.0);
		
		studentA.setFinal(69);
		studentA.setMidterm(117.0);
		studentA.setProject(92.0);
		studentA.setquiz(quizArray);
		studentA.setassignment(assignmentArray);
		
		System.out.println(studentA);
		

	}
}