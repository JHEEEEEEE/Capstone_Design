package com.effort.project_application

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SettingFragment : Fragment() {
    private lateinit var btnSetLock: Button
    private lateinit var btnSetDelLock: Button
    private lateinit var btnChangePwd: Button
    private var lock = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)

        // 버튼 위젯 초기화
        btnSetLock = view.findViewById(R.id.btnSetLock)
        btnSetDelLock = view.findViewById(R.id.btnSetDelLock)
        btnChangePwd = view.findViewById(R.id.btnChangePwd)

        // 잠금 설정 버튼 클릭 리스너 등록
        btnSetLock.setOnClickListener {
            val intent = Intent(requireContext(), AppPassWordActivity::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.ENABLE_PASSLOCK)
            }
            startActivityForResult(intent, AppLockConst.ENABLE_PASSLOCK)
        }

        // 잠금 비활성화 버튼 클릭 리스너 등록
        btnSetDelLock.setOnClickListener{
            val intent = Intent(requireContext(), AppPassWordActivity::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.DISABLE_PASSLOCK)
            }
            startActivityForResult(intent, AppLockConst.DISABLE_PASSLOCK)
        }

        // 암호 변경 버튼 클릭 리스너 등록
        btnChangePwd.setOnClickListener {
            val intent = Intent(requireContext(), AppPassWordActivity::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.CHANGE_PASSWORD)
            }
            startActivityForResult(intent, AppLockConst.CHANGE_PASSWORD)
        }

        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode){
            AppLockConst.ENABLE_PASSLOCK ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(requireContext(), "암호 설정 됨", Toast.LENGTH_SHORT).show()
                    init()
                    lock  = false
                }

            AppLockConst.DISABLE_PASSLOCK ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(requireContext(), "암호 삭제 됨", Toast.LENGTH_SHORT).show()
                    init()
                }

            AppLockConst.CHANGE_PASSWORD ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(requireContext(), "암호 변경 됨", Toast.LENGTH_SHORT).show()
                    lock = false
                }

            AppLockConst.UNLOCK_PASSWORD ->
                if(resultCode == Activity.RESULT_OK){
                    Toast.makeText(requireContext(), "잠금 해제 됨", Toast.LENGTH_SHORT).show()
                    lock = false
                }
        }
    }

    override fun onStart() {
        super.onStart()
        if(lock && AppLock(requireContext()).isPassLockSet()){
            val intent = Intent(requireContext(), AppPassWordActivity::class.java).apply {
                putExtra(AppLockConst.type, AppLockConst.UNLOCK_PASSWORD)
            }
            startActivityForResult(intent, AppLockConst.UNLOCK_PASSWORD)
        }
    }

    override fun onPause() {
        super.onPause()
        if (AppLock(requireContext()).isPassLockSet()) {
            lock = true
        }
    }

    private fun init(){
        if (AppLock(requireContext()).isPassLockSet()){
            btnSetLock.isEnabled = false
            btnSetDelLock.isEnabled = true
            btnChangePwd.isEnabled = true
            lock = true
        }
        else{
            btnSetLock.isEnabled = true
            btnSetDelLock.isEnabled = false
            btnChangePwd.isEnabled = false
            lock = false
        }
    }
}
