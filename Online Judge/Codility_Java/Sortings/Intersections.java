
/*
    END, 100%
 */
import java.util.*;
class Disc implements Comparable<Disc>{
    Disc(int center, int radius){
        this.center = center;
        this.start = center - radius;
        this.end = center + radius;
        if(isOverflow()){
            end = 2147483647;
        }
        if(isUnderflow()){
            start = -2147483648;
        }
    }

    int getStartPoint(){
        return this.start;
    }

    int getEndPoint(){
        return this.end;
    }

    Boolean isOverflow(){
        return (center > end);
    }

    Boolean isUnderflow(){
        return (center < start);
    }

    int getNum(){
        return this.center;
    }

    @Override
    public int compareTo(Disc disc){
        return start.compareTo(disc.start);
    }

    Integer center;
    Integer start;
    Integer end;
}

public class Intersections {
    Intersections(int[] inputs){
        A = inputs;
        totalDiscNum = A.length;
        buildDiscArray();
        buildSortedStartPoints();
    }

    void buildDiscArray(){
        discArray = new ArrayList<Disc>();
        for(int i = 0; i < A.length; i++){
            Disc element = new Disc(i, A[i]);
            discArray.add(element);
        }
        // sort by startPoint
        Collections.sort(discArray);
    }

    void printDiscArray(){
        for(Disc element : discArray){
            System.out.println(element.getNum());
        }
    }

    void printSortedStartPoint(){
        for(int element : sortedStartPoints){
            System.out.println(element);
        }
    }

    int getIntersections(){
        int result = 0;
        for(int i = 0; i < totalDiscNum; i++){
//            System.out.println("i : " + i);
            int curEndPoint = discArray.get(i).getEndPoint();

            // TODO - impelement binary search
            int lastIntersectIndex = binarySearch(i, totalDiscNum-1, curEndPoint);
//            System.out.println("binary search for " + sortedStartPoints[i] + " to " + curEndPoint + " is " + lastIntersectIndex + "(" + sortedStartPoints[lastIntersectIndex] + "), " + (lastIntersectIndex - i) + "point.");
            result += (lastIntersectIndex - i);
            if(result > 10000000){
                return -1;
            }

        }
        return result;
    }

    int binarySearch(int startIndex, int endIndex, int targetStartPoint){
        int medianIndex = (endIndex + startIndex)/2;
        if(medianIndex == endIndex || medianIndex == startIndex){
            if(sortedStartPoints[endIndex] <= targetStartPoint){
                return endIndex;
            }else{
                return startIndex;
            }
        }
        int pivotValue = sortedStartPoints[medianIndex];
        if(pivotValue > targetStartPoint){
            // Pivot value is smaller than target
            return binarySearch(startIndex, medianIndex, targetStartPoint);
        }else if(pivotValue < targetStartPoint){
            // Pivot value is larger than target
            return binarySearch(medianIndex, endIndex, targetStartPoint);
        }else{
            // equals. do linear search.
            while((medianIndex+1) <= endIndex){
                if(pivotValue != sortedStartPoints[medianIndex+1]){
                    return medianIndex;
                }else{
                    medianIndex += 1;
                }
            }
            return medianIndex;
        }
    }

    void buildSortedStartPoints(){
        sortedStartPoints = new int[A.length];
        for(int i = 0; i < A.length; i++){
            sortedStartPoints[i] = discArray.get(i).getStartPoint();
        }
    }

    int[] A;
    int[] sortedStartPoints;
    int totalDiscNum;
    ArrayList<Disc> discArray;
}
