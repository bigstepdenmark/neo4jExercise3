package Neo4j;

/**
 * Created by ismailcam on 30/03/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Neo4j neo4j = new Neo4j();

        neo4j.connect();
        neo4j.exA(0);
        neo4j.close();
    }
}
