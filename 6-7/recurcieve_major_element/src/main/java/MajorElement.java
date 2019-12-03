public class MajorElement {

    public boolean isMajorElement(int[] array) {
        return getMajorityElement(array, 0, array.length) > -1;
    }

    private int getMajorityElement(int[] array, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return array[left];
        }

        int middle = (right + left) / 2;
        int mLeft = getMajorityElement(array, left, middle);
        int mRight = getMajorityElement(array, middle, right);

        if (mLeft == mRight)
            return mLeft;

        if (mLeft > -1) {
            int counter = 0;
            for (int i = left; i < right; i++) {
                if (array[i] == mLeft && ++counter > (right - left) / 2)
                    return mLeft;
            }

        }

        if (mRight > -1) {
            int counter = 0;
            for (int i = left; i < right; i++) {
                if (array[i] == mRight && ++counter > (right - left) / 2)
                    return mRight;
            }

        }
        return -1;
    }
}


