package app;

import core.Database;
import display.Display;

import java.sql.*;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        Display display = new Display();
        Database database = new Database();
        database.create_commection();

        int choice;
        int fixed = 0;
        while (fixed == 0) {
            choice = display.menu();
            if (choice == 1) {
                display.selectAllInfo();
            }

            if (choice == 2) {
                display.update();
            }

            if (choice == 3) {
                display.insert();
            }

            if (choice == 4) {
                display.delete();
            }


            if (choice == 0) {
                fixed = 1;
            }
        }


    }
}
