package edu.wctc;

import jdk.internal.module.ModuleInfoExtender;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.channels.WritePendingException;
import java.util.Scanner;

public class Main {

        private static Scanner keyboard;
        private static PaintCalculator paintCalculator;

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
                File file = new File("Rooms.txt");
                Scanner fileReader = new Scanner(file);

                while (fileReader.hasNextLine()) {
                    String oneRoom = fileReader.nextLine();
                    System.out.println(oneRoom);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File Doesnt Exist");
            }
        }

        private static void writeFile() {
            try {
                File file = new File("Rooms.txt");

                file.write(paintCalculator.toString());

            } catch (WritePendingException | FileNotFoundException e) {
                System.out.println("File could not be written to");
            }
        }

        public static void main(String[]args)  {

            while(userInput != 5) {
                printMenu();
                int userInput = keyboard.nextInt();

                if (userInput == 1)
                {
                    createRoom();
                }
                else if (userInput == 2)
                {
                    System.out.println(paintCalculator.getClass(roomList));
                }
                else if (userInput == 3)
                {
                    readFile();
                }
                else if (userInput == 4)
                {
                    writeFile();
                }
            } fileReader.close();
            System.out.println("Program Ended");
        }
}
