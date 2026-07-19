import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // TODO: Uncomment the code below to pass the first stage
        Scanner sc=new Scanner(System.in);
        int n=1;
        while(n>0){
        System.out.print("$ ");
        String s=sc.nextLine();
         if(s.startsWith("exit"))
            break;
        
        else if (s.startsWith("echo")) {
            String [] p=s.split(" ");
            for (int i = 1; i < p.length; i++) {
                       System.out.print(p[i] + " ");
                      }
                     System.out.println();

            }
        else if (s.startsWith("type")) {
            String b=s.substring(5);
            if(b.equals("echo") || b.equals("exit")|| b.equals("type"))
                System.out.println(b+" is a shell builtin");
        
             else{
           System.out.println(b+": not found");
             }
           }
        else 
            System.out.println(s+": command not found");
      }

    }
}

