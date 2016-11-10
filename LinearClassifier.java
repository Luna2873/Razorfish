
package linearclassifier;

public class LinearClassifier {
        
    public static double euclidDistance(double[] x, double[] y){
        
        double sum = 0;
        int i = 0;
        while(i < x.length){
            sum += Math.pow(Math.abs(x[i]- y[i]),2);
         i++;   
        }
        return Math.sqrt(sum);
    }
    
    public static double manhattanDistance(double[] x, double[] y){
        
        double sum = 0;
        int i = 0;
        while(i < x.length){
            sum += Math.abs(x[i]- y[i]);
         i++;   
        }
        return sum;
    }
    
    public static void classifyEuclidean(double[] x, double[] y, double threshold){
        double distance = euclidDistance(x,y);
        if(distance < threshold){
            System.out.println("User Vector is authentic");
        }
        else{
            System.out.println("User Vector is not authentic");
        }
    }
    public static void classifyManhattan(double[] x, double[] y, double threshold){
        double distance = manhattanDistance(x,y);
        if(distance < threshold){
            System.out.println("User Vector is authentic");
        }
        else{
            System.out.println("User Vector is not authentic");
        }
    }
    

    public static void main(String[] args) {
        double[] uVector1 = {1.0,2.0,3.0};
        double[] uVector2 = {1.5,2.5,3.5};
        double[] uVector3 = {1.1,2.2,3.3};
        double[] uVector4 = {1.2,2.4,3.6};
        double[] uVector5 = {1.2,2.2,3.2};
        double[] uVector6 = {1.1,2.3,3.7};
        
        double[][] uV = {uVector1,uVector2,uVector3,uVector4,uVector5,
        uVector6};
        
        int i = 0;
        int vectorCount = 0;
        while(i < uV.length){
            int j = 0;
            while(j < uV.length){
              classifyManhattan(uV[i],uV[j],0.05); 
              vectorCount++;
             j++;   
            }
         i++;   
        }
        System.out.println(vectorCount + " vectors have been classified");
    }
    
}
