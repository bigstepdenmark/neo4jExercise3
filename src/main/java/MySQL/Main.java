package MySQL;

import java.sql.SQLException;

/**
 * Created by ismailcam on 27/03/2017.
 */
public class Main
{
    public static void main(String[] args) throws SQLException
    {
        MySQL mySQL = new MySQL();

        mySQL.connect();
        mySQL.runEx( mySQL.exA(0) );
        mySQL.close();
    }
}
