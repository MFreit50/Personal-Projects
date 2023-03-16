import java.util.Scanner;
import java.util.Random;
public class Stat4{
	public static void main(String[] args){
		/*
		this code calculates the odds of a random number (r)
		to calculate up to user input variable (n) consecutively.

		r should not be able to pick the same value twice inside a
		for loop. For example, in the first iteration, r can choose
		any int from 1 up to n.

		If that iteration is successful, in the next iteration, r should
		be able to choose from 2 to n.
		*/


		Scanner sc = new Scanner(System.in);

		System.out.println("insert value for n, and number of iterations");
		int n = Math.abs(sc.nextInt()); //n is the number we will randomly count up too
		long iterations = Math.abs(sc.nextLong()); //number of times this scenario is played out
		sc.close();

		double calculate = calc(n, iterations);

		System.out.println("the calculated odds are: "+calculate); //Mathematically calculates your odds without simulation
	}
	public static double simulate(double fact, long iterations){
		Random random = new Random();
		double correct = 0; //number of times we get a perfect scenario (used for calculating percentages)
		int factorial = (int)fact;

		for(int i = 0; i < iterations; i++){
				int r = random.nextInt(factorial)+1; //r must choose 1 from factorial amount of numbers
				if(r == 1)
					correct++;
		}
	        System.out.println("There were " + (int)correct + " correct instances within " + iterations + " iterations"); //shows amount correct
	        return 100*(correct/iterations); //calculates percentage
	}
	public static double calc(int n, long iterations){
		double factorial = 1.0; //calculates n!
		for(int i = n; i > 1; i--){
			factorial*=i;
		}


		double percentage = simulate(factorial, iterations);
		System.out.println("the simulated odds are: "+percentage); //Calculates your odds through simulation


    	return (100*(1/factorial));
	}
}