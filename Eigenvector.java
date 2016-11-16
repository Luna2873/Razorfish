package eigenvector;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sukun
 */
public class Eigenvector {
    private static double sum = 0;
    
    public static double mean(double[] v) {
        double sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += v[i];
        }
        return sum / v.length;
    }

    private static double CalcuSigm(double[] v){
        double res = 0;
        for (int i = 0; i < v.length; i++) {
            res = Math.pow(v[i],2);
        }
        return res;
    }
    public static void sumaStatus(double[] v){
        double pMean = mean(v);
        CalcuSigm(v);
        System.out.println("The mean is: " + pMean );
    }

    
        public static double euclidDistance(double[] x, double[] y){
        
        double sum = 0;
        int i = 0;
        while(i < x.length){
            sum += Math.pow(Math.abs(x[i]- y[i]),2);
         i++;   
        }
        return Math.sqrt(sum);
    }
    //曼哈顿
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
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int i = 0;
        BufferedReader br = null;
        double[] vector = new double[8];
        int clom = 3;
        String line = "";
        String cvsSplitBy = ",";
        String dataSource = "D:\\Documents\\Projects\\github\\Eigenvector\\"
                            + "src\\eigenvector\\test.csv";
         try {
            br  = new BufferedReader(new FileReader(dataSource));
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                for(int j = 0; j<= data.length;j++){
                    vector[i] = Double.valueOf(data[clom]);    //the fourth clom
                     //System.out.println("Data [User= " + data[0] + " , H.period=" + data[3] + "]");
                }
                i++;
            }
            sumaStatus(vector);
            
            
        }catch (IOException e) {
            System.out.println (e.toString());
        } finally {
            if (br != null)
                br.close();
        }
    }
    
    /*
     public static final int COLUMN_NUM = 2;//csv文件列数
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        double[] vector = new double[8];
        int clom = 3;
        String line = "";
        String cvsSplitBy = ",";
        String dataSource = "D:\\Documents\\Projects\\github\\Eigenvector\\"
                            + "src\\eigenvector\\test.csv";
         try {
            ArrayList<String[]> lineList = new ArrayList<String[]>(); 
            br  = new BufferedReader(new FileReader(dataSource));
            br.readLine();  
                while ((line = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(line, ","); // 以逗号作为分隔符
                    String[] currCol = new String[COLUMN_NUM]; // Each currCol has 9 fields, so we need room for the 8 tokens.
                    for(int i = 0; i < COLUMN_NUM; i++) { // For each token in the line that we've read:
                        //先判断是否还有待读取数据，防止溢出
                        if(st.hasMoreTokens()){
                            st.nextToken(); 
                            st.nextToken(); 
                            currCol[i]  = st.nextToken(); 
                        }
                    }
                    lineList.add(currCol); 
                }
                String[][] str = new String[lineList.size()][COLUMN_NUM];
                for(int i = 0; i < lineList.size(); i++) {
                      for(int j = 0; j < COLUMN_NUM; j++) {
                       str[i][j] = lineList.get(i)[j];
                       System.out.print(str[i][j] +" ");
                      }
                      System.out.println();
                }
            sumaStatus(currCol);
            
        }catch (IOException e) {
            System.out.println (e.toString());
        } finally {
            if (br != null)
                br.close();
        }
    }
    
    */
}
