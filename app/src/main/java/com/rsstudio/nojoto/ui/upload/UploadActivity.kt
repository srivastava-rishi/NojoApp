package com.rsstudio.nojoto.ui.upload


import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.rsstudio.nojoto.R
import com.rsstudio.nojoto.databinding.ActivityUploadBinding
import com.rsstudio.nojoto.ui.base.BaseActivity
import com.rsstudio.nojoto.util.Constant

class UploadActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUploadBinding
    private lateinit var imageUri : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_upload)

        //
        initData()
        initTheme()
        initActions()
        initView()
    }

    private fun initData() {
        imageUri = intent.getParcelableExtra(Constant.IMAGE_URI)!!
    }


    private fun initActions(){
        binding.iAppBar.ivHamburger.setOnClickListener(this)
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

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.ivHamburger -> {
              finish()
            }
        }
    }
}