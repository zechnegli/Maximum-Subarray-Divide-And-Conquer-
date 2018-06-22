
public class MaximumSubArray {

	public MaximumSubArray() {
		
	}
	
	public Result findMaximumSubArray(int[] array, int low, int high) {
		System.out.println("low: " + low + "   high: " + high );
		//base case:
		 if (low == high) {
			Result result = new Result(array[high], high, high);			
			return result;
		}
		int mid = (high + low) / 2; 
		
		Result leftResult = this.findMaximumSubArray(array, low, mid);
	
		Result rightResult = this.findMaximumSubArray(array, mid + 1, high);
		
		Result crossingResult = this.findCrossingMaximumMidPointSum(low, high, mid, array);
		System.out.println("leftResult: " + leftResult.sum + " rightResult: " + rightResult.sum + " crossingReuslt: " + crossingResult.sum + " low: " + low + " high: " + high);
		if (leftResult.compareTo(rightResult) > 0) {
			if (leftResult.compareTo(crossingResult) > 0) {
				return leftResult;
			}
			return crossingResult;
		} else {
			if (rightResult.compareTo(crossingResult) > 0) {
				return rightResult;
			}
			return crossingResult;
		}
		
 
		
//		if ((high - low) == 1) {
//			if (array[high] > 0 && array[low] > 0) {
//				Result result = new Result(array[high] + array[low], low, high);
//				return result;
//			} else if (array[high] > 0 && array[low] < 0) {
//				Result result = new Result(array[high], high, high);
//				return result;
//			} else if (array[high] < 0 && array[low] > 0) {
//				Result result = new Result(array[low], low, low);
//				return result;				
//			} else {
//				return new Result(0, 0, 0);
//			}
//		} else
	}
	
	public Result findCrossingMaximumMidPointSum(int low, int high, int mid, int[] array) {
		System.out.println("================");
		int leftMaximum = - Integer.MAX_VALUE;
		int leftSum = 0;
		int leftMaximumIndex = mid;
		
		for (int leftIndex = mid; leftIndex >= 0; leftIndex--) {
			if ((leftSum + array[leftIndex]) >= leftMaximum) {
				leftMaximumIndex = leftIndex;
				leftSum += array[leftIndex];
			}
		}
		
		int rightMaximum = - Integer.MAX_VALUE;
		int rightSum = 0;
		int rightMaximumIndex = mid + 1;
		
		for (int rightIndex = mid + 1; rightIndex < array.length; rightIndex++) {
			if ((rightSum + array[rightIndex]) >= rightMaximum) {
				rightSum += array[rightIndex];
				rightMaximumIndex = rightIndex;
			}
			 
		}
			
		int totalSum = leftSum;
		boolean isIncludeRightIndex = false;
		boolean isIncludeBothIndex = false;
		boolean isIncludeLeftIndex = true;
		if ((totalSum + rightSum) > totalSum && (totalSum + rightSum) > rightSum) {
			totalSum += rightSum;
			isIncludeBothIndex = true;
		} else if ((totalSum + rightSum) > totalSum && (totalSum + rightSum) < rightSum) {
			totalSum = rightSum;
			isIncludeLeftIndex = false;
			isIncludeRightIndex = true;
		}
		
		System.out.println("low: " + low + " high: " + high + " leftSum" + leftSum + " rightSum" + rightSum);
		if (isIncludeBothIndex) {
			return new Result(totalSum, leftMaximumIndex, rightMaximumIndex);
		} else {
			if (isIncludeLeftIndex) {
				return new Result(totalSum, leftMaximumIndex, mid);
			} else {
				return new Result(totalSum, mid+1, rightMaximumIndex);
			}
			
		}
		
	}
		
		
		
		
		
		
	

}
