package com.example;

import java.util.Random;

/**
 * Pulled from https://github.com/pjimenezmateo/Computer-jokes/blob/master/jokes.txt
 */
public final class JokeCreator {

    private static final String[] JOKES = {
            "There are 10 types of people in the world: those who understand binary, and those who don't",
            "If at first you don't succeed; call it version 1.0",
            "I'm not anti-social; I'm just not user friendly",
            "My software never has bugs. It just develops random features",
            "Roses are #FF0000 , Violets are #0000FF , All my base belongs to you",
            "In a world without fences and walls, who needs Gates and Windows?",
            "Hand over the calculator, friends don't let friends derive drunk",
            "I would love to change the world, but they won't give me the source code",
            "Enter any 11-digit prime number to continue...",
            "The box said 'Requires Windows 95 or better'. So I installed LINUX",
            "A penny saved is 1.39 cents earned, if you consider income tax",
            "Unix, DOS and Windows...the good, the bad and the ugly",
            "A computer lets you make more mistakes faster than any invention in human history - with the possible exceptions of handguns and " +
                    "tequila",
            "The code that is the hardest to debug is the code that you know cannot possibly be wrong",
            "UNIX is basically a simple operating system, but you have to be a genius to understand the simplicity",
            "Ethernet (n): something used to catch the etherbunny",
            "C://dos C://dos.run run.dos.run",
            "You know it's love when you memorize her IP number to skip DNS overhead",
            "JUST SHUT UP AND REBOOT!!",
            "1f u c4n r34d th1s u r34lly n33d t0 g37 l41d",
            "Alcohol & calculus don't mix. Never drink & derive",
            "How do I set a laser printer to stun?",
            "There is only one satisfying way to boot a computer",
            "Concept: On the keyboard of life, always keep one finger on the escape button",
            "It's not bogus, it's an IBM standard",
            "Be nice to the nerds, for all you know they might be the next Bill Gates!",
            "The farther south you go, the more dollar stores there are",
            "Beware of programmers that carry screwdrivers",
            "The difference between e-mail and regular mail is that computers handle e-mail, and computers never decide to come to work one day and" +
                    " shoot all the other computers",
            "If you want a language that tries to lock up all the sharp objects and fire-making implements, use Pascal or Ada: the Nerf languages, " +
                    "harmless fun for children of all ages, and they won't mar the furniture",
            "COFFEE.EXE Missing - Insert Cup and Press Any Key",
            "Programming today is a race between software engineers striving to build bigger and better idiot-proof programs, and the Universe " +
                    "trying to produce bigger and better idiots. So far, the Universe is winning",
            "LISP = Lots of Irritating Silly Parentheses",
            "The beginning of the programmer's wisdom is understanding the difference between getting program to run and having a runnable program",
            "Squash one bug, you'll see ten new bugs popping",
            "Everytime i time i touch my code, i give birth to ten new bugs"
    };
    private static JokeCreator sInstance;
    private Random mRand;

    private JokeCreator() {
        mRand = new Random();
    }

    public static JokeCreator getsInstance() {
        if (sInstance == null) {
            sInstance = new JokeCreator();
        }

        return sInstance;
    }

    public String getRandomJoke() {
        int value = mRand.nextInt(JOKES.length);
        return JOKES[value];
    }
}
