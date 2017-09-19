package com.example.hardik.doorslash.utils;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.example.hardik.doorslash.R;

public class Commons {
    public static final String FAVORITE = "fav";

    /**
     * Checks network connection and returns true if available.
     *
     * @param context application context
     * @return boolean  returns true if network is available.
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     * Method displays the Toast with message
     *
     * @param context application context
     * @param text    text to display as toast.
     */
    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public static boolean checkLocationPermission(Context context) {
        int permissionCheck = ContextCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    public static ProgressDialog createProgressDialog(Context context) {
        ProgressDialog mProgressDialog = new ProgressDialog(context, ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage(context.getString(R.string.progress_text));
        return mProgressDialog;
    }


    public static void showAlertMessage(Context context, String message, boolean singleBtnDialog
            , final String positiveText
            , final DialogInterface.OnClickListener onPositiveClick
            , final DialogInterface.OnClickListener onNagativeClick) {

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.app_name));
        builder.setMessage(message);
        builder.setCancelable(false);
        if (!singleBtnDialog) {
            builder.setNegativeButton(context.getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // if this button is clicked, close
                    dialog.cancel();
                    onNagativeClick.onClick(dialog, id);
                }
            });
        }

        builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // if this button is clicked, close
                dialog.cancel();
                onPositiveClick.onClick(dialog, id);
            }
        });
        builder.show();
    }
}
