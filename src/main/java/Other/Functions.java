package Other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by ismailcam on 31/03/2017.
 */
public class Functions
{
    private ArrayList<String> timeList;

    public Functions()
    {
        timeList = new ArrayList<>();
    }

    public ArrayList<Integer> getIdList()
    {
        ArrayList<Integer> idList = new ArrayList<>();

        String csvFile = "/Users/ismailcam/IdeaProjects/neo4j/src/files/idList.csv";
        String line = "";
        String cvsSplitBy = ",";

        try( BufferedReader br = new BufferedReader( new FileReader( csvFile ) ) )
        {
            while( ( line = br.readLine() ) != null )
            {

                // use comma as separator
                String[] list = line.split( cvsSplitBy );

                for( String id : list )
                {
                    idList.add( Integer.parseInt( id ) );
                }
            }
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }

        return idList;
    }

    public ArrayList<String> getTimeList()
    {
        return timeList;
    }

    public void writeToCSVFile(String filename)
    {
        try
        {
            FileWriter writer = new FileWriter( "/Users/ismailcam/IdeaProjects/neo4j/src/files/" + filename + ".csv", true );
            writer.write( "\n" );
            writer.write( timeList.stream().collect( Collectors.joining( "," ) ) );
            writer.close();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }

        timeList = new ArrayList<>();
    }
}
