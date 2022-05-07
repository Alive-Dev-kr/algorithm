package level2;

import java.util.ArrayList;

public class TruckPassBridge {
	
	static int BRIDGE_ON_TRUCK_WEIGHT = 0;

	public static void main(String[] args) {
		
		//int bridgeLength = 2;
		//int limitWeight = 10;
		//int[] truckWeights = {7, 4, 5, 6};
		
		int bridgeLength = 100;
		int limitWeight = 100;
		
		//int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};
		int[] truckWeights = {10};
		
		try {
			int returnSecond = solution(bridgeLength, limitWeight, truckWeights);
			System.out.println("Ret : " + returnSecond);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        ArrayList<Integer> waitTruckArr = new ArrayList<>(truck_weights.length);
        for (int i : truck_weights) {
        	waitTruckArr.add(i);
        }
        
        int[] bridge = new int[bridge_length];
        ArrayList<Integer> bridgeArr = new ArrayList<>(bridge.length);
        
        for (int i : bridge) {
        	bridgeArr.add(i);
        }
        
        boolean isEnd = false;
        
        while (isEnd == false) {
    
        	answer++;
        	
        	BRIDGE_ON_TRUCK_WEIGHT = BRIDGE_ON_TRUCK_WEIGHT - bridgeArr.get(0);
        	
        	bridgeArr.remove(0);
        	
        	if (waitTruckArr.size() > 0 && BRIDGE_ON_TRUCK_WEIGHT + waitTruckArr.get(0) <= weight) {
        		
        		bridgeArr.add(waitTruckArr.get(0));
        		
        		BRIDGE_ON_TRUCK_WEIGHT = BRIDGE_ON_TRUCK_WEIGHT + waitTruckArr.get(0);
        		
        		waitTruckArr.remove(0);
        	} else {
        		bridgeArr.add(0);
        	}
        	
        	if (waitTruckArr.size() == 0 && BRIDGE_ON_TRUCK_WEIGHT == 0) {
        		isEnd = true;
        	}
        	
        }
        
        return answer;
    }
    
}
