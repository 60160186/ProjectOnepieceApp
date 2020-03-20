package com.example.onepieceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.facebook.login.LoginManager

/**
 * A simple [Fragment] subclass.
 */
class Menu : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val button1 = view.findViewById(R.id.character) as Button
        val button2 = view.findViewById(R.id.score) as Button
        val button3 = view.findViewById(R.id.logout) as Button

        button1.setOnClickListener {
            val Recycler_view = Recycler_view()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout,Recycler_view,"fragment_Recycler_view")
            transaction.addToBackStack("fragment_Recycler_view")
            transaction.commit() }

        button2.setOnClickListener {
            val activity1 = activity_main1()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout,activity1,"fragment_activity1")
            transaction.addToBackStack("fragment_activity1")
            transaction.commit() }

        button3.setOnClickListener {
            LoginManager.getInstance().logOut()
            activity!!.supportFragmentManager.popBackStack()
            val authen = authen()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout,authen,"fragment_authen")
            transaction.addToBackStack("fragment_authen")
            transaction.commit() }
        return view
    }

}
