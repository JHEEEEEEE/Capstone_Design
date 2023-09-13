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
 * Use the [LinkFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LinkFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private var isClicked = false // 버튼 클릭 상태를 추적하는 변수
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_link, container, false)
        val myButton = view.findViewById<Button>(R.id.bt_connect)
        val myButton2 = view.findViewById<Button>(R.id.bt_unconnect)
        val bt1 = view.findViewById<Button>(R.id.button1)
        val bt2 = view.findViewById<Button>(R.id.button2)
        val bt3 = view.findViewById<Button>(R.id.button3)

        myButton.setOnClickListener {
            // 클릭 이벤트 처리
            // 원하는 작업을 수행
            bt1.text = "연동중"
            bt2.text = "연동중"
            bt3.text = "연동중"
        }

        myButton2.setOnClickListener {
            // 클릭 이벤트 처리
            // 원하는 작업을 수행
            bt1.text = "미연동"
            bt2.text = "미연동"
            bt3.text = "미연동"
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
         * @return A new instance of fragment LinkFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LinkFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}