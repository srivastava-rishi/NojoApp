package com.rsstudio.nojoto.ui.upload


import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.rsstudio.nojoto.R
import com.rsstudio.nojoto.data.network.model.Data
import com.rsstudio.nojoto.databinding.ActivityUploadBinding
import com.rsstudio.nojoto.ui.base.BaseActivity
import com.rsstudio.nojoto.ui.upload.viewModel.UploadViewModel
import com.rsstudio.nojoto.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class UploadActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUploadBinding
    private lateinit var imageUri : Uri
    private var logTag: String = "@uploadActivity"

    private val viewModel: UploadViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_upload)

        //
        initData()
        initTheme()
        initActions()
        initView()
        initObservers()
    }

    private fun initData() {
        imageUri = intent.getParcelableExtra(Constant.IMAGE_URI)!!
    }


    private fun initActions(){
        binding.iAppBar.ivHamburger.setOnClickListener(this)
        binding.llUploadButton.setOnClickListener(this)
    }

    private fun initView() {
        binding.iAppBar.ivHamburger.setImageResource(R.drawable.left)
        binding.iAppBar.tvTitle.text = "Upload Photo Screen"
        binding.rivPostImage.setImageURI(imageUri)
    }


    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.light_bluer)
        window.navigationBarColor = resources.getColor(R.color.Goo_Grey_Dark)
    }

    private fun initObservers() {

        viewModel.postData.observe(this) {

            if (it.isSuccessful) {
                finish()
            }
            else {
                Log.d(logTag, "initObservers: " + "OkEND...")
            }
        }
    }



    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.ivHamburger -> {
              finish()
            }
            R.id.llUploadButton -> {
             var data = Data("media" ,imageUri.toString())
             viewModel.saveData(data)
            }
        }
    }
}