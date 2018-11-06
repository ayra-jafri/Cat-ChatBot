/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        String s = statement.trim();
        if(s.length() < 1)
        {
            response = "Say something, please.";
        }
        
        else if(statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (statement.indexOf("dog") >= 0
                || statement.indexOf("cat") >= 0
                || statement.indexOf("rabbit") >= 0
                || statement.indexOf("bird") >= 0)
        {
            response = "Tell me more about your pets.";
        }
        
        else if (statement.contains("Kaehms"))
        {
            response = "Wow, he sounds like a nice guy! Tell me more.";
        }
        else if (statement.indexOf("weather") >= 0)
        {
            response = "I hope it's sunny where you are! But I can't actually check the weather you know, haha!";
        }
        else if (statement.contains("haha"))
        {
            response = ":D\nThat's pretty funny!";
        }
        else if (statement.indexOf("meow") >= 0)
        {
            response = "Ah, I'm afraid I can't speak cat.";
        }
        else if (statement.indexOf("anime") >= 0)
        {
            response = "...\n...\n...\nI'm not into anime, sorry.\n\n\nI'm not a weeb smh.";
        }
        else if (statement.indexOf("sad") >= 0)
        {
            response = ":(";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
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
        return response;
    }
}
