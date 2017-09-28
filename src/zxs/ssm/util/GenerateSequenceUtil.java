package zxs.ssm.util;

public class GenerateSequenceUtil {
	public static String generateBidId() {
		long now = System.currentTimeMillis();//一个13位的时间戳
    	int r1 = (int)(Math.random()*9+1);
    	int r2 = (int)(Math.random()*9+1);
    	String bidId = String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);
    	//休眠1毫秒
    	try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return bidId;
	} 
}
