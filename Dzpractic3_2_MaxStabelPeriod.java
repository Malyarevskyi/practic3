package practic.practic3;

import java.util.ArrayList;
import java.util.Collections;

public class Dzpractic3_2_MaxStabelPeriod {
    public static void main(String[] args) {
        int[] period = {3, 4, 5, 2, 4, 2, 4, 3, 5, 2, 3, 4, 2, 3, 4, 5, 6, 4, 3, 3, 4, 4, 5};

        int maxStablePeriod = getMaxStablePeriod(period);

        System.out.println("The longest stable period was " + maxStablePeriod + " months");
    }

    private static int getMaxStablePeriod(int[] period) {
        int count = 1;

        ArrayList<Integer> stablePeriods = new ArrayList<>();

        for (int i = 0; i < period.length - 1; i++) {
            if (period[i] - period[i + 1] == 1 || period[i] - period[i + 1] == -1 || period[i] == period[i + 1]) {
                count++;
            } else {
                stablePeriods.add(count);
                count = 1;
            }
        }

        Collections.sort(stablePeriods);

        return stablePeriods.get(stablePeriods.size() - 1);
    }
}

