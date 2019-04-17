---------------------------------------------------------------------------------------~~
PROJECT TITLE: PLTW 1.1.6 Chatting with Magpie / Cat Chat Bot
PURPOSE OF PROJECT: School assignment; experiemnt with basic AI and chatbots
VERSION or DATE: 11/5/18
HOW TO START THIS PROJECT: Run in BlueJ, or download BlueJ and click on package.bluej
AUTHOR: Ayra Jafri
---------------------------------------------------------------------------------------~~
###########################################################################################################################################################################
Database of Possible Responses:
###########################################################################################################################################################################
format:
|[number]  |
|[keywords]|
|[response]|

1
no
You should be more paw-sitive.

2
mother, father, brother, sister
Tell me more about your family.

3
dog, pet, pets, rabbit, hamster
Tell me more about your pets. And also, do you have any cats?

4
cat & best (“not” not present)
I love cats!\n They're quite fluffy and great to hug.

5
cat & best & not
Ah. Well, to each their own, I suppose.

6
cat (excluding all other keywords to prevent this keyword from overriding other methods)
I do, but I’m actually allergic, haha. Plus, the fact that I have no physical body, or mind, or real consciousness, or free will probably also has something to do with it.

7
Kaehms
Wow, he sounds purr-ty nice. Tell me more.

8
how are you, how about you
I am doing purr-fectly fine, I think. How about you?"

9
weather
Ah, the weather is quite an interesting topic.

10
No u
no u

11
haha
:D
That's purr-ty funny!

12
kill yourself, go die, kys, shut up,
That's not nice. :/

13
owo, uwu (differs based on the number of times said)
first time:
Paw-lease stop.
second: 
Right meow, purr-furably.
third: 
Goodbye.

14
meow, mew, nya
I don't actually speak cat, haha.

15
anime
Ah. I don't really like anime. Let's talk about something else.

