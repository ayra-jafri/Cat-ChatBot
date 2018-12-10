import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.*;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class MagpieRunner2
{
    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args) throws IOException
    {
        Magpie2 maggie = new Magpie2();
        
        System.out.println (maggie.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        while (!statement.contains("bye") && !statement.contains("Bye") && Magpie2.oWo < 3 /*&& Magpie2.addJoke == false*/)
        {
            System.out.println (maggie.getResponse(statement));
            statement = in.nextLine();
        }
        }
        /*
        if(Magpie2.addJoke == true && end == false) {
               System.out.println("Grrr-eat! Type in your joke below!");
               String newJoke = in.nextLine();
               Magpie2.jokes.add(newJoke);
               System.out.println("Your joke has been added!");
               Magpie2.jokeFlag = false;
               Magpie2.addJoke = false;
        }
        */
    }
