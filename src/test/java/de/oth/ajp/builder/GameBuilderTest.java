package de.oth.ajp.builder;

import org.junit.jupiter.api.Test;

import static de.oth.ajp.builder.PlayerDetail.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameBuilderTest {

        @Test
        void testPositiveComplexGame() {
            Game g = Game.create()
                    .player(name("Brent"), age(27), level(3))
                    .player(name("Sue"), level(10))
                    .setOnEarth()
                    .player(name("Mary")).asMaster()
                    .player()
                    .adversary(Game.create()
                            .player(name("Capt.	Kirk"),	age(99))
                            .setInSpace()
                            .player(name("Kahn"))
                            .adversary(Game.create()
                                    .player(level(1000))
                                    .get())
                            .get())
                    .get();

            assertEquals(BasicGame.class, g.getClass(), "Builder has to return BasicGame class.");
            assertTrue(g.isOnEarth(), "Players aren't set on earth.");
            assertEquals(4, g.getPlayers().size(), "In game aren't 4 players.");

            Player bret = g.getPlayers().get(0);
            assertEquals("Brent", bret.getName(), "First player names Bret.");
            assertEquals(27, bret.getAge(), "Bret is 27 years old.");
            assertEquals(3, bret.getLevel(), "Bret is on 3. level.");

            Player sue = g.getPlayers().get(1);
            assertEquals("Sue", sue.getName(), "Second player names Sue.");
            assertEquals(10, sue.getLevel(), "Sue is on 10 10. level.");

            Player mary = g.getPlayers().get(2);
            assertEquals("Mary", mary.getName(), "Third player names Mary.");
            assertTrue(mary.isMaster(), "Mary is master in game.");

            Player noname = g.getPlayers().get(3);
            assertEquals("unknown", noname.getName(), "Fourth player doesn't have set name.");
            assertEquals(0, noname.getAge(), "Unknown player doesn't have set age.");
            assertEquals(0, noname.getLevel(), "Unknown player doesn't have set level.");
            assertFalse(noname.isMaster(), "Unknown player isn't master.");

            Game adv1 = g.getAdversary();

            assertNotNull(adv1, "Game has set adversary game.");
            assertEquals(2, adv1.getPlayers().size(), "In adversary game are 2 players.");
            assertTrue(adv1.isInSpace(), "Adversary game is set in space.");

            Player kirk = adv1.getPlayers().get(0);
            assertEquals("Capt.	Kirk", kirk.getName(), "First player in adversary game is Kirk.");
            assertEquals(99, kirk.getAge(), "Kirk is 99 years old.");

            Player kahn = adv1.getPlayers().get(1);
            assertEquals("Kahn", kahn.getName(), "Second player in adversary game is Kahn.");

            Game adv2 = adv1.getAdversary();

            assertNotNull(adv2);
            assertEquals(1, adv2.getPlayers().size());
            assertEquals(1000, adv2.getPlayers().get(0).getLevel());
        }

        @Test
        void testNegativeTwoLocations() {
            assertThrows(IllegalArgumentException.class, () -> Game.create()
                    .player()
                    .adversary(Game.create()
                            .player()
                            .setInSpace()
                            .player()
                            .setOnEarth()
                            .get())
                    .get(), "Players can't be set in two places at the same time.");
        }

        @Test
        void testGameInSpace() {
            Game g = Game.create()
                    .player(name("Tom"))
                    .setInSpace()
                    .get();

            assertTrue(g.isInSpace());
            assertFalse(g.isUnderwater());
            assertFalse(g.isOnEarth());
        }

        @Test
        void testGameOnEarth() {
            Game g = Game.create()
                    .player(name("Tom"))
                    .setOnEarth()
                    .get();

            assertFalse(g.isInSpace());
            assertFalse(g.isUnderwater());
            assertTrue(g.isOnEarth());
        }

        @Test
        void testGameUnderwater() {
            Game g = Game.create()
                    .player(name("Tom"))
                    .setUnderwater()
                    .get();

            assertFalse(g.isInSpace());
            assertTrue(g.isUnderwater());
            assertFalse(g.isOnEarth());
        }
}