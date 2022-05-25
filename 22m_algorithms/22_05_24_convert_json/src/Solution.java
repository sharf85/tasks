import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


    public Map<String, Object> transformToCamelCase(Map<String, Object> json) {
        Map<String, Object> res = new HashMap<>();
        for (String key : json.keySet()) {
            String newKey = snakeToCamel(key);
            Object value = json.get(key);
            res.put(newKey, transformValue(value));
        }
        return res;
    }

    /**
     * @param
     * @return
     */
    List<Object> transformListValue(List<Object> value) {
        List<Object> res = new ArrayList<>();
        for (Object elt : value) {
            res.add(transformValue(elt));
        }
        return res;
    }

    Object transformValue(Object value) {
        if (value instanceof Map) {
            return transformToCamelCase((Map) value);
        } else if (value instanceof List) {
            return transformListValue((List) value);
        } else {
            return value;
        }
    }

    /**
     * "hello_world" -> "helloWorld"
     * "snake_case" -> "camelCase"
     *
     * @param snake_case
     * @return
     */
    String snakeToCamel(String snake_case) {
        StringBuilder sb = new StringBuilder();

        final int length = snake_case.length();
        for (int i = 0; i < length; i++) {
            if (snake_case.charAt(i) == '_') {
                sb.append(Character.toUpperCase(snake_case.charAt(++i)));
            } else {
                sb.append(snake_case.charAt(i));
            }
        }
        return sb.toString();
    }
}
