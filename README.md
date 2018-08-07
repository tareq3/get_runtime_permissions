# get_runtime_permissions
Its a library for getting permissions in android on Runtime
# Dependencies:

### needed repository:
```

        maven { url 'https://jitpack.io' }
```
### needed dependencies:
```
 implementation 'com.github.tareq3:get_runtime_permissions:1.1'
```

 ## Need a member Variable like:
 ```
 Context mContext;
 
 ```
 
  ## Initialize mContext in Oncreate() like: 
  
   ```
   mContext=this;
   
   ```
   

  ### Declare a member variable like:
  ```
  GetRuntimePermission mGetRuntimePermission;
  ```
  
  ## TODO: 4/14/2018    ///Copy the following lines in onclick() or any method for using this class 

```
       mGetRuntimePermission=new GetRuntimePermission(mContext, GetRuntimePermission.TYPE_OF_PERMISSIONS.READ_CONTACTS) {
                    @Override
                    public void setTaskCompleteAction() {
                      //Do the task you want to do right there
                      //just write down your task Once
                      //following lines will be played if user accept the permission and after accepting everytime 
                      ///So don't need to write the same code again after the semicolon
                      
                    }
                };
 ```

 ## TODO: 4/14/2018 Copy the following methdod below of your code this is important
  ```   
      @Override
     public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
         super.onRequestPermissionsResult(requestCode, permissions, grantResults);


         getRuntimePermission.onRequestPermissionsResult(requestCode,permissions,grantResults);


     }
      
  ```
  
  ### TODO: Check permission is Added in Manifest or not
  
  ```
   if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "need_location_permission_message", Toast.LENGTH_LONG).show();
            return;
        }
  
  ```
