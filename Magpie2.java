import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 *          Uses advanced search for keywords
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    int owo = 0;
    /**
     * Get a default greeting 
     * 
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello there!";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) throws IOException
    {
        String response = "";
        String s = statement.trim();
        if(s.length() < 0)
        {
          final int NUMBER_OF_RESPONSES = 1;
          double r = Math.random();
          int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
          response = "";
          if(whichResponse == 0)
          {
            response = "Hmm, I don’t quite understand you right meow.";
          }
          else if(whichResponse == 1)
          {
            response = "Cat got your tongue?";
          }
        }
        
        else if (findKeyword(statement, "no") >= 0)
        {
            response = "You should be more paw-sitive,";
        }
        else if (findKeyword(statement, "mother") >= 0
        || findKeyword(statement, "father") >= 0
        || findKeyword(statement, "sister") >= 0
        || findKeyword(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (findKeyword(statement, "dog") >= 0
        || findKeyword(statement, "pet") >= 0
        || findKeyword(statement, "pets") >= 0
        || findKeyword(statement, "rabbit") >= 0
        || findKeyword(statement, "hamster") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        else if (findKeyword(statement, "cat") >= 0 && findKeyword(statement, "best") >= 0 && findKeyword(statement, "not") < 0)
        {
            response = "I love cats! They’re quite fluffy and easy to hug (sometimes)!";
        }
        else if (findKeyword(statement, "cat") >= 0 && findKeyword(statement, "best") >= 0 && findKeyword(statement, "not") >= 0)
        {
            response = "Ah. Well, to each their own, I suppose. But then again, what are you doing with a cat loving chatbot?";
        }
        else if (findKeyword(statement, "Do you like cats") >= 0 && findKeyword(statement, "not") < 0 )
        {
            response = "I do, but I’m actually allergic, haha. Plus, the fact that I have no physical body, or mind, or real consciousness, or free will probably also has something to do with it.";
        }
        else if (findKeyword(statement, "General Kenobi") >= 0)
        {
            response = "You are a bold one.";
        }
        
        else if(findKeyword(statement, "cat") >= 0)
        {
            response = "Wow! Tell me more about cats! I just love cats!";
        }
        else if (findKeyword(statement, "Kaehms") >= 0)
        {
            response = "Wow, he sounds like a nice guy! Tell me more.";
        }
        else if (findKeyword(statement, "weather") >= 0)
        {
            response = "I hope it's sunny where you are! But I can't actually check the weather you know, haha!";
        }
        else if (findKeyword(statement, "haha") >= 0)
        {
            response = ":D\nThat's purr-ty funny!";
        }
        else if (findKeyword(statement, "oWo") >= 0 && owo == 0)
        {
            owo++;
            response = "No. Stop.\n\n\nDon't do that again, or else I'm leaving."; 
        }
        else if (findKeyword(statement, "owo") >= 0 && owo == 1)
        {
            owo++;
            response = "This is your final warning, purr-tner.";
        }
        else if (findKeyword(statement, "owo") >= 0 && owo == 2)
        {
            owo++;
            response = "Goodbye.";
            //MagpieRunner2.programEnd = true;
        }
        else if (findKeyword(statement, "meow") >= 0)
        {
            response = "Ah, I'm afraid I can't speak cat. Yet.";
        }
        else if (findKeyword(statement, "anime") >= 0)
        {
            response = "...\n...\n...\nI'm not into anime, sorry.";
        }
        else if (findKeyword(statement, "sad") >=0
                || findKeyword(statement, ":(") >= 0){
            response = ":(";
        }
        else if (findKeyword(statement, "You already") >= 0)
        {
            response = transformYouAlready(statement);
        }
        else if (findKeyword(statement, "lenny") >=0
                || findKeyword(statement, "( ͡° ͜ʖ ͡°)") >= 0
                || findKeyword(statement, "lenny face") >= 0){
            response = "( ͡° ͜ʖ ͡°)\t( ͡° ͜ʖ ͡°)";
        }
      
        // Responses which require transformations
        else if (findKeyword(statement, "I want", 0) >= 0 && findKeyword(statement, "I want to", 0) < 0)
        {
            response = transformIWantStatement(statement);
        }
        
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }
        
        else if ( findKeyword(statement, "fact", 0) >= 0 && (((findKeyword(statement, "not", 0) <= -1 
        || findKeyword(statement, "no", 0) <= -1))) )
        {
            response = fact(statement);
        }
        
        else
        {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(statement, "you", 0);
            if ((psn >= 0 && findKeyword(statement, "me", psn) >= 0))
            {
                response = transformYouMeStatement(statement);
            }
            else
            {
                response = getRandomResponse();
            }
            
            int psn2 = findKeyword(statement, "I", 0);
            if ((psn2 >= 0 && findKeyword(statement, "you", psn2) >= 0))
            {
                response = transformIYouStatement(statement);
            }
            
            int psn3 = findKeyword(statement, "I am", 0);
            if ((psn3 >= 0 && findKeyword(statement, "you", psn3) >= 0))
            {
                response = transformIAmYouStatement(statement);
            }
        }
        return response;
    }

    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no").
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @param startPos
     *            the character of the string to begin the
     *            search at
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal,
    int startPos)
    {
        String phrase = statement.trim();
        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.toLowerCase().indexOf(
                goal.toLowerCase(), startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn)
                .toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                    psn + goal.length(),
                    psn + goal.length() + 1)
                .toLowerCase();
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                // letter
            && ((after.compareTo("a") < 0) || (after
                    .compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(),
                psn + 1);

        }

        return -1;
    }
    
    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <statement> ?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Would you really be happy if you had " + restOfStatement + "?";
    }

    private String transformIWantToStatement(String statement)
    {
        //  Remove the final period, if there is one
        boolean IWantYou = false;
        String statementNoYou = "";
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        String restOfStatementWant = statement.substring(psn + 2).trim();
        if(restOfStatement.contains("you")){
            statementNoYou = restOfStatementWant.substring(0, restOfStatementWant
                    .length() - 4);
            IWantYou = true;
        }
        
        if(IWantYou == true){
            return "Why do you " + statementNoYou + " me?";
        }
        return "What would it mean to " + restOfStatement + "?";
    }
    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    private String transformYouMeStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
        
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
    private String transformIYouStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfYou = findKeyword (statement, "I", 0);
        int psnOfMe = findKeyword (statement, "you", psnOfYou + 2);
        
        String restOfStatement = statement.substring(psnOfYou + 2, psnOfMe).trim();
        return "Why do you " + restOfStatement + " me?";
    }

    private String transformIAmYouStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfYou = findKeyword (statement, "I am", 0);
        int psnOfMe = findKeyword (statement, "you", psnOfYou + 4);
        
        String restOfStatement = statement.substring(psnOfYou + 4, psnOfMe).trim();
        return "Why are you " + restOfStatement + " me?";
    }
    
    private String transformYouAlready(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfYouAlready = findKeyword(statement, "You already", 0);
        String restOfStatement = statement.substring(psnOfYouAlready + 11, statement.length());
        return "Oh, I already " + restOfStatement + "? My a-paw-logies, I'm very forgetful.";      
    }

    private String fact(String statement) throws IOException
    {
        // Make a URL to the web page
        URL url = new URL("https://catfact.ninja/fact");
        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        line = br.readLine();
        
        int psnOfFact = findKeyword (line, "\\{\"fact\":", 0);
        int psnOfLength = findKeyword (line, "\"length\"", line.length() - 16);
        
        String restOfStatement = line.substring(psnOfFact + 9, psnOfLength);
        return restOfStatement;
    }
    
    /**
     * Search for one word in phrase. The search is not case
     * sensitive. This method will check that the given goal
     * is not a substring of a longer string (so, for
     * example, "I know" does not contain "no"). The search
     * begins at the beginning of the string.
     * 
     * @param statement
     *            the string to search
     * @param goal
     *            the string to search for
     * @return the index of the first occurrence of goal in
     *         statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Paw-lease tell me more."; 
        }
        else if (whichResponse == 5)
        {
            response = "Ah, I see. That's purr-ty fascinating";
        }
        else if (whichResponse == 6)
        {
            response = "Uh huh, I see, yes.";
        }
        else if (whichResponse == 7)
        {
            response = "That sounds a-meow-zing. Tell me more.";
        }
        return response;
    }
}




