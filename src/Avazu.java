import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Avazu {
	
	public static void main(String[] args) throws FileNotFoundException{
		
		
		//FTRL ftrl = new FTRL();
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddHHmmss");
		Date startDate = new Date();
		System.out.println(sdf.format(startDate));
		
		//ftrl.execute();
		
		Date endDate = new Date();
		System.out.println(sdf.format(endDate));
		
		/**
		 * D:
		 * 20 0.3928350669501395	0.3953837
		 * 23 0.3925770794062088	0.3949895
		 * 
		 * D=23 alpha=0.05 0.3943889867393768	0.3947431
		 * D=20 alpha=0.01 0.4006194539838448
		 * alpha:
		 * D:23 alpha=0.05 0.39438898673937683 
		 * D:20 alpha=0.05 0.3945528022936256 
		 * 		alpha=0.15 0.3920284035326965	0.3961264
		 * D:20 alpha=0.2 0.3915621155326924	0.3969311
		 * D:20 alpha=0.3 0.3911010758892749
		 * 		alpha=0.5 0.3909766472162713	0.4011584
		 * 		alpha=0.8 0.391096048663087
		 * 
		 * L2
		 * 		L2=2.0 0.3928916204115726
		 * 
		 * L1
		 * 		L1=2.0 0.39327932293786055
		 * 		L1=1.5 0.39307620249725034		0.3953043
		 * 		L1=1.2 0.39293591654559
		 * 		L1=0.8 0.3927288635424013
		 * 		L1=0.5 0.39255780870485135		
		 * beta:
		 * 		beta=5 0.3942018287902018		0.3951210
		 * 		beta=2 0.3933175669611119		0.3951609
		 * 		beta=0.5 0.3925119614511131		0.3956611
		 * 		beta=10 0.3950453882117167	
		 * 
		 * D=23 alpha=0.05 epoch=3 0.38742534644267457 	0.3942676
		 * D = Math.pow(2, 25)+10000000 alpha=0.05 epoch=20	0.36369834038963345	 0.3947959
		 * D = Math.pow(2, 25)+10000000 alpha=0.1 epoch=3	0.38242123175177656	 0.3943070
		 * D = Math.pow(2, 25)+10000000 alpha=0.05 epoch=3	0.3874201979376878	 0.3940986
		 * D = Math.pow(2, 25)+10000000 alpha=0.05 epoch=4  0.3848864718815796	 0.3938000
		 * D = Math.pow(2, 25)+10000000 alpha=0.05 epoch=5  0.3848864718815796	 0.3936916
		 * D = Math.pow(2, 25)+10000000 alpha=0.06 epoch=5  0.3808655819103142	 0.3936893
		 * D = Math.pow(2, 25)+10000000 alpha=0.06 epoch=6  0.37863828647285314	 0.3937676
		 * D = Math.pow(2, 25)+10000000 alpha=0.04 epoch=5  0.38468495197729946	 0.3937630
		 * D = Math.pow(2, 25)+10000000 alpha=0.03 epoch=5  0.38698347886295537	 0.3939697
		 * D = Math.pow(2, 25)+10000000 alpha=0.03 epoch=6  	 				 0.3939212
		 * D = Math.pow(2, 25)+10000000 alpha=0.07 epoch=5  0.3792139554599497	 0.3937277
		 * D = Math.pow(2, 25)+10000000 alpha=0.07 epoch=4  0.38198184805714225	 0.3937906
		 * 
		 * D=25 alpha=0.05 epoch=3 0.38742357423207296	0.3942458
		 * D=25 alpha=0.05 epoch=25 0.3600311174781288	0.3960901
		 */
	}
	
}
