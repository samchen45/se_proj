package project1;

import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.*;
import java.io.BufferedReader;  
import java.io.File;    
import java.io.FileReader;  
import java.io.IOException;    

public class Wordladder {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        Scanner sb = new Scanner(System.in);
        System.out.print("Please input the address of the dictionary : ");
        String address = sb.nextLine();
        System.out.print("Please input the head word: ");
        String head_word = sb.nextLine();
        System.out.print("Please input the end word: ");
        String end_word = sb.nextLine();
        sb.close();
        File file = new File(address);
        BufferedReader reader = null;
        try {
        	reader = new BufferedReader(new FileReader(file));
        	String word = null;
        	while ((word = reader.readLine())!= null ) {
        		dict.add(word);
        	}
        	reader.close();
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
        finally {
        	if(reader != null) {
        		try {
        			reader.close();
        		}
        		catch(IOException e1) {
        		}
        	}
        }
        
        System.out.println("The length of wordladder is " + wordLadder(head_word,end_word,dict));
    }
    public static int wordLadder(String head, String end, Set<String> dictionary){
        if ( head == null || end == null) return 0;
        if ( head.length() == 0 || end.length()== 0) return 0;
        if ( head.length() != end.length()) return 0;
        else {
            LinkedList<String> ladder = new LinkedList<String>();
            ladder.add(head);
            int len = 1; 
            while (!ladder.isEmpty()) {
                int size = ladder.size();
                while (size > 0){
                    String word = ladder.poll();  // pop the top of the list
                    for (int i = 0 ; i < word.length() ; i++) {
                        char[] word_array = word.toCharArray();
                        for (char j = 'a' ; j <= 'z' ; j ++) {
                            word_array[i] = j;
                            String new_word = new String(word_array);
                            if (new_word.equals(end)) return (len + 1);
                            if (dictionary.contains(new_word)){
                                ladder.add(new_word);
                                dictionary.remove(new_word);
                            }
                        }
                    }
                    size --;
                }
                len ++;
            }
            return 0;
        }
    }
}
