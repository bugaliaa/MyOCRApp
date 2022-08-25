package com.example.base

import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseFragment constructor(@LayoutRes contentLayoutId: Int) :
    Fragment(contentLayoutId) {

    fun String.showAsToast() {
        Toast.makeText(requireContext(), this, Toast.LENGTH_SHORT).show()
    }
}

abstract class BaseBottomSheetFragment constructor(@LayoutRes contentLayoutId: Int) :
    BottomSheetDialogFragment() {

    fun String.showAsToast() {
        Toast.makeText(requireContext(), this, Toast.LENGTH_SHORT).show()
    }
}