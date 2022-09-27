package com.rsstudio.nojoto.ui.main


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.rsstudio.nojoto.R
import com.rsstudio.nojoto.databinding.ActivityMainBinding
import com.rsstudio.nojoto.ui.base.BaseActivity
import com.rsstudio.nojoto.ui.upload.UploadActivity

class MainActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //
        initTheme()
        initActions()
    }

    private fun initActions(){
        binding.iBottomNav.rlPhoto.setOnClickListener(this)
    }

    private fun initTheme() {
        window.statusBarColor = resources.getColor(R.color.light_bluer)
        window.navigationBarColor = resources.getColor(R.color.Goo_Grey_Dark)
    }

    override fun onClick(view: View?) {

        when (view?.id) {
          R.id.rlPhoto ->{
              val intent = Intent(this, UploadActivity::class.java)
              startActivity(intent)
          }
        }
    }


}