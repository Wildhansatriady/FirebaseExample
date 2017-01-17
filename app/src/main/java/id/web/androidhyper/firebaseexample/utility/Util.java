package id.web.androidhyper.firebaseexample.utility;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by WILDHAN2 on 1/16/2017.
 */

public class Util {
    public static void showToast(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }
}
