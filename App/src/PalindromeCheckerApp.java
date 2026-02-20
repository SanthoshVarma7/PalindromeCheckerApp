import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class PalindromeCheckerApp {
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Input Text:");
    String input=sc.next();
    boolean b=false;
    for(int i=0;i<input.length()/2;i++){
        if(input.charAt(i)==input.charAt(input.length()-i-1)){
            b=true;
        }
        else{
            b=false;
        }
    }

    System.out.println("Is it a Palindrome?: "+b);
    }
}
