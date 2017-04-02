package MySQL;

import Other.Functions;

import java.sql.SQLException;

/**
 * Created by ismailcam on 27/03/2017.
 */
public class Main
{
    public static void main(String[] args) throws SQLException
    {
        MySQL mySQL = new MySQL();
        Functions func = new Functions();

        for( Integer id : func.getIdList() )
        {
            mySQL.connect();
            //mySQL.runEx( mySQL.exA( id ), func.getTimeList() );
            //mySQL.runEx( mySQL.exB( id ), func.getTimeList() );
            //mySQL.runEx( mySQL.exC( id ), func.getTimeList() );
            //mySQL.runEx( mySQL.exD( id ), func.getTimeList() );
           //mySQL.runEx( mySQL.exE( id ), func.getTimeList() );
            mySQL.close();
        }

        func.writeToCSVFile( "MySQL-TimeResults" );
    }
}
