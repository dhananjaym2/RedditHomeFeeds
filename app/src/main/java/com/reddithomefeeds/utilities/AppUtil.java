package com.reddithomefeeds.utilities;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.reddithomefeeds.R;
import com.reddithomefeeds.interfaces.AlertDialog_OnClickInterface;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Dhananjay Mohnot on 4/13/2016.
 */
public class AppUtil {
    private static final String LOG_TAG = AppUtil.class.getSimpleName();

    public static void showToast(Context context, String strToastMessage, boolean isShownLong) {
        if (isShownLong)
            Toast.makeText(context, strToastMessage, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, strToastMessage, Toast.LENGTH_SHORT).show();
    }

    public static void showAlertDialogWith1Button(Context context, String messageToShowOnAlert, final AlertDialog_OnClickInterface
            mAlertDialog_OnClickListener, String buttonText, final String strTAG, boolean isCancellable) {

        if (context == null) {
            return;
        }
        AlertDialog.Builder alertDialog_builder = new AlertDialog.Builder(context);
        alertDialog_builder.setCancelable(isCancellable);
        alertDialog_builder.setMessage(messageToShowOnAlert);

        if (buttonText == null) {
            buttonText = context.getString(android.R.string.ok);
        }
        final String finalButtonText = buttonText;

        alertDialog_builder.setPositiveButton(buttonText, new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (mAlertDialog_OnClickListener != null && strTAG != null) {
                            mAlertDialog_OnClickListener.onAlertDialogButtonClicked(
                                    finalButtonText, strTAG);
                        }
                    }
                });
        alertDialog_builder.show();
    }

    public static void showAlertDialogWith_TwoButtons(Context context, String messageToShowOnAlert, final AlertDialog_OnClickInterface
            mAlertDialog_OnClickListener, String positiveButtonText, String negativeButtonText, final String strTAG, boolean isCancellable) {

        if (context == null) {
            return;
        }
        AlertDialog.Builder alertDialog_builder = new AlertDialog.Builder(context);
        alertDialog_builder.setCancelable(isCancellable);
        alertDialog_builder.setMessage(messageToShowOnAlert);

        if (positiveButtonText == null) {
            positiveButtonText = context.getString(android.R.string.ok);
        }
        final String finalPositiveButtonText = positiveButtonText;
        alertDialog_builder.setPositiveButton(positiveButtonText, new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (mAlertDialog_OnClickListener != null && strTAG != null) {
                            mAlertDialog_OnClickListener.onAlertDialogButtonClicked(
                                    finalPositiveButtonText, strTAG);
                        }
                    }
                });

        if (negativeButtonText == null) {
            negativeButtonText = context.getString(android.R.string.cancel);
        }
        final String finalNegativeButtonText = negativeButtonText;
        alertDialog_builder.setNegativeButton(negativeButtonText, new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (mAlertDialog_OnClickListener != null && strTAG != null) {
                            mAlertDialog_OnClickListener.onAlertDialogButtonClicked(
                                    finalNegativeButtonText, strTAG);
                        }
                    }
                });

        alertDialog_builder.show();
    }

    public static ProgressDialog showProgressDialog(Context context, String msgOnProgressDialog, boolean isCancellable) {
        ProgressDialog progressDialog = null;
        if (context != null) {
            progressDialog = new ProgressDialog(context);

            if (msgOnProgressDialog == null)
                msgOnProgressDialog = context.getString(R.string.LoadingFeeds);

            progressDialog.setMessage(msgOnProgressDialog);
            progressDialog.setCancelable(isCancellable);
            progressDialog.show();
        }
        return progressDialog;
    }

    /**
     * method to check if internet is connected or not
     *
     * @param mContext Context
     * @return true if connected else false
     */
    public static boolean isInternetAvailable(Context mContext) {

        ConnectivityManager cm = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiNetwork = cm
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetwork != null && wifiNetwork.isConnected()) {
            return true;
        }

        NetworkInfo mobileNetwork = cm
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mobileNetwork != null && mobileNetwork.isConnected()) {
            return true;
        }

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        //activeNetwork.getType() == ConnectivityManager.TYPE_WIFI
        if (activeNetwork != null && activeNetwork.isConnected()) {
            return true;
        }

        return false;
    }

    public static void openFragmentByReplacing(FragmentActivity fragmentActivity, int frameLayoutId,
                                               Fragment mFragment, String strTagForBackStack,
                                               Bundle mBundleArguments) {

        if (mBundleArguments != null) {
            mFragment.setArguments(mBundleArguments);
        }

        AppLog.v(LOG_TAG, "in openFragmentByReplacing() before replacing new mFragment with strTagForBackStack:"
                + strTagForBackStack + " backStackEntryCount:" + fragmentActivity.
                getSupportFragmentManager().getBackStackEntryCount());

        try {
            fragmentActivity.getSupportFragmentManager().beginTransaction()
                    .replace(frameLayoutId, mFragment)
                    .addToBackStack(strTagForBackStack)
                    .commit();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public static void setTypeFaceForTextView_abeatbykai(Context context, TextView textView_toSetTypeFace) {
        if (context != null) {
            if (textView_toSetTypeFace != null) {

                textView_toSetTypeFace.setTypeface(Typeface.createFromAsset(context.getAssets(),
                        "fonts/abeatbykai_regular_font.otf"));
            } else
                AppLog.e(LOG_TAG, "mTextView null in setTypeFaceForTextView_abeatbykai()");
        } else
            AppLog.e(LOG_TAG, "context null in setTypeFaceForTextView_abeatbykai()");
    }

    /**
     * check if Camera Permission is available to the app then returns camera Intent object
     *
     * @param activity
     * @param cameraPermissionIntentRequestCode
     * @return if permission is available then returns camera Intent object
     */
    public static Intent checkCameraPermission(Activity activity, int cameraPermissionIntentRequestCode) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(activity.getPackageManager()) != null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_GRANTED) {

                    return takePictureIntent;

                } else {

                    if (activity.shouldShowRequestPermissionRationale(Manifest.permission.
                            CAMERA)) {
                        AppUtil.showToast(activity, "No Permission to use the Camera services", true);
                    }

                    activity.requestPermissions(new String[]{Manifest.permission.CAMERA},
                            cameraPermissionIntentRequestCode);
                }

            } else {
                return takePictureIntent;

            }
        } else {
            AppUtil.showAlertDialogWith1Button(activity, activity.getString(R.string.
                    YourDeviceDoesntHaveASupportedCameraApp), null, null, LOG_TAG, false);
        }

        return null;
    }

    /**
     * Hide Soft Keyboard
     *
     * @param activity
     */
    public static void hideSoftKeyboard(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(
                    Activity.INPUT_METHOD_SERVICE);
            View focusView = activity.getCurrentFocus();
            if (focusView != null) {
                inputMethodManager.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
            }
        }
    }


    public static String saveBitmapOfImageToFile(Context context/*, String imageFileName*/, Bitmap bitmapToSaveToFile) throws IOException {
        FileOutputStream out = null;
        String imageFileName = getANewImageFileName(context);
        try {
            out = new FileOutputStream(imageFileName);
            if (bitmapToSaveToFile.compress(Bitmap.CompressFormat.PNG, 100, out)) {
                return imageFileName;
            }
            // PNG is a lossless format, the compression factor (100) is ignored
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return imageFileName;
    }

    private static String getANewImageFileName(Context context) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
//mCurrentPhotoPath:/storage/emulated/0/Android/data/trustid.interviewapp/files/Pictures/JPEG_20160727_223710_-1435487978.jpg
        return String.valueOf(image);
    }

    /**
     * convert image bitmap to String to be sent to API
     *
     * @param image
     * @return
     */
    public static String encodeImageBitmapToBase64String(Bitmap image) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 90, baos);
        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

    public static String getDeviceID(Context context) {

        String deviceId = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        return deviceId != null ? deviceId : "";
    }

    public static boolean checkAndRequestLocationPermissions(Activity mActivity, int locationPermissionRequestCode) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_COARSE_LOCATION) ==
                    PackageManager.PERMISSION_GRANTED) {

                AppLog.v(LOG_TAG, "ACCESS_COARSE_LOCATION PERMISSION_GRANTED");

                if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {

                    AppLog.v(LOG_TAG, "ACCESS_FINE_LOCATION PERMISSION_GRANTED");
                    return true;

                } else {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {
                        showToast(mActivity, mActivity.getString(R.string.
                                This_app_needs_access_to_location_permissions_to_provide_you_information), true);
                    } else {
                        AppLog.v(LOG_TAG, "shouldShowRequestPermissionRationale() returns false");
                    }
                    ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.
                            ACCESS_FINE_LOCATION}, locationPermissionRequestCode);
                }
            } else {
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.
                        ACCESS_COARSE_LOCATION}, locationPermissionRequestCode);
            }
        } else {
            /**
             * permissions explicitly not required for devices below API 23
             */
            return true;
        }
        return false;
    }

    public static void dismissProgressDialog(ProgressDialog progressDialog) {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.dismiss();
    }

    public static int getColorAccordingToAndroidVersion(Context context, int idOfColor) {
        if (context != null) {
            if (Build.VERSION.SDK_INT >= 23)
                return context.getResources().getColor(idOfColor, null);
            else
                return context.getResources().getColor(idOfColor);
        } else
            return 0;
    }

    public static String getFormattedDate(Long dateTimeInMilliseconds, String dateTimeFormat) {

        if (dateTimeFormat != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTimeFormat, Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(dateTimeInMilliseconds);
            return simpleDateFormat.format(calendar.getTime());
        } else {
            AppLog.e(LOG_TAG, "dateTimeFormat is null in getFormattedDate()");
            return null;
        }
    }

    public static void openURLLinkInBrowserIntent(Context context, String strURL_linkToOpenInBrowser) {

        if (!strURL_linkToOpenInBrowser.startsWith("http://") && !strURL_linkToOpenInBrowser.startsWith("https://"))
            strURL_linkToOpenInBrowser = "http://" + strURL_linkToOpenInBrowser;

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(strURL_linkToOpenInBrowser));

        try {
            context.startActivity(browserIntent);
        } catch (ActivityNotFoundException ex) {
            showAlertDialogWith1Button(context, context.getString(R.string.
                            CannotFindAnyWebBrowserApplicationToOpenLinkYouCanVisitThisLinkFromADeviceWithSupportedWebBrowser,
                    strURL_linkToOpenInBrowser), null, null, LOG_TAG, true);
        }

    }
}