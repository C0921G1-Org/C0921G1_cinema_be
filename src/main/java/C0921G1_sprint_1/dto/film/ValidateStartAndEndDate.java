package C0921G1_sprint_1.dto.film;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateStartAndEndDate {

    public static Boolean checkNgay(String startDate, String endDate) {
        boolean flag;
        Date ngayChieu = null;
        Date ngayKetThuc = null;

        try {
            ngayChieu = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            ngayKetThuc = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        } catch (ParseException e) {
            flag = false;
        }
        if (ngayChieu.compareTo(ngayKetThuc) > 0) {
            flag = false;
        } else if (ngayChieu.compareTo(ngayKetThuc) < 0) {
            flag = true;
        } else {
            flag = true;
        }
        return flag;
    }


}
