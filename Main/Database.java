package Main;
import java.util.*;

public class Database{
   //Fields
   private ArrayList<Movie> database;
  
   //Constructor
   Database(){
       database = new ArrayList<Movie>();
   }
  
   //Methods
   public ArrayList<Movie> getDatabase(){
       return database;
   }
   public Movie getElement(int i){
       return database.get(i);
   }
   //Add a new movie to the database
   public void addMovie(){
       String title = "";
       String actor1 = "";
       String actor2 = "";
       int year = -1;
       int runtime = -1;
       String director = "";
      
       KeyboardInput input = new KeyboardInput();
       System.out.println("Enter Movie Title > ");
       input.retrieveText();
       title = input.getInput();
       System.out.println("Enter Actor #1 > ");
       input.retrieveText();
       actor1 = input.getInput();
       System.out.println("Enter Actor #2 > ");
       input.retrieveText();
       actor2 = input.getInput();
       System.out.println("Enter Year > ");
       input.retrieveText();
       try{
           year = Integer.parseInt(input.getInput());
       } catch (Exception e){
           System.out.println("Invalid year. Year set to 0.");
           year = 0;
       }
       input.prompt("Enter Runtime > ");
       input.retrieveText();
       try{
           runtime = Integer.parseInt(input.getInput());
       } catch (Exception e){
           System.out.println("Invalid Runtime. Runtime set to 0 minutes.");
           runtime = 0;
       }
       input.prompt("Enter Director > ");
       input.retrieveText();
       director = input.getInput();
      
       //input.done();
      
       //Add the movie into the database
       database.add(new Movie(title, actor1, actor2, director, runtime, year));
       System.out.println("Movie added!");
       System.out.println("");
   }
   //Delete a movie from the database (delete by title)
   public void deleteMovie(){
       String title = "";
       int count = 0;
      
       KeyboardInput input = new KeyboardInput();
       input.prompt("Enter Title to delete > ");
       input.retrieveText();
       title = input.getInput();
      
       for (int i = 0; i < database.size(); i++)
       {
           if (database.get(i).getTitle().toLowerCase().equals(title.toLowerCase())){
               System.out.println("'" + database.get(i).getTitle() + "' has been deleted.");
               database.remove(i);
               count += 1;
           }
       }
      
       if (count == 0)
           System.out.println("The movie title '" + title + "' was not found.");
      
       System.out.println("");
   }
   //Search for a movie by actor
   public void actorSearch(){
       String actor = "";
       int count = 0;
      
       KeyboardInput input = new KeyboardInput();
       input.prompt("Enter Actor Name > ");
       input.retrieveText();
       actor = input.getInput();
      
       for (int i = 0; i < database.size(); i++)
       {
           if (database.get(i).getActor1().toLowerCase().equals(actor.toLowerCase()) || database.get(i).getActor2().toLowerCase().equals(actor.toLowerCase())){
               System.out.println(database.get(i).getTitle());
               count += 1;
           }
       }
      
       if (count == 0)
           System.out.println("No titles found for '" + actor + "'.");
      
       System.out.println("");
   }
   //Search for a movie by year
   public void yearSearch(){
       int year = 0;
       int count = 0;
      
       KeyboardInput input = new KeyboardInput();
       System.out.println("Enter year > ");
       input.retrieveText();
       try{
           year = Integer.parseInt(input.getInput());
       } catch(Exception e) {
           System.out.println("Invalid year. Searching year 0.");
           year = 0;
       }
       for (int i = 0; i < database.size(); i++)
       {
           if (database.get(i).getYear() == year){
               System.out.println(database.get(i).getTitle());
               count += 1;
           }
       }
      
       if (count == 0)
           System.out.println("No titles found for " + Integer.toString(year) + ".");
      
       System.out.println("");
   }
   //Search for a movie by runtime
   public void runtimeSearch(){
       int runtime = 0;
       int count = 0;
      
       KeyboardInput input = new KeyboardInput();
       input.prompt("Enter runtime (in minutes) > ");
       input.retrieveText();
       try{
           runtime = Integer.parseInt(input.getInput());
       } catch(Exception e) {
           System.out.println("Invalid runtime. Searching runtime of 0 minutes.");
           runtime = 0;
       }
      
       for (int i = 0; i < database.size(); i++)
       {
           if (database.get(i).getRuntime() == runtime){
               System.out.println(database.get(i).getTitle());
               count += 1;
           }
       }
      
       if (count == 0)
           System.out.println("No titles found for " + Integer.toString(runtime) + " minutes.");
      
       System.out.println("");
   }
   //Search for a movie by director
   public void directorSearch(){
       String director = "";
       int count = 0;
      
       KeyboardInput input = new KeyboardInput();
       System.out.println("Enter Director Name > ");
       input.retrieveText();
       director = input.getInput();
      
       for (int i = 0; i < database.size(); i++)
       {
           if (database.get(i).getDirector().toLowerCase().equals(director.toLowerCase())){
               System.out.println(database.get(i).getTitle());
               count += 1;
           }
       }
      
       if (count == 0)
           System.out.println("No titles found for '" + director + "'.");
      
       System.out.println("");
   }
   //Search for a movie by title
   public void titleSearch(){
       String title = "";
       int count = 0;
      
       KeyboardInput input = new KeyboardInput();
       System.out.println("Enter Actor Name > ");
       input.retrieveText();
       title = input.getInput();
      
       for (int i = 0; i < database.size(); i++)
       {
           if (database.get(i).getTitle().toLowerCase().equals(title.toLowerCase())){
               System.out.println(database.get(i).getTitle() + ":");
               System.out.println(" Actors - " + database.get(i).getActor1() + ", " + database.get(i).getActor2());
               System.out.println(" Director - " + database.get(i).getDirector());
               System.out.println(" Year - " + Integer.toString(database.get(i).getYear()));
               System.out.println(" Runtime - " + Integer.toString(database.get(i).getRuntime()) + " minutes");
               count += 1;
           }
       }
      
       if (count == 0)
           System.out.println("The movie title '" + title + "' was not found.");
      
       System.out.println("");
   }
}