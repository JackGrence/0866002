import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.stream.events.ProcessingInstruction;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PriorityQueueTest {

    @ParameterizedTest
    @MethodSource("integerParameters")
    public void orderedInt(List<Integer> randList, List<Integer> orderedList) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(randList);
        for (Integer i : orderedList) {
            assertEquals(i, priorityQueue.poll());
        }
    }

    static Stream<Arguments> integerParameters() {
        return Stream.of(
                arguments(Arrays.asList(1, 5, 3, 4, 10), Arrays.asList(3, 1, 4, 5, 10)),
                arguments(Arrays.asList(80, 50, -3, 4, 10), Arrays.asList(-3, 4, 10, 50, 80)),
                arguments(Arrays.asList(1, 50, 3, 4, 10), Arrays.asList(1, 3, 4, 10, 50)),
                arguments(Arrays.asList(18, 5, 30, 4, -10), Arrays.asList(-10, 4, 5, 18, 30)),
                arguments(Arrays.asList(1, 55, -3, 44, 15), Arrays.asList(-3, 1, 15, 44, 55))
        );
    }

    @Test
    public void outOfBoundException() {
        PriorityQueue<String> emptyPriorityQueue = new PriorityQueue<>();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            PriorityQueue<String> exception = new PriorityQueue<>(emptyPriorityQueue);
        });
    }

    @Test
    public void nullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<String> exception = new PriorityQueue<>(Arrays.asList(null));
        });
        assertThrows(NullPointerException.class, () -> {
            PriorityQueue<String> trigger = new PriorityQueue<>();
            trigger.add(null);
        });
    }

    @Test
    public void illegalArgumentException() {
        PriorityQueue<String> trigger = new PriorityQueue<>();
        assertThrows(IllegalArgumentException.class, () -> {
            trigger.addAll(trigger);
        });
    }
}