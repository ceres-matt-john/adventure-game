import java.util.Scanner;
//Features
//Hero attacks
//Enemy attacks
//Custom hero name
//Multi enemies
//Potion


public class Game {
    public static void main(String[] args) {
        int heroHP = 10;
        int enemyHP = 10;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the game!");
        System.out.println("");
        initCombat(heroHP, enemyHP, input);

    }

    public static void initCombat(int heroHP, int enemyHP, Scanner input){
        System.out.println("You encountered an enemy!");
        runCombatRound(heroHP, enemyHP, input);
    }

    public static void runCombatRound(int heroHP, int enemyHP, Scanner input) {
        System.out.println("");
        System.out.println("Your HP is: " + heroHP);
        System.out.println("Enemy HP is: " + enemyHP);
        System.out.println("");
        System.out.println("What will you do?");
        System.out.println("1. Attack | 2. Run [ 1 | 2 ]");
        String userChoice = input.nextLine();
        switch(userChoice) {
            case "1":
                heroAttack(heroHP, enemyHP, input);
                break;
            case "2":
                System.out.println("You couldn't escape!");
                runCombatRound(heroHP, enemyHP, input);
                break;
            default:
                System.out.println("I'm sorry, I didn't understand your instructions.");
                runCombatRound(heroHP, enemyHP, input);
        }
    }

    public static void heroAttack(int heroHP, int enemyHP, Scanner input){
        System.out.println("");
        int randomAttack = (int) (Math.random() * 5) + 1;
        System.out.println("You attack enemy for " + randomAttack);
        enemyHP -= randomAttack;
        if (enemyHP <= 0){
            System.out.println("Congrats you win!!");
        }else {
            runCombatRound(heroHP, enemyHP, input);
//          ===Would call enemy attack method

        }
    }

}


