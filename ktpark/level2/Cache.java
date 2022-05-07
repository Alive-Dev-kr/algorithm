package level2;

import java.util.ArrayList;
import java.util.HashMap;

public class Cache {
	
	public static void main(String[] args) {
		
		//String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		//String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
		
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		
		int cacheSize = 5;
		
		int result = cache(cacheSize, cities);
		System.err.println("result : " + result);
		
	}
	
	public static int cache(int cacheSize, String[] cities) {
		
		int answer = 0;
		
        if (cities.length == 0) {
            return 0;
        }
		
		HashMap<String, Boolean> cacheMap = new HashMap<String, Boolean>();
		ArrayList<String> cacheList = new ArrayList<>();
		int selectIndex = 0;
		String selecCity = null;
		
		for (String city : cities) {
			
			city = city.toLowerCase();
			
			// 캐시 사이즈 0일땐 무조건 5초씩 증가
			if (cacheSize == 0) {
				answer = answer + 5;
			} else {
				
				// Cache 체크
				// 캐시 있는경우 1초씩 증가
				if (cacheMap.get(city) != null) {
					selectIndex = cacheList.indexOf(city);
					cacheList.remove(selectIndex);
					answer = answer + 1;
				} else if (cacheSize == cacheList.size()) {
					selecCity = cacheList.get(0);
					cacheMap.remove(selecCity);
					cacheList.remove(0);
					answer = answer + 5;
				//} else if (cacheSize > cacheList.size()) {
				} else {
					answer = answer + 5;
				}
				
			}
			
			cacheList.add(city);
			cacheMap.put(city, true);
		  
		}
			
		System.err.println("cacheMap : " + cacheMap);
		
		return answer;
	}

}
