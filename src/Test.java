public class Test {

	public static void main(String[] args) {
		int[] testArray = {3, 1, -4, 50, 4, 5};
		MaximumSubArray al = new MaximumSubArray();
		Result r = al.findMaximumSubArray(testArray, 0, testArray.length-1);
		System.out.println(r.sum);
		System.out.println("leftMaxIndex: " + r.initialIndex + " rightMaxIndex: " + r.finalIndex);
		
		
		
		
		
		
		
		

		
		
		
	}

}