package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(60, "points").build();

        Matcher m3 = query.oneOf(m1, m2).build();
        
        System.out.println("\n\nOr with QueryBuilder");
        
        for (Player player : stats.matches(m3)) {
            System.out.println(player);
        }


        /*
        System.out.println("And + HasAtLeast:\n");  
        
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        System.out.println("\n\nAnd + hasFewerThan:\n");
        
        Matcher m2 = new And( new HasFewerThan(20, "goals"),
                             new HasFewerThan(20, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m2)) {
            System.out.println( player );
        }
        
        System.out.println("\n\nOr + hasAtleast:\n");
        
        Matcher m3 = new And(new Or( new HasAtLeast(20, "goals"),
                             new HasAtLeast(20, "assists")),
                             new PlaysIn("PHI"));
        
        for (Player player : stats.matches(m3)) {
            System.out.println( player );
        }        
        
        System.out.println("\n\nNot + hasAtleast:\n");
        
        Matcher m4 = new And(new Or( new HasAtLeast(25, "goals"),
                             new HasAtLeast(30, "assists")),
                            new Not(new PlaysIn("PHI")));
        
        for (Player player : stats.matches(m4)) {
            System.out.println( player );
        }  
         */
    }

}
