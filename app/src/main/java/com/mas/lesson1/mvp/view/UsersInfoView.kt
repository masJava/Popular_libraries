package com.mas.lesson1.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface UsersInfoView : MvpView {
    fun setLogin(text: String)
}