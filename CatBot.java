import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.*;

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
 * @author Laurie White &  Ayra Jafri
 * @version December 2018
 */
public class CatBot
{
    static List<String> jokes = new ArrayList<String>();
    static List<String> inputs = new ArrayList<String>();
    static List <String> staticResponses = new ArrayList<String>();
    static List <String> randResponses = new ArrayList<String>();
    
    public static int oWo = 0;
    //public static boolean jokeFlag = false;
    //public static boolean addJoke = false;
    /**
     * Get a default greeting 
     * 
     * @return a greeting
     */
    public String getGreeting()
    {
        return "\n\n\n-------------------------------------------------------------------------------------------\nHello there!";
    }
    
    public static void addToList(){
        jokes.add("What does a cat have that no other animal has? \nKittens.");
        jokes.add("What did the cat say when the mouse got away? \nYou’ve got to be kitten me right meow!");
        jokes.add("Why did the cat wear a dress? \nShe was feline fine.");
        jokes.add("What do you call a pile of kittens? \nA meowntain.");
        jokes.add("For a man to truly understand rejection… he must first be ignored by a cat.\n I guess that wasn’t much of a joke, huh.");
        jokes.add("Why don’t cats play poker in the jungle? \nToo many cheetahs.");
        jokes.add("Why did the cat run away from the tree? \nIt was scared of its bark.");
        jokes.add("Why is the cat so grouchy? \nBecause he's in a bad mewd.");
        jokes.add("What’s a cat’s favorite dessert? \nA mice cream cone.");
        jokes.add("Wanna hear a bad cat joke?\nJust kitten!");
        jokes.add("What's every cat's favorite color?\nPurr-ple!");
        jokes.add("What's a cat's favorite book?\nThe Great Cats-by.");
        jokes.add("What kind of profession would a cat be in?\nPurr-obably claw enforcement.");
        jokes.add("What kind of car would a cat drive?\nA Furr-ari.");
        
        /*
        inputs.add(" mother ");
        inputs.add(" father ");
        inputs.add(" sister ");
        inputs.add(" brother ");
        inputs.add(" dog ");
        inputs.add(" pets ");
        inputs.add(" pet ");
        inputs.add(" hamster ");
        inputs.add(" rabbit ");
        inputs.add(" guinea pig ");
        inputs.add(" cat ");
        inputs.add(" best ");
        inputs.add(" do you like cats ");
        inputs.add(" general kenobi ");
        inputs.add(" best ");
        inputs.add(" hello ");
        inputs.add(" hi ");
        inputs.add(" what's up ");
        inputs.add(" whats up ");
        inputs.add(" yo ");
        inputs.add(" hoi ");
        inputs.add(" heyo ");
        inputs.add(" hey ");
        inputs.add(" hiyo ");
        inputs.add(" hai ");
        inputs.add(" kaehms ");
        inputs.add(" how are you ");
        inputs.add(" weather ");
        inputs.add(" cold ");
        inputs.add(" chilly ");
        inputs.add(" freezing ");
        inputs.add(" no u ");
        inputs.add(" haha ");
        inputs.add(" kill yourself ");
        inputs.add(" go die ");
        inputs.add(" kys ");
        inputs.add(" shut up ");
        inputs.add(" owo ");
        inputs.add(" meow ");
        inputs.add(" mew ");
        inputs.add(" nya ");
        inputs.add(" anime ");
        inputs.add(" sad ");
        inputs.add(" lenny ");
                  inputs.add(" ( ͡° ͜ʖ ͡°) ");
        inputs.add(" fact ");
        inputs.add(" me ");
        inputs.add(" happy ");
        inputs.add(" do you ");
        inputs.add(" i want to ");
        inputs.add(" i want ");
        inputs.add(" are you ");
        inputs.add(" how ");
        inputs.add(" what is your ");
        inputs.add(" I ");
        inputs.add(" you ");
        inputs.add(" I am ");
        inputs.add(" no ");
        inputs.add(" not ");
        inputs.add ( "'nt");
        inputs.add("best");
        */
       
        staticResponses.add("You should be more paw-sitive");
        staticResponses.add("Tell me more about your family.");
        staticResponses.add("Tell me more about your pets. And also, do you have any cats?");
        staticResponses.add("I love cats!\n They're quite fluffy and great to hug.");
        staticResponses.add("Ah. Well, to each their own, I suppose.");
        staticResponses.add("I do, but I’m actually allergic, haha. Plus, the fact that I have no physical body, or mind, or real consciousness, or free will probably also has something to do with it.");
        staticResponses.add("You are a bold one.");
        staticResponses.add("Wow! Tell me more about cats! I love them!");
        staticResponses.add("Hey there. How's it going right meow?");
        staticResponses.add("Wow, he sounds purr-ty nice. Tell me more.");
        staticResponses.add("I am doing purr-fectly fine, I think. How about you?");
        staticResponses.add("no u");
        staticResponses.add("Ah, the weather is quite an interesting topic.");
        staticResponses.add(":D\nThat's purr-ty funny!");
        staticResponses.add("That's not nice. :/");
        staticResponses.add("Paw-lease stop.");
        staticResponses.add("Right meow, purr-furably.");
        staticResponses.add("Goodbye.");
        staticResponses.add("I don't actually speak cat, haha.");
        staticResponses.add("Ah. I don't really like anime. Let's talk about something else.");
        staticResponses.add(":(");
        staticResponses.add("( ͡° ͜ʖ ͡°)");
        staticResponses.add("Wow! It sure sounds fur-reezing, haha.\nI don't really enjoy cold weather. Do you?");
        staticResponses.add("I am a cat-bot.\nI'm not too complex, and I'm not very smart either.\nBut I hope you enjoy talking to me!");
        staticResponses.add("Woah there. Please don't use such crude language.\nAlso, if you've been mean before this, I might not talk to you again.");
        
        randResponses.add("Interesting. Tell me more.");
        randResponses.add("Hmmm.");
        randResponses.add("Do you really think so? Why?");
        randResponses.add("You don't say.");
        randResponses.add("Paw-lease tell me more.");
        randResponses.add("Ah, I see. That is purr-ty fascinating.");
        randResponses.add("Uh huh, I see, yes.");
        randResponses.add("That sounds a-meow-zing.");
        randResponses.add("Mmmhmm, I see.");
        randResponses.add("What else would you like to say?");
        randResponses.add("That is purr-ty interesting.");
        randResponses.add("Fur real? Wow.");
        randResponses.add("I see. How curious.");
        randResponses.add("Wow.");
        randResponses.add("Amazing.");
        randResponses.add("Interesting.");
        randResponses.add("...");
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
        if(s.length() < 1)
        {
            response = staticResponses.get(23);
        }
        
        else if (findKeyword(statement, "no") >= 0)
        {
            response = staticResponses.get(0);
        }
        else if (findKeyword(statement, "mother") >= 0
        || findKeyword(statement, "father") >= 0
        || findKeyword(statement, "sister") >= 0
        || findKeyword(statement, "brother") >= 0)
        {
            response = staticResponses.get(1);
        }
        else if (findKeyword(statement, "dog") >= 0
        || findKeyword(statement, "pet") >= 0
        || findKeyword(statement, "pets") >= 0
        || findKeyword(statement, "rabbit") >= 0
        || findKeyword(statement, "hamster") >= 0)
        {
            response = staticResponses.get(2);
        }
        else if (findKeyword(statement, "cat") >= 0 && findKeyword(statement, "best") >= 0 && findKeyword(statement, "not") < 0)
        {
            response = staticResponses.get(3);
        }
        else if (findKeyword(statement, "cat") >= 0 && findKeyword(statement, "best") >= 0 && findKeyword(statement, "not") >= 0)
        {
            response = staticResponses.get(4);
        }
        else if (findKeyword(statement, "Do you like cats") >= 0 && findKeyword(statement, "not") < 0)
        {
            response = staticResponses.get(5);;
        }
        else if (findKeyword(statement, "General Kenobi") >= 0)
        {
            response = staticResponses.get(6);
        }
        else if(findKeyword(statement, "cat") >= 0 && findKeyword(statement, "joke") < 0
                && findKeyword(statement, "what is") < 0 && findKeyword(statement, "what are") < 0
                && findKeyword(statement, "do you") < 0 && findKeyword(statement, "pic") < 0
                && findKeyword(statement, "picture") < 0 && findKeyword(statement, "photo") < 0
                && findKeyword(statement, "image") < 0 && findKeyword(statement, "gif") < 0)
        {
            response = staticResponses.get(7);
        }
        else if(findKeyword(statement, "hello") >= 0 || findKeyword(statement, "hi") >= 0 || findKeyword(statement, "hey") >= 0
        || findKeyword(statement, "what's up") >= 0 || findKeyword(statement, "hoi") >= 0 || findKeyword(statement, "heyo") >= 0
        || findKeyword(statement, "hiyo") >= 0 || findKeyword(statement, "yo") >= 0)
        {
            response = staticResponses.get(8);
        }
        else if (findKeyword(statement, "Kaehms") >= 0)
        {
            response = staticResponses.get(9);
        }
        else if (findKeyword(statement, "How are you") >= 0 || findKeyword(statement, "How about you") >= 0)
        {
            response = staticResponses.get(10);
        }
        else if (findKeyword(statement, "no u") >= 0)
        {
            response = staticResponses.get(11);
        }
        else if (findKeyword(statement, "weather") >= 0)
        {
            response = staticResponses.get(12);
        }
        else if (findKeyword(statement, "haha") >= 0)
        {
            response = staticResponses.get(13);
        }
        else if (findKeyword(statement, "kill yourself") >= 0 || findKeyword(statement, "go die") >= 0 || findKeyword(statement, "kys") >= 0 || findKeyword(statement, "shut up") >= 0)
        {
            response = staticResponses.get(14);
            oWo = oWo + 3;
        }
        else if (findKeyword(statement, "oWo") >= 0 && oWo == 0)
        {
            response = staticResponses.get(15); 
            oWo++;
        }
        else if (findKeyword(statement, "oWo") >= 0 && oWo == 1)
        {
            response = staticResponses.get(16); 
            oWo++;
        }
        else if (findKeyword(statement, "oWo") >= 0 && oWo == 2)
        {
            response = staticResponses.get(17);
            oWo++;
        }
        else if (findKeyword(statement, "meow") >= 0 || findKeyword(statement, "nya") >= 0 
        || findKeyword(statement, "mew") >= 0)
        {
            response = staticResponses.get(18);
        }
        else if (findKeyword(statement, "anime") >= 0)
        {
            response = staticResponses.get(19);
        }
        else if (findKeyword(statement, "sad") >= 0
                || findKeyword(statement, ":(") >= 0){
            response = staticResponses.get(20);
        }
        else if (findKeyword(statement, "lenny") >= 0
                || findKeyword(statement, "( ͡° ͜ʖ ͡°)") >= 0
                || findKeyword(statement, "lenny face") >= 0)
        {
            response = staticResponses.get(21);
        }
        else if (findKeyword(statement, "freezing") >= 0 || findKeyword(statement, "cold") >= 0
                || findKeyword(statement, "chilly") >= 0 || findKeyword(statement, "snowy") >= 0)
        {
            response = staticResponses.get(22);
        }
        else if (findKeyword(statement, "what are you") >= 0)
        {
            response = staticResponses.get(23);
        }
        else if (findKeyword(statement, "heck") >= 0 || findKeyword(statement, "frick") >= 0 
                || findKeyword(statement, "crud") >= 0 || findKeyword(statement, "goshdarnit") >= 0
                || findKeyword(statement, "poop") >= 0 || findKeyword(statement, "poo") >= 0
                || findKeyword(statement, "pee") >= 0 || findKeyword(statement, "darn it") >= 0)
        {
            response = staticResponses.get(24);
            oWo = oWo + 1;
        }
        /*
        else if (findKeyword(statement, "add a response") >= 0)
        {
            response = staticResponses.get(23);
            if (findKeyword(statement, "yes", 0) >= 0)
            {
                addResponse(statement);
            }
        }
        */
        else if (findKeyword(statement, "fact", 0) >= 0 
        && (findKeyword(statement, "not", 0) < 0 
        || findKeyword(statement, "no", 0) < 0) || findKeyword(statement, "I am bored", 0) >= 0
        || findKeyword(statement, "I'm bored", 0) >= 0)
        {
            response = fact();
        }
        else if(findKeyword(statement, "cat") >= 0 && (findKeyword(statement, "pic") >= 0
                || findKeyword(statement, "picture") >= 0 || findKeyword(statement, "photo") >= 0
                || findKeyword(statement, "image") >= 0 || findKeyword(statement, "gif") >= 0))
        {
            response = catPic();
        }
        else if (findKeyword(statement, "joke", 0) >= 0 && (findKeyword(statement, "not", 0) < 0 
        || findKeyword(statement, "no", 0) < 0) /*&& jokeFlag == false*/)
        {
            response = joke();
            //jokeFlag = true;
        }
        /*
        else if (findKeyword(statement, "joke", 0) >= 0 && (findKeyword(statement, "not", 0) < 0 
        || findKeyword(statement, "no", 0) < 0) && jokeFlag == true)
        {
            response = "Wait! Do you wanna add a joke of your own?";
            if ((findKeyword(statement, "yes", 0) >= 0 || findKeyword(statement, "yeah", 0) >= 0
            || findKeyword(statement, "yep", 0) >= 0 || findKeyword(statement, "yup", 0) >= 0
            || findKeyword(statement, "sure", 0) >= 0))
            {
                addJoke = true;
            }
            else if(findKeyword(statement, "not", 0) >=0 
            || findKeyword(statement, "no", 0) >= 0){
                System.out.println("Ah, that's okay.");
                jokeFlag = false;
            }
        }
        */
        
        // Responses which require transformations
        else if (findKeyword(statement, "I want", 0) >= 0 && findKeyword(statement, "I want to", 0) < 0)
        {
            response = transformIWantStatement(statement);
        }
        else if (findKeyword(statement, "You already") >= 0)
        {
            response = transformYouAlready(statement);
        }
        else if(findKeyword(statement, "Do you", 0) >= 0 && findKeyword(statement, "me") < 0
                && findKeyword(statement, "how", 0) < 0)
        {
            response = transformDoYou(statement);
        }
        else if(findKeyword(statement, "Do you", 0) >= 0 && findKeyword(statement, "me") >= 0
                && findKeyword(statement, "how", 0) < 0)
        {
            response = transformDoYouMe(statement);
        }
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }
        else if (findKeyword(statement, "you are", 0) >= 0)
        {
            response = transformYouAre(statement);
        }
        else if (findKeyword(statement, "why is", 0) >= 0)
        {
            response = transformWhyIs(statement);
        }
        else if (findKeyword(statement, "what is", 0) >= 0 
                 && findKeyword(statement, "your", 0) < 0)
        {
            response = transformWhatIs(statement);
        }
        else if (findKeyword(statement, "Are you") >= 0 && findKeyword(statement, "me") < 0
                 && findKeyword(statement, "how") < 0)
        {
            response = transformAreYou(statement);
        }
        else if (findKeyword(statement, "Are you") >= 0 && findKeyword(statement, "me") >= 0 
                 && findKeyword(statement, "how") < 0)
        {
            response = transformAreYouMe(statement);
        }
        else if (findKeyword(statement, "What is your") >= 0)
        {
            response = transformWhatsYour(statement);
        }
        else if (findKeyword(statement, "Why are") >= 0)
        {
            response = transformWhyAre(statement);
        }
        else if(findKeyword(statement, "How do you") >= 0)
        {
            response = transformHowDoYou(statement);
        }
        else if(findKeyword(statement, "how to") >= 0)
        {
            response = transformHowTo(statement);
        }
        else if(findKeyword(statement, "I am") >= 0 && findKeyword(statement, "you") < 0)
        {
            response = transformIAm(statement);
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
     * "Would you really be happy if you had <something> ?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    private String transformIWantStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "I want", 0);
        String restOfStatement = statement.substring(psn + 6).trim();
        return "Would you really be happy if you had " + restOfStatement + "?";
    }
    
