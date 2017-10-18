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
 * @author berne
 */
public class CharacterSelection {

    private boolean gender; //true is boy, false is girl
    private String isGender;

    private Scanner sc;

    public CharacterSelection() {
        characterGeneration();
    }

    private void characterGeneration() {
        sc = new Scanner(System.in);
        boolean sexUnknown = true;

        do {
            try {
                System.out.print("Are you [m]ale or [f]emale? ");
                isGender = sc.nextLine();

                if (isGender.equalsIgnoreCase("m") || isGender.equalsIgnoreCase("male")) {
                    gender = true; //MALE
                    sexUnknown = false;
                    System.out.println("#====================You are MALE====================#");
                } else if (isGender.equalsIgnoreCase("f") || isGender.equalsIgnoreCase("female")) {
                    gender = false; //FEMALE
                    sexUnknown = false;
                    System.out.println("#===================You are FEMALE===================#");
                } else {
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException e) { //IF USER ENTERS A NUMBER
                System.out.println("Input error. Please enter your gender by typing m for male and f for female, then press enter");
            }
    }while (sexUnknown);

}
    
}
    

