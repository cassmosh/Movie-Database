import java.io.*;
import java.util.StringTokenizer;
public class Input{
   //Fields;
   private BufferedReader in;
   private String fileName;
  
  
   //Constructor
   Input(){
       fileName = "CourseList.txt";
   }
  
   //Methods
   public static boolean doesFileExist(String file){
       BufferedReader inFile;
       try{
           inFile = new BufferedReader(new FileReader(file));
       } catch(IOException e){
           return false;
       }
      
       try{
           inFile.close();
       } catch (IOException e){
           System.exit(0);
       }
       return true;
   }
   public void openFile(){
       try{
           in = new BufferedReader(new FileReader(fileName));
       } catch (FileNotFoundException e){
           System.out.println("File not found!");
           System.exit(0);
       }
   }
   public String loadMovie(){
       String ret = "";
       try{
           ret = in.readLine();
       } catch (IOException ex) {
           return "NULL";
       }
       if (ret == null)
           ret = "NULL";
       return ret;
   }
   public void loadDatabase(Database movies){
       openFile();
       String line = loadMovie();
       while(line.equals("NULL") == false){
           StringTokenizer st = new StringTokenizer(line,"*");
           String title = st.nextToken();
           String actor1 = st.nextToken();
           String actor2 = st.nextToken();
           int year = Integer.parseInt(st.nextToken());
           int runtime = Integer.parseInt(st.nextToken());
           String director = st.nextToken();
           //Add the movie into the database
           movies.getDatabase().add(new Movie(title, actor1, actor2, director, runtime, year));
           //Load next movie
           line = loadMovie();
       }
   }
}