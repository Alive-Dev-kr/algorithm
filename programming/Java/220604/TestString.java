package practice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

// 1. 상속 불가능한 클래스다
// 2. 변하지 않는 클래스다
// - String test = "KT";
//   test = "KT1";
public final class TestString {

	public final int testInt = 1;
	
	// A
	public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(1);
        
        Iterator<Integer> iter = hashSet.iterator();
        
        while (iter.hasNext()) {
        	System.out.println("iterator 1 : " + iter.next());
        }
        
        while (iter.hasNext()) {
        	System.out.println("iterator 2 : " + iter.next());
        }
        
        SortedSet<Human> set2 = new TreeSet<Human>();

        Human human5 = new Human("김경택55555555555555");
        Human human2 = new Human("박혜련22");
        Human human4 = new Human("사람4444444");
        Human human1 = new Human("박경택1");
        Human human3 = new Human("정원일333");
        
        set2.add(human5);
        set2.add(human4);
        set2.add(human3);
        set2.add(human2);
        set2.add(human1);
        
        Iterator<Human> iter2 = set2.iterator();
        
        while (iter2.hasNext()) {
        	System.out.println("iterator : " +iter2.next().getName());
        }
		
	}
	
	public void testMethod() {
		
	}
	
}
