package Neo4j;

import Other.Functions;

/**
 * Created by ismailcam on 30/03/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Neo4j neo4j = new Neo4j();
        Functions func = new Functions();

        neo4j.connect();

        for( Integer id : func.getIdList() )
        {
            neo4j.runEx( neo4j.exA( id ), func.getTimeList() );
        }

        neo4j.close();

        //func.writeToCSVFile( "Neo4j-exA-TimeResult" );
    }
}
