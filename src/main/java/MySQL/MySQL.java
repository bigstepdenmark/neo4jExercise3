package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ismailcam on 27/03/2017.
 */
public class MySQL
{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public Connection connect()
    {
        String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        String user = "root";
        String password = "pwd";

        try
        {
            connection = DriverManager.getConnection( url, user, password );
        }
        catch( SQLException e )
        {
            System.out.println( "Connection error!" );
        }

        return connection;
    }

    public void close() throws SQLException
    {
        if( resultSet != null ) resultSet.close();
        if( statement != null ) statement.close();
        if( connection != null ) connection.close();
    }

    private void setResultSet(String query) throws SQLException
    {
        statement = connection.createStatement();
        resultSet = statement.executeQuery( query );
    }

    // A: all persons that a person endorses, i.e., endorsements of depth one.
    public void exA(int id) throws SQLException
    {
        // language=SQL
        String query = "";
        query += "SELECT myfriend.name AS myfriend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        setResultSet( query );

        System.out.println( "\n::::::::::::::: Ex: A :::::::::::::::" );
        while( resultSet.next() )
        {
            System.out.println( resultSet.getString( "myfriend_name" ) );
        }
    }

    // B: all persons that are endorsed by endorsed persons of a person, i.e., endorsements of depth two.
    public void exB(int id) throws SQLException
    {
        // language=SQL
        String query = "";
        query += "SELECT myfriendsfriend.name AS myfriendsfriend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsrelation ON (myfriendsrelation.source_node_id = myfriend.id) ";
        query += "JOIN t_user myfriendsfriend ON (myfriendsfriend.id = myfriendsrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        setResultSet( query );

        System.out.println( "\n::::::::::::::: Ex: B :::::::::::::::" );
        while( resultSet.next() )
        {
            System.out.println( resultSet.getString( "myfriendsfriend_name" ) );
        }
    }

    // C: endorsements of depth three.
    public void exC(int id) throws SQLException
    {
        // language=SQL
        String query = "";
        query += "SELECT myfriendsfriendsfriend.name AS myfriendsfriendsfriend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsrelation ON (myfriendsrelation.source_node_id = myfriend.id) ";
        query += "JOIN t_user myfriendsfriend ON (myfriendsfriend.id = myfriendsrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendrelation ON (myfriendsfriendrelation.source_node_id = myfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriend ON (myfriendsfriendsfriend.id = myfriendsfriendrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        setResultSet( query );

        System.out.println( "\n::::::::::::::: Ex: C :::::::::::::::" );
        while( resultSet.next() )
        {
            System.out.println( resultSet.getString( "myfriendsfriendsfriend_name" ) );
        }
    }

    // D: endorsements of depth four.
    public void exD(int id) throws SQLException
    {
        // language=SQL
        String query = "";
        query += "SELECT myfriendsfriendsfriendsfriend.name AS myfriendsfriendsfriendsfriend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsrelation ON (myfriendsrelation.source_node_id = myfriend.id) ";
        query += "JOIN t_user myfriendsfriend ON (myfriendsfriend.id = myfriendsrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendrelation ON (myfriendsfriendrelation.source_node_id = myfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriend ON (myfriendsfriendsfriend.id = myfriendsfriendrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendsfriendrelation ON (myfriendsfriendsfriendrelation.source_node_id = myfriendsfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriendsfriend ON (myfriendsfriendsfriendsfriend.id = myfriendsfriendsfriendrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        setResultSet( query );

        System.out.println( "\n::::::::::::::: Ex: D :::::::::::::::" );
        while( resultSet.next() )
        {
            System.out.println( resultSet.getString( "myfriendsfriendsfriendsfriend_name" ) );
        }
    }

    // E: endorsements of depth five.
    public void exAE(int id) throws SQLException
    {
        // language=SQL
        String query = "";
        query += "SELECT myfriendsfriendsfriendsfriendsfriend.name AS myfriendsfriendsfriendsfriendsfriend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsrelation ON (myfriendsrelation.source_node_id = myfriend.id) ";
        query += "JOIN t_user myfriendsfriend ON (myfriendsfriend.id = myfriendsrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendrelation ON (myfriendsfriendrelation.source_node_id = myfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriend ON (myfriendsfriendsfriend.id = myfriendsfriendrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendsfriendrelation ON (myfriendsfriendsfriendrelation.source_node_id = myfriendsfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriendsfriend ON (myfriendsfriendsfriendsfriend.id = myfriendsfriendsfriendrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendsfriendsfriendrelation ON (myfriendsfriendsfriendsfriendrelation.source_node_id = myfriendsfriendsfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriendsfriendsfriend ON (myfriendsfriendsfriendsfriendsfriend.id = myfriendsfriendsfriendsfriendrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        setResultSet( query );

        System.out.println( "\n::::::::::::::: Ex: E :::::::::::::::" );
        while( resultSet.next() )
        {
            System.out.println( resultSet.getString( "myfriendsfriendsfriendsfriendsfriend_name" ) );
        }
    }
}
