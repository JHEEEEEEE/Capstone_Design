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

    private fun setToggleButton(button: Button, onText: String, offText: String, onClick: () -> Unit) {
        button.setOnClickListener {
            // 상태 토글
            button.isSelected = !button.isSelected
            // 버튼 텍스트 설정
            button.text = if (button.isSelected) onText else offText
            // onClick 콜백 호출
            onClick()
        }
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
        val window_openclose: Button = view.findViewById(R.id.window_openclose)
        val wifi_onoff: Button = view.findViewById(R.id.wifi_onoff)
        val lock_onoff: Button = view.findViewById(R.id.lock_onoff)

        // 초기 설정
        setButtonImage(window_openclose, R.drawable.window_open)
        setButtonImage(wifi_onoff, R.drawable.wifi_on)
        setButtonImage(lock_onoff, R.drawable.lock_on)

        // close_open 버튼 처리
        setToggleButton(window_openclose, "open", "close") {
            // 버튼 상태에 따라 drawableBottom 이미지 변경
            if (window_openclose.isSelected) {
                setButtonImage(window_openclose, R.drawable.window_open)
            } else {
                setButtonImage(window_openclose, R.drawable.window_close)
            }
        }

        // wifi_onoff 버튼 처리
        setToggleButton(wifi_onoff, "on", "off") {
            // 버튼 상태에 따라 drawableBottom 이미지 변경
            if (wifi_onoff.isSelected) {
                setButtonImage(wifi_onoff, R.drawable.wifi_on)
            } else {
                setButtonImage(wifi_onoff, R.drawable.wifi_off)
            }
        }

        setToggleButton(lock_onoff, "on", "off") {
            // 버튼 상태에 따라 drawableBottom 이미지 변경
            if (lock_onoff.isSelected) {
                setButtonImage(lock_onoff, R.drawable.lock_on)
            } else {
                setButtonImage(lock_onoff, R.drawable.lock_off)
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