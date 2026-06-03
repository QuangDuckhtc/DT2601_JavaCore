

import frontend.Menu;
import frontend.StudentFunction;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        StudentFunction program = new StudentFunction();
        Menu menu = new Menu(program);
        menu.start();
    }
}