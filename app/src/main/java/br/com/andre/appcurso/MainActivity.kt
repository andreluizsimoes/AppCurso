package br.com.andre.appcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Path

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_activity)

//        Picasso.get()
//            .load("https://images.discerningassets.com/image/upload/c_fit,h_1000,w_1000/c_fit,fl_relative,h_1.0,o_100,w_1.0/v1529691019/Cinderella_s_Castle_at_Night_1_xndmux.jpg")
//            .into(imageView)
    }

    override fun onStart() {
        super.onStart()
        toastTest("Let's Start!")

    }

    fun toastTest(text:String)=
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

    override fun onRestart() {
        super.onRestart()
        toastTest("RESTARTing")
    }

    override fun onResume() {
        super.onResume()
        toastTest("RESUME: Voltando!")
    }

    override fun onPause() {
        super.onPause()
        toastTest("2 ALTOS! PAUSE!")
    }

    override fun onStop() {
        super.onStop()
        toastTest("Vamo parar!")
    }

    override fun onDestroy() {
        super.onDestroy()
        toastTest("Meu App Morreu!")
    }

}
