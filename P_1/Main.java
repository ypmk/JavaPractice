import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Input num: ");
        int num = in.nextInt();

        Second object = new Second();
        if(object.isDegreeOfTwo(num)==true){
            System.out.print("YES");
        }
        if(object.isDegreeOfTwo(num)==false){
            System.out.print("NO");
        }



    }
}

