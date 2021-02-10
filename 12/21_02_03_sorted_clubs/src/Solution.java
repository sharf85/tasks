import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Solution {

    /**
     * The method returns a NEW list with the clubs sorted by country and score
     *
     * @param clubs
     * @return
     */
    public List<FootballClub> solve(List<FootballClub> clubs) {
        List<FootballClub> res = new ArrayList<>(clubs);

//        Comparator<FootballClub> reversedScoreComp = Comparator.comparing(FootballClub::getAchievedPoint).reversed();
//
//        Comparator<FootballClub> comparator = Comparator
//                .comparing(FootballClub::getCountry)
//                .thenComparing(reversedScoreComp);
//
//        res.sort(comparator);
        res.sort(new CountryAndScoreClubComparator());

        return res;
    }
}
