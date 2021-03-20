package space.basyk.numbers.screens.random

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import space.basyk.numbers.R
import space.basyk.numbers.databinding.FragmentRandomBinding
import space.basyk.numbers.models.modelroom.NumModel


class RandomFragment : Fragment() {

    private var binding: FragmentRandomBinding ?= null
    private val mBinding get() = binding!!
    lateinit var viewModel: RandomViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentRandomBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    private fun initialization() {
        viewModel = ViewModelProvider(this).get(RandomViewModel::class.java)
        viewModel.initDatabase {  }
        mBinding.btnRandYear.setOnClickListener {
            viewModel.getRandomYear()
            viewModel.myRandYear.observe(this, {response ->
                mBinding.tvRandomText.text = response.text
                mBinding.tvRandomNum.text = response.number.toString()
            })
        }
        mBinding.btnRandDate.setOnClickListener {
            viewModel.getRandomDate()
            viewModel.myRandDate.observe(this, {response ->
                mBinding.tvRandomText.text = response.text
                mBinding.tvRandomNum.text = response.number.toString()
            })
        }
        mBinding.btnRandNum.setOnClickListener {
            viewModel.getRandomMath()
            viewModel.myRandMath.observe(this, {response ->
                mBinding.tvRandomText.text = response.text
                mBinding.tvRandomNum.text = response.number.toString()
            })
        }
        mBinding.btnRandTrivia.setOnClickListener {
            viewModel.getRandomTrivia()
            viewModel.myRandTrivia.observe(this, {response ->
                mBinding.tvRandomText.text = response.text
                mBinding.tvRandomNum.text = response.number.toString()
            })
        }

        mBinding.saveText.setOnClickListener {
            val desc = mBinding.tvRandomText.text.toString()
            val num = mBinding.tvRandomNum.text.toString()
            viewModel.insert(NumModel(description = desc, number = num)){}
            Snackbar.make(mBinding.constRandom, "Сохранено в избранное!", Snackbar.LENGTH_LONG).setAction("Ok"){}.show()
        }

    }


}