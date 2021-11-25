package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class Main {

    private static HashMap<Integer, String> tickets = new HashMap<>(); //create a hashmap, first one is an int and second is a string
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        //main menu
        while (true) { //loops forever unitl broke or exit
            System.out.println();
            System.out.println("What do you want to do ╭(◔ ◡ ◔)/ ");
            System.out.println("1. purchase a ticket or 2. check a ticket or 3. nothing ");

            try {
                int userchoice = Integer.parseInt(input.readLine()); //takes the string which the buffer gets and turns it into an integer
                switch (userchoice) {
                    case (1): //if 1 typed in follows this
                        System.out.println("you can now buy a ticket, good luck :]");
                        buyticket();
                        break;
                    case (2):
                        System.out.println("lets check the ticket now ... ;-;");
                        checkticket();
                        break;
                    case (3): // if 3 is typed inthe it exits the loop
                        System.out.println("bye bye");
                        System.exit(0);

                    default: // if anything other than 1 or 2 then goes to default
                        System.out.println("not valid choice");
                        break;
                }
            } catch (Exception e) { //if not a number
                System.out.println(e);
            }
        }
    }

    public static void buyticket (){
        try {
            System.out.println("whats you name?");
            String name = input.readLine();

            Random rand = new Random();
            int ticketnumber = rand.nextInt(999); //random number up to 999
            System.out.println("your ticket number "+ ticketnumber);

            tickets.put(ticketnumber, name); //add them to hashmap connected to each other
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void checkticket () {

        try{
            System.out.println("whats the ticket number?");
            int ticketnumber = Integer.parseInt(input.readLine()); //changes string to integer
            
            System.out.println("whats your name?");
            String name = input.readLine(); //buffered reader already in string format so don't need to change the format

            boolean valid = false;
            for (int key: tickets.keySet() ){ // loops through each of the things in the hashmap
                if (key == ticketnumber){ //check if number is in the hashmap
                    if (tickets.get(key).equals(name)){ // if number is in then checks if name connected to it is the same
                        valid = true;
                        break; //already know ticket is valid, don't need to check others
                    }
                }
            }

            if(valid) {
                if (prime(ticketnumber)) {//allows method to be able to access the variable, sees if true or false
                    System.out.println("you won  ᕕ( ᐛ )ᕗ");
                }
                else{ // if prime is false then prints this
                    System.out.println("you lost (-.-;) ");
                    System.out.println("better luck next time");
                }
            }
            else{
                System.out.println("your ticket is not valid :/");
            }
        }
        catch (Exception e ){
            System.out.println(e);
        }
    }

    public static boolean prime(int ticketnumber) {

        boolean isprime = true;
        for (int i = 2; i< 10; i++){
            if (ticketnumber == i){
                continue; // skip the iteration of when they are equal
            }
            if (ticketnumber % i == 0 ){ //means dividable by another number than 1 or itself
                isprime = false;
                break;
            }
        }


        return isprime;
    }
}
