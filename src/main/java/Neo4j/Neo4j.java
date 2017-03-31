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
        return session.run( "MATCH (me {id:" + id + "})-[:ENDORSES]->(other) RETURN other" );
    }

    // B: all persons that are endorsed by endorsed persons of a person, i.e., endorsements of depth two.
    public void exB(int id)
    {
    }

    // C: endorsements of depth three.
    public void exC(int id)
    {
    }

    // D: endorsements of depth four.
    public void exD(int id)
    {
    }

    // E: endorsements of depth five.
    public void exE(int id)
    {
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
