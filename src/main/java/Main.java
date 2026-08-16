import java.io.File;
import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        // TODO: Uncomment the code below to pass the first stage
        Scanner sc=new Scanner(System.in);
        int n=1;
        while(n>0)
        {
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
             System.out.println(type(b));
             }
        else if(s.startsWith("custom_exe")) 
            {String []h=s.split("\\s+");
               boolean j=check_executable(h[0]);
               execute(j,s);
            } 
    
        else 
            System.out.println(s+": command not found");

      }

    }
          public  static  String type(String e)
           {
                 String[] c={"echo","exit","echo","type"};
                 String path = System.getenv("PATH");
                 String[] dirs=path.split(File.pathSeparator);
                 for(int i=0;i<c.length;i++)
                 {
                    if(c[i].equals(e))
                   {
                       return e + " is a shell builtin";
                   }
                    }   
            
                for(String dir:dirs)
                {
                    File file =new File(dir,e);
                    if(file.exists()&& file.canExecute())
                    {
                        return e +" is "+file.getAbsolutePath();
     
                    }
                }
                return e + ": not found";
            }
                
            public static  boolean check_executable(String ce)
           {  
              String path = System.getenv("PATH");
                 String[] dirs=path.split(File.pathSeparator);
                 for(String dir:dirs)
                {
                    File file =new File(dir,ce);
                    if(file.exists()&& file.canExecute())
                    {
                        return true;
                     }
                 }
                 return false;
            }
        
           public static void execute(boolean d,String ec) throws Exception
           {
            if(d)
            {
                String[] parts=ec.split("\\s+");
                ProcessBuilder pb=new ProcessBuilder(parts);
                pb.inheritIO();
                Process process=pb.start();
                process.waitFor();
            }
                   
               }
        
           
 }

