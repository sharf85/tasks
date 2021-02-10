import java.util.Comparator;

public class CountryAndScoreClubComparator implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub o1, FootballClub o2) {
        int countryCompared = o1.getCountry().compareTo(o2.getCountry());
        if (countryCompared != 0)
            return countryCompared;

        return o2.getAchievedPoint() - o1.getAchievedPoint();
    }
}
