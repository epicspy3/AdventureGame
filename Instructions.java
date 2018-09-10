public class Instructions {
    public static void Intro() {
        System.out.println("Welcome to the Native American Survival Game.");
        System.out.println("The year is 1500.");
        System.out.println("You have been enslaved by the Spanish.");
        Instructions.Instructions();
        System.out.println("At any time, you may call for instructions when an input is required \nthrough typing \"Instructions.\"");
        System.out.println("Good Luck!");
        System.out.println("Press enter to start the game.");
    }
    public static void Instructions() {
        System.out.println("--------------------------INSTRUCTIONS--------------------------");
        System.out.println("Objective: Find as much gold as possible in different locations.");
        System.out.println("You can visit one location per day before heading home.");
        System.out.println("Locations:");
        System.out.println("Mine");
        System.out.println("River");
        System.out.println("Town Square");
        System.out.println("Home");
        System.out.println("In addition to finding gold, you must feed yourself.");
        System.out.println("You start with 0 gold and three pieces of bread.");
        System.out.println("Every day, you eat one piece of bread.");
        System.out.println("Once you go one day without food, you will lose the game from starvation.");
        System.out.println("The Spanish will collect 5 pieces of gold every week.");
        System.out.println("If you fail to obtain 5 pieces of gold, you lose this game.");
    }
}
