package cz.koubicl.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import cz.koubicl.example.R
import cz.koubicl.example.common.CommonKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeKoin()

        setContentView(R.layout.main_activity)
        navController = findNavController(this, R.id.nav_host_fragment)
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(application)
            module {  }
        }

        CommonKoinModule.start()
        UiKoinModule.start()
    }
}