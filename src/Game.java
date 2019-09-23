import java.util.Scanner;
//Features:

//Multi enemies
//Potion


public class Game {
    public static void main(String[] args) {
        int heroHP = 10;
        int enemyHP = 10;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the game!");
        System.out.println("");
        System.out.println("What is your name, hero?");
        String heroName = input.nextLine();
        initCombat(heroHP, enemyHP, input, heroName);

    }

    public static void initCombat(int heroHP, int enemyHP, Scanner input, String heroName){
        System.out.println("You encountered an enemy!");
        runCombatRound(heroHP, enemyHP, input, heroName);
    }

    public static void runCombatRound(int heroHP, int enemyHP, Scanner input, String heroName) {
        System.out.println("");
        System.out.println(heroName + "'s HP is: " + heroHP);
        System.out.println("Enemy HP is: " + enemyHP);
        System.out.println("");
        System.out.println("What will you do?");
        System.out.println("1. Attack | 2. Run [ 1 | 2 ]");
        String userChoice = input.nextLine();
        switch(userChoice) {
            case "1":
                heroAttack(heroHP, enemyHP, input, heroName);
                break;
            case "2":
                System.out.println( heroName + " couldn't escape!");
                runCombatRound(heroHP, enemyHP, input, heroName);
                break;
            default:
                System.out.println("I'm sorry, I didn't understand your instructions.");
                runCombatRound(heroHP, enemyHP, input, heroName);
        }
    }

    public static void heroAttack(int heroHP, int enemyHP, Scanner input, String heroName){
        System.out.println("");
        int randomAttack = (int) (Math.random() * 5) + 1;
        System.out.println( heroName + " attacks enemy for " + randomAttack);
        enemyHP -= randomAttack;
        if (enemyHP <= 0){
            System.out.println("Congrats you win!!");
        }else {
            enemyAttack(heroHP, enemyHP, input, heroName);


        }
    }

    public static void enemyAttack(int heroHP, int enemyHP, Scanner input, String heroName){
        System.out.println("");
        int randomAttack = (int) (Math.random() * 3) + 1;
        System.out.println("Enemy attacks " +  heroName + " for " + randomAttack);
        heroHP -= randomAttack;
        if (heroHP <= 0){
            System.out.println(heroName + " died, game over!!");
        }else {
            runCombatRound(heroHP, enemyHP, input, heroName);
//          ===Would call enemy attack method

        }
    }

}


