package leetcodes.easy;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年07月04日 21:40
 */
public class 日期之间隔几天 {

    public int daysBetweenDates(String date1, String date2) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date from = sdf.parse(date1);
        Date to = sdf.parse(date2);

        long difference = (from.getTime() - to.getTime());
        int res = (int) (difference/(3600*24*1000));

        return Math.abs(res);
    }

    @Test
    public void Run() throws ParseException {
        System.out.println(daysBetweenDates("2019-06-29", "2019-06-30"));
    }
}
