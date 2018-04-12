import java.util.Arrays;
import java.util.Collections;

public class NoOvertime {
    NoOvertime(int no, int[] works){
        this.works = works;
        this.no = no;
        minWork = getMinimumWork();
        additionalWork = computeAdditionalWork();
    }


    int getMinimumWork(){
        int minimum = works[0];
        for(int work : works){
            minimum = Math.min(minimum, work);
        }
        return minimum;
    }

    int computeAdditionalWork(){
        int workOffset = 0;
        for(int work : works){
            workOffset += (work - minWork);
        }

        return workOffset;
    }

    Boolean isGoingLowerThanMinWork(){
        return no > additionalWork;
    }

    public int noOvertime() {
        int result = 0;
        // 야근 지수를 최소화 하였을 때의 야근 지수는 몇일까요?
        if(isGoingLowerThanMinWork()){
            no -= additionalWork;
            int spreadTime = (no / works.length);
            int remainerTime = no - (no*spreadTime);
            for(int work = 0; work < works.length; work++){
                int overTimeIndex = (minWork - spreadTime);
                if(remainerTime > 0){
                    overTimeIndex -= 1;
                    remainerTime -= 1;
                }
                result += (overTimeIndex*overTimeIndex);
            }
        }else{
            Arrays.sort(works);
            for(int index = works.length-1; index >= 0 && no > 0; index--){
                if(index > 0){
                    if((works[index] - works[index-1]) > no ){
                        works[index] -= no;
                        no = 0;
                    }else{
                        works[index] = works[index - 1];
                        no -= works[index] - works[index-1];
                    }
                }else{
                    works[index] -= no;
                }
            }
            for(int work : works){
                result += work * work;
            }
        }
        return result;
    }

    int[] works;
    int no;
    int minWork;
    int additionalWork;
}
