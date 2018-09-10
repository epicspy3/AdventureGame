import java.util.Scanner;
public class Locations {
    // instance variables - replace the example below with your own
    private int i;
    private boolean PickUpBread;
    public Locations() {
        // initialise instance variables
        i = 0;
        PickUpBread = false;
    }
    public static void setI(int i) {
        int j = i;
    }
    public static void setDay(int day) {
        int DayInt = day;
    }
    public static void setLocationsVisited(int LocationsVisited) {
        int LV = LocationsVisited;
    }
    public int getI() {
        return(i);
    }
    public void SelectLocation(int Bread, int LocationsVisited, int Gold, String CurrentLocation, int day) {
        Scanner scanner = new Scanner(System.in);
        Locations Player = new Locations();
        String choice1;
        String choice2;
        String choice3;
        switch (CurrentLocation) {
            case "Home": System.out.println("Select a location below:");
                         System.out.println("1: Mine");
                         choice1 = "Mine";
                         System.out.println("2: River");
                         choice2 = "River";
                         System.out.println("3: Town Square");
                         choice3 = "Town Square";
                         System.out.println("Enter the name of the location.");
                         break;
            case "Mine": System.out.println("Select a location below:");
                         System.out.println("1: River");
                         choice1 = "River";
                         System.out.println("2: Town Square");
                         choice2 = "Town Square";
                         System.out.println("3: Home");
                         choice3 = "Home";
                         System.out.println("Enter the name of the location.");
                         break;
            case "River": System.out.println("Select a location below:");
                          System.out.println("1: Town Square");
                          choice1 = "Town Square";
                          System.out.println("2: Home");
                          choice2 = "Home";
                          System.out.println("3: Mine");
                          choice3 = "Mine";
                          System.out.println("Enter the name of the location.");
                          break;
            case "Town Square": System.out.println("Select a location below:");
                                System.out.println("1: Mine");
                                choice1 = "Mine";
                                System.out.println("2: River");
                                choice2 = "River";
                                System.out.println("3: Home");
                                choice3 = "Home";
                                System.out.println("Enter the name of the location.");
                                break;
            default: System.out.println("CurrentLocation variable is broken.");
                     break;
        }
        String input = scanner.nextLine();
        i = 0;
        while (i < 1) {
            switch (input.toLowerCase()) {
                case "home": Player.Home(Bread, LocationsVisited, Gold, CurrentLocation, day);
                             i=1;
                             break;
                case "mine": Player.Mine(Bread, LocationsVisited, Gold, CurrentLocation, day);
                             i=1;
                             break;
                case "river": Player.River(Bread, LocationsVisited, Gold, CurrentLocation, day);
                              i=1;
                              break;
                case "town square": Player.TownSquare(Bread, LocationsVisited, Gold, CurrentLocation, day);
                                    i=1;
                                    break;
                case "instructions": Instructions.Intro();                    
                                     break;
                default: System.out.println("Please enter a valid input.");
            }
        }
    }
    public void Home(int Bread, int LocationsVisited ,int Gold, String CurrentLocation, int day) {
        Scanner scanner = new Scanner(System.in);
        CurrentLocation = "Home";
        System.out.println(PickUpBread);
        if (LocationsVisited == 0) {
            System.out.print('\u000C');
            System.out.println("You are inside your home.");
            System.out.println("There are three pieces of bread on your table.");
            System.out.println("Do you pick it up? Enter yes or no.");
            String PickUp = scanner.nextLine();
            i = 0;
            while (i < 1) {
                if (PickUp.equalsIgnoreCase("yes")||PickUp.equalsIgnoreCase("y")) {
                    System.out.println("You have picked up 3 pieces of bread.");
                    Bread = Bread + 3;
                    i = 1;
                    System.out.println("You now have " + Bread + " pieces of bread.");
                    PickUpBread = true;
                }
                else if (PickUp.equalsIgnoreCase("no")||PickUp.equalsIgnoreCase("n")) {
                    System.out.println("You leave the bread on the table.");
                    i = 1;
                }
                else if (PickUp.equalsIgnoreCase("instructions")) {
                    Instructions.Intro();
                }
                else {
                    System.out.println("Please enter a valid input.");
                }
            }
            System.out.println("There is nothing else to note here.");
        }
        else if (PickUpBread = true) {
            System.out.println("There is nothing to note here.");
        }
        else if (PickUpBread = false && day < 3) {
            System.out.println("The bread is still on your table.");
            System.out.println("Do you pick it up? Enter yes or no.");
            String PickUp = scanner.nextLine();
            int i = 0;
            while (i < 1) {
                if (PickUp.equalsIgnoreCase("yes")||PickUp.equalsIgnoreCase("y")) {
                    System.out.println("You have picked up 3 pieces of bread.");
                    Bread = Bread + 3;
                    i = 1;
                    PickUpBread = true;
                }
                else if (PickUp.equalsIgnoreCase("no")||PickUp.equalsIgnoreCase("n")) {
                    System.out.println("You leave the bread on the table.");
                    i = 1;
                }
                else if (PickUp.equalsIgnoreCase("instructions")) {
                    Instructions.Intro();
                }
                else {
                    System.out.println("Please enter a valid input.");
                }
            }
        }
        else {
            System.out.println("Your bread has sadly been stolen. You suspect the Spaniards broke into your hut,\nbut you cannot accuse them.");
        }
        LocationsVisited++;
        Locations Player = new Locations();
        Player.CheckDay(day, LocationsVisited, Gold, Bread);
        Player.PaySpanish(day, Gold, LocationsVisited);
        Player.SelectLocation(Bread, LocationsVisited, Gold, CurrentLocation, day);
    }
    public void Mine(int Bread, int LocationsVisited, int Gold, String CurrentLocation, int day) {
        Scanner scanner = new Scanner(System.in);
        CurrentLocation = "Mine";
        if (day < 3) {
            System.out.println("You walk into the mine, where hundreds like you are also hunting for precious gold.");
            System.out.println("Are you willing to spend the entire day mining for gold?");
            String GoldMining = scanner.nextLine();
            i = 0;
            while (i < 1) {
                if (GoldMining.equalsIgnoreCase("y")||GoldMining.equalsIgnoreCase("yes")){
                    System.out.println("Lucky for you, as you dug deep into the caverns, you found one small piece of gold!");
                    System.out.println("Other Native Americans try to steal it from you, but you manage to keep it in your palms.");
                    Gold++;
                    if (LocationsVisited%3 == 0) {
                        LocationsVisited = LocationsVisited + 2;
                    }
                    else if (LocationsVisited%3 == 1) {
                        LocationsVisited = LocationsVisited + 1;
                    }
                    i = 1;
                }
                else if (GoldMining.equalsIgnoreCase("n")||GoldMining.equalsIgnoreCase("no")) {
                    System.out.println("You decide to back out from the cave.");
                    System.out.println("Select another location to visit.");
                    i = 1;
                }
                else if (GoldMining.equalsIgnoreCase("instructions")) {
                    Instructions.Intro();
                }
                else {
                    System.out.println("Enter a valid input.");
                }
            }
        }
        else {
            System.out.println("Unfortunately, all the gold has been extracted from this mine.");
            System.out.println("Select another location to visit.");
        }
        LocationsVisited++;
        Locations Player = new Locations();
        Player.CheckDay(day, LocationsVisited, Gold, Bread);
        Player.SelectLocation(Bread, LocationsVisited, Gold, CurrentLocation, day);
    }
    public void River(int Bread, int LocationsVisited, int Gold, String CurrentLocation, int day) {
        Scanner scanner = new Scanner(System.in);
        CurrentLocation = "River";
        System.out.println("You have reached the river, where Natives are digging underwater.");
        System.out.println("Are you willing to spend the entire day mining for gold?");
        String GoldMining = scanner.nextLine();
        i = 0;
        while (i < 1) {
            if (GoldMining.equalsIgnoreCase("y")||GoldMining.equalsIgnoreCase("yes")){
                System.out.println("Lucky for you, as you dig deep into the water, you found one small piece of gold!");
                System.out.println("Other Native Americans try to steal it from you, but you manage to keep it in your palms.");
                Gold++;
                if (LocationsVisited%3 == 0) {
                    LocationsVisited = LocationsVisited + 2;
                }
                else if (LocationsVisited%3 == 1) {
                    LocationsVisited = LocationsVisited + 1;
                }
                i = 1;
            }
            else if (GoldMining.equalsIgnoreCase("n")||GoldMining.equalsIgnoreCase("no")) {
                System.out.println("You decide to back out from the river.");
                System.out.println("Select another location to visit.");
                i = 1;
            }
            else if (GoldMining.equalsIgnoreCase("instructions")) {
                    Instructions.Intro();
                }
            else {
                System.out.println("Enter a valid input.");
            }
        } 
        LocationsVisited++;
        Locations Player = new Locations();
        Player.CheckDay(day, LocationsVisited, Gold, Bread);
        Player.SelectLocation(Bread, LocationsVisited, Gold, CurrentLocation, day);
    }
    public void TownSquare(int Bread, int LocationsVisited, int Gold, String CurrentLocation, int day) {
        Scanner scanner = new Scanner(System.in);
        CurrentLocation = "Town Square";
        System.out.println("You spot a small piece of bread left on a bench!");
        System.out.println("Do you pick it up?");
        String BenchBread = scanner.nextLine();
        i = 0;
        while (i < 1) {
            if (day < 3) {
                if (BenchBread.equalsIgnoreCase("y")||BenchBread.equalsIgnoreCase("yes")){
                    System.out.println("You decide to pick up the bread.");
                    Bread++;
                    i = 1;
                }  
                else if (BenchBread.equalsIgnoreCase("n")||BenchBread.equalsIgnoreCase("no")) {
                    System.out.println("You leave the bread on the table.");
                    i = 1;
                }   
                else if (BenchBread.equalsIgnoreCase("instructions")) {
                    Instructions.Intro();
                }
                else {
                    System.out.println("Enter a valid input.");
                }
            }
            else if (LocationsVisited%3 == 2) {
                System.out.println("You came to the town square just in time for dinner.");
                System.out.println("However, the Spanish charge 1 piece of gold for one piece of bread.");
                System.out.println("Do you pay?");
                String pay = scanner.nextLine();
                while (i < 1) {
                    if (pay.equalsIgnoreCase("y")||pay.equalsIgnoreCase("yes")){
                        System.out.println("You accept the payment.");
                        Gold--;
                        Bread++;
                    }
                    else if (pay.equalsIgnoreCase("n")||pay.equalsIgnoreCase("no")) {
                        System.out.println("You decline the payment.");
                    }
                    else if (pay.equalsIgnoreCase("instructions")) {
                        Instructions.Intro();
                    }
                    else {
                        System.out.println("Enter a valid input.");
                    }
                } 
            }
            else if (BenchBread.equalsIgnoreCase("instructions")) {
                    Instructions.Intro();
            }
            else {
                System.out.println("There is nothing to note here.");
            }
        } 
        LocationsVisited++;
        Locations Player = new Locations();
        Player.CheckDay(day, LocationsVisited, Gold, Bread);
        Player.SelectLocation(Bread, LocationsVisited, Gold, CurrentLocation, day);
    }
    public void CheckDay(int day, int LocationsVisited, int gold, int bread) {
        if (LocationsVisited%3 == 0 && LocationsVisited != 0) {
            System.out.println("This is the end of day " + day + ".");
            System.out.println("You now eat one piece of bread.");
            bread--;
            System.out.println("You have " + gold + "pieces of gold and " + bread + "pieces of bread.");
            day++;
            System.out.println("It is now day " + day + ".");
        }
    }
    public void PaySpanish(int day, int gold, int LocationsVisited) {
        Scanner scanner = new Scanner(System.in);
        if (day%7 == 0 && day != 0 && LocationsVisited%3 == 0 && LocationsVisited != 0) {
            System.out.println("The Spanish have arrived to take your earnings.");
            if (gold > 5) {
                System.out.println("The Spanish take 5 gold from you.");
                gold = gold - 5;
                System.out.println("You now have " + gold + "pieces of gold.");
                if (day > 21) {
                    System.out.println("You survived for 21 days! You win the game!");
                    System.out.println("Would you like to play again?");
                    String GameOver = scanner.nextLine();
                    i = 0;
                    while (i < 1) {    
                        if (GameOver.equalsIgnoreCase("y")||GameOver.equalsIgnoreCase("yes")) {
                        }
                        else if (GameOver.equalsIgnoreCase("n")||GameOver.equalsIgnoreCase("no")) {
                            System.out.println("You have exited the Native American Survival Game.");
                            System.exit(0);
                        }
                        else {
                            System.out.println("Enter a valid input.");
                        }
                    }
                }
            }
            else {
                System.out.println("You do not have enough gold!");
                System.out.println("Unfortunately, the Spanish decide to kill you for your incompetence.");
                System.out.println("You lose the game.");
                System.out.println("Would you like to try again?");
                String GameOver = scanner.nextLine();
                i = 0;
                while (i < 1) {    
                    if (GameOver.equalsIgnoreCase("y")||GameOver.equalsIgnoreCase("yes")) {
                    }
                    else if (GameOver.equalsIgnoreCase("n")||GameOver.equalsIgnoreCase("no")) {
                        System.out.println("You have exited the Native American Survival Game.");
                        System.exit(0);
                    }
                    else {
                        System.out.println("Enter a valid input.");
                    }
                }
            }
        }
    }
}