16
sad, :(
:(

17
lenny, ( ͡° ͜ʖ ͡°), lenny face
( ͡° ͜ʖ ͡°)

18
freezing, chilly, cold, snowy
Wow! It sure sounds fur-reezing, haha.
I don't really enjoy cold weather. Do you?

19
what are you
I am a cat-bot.
I'm not too complex, and I'm not very smart either.
But I hope you enjoy talking to me!

20
heck, frick, darn, crud, goshdarnit, poop, pee, darn it
Woah there. Please don't use such crude language.
Also, if you've been mean before this, I might not talk to you again.

21
fact, I’m bored (“no” and “not” not present)
[returns a fact]

22
cat, picture, pic, photo, image, gif
Here's a link to a cat pic (or gif!): <link>
As far as I know, it's im-paw-sible to output images to the console 3:

23
joke (“no” and “not” not present)
"I don't know too many jokes, but here's a purr-fectly fine joke!
<joke>

25
general kenobi
You are a bold one.

26
do you? (this phrase specifically)
Do I what?

27
how do you? (this phrase specifically)
How do I want?

28
I want <something>.
Would you really be happy if you had <something>?

29
I want to <something>.
What would it mean to <something>?

30
You already <something>.
Oh, I already <something>? My a-paw-logies, I'm very fur-getful.

31
Do you <something>?
What makes you think that I <something>?

32
Do you <something> me?
What makes you think that I <something> you?

33
You are <something>.
Why do you think that I am <something>?

34
Why is <something>?
You want to why is <something>? Well, what do you think?
 Or google it; here's a link you can copy and paste:
<link>

35
What is <something>?
You want to know what <something> is? Try googling it; here's a link you can copy and paste:
<link>

36
Are you <something>?
What makes you think that I am or am not <something>

37
Are you <something> me?
What makes you think that I am or am not <something> you?

38
What is your <something>?
I am afraid I don't have a <something>.
However, now I want to know your <something>. What is your <something>?

39
How do you <something>?
You want to know how I <something>? I'm not sure; tell me! Or google it; here's a link you can copy and paste:
<link>

40
How to <something>?
You want to know how to <something>? Try googling it; here's a link you can copy and paste:
<link>" 

41
You <something> me.
What makes you think that I <something> you?

42
I <something> you.
Why do you <something> me?

43
I am <something> you.
Why are you <something> me?

44
I am <something>.
Why are you <something>?

45
Why are <something>?
<something>? I'm not sure; tell me! Or google it; here's a link you can copy and paste:
<link>

46
I want to <something> you.
Why do you <something> me?

47
I like <something>.
Why do you like <something>?

48
I <something>. (assumed to contain “I” and “because”)
So you <something>? That's purr-ty interesting.


###########################################################################################################################################################################
Random Responses
###########################################################################################################################################################################
format:
|[number]  |
|[response]|

1
Interesting. Tell me more.


2
Hmmm.


3
Do you really think so? Why?


4
You don't say.


5
Paw-lease tell me more.


6
Ah, I see. That is purr-ty fascinating.


7
Uh huh, I see, yes.


8
That sounds a-meow-zing.


9
Mmmhmm, I see.


10
What else would you like to say?


11
That is purr-ty interesting.


12
Fur real? Wow.


13
I see. How curious.


14
Wow.


15
Amazing.


16
Interesting.


17
...


###########################################################################################################################################################################
Main Methods:
Class CatBot
###########################################################################################################################################################################
format:
|[method()]	   |
|[java doc comment]|

findKeyword();
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
transformIWantStatement();
/**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something> ?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */


transformIWantToStatement();
/**
     * Take a statement with "I want <something>" and transforms it into:
     * "What would it mean to <something>?" or "Why do you <something> me?"
     * depending on whether the statement also contains a "you" at the end.
     * @param statement the user statement, assumed to contain "I want" followed by "me" or nothing.
     * @return the transformed statement
     */
transformYouMeStatement();
/**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
transformAreYou();
/**
     * Take a statement with "Are you <something> ?" and transform it into 
     * "What makes you think that I am or am not <something>?"
     * @param statement the user statement, assumed to contain "are you".
     * @return the transformed statement
     */
transformDoYou();
/**
     * Take a statement with "Do you <something>?" and transform it into 
     * "What makes you think that I <something>?"
     * @param statement the user statement, assumed to contain "do you".
     * @return the transformed statement
     */
transformDoYouMe();
/**
     * Take a statement with "Do you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "do you" followed by "me"
     * @return the transformed statement
     */
transformAreYouMe();
/**
     * Take a statement with "Are you <something> me?" and transform it into 
     * "What makes you think that I am or am not <something> you?"
     * @param statement the user statement, assumed to contain "are you" followed by "me".
     * @return the transformed statement
     */
transformIYouStatement();
/**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
transformWhatsYour();
/**
     * Take a statement with "What is your <something>?" and transform it into 
     * "I am afraid I don't have a <something>."
     * However, now I want to know your <something>. What is your <something>?"
     * @param statement the user statement, assumed to contain "what is your".
     * @return the transformed statement
     */
transformIAmYouStatement();
/**
     * Take a statement with "I am <something> you" and transform it into 
     * "Why are you <something> me?" 
     * @param statement the user statement, assumed to contain "I am" followed by "you".
     * @return the transformed statement
     */
transformYouAlready();
/**
     * Take a statement with "You already <something>" and transform it into 
     * "Oh, I already <something>? My a-paw-logies, I'm very fur-getful." 
     * @param statement the user statement, assumed to contain "you already".
     * @return the transformed statement
     */
transformHowDoYou();
/**
     * Take a statement with "How do you <something>?" and transform it into 
     * "You want to know how I <something>? I'm not sure; tell me! Or google it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "how do you".
     * @return the transformed statement
     */
transformWhyAre();
/**
     * Take a statement with "Why are <something>?" and transform it into 
     * "<something>? I'm not sure; tell me! Or google it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "why are".
     * @return the transformed statement
     */
transformWhyIs();
/**
     * Take a statement with "Why is <something>?" and transform it into 
     * "You want to why is <something>? Well, what do you think?\n Or google it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "why is".
     * @return the transformed statement
     */
transformILike();
/**
     * Take a statement with "I like <something>?" and transform it into 
     * "Why do you like <something>?" 
     * @param statement the user statement, assumed to contain "i like".
     * @return the transformed statement
     */
transformIBecause();
/**
     * Take a statement with "I <something>?" and transform it into 
     * "So you <something>? That's purr-ty interesting." 
     * @param statement the user statement, assumed to contain "I" and "because".
     * @return the transformed statement
     */
transformYouAre();
/**
     * Take a statement with "You are <something>." and transform it into 
     * "Why do you think that I am <something>?" 
     * @param statement the user statement, assumed to contain "you are".
     * @return the transformed statement
     */
transformIAm();
/**
     * Take a statement with "I am <something>." and transform it into 
     * "Why are you <something>?" 
     * @param statement the user statement, assumed to contain "I am".
     * @return the transformed statement
     */
transformHowTo();
/**
     * Take a statement with "How to <something>" and transform it into 
     * "You want to know how to <something>? Try googling it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "how to".
     * @return the transformed statement
     */
transformWhatIs();
/**
     * Take a statement with "What is <something>?" and transform it into 
     * "You want to know what <something> is? Try googling it; here's a link you can copy and paste:\n <link>" 
     * @param statement the user statement, assumed to contain "what is".
     * @return the transformed statement
     */
fact();
/**
     * Retrieves a random cat fact from catfat.ninja/fact (an API)
     * @param statement the user statement, assumed to contain "fact"
     * @return the transformed statement
     */
catPic();
/**
     * Retrieves a random cat image or gif from http://aws.random.cat/meow (an API)
     * @param statement the user statement, assumed to contain "pic" (or some synonym) and "cat"
     * @return the transformed statement
     */
getList(); (replaced the joke() and getRandResponse() methods)
/**
     * Retrieves a random string from the list passed
     * Used for retrieving a random response or random joke
     * @param List<String> list the list passed in
     * @return the statement
     */
