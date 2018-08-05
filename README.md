# get_runtime_permissions
Its a library for getting permissions in android on Runtime

 ##Need a member Variable like:
 ```
 Context mContext;
 
 ```
 
  ##Initialize mContext in Oncreate() like: 
  
   ```
   mContext=this;
   
   ```
   

  ### Declare a member variable like: GetRuntimePermission mGetRuntimePermission;

  ##TODO: 4/14/2018    ///Copy the following lines in onclick() or any method for using this class 

```
       mGetRuntimePermission=new GetRuntimePermission(mContext, GetRuntimePermission.TYPE_OF_PERMISSIONS.READ_CONTACTS) {
                    @Override
                    public void setTaskCompleteAction() {
                      //Do the task you want to do right there
                      //write down your task
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
