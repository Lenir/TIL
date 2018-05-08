// Respectful difficulty

import java.util.TreeMap;

public class NailingPlanks {

    NailingPlanks(int[] plankStartPoints, int[] plankEndPoints, int[] nailPoints){
        plankLocations = getPlankLocations(plankStartPoints, plankEndPoints);
        this.nailPoints = nailPoints;
    }

    TreeMap<Integer, Integer> getPlankLocations(int[] plankStartPoints, int[] plankEndPoints){
        TreeMap<Integer, Integer> planks = new TreeMap<>();

        for(int index = 0; index < plankStartPoints.length; index++){
            planks.put(plankStartPoints[index], plankEndPoints[index]);
        }

        return planks;
    }

    int getLeastNailNum(){
        for(int nailIndex = 0; nailIndex < nailPoints.length; nailIndex++){
            // TODO : write code that determine which planks are nailed.
            return nailIndex;
        }

        return -1;
    }



    TreeMap<Integer, Integer> plankLocations;
    int[] nailPoints;
}
