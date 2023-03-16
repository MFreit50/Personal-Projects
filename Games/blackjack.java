import java.util.Scanner;
public class blackjack{
	public static void main(String[]args){

	/*
		arr = draw("a","a","a","a","a","a","a","a","0","0","t");
					0   1   2   3   4   5   6   7   8   9   10

		Size is 11

		0-7 = slots for holding cards
		8 = count of how many cards were drawn (only used for cosmetic purposes so I can make cool print statements)
		9 = total value of all cards held
		10 = return statement, if arr[10] == t the method knows to alter player info

		The order of logic is
		house --> draw --> house --> player --> draw --> player
	*/

	house();
    }
    public static void house(){
    	String[] arr = new String[11];
		arr = draw("a","a","a","a","a","a","a","a","0","0","f"); //decides what arr equals by running method draw
				//( 0   1   2   3   4   5   6   7   8   9  10 )
		//"a" means placeholder string
		//"0" means placeholder int
		//I made placeholders so the program knows how long the array is, but also differentiates number Strings

		String[] house = {"a","a","a","a","a","a","a","a","0","0","0"}; 

		for(int i = 0; i<11; i++){ //passes info arr[] to house[]
			house[i] = arr[i];
		}
        player(house); //sends house[] to method "player"
    }
    public static void player(String[] house){
    	Scanner sc = new Scanner(System.in);
    	String[] arr = new String[11];
    	arr = draw("a","a","a","a","a","a","a","a","0","0","t");

    	/*
    	because there will no longer be any alterations to arr in this stage of the code
    	having a dedicated player array isnt really necessary
    	String[] player = {"a","a","a","a","a","a","a","a","0","0","t"};
    	
    	for(int i = 0; i<11; i++){
			player[i] = arr[i];
			}
		*/
		int houseTotal = Integer.parseInt(house[9]); //takes total from player and house to compare who won;
		int playerTotal = Integer.parseInt(arr[9]);
		//count is only used for print statements, they dont provide any functionality
		int countHouse = Integer.parseInt(house[8]) + 1;
		int countPlayer = Integer.parseInt(arr[8]) + 1;

		System.out.printf("%n----------------------%nYou held...%nThe House drew:%n");
		for(int i = 0; i < countHouse; i++){
			System.out.print(house[i] + " ");
		}
		System.out.printf("%nYou Drew: %n");
			for(int i = 0; i < countPlayer; i++){
			System.out.println(arr[i] + " ");
		}
		System.out.printf("%nYour total is: " + playerTotal + "%nThe House's total is " + houseTotal + "%n----------------------%n");
		if(playerTotal > houseTotal){
			System.out.println("You win");
		}else if(playerTotal < houseTotal){
			System.out.println("You lose");
		}else if(playerTotal == houseTotal){
			System.out.println("Push");
			System.out.println("You Tied");
		}


    }
    public static String[] draw(String a, String b, String c, String d, String e, String f, String g, String h, String i, String j, String l){
    	Scanner sc = new Scanner(System.in);
    	String[] deck = {"2", "3", "4", "5", "6", "7", "8", "9", "A", "10", "J", "Q", "K"};
		//Index 		{ 0    1    2    3    4    5    6    7    8    9    10   11   12};

    	String s = "the House";
    	String w = "Won";
    	String p = "Lost";

    	boolean isPlayer = false;
    	if(l.equals("t")){
    		isPlayer = true;
    		s = "You";
    		w = "Lost";
    		p = "Win";
    		System.out.println("You drew: ");
    	}

    	String[] arr = new String[11];

    	int total = 0;
    	int ace = 0;
    	int draw = 2;
    	int count = -1;

    	int r = (int)(Math.random()*12);
		for(int k = 0; k<draw; k++){
			if (r > 8){
				total += 10;
			}else if (r == 8){
				total += 11;
				ace ++;
			}else if(r < 8){
				total += Integer.parseInt(deck[r]);
			}
			arr[k] = deck[r];
			count++;
			arr[8] = String.valueOf(count);
			arr[9] = String.valueOf(total);
			if(isPlayer==true){
				System.out.print(arr[count]);
			}
			//System.out.println(arr[k] + " ");	if player
			r = (int)(Math.random()*(12));
			/*
			if(isPlayer == false && ace == 0 && total >= 17){
				System.out.printf("%n----------------------%nThe house drew " + (count+=1) + " cards%n");
				System.out.printf("The last card the house drew was " + arr[count-=1] + "%n----------------------%n");
			}
			*/
			if(total > 21 && ace > 0){
					total-=10;
					ace--;
			}else if(total > 21){
				System.out.printf("%n----------------------%n" + s + " busted with%na card value of " +  total + "%n----------------------%n");
				System.out.println("You " + w);
			}else if(total == 21){
				System.out.printf("%n----------------------%n" + s + " drew blackjack %n----------------------%n");
				System.out.println("You " + p);
			}

			if(total == 21 || total > 21){ //before ending the program, it will show what cards were drawn
				System.out.println(s + " drew:");
				for(int x = 0; x < (count + 1); x++){
					System.out.print(arr[x] + " ");
				}
				System.exit(0);
			}
			if(isPlayer == false){
				if(total < 16){
					draw++;
				}else if(total >= 16){
					System.out.printf("%n----------------------%nThe house drew " + (count+=1) + " cards%n");
					System.out.printf("The last card the house drew was " + arr[count-=1] + "%n----------------------%n");
					return arr;
				}
			}

			if(isPlayer == true){
			if(count%2==0 && k!=(draw-1)){
				System.out.print(" and ");
			}
				if(k==(draw-1) && total < 21){
					System.out.printf("%nYour total is " + total + "%nWhat do you do?%n");
					System.out.println("1. Hit");
					System.out.println("2. Hold");
					int option = sc.nextInt();
					if(option == 1){
						draw++;
					}else if(option == 2){
						return arr;
					}
				}
			}
		}
		/*
		this return statement should never be reached

		known reasons for error:
		entering int value for option that isnt 1 or 2
		
		*/
		System.out.println("error, please report");
		System.exit(0);
  		return arr;

	}
}