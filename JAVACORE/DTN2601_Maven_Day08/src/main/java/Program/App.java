package Program;

import frontend.Menu;

import java.sql.SQLException;

public class App
{
    public static void main( String[] args ) throws SQLException {
        Menu menu = new Menu() ;
        menu.run();
    }
}