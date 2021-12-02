package com.example.marveldemo.utils

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import javax.inject.Inject


class Nav @Inject constructor() {
    fun goToFragment(view: View, id: Int, args: Bundle?){
        Navigation.findNavController(view).navigate(id,args)
    }
}