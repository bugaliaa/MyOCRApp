package com.example.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BindingFragment<B : ViewDataBinding> constructor(
    @LayoutRes contentLayoutId: Int
) : BaseFragment(contentLayoutId) {

    lateinit var binding: B

    final override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = onCreateBinding(inflater, container)
        binding.lifecycleOwner = viewLifecycleOwner
        this.binding = binding
        return binding.root
    }

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.onBindingCreated(savedInstanceState)
    }

    open fun B.onBindingCreated(savedInstanceState: Bundle?) {}

    open fun onCreateBinding(inflater: LayoutInflater, container: ViewGroup?): B {
        val view = super.onCreateView(inflater, container, null)
        if (view != null) {
            return DataBindingUtil.bind(view)!!
        }

        throw IllegalStateException("Override onCreateBinding or pass a layout resource in the fragment constructor")
    }

    @CallSuper
    override fun onDestroyView() {
        binding.unbind()
        super.onDestroyView()
    }
}