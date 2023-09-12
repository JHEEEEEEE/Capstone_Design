package com.effort.project_application

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private fun setButtonImage(button: Button, drawableResId: Int) {
        val drawable = resources.getDrawable(drawableResId)
        button.setCompoundDrawablesWithIntrinsicBounds(null, null, null, drawable)
    }

   

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val close_open: Button = view.findViewById(R.id.close_open)

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

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}