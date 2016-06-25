import java.util.Scanner;

public class PingCSV{

   public static final int FIRST_NUM_INDEX = 23;
   public static final int NUM_QUALIFIERS =  4;
   public static final int NUM_SLASH = 1;

   public static void main(String args[]){

      // Read results from standard in
      Scanner s = new Scanner(System.in);

      // Find Average ping time
      String num = "";
      while(s.hasNextLine()){
         String line = s.nextLine();
         if(line.length() > 0 && line.charAt(0) == 'r' && line.charAt(1) == 't' && line.charAt(2) == 't'){
            int foreSlash = 0;
            for(int i = FIRST_NUM_INDEX; i < line.length(); i++){
               if(line.charAt(i) == '/'){
                  if(++foreSlash == NUM_SLASH){
                     i++;
                     while(line.charAt(i) != '/'){
                        num += line.charAt(i++); 
                     }
                     break;
                  }
               }
            }
         }
      }
      System.out.println(num);
   }
}
