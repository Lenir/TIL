// Respectful difficulty

import java.util.*;

public class NailingPlanks {

    TreeMap<Integer, Integer> buildNailMap(int[] nails){
        TreeMap<Integer, Integer> nailMap = new TreeMap<>();

        for(int index = 0; index < nails.length; index++){
            nailMap.put(nails[index], index);
        }

        return nailMap;
    }

    int findFrontmostNail(int plankStart, int plankEnd, TreeMap<Integer, Integer> nails){
        int nailIndex = -1;

        int begin = 0;
        int end = nails.size();
        while(begin < end){
            int median = (begin + end) / 2;
            int medianStart =
        }

        return nailIndex;
    }

    int getLeastNailNum(int[] plankStartPoints, int[] plankEndPoints, int[] nails){

        TreeMap<Integer, Integer> nailMap = buildNailMap(nails);

        for(int plankIndex = 0; plankIndex < plankStartPoints.length; plankIndex++){
            // TODO : find every plank's frontmost nail. return max nailIndex.

        }

        return -1;
    }


    int[] nailPoints;
}
