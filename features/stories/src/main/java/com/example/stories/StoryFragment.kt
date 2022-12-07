package com.example.stories

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.data.StoriesRepository
import com.example.database.DatabaseDriverFactory
import com.example.database.StoriesLocalRepository
import com.example.intermediatedatalayer.IntermediateStoriesDataSource
import com.example.network.NetworkStoriesRepository
import com.example.usecases.GetAllStories

/**
 * A fragment representing a list of Items.
 */
class StoryFragment : Fragment() {

    private var columnCount = 1
    private lateinit var storiesViewModel: StoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        storiesViewModel = StoriesViewModel(
            GetAllStories(
                StoriesRepository(
                    NetworkStoriesRepository,
                    StoriesLocalRepository(DatabaseDriverFactory(requireActivity().applicationContext))
                )
            )
        )
        // Set the adapter
        val adapter = StoryRecyclerViewAdapter(emptyList())
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                view.adapter = adapter
            }
        }
        storiesViewModel.getAllStories()
        lifecycleScope.launchWhenStarted {
            storiesViewModel.storiesFlow.collect {
                adapter.updateAdapter(it)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            StoryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}