/**
*±àÐ´½á¹û¼ÆËã
*/
import java.util.Calendar;
class main{
	public static void main(String args[]){
	   Calendar c = Calendar.getInstance();
        c.getTime();
        Date date = c.getTime();
        System.out.println(c.getTimeInMillis());
        c.set(Calendar.YEAR,Calendar.SEPTEMBER+1,Calendar.DATE,Calendar.HOUR_OF_DAY, Calendar.MINUTE);
        System.out.println(c.getTimeInMillis());
	  
	}
}