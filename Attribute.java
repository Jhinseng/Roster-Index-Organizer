import java.util.ArrayList;
import java.util.Scanner;

// Declaring the Attribute class
public class Attribute {
    private ArrayList<String> character = new ArrayList<String>();
    private double[] hitpoint;
    private double[] defense; 
    private double[] attack;
    private int[] speed;

    Scanner scan = new Scanner(System.in);

// Initializes the arrays to the new arrays
    public Attribute(ArrayList<String> roster, double[] hp, double[] def, double[] atk, int[] spd) {
        for (int i = 0; i < roster.size(); i++) {
            character.add(roster.get(i));
        }

    hitpoint = hp;
    defense = def;
    attack = atk;
    speed = spd;
    }

// Stat-Setting Methods
    public void setHP(String name) {
        int index = character.indexOf(name);
        System.out.println("Enter a value to change the hitpoints:");
        hitpoint[index] = scan.nextDouble();
    }

    public void setDef(String name) {
        int index = character.indexOf(name);
        System.out.println("Enter a value to change the defense:");
        defense[index] = scan.nextDouble();
    }

    public void setAtk(String name) {
        int index = character.indexOf(name);
        System.out.println("Enter a value to change the attack:");
        attack[index] = scan.nextDouble();
    }

    public void setSpd(String name) {
        int index = character.indexOf(name);
        System.out.println("Enter a value to change the speed:");
        speed[index] = scan.nextInt();
    }

// Built-in print METHOD
    public String toString() {
        String format = "";
        for (int i = 0; i < character.size(); i++) {
            format += "\n_____________\n" + "| " + character.get(i) + " |\n" 
            + "HP - " + hitpoint[i] + "\nAtk - " + attack[i] + "\nDef - " + defense[i] 
            + "\nSpeed - " + speed[i] + "\n";
        }
        return format;
    }
}