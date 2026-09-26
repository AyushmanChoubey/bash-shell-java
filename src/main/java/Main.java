import java.io.File;
import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) throws Exception 
    {
    
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
        else if(s.equals("pwd"))
        {
            System.out.println(print_current_path());
        }
        else if(s.startsWith("cd"))
        {
        
                 String[] h = s.split("\\s+");

            if (h.length > 1) {
            
             String target = h[1];
              File dir = new File(target);
             if (dir.isAbsolute()) {
            if (dir.isAbsolute() && dir.isDirectory()) {
                System.setProperty("user.dir", dir.getAbsolutePath());
            } else {
                System.out.println("cd: " + target + ": No such file or directory");
            }
            }
            else{
                 File current = new File(System.getProperty("user.dir"));
                  dir = new File(current, target);
                  System.setProperty("use.dir", dir.getAbsolutePath());
            }
        }
    }

        else 
            System.out.println(s+": command not found");

        

         
    } 
    }
          public  static  String type(String e)
           {
                 String[] c={"echo","exit","echo","type","pwd"};
                 String path = System.getenv("PATH");
                  String[] dirs = path.split(java.io.File.pathSeparator);
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
        private static String print_current_path()
        {
                return System.getProperty("user.dir");

        }
     //public static boolean changedirectory(String cf) throws Exception{
        //File dir = new File(cf);

        // Check if path exists and is a directory
       // if (dir.exists() && dir.isDirectory()) {
           // System.setProperty("user.dir", dir.getAbsolutePath());
           // return true;
       // } else {
          //  return false;
      //  }
   // }
   

 }