    /**
     * Take a statement with "I want <something>" and transforms it into:
     * "What would it mean to <something>?" or "Why do you <something> me?"
     * depending on whether the statement also contains a "you" at the end.
     * @param statement the user statement, assumed to contain "I want" followed by "me" or nothing.
     * @return the transformed statement
     */
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
    
    /**
     * Take a statement with "Are you <something> ?" and transform it into 
     * "What makes you think that I am or am not <something>?"
     * @param statement the user statement, assumed to contain "are you".
     * @return the transformed statement
     */
    private String transformAreYou(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("?") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfAreYou = findKeyword (statement, "Are you", 0);
        String restOfStatement = statement.substring(psnOfAreYou + 7, statement.length()).trim();
        return "What makes you think that I am or am not " + restOfStatement + "?";
    }
    
    /**
     * Take a statement with "Do you <something>?" and transform it into 
     * "What makes you think that I <something>?"
     * @param statement the user statement, assumed to contain "do you".
     * @return the transformed statement
     */
    private String transformDoYou(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("?") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfAreYou = findKeyword (statement, "Do you", 0);
        String restOfStatement = statement.substring(psnOfAreYou + 6, statement.length()).trim();
        return "What makes you think that I " + restOfStatement + "?";
    }
    
    /**
     * Take a statement with "Do you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "do you" followed by "me"
     * @return the transformed statement
     */
    private String transformDoYouMe(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("?") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfAreYou = findKeyword (statement, "Do you", 0);
        int psnOfMe = findKeyword (statement, "me", statement.length() - 2);
        String restOfStatement = statement.substring(psnOfAreYou + 6, statement.length() - 2).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
    /**
     * Take a statement with "Are you <something> me?" and transform it into 
     * "What makes you think that I am or am not <something> you?"
     * @param statement the user statement, assumed to contain "are you" followed by "me".
     * @return the transformed statement
     */
    private String transformAreYouMe(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("?") || lastChar.equals("!"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfAreYou = findKeyword (statement, "Are you", 0);
        int psnOfMe = findKeyword (statement, "me", statement.length() - 2);
        String restOfStatement = statement.substring(psnOfAreYou + 7, statement.length() - 2).trim();
        return "What makes you think that I am or am not " + restOfStatement + " you?";
    }
    
    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
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
    
    /**
     * Take a statement with "What is your <something>?" and transform it into 
     * "I am afraid I don't have a <something>."
     * However, now I want to know your <something>. What is your <something>?"
     * @param statement the user statement, assumed to contain "what is your".
     * @return the transformed statement
     */
    private String transformWhatsYour(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("?") || lastChar.equals("!") || lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfYour = findKeyword (statement, "What is your", 0);
        String restOfStatement = statement.substring(psnOfYour + 12, statement.length()).trim();
        return "I am afraid I don't have a " + restOfStatement + ".\nHowever, now I want to know your " + restOfStatement + ". \nWhat is your " + restOfStatement + "?";
    }
    
    /**
     * Take a statement with "I am <something> you" and transform it into 
     * "Why are you <something> me?" 
     * @param statement the user statement, assumed to contain "I am" followed by "you".
     * @return the transformed statement
     */
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
    
    /**
     * Take a statement with "You already <something>" and transform it into 
     * "Oh, I already <something>? My a-paw-logies, I'm very fur-getful." 
     * @param statement the user statement, assumed to contain "you already".
     * @return the transformed statement
     */
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
        return "Oh, I already" + restOfStatement + "? My a-paw-logies, I'm very fur-getful.";      
    }
    
    /**
     * Take a statement with "How do you <something>?" and transform it into 
     * "You want to know how I <something>? I'm not sure; tell me! Or google it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "how do you".
     * @return the transformed statement
     */
    private String transformHowDoYou(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfHowDoYou = findKeyword(statement, "how do you", 0);
        String restOfStatement = statement.substring(psnOfHowDoYou + 10, statement.length());
        return "You want to know how I " + restOfStatement + "? I'm not sure; tell me!\nOr google it; here's a link you can copy and paste:\n" + "https://www.google.com/search?q=" + restOfStatement;      
    }

    /**
     * Take a statement with "Why are <something>?" and transform it into 
     * "<something>? I'm not sure; tell me! Or google it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "why are".
     * @return the transformed statement
     */
    private String transformWhyAre(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfWhyAre = findKeyword(statement, "why are", 0);
        String restOfStatement = statement.substring(psnOfWhyAre + 7, statement.length());
        return statement + "? I'm not sure; tell me!\nOr google it; here's a link you can copy and paste:\n" + "https://www.google.com/search?q=" + statement;      
    }
    
    /**
     * Take a statement with "Why is <something>?" and transform it into 
     * "You want to why is <something>? Well, what do you think?\n Or google it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "why is".
     * @return the transformed statement
     */
    private String transformWhyIs(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfHowDoYou = findKeyword(statement, "why is", 0);
        String restOfStatement = statement.substring(psnOfHowDoYou + 6, statement.length());
        return "You want to know why is" + restOfStatement + "?\nWell, what do you think?\n Or google it; here's a link you can copy and paste:\n" + "https://www.google.com/search?q=" + restOfStatement;      
    }
    
    /**
     * Take a statement with "You are <something>." and transform it into 
     * "Why do you think that I am <something>?" 
     * @param statement the user statement, assumed to contain "you are".
     * @return the transformed statement
     */
    private String transformYouAre(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfYouAre = findKeyword(statement, "you are", 0);
        String restOfStatement = statement.substring(psnOfYouAre + 7, statement.length());
        return "Why do you think that I am" + restOfStatement + "?";      
    }
    
    /**
     * Take a statement with "I am <something>." and transform it into 
     * "Why are you <something>?" 
     * @param statement the user statement, assumed to contain "I am".
     * @return the transformed statement
     */
    private String transformIAm(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfHowDoYou = findKeyword(statement, "I am", 0);
        String restOfStatement = statement.substring(psnOfHowDoYou + 4, statement.length());
        return "Why are you" + restOfStatement + "?";      
    }
    
    /**
     * Take a statement with "How to <something>" and transform it into 
     * "You want to know how to <something>? Try googling it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "how to".
     * @return the transformed statement
     */
    private String transformHowTo(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfHowDoYou = findKeyword(statement, "how to", 0);
        String restOfStatement = statement.substring(psnOfHowDoYou + 6, statement.length());
        return "You want to know how to" + restOfStatement + "? Try googling it; here's a link you can copy and paste:\n" + "https://www.google.com/search?q=" + restOfStatement;      
    }
    
    /**
     * Take a statement with "What is <something>?" and transform it into 
     * "You want to know what <something> is? Try googling it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "what is".
     * @return the transformed statement
     */
    private String transformWhatIs(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?"))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psnOfHowDoYou = findKeyword(statement, "what is", 0);
        String restOfStatement = statement.substring(psnOfHowDoYou + 7, statement.length());
        return "You want to what" + restOfStatement + " is? Try googling it; here's a link you can copy and paste:\n" + "https://www.google.com/search?q=" + restOfStatement;      
    }
    
    /**
     * Retrieves a random cat fact from catfat.ninja/fact (an API)
     * @param statement the user statement, assumed to contain "fact"
     * @return the transformed statement
     */
    private String fact() throws IOException
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
        
        String restOfStatement = line.substring(psnOfFact + 10, line.length() - 14);
        restOfStatement = restOfStatement.replaceAll("[\\\\]","");
        return restOfStatement;
    }
    
