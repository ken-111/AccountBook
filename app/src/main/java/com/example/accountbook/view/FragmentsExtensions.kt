package com.example.accountbook.view

import androidx.fragment.app.Fragment

fun Fragment.getMainActivity(): MainActivity? {
    if (activity is MainActivity) {
        return activity as MainActivity
    }
    return null
}