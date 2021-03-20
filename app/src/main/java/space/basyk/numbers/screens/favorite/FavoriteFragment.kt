package space.basyk.numbers.screens.favorite

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import space.basyk.numbers.R
import space.basyk.numbers.databinding.FragmentFavoriteBinding
import space.basyk.numbers.utils.REPOSITORY_ROOM


class FavoriteFragment : Fragment() {

    private var binding: FragmentFavoriteBinding ?= null
    private val mBinding get() = binding!!
    lateinit var viewModel: FavoriteViewModel
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { FavoriteAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        setHasOptionsMenu(true)
        initialization()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
        recyclerView.adapter = null
    }
    private fun initialization() {
        viewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
        recyclerView = mBinding.recNumber
        recyclerView.adapter = adapter
        viewModel.getAllNum.observe(this, {list ->
            val list = list.asReversed()
            adapter.setList(list)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete_menu ->{
                viewModel.deleteAll()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}