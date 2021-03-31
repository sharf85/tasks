import java.util.List;

public class Solution {

    /**
     * Метод должен делать следущее: на вход есть текст, состоящий из слов и пробелов. Не может быть больше одного
     * пробела между двумя словами и не может быть пробелов на концах текста.
     * Необходимо обрезать текст таким образом, чтобы:
     * 1) он имел максимально возможную длину, но не больше значения 'index'
     * 2) он состоял из целых слов (не содержал неполные слова)
     * <p>
     * Пример:
     * (Hello world, 5) ->Hello
     * (Hello world, 8) ->Hello
     * (Hello world, 11) ->Hello world
     *
     * @param text
     * @param index
     * @return
     */
    public String task1(String text, int index) {

    }


    /**
     * Имеется текст, необходимо его разбить на подпоследовательности строки pattern и сложить в лист.
     * Разбиение должно иметь минимально возможное число составляющих.
     * Обе строки содержат лишь маленькие символы латинского алфавита.
     * Вернуть null, если разбить не получается.
     * <p>
     * "Hlo" substring of "Hello"
     * "lHo" non substring of "Hello"
     * <p>
     * text = "helloworld", pattern = "helworeld"
     * result = {hel, lo, world}
     *
     * Подсказка: взять задачу на определение подпоследовательности и задачу на разбиение текста на слова из словаря
     * из папки 12 группы.
     * @param text
     * @param pattern
     * @return
     */
    public List<String> task2(String text, String pattern) {

    }

}
