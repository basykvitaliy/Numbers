package space.basyk.numbers.screens.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import space.basyk.numbers.databinding.FragmentFirstBinding
import space.basyk.numbers.models.modelroom.NumModel


class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding ?= null
    private val mBinding get() = binding!!
    lateinit var viewModel: FirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
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
        viewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        mBinding.materialButton.setOnClickListener {
            val num = mBinding.tvNumber.text.toString().toInt()
            viewModel.getNumber(num)
            viewModel.myNumber.observe(this, {number ->
                mBinding.tvNumberText.text = number.text
                mBinding.tvNumberNum.text = number.number.toString()

            })
            mBinding.saveText.setOnClickListener {
                val desc = mBinding.tvNumberText.text.toString()
                val num = mBinding.tvNumberNum.text.toString()
                viewModel.insert(NumModel(description = desc, number = num)){}
                Snackbar.make(mBinding.constLayout, "Сохранено в избранное!", Snackbar.LENGTH_LONG).setAction("Ok"){}.show()
            }
        }
    }

}