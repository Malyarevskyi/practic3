package practic.practic3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Dzpractic3_6_DwarfsFood {
    public static void main(String[] args) {
        int[] dwarfsHeight = {5, 6, 8, 4, 3, 2, 1};
        int[] foodForDwarfs = {9, 1, 2, 4, 7, 5, 6};

        int[] result = findSequence(dwarfsHeight, foodForDwarfs);

        System.out.println(Arrays.toString(result));
    }

    private static int[] findSequence(int[] dwarfsHeight, int[] foodForDwarfs) {
        int amountOfDwarfs = dwarfsHeight.length;

        ArrayList<Integer> topToDownDwarfs = new ArrayList<>();
        for (int dwarf : dwarfsHeight) {
            topToDownDwarfs.add(dwarf);
        }

        ArrayList<Integer> topToDownFood = new ArrayList<>();
        for (int food : foodForDwarfs) {
            topToDownFood.add(food);
        }

        Collections.sort(topToDownDwarfs, Collections.reverseOrder());
        Collections.sort(topToDownFood, Collections.reverseOrder());

        int[] result = new int[amountOfDwarfs];

        for (int i = 0; i < amountOfDwarfs; i++) {
            int bigDwarf = topToDownDwarfs.get(i);
            int bigFood = topToDownFood.get(i);
            int dwarfIndex = 0;
            int foodIndex = 0;

            for (int j = 0, k = 0; j < amountOfDwarfs && k < amountOfDwarfs; j++, k++) {
                if (bigDwarf == dwarfsHeight[j]) dwarfIndex = j;
                if (bigFood == foodForDwarfs[k]) foodIndex = k;
            }

            result[dwarfIndex] = foodIndex;
        }
        return result;
    }
}
