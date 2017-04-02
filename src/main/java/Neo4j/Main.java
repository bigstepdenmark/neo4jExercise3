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

        for( Integer id : func.getIdList() )
        {
            neo4j.connect();
            neo4j.runEx( neo4j.exC( id ), func.getTimeList() );
            neo4j.close();
        }

        func.writeToCSVFile( "Neo4j-TimeResult" );
    }
}
