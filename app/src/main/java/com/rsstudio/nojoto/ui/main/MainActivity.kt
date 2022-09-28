package com.rsstudio.nojoto.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.databinding.DataBindingUtil
import com.rsstudio.nojoto.R
import com.rsstudio.nojoto.databinding.ActivityMainBinding
import com.rsstudio.nojoto.ui.base.BaseActivity
import com.rsstudio.nojoto.ui.upload.UploadActivity
import com.rsstudio.nojoto.util.Constant
import java.io.File

class MainActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageUri : Uri

    private var logTag: String = "@MainActivity"

    private val contract = registerForActivityResult(ActivityResultContracts.TakePicture()){ successful ->
        Log.d(logTag, ": $imageUri")
        if (successful) {
            val intent = Intent(this, UploadActivity::class.java)
            intent.putExtra(Constant.IMAGE_URI, imageUri)
            startActivity(intent)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //
        initTheme()
        initActions()
        imageUri = createImageUri()!!
    }

    private fun initActions() {
        binding.iBottomNav.rlPhoto.setOnClickListener(this)
    }

    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.light_bluer)
        window.navigationBarColor = resources.getColor(R.color.Goo_Grey_Dark)
    }

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.rlPhoto -> {
               contract.launch(imageUri)
            }
        }
    }

    private fun createImageUri() :Uri? {
      val image = File(applicationContext.filesDir,"camera_photo.png")
      return FileProvider.getUriForFile(applicationContext,
          "com.rsstudio.nojoto.fileProvider",
          image
          )
    }
}