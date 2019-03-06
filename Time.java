import java.util.Calendar;

/**
 * static method about time
 * 
 */
public class Time {
    public static String getTime() {
        String month1 ;
        String minute ;
        String second ;
        String hour  ;
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        month = month + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int h = c.get(Calendar.HOUR_OF_DAY);
        int m = c.get(Calendar.MINUTE);
        int t = c.get(Calendar.SECOND);
        if(h<10){
            hour = "0"+h;
        }
        else
            hour = String.valueOf(h);
        if(month<10) {
            month1 = "0" + month;
        }
        else
            month1 = String.valueOf(month);
        if(m<10){
            minute  = "0" + m;
        }
        else
            minute = String.valueOf(m);
        if(t<10){
            second = "0" + t;
        }
        else
            second = String.valueOf(t);
        String time = year + ""+ month1 + "" + day + "" + hour + "" + minute + "" + second;
        return time;
    }

    /**
     *
     * 与某天相差毫秒数
     * @return
     */
    public static long getMill(int y,int m,int d){
	Calendar c = Calendar.getInstance();
	long now = c.getTimeInMillis();
	c.set(y,m-1,d);
	long u = c.getTimeInMillis();
	return u-now;
    }
}
