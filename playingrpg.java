package RPG;

import java.util.Scanner;
import java.util.Random;
public class playingrpg {
    
    void battle() throws InterruptedException{
        Scanner gg = new Scanner(System.in);
        Random random = new Random();
        int RNGDef,enemyAttack,attack;

        System.out.println("Battling...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
        Thread.sleep(900);
        int HP = random.nextInt(50)+50;
        int enemyHP = random.nextInt(50)+50;
        do {
            System.out.println("HP "+HP+"\nEnemy HP: "+enemyHP);
            System.out.println("1.Attack\n2.Defense\n3.Dodge");
            System.out.println("~~~~~~~~~~~~~~~~");
            int option = gg.nextInt();
            switch(option) {
                case 1: attack = random.nextInt(10)+10; enemyAttack = random.nextInt(10)+10; RNGDef = random.nextInt(11);
                System.out.println("You attacked!");
                if (RNGDef >=0 && RNGDef <=3) {
                    Thread.sleep(1000);
                    System.out.println("Enemy Deflected Your Attack!");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                } else if (RNGDef >3 && RNGDef <=9) {
                    Thread.sleep(1000);
                    System.out.println("You Succesfully attacked!\nEnemy Lost "+attack+" HP!");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    enemyHP -= attack;
                } else if (RNGDef == 10) {
                    Thread.sleep(1000);
                  System.out.println("You Failed to Attack!\nEnemy hit you back and you lost "+enemyAttack+" HP!");
                  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    HP -= enemyAttack;
                } break;

                case 2: int shieldHP = 100; RNGDef = random.nextInt(11); enemyAttack = random.nextInt(10)+10;
                System.out.println("You've used your shield!");
                if (RNGDef >=0 && RNGDef <=7){
                    shieldHP -= enemyAttack;
                    Thread.sleep(1000);
                    System.out.println("You've successfully deflected enemy attacks!\nYoure shield strength "+shieldHP);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                } else if (RNGDef >=8 && RNGDef <=10){ 
                    Thread.sleep(1000);
                    System.out.println("You've failed to deflected enemy attacks!\nYou've lost "+enemyAttack+"HP!");
                    HP -= enemyAttack;
            } break;

            case 3: int Dodge = random.nextInt(11); enemyAttack = random.nextInt(10)+10; attack = random.nextInt(10)+10;
            System.out.println("You tried to dodge enemy attacks!");
            if (Dodge > 0 && Dodge <=5)  {
            enemyHP-=attack; 
            Thread.sleep(1000);
            System.out.println("You dodged the enemy attacks and hit back!\nEnemy lost "+attack+" HP");
            } else if (Dodge >=6 && Dodge <=10){
            HP -= enemyAttack;
            Thread.sleep(1000);
            System.out.println("You failed to dodge the enemy.\nYou lost "+HP+" HP");
            }
        }
    } while (enemyHP > 0 && HP > 0);
}
}