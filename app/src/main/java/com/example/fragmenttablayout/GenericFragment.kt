package com.example.fragmenttablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class GenericFragment : Fragment() {
    /*
        Так делать нельзя!
        Конструктор не будет вызван при пересоздании фрагмента
        при изменении конфигурации устройства
        Нужно использовать статическую инициализацию
    public GenericFragment(int color, String data)
    {

    }
    */
    private var backgroundColor = 0
    private var title: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? = getArguments()
        if (bundle != null) {
            if (bundle.containsKey(FRAGMENT_COLOR)) {
                backgroundColor = bundle.getInt(FRAGMENT_COLOR)
            }
            if (bundle.containsKey(FRAGMENT_TITLE)) {
                title = bundle.getString(FRAGMENT_TITLE)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_generic, container, false)
        val relative = view.findViewById<View>(R.id.relative) as RelativeLayout
        relative.setBackgroundColor(backgroundColor)
        val text = view.findViewById<View>(R.id.text) as TextView
        text.text = title
        return view
    }

    companion object {
        private const val FRAGMENT_COLOR = "FRAGMENT_COLOR"
        private const val FRAGMENT_TITLE = "FRAGMENT_TITLE"
        fun newInstance(color: Int, data: String?): GenericFragment {
            val fragment = GenericFragment()
            val bundle = Bundle()
            bundle.putInt(FRAGMENT_COLOR, color)
            bundle.putString(FRAGMENT_TITLE, data)
            fragment.setArguments(bundle)
            return fragment
        }
    }
}