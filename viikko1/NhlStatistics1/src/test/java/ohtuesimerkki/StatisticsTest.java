package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    public StatisticsTest() {
    }

    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSearch() {
        assertEquals("Kurri", stats.search("Kurri").getName());
    }

    @Test
    public void testSearchWhenNotExist() {
        //should return null when not found
        assertNull(stats.search("Jutila"));
    }

    @Test
    public void getTeam() {
        assertEquals(3, stats.team("EDM").size());
    }

    @Test
    public void topScorers() {
        assertEquals("Gretzky", stats.topScorers(2).get(0).getName());
    }
}
