import java.util.Scanner;
public class Stat{
	public static void main(String[] args){
		/*
		This code compares the odds of picking a "door"
		that contains a car out of 3 options
		To doing the same but changing your answer later
		if one of the options are removed

		It does so through simulation, and the odds should be
		33.3% if you stay
		66.6% if you switch
		*/
		Scanner sc = new Scanner(System.in);

		double correct = 0;
		int incorrect = 0;
		int count = 100000;

		String[] options = {"donkey","car","donkey"};

		int max = 3;
		int min = 0;

		int opt = sc.nextInt();


		if(opt == 1){
			int r = (int)(Math.random()*(max));
			while(count > 0){
				if(options[r] == options[1])
					correct++;
				else if(options[r] != options[1])
					incorrect++;
				count--;
				r = (int)(Math.random()*(max-min)+min);
		}
		}
		if(opt == 2){
			int r = (int)(Math.random()*(max));

			while(count > 0){
				if(options[r] == options[1])
					incorrect++;
				else if(options[r] != options[1])
					correct++;
				count--;
				r = (int)(Math.random()*(max-min)+min);
			}
		}
		System.out.println(correct + "/" + incorrect);
		double percent = 100*(correct/100000);
		System.out.println(percent);
	}
}