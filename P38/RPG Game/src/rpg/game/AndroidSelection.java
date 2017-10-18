/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author syk2011
 */
public class AndroidSelection {

    
    private int androidChoice;
    
    public String androidName;
    public Android playerAndroid;
    public int androidNum;
    private boolean repeat = true;
    
    public AndroidSelection() {
        super();
        options();
        calculateAndroid();
        nameAndroid();
    }
    
    //ALLOW USER TO PICK WHICH ANDRIOD
    public void options() {
        System.out.println("  (1)RED ANDROID - A small and agile bot  ");
        System.out.println("     with a sharper edge - can deal more  ");
        System.out.println("     damage but is more fragile.         ");
        System.out.println("     -------------------------------------");
        System.out.println("  (2)GOLD ANDROID - A larger and stiff bot");
        System.out.println("     with a blunt edge - is more durable in ");
        System.out.println("     the field but is less menacing.");
        System.out.println("     -------------------------------------");
        System.out.println("  (3)GREEN ANDROID - A more well rounded bot ");
        System.out.println("     that is sufficient in both defence and ");
        System.out.println("     offence.");
        System.out.println("     -------------------------------------");
   
        do {
            try{
                System.out.print("Select a companion android from the options above, to explore where you cannot: ");
                
                Scanner sc = new Scanner(System.in);
                androidChoice = sc.nextInt();
                
                if (androidChoice < 1 || androidChoice > 3) {
                    throw new IllegalArgumentException();
                }
                else if(androidChoice == 1 || androidChoice == 2 || androidChoice == 3) {
                    repeat = false;
                    String androidColor = "";
                    if (androidChoice == 1) {
                        androidColor = "RED ANDROID"; 
                    }
                    else if (androidChoice == 2) {
                        androidColor = "GOLD ANDROID"; 
                    }
                    else if (androidChoice == 3) {
                        androidColor = "GREEN ANDROID"; 
                    }
                    System.out.println("You chose android " + androidChoice + ", the " + androidColor + "...");
                }

            }catch(InputMismatchException e) { //IF THEY ENTER A STRING
                System.out.println("Input Error. Please choose an android by typing 1, 2, 3 respectivly, then press enter"); 
            }catch(IllegalArgumentException e) { //IF THEY ENTER 0 or 4+
                System.out.println("Input Error. Please choose an android by typing 1, 2, 3 respectivly, then press enter");
            }

        } while (repeat);
        
    }
    
    //ALLOCATE WHICH ANDROID THE PLAYER CHOSE
    private void calculateAndroid() {
        if (androidChoice == 1) {
            playerAndroid = new AndroidDMG();
            androidNum = 1;
        } else if (androidChoice == 2) {
            playerAndroid = new AndroidDEF();
            androidNum = 2;
        } else if (androidChoice == 3) {
            playerAndroid = new AndroidJACK();
            androidNum = 3;
        }
    }
    
    //ALLOW USER TO NAME ANDROID
    public void nameAndroid() {
        System.out.print("Name your companion android: ");
        Scanner scan = new Scanner(System.in);
        androidName = scan.nextLine();
    }
}
