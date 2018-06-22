
public class Result implements Comparable{
	int sum;
	int initialIndex;
	int finalIndex;
	
	public Result(int sum, int initialIndex, int finalIndex) {
		this.sum = sum;
		this.initialIndex = initialIndex;
		this.finalIndex = finalIndex;
	}
	@Override
	public int compareTo(Object o) {
		try {
			if (this.sum < ((Result) o).sum) {
				return -1;
			} else if (this.sum == ((Result) o).sum) {
				return 0;
			} else {
				return 1;
			}
		} catch (NullPointerException b) {
			System.out.println("Empty object was passed in.");
		} catch (ClassCastException c) {
			System.out.println("casting object failed.");
		}
		return 0;
	}

	
}
