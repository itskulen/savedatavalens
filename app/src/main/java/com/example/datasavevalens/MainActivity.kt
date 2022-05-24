 package com.example.datasavevalens

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.datasavevalens.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val MY_SHARED_PREF_NAME ="my_shared_pref"
    private val NAME = "name"
    private val AGE = "age"
// baris 12 hingga 14 merupakan insialisasikan  variable MY_SHARED_PREF_NAME, name dan age
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showSavedData()
        binding.btnSave.setOnClickListener {
            saveData()
        }


    }

     private fun saveData(){
         val insertName = binding.etName.text.toString()
         val insertAge = binding.etAge.text.toString()

         val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME,
             Context.MODE_PRIVATE)

         val editor = sharedPref.edit()
         editor.putString(NAME, insertName)
         editor.putString(AGE, insertAge)
         editor.apply()

         Toast.makeText(this, "Data saved",
             Toast.LENGTH_SHORT
         ).show()
    // apapbila context adalah this akan menampilkn text data saved (setelah user menginputkan ke2 variable yang diminta)
         binding.tvResult.text = "Name:$insertName \nAge: $insertAge"
        // text view tvresult menampilkan nama dari variable name dan insert age
     }

     private fun showSavedData(){

         val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME,
             Context.MODE_PRIVATE)

         val name = sharedPref.getString(NAME, "")
         val age = sharedPref.getString(AGE, "")

         binding.tvResult.text = "Name:$name \nAge: $age"

 // baris 49 merupakan proses untuk menampilkan data yang telah diinputkan oleh user, baris 54 apabila variable name=sharedPref.getString akan menampilkan nama yang diinputkan baris 55 apabila variable agee=sharedPref.getString akan menampilkan umur yang diinputkan
     }
}