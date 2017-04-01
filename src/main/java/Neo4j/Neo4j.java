package Neo4j;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by ismailcam on 30/03/2017.
 */
public class Neo4j
{
    private Driver driver;
    private Session session;

    public void connect()
    {
        driver = GraphDatabase.driver( "bolt://localhost:7687", AuthTokens.basic( "neo4j", "class" ) );
        session = driver.session();
    }

    public void close()
    {
        session.close();
        driver.close();
    }

    // A: all persons that a person endorses, i.e., endorsements of depth one.
    public StatementResult exA(int id)
    {
        System.out.println( "\n::::::::::::::: Ex: A (ID: " + id + ") :::::::::::::::" );

        String query = "";
        query += "MATCH (me {id:" + id + "})";
        query += "-[:ENDORSES]->(other)";
        query += "RETURN other";

        return session.run( query );
    }

    // B: all persons that are endorsed by endorsed persons of a person, i.e., endorsements of depth two.
    public StatementResult exB(int id)
    {
        System.out.println( "\n::::::::::::::: Ex: B (ID: " + id + ") :::::::::::::::" );

        String query = "";
        query += "MATCH (me {id:" + id + "})";
        query += "-[:ENDORSES]->(otherdeep1)";
        query += "-[:ENDORSES]->(other)";
        query += "RETURN other";

        return session.run( query );
    }

    // C: endorsements of depth three.
    public StatementResult exC(int id)
    {
        System.out.println( "\n::::::::::::::: Ex: C (ID: " + id + ") :::::::::::::::" );

        String query = "";
        query += "MATCH (me {id:" + id + "})";
        query += "-[:ENDORSES]->(otherdeep1)";
        query += "-[:ENDORSES]->(otherdeep2)";
        query += "-[:ENDORSES]->(other)";
        query += "RETURN other";

        return session.run( query );
    }

    // D: endorsements of depth four.
    public StatementResult exD(int id)
    {
        System.out.println( "\n::::::::::::::: Ex: D (ID: " + id + ") :::::::::::::::" );

        String query = "";
        query += "MATCH (me {id:" + id + "})";
        query += "-[:ENDORSES]->(otherdeep1)";
        query += "-[:ENDORSES]->(otherdeep2)";
        query += "-[:ENDORSES]->(otherdeep3)";
        query += "-[:ENDORSES]->(other)";
        query += "RETURN other";

        return session.run( query );
    }

    // E: endorsements of depth five.
    public StatementResult exE(int id)
    {
        System.out.println( "\n::::::::::::::: Ex: E (ID: " + id + ") :::::::::::::::" );

        String query = "";
        query += "MATCH (me {id:" + id + "})";
        query += "-[:ENDORSES]->(otherdeep1)";
        query += "-[:ENDORSES]->(otherdeep2)";
        query += "-[:ENDORSES]->(otherdeep3)";
        query += "-[:ENDORSES]->(otherdeep4)";
        query += "-[:ENDORSES]->(other)";
        query += "RETURN other";

        return session.run( query );
    }

    public void runEx(StatementResult result, ArrayList<String> timeList)
    {
        long startTime = System.nanoTime();

        while( result.hasNext() )
        {
            Record record = result.next();
            System.out.println( record.get( "other" ).get( "name" ).asString() );
        }

        long endTime = System.nanoTime();

        timeList.add( Long.toString( endTime - startTime ) );
    }
}
