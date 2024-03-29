package com.example.snackbarmessage

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var showSnackBarMessage : Button
    private lateinit var showDialogMessage : Button
    private lateinit var showToastMessage : Button
    private lateinit var output : TextView
    private lateinit var myLayOut : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showSnackBarMessage = findViewById(R.id.showSnackBarMessage)
        showDialogMessage = findViewById(R.id.showDialogMessage)
        showToastMessage = findViewById(R.id.showToastMessage)
        output = findViewById(R.id.output)
        myLayOut = findViewById(R.id.main)

        showSnackBarMessage.setOnClickListener{
            myLayOut.setBackgroundColor(Color.parseColor("#fff1e7"))
            Snackbar.make(myLayOut, "This iis my snackbar message", Snackbar.LENGTH_INDEFINITE)
                .setAction("Close") {

                }.setActionTextColor(Color.parseColor("#30949d"))
                .setTextColor(Color.WHITE)
                .setAnimationMode(Snackbar.ANIMATION_MODE_FADE)
                .show()
        }
        showDialogMessage.setOnClickListener{
            showAlertDialogMessage()
        }
        showToastMessage.setOnClickListener {
            Toast.makeText(
                applicationContext
                ,"This is the toast message"
                ,Toast.LENGTH_LONG)
                .show()
        }    }
    private fun showAlertDialogMessage(){
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("Change")
            .setMessage("Do you want to change the text of the button")
            .setIcon(R.drawable.warning_icon)
            .setCancelable(false)
            .setNegativeButton("No") { dialog, which ->
                dialog.cancel()
            }
            .setPositiveButton("Yes") { _, _ ->
                output.text = "Alert Dialog"
            }
        alertDialog.create().show()
    }

}