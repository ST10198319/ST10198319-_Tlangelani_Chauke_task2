package ST10198319_TlangelaniChauke_PROG5121TASK1;

import sun.security.util.Password;

import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

 public class Main {
    static Scanner scan = new Scanner(System.in);
    //The scanner is here because I want it to be used throughout my class
    public static void main(String[] args) {
        // write your code here

        System.out.println("Enter your first name");
        String firstName = scan.nextLine();

        System.out.println("Enter your last name");
        String lastName = scan.nextLine();
        registerUser();

        System.out.println("Please create your username");
        System.out.println("Ensure that username is less than or equal to 5 characters and it has an underscore");
        String userName = scan.nextLine();
        System.out.println(checkUserName(userName));

        System.out.println("Create a Password");
        System.out.println("Ensure that password has special characters, a digit, an uppercase letter and is greater than 8 characters");
        String Password = scan.nextLine();
        System.out.println(checkPasswordComplexity(Password));
        while (!checkPasswordComplexity(Password)) {
            //Placed the while loop here so it can loop back if the user enters incorrect information
            Password = scan.next();
            if (checkPasswordComplexity(Password)) {
                System.out.println("May you please try again while following the instructions above");
            }
            else{
                break;
            }
        }

        System.out.println("Please login");
        String Login = scan.nextLine();
        System.out.println(firstName + lastName );
        System.out.println(loginUser(userName , Password));

        System.out.println(returnLoginStatus(userName,Password));
    }
    public static boolean checkUserName(String userName) {
        boolean underScore = false;
        while (userName.length()>5 || !userName.contains("_")) {
            //if username is greater than 5 or doesn't consist of an underscore it will loop back
            System.out.println("incorrect formatting ");
            userName= scan.next();
        }
        if (!userName.contains("_")) {
                System.out.println("try again including an underscore");
            }

      if(userName.contains("_")){
          System.out.println("Valid username entered");
      }
      return true;
    }

    public static boolean checkPasswordComplexity(String password) {
        boolean uppercase = false;
        boolean specialCharacter = false;
        boolean digit = false;
        //declaring the conditions of the password which should be entered
        int t;
        int digitCount = 0;
        int capitalLetterCount = 0;
        int SpecialCharCount = 0;

        for (t = 0; t < password.length(); t++) {
            char x = password.charAt(t);
            //the char x is because i didn't want to write password.charAt(t) over and over
            if (password.length() <8) {
                System.out.println("incorrect formatting of password");
                password = scan.next();
            }
            if (x >= 65 && x <= 90) {
                capitalLetterCount++;
            } else if (x >= 48 && x <= 57) {
                digitCount++;
            } else if (x >= 33 && x <= 47) {
                SpecialCharCount++;
            }
        }
        if (capitalLetterCount >=1) {
            uppercase = true;
        }
        if (SpecialCharCount >=1) {
            specialCharacter = true;
        }
        if (digitCount >=1) {
            digit = true;
        }
        if(uppercase && specialCharacter && digit && password.length()>=8){
            return true;
        }
        else {
            return false;
        }
    }
    public static String registerUser(){
        return "registration completed";
    }
    public static boolean loginUser(String Password,String username){
        System.out.println("Enter username");
        String Lusername = scan.nextLine();

        System.out.println("Enter Password");
        String Lpassword = scan.nextLine();

        //if the login username or the login password is not the actual username or password it must not allow access
        if (!Lusername.equals(username)) {
            System.out.println("Username is incorrect");

            if (!Lpassword.equals(Password)) {
                System.out.println("Password");
            }
        }
        else {
            return false;
        }
        return true;
    }
    public static String returnLoginStatus(String usernameLog,String PasswordLog){
        if (loginUser(usernameLog, PasswordLog)){
            System.out.println("Welacome back it is good to see you again");
        }
        else{
            System.out.println("Login failed");
        }
        return "Logged in";
    }

}
public class Task2 {

    static Scanner scan = new Scanner(System.in);
while(loginUser(usernameLog, PasswordLog)==Logged in)

    {
        public static void main (String[]args){

        String option = JOptionPane.showInputDialog("Welcome to EasyKanban\nOption 1: Add tasks\nOption 2: Coming soon\nOption 3: Quit");

        if (option.equals("1")) {
            System.out.println("How many tasks do you want to add?");
        }
        int numTasks = scan.nextInt();
        for (int t = 0; t < numTasks; t++) {
            System.out.println("Task Name: ");
            String taskName = scan.next();

            System.out.println("Task Number: " + (t));

            System.out.println("Task Description: ");
            String taskDescription = scan.next();
            System.out.println(checkTaskDescription(taskDescription));

            System.out.println("Enter first name:");
            String firstName = scan.next();

            System.out.println("Enter last name:");
            String lastName = scan.next();

            System.out.println("Enter the duration of your task: ");
            int taskDuration = scan.nextInt();

            System.out.println("Task ID:");
            createTaskID(taskName, t, firstName);

            System.out.println("Enter Task status: \nTo Do\nDone\nDoing");
            String taskStatus = scan.next();

            JOptionPane.showMessageDialog(null, printTaskDetails(taskStatus, firstName, lastName, t, taskName, taskDuration, taskDescription));

            JOptionPane.showMessageDialog(null, returnTotalHours(t, taskDuration));

        }
        if (option.equals("2")) {
            System.out.println("Coming soon");
        }
        if (option.equals("3")) {
            System.exit(0);
        }
    }
    }
    public static boolean checkTaskDescription(String taskDescription) {
        if (taskDescription.length() <= 50) {
            System.out.println("Description successfully captured");
        }
        else{
            System.out.println("Description should be less than 50 words");
            return false;
        }
        return true;
    }

    public static String createTaskID(String taskName,int t,String firstName){

        return taskName.substring(0,2) + ":" + (t) + ":" + firstName.substring(firstName.length() - 3);
    }
    public static  String printTaskDetails(String taskStatus, String firstName, String lastName, int t, String taskName, int duration, String taskDescription){
        //A JOptionPane will display all the task details to the user.
        return "Task Status: " + taskStatus
                + "\nDeveloper Details: " + firstName + lastName
                + "\nTask Number: " + t
                + "\nTask name: " + taskName
                + "\nTask Description: " + taskDescription
                + "\n Task ID: " + createTaskID(taskName,t, firstName)
                + "\n Task duration: " + duration + "hours" ;
    }
    public static int returnTotalHours(int t, int taskDuration){
        // This method adds up all the taskDurations of all tasks.
        int sum = 0;
        for (int i = 0; i < t; i++){
            sum += taskDuration;

        }
        return sum;
    }
}