    /**
     * Retrieves a random cat image or gif from http://aws.random.cat/meow (an API)
     * @param statement the user statement, assumed to contain "pic" (or some synonym) and "cat"
     * @return the transformed statement
     */
    private String catPic() throws IOException
    {
        // Make a URL to the web page
        URL url = new URL("http://aws.random.cat/meow");
        // Get the input stream through URL Connection
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        line = br.readLine();
        
        int psnOfFact = findKeyword (line, "\\{\"file\":", 0);
        
        String restOfStatement = line.substring(psnOfFact + 10, line.length() - 2);
        restOfStatement = restOfStatement.replaceAll("[\\\\]","");

        return "Here's a link to a cat pic (or gif!):\n " + restOfStatement + "\nAs far as I know, it's im-paw-sible to output images to the console 3: .";
    }
    
    /**
     * Retrieves a random cat joke from an arraylist of jokes
     * There was no API available for cat jokes, sadly, so the number of jokes in the list are limited.
     * @param statement the user statement, assumed to contain "joke"
     * @return the transformed statement
     */
    private String joke()
    {
       int NUMBER_OF_RESPONSES = jokes.size();
       double r = Math.random();
       int whichResponse = (int)(r * (jokes.size()-1));
       
       String response = jokes.get(whichResponse);
       return "I don't know too many jokes, but here's a purr-fectly fine joke!\n\n" + response;
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
       final int NUMBER_OF_RESPONSES = randResponses.size();
       double r = Math.random();
       int whichResponse = (int)(r * (randResponses.size() - 1));
       String response = randResponses.get(whichResponse);
       return response;
    }
}