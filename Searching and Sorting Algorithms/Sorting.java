public class Sorting{
	public static void main(String[] args){
		int arr[] = {3, 5, 9, 0, 3, 2, 10, 23, 4, 6};
		selectionSort(arr); //max to min
		selectionSort2(arr); // min to max

	}
	public static void selectionSort(int[] arr){
		//Selection Sort
		//finds the smallest value and swaps with current index

		for(int i = 0; i < arr.length; i++){
			for(int k = i+1; k < arr.length; k++){
				if(arr[i] < arr[k]){
					int temp = arr[i];
					arr[i] = arr[k];
					arr[k] = temp;
				}

			}
		}
		System.out.println("Selection Sort: ");
		printArr(arr);
	}

	public static void selectionSort2(int[] arr){
		for(int i = 0; i < arr.length -1; i++){
			int min = i;

			for(int j = 1; j<arr.length; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
		int temp = arr[0];
		arr[0] = arr[min];
		arr[min] = temp;
		}
		System.out.println("\nSelection Sort 2: ");
		printArr(arr);
	}



	public static void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}