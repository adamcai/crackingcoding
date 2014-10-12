package ch9Recursion;

public class RunningChild {
	
	public static int[] availableSteps = {1,2,3};

	public static int countTotalWays(int totalStairs){
		if(totalStairs < availableSteps[0]){
			return 0;
		}

		int numOfTotalWays = 0;
		for(int step:availableSteps){
			if (totalStairs == step){
				numOfTotalWays += 1;
			}
			int nextAvailableSteps = countTotalWays(totalStairs - step);
			numOfTotalWays += nextAvailableSteps;
		}
		return numOfTotalWays;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0; i <= 10; i++){
			System.out.println(Integer.toString(i)+ ": "+ Integer.toString(countTotalWays(i)));
		}
	}


}