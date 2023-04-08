package AniketAutomation.MainTests;

import java.beans.Statement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.interactions.Actions;

public class JavaPrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		swapTwoNums();
//		swapTwoNumsWOthirdVar();
//		findGreatestNum();
//		fibonacciSeries();
//		starconsole();
//		starPyramid();
		// Find Duplicates in Array withdiff methods
//		int[] inputArray = {"Aniket","naman","yuga","Aniket","Aniket"};
//		findDuplicatesUsingSorting(inputArray);
//		findDuplicatesUsingHashSet( inputArray);
//		findDuplicatesUsingJava8(inputArray);
//		findDuplicatesUsingHashMap(inputArray);
		duplicatecharactersHashMap();
		// remove white spaces from A String
		removeWhiteSpaces();
//		removeWhiteSpacesWObuiltin();
//		findDuplicatecharacterinString();
//		StringReverse();
//		ArrayReverse();
//		ArrayReversewitheachelement();
//		ArrayReversewitheachinteger();
//		isAnagram();
//		stringSort();
//		DuplicateWord();
//		String str = "Aniket PaDgilwar";
//		str = str.toLowerCase();
//		getDuplicateCount(str);
//		countDuplicateCharacters(str);
//		squareFilterUsingStream();
//		alphabets();
	}

	public static void swapTwoNums() {

		int a = 10;
		int b = 20;
		int temp;
		temp = b;
		b = a;
		a = temp;
		System.out.println(a + "and" + b);

	}

	public static void swapTwoNumsWOthirdVar() {

		int a = 10;
		int b = 20;
		a = b + a;
		b = a - b;
		a = a - b;
		System.out.println(a + "and" + b);
	}

	public static void findGreatestNum() {

		int a = 10;
		int b = 20;
		int c = 30;

		if (a > b && a > c) {
			System.out.println(a);
		} else if (b > c) {
			System.out.println(b);
		} else {
			System.out.println(c);
		}

	}

	public static void fibonacciSeries() {

		int n1 = 0;
		int n2 = 1;
		int n3;
		int count = 10;
		System.out.print(n1 + ", " + n2);
		for (int i = 2; i < count; ++i) {
			n3 = n1 + n2;
			System.out.print(", " + n3);
			n1 = n2;
			n2 = n3;
		}

	}

	public static void starconsole() {
		int row, numberOfStars;
		for (row = 1; row <= 10; row++) {
			for (numberOfStars = 1; numberOfStars <= row; numberOfStars++) {
				System.out.print("*");
			}
			System.out.println(); // Go to next line
		}
	}

	public static void starPyramid()

	{
		int rows = 10;

		for (int i = 1; i <= rows; i++) {
			// Print space in decreasing order
			for (int j = rows; j > i; j--) {
				System.out.print(" ");
			}
			// Print star in increasing order
			for (int k = 1; k <= (i * 2) - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void findDuplicatesUsingSorting(String[] inputArray) {
		Arrays.sort(inputArray);
		int cnt = 0;
		for (int i = 0; i < inputArray.length - 1; i++) {

			if (inputArray[i] == inputArray[i + 1]) {
				System.out.println("Duplicate Element :" + inputArray[i]);
				cnt+=1;
				System.out.println("repeat :" + cnt);
				
			}
			

		}

	}

	private static void findDuplicatesUsingHashSet(int[] inputArray) {
		HashSet<Integer> set = new HashSet<Integer>();

		for (int element : inputArray) // Hashset allow only unique elements
		{
			if (!set.add(element)) {
				System.out.println("Duplicate Element : " + element);
			}
		}
	}

	public static void findDuplicatesUsingJava8(int[] inputArray) {
		Set<Integer> uniqueElements = new HashSet<>();

		Set<Integer> duplicateElements = Arrays.stream(inputArray).filter(i -> !uniqueElements.add(i)).boxed()
				.collect(Collectors.toSet());

		System.out.println(duplicateElements);
	}

	private static void findDuplicatesUsingHashMap(int[] inputArray) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int element : inputArray) {
			if (map.get(element) == null) {
				map.put(element, 1);
			} else {
				map.put(element, map.get(element) + 1);
			}
		}

		Set<Entry<Integer, Integer>> entrySet = map.entrySet();

		for (Entry<Integer, Integer> entry : entrySet) {
			if (entry.getValue() > 1) {
				System.out
						.println("Duplicate Element : " + entry.getKey() + " - found " + entry.getValue() + " times.");
			}
		}
	}

	// remove white spaces from A String
	public static void removeWhiteSpaces() {
		String orig = "hasjda jdkasjdklasj kjashdjkhaskj jhkahkjdsa     djkasbnjsad  sajdhjkas  asjkhdjashkjsa     asjdhkjas";
		String rep = orig.replaceAll(" ", "");
		System.out.println(rep);
	}

	public static void removeWhiteSpacesWObuiltin() {
		String orig = "hasjda jdkasjdklasj kjashdjkhaskj jhkahkjdsa     djkasbnjsad  sajdhjkas  asjkhdjashkjsa     asjdhkjas";
		char[] arr = orig.toCharArray();
		String rep = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != ' ') {
				rep += arr[i];
			}
		}
		System.out.println(rep);
	}

	public static void findDuplicatecharacterinString() {
		String orig = "aniket padgilwar";
		char[] arr = orig.toCharArray();
		Arrays.sort(arr);
		String rep = "";
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1])
				System.out.println(arr[i]);
		}
		System.out.println(rep);
	}

	public static void StringReverse() {
		String s1 = "Aniket Padgilwar";
		for (int i = s1.length() - 1; i >= 0; i--) {
			System.out.print(s1.charAt(i));
		}
		System.out.println("");
	}

	public static void ArrayReverse() {
		int s1[] = { 1, 5, 6, 8, 9, 50, 15 };

		for (int i = s1.length - 1; i >= 0; i--)

		{
			System.out.print(s1[i]);
		}
	}

	public static void ArrayReversewitheachelement() {
		String s1[] = { "Aniket", "Optum", "TCS", "Padgilwar" };

		String rev = "";
		for (int i = s1.length - 1; i >= 0; i--) {

			for (int j = s1[i].length() - 1; j >= 0; j--) {
				rev = rev + s1[i].charAt(j);
			}
			System.out.print(rev + " ");
			rev = "";
		}
	}

	public static void ArrayReversewitheachinteger() {
		int s1[] = { 123, 456, 876, 987 };
		String s2 = "";
		String rev = "";
		int rev1;
		for (int i = s1.length - 1; i >= 0; i--) {
			s2 = Integer.toString(s1[i]);
			for (int j = s2.length() - 1; j >= 0; j--) {
				rev = rev + s2.charAt(j);
			}
			rev1 = Integer.parseInt(rev);
			System.out.print(rev1 + " ");
			rev = "";
		}
	}

	public static void isAnagram() {
		String s1 = "Mother In Law";
		String s2 = "Hitler Woman";

		String s3 = s1.replaceAll(" ", "");
		String s4 = s2.replaceAll(" ", "");

		Boolean flag = true;
		if (s3.length() != s4.length()) {
			flag = false;
		} else {
			char[] s1Arr = s3.toLowerCase().toCharArray();
			char[] s2Arr = s4.toLowerCase().toCharArray();
			Arrays.sort(s1Arr);
			Arrays.sort(s2Arr);

			flag = Arrays.equals(s1Arr, s2Arr);

		}
		if (flag) {
			System.out.println("anagram");
		} else {
			System.out.println("not anagram");
		}
	}

	public static void stringSort() {
		String s1 = "aniket";
		char[] s2 = s1.toCharArray();		
		char temp;
		for(int i =0; i<s2.length;i++) 
		{
			for(int j =i+1;j<s2.length;j++)
			{
				if(s2[i]>s2[j])
				{
					temp = s2[j];
                    s2[j] = s2[i];
                    s2[i] = temp;
				}
			}
			
		}
		System.out.println(s2);
	}
	public static void stringSort2() {
		String s1 = "aniket";
		char[] s2 = s1.toCharArray();
		Arrays.sort(s2);
		System.out.println(s2);
	}
	
	public static void DuplicateWord() {    
	        String string = "Big black bug bit a big black dog on his big black nose";  
	        int count; 
	          
	        //Converts the string into lowercase  
	        string = string.toLowerCase();  
	          
	        //Split the string into words using built-in function  
	        String words[] = string.split(" ");  
	          
	        System.out.println("Duplicate words in a given string : ");   
	        for(int i = 0; i < words.length; i++) {  
	            count = 1;  
	            for(int j = i+1; j < words.length; j++) {  
	                if(words[i].equals(words[j])) {  
	                    count++;
	                }
	            }  
	            //Displays the duplicate word if count is greater than 1  
	            if(count > 1) {  
	            	System.out.println(words[i]+" and count is :"+count); 
	            }
	            else if (count == 1){
	            	System.out.println(words[i]+" and count is :"+count); 
		            
	            }
	            }  
	        
	    }  
	
	public static void countDuplicateCharacters(String str)
    {
 
        // Creating a HashMap containing char
        // as a key and occurrences as a value
        Map<Character, Integer> map
            = new HashMap<Character, Integer>();
 
        // Converting given string into
        // a char array
        char[] charArray = str.toCharArray();
 
        // Checking each character
        // of charArray
        for (char c : charArray) {
 
            if (map.containsKey(c)) {
 
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
 
        for (Map.Entry<Character, Integer> entry :
             map.entrySet()) {
 
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey()
                                   + " : "
                                   + entry.getValue());
            }
            else{
                System.out.println(entry.getKey()
                               + " : "
                               + entry.getValue());
            
                   }
        }	
}
public static void getDuplicateCount(String str) {
	int cnt;
      str = str.toLowerCase();
      for(int i=0; i<str.length();i++)
      {
    	  cnt =1;
    	  for(int j=i+1; j<str.length();j++)
    	  {
    		  if(str.charAt(i)==str.charAt(j)) {
    			  cnt++;
    		  }
    	  }
    	  if(cnt>1) {
    		  System.out.println(str.charAt(i)+"- count is - "+cnt);
    	  }
    	  else{
    		  System.out.println(str.charAt(i)+"- count is - "+cnt);
    	  }
      }
      
}

