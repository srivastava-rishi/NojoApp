package com.rsstudio.nojoto.ui.splash

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.rsstudio.nojoto.R
import com.rsstudio.nojoto.databinding.ActivitySplashBinding
import com.rsstudio.nojoto.ui.base.BaseActivity
import com.rsstudio.nojoto.ui.main.MainActivity
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog

class SplashActivity : BaseActivity(), EasyPermissions.PermissionCallbacks {

    companion object {
        const val PERMISSION_CAMERA_REQUEST_CODE = 1
    }

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        //
        if (hasCameraPermission()) {
            gotoMainActivity()
        } else {
            requestCameraPermission()
        }
    }
    private fun gotoMainActivity() {
        Handler(Looper.getMainLooper()).postDelayed(
            Runnable {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 500
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    private fun hasCameraPermission() =
        EasyPermissions.hasPermissions(
            this,
            Manifest.permission.CAMERA
        )

    private fun requestCameraPermission() {
        EasyPermissions.requestPermissions(
            this,
            "This application cannot work without Camera Permission.",
            PERMISSION_CAMERA_REQUEST_CODE,
            Manifest.permission.CAMERA
        )
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            SettingsDialog.Builder(this).build().show()
        } else {
            requestCameraPermission()
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        //
        gotoMainActivity()
    }


}