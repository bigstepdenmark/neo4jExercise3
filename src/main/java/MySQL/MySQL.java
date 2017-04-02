package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        String url = "jdbc:mysql://127.0.0.1:8889/mydb";
        String user = "root";
        String password = "root";

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

    // A: all persons that a person endorses, i.e., endorsements of depth one.
    public ResultSet exA(int id) throws SQLException
    {
        System.out.println( "\n::::::::::::::: Ex: A (ID: " + id + ") :::::::::::::::" );

        // language=SQL
        String query = "";
        query += "SELECT myfriend.name AS friend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        statement = connection.createStatement();
        resultSet = statement.executeQuery( query );

        return resultSet;
    }

    // B: all persons that are endorsed by endorsed persons of a person, i.e., endorsements of depth two.
    public ResultSet exB(int id) throws SQLException
    {
        System.out.println( "\n::::::::::::::: Ex: B (ID: " + id + ") :::::::::::::::" );

        // language=SQL
        String query = "";
        query += "SELECT myfriendsfriend.name AS friend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsrelation ON (myfriendsrelation.source_node_id = myfriend.id) ";
        query += "JOIN t_user myfriendsfriend ON (myfriendsfriend.id = myfriendsrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        statement = connection.createStatement();
        resultSet = statement.executeQuery( query );

        return resultSet;
    }

    // C: endorsements of depth three.
    public ResultSet exC(int id) throws SQLException
    {
        System.out.println( "\n::::::::::::::: Ex: C (ID: " + id + ") :::::::::::::::" );

        // language=SQL
        String query = "";
        query += "SELECT myfriendsfriendsfriend.name AS friend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsrelation ON (myfriendsrelation.source_node_id = myfriend.id) ";
        query += "JOIN t_user myfriendsfriend ON (myfriendsfriend.id = myfriendsrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendrelation ON (myfriendsfriendrelation.source_node_id = myfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriend ON (myfriendsfriendsfriend.id = myfriendsfriendrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        statement = connection.createStatement();
        resultSet = statement.executeQuery( query );

        return resultSet;
    }

    // D: endorsements of depth four.
    public ResultSet exD(int id) throws SQLException
    {
        System.out.println( "\n::::::::::::::: Ex: D (ID: " + id + ") :::::::::::::::" );

        // language=SQL
        String query = "";
        query += "SELECT myfriendsfriendsfriendsfriend.name AS friend_name FROM t_user i ";

        query += "JOIN t_user_relations myrelation ON (myrelation.source_node_id = i.id) ";
        query += "JOIN t_user myfriend ON (myfriend.id = myrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsrelation ON (myfriendsrelation.source_node_id = myfriend.id) ";
        query += "JOIN t_user myfriendsfriend ON (myfriendsfriend.id = myfriendsrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendrelation ON (myfriendsfriendrelation.source_node_id = myfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriend ON (myfriendsfriendsfriend.id = myfriendsfriendrelation.target_node_id) ";

        query += "JOIN t_user_relations myfriendsfriendsfriendrelation ON (myfriendsfriendsfriendrelation.source_node_id = myfriendsfriendsfriend.id) ";
        query += "JOIN t_user myfriendsfriendsfriendsfriend ON (myfriendsfriendsfriendsfriend.id = myfriendsfriendsfriendrelation.target_node_id) ";

        query += "WHERE i.id = " + id;

        statement = connection.createStatement();
        resultSet = statement.executeQuery( query );

        return resultSet;
    }

    // E: endorsements of depth five.
    public ResultSet exE(int id) throws SQLException
    {
        System.out.println( "\n::::::::::::::: Ex: E (ID: " + id + ") :::::::::::::::" );

        // language=SQL
        String query = "";
        query += "SELECT myfriendsfriendsfriendsfriendsfriend.name AS friend_name FROM t_user i ";

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

        statement = connection.createStatement();
        resultSet = statement.executeQuery( query );

        return resultSet;
    }

    public void runEx(ResultSet resultSet, ArrayList<String> timeList) throws SQLException
    {
        long startTime = System.nanoTime();

        while( resultSet.next() )
        {
            System.out.println( resultSet.getString( "friend_name" ) );
        }

        long endTime = System.nanoTime();

        timeList.add( Long.toString( endTime - startTime ) );
    }
}
