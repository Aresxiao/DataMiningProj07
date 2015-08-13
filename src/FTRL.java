import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FTRL {
	
	double alpha;
	double beta;
	double L1;
	double L2;
	double[] z;
	double[] n;
	double[] w;
	int D = (int)Math.pow(2, 25)+10000000;
	int epoch;
	
	public FTRL(){
		alpha = 0.06;
		beta = 1.0;
		L1 = 1.0;
		L2 = 1.0;
		epoch = 5;
		z = new double[D];
		n = new double[D];
		w = new double[D];
	}
	
	public double predict(int[] x){
		double wTx = 0;
		
		for(int i = 0;i<x.length;i++){
			double sign = 1;
			int index = x[i];
			if(z[index]<0)
				sign = -1;
			if((sign*z[index])<L1)
				w[index] = 0;
			else {
				w[index] = (sign * L1 - z[index])/((beta + Math.sqrt(n[index]))/alpha + L2);
			}
			wTx += w[index];
		}
		
		wTx = Math.max(Math.min(wTx, 35.0), -35.0);
		double p = Math.exp(-wTx);
		p = 1.0/(1.0+p);
		return p;
	}
	
	public void update(int[] x,double p,double y){
		double g = p - y;
		for(int i = 0;i < x.length;i++){
			int index = x[i];
			double sigma = (Math.sqrt(n[index]+g*g) - Math.sqrt(n[index]))/alpha;
			z[index] = z[index] + g - sigma*w[index];
			n[index] = n[index] + g*g;
		}
	}
	
	public double logLoss(double p,double y){
		p = Math.max(Math.min(p, 1.0 - Math.pow(10, -14)), Math.pow(10, -14));
		if(y==1){
			return -Math.log(p);
		}
		else {
			return -Math.log(1.0-p);
		}
	}
	
	public void execute() throws FileNotFoundException{
		String directory = "data\\";
		String resultString = directory + "Submission.csv";
		String trainString = directory + "train.csv";
		String testString = directory + "test.csv";
		
		int r = 0;
		while(r < epoch){
			Scanner trainScanner = new Scanner(new File(trainString));
			String readString = trainScanner.nextLine();
			System.out.println("开始执行");
			int count = 0;
			double loss = 0;
			while(trainScanner.hasNext()){			//训练模型
				readString = trainScanner.nextLine();
				
				String[] featureString = readString.split(","); 
				
				double y = 0;
				if(featureString[1].equals("1")){
					y = 1;
				}
				int[] feature = new int[featureString.length-1];
				feature[0] = 0;
				featureString[2] = featureString[2].substring(6);
				for(int i = 1;i < feature.length; i++){
					String valueString = (i+1)+"_"+featureString[i+1];
					int index = Math.abs(valueString.hashCode() % D);
					feature[i] = index;
				}
				double p = predict(feature);
				loss = loss+logLoss(p, y);
				count++;
				update(feature, p, y);
			}
			loss = loss/count;
			System.out.println("r="+r+",训练完成,损失为:"+loss);
			trainScanner.close();
			r++;
		}
		
		Scanner testScanner = new Scanner(new File(testString));
		PrintWriter printWriter = new PrintWriter(new File(resultString));
		printWriter.println("id,click");
		String readString = testScanner.nextLine();
		
		while(testScanner.hasNext()){				//预测数据
			readString = testScanner.nextLine();
			
			String[] featureString = readString.split(",");
			String idString = featureString[0];
			int[] feature = new int[featureString.length];
			feature[0] = 0;
			featureString[1] = featureString[1].substring(6);
			for(int i = 1;i < feature.length;i++){
				String valueString = (i+1)+"_"+featureString[i];
				int index = Math.abs(valueString.hashCode() % D);
				feature[i] = index;
			}
			
			double p = predict(feature);
			printWriter.println(idString+","+p);
		}
		printWriter.close();
		testScanner.close();
		
		System.out.println("完成预测和写文件");
	}
	
	
	
}
