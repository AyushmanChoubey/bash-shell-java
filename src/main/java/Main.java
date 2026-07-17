import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: Uncomment the code below to pass the first stage
        int n=1;
        while(n>0){
        Scanner sc=new Scanner(System.in);
        System.out.print("$ ");
        String s=sc.nextLine();
        String[] p=s.split("\\s+");
        if(s.equals("exit"))
            break;
        
        else if (p[0].equals("echo")) {
               for (int i = 1; i < p.length; i++) {
                    System.out.print(p[i] + " ");
                  }
                 System.out.println(); 
            }

        else
            System.out.println(s+": command not found");
        }

    }
}

