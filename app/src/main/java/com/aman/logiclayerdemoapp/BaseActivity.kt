package com.aman.logiclayerdemoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
/*
* Flow of code wrt MainActivity & BaseActivity : after onCreate of Mainactivity super.onCreate(savedInstanceState) gets triggered the code goes to it's parent class & execute repective code part there, then code comes back to MainActivity after infalting the view & code after super.onCreate executes
*
*   MainActivity.onCreate()
*       BaseActivity.onCreate()
*           MainActivity.inflateViewBinding() (called from BaseActivity.onCreate())
*               setContentView(binding.root) in BaseActivity
*                   Return to MainActivity.onCreate()
*
* */
abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateViewBinding()
        setContentView(_binding?.root)

    }
    abstract fun inflateViewBinding(): VB

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}