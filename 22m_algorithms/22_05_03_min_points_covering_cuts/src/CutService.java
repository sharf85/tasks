import java.util.List;

public class CutService {
    public int getMinPointsCoveringCuts(List<Cut> cuts) {
//        cuts.sort(Comparator.comparing(Cut::getLeft));
        cuts.sort((cut1, cut2) -> Integer.compare(cut1.getLeft(), cut2.getLeft()));

        int res = 0;
        int hypotheticalCoveringPoint = cuts.get(0).getRight();
        for (Cut cut : cuts) {
            if (cut.getRight() < hypotheticalCoveringPoint) {
                hypotheticalCoveringPoint = cut.getRight();
            } else if (cut.getLeft() > hypotheticalCoveringPoint) {
                res++;
                hypotheticalCoveringPoint = cut.getRight();
            }
        }

        res++;
        return res;
    }
}
