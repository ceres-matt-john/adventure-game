import java.util.Scanner;
//Features:

//Multi enemies
//Potion


public class Game {
    public static void main(String[] args) {
        int heroHP = 20;

        Scanner input = new Scanner(System.in);
        int killCount = 0;

        System.out.println("Welcome to the game!");
        System.out.println("");
        System.out.println("What is your name, hero?");
        String heroName = input.nextLine();
        System.out.println("Three monsters are terrorizing the villagers. You must defeat all three to win.");
        initCombat(heroHP, input, heroName, killCount);

    }

    public static void initCombat(int heroHP, Scanner input, String heroName, int killCount){
        System.out.println("You encountered an enemy!");
        int enemyHP = (int) (Math.random( ) * 4 ) + 7 ; // HP range 7-10
        runCombatRound(heroHP, enemyHP, input, heroName, killCount);
    }

    public static void runCombatRound(int heroHP, int enemyHP, Scanner input, String heroName, int killCount) {
        System.out.println("");
        System.out.println(heroName + "'s HP is: " + heroHP);
        System.out.println("Enemy HP is: " + enemyHP);
        System.out.println("");
        System.out.println("What will you do?");
        System.out.println("1. Attack | 2. Run [ 1 | 2 ]");
        String userChoice = input.nextLine();
        switch(userChoice) {
            case "1":
                heroAttack(heroHP, enemyHP, input, heroName, killCount);
                break;
            case "2":
                System.out.println( heroName + " couldn't escape!");
                runCombatRound(heroHP, enemyHP, input, heroName, killCount);
                break;
            default:
                System.out.println("I'm sorry, I didn't understand your instructions.");
                runCombatRound(heroHP, enemyHP, input, heroName, killCount);
        }
    }

    public static void heroAttack(int heroHP, int enemyHP, Scanner input, String heroName, int killCount){
        System.out.println("");
        int randomAttack = (int) (Math.random() * 5) + 1;
        System.out.println( heroName + " attacks enemy for " + randomAttack);
        enemyHP -= randomAttack;
        if (enemyHP <= 0){
            killCount++;
            System.out.println(heroName + " has defeated " + killCount + " monsters.");
            System.out.println("");
//            Win condition kill 3 enemies. Otherwise, start a new battle.
            if (killCount >= 3){
                System.out.println("Congrats you win!!");
            }else{
                initCombat(heroHP, input, heroName, killCount);
            }
        }else {
            enemyAttack(heroHP, enemyHP, input, heroName, killCount);


        }
    }

    public static void enemyAttack(int heroHP, int enemyHP, Scanner input, String heroName, int killCount){
        System.out.println("");
        int randomAttack = (int) (Math.random() * 5) + 1;
        System.out.println("Enemy attacks " +  heroName + " for " + randomAttack);
        heroHP -= randomAttack;
        if (heroHP <= 0){
            System.out.println(heroName + " died, game over!!");
        }else {
            runCombatRound(heroHP, enemyHP, input, heroName, killCount);


        }
    }

}


