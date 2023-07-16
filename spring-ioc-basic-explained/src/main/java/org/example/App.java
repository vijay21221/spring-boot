package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PubgGameServiceV2 pubgGameService = new PubgGameServiceV2();
        pubgGameService.updateGameStats(2, 4, 4, false);
    }
}
