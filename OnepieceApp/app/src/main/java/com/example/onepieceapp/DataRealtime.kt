package com.example.onepieceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.database.FirebaseDatabase

/**
 * A simple [Fragment] subclass.
 */
class DataRealtime : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_data_realtime, container, false)
        // Inflate the layout for this fragment

        val btn4 = view.findViewById<Button>(R.id.btn4)

        //ประกาศตัวแปร DatabaseReference รับค่า Instance และอ้างถึง path ที่เราต้องการใน database
        val mRootRef = FirebaseDatabase.getInstance().getReference()

        //อ้างอิงไปที่ path ที่เราต้องการจะจัดการข้อมูล ตัวอย่างคือ users และ messages
        val mUsersRef = mRootRef.child("users")
        val mMessagesRef = mRootRef.child("messages")

        btn4.setOnClickListener {

            val mMessagesRef2 = mRootRef.child("data")

            val key = mMessagesRef.push().key
            val postValues: HashMap<String, Any> = HashMap()
            postValues["username"] = "60160186"
            postValues["text"] = "-"

            val childUpdates: MutableMap<String, Any> = HashMap()

            childUpdates["$key"] = postValues

            mMessagesRef2.updateChildren(childUpdates)

        }

        val button1 = view!!.findViewById(R.id.btn1) as Button

        button1.setOnClickListener {
            val Menu_view = Menu()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout,Menu_view,"fragment_Menu_view")
            transaction.addToBackStack("fragment_Menu_view")
            transaction.commit()
        }

        return view

    }

    data class FriendlyMessage(
        var username: String? = "",
        var text: String? = ""
    )


}
