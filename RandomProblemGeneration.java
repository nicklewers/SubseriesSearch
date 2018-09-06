
package timingexamples;

import java.util.Random;

/**
 *
 * @author ajb
 */
public class RandomProblemGeneration {

    public static double[] generateQuery(int s) {
        double[] q = new double[s];
        Random r = new Random();
        for (int i = 0; i < s; i++) {
            q[i] = r.nextDouble();
        }
        return q;
    }

    public static double[][] generateDataSet(int n) {
        double[][] data = new double[n][n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = r.nextDouble();
            }
        }

        return data;
    }
    
    public static void main(String[] args){
        
        int n = 20;
        double[] exampleQuery = generateQuery(n);
        double[][] dataset = generateDataSet(n);
    
        System.out.println("An example query:");
        System.out.println("=================");
        for(double d:exampleQuery){
            System.out.print(d+",");
        }
        System.out.println();
    }

}
