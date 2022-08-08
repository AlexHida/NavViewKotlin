package com.example.navviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_launcher)
    }
    fun botonEnviar(view: View){
        val intent = Intent(this, MainActivity2::class.java)
        val txtUsr = findViewById<EditText>(R.id.txtUser)
        val txtPsw = findViewById<EditText>(R.id.txtPass)

        val aux = findViewById<EditText>(R.id.txtUser).getText().toString()
        val aux2 = findViewById<EditText>(R.id.txtPass).getText().toString()

        val admin = "Alex"
        val adminPw = "1234"

        val user = "User"
        val userPw = "4321"

        intent.putExtra("usr", txtUsr.text.toString())
        intent.putExtra("psw", txtPsw.text.toString())

        if(aux == admin && aux2 == adminPw){
            intent.putExtra("usuario",txtUsr.text.toString())
            intent.putExtra("rol","Admin")
            startActivity(intent)
        } else if(aux == user && aux2 == userPw){
            intent.putExtra("usuario",txtUsr.text.toString())
            intent.putExtra("rol","User")
            startActivity(intent)
        }
        else{
            Snackbar.make(
                findViewById(R.id.txtUser),
                "Usuario Incorrecto",
                BaseTransientBottomBar.LENGTH_SHORT
            ).show()
        }

    }
}