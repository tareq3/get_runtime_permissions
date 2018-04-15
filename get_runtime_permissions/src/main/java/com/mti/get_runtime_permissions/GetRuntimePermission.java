package com.mti.get_runtime_permissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;


public abstract class GetRuntimePermission {
    // TODO: 4/14/2018    ///Copy the following lines in onclick() or any method for using this class ///
/*
       mGetRuntimePermission=new GetRuntimePermission(mContext, GetRuntimePermission.TYPE_OF_PERMISSIONS.READ_CONTACTS) {
                    @Override
                    public void setTaskCompleteAction() {

                      //Do the task you want to do right there
                      //write down your task
                    }
                };
 */

// TODO: 4/14/2018 Copy the following methdod below of your code this is important
    /*
     @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        getRuntimePermission.onRequestPermissionsResult(requestCode,permissions,grantResults);


    }
     */

// TODO: 4/14/2018 For adding a new permission Request in this class
    /*
        1. First declare the permissionRequest in Manifest: <uses-permission android:name="android.permission.SEND_SMS"/>

        2.Add new Constant  Request code :  private static final int SEND_SMS_CODE = 25;

        3.Add new Request in enum :TYPE_OF_PERMISSIONS { SEND_SMS}

        4. Add new Switch case in isPermissionAllowed:  case SEND_SMS:

             case SEND_SMS:
                //Getting the permission status
                int result3 = ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS);

                //If permission is granted returning true
                if (result3 == PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;

         5. create a new method :

               public void requestSMSPermission() {
                     if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.SEND_SMS)) {
                      //If the user has denied the permission previously your code will come to this block
                         //Here you can explain why you need this permission
                              //Explain here why you need this permission
                       }
                       //And finally ask for the permission
                       ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_CODE);
                  }

          6.  Add a switch case in onRequestPermissionResult method:
               case SEND_SMS_CODE:
                     //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;
     */

  public   enum TYPE_OF_PERMISSIONS {READ_EXTERNAL_STORAGE, READ_CONTACTS, SEND_SMS,CAMERA,RECORD_AUDIO,ACCESS_FINE_LOCATION,CALL_PHONE,CALENDER}

    // TODO: 4/14/2018 CONSTANTS and Request Codes right below
    private static final int STORAGE_PERMISSION_CODE = 23;
    private static final int READ_CONTACTS_CODE = 24;
    private static final int SEND_SMS_CODE = 25;
    private static final int CAMERA_CODE=26;
    private static final int RECORD_AUDIO_CODE=27;
    private static final int ACCESS_FINE_LOCATION_CODE=28;
    private static final int CALL_PHONE_CODE=29;
    private static final  int CALENDER_CODE=30;

    public static Context context;


    public GetRuntimePermission(Context context,TYPE_OF_PERMISSIONS type_of_permissions) {

        GetRuntimePermission.context = context;

        switch (type_of_permissions) {
            case READ_EXTERNAL_STORAGE:
            //First checking if the app is already having the permission
            if (isPermissionAllowed(TYPE_OF_PERMISSIONS.READ_EXTERNAL_STORAGE)) {
                //If permission is already having then showing the toast
                setTaskCompleteAction();
            } else {
                //If the app has not the permission then asking for the permission
                requestStoragePermission();
            }
            break;
            case READ_CONTACTS:
                //First checking if the app is already having the permission
                if (isPermissionAllowed(TYPE_OF_PERMISSIONS.READ_CONTACTS)) {
                    //If permission is already having then showing the toast
                    setTaskCompleteAction();
                } else {
                    //If the app has not the permission then asking for the permission
                    requestContactPermission();
                }
                break;
            case SEND_SMS:
                //First checking if the app is already having the permission
                if (isPermissionAllowed(TYPE_OF_PERMISSIONS.SEND_SMS)) {
                    //If permission is already having then showing the toast
                    setTaskCompleteAction();
                } else {
                    //If the app has not the permission then asking for the permission
                   requestSMSPermission();
                }
                break;
            case CAMERA:
                //First checking if the app is already having the permission
                if (isPermissionAllowed(TYPE_OF_PERMISSIONS.CAMERA)) {
                    //If permission is already having then showing the toast
                    setTaskCompleteAction();
                } else {
                    //If the app has not the permission then asking for the permission
                    requestCameraPermission();
                }
                break;
            case RECORD_AUDIO:
                //First checking if the app is already having the permission
                if (isPermissionAllowed(TYPE_OF_PERMISSIONS.RECORD_AUDIO)) {
                    //If permission is already having then showing the toast
                    setTaskCompleteAction();
                } else {
                    //If the app has not the permission then asking for the permission
                    requestMicrophonePermission();
                }
                break;

            case ACCESS_FINE_LOCATION:
                //First checking if the app is already having the permission
                if (isPermissionAllowed(TYPE_OF_PERMISSIONS.ACCESS_FINE_LOCATION)) {
                    //If permission is already having then showing the toast
                    setTaskCompleteAction();
                } else {
                    //If the app has not the permission then asking for the permission
                    requestLocationPermission();
                }
                break;

            case CALL_PHONE:
                //First checking if the app is already having the permission
                if (isPermissionAllowed(TYPE_OF_PERMISSIONS.CALL_PHONE)) {
                    //If permission is already having then showing the toast
                    setTaskCompleteAction();
                } else {
                    //If the app has not the permission then asking for the permission
                    requestCallPhonePermission();
                }
                break;
            case CALENDER:
                //First checking if the app is already having the permission
                if (isPermissionAllowed(TYPE_OF_PERMISSIONS.CALENDER)) {
                    //If permission is already having then showing the toast
                    setTaskCompleteAction();
                } else {
                    //If the app has not the permission then asking for the permission
                    requestCalenderPermission();
                }
                break;

        }
    }


