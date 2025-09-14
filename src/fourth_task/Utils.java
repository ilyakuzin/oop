package fourth_task;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Utils {


    //можно вынести в main функции отсюда, можно создать экземпляр класса в main
    //и там через него вызывать функции
    //а вообще, я бы тесты написал, тоже ок вариант
    // см. тесты на первое задание для примера

    // смотри на код и учись задавать вопросы, я могу ошибиться, учись правильно на него смотреть
    // и видеть возможности для оптимизации, проверки на все ошибки и краевые случаи

    // смотри Java Collection Framework и его иерархию
    // в том числе когда что и где лучше использовать
    public double getAverage(List<Integer> integers) {
        if (integers == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return integers.stream().mapToDouble(ints -> (double) ints).average().getAsDouble();
    }


    public List<String> stringRefactor(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        // check it out, maybe u can use StringBuilder or StringBuffer
        // instead of working with string operations
        // and find out why u should use StringBuilder or StringBuffer
        // then u need 2 do a lot of operations with strings -- its very important!

        //нужно ли делать проверку на пустую строку в списке и что делать с ней?
        //на вход должен даваться массив или список? узнай и подправь код там? где нужно
        return strings.stream()
                .map(str -> "_new_" + str.toUpperCase())
                .collect(Collectors.toList());
    }

    //а тут мб можно будет и оптимизировать
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

    //остальные методы сделаешь сам, там легко и для практики мастхэв
}





