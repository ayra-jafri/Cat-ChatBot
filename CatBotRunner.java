import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.*;

/**
 * A simple class to run the CatBot class.
 * @author Laurie White & Ayra Jafri
 * @version December 2018
 */
public class CatBotRunner
{
    /**
     * Create a Kitten, give it user input, and print its replies.
     */
    public static void main(String[] args) throws IOException
    {
        CatBot.addToList();
        CatBot kitten = new CatBot();
        System.out.println (kitten.getGreeting());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        while (!statement.contains("bye") && !statement.contains("Bye") && CatBot.oWo < 3 /*&& Magpie2.addJoke == false*/)
        {
            System.out.println (kitten.getResponse(statement));
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
