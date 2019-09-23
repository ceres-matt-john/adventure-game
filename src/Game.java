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
        initCombat(heroHP, enemyHP, input);

    }

    public static void initCombat(int heroHP, int enemyHP, Scanner input){
        System.out.println("You encountered an enemy!");

        heroAttack(heroHP, enemyHP, input);
    }

    public static void heroAttack(int heroHP, int enemyHP, Scanner input){
        System.out.println("Your HP is: " + heroHP);
        System.out.println("Enemy HP is: " + enemyHP);
        int randomAttack = (int) (Math.random() * 5) + 1;
        System.out.println("You attack enemy for " + randomAttack);
        enemyHP -= randomAttack;
        if (enemyHP <= 0){
            System.out.println("Congrats you win!!");
        }else {
            System.out.println("Battle continues");
            heroAttack(heroHP, enemyHP, input);
//          ===Would call enemy attack method

        }
    }

}


