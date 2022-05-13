package Main;
public class Final{
  
   //Global variable to keep track of state
   public static String state = "main";
  
   public static void main(String[] args){
   //Program greeting
       pn("Welcome to Cassie's Movie Database program.");
       pn("");
      
   //Create Database
       Database movieDB = new Database();
      
   //Load in the previously saved database
       //Check if the save file exists
       boolean exist = Input.doesFileExist("CourseList.txt");
       //Load in the movies from db.txt to movieDB
       if (exist == true){
           Input load = new Input();
           load.loadDatabase(movieDB);
       }
      
   //Finite State Machine for the different states
       KeyboardInput mainInput = new KeyboardInput();
       String input = "";
       while(!mainInput.getInput().toLowerCase().equals("quit")){
          
           input = FSM(mainInput);
           FSM_process(input, movieDB);
       }
      
      
      
   //Before the program terminates, save the database from memory to db.txt
       Output save = new Output();
       save.saveDatabase(movieDB);
   }
  
   //***********************************************************************************************
  
   public static String FSM(KeyboardInput in){
       switch(state){
       case "main":
           pn("Main Menu:");
           pn("a) New Entry - 'add'");
           pn("b) Delete Entry - 'delete'");
           pn("c) Search By Actor - 'actor'");
           pn("d) Search by Year - 'year'");
           pn("e) Search by Runtime (in minutes) - 'runtime'");
           pn("f) Search by Director - 'director'");
           pn("g) Search by Title - 'title'");
           pn("h) Save and Quit - 'quit'");
           pn("**Keywords are enclosed in single quotes.**");
           pn("Make a selection by entering the keyword of your choice.");
          
           in.prompt("Enter Command > ");
           in.retrieveText();
           pn("");
           return in.getInput();
       }
       return "main";
   }
  
   public static void FSM_process(String input, Database db){
       switch(input.toLowerCase()){
       case "add":
           pn("New Entry:");
           db.addMovie();
           break;
       case "delete":
           pn("Delete Movie:");
           db.deleteMovie();
           break;
       case "actor":
           pn("Search by Actor:");
           db.actorSearch();
           break;
       case "year":
           pn("Search by Year:");
           db.yearSearch();
           break;
       case "runtime":
           pn("Search by Runtime:");
           db.runtimeSearch();
           break;
       case "director":
           pn("Search by Director:");
           db.directorSearch();
           break;
       case "title":
           pn("Search by Title:");
           db.titleSearch();
           break;
       }
   }
  
   /* Easily print string to console (no line return) */
   public static <E> void p(String s){
       System.out.print(s);
   }
  
   /* Easily print string to console (with line return) */
   public static <E> void pn(String s){
       System.out.println(s);
   }
}