package edu.wctc;
import java.io.*;
import java.util.Scanner;

public class Main {

        private static Scanner keyboard = new Scanner(System.in);
        private static PaintCalculator paintCalculator = new PaintCalculator();

        private static void printMenu() {
            System.out.println("1.) Add room");
            System.out.println("2.) View Rooms");
            System.out.println("3.) Read Rooms to File");
            System.out.println("4.) Write Rooms to File");
            System.out.println("5.) Exit Program");

            System.out.print("Enter Choice: ");
        }

        private static double promptForDimension(String DimensionName) {
            System.out.println("Enter the dimensions");

            //System.out.println("Enter dimension 1");
            //double dim1 = keyboard.nextDouble();

            //System.out.println("Enter dimension 2");
            //double dim2 = keyboard.nextDouble();

            //not sure how or where promptForDimension is used in this program
            return keyboard.nextDouble();
        }

        private static void createRoom() {
            System.out.println("Enter a length");
            double userLength = keyboard.nextDouble();

            System.out.println("Enter a width");
            double userWidth = keyboard.nextDouble();

            System.out.println("Enter a height");
            double userHeight = keyboard.nextDouble();

            paintCalculator.addRoom(userLength, userWidth, userHeight);
        }

        private static void readFile() {
            try {
                FileInputStream fis = new FileInputStream("Rooms.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                paintCalculator = (PaintCalculator) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        private static void writeFile() {
            try {
                FileOutputStream fos = new FileOutputStream("Rooms.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(paintCalculator);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[]args)  {
            printMenu();
            int userInput = keyboard.nextInt();

            while(userInput != 5) {
                if (userInput == 1)
                {
                    createRoom();
                }
                else if (userInput == 2)
                {
                    System.out.println(paintCalculator.toString());
                }
                else if (userInput == 3)
                {
                    readFile();
                }
                else if (userInput == 4)
                {
                    writeFile();
                }
                printMenu();
                userInput = keyboard.nextInt();
            }
            System.out.println("Program Ended");
        }
}
