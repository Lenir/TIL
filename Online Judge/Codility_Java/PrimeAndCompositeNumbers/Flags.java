import java.util.*;

public class Flags {
    Flags(int[] heights){
        this.heights = heights;
        peaks = new ArrayList<>();
        peakDifferences = new ArrayList<>();
        buildPeaksArray();
    }

    void buildPeaksArray(){
        int lastPeak = -1;
        for(int i = 1; i < heights.length-1; i++){
            if(heights[i] > heights[i-1] && heights[i] > heights[i+1]){
                if(lastPeak > 0){
                    peakDifferences.add(i - lastPeak);
                }
                peaks.add(i);
                lastPeak = i;
            }
        }
    }

    int getMaximumFlagNum(){
        if(peaks.size() == 0){
            return 0;
        }
        int flags = (int)Math.ceil(Math.sqrt((heights.length)));
        flags = Math.min(flags, peaks.size());
        for(int maxFlagCandidate = flags; maxFlagCandidate > 0; maxFlagCandidate--){
            int index = 0;
            int distance = 0;
            int remainFlags = maxFlagCandidate - 1;
            while(index <= peakDifferences.size()-1){
                distance += peakDifferences.get(index);
                if(distance >= maxFlagCandidate ){
                    remainFlags -= 1;
                    distance = 0;
                }
                if(remainFlags == 0){
                    return maxFlagCandidate;
                }
                index += 1;
            }
        }
        return flags;
    }

    int[] heights;
    ArrayList<Integer> peaks;
    ArrayList<Integer> peakDifferences;
}
