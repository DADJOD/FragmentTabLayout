package com.example.fragmenttablayout.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmenttablayout.R

class GenericFragment : Fragment() {
    private var backgroundColor = 0
    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            backgroundColor = it.getInt(ARG_COLOR)
            title = it.getString(ARG_TITLE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_generic, container, false)
        view.setBackgroundColor(backgroundColor)
        view.findViewById<TextView>(R.id.text).text = title
        return view
    }

    companion object {
        private const val ARG_COLOR = "ARG_COLOR"
        private const val ARG_TITLE = "ARG_TITLE"

        fun newInstance(color: Int, title: String): GenericFragment {
            return GenericFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLOR, color)
                    putString(ARG_TITLE, title)
                }
            }
        }
    }
}