public static void squareFilterUsingStream() {
	Integer[] nums = { 1, 2, 3, 4,5,6,7,8 };
	Stream.of(nums)
      .filter(e -> e != null)
      .filter(e -> e*e > 30)
      .forEach(e -> System.out.println(e + "\t" +(int)Math.pow(e, 2)));
}

public static void alphabets() {
	char ch;
	for(ch='a'; ch<'z';ch++) {
		System.out.println(ch);
	}
}

public static void reverseArray() {
	Integer[] myArr = { 1, 2, 3, 4,5,6,7,8 };
	Collections.reverse(Arrays.asList(myArr));
	System.out.println(Arrays.asList(myArr));

}

public static void IteratorUsingJavaStream() {  
	Stream.iterate(1, element->element+1)  
    .filter(element->element%5==0)  
    .limit(5)  
    .forEach(System.out::println);   
}  
public static void connectDB() throws SQLException, ClassNotFoundException {
	//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
    String dbUrl = "jdbc:mysql://localhost:3036/emp";					

	//Database Username		
	String username = "root";	
    
	//Database Password		
	String password = "guru99";				

	//Query to Execute		
	String query = "select *  from employee;";	
    
	    //Load mysql jdbc driver		
	    Class.forName("com.mysql.jdbc.Driver");			

		//Create Connection to DB		
	Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object		
   java.sql.Statement stmt = con.createStatement();					

		// Execute the SQL Query. Store results in ResultSet		
		ResultSet rs= stmt.executeQuery(query);							

		// While Loop to iterate through all data and print results		
	while (rs.next()){
        		String myName = rs.getString(1);								        
                String myAge = rs.getString(2);					                               
                System. out.println(myName+"  "+myAge);		
        }		
		 // closing DB Connection		
		con.close();
}

