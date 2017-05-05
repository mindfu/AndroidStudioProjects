package util;

import java.text.DecimalFormat;

/**
 * Created by Chris on 5/4/2017.
 */

public class Util {

    public static String formatNumber(int value){
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String formatted = formatter.format(value);

        return formatted;
    }

}
