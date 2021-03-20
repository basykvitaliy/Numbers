package space.basyk.numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import space.basyk.numbers.data.roomrepository.NumDatabaseRepository
import space.basyk.numbers.databinding.ActivityMainBinding
import space.basyk.numbers.repositories.RpositoryRetrofit
import space.basyk.numbers.utils.APP_ACTIVITY
import space.basyk.numbers.utils.REPOSITORY
import space.basyk.numbers.utils.REPOSITORY_ROOM

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding ?= null
    private val mBinding get() = binding!!
    lateinit var navController: NavController
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        APP_ACTIVITY = this
        REPOSITORY = RpositoryRetrofit()
        navController = Navigation.findNavController(this, R.id.nav_host)
        bottomNavigationView = mBinding.bottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}