import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.plaf.SliderUI;



public class SyncTest {
	
	public static ArrayList<Data> dataList = new ArrayList<Data>();
	static String mMobileNo, mTxtMessage;

	static int index = 0;
	public static void main(String[] args) {
        SyncTest test = new SyncTest();
        test.init();
	}
	
	private void init(){
		for(int i=0; i<5; i++){
			Data data = new Data();
			data.setMobile("918929809991" +i);
			data.setTxtMessage("Hi-Rajesh How-r-u?" + i);
			dataList.add(data);
		}
		
		mMobileNo = dataList.get(index).getMobile();
		mTxtMessage = dataList.get(index).getTxtMessage();
		for(int i=0; i< dataList.size(); i++){
			System.out.println("###############");
			Thread t1 = new Thread(new GetDataRunnable(), "t1");
        	Thread t2 = new Thread(new SendMessageRunnable(), "t2");
        	t2.start();
        	try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	t1.start();
        }
	}

}

class GetDataRunnable implements Runnable{

	
	public void run() {
		if(SyncTest.dataList.size() > SyncTest.index){
			Data data = SyncTest.dataList.get(SyncTest.index);
			SyncTest.mMobileNo = data.getMobile();
			SyncTest.mTxtMessage = data.getTxtMessage();
		}
	}
	
}

class SendMessageRunnable implements Runnable{

	public void run() {
		try {
			System.out.println("Mobile NO " + SyncTest.mMobileNo + "   Text Message " + SyncTest.mTxtMessage);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Current time " + getDate(System.currentTimeMillis(), "dd-MMM-yyyy hh:mm:ss aa"));
		SyncTest.index++;
	}
	
	
	private String getDate(long milliSeconds, String dateFormat) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            String dateString = formatter.format(new Date(milliSeconds));
            return dateString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
	
}

class Data{
	private String mobile;
	private String txtMessage;
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getTxtMessage() {
		return txtMessage;
	}
	
	public void setTxtMessage(String txtMessage) {
		this.txtMessage = txtMessage;
	}
}



