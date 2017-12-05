
public class Analysis {
	//private static long totaltime;
	private static long comparisons = 0;
	private static long swaps = 0;


	public static void main(String[] args){
		//Stopwatch time = new Stopwatch();
		int[] sizes = {10,100,1000,10000,100000};
		for (int x = 0; x<sizes.length; x++)
		{
			comparisons = 0;
			swaps = 0;
			
			for (int i = 0; i < 10; i++){
				//time.start();
				Sorts.quickSort(ArrayGen.nearlySortedArray(sizes[x]));
				//Sorts.quickSort(ArrayGen.nearlySortedArray(sizes[x]));
				//time.stop();
				//totaltime += time.getElapsedTime();
				comparisons += Sorts.getCompareCount();
				swaps += Sorts.getSwapCount();
				
			}
			//System.out.println(totaltime/10.0);     
			System.err.println("Size " + sizes[x] +"\n");
			System.out.println("Comparisons " + comparisons/10.0);
			System.out.println("Swaps " + swaps/10.0 + "\n");
		}
	}
}
