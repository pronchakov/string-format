package io.github.pronchakov.sf;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StrTest {

    @Test
    public void testFormatter() {
        final var formattedString = Str.fmt("Hello {}. My name is {}. How are you?", "friend", "Formatter");
        assertEquals("Hello friend. My name is Formatter. How are you?", formattedString);
    }

    @Test
    public void testWithoutArguments() {
        final var formattedString = Str.fmt("Formatting without arguments. {} is a brackets");
        assertEquals("Formatting without arguments. {} is a brackets", formattedString);
    }

    @Test
    public void testAtStart() {
        final var formattedString = Str.fmt("{} argument is at start", "This");
        assertEquals("This argument is at start", formattedString);
    }

    @Test
    public void testAtEnd() {
        final var formattedString = Str.fmt("This argument is at {}", "end");
        assertEquals("This argument is at end", formattedString);
    }

    @Test
    public void testMissingArgument() {
        final var formattedString = Str.fmt("{}, {}, {}", "one", "two");
        assertEquals("one, two, {}", formattedString);
    }

    @Test
    public void testExtraArgument() {
        final var formattedString = Str.fmt("{}, {}", "one", "two", "three");
        assertEquals("one, two", formattedString);
    }

    @Test
    public void testStringArgument() {
        final var formattedString = Str.fmt("Today is {} of January", "1st");
        assertEquals("Today is 1st of January", formattedString);
    }

    @Test
    public void testIntArgument() {
        final var formattedString = Str.fmt("Today is {} of January", 1);
        assertEquals("Today is 1 of January", formattedString);
    }

    @Test
    public void testLongArgument() {
        final var formattedString = Str.fmt("It's {} year now", 2023L);
        assertEquals("It's 2023 year now", formattedString);
    }

    @Test
    public void testDifferentArguments() {
        final var formattedString = Str.fmt("It's {} year now, {}, day {}", 2023L, "January", 1);
        assertEquals("It's 2023 year now, January, day 1", formattedString);
    }

    @Test
    public void testListArgument() {
        final var formattedString = Str.fmt("First numbers list: {}", List.of("one", "two", "three"));
        assertEquals("First numbers list: [one, two, three]", formattedString);
    }

    @Test
    public void testMapArgument() {
        final var map = new LinkedHashMap<>() {{
            put(1, "one");
            put(2, "two");
            put(3, "three");
        }};
        final var formattedString = Str.fmt("First numbers map: {}", map);
        assertEquals("First numbers map: {1=one, 2=two, 3=three}", formattedString);
    }

    public void testArrayStringArgument() {
        final var formattedString = Str.fmt("First numbers array: {}", new String[]{"one", "two", "three"});
        assertEquals("First numbers array: [one, two, three]", formattedString);
    }

    public void testArrayIntArgument() {
        final var formattedString = Str.fmt("First numbers array: {}", new int[]{1, 2, 3});
        assertEquals("First numbers array: [1, 2, 3]", formattedString);
    }

    public void testArrayStringMixArgument() {
        final var formattedString = Str.fmt("First numbers array: 1:{}, 2:{}, 3:{}", new String[]{"one", "two", "three"}, "four", "five");
        assertEquals("First numbers array: 1:[one, two, three], 2:four, 3:five", formattedString);
    }

    public void testReverseArrayStringMixArgument() {
        final var formattedString = Str.fmt("First numbers array: 1:{}, 2:{}, 3:{}", "four", "five", new String[]{"one", "two", "three"});
        assertEquals("First numbers array: 1:four, 2:five, 3:[one, two, three]", formattedString);
    }

    public void testArrayLongArgument() {
        final var formattedString = Str.fmt("First numbers array: {}", new long[]{1, 2, 3});
        assertEquals("First numbers array: [1, 2, 3]", formattedString);
    }

    public void testArrayDifferentArguments() {
        final var formattedString = Str.fmt("First numbers array: {}", new Object[]{1L, "2", 3});
        assertEquals("First numbers array: [1, 2, 3]", formattedString);
    }

}
