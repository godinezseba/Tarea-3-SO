import java.io.FileWriter;
public class test 
{ 
    public static void main(String[] args) 
    { 
        try{    
            FileWriter fw=new FileWriter("hola_mundo.txt");    
            fw.write("Hola mundo.");    
            fw.close();    
           }catch(Exception e){System.out.println(e);}    
      
    } 
} 
