package br.com.placesnap.controller.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import br.com.placesnap.R;
import br.com.placesnap.controller.view.CameraPreview;

public class PhotoActivity extends AppCompatActivity {

    @SuppressWarnings("deprecation")
    private Camera mCamera;
    private CameraPreview mPreview;
    private ImageView mImageViewPhoto, mImageViewRotateCamera, mImageViewFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        this.bindViews();
    }

    @Override
    protected void onResume() {
        // Create an instance of Camera
        super.onResume();
        mCamera = getCameraInstance();

        // Create our Preview view and set it as the content of our activity.
        if (mCamera != null) {
            mPreview = new CameraPreview(this, mCamera);
            FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
            preview.addView(mPreview);
        }
    }

    @Override
    protected void onPause() {
        if (mCamera != null) {
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;
        }

        super.onPause();
    }

    private void bindViews() {
        mImageViewPhoto = (ImageView) findViewById(R.id.imageview_camera_photo);
        mImageViewFlash = (ImageView) findViewById(R.id.imageview_camera_flash);
        mImageViewRotateCamera = (ImageView) findViewById(R.id.imageview_camera_rotate);
    }

    private boolean checkCameraHardware(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    @SuppressWarnings("deprecation")
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
}
