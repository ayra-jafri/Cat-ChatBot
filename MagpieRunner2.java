    import java.util.Scanner;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.net.URL;
    import java.net.URLConnection;
    import java.util.Properties;
    
    /**
     * A simple class to run the Magpie class.
     * @author Laurie White
     * @version April 2012
     */
    public class MagpieRunner2
    {
        public boolean programEnd = false;
	/**
	 * Create a Magpie, give it user input, and print its replies.
	 */
	public static void main(String[] args) throws IOException
	{
		Magpie2 maggie = new Magpie2();
		
		System.out.println (maggie.getGreeting());
		Scanner in = new Scanner (System.in);
		String statement = in.nextLine();
		
		while (!statement.contains("bye") && !statement.contains("Bye") /*&& programEnd == false*/)
		{
			System.out.println (maggie.getResponse(statement));
			statement = in.nextLine();		
                 }
		
	}
}