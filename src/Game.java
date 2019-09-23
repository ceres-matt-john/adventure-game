import java.util.Scanner;
//Features:

// setTimeout function
// Max HP variable
// Strength Potion
// Refactor game win to be a separate method call



public class Game {

    public static void main(String[] args) {
        int heroHP = 20;
        Scanner input = new Scanner(System.in);
        int killCount = 0;
        int potionCount = 2;
                    //        System.out.println("Welcome to the game!");
                    //        System.out.println("");
                    //        System.out.println("No ASCII art here, buddy.");
                    //        System.out.println("#R.I.P. Bootstrap");
                    //        System.out.println("");
                    //        System.out.println("What is your name, hero?");
        openingText();
        String heroName = input.nextLine();
        // Cheat Code #1 - Advance directly to Boss Battle
        if (heroName.equalsIgnoreCase("uuddlrlrba")) {
            bossBattle(heroHP, input, heroName, killCount, potionCount);
        }
        // Cheat Code #2 -- Plus 30 HP
        else if (heroName.equalsIgnoreCase("Justin") ||
            heroName.equalsIgnoreCase("Fernando") ||
            heroName.equalsIgnoreCase("Fer")) {
            heroHP += 30;
            System.out.println("Ah, Master " + heroName + "! I didn't recognize you. ");
            System.out.println("(You've earned a 30 HP boost!)");
            System.out.println("");
            System.out.println("Three monsters are terrorizing the villagers. You must defeat all three to win.");
            initCombat(heroHP, input, heroName, killCount, potionCount);
        }
        // Regular Play Conditions
        else {
            System.out.println("Three monsters are terrorizing the villagers. You must defeat all three to win.");
            initCombat(heroHP, input, heroName, killCount, potionCount);
        }
    }

    public static void initCombat(int heroHP, Scanner input, String heroName, int killCount, int potionCount){
        System.out.println("You encountered an enemy!");
        int enemyHP = (int) (Math.random( ) * 4 ) + 7 ; // HP range 7-10
        runCombatRound(heroHP, enemyHP, input, heroName, killCount, potionCount);
    }

    public static void runCombatRound(int heroHP, int enemyHP, Scanner input, String heroName, int killCount, int potionCount) {
        menuOptions(heroName, heroHP, enemyHP);
        String userChoice = input.nextLine();
        switch(userChoice) {
            // 1: Attack
            case "1":
                heroAttack(heroHP, enemyHP, input, heroName, killCount, potionCount);
                break;
            // 2: Run
            case "2":
                System.out.println( heroName + " couldn't escape!");
                runCombatRound(heroHP, enemyHP, input, heroName, killCount, potionCount);
                break;
            // 3: Use Potion
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
            // 4. Check Inventory
            case "4":
                System.out.println("You have " + potionCount + " potions remaining.");
                System.out.println("");
                runCombatRound(heroHP, enemyHP, input, heroName, killCount, potionCount);
                break;
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
            // If Konami code cheater has defeated boss, automatically advance kill count to 4 to trigger game win
            if (heroName.equalsIgnoreCase("uuddlrlrba")) {
                killCount = 4;
            }
            else {
                killCount++;
            }
            // Display kill count as long as Boss Battle hasn't happened
            if (killCount != 4) {
            System.out.println(heroName + " has defeated " + killCount + " monsters.");
            System.out.println("");
            }
            // Win Condition
            if(killCount == 4){
                System.out.println("You have defeated the boss!");
                System.out.println("You win! Congrats!");
            }else if (killCount == 3){ // Initiate Boss Battle
                bossIntroText();
                bossBattle(heroHP, input, heroName, killCount, potionCount);
            }else{ // Enemy killed, but have not yet reached boss battle
                initCombat(heroHP, input, heroName, killCount, potionCount);
            }
        }else { // enemy not dead, enemy attack
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

    public static void bossBattle(int heroHP, Scanner input, String heroName, int killCount, int potionCount){
        System.out.println("Uh! Oh! Here comes the boss!");
        int bossHP = 30;
        runCombatRound(heroHP, bossHP, input, heroName, killCount, potionCount);
    }

    // Methods for large chunks of text

    public static void openingText() {
        System.out.println("Welcome to the game!");
        System.out.println("");
        System.out.println("No ASCII art here, buddy.");
        System.out.println("#R.I.P. Bootstrap");
        System.out.println("");
        System.out.println("What is your name, hero?");
    }

    public static void menuOptions(String heroName, int heroHP, int enemyHP) {
        System.out.println("");
        System.out.println(heroName + "'s HP is: " + heroHP);
        System.out.println("Enemy HP is: " + enemyHP);
        System.out.println("");
        System.out.println("What will you do?");
        System.out.println("1. Attack | 2. Run | 3. Use Potion | 4. Check Inventory");
        System.out.println("Enter the number for your choice: [ 1 | 2 | 3 | 4 ]");
    }

    public static void bossIntroText() {
        System.out.println("You have defeated all the monsters!");
        System.out.println("The villagers have been saved...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
    }

}


