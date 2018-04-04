/*
    END, 100%
 */

public class MinPerimeterRectangle {
    MinPerimeterRectangle(int N){
        area = N;
    }

    int getMinPerimeter(){
        int minPerimeter = getPerimeter(1, area);

        for(int a = 1; a <= Math.ceil(Math.sqrt(area)); a++){
            if(area % a == 0){
                minPerimeter = Math.min(minPerimeter, getPerimeter(a, area/a));
            }
        }

        return minPerimeter;
    }

    int getPerimeter(int A, int B){
        return 2*(A + B);
    }

    int area;
}
