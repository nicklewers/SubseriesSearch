/**
 * SeriesSearch
 */
import java.util.Arrays;

public class SeriesSearch {

    // static int[] T = {1,2,1,0,3,5};
    static int[][] Tn = {
        {1,5,2,7,3,1},
        {0,3,1,1,0,3},
        {1,0,2,5,2,1},
        {1,4,1,2,4,6},
        {4,5,6,3,2,1},
        {6,7,2,3,5,2}
    };
    static int[] S = {1,0,3};

    public static double[] distance(int[] S, int[] T, int subSeriesIndex, int startIndex){

        double innerResult =0;
        double sqrtResult =0 ;
        double[] result = new double[3];
        
        for(int k = 0; k < S.length; k++){
            innerResult += Math.pow(S[k] - T[k], 2);
            innerResult = Math.sqrt(innerResult);
        }
        
        
        result[0] = innerResult;
        result[1] = subSeriesIndex;
        result[2] = startIndex;
        return result;
    }

    
    public static double[] matchSubSeries(int[] S, int[][] Tn){

        double[] closestSub = {Tn.length, 0, 0};
        int distances = 0;
        for(int j = 0; j < Tn.length; j++){
            for(int i = 0; i+S.length - 1 < Tn.length; i++ ){
                distances++;
                double[] result = distance(S, Arrays.copyOfRange(Tn[j], i, i+S.length), j, i);
                 if(result[0] < closestSub[0]){
                     closestSub = result;
                 }
             }
        }
        System.out.println(distances);
        return closestSub;
    }

    public static void main(String[] args) {
        double[] match = matchSubSeries(S, Tn);
        System.out.println("Subseries index: "+match[1]+"\nSubseries element starting index: "+match[2]);
    }
}