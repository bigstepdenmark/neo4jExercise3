package Neo4j;

/**
 * Created by ismailcam on 30/03/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Neo4j neo4j = new Neo4j();

        long startTime = System.currentTimeMillis();
        neo4j.connect();

        neo4j.getNames();

        neo4j.close();
        long endTime = System.currentTimeMillis();

        long duration = (endTime - startTime);

        System.out.println(duration);
    }
}
