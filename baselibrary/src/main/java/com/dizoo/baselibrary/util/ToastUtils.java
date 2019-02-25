package com.dizoo.baselibrary.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    private static Toast sToast;

    public static void show(Context context, String msg){
        if (sToast == null){
            sToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        }else {
            sToast.setText(msg);
        }
        sToast.show();
    }
}
