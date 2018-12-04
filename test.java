import java.io.PrintStream;
import java.io.FileOutputStream;
public class test 
{ 
    public static void main(String[] args) 
    { 
        try{    
            PrintStream fw=new PrintStream(new FileOutputStream("hola_mudno.txt", true));    
            fw.println("Hola mundo.");    
            fw.close();    
           }catch(Exception e){System.out.println(e);}    
      
    } 
} 
