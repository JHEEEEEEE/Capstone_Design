package com.effort.project_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    fun main() {
        setContentView(R.layout.activity_main)
        val close_open: Button = findViewById(R.id.close_open)

        // 초기 설정
        setButtonImage(close_open, R.drawable.window_open)

        close_open.setOnClickListener {
            // 상태 토글
            close_open.isSelected = !close_open.isSelected

            // 버튼이 눌렸을 때 상태에 따라 drawableBottom 이미지 변경
            if (close_open.isSelected) {
                // 눌린 상태 (state_pressed=true)이면 window_open.png로 설정
                setButtonImage(close_open, R.drawable.window_open)
                close_open.text = "open"
            } else {
                // 눌리지 않은 상태 (state_pressed=false)이면 window_close.png로 설정
                setButtonImage(close_open, R.drawable.window_close)
                close_open.text = "close"
            }
        }
    }

    private fun setButtonImage(button: Button, drawableResId: Int) {
        val drawable = resources.getDrawable(drawableResId)
        button.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()

        // 네비게이션 컨트롤러
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        //앱바 설정 객체
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.linkFragment, R.id.settingFragment))

//        setupActionBarWithNavController(navController, appBarConfiguration)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)

        bottomNav.setupWithNavController(navController)
        }
    }