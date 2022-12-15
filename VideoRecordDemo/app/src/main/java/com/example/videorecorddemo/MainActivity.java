package com.example.videorecorddemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.hardware.Camera;
import android.hardware.camera2.CameraDevice;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

//    private CameraDevice cameraDevice;
    private MediaRecorder mediaRecorder;
    private Camera camera;

    private Button btnRecord;
    private SurfaceView sfv;
    private SurfaceHolder holder;
    private boolean isRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 권한 확인
        TedPermission.with(this)
                .setPermissionListener(permission)
                .setRationaleMessage("녹화를 위한 권한을 허용해주세요.")
                .setDeniedMessage("권한이 거부되었습니다. 섫정 > 권한에서 허용해주세요.")
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO)
                .check();

        btnRecord = findViewById(R.id.btn_record);


        btnRecord.setOnClickListener(view -> {
            // 예외 방지
            if (isRecord) {
                mediaRecorder.stop();
                mediaRecorder.release();
//                cameraDevice.close();
                camera.lock();
                isRecord = false;
            } else {
                runOnUiThread(() -> {
                    try {
                        Toast.makeText(MainActivity.this, "녹화가 시작되었습니다.", Toast.LENGTH_SHORT).show();
                        mediaRecorder = new MediaRecorder();
                        camera.unlock();
                        mediaRecorder.setCamera(camera);
                        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
                        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                        mediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_720P));
                        mediaRecorder.setOrientationHint(90); // 90도로 촬영 각도 맞추기
                        mediaRecorder.setOutputFile("/sdcard/test.mp4");
                        mediaRecorder.setPreviewDisplay(holder.getSurface());
                        mediaRecorder.prepare();
                        mediaRecorder.start();
                        isRecord = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        mediaRecorder.release();
                    }
                });
            }
        });



    }

    // 권한 확인 여부에 따른 팝업메시지 띄우기
    PermissionListener permission = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(getApplicationContext(), "권한 허용", Toast.LENGTH_SHORT).show();
            camera = Camera.open();
            camera.setDisplayOrientation(90);
            sfv = findViewById(R.id.sfv);
            holder = sfv.getHolder();
            holder.addCallback(MainActivity.this);
            holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }

        @Override
        public void onPermissionDenied(List<String> deniedPermissions) {
            Toast.makeText(getApplicationContext(), "권한 거부", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

    }

    private void refreshCamera(Camera camera) {
        if (holder.getSurface() == null) {
            return;
        }

        try {
            camera.stopPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }

        setCamera(camera);

    }

    private void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        refreshCamera(camera);
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }
}