public static void duplicatecharactersHashMap()
{
	{
		String str = "geeksforgeeks jsadlkasjdl dkjaslkdsaks";
        // Creating a HashMap containing char
        // as a key and occurrences as a value
        Map<Character, Integer> map
            = new HashMap<Character, Integer>();
 
        // Converting given string into
        // a char array
        char[] charArray = str.toCharArray();
 
        // Checking each character
        // of charArray
        for (char c : charArray) {
 
            if (map.containsKey(c)) {
 
                // If character is present
                // in map incrementing it's
                // count by 1
                map.put(c, map.get(c) + 1);
            }
            else {
 
                // If character is not present
                // in map putting this
                // character into map with
                // 1 as it's value.
                map.put(c, 1);
            }
        }
 
        // Traverse the HashMap, check
        // if the count of the character
        // is greater than 1 then print
        // the character and its frequency
        for (Map.Entry<Character, Integer> entry :
             map.entrySet()) {
 
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey()
                                   + " : "
                                   + entry.getValue());
            }
        }
	}
}

//public static void brokenLinks() {
//	String homePage = "http://www.zlti.com";
//    String url = "";
//    HttpURLConnection huc = null;
//    int respCode = 200;
//    
//    driver = new ChromeDriver();
//    
//    driver.manage().window().maximize();
//    
//    driver.get(homePage);
//    
//    List<WebElement> links = driver.findElements(By.tagName("a"));
//    
//    Iterator<WebElement> it = links.iterator();
//    
//    while(it.hasNext()){
//        
//        url = it.next().getAttribute("href");
//        
//        System.out.println(url);
//    
//        if(url == null || url.isEmpty()){
//System.out.println("URL is either not configured for anchor tag or it is empty");
//            continue;
//        }
//        
//        if(!url.startsWith(homePage)){
//            System.out.println("URL belongs to another domain, skipping it.");
//            continue;
//        }
//        
//        try {
//            huc = (HttpURLConnection)(new URL(url).openConnection());
//            
//            huc.setRequestMethod("HEAD");
//            
//            huc.connect();
//            
//            respCode = huc.getResponseCode();
//            
//            if(respCode >= 400){
//                System.out.println(url+" is a broken link");
//            }
//            else{
//                System.out.println(url+" is a valid link");
//            }
//                
//        } catch (MalformedURLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//    
//    driver.quit();
//}

}  