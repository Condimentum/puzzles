import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class PuzzlesTest
{

    @Test
    @DisplayName( "Puzzle 1 - SelectionLongestWords" )
    void testSelectLongestWords()
    {
        List<String> input = Arrays.asList( "alfa", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotel" );

        List<String> result = Puzzles.selectLongestWords( input );

        assertEquals( Arrays.asList( "charlie", "foxtrot" ), result );
    }

    @Test
    @DisplayName( "Puzzle 2 - UpcaseOddLengthWords" )
    void testUpcaseOddLengthWords()
    {
        List<String> input = Arrays.asList( "alfa", "bravo", "charlie", "delta", "echo", "foxtrot" );

        List<String> result = Puzzles.upcaseOddLengthWords( input );

        assertEquals( Arrays.asList( "BRAVO", "CHARLIE", "DELTA", "FOXTROT" ), result );
    }

    @Test
    @DisplayName( "Puzzle 3 - MapOfStringByInitialCharacter" )
    void testMapOfStringByInitialCharacter()
    {
        List<String> input = Arrays
            .asList( "aardvark", "bison", "capybara", "alligator", "bushbaby", "chimpanzee", "avocet", "bustard",
                "capuchin" );

        Map<Character, String> result = Puzzles.mapOfStringByInitialCharacter( input );

        assertEquals( "aardvark:alligator:avocet", result.get( 'a' ) );
        assertEquals( "bison:bushbaby:bustard", result.get( 'b' ) );
        assertEquals( "capybara:chimpanzee:capuchin", result.get( 'c' ) );
    }

    @Test
    @DisplayName( "Puzzle 4 - Denormalize Map" )
    void testDenormalizeMap()
    {
        Map<Integer, List<String>> input = new HashMap<>();
        input.put( 4, Arrays.asList( "ibex", "hedgehog", "wombat" ) );
        input.put( 6, Arrays.asList( "ant", "beetle", "cricket" ) );
        input.put( 8, Arrays.asList( "octopus", "spider", "squid" ) );
        input.put( 10, Arrays.asList( "crab", "lobster", "scorpion" ) );
        input.put( 750, Arrays.asList( "millipede" ) );

        List<String> result = Puzzles.denormilizeMap( input );

        assertEquals( 13, result.size() );
        assertTrue( result.contains( "ibex:4" ) );
        assertTrue( result.contains( "hedgehog:4" ) );
        assertTrue( result.contains( "wombat:4" ) );
        assertTrue( result.contains( "ant:6" ) );
        assertTrue( result.contains( "beetle:6" ) );
        assertTrue( result.contains( "cricket:6" ) );
        assertTrue( result.contains( "octopus:8" ) );
        assertTrue( result.contains( "spider:8" ) );
        assertTrue( result.contains( "squid:8" ) );
        assertTrue( result.contains( "crab:10" ) );
        assertTrue( result.contains( "lobster:10" ) );
        assertTrue( result.contains( "scorpion:10" ) );
        assertTrue( result.contains( "millipede:750" ) );
    }

    @Test
    @DisplayName( "Puzzle 5 - InvertMultimap" )
    void testInvertMultiMap()
    {
        Map<String, Set<Integer>> input = new HashMap<>();
        input.put( "a", new HashSet<>( Arrays.asList( 1, 2 ) ) );
        input.put( "b", new HashSet<>( Arrays.asList( 2, 3 ) ) );
        input.put( "c", new HashSet<>( Arrays.asList( 1, 3 ) ) );
        input.put( "d", new HashSet<>( Arrays.asList( 1, 4 ) ) );
        input.put( "e", new HashSet<>( Arrays.asList( 2, 4 ) ) );
        input.put( "f", new HashSet<>( Arrays.asList( 3, 4 ) ) );

        Map<Integer, Set<String>> result = Puzzles.invertMultiMap( input );

        assertEquals( new HashSet<>( Arrays.asList( "a", "c", "d" ) ), result.get( 1 ) );
        assertEquals( new HashSet<>( Arrays.asList( "a", "b", "e" ) ), result.get( 2 ) );
        assertEquals( new HashSet<>( Arrays.asList( "b", "c", "f" ) ), result.get( 3 ) );
        assertEquals( new HashSet<>( Arrays.asList( "d", "e", "f" ) ), result.get( 4 ) );
        assertEquals( 4, result.size() );
    }
}
