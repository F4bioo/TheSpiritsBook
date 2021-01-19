package fbo.costa.thespiritsbook.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import fbo.costa.thespiritsbook.R
import fbo.costa.thespiritsbook.data.model.QueAns
import fbo.costa.thespiritsbook.databinding.ListFragmentBinding
import fbo.costa.thespiritsbook.ui.adapter.Adapter
import java.util.*

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModels()
    private var queAnsList = arrayListOf<QueAns>()
    private lateinit var adapter: Adapter

    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModelEvents()
    }

    private fun observeViewModelEvents() {
        setHasOptionsMenu(true)

        viewModel.queAnsListCoroutine()
        viewModel.queAnsListEvent.observe(viewLifecycleOwner) { _queAnsList ->
            queAnsList.clear()
            queAnsList.addAll(_queAnsList)

            adapter = Adapter(_queAnsList) { _queAns ->
                val directions = ListFragmentDirections
                    .actionListFragmentToDetailsFragment(_queAns)
                // Send data to DetailsFragment
                findNavController().navigate(directions)
            }

            binding.apply {
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = adapter
                progress.visibility = View.GONE
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)

        val tempList = arrayListOf<QueAns>()
        val itemSearch = menu.findItem(R.id.action_search)
        val searchView = itemSearch?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!!.isNotEmpty()) {
                    tempList.clear()

                    val query = newText.toLowerCase(Locale.getDefault())
                    queAnsList.forEach { queAns ->
                        val id = queAns.id.toLowerCase(Locale.getDefault())
                        val question = queAns.question.toLowerCase(Locale.getDefault())
                        val answer = queAns.answer.toLowerCase(Locale.getDefault())

                        val contains = id.contains(query) || question.contains(query)
                                || answer.contains(query)
                        if (contains) tempList.add(queAns)
                    }
                    binding.empty.visibility = when {
                        tempList.isEmpty() -> View.VISIBLE
                        else -> View.GONE
                    }
                    adapter.submitList(tempList)
                    binding.recyclerView.scrollToPosition(0)

                } else {
                    binding.empty.visibility = View.GONE
                    adapter.submitList(queAnsList)
                }
                return true
            }
        })
    }
}
