package com.pramodk.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        val addContactDialog = AlertDialog.Builder(this)
                .setTitle("Add Contact")
                .setMessage("Do you want to add Mr. Tank?")
                .setIcon(R.drawable.ic_person)
                .setPositiveButton("yes"){ _, _ ->
                    Toast.makeText(this,"Mr Tank has been added to contact list",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("no"){ _, _ ->
                    Toast.makeText(this,"Mr Tank has not been added to contact list",Toast.LENGTH_SHORT).show()
                }.create()

        button1.setOnClickListener {
           addContactDialog.show()
        }

        val options = arrayOf("first item","second item","third item")
        val singleChoiceDialog = AlertDialog.Builder(this)
                .setTitle("choose any one")
                .setSingleChoiceItems(options,0) { dialogInterface, i->
                    Toast.makeText(this,"you clicked on ${options[i]}",Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Accept"){ _, _ ->
                    Toast.makeText(this,"you accepted ",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Decline"){ _, _ ->
                    Toast.makeText(this,"you declined",Toast.LENGTH_SHORT).show()
                }.create()

        button2.setOnClickListener{
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
                .setTitle("choose any one")
                .setMultiChoiceItems(options, booleanArrayOf(false,false,false)) { _ , i , isChecked->
                    if (isChecked){
                    Toast.makeText(this,"you checked ${options[i]}",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"you unchecked ${options[i]}",Toast.LENGTH_SHORT).show()
                    }
                }
                .setPositiveButton("Accept"){ _, _ ->
                    Toast.makeText(this,"you accepted ",Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Decline"){ _, _ ->
                    Toast.makeText(this,"you declined",Toast.LENGTH_SHORT).show()
                }.create()

        button3.setOnClickListener{
            multiChoiceDialog.show()
        }
    }

}