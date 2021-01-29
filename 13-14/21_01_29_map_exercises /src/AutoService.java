import java.text.Collator;
import java.util.*;

public class AutoService {

    Map<String, List<Auto>> groupByMake(List<Auto> autos) {
        Map<String, List<Auto>> res = new HashMap<>();

        for (Auto auto : autos) {
            List<Auto> autosList = res.get(auto.getMake());

            if (autosList == null) {
                autosList = new ArrayList<>();
                res.put(auto.getMake(), autosList);
            }

            autosList.add(auto);
        }

        return res;
    }

}
