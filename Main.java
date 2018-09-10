import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Locations player = new Locations();
        int Bread = 0;
        int LocationsVisited = 0;
        int Gold = 0;
        int day = 0;
        String CurrentLocation = "Home";
        System.out.print('\u000C');
        Scanner scanner = new Scanner(System.in);
        Instructions.Intro();
        scanner.nextLine();
        player.Home(Bread, LocationsVisited, Gold, CurrentLocation, day);
    }
}