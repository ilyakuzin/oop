package fourth_task;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {

    // можно вынести в main функции отсюда, можно создать экземпляр класса в main
    // и там через него вызывать функции
    // а вообще, я бы тесты написал, тоже ок вариант
    // см. тесты на первое задание для примера

    // смотри на код и учись задавать вопросы, я могу ошибиться, учись правильно на него смотреть
    // и видеть возможности для оптимизации, проверки на все ошибки и краевые случаи

    // смотри Java Collection Framework и его иерархию
    // в том числе когда что и где лучше использовать

    //Calculates the arithmetic average of integers in the specified list.
    public double getAverage(List<Integer> integers) {
        if (integers == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return integers.stream().mapToDouble(ints -> (double) ints).average().getAsDouble();
    }


    public List<String> stringRefactor(List<String> strings) {
        // do we really need this? we can move this to stream expression
        if (strings == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        // check it out, maybe u can use StringBuilder or StringBuffer
        // instead of working with string operations
        // and find out why u should use StringBuilder or StringBuffer
        // then u need 2 do a lot of operations with strings -- its very important!

        // нужно ли делать проверку на пустую строку в списке и что делать с ней?
        // на вход должен даваться массив или список? узнай и подправь код там? где нужно
        return strings.stream()
                .map(str -> "_new_" + str.toUpperCase())
                .collect(Collectors.toList());
    }

    // maybe here it will be possible to optimize
    // need test and checks
    public static List<Integer> getSquaresOfUniqueElements(List<Integer> integers) {
        if (integers == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return integers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1) // only unique
                .map(entry -> entry.getKey() * entry.getKey()) // square
                .collect(Collectors.toList());
    }

    // write tests, check u need to write comparator for .sorted() -- to ignore case lower/apper
    // pretty sure yes
    // example: Apple, Book, actor
    // should be actor, Apple, Book
    //easy to do -- we need to add some code in one line
    // but dont use any ai -- read docs, find examples in internet
    public static List<String> getFilteredAndSortedStrings(List<String> strings, char c) {
        return strings.stream().filter(
                        s -> !s.isEmpty() &&
                                Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(c))
                .sorted()
                .collect(Collectors.toList());
    }


}





