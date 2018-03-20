import java.util.Arrays;
import java.util.*;
import java.util.Map;
/*
    NOT COMPLETED : 58%
 */
class Disc implements Comparable<Disc>{
    Disc(int center, int radius){
        this.center = center;
        this.start = center - radius;
        this.end = center + radius;
    }

    int getStartPoint(){
        return this.start;
    }

    int getEndPoint(){
        return this.end;
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
            for(int reverseI = sortedStartPoints.length - 1; reverseI >= i; reverseI--){
                if(sortedStartPoints[reverseI] <= curEndPoint){
//                    System.out.println(sortedStartPoints[reverseI] + " overd, inter : " + (reverseI - i));
                    result = result + (reverseI - i);
                    break;
                }
            }

        }
        return result;
    }

    void buildSortedStartPoints(){
        sortedStartPoints = new int[A.length];
        for(int i = 0; i < A.length; i++){
            sortedStartPoints[i] = discArray.get(i).getStartPoint();
        }
    }

    int[] A;
    int[] endPoints;
    int[] sortedStartPoints;
    int totalDiscNum;
    ArrayList<Disc> discArray;
}
