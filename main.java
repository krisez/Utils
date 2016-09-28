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
      
		
		 c.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH),30,11,0);
        System.out.println(c.getTime());
        System.out.println(c.get(Calendar.MONTH));
        long a2 = c.getTimeInMillis();
        System.out.println(a2);
        long a3 = a2 - a1;
        System.out.println(a3);
	  
	}
}