import java.util.ArrayList;
import java.util.Scanner;

public class Main {

// Constrains the user to input an appropriate input
public static int getCount() {
    Scanner scan = new Scanner(System.in);
    System.out.println("How many characters would you like to input? [May not exceed 8 characters per roster]");
    /* Had to find a technique to scanning the int for character count,
    since it couldn't read scan.nextLine() 
    */ 
    int charcount = Integer.parseInt(scan.nextLine());
    return charcount;
}


// Update Stats METHOD
public static void Update(Attribute newRoster, ArrayList<String> roster) {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nWhat character would you like to change?");
    String name2 = scan.nextLine();
    /*Sets condition to always ask for character name until 
    a character with the roster is called upon
    */
    while (roster.indexOf(name2) == -1) {
        System.out.println("There is no character by the name " + "\"" + name2 + "\"");
        System.out.println("TRY AGAIN.");
        name2 = scan.nextLine();
    }

    newRoster.setHP(name2);
    newRoster.setDef(name2);
    newRoster.setAtk(name2);
    newRoster.setSpd(name2);

    System.out.println("\nYour stats have been changed.");
    System.out.println(newRoster);
}

// MAIN METHOD
public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    ArrayList<String> roster = new ArrayList<String>();

    System.out.println("\nGreetings Summoner!" + "\n");
    int charcount = getCount();

// Declare arrays for the stats
    double[] hp = new double[charcount];
    double[] atk = new double[charcount];
    double[] def = new double[charcount];
    int[] spd = new int[charcount];

// Loops for an appropriate input if condition wasn't met
    while (charcount > 8 || charcount <= 0) {
        System.out.println("\nPlease re-enter the input you'd like for your roster.");
        System.out.println("\nREMEMBER: Roster limit may not exceed 8 characters!" + "\n");
    charcount = getCount();
    }

// Begins the program if input was a success
    System.out.println("Please enter the names of your character(s):");
    String name = "";
    int counter = 0;

    while (counter < charcount && counter <= 6) {
        name = scan.nextLine();
        roster.add(name);
        counter++;
    }

// Series of stat inputs for each character
    System.out.println("\nEnter the hitpoints of " + roster.get(0) + ":");
    hp[0] = scan.nextDouble();
    System.out.println("\nEnter the attack points of " + roster.get(0) + ":");
    atk[0] = scan.nextDouble();
    System.out.println("\nEnter the defense points of " + roster.get(0) + ":");
    def[0] = scan.nextDouble();
    System.out.println("\nEnter the speed of " + roster.get(0) + ":");
    spd[0] = scan.nextInt();
// Continues through the rest of the roster after the first character ~
    for (int i = 1; i < charcount; i++) {
        System.out.println("\nEnter the hitpoints of " + roster.get(i) + ":");
        hp[i] = scan.nextDouble();
        System.out.println("\nEnter the attack points of " + roster.get(i) + ":");
        atk[i] = scan.nextDouble();
        System.out.println("\nEnter the defense points of " + roster.get(i) + ":");
        def[i] = scan.nextDouble();
        System.out.println("\nEnter the speed of " + roster.get(i) + ":");
        spd[i] = scan.nextInt();
    }

// Displays the newly created roster
    System.out.println("\n\nYour roster: " + roster);
    Attribute newRoster = new Attribute(roster, hp, def, atk, spd);
    System.out.println(newRoster);

// Stat Changer
    int checker = 1;
    while (checker == 1) {
        scan.nextLine();
        System.out.println("Would you like to change the stats for any of your characters?");
        String perhaps = scan.nextLine();
        String confirm = "yes";
        String confirm2 = "sure";
        String decline = "no";
    if (confirm.equals(perhaps.toLowerCase()) || confirm2.equals(perhaps.toLowerCase())) {
        Update(newRoster, roster);
    }
    if (decline.equals(perhaps.toLowerCase())) {
        checker = 0;
    }
  }
 }
}