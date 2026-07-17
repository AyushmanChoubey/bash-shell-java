import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: Uncomment the code below to pass the first stage
        Scanner sc=new Scanner(System.in);
        int n=1;
        while(n>0){
        System.out.print("$ ");
        String s=sc.nextLine();
        String[] p=s.split("\\s+");
        if(s.startsWith("exit"))
            break;
        
        else if (s.startsWith("echo")) {
               for (int i = 1; i < p.length; i++) {
                    System.out.print(p[i] + " ");
                  }
                 System.out.println(); 
            }
        else if (s.startsWith("type")) {
            if(s.substring(5).equals("echo") || s.substring(5).equals("exit")|| s.substring(5).equals("type"))
                System.out.println(s.substring(5)+" is a shell builtin");
        }
        else{
           for (int k=5;k<p.length;k++)
            System.out.print(p[k]+": command not found");
        }
        }

    }
}

