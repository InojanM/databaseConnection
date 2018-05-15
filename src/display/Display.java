package display;

import core.Database;

import java.util.*;
import java.util.ArrayList;

public class Display {

    Database database = new Database();
    Scanner scanner = new Scanner(System.in);


    public int menu() {

        int menuLenth = 0;
        int choice = 0;

        ArrayList<String> list = new ArrayList<String>();
        list.add("View All information: 1");
        list.add("Update Specify person's information: 2");
        list.add("Insert new person: 3");
        list.add("Delete a person: 4");
        list.add("Exit: 0");

        for (String li : list) {
            if (li.length() > menuLenth) {
                menuLenth = li.length();
            }
        }

        StringBuilder seperater = new StringBuilder();

        for (int i = 0; i < menuLenth; i++) {

            seperater.append("-");
        }

        for (String menu : list) {

            int balanceSpace = menuLenth - menu.length();

            StringBuilder sp = new StringBuilder();
            for (int j = 0; j < balanceSpace; j++) {
                sp.append(" ");
            }
            System.out.println("+" + seperater + "+");
            System.out.println("|" + menu + sp + "|");

        }
        System.out.println("+" + seperater + "+");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice : ");
        choice = scanner.nextInt();

        return choice;

    }


    public void selectAllInfo() {

        database.create_commection();
        database.select_all();



    }

    public void insert() {

        System.out.print("Enter name : ");
        String name = scanner.next();

        System.out.print("Enter age : ");
        int age = scanner.nextInt();

        database.create_commection();
        database.insert(name, age);

    }

    public void update() {
        System.out.println("Enter person name who do you want to update: ");
        String upname = scanner.next();

        System.out.println("Enter the new name:");
        String name = scanner.next();

        System.out.println("Enter age: ");
        int age = scanner.nextInt();

        database.create_commection();
        database.update(upname, name, age);
    }

    public void delete() {

        System.out.println("Enter person name: ");
        String name = scanner.next();

        database.create_commection();
        database.delete(name);
    }


}
