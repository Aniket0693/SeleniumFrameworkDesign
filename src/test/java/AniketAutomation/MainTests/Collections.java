package AniketAutomation.MainTests;

import java.util.Arrays;
import java.util.*;


public class Collections {

	public static void main(String[] args) {
//		hashTableAndVecor();
//		iterateArrayList();
//		ListToArray();
//		iterateHashSet();
//		elementExistsArrayList();
//		elementExistsHashSet();
		
//		Imp Que
//		iterateHashMap();
//		sortHashMapKey(); 
		
		
		
	}
	
	
	public static void hashTableAndVecor()
	{
		// Creating instances of the array,
				// vector and hashtable
				int arr[] = new int[] { 1, 2, 3, 4 };
				Vector<Integer> v = new Vector();
				Hashtable<Integer, String> h = new Hashtable();

				// Adding the elements into the
				// vector
				v.addElement(1);
				v.addElement(2);

				// Adding the element into the
				// hashtable
				h.put(1, "geeks");
				h.put(2, "4geeks");

				// Array instance creation requires [],
				// while Vector and hastable require ()
				// Vector element insertion requires addElement(),
				// but hashtable element insertion requires put()

				// Accessing the first element of the
				// array, vector and hashtable
				System.out.println(arr[0]);
				System.out.println(v.elementAt(0));
				System.out.println(h.get(1));

				// Array elements are accessed using [],
				// vector elements using elementAt()
				// and hashtable elements using get()
	}
//Write a program to traverse (or iterate) ArrayList
	public static void iterateArrayList() {
		ArrayList<Integer> al = new ArrayList<Integer>();
        // add elements to ArrayList object
        al.add(3);
        al.add(17);
        al.add(6);
        al.add(9);
        al.add(7);
        System.out.println("Using Advanced For Loop");   
        // printing ArrayList 
        for (Integer num : al) {         
            System.out.println(num);   
        }
	}
//	Write a program to convert List to Array
	public static void ListToArray() {
		ArrayList<String> cities = new ArrayList<>();
	      cities.add("Boston");
	      cities.add("Dallas");
	      cities.add("San jose");
	      cities.add("Chicago");

	      // ArrayList to String array conversion using toArray()
	      String citinames[]=cities.toArray(new String[cities.size()]);
	   // Printing elements using for-each loop
	      for(String str : citinames) {
	        System.out.println(str); 
	        }
	      
	      //Method 2
	      String[] browsernames = Arrays.copyOf(cities.toArray(), cities.size(), String[].class);
	      for(String str1 : browsernames) {
		        System.out.println(str1); 
		        }
	}
// Write a program to traverse(or iterate) HashSet?
	public static void iterateHashSet() {
		// Declaring a HashSet
	    HashSet<String> hashset = new HashSet<String>();
	    // Add elements to HashSet
	    hashset.add("Pear");
	    hashset.add("Apple");
	    hashset.add("Orange");
	    hashset.add("Papaya");
	    hashset.add("Banana");    
	    // Get iterator
	    Iterator<String> it = hashset.iterator();
	    // Show HashSet elements
	    System.out.println("HashSet contains: ");
	    while(it.hasNext()) {
	      System.out.println(it.next());
	    }
	    
	    System.out.println("HashSet contains :");
	    // Using for each loop
	    for(String str : hashset){
	        System.out.println(str);
	    }
	}
// Given an element write a program to check if element(value) exists in ArrayList?
	public static void elementExistsArrayList() {
		// initialize ArrayList  
        ArrayList<Integer> al = new ArrayList<Integer>();
        // add elements to ArrayList object
        al.add(3);
        al.add(17);
        al.add(6);
        al.add(9);
        al.add(7);
        // check if ArrayList contains element
        if (al.contains(7)) {
            System.out.println("7 was found in the list");
        } else {
            System.out.println("7 was not found in the list");
        }
	}
// Given an element write a program to check if element exists in HashSet?
	public static void elementExistsHashSet() {
		// initialize HashSet  
        HashSet<Integer> hs = new HashSet<Integer>();
        // add elements to HashSet object
        hs.add(3);
        hs.add(17);
        hs.add(6);
        hs.add(9);
        hs.add(7);
        // check if HashSet contains element
        if (hs.contains(7)) {
            System.out.println("7 was found in the list");
        } else {
            System.out.println("7 was not found in the list");
        }
	}
	//How To Iterate Or Loop Over HashMap (Map)
	public static void iterateHashMap() {
		 // Creating a HashMap of String keys and String values
	    HashMap<String, String> hashmap = new HashMap<String, String>();
	    hashmap.put("Key1", "Value1");
	    hashmap.put("Key2", "Value2");
	    System.out.println("Iterating or looping map using foreach loop");
	    // Iterating or looping using keySet() method
	    for (String key : hashmap.keySet()) {
	        System.out.println("key: " + key + " value: " + hashmap.get(key));
	    }
	    System.out.println("*******************************************************************************************");
	 // Iterating or looping using keySet() method
	    Set<String> keySet = hashmap.keySet();
	    Iterator<String> keySetIterator = keySet.iterator();
	    while (keySetIterator.hasNext()) {
	        String key = keySetIterator.next();
	        System.out.println("key: " + key + " value: " + hashmap.get(key));
	    }
	    System.out.println("*******************************************************************************************");
	 // Iterating or looping using entrySet() method
	    Set<Map.Entry<String, String>> entrySet = hashmap.entrySet();
	    for (Map.Entry entry : entrySet) {
	        System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
	    }
	    System.out.println("*******************************************************************************************");
	 // Iterating or looping using entrySet() method
	    Set<Map.Entry<String, String>> entrySet1 = hashmap.entrySet();
	    Iterator<Map.Entry<String, String>> entrySetIterator = entrySet1.iterator();
	    while (entrySetIterator.hasNext()) {
	        Map.Entry entry = entrySetIterator.next();
	        System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
	    }
	
	
	}
//	How To Sort HashMap In Java By Keys And Values
	public static void sortHashMapKey() {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		 
	    // Adding Key and Value pairs to HashMap
	    hashmap.put(22,"A");
	    hashmap.put(55,"B");
	    hashmap.put(33,"Z");
	    hashmap.put(44,"M");
	    hashmap.put(99,"I");
	    hashmap.put(88,"X");
	 
	    System.out.println("Before Sorting:");
	    Set set = hashmap.entrySet();
	    Iterator it = set.iterator();
	    while(it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.print(pair.getKey() + ": ");
	        System.out.println(pair.getValue());
	    }
	    
	    // sorting method - Treemap
	    Map<Integer, String> map = new TreeMap<Integer, String>(hashmap);    
	    System.out.println("After Sorting:");
	    Set set2 = map.entrySet();
	    Iterator iterator2 = set2.iterator();
	    while(iterator2.hasNext()) {
	        Map.Entry pair = (Map.Entry)iterator2.next();
	        System.out.print(pair.getKey() + ": ");
	        System.out.println(pair.getValue());
	    } 
	}
//	Java ArrayList Of Object Sort
	
	

}
