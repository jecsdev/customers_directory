package com.jcampusano.customersdirectory.ui.listeners

import android.view.View

interface ClickListener {

    fun onClick(view: View, position:  Int)

    fun onLongClick(v: View?, position: Int): Boolean
}