    //We are calling this method to check the permission status
    private boolean isPermissionAllowed(TYPE_OF_PERMISSIONS permissions) {
        switch (permissions) {
            case READ_EXTERNAL_STORAGE:
                //Getting the permission status
                int resultStorage = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);

                //If permission is granted returning true
                if (resultStorage == PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;

            case READ_CONTACTS:
                //Getting the permission status
                int resultContact = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CONTACTS);

                //If permission is granted returning true
                if (resultContact == PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;
            case SEND_SMS:
                //Getting the permission status
                int resultSms = ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS);

                //If permission is granted returning true
                if (resultSms == PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;
            case CAMERA:
                //Getting the permission status
                int resultCamera = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA);

                //If permission is granted returning true
                if (resultCamera == PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;

            case RECORD_AUDIO:
                //Getting the permission status
                int resultMicrophone = ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO);

                //If permission is granted returning true
                if (resultMicrophone == PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;
            case ACCESS_FINE_LOCATION:
                //Getting the permission status
                int resultLocation = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION);

                //If permission is granted returning true
                if (resultLocation == PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;
            case CALL_PHONE:
                //Getting the permission status
                int resultPhone = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE);

                //If permission is granted returning true
                if (resultPhone == PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;

            case CALENDER:
                //Getting the permission status
                int resultCalender = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALENDAR);

                int resultCalender_wr= ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR);

                //If permission is granted returning true
                if (resultCalender == PackageManager.PERMISSION_GRANTED && resultCalender_wr==PackageManager.PERMISSION_GRANTED)
                    return true;

                //If permission is not granted returning false
                return false;
        }
        return false;
    }

    //Requesting permission
    private void requestCalenderPermission() {

        if(ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_CALENDAR) &&ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.WRITE_CALENDAR) ) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_CALENDAR,Manifest.permission.WRITE_CALENDAR},
                CALENDER_CODE);

    }

    //Requesting permission
    private void requestCallPhonePermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.CALL_PHONE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE},
                CALL_PHONE_CODE);
    }


    //Requesting permission
    private void requestLocationPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.ACCESS_FINE_LOCATION)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                ACCESS_FINE_LOCATION_CODE);
    }


    //Requesting permission
    private void requestMicrophonePermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.RECORD_AUDIO)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.RECORD_AUDIO},
                RECORD_AUDIO_CODE);
    }



    //Requesting permission
    private void requestCameraPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.CAMERA)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CAMERA},
                CAMERA_CODE);
    }


    //Requesting permission
    private void requestSMSPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.SEND_SMS)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.SEND_SMS},
                SEND_SMS_CODE);
    }


    //Requesting permission
    private void requestStoragePermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                STORAGE_PERMISSION_CODE);
    }

    //request Permission
    private void requestContactPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_CONTACTS)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_CONTACTS}
                , READ_CONTACTS_CODE);

    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        switch (requestCode) {

            case STORAGE_PERMISSION_CODE:

                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
                    setTaskCompleteAction();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;

            case READ_CONTACTS_CODE:
                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can read the Contact", Toast.LENGTH_LONG).show();

                        setTaskCompleteAction();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;
            case SEND_SMS_CODE:
                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can Send the sms", Toast.LENGTH_LONG).show();
                    setTaskCompleteAction();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;

            case CAMERA_CODE:
                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can Use the Camera", Toast.LENGTH_LONG).show();
                    setTaskCompleteAction();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;
            case RECORD_AUDIO_CODE:

                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can Use the Microphone", Toast.LENGTH_LONG).show();
                    setTaskCompleteAction();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;

            case ACCESS_FINE_LOCATION_CODE:
                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can Use the Location", Toast.LENGTH_LONG).show();
                    setTaskCompleteAction();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;
            case CALL_PHONE_CODE:
                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can Use the Phone", Toast.LENGTH_LONG).show();
                    setTaskCompleteAction();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;
            case CALENDER_CODE:
                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //Displaying a toast
                    Toast.makeText(context, "Permission granted now you can Use the Calender", Toast.LENGTH_LONG).show();
                    setTaskCompleteAction();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(context, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


   public  abstract void setTaskCompleteAction();


}
