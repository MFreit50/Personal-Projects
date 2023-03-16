public class Searching{
	public static void main(String[] args){

		double[] arr = {3,5,6,8,15,20,25,62};
		double[] arr3 = {2,5,9,4,8,1,6};
		double[] arr4 = {1, 2, 5, 6, 9, 11, 15, 16, 20, 34, 43, 45, 53, 58, 60};
		double[] arr2 = {3,5,6,8,15,20,25,62,306,23,12490,14290,90253,9124,90532,40912,5392,40129,50932,41092,25309,42109,5209,13240,6390,3259,963,9,2509,69,90,2509,907,90,9250,9074,90,952,70946};
		//Linear Search (Brute Force/Search)
		System.out.println("Linear Search: " + linearSearch(arr,20));
		//Linear Search on a sorted array
		System.out.println("Linear Search: " + linearSearch(arr,20));
		//test sorted array
		System.out.println("Test Search: " + test(arr2,41092.0));


		//insertion sort
		insertionSort(arr3);
		//binary searching
		System.out.println("\nBinary Search: " + binarySearch(arr4, 11));
	}
	public static boolean linearSearch(double[] arr, double key){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == key){
				return true;
			}
		}
		return false;
	}
	public static boolean linearSearchSorted(double[] arr, double key){
		//Because array is sorted, we can assume that if we reach a value that is 
		//bigger than key, the key does not exist in the array
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == key)
				return true;
			else if(arr[i] > key)
				return false;
			/*
			else if(i+1 != arr.length && arr[i] > key)
				return false;
			*/
		}
		return false;
	}
	public static boolean test(double[] arr, double key){
		for(int i = 0; i < arr.length/2; i++){
			if(arr[i] == key || arr[arr.length-1-i] == key || arr[(arr.length/2)-1-i] == key || arr[(arr.length/2)-1+i] == key)
				return true;
		}
		return false;
	}
	public static void insertionSort(double[] arr){
			//{2,5,9,4,8,1,6};
			// 0 1 2 3 4 5 6

		for(int i = 1; i<arr.length; i++){ //i == 1 because j == i-1
			double currentElement = arr[i]; //stores a number that will be moved so it does not get overwritten
			int j;
			for(j = i-1; j>=0 && arr[j] > currentElement; j--){
				arr[j+1] = arr[j]; // moves a sorted element down by one
			}
			arr[j + 1] = currentElement;
		}
		printArr(arr);
	}
	public static boolean binarySearch(double[] arr, double key){
		//works for sorted arrays
		int low = 0; //1
		int high = arr.length-1; //60

		while(high>=low){
			int mid = (low + high)/2;//midpoint of low and high
			if(arr[mid] == key){
				return true;
			}else if(key < arr[mid]){ //if mid is lower than key, high cannot be correct
				high = mid-1;
			}else{
				low = mid + 1; //if mid is too low, low has to go up to mid.
			}
		}
		return false;
	}
		public static void printArr(double[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}
}