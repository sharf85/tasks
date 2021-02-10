import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void table() {

        List<FootballClub> expectedList = Arrays.asList(
                new FootballClub("Germany", "BVG", 100),
                new FootballClub("Germany", "Hertha", 40),
                new FootballClub("Italy", "Juventus", 140),
                new FootballClub("Italy", "Milan", 100),
                new FootballClub("Italy", "Lazio", 40),
                new FootballClub("Spain", "Barcelona", 40));

        List<FootballClub> listFC = Arrays.asList(
                new FootballClub("Italy", "Juventus", 140),
                new FootballClub("Germany", "BVG", 100),
                new FootballClub("Italy", "Milan", 100),
                new FootballClub("Italy", "Lazio", 40),
                new FootballClub("Spain", "Barcelona", 40),
                new FootballClub("Germany", "Hertha", 40)
        );
        int i = 0;
        //System.out.println(operation.table(listFC));
        List<FootballClub> sortListFC = solution.solve(listFC);
        for (FootballClub elt : sortListFC) {
            FootballClub eltTest = expectedList.get(i);
            assertEquals(eltTest.getCountry(), elt.getCountry());
            assertEquals(eltTest.getAchievedPoint(), elt.getAchievedPoint());
            i++;
        }

        assertEquals(6, i);
    }
}
