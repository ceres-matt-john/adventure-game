import java.util.Scanner;
//Features:

// Inventory
// Boss Battle
// Cheat Codes
// Max HP variable



public class Game {
    public static void main(String[] args) {
        int heroHP = 20;

        Scanner input = new Scanner(System.in);
        int killCount = 0;
        int potionCount = 2;

        System.out.println("Welcome to the game!");
        System.out.println("");
        System.out.println("What is your name, hero?");
        String heroName = input.nextLine();
        System.out.println("Three monsters are terrorizing the villagers. You must defeat all three to win.");
        initCombat(heroHP, input, heroName, killCount, potionCount);

    }

    public static void initCombat(int heroHP, Scanner input, String heroName, int killCount, int potionCount){
        System.out.println("You encountered an enemy!");
        int enemyHP = (int) (Math.random( ) * 4 ) + 7 ; // HP range 7-10
        runCombatRound(heroHP, enemyHP, input, heroName, killCount, potionCount);
    }

    public static void runCombatRound(int heroHP, int enemyHP, Scanner input, String heroName, int killCount, int potionCount) {
        System.out.println("");
        System.out.println(heroName + "'s HP is: " + heroHP);
        System.out.println("Enemy HP is: " + enemyHP);
        System.out.println("");
        System.out.println("What will you do?");
        System.out.println("1. Attack | 2. Run | 3. Use Potion");
        System.out.println("Enter the number for your choice: [ 1 | 2 | 3 ]");
        String userChoice = input.nextLine();
        switch(userChoice) {
            case "1":
                heroAttack(heroHP, enemyHP, input, heroName, killCount, potionCount);
                break;
            case "2":
                System.out.println( heroName + " couldn't escape!");
                runCombatRound(heroHP, enemyHP, input, heroName, killCount, potionCount);
                break;
            case "3":
                if (potionCount == 0) {
                    System.out.println("Oh no! You're out of potions.");
                    runCombatRound(heroHP, enemyHP, input, heroName, killCount, potionCount);
                    break;
                } else {
                    heroHP += 15;
                    potionCount--;
                    System.out.println(heroName + "'s HP rose to: " + heroHP);
                    System.out.println("You have " + potionCount + " potions remaining.");
                    System.out.println("");
                    enemyAttack(heroHP, enemyHP, input, heroName, killCount, potionCount);
                    break;
                }
            default:
                System.out.println("I'm sorry, I didn't understand your instructions.");
                runCombatRound(heroHP, enemyHP, input, heroName, killCount, potionCount);
        }
    }

    public static void heroAttack(int heroHP, int enemyHP, Scanner input, String heroName, int killCount, int potionCount){
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
                initCombat(heroHP, input, heroName, killCount, potionCount);
            }
        }else {
            enemyAttack(heroHP, enemyHP, input, heroName, killCount, potionCount);
        }
    }

    public static void enemyAttack(int heroHP, int enemyHP, Scanner input, String heroName, int killCount, int potionCount){
        System.out.println("");
        int randomAttack = (int) (Math.random() * 5) + 1;
        System.out.println("Enemy attacks " +  heroName + " for " + randomAttack);
        heroHP -= randomAttack;
        if (heroHP <= 0){
            System.out.println(heroName + " died, game over!!");
        }else {
            runCombatRound(heroHP, enemyHP, input, heroName, killCount, potionCount);


        }
    }

}


