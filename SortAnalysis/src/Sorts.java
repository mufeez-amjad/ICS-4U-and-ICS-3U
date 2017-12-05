public class Sorts
{

	//Selection

	private static long compareCount;
	private static long swapCount;

	public static long getCompareCount()
	{
		return compareCount;
	}

	public static long getSwapCount()
	{
		return swapCount;
	}

	public static void selectSort(int[] list)
	{
		compareCount = 0;
		swapCount = 0;
		for (int top = list.length - 1; top > 0; top--)
		{
			int largeLoc = 0; // location of largest element
			// assume list[0] is largest to start
			for (int i = 1; i <= top; i++) // check list[1] to list[top]
			{
				compareCount++;
				if (list[i] > list[largeLoc])
				{
					largeLoc = i;
				}
			}
			int temp = list[top]; // temporary storage
			list[top] = list[largeLoc];
			list[largeLoc] = temp;
			swapCount++;
		}
	}



	//Bubble
	public static void bubbleSort (int[] list)
	{
		compareCount = 0;
		swapCount = 0;
		boolean sorted = false;
		for (int top = list.length - 1; top > 0 && sorted == false; top--)
		{
			sorted = true;
			for (int i = 0; i < top; i++)
			{
				compareCount++;
				if (list[i] > list[i+1] )
				{
					sorted = false; // a swap was required
					int temp = list[i];
					list[i] = list[i+1];
					list[i+1] = temp;
					swapCount++;
				}
			}
		}
	}

	//Insertion
	public static void insertSort( int[] list)
	{
		compareCount = 0;
		swapCount = 0;
		for (int top = 1; top < list.length; top++)
		{
			int item = list[top]; // temporary storage of item
			int i = top;
			compareCount++;
			while (i > 0 && item < list[i-1])
			{
				compareCount++;
				// shift larger items to the right by one
				list[i] = list[i-1];
				swapCount++;
				// prepare to check the next item to the left
				i--;
			}
			list[i] = item; // put sorted item in open location
			swapCount++;
		}
	}

	//Mergesort
	public static void mergeSort( int[] a ) 
	{
		compareCount = 0;
		swapCount = 0;
		int[] tmpArray = new int[a.length];
		mergeSort( a, tmpArray, 0, a.length - 1 );
	}

	//Overloaded Mergesort used by the above method
	private static void mergeSort( int[] a, int[] tmpArray, int left, int right )
	{
		if( left < right ) {
			int center = ( left + right ) / 2;
			mergeSort( a, tmpArray, left, center );
			mergeSort( a, tmpArray, center + 1, right );
			merge( a, tmpArray, left, center + 1, right );
		}
	}
	/** Internal method that merges two sorted halves of a subarray. 
	 * @param a an array of int items. 
	 * @param tmpArray an array to place the merged result. 
	 * @param leftPos the left-most index of the subarray. 
	 * @param rightPos the index of the start of the second half. 
	 * @param rightEnd the right-most index of the subarray. 
	 */ 
	private static void merge( int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd )
	{ 
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop 
		while( leftPos <= leftEnd && rightPos <= rightEnd ){
			compareCount++;
			if( a[ leftPos ]<=( a[ rightPos ] )){
				tmpArray[ tmpPos++ ] = a[ leftPos++ ];
				swapCount++;
			}
			else {
				tmpArray[ tmpPos++ ] = a[ rightPos++ ];
				swapCount++;
			}
		}
		while( leftPos <= leftEnd ){ // Copy rest of first half 
			tmpArray[ tmpPos++ ] = a[ leftPos++ ];
			swapCount++;
		}
		while( rightPos <= rightEnd ){ // Copy rest of right half
			tmpArray[ tmpPos++ ] = a[ rightPos++ ];
			swapCount++;
		}
		// Copy tmpArray back 
		for( int i = 0; i < numElements; i++, rightEnd-- ){ 
			a[ rightEnd ] = tmpArray[ rightEnd ];
			swapCount++;
		}

	}


	//Quicksort
	public static void quickSort(int[] arr)
	{
		compareCount = 0;
		swapCount = 0;
		quickSort(arr, 0, arr.length-1);
	}

	//Overloaded Quicksort used by the above method
	private static void quickSort(int[] arr, int left, int right) 
	{ 
		int index = partition(arr, left, right);
		if (left < index - 1) 
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}

	//Internal method that partitions the given array
	private static int partition(int[] arr, int left, int right) 
	{
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2]; 

		while (i <= j) { 
			compareCount++;
			while (arr[i] < pivot){
				compareCount++;
				i++;
			}

			compareCount++;
			while (arr[j] > pivot){ 
				compareCount++;
				j--; 
			}

			if (i <= j) {
				tmp = arr[i]; 
				arr[i] = arr[j];
				arr[j] = tmp;
				i++; 
				j--; 
				swapCount++;
			}
		} 
		return i;
	}

}