// Respectful difficulty

import java.util.*;

public class NailingPlanks {

    NailingPlanks(int[] plankStartPoints, int[] plankEndPoints, int[] nailPoints){
        plankLocations = getPlankLocations(plankStartPoints, plankEndPoints);
        this.nailPoints = nailPoints;
    }

    TreeMap<Integer, Integer> getPlankStartTreeMap(int[] plankStartPoints){
        TreeMap<Integer, Integer> planks = new TreeMap<>();

        for(int index = 0; index < plankStartPoints.length; index++){
            planks.put(plankStartPoints[index], index);
        }

        return planks;
    }

    TreeMap<Integer, Integer> getPlankEndTreeMap(int[] plankEndPoints){
        TreeMap<Integer, Integer> planks = new TreeMap<>();

        for(int index = 0; index < plankStartPoints.length; index++){
            planks.put(plankEndPoints[index], index);
        }

        return planks;
    }

    int getLeastNailNum(int[] plankStartPoints, int[] plankEndPoints, int[] nailPoints){
        TreeMap<Integer, Integer> plankStartMap = getPlankStartTreeMap(plankStartPoints);
        TreeMap<Integer, Integer> plnakEndMap = getPlankEndTreeMap(plankEndPoints);

        for(int nailIndex = 0; nailIndex < nailPoints.length; nailIndex++){
            // TODO : add search algorithm
            return nailIndex;
        }

        return -1;
    }


    int[] nailPoints;
}
