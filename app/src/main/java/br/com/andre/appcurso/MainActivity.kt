package br.com.andre.appcurso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.set
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.constraint_activity.*
import java.nio.file.Path

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_activity)
        iniListeners()

//     Adicionando imagem direto no app com Picasso
//      Picasso.get()
//            .load("https://images.discerningassets.com/image/upload/c_fit,h_1000,w_1000/c_fit,fl_relative,h_1.0,o_100,w_1.0/v1529691019/Cinderella_s_Castle_at_Night_1_xndmux.jpg")
//            .into(imageView)
    }

    private fun esconderTeclado() {
        alturaEDTX.onEditorAction(EditorInfo.IME_ACTION_DONE)
        pesoEDTX.onEditorAction(EditorInfo.IME_ACTION_DONE)
    }

    private fun iniListeners(){
        // chamar essa função no onCreate, com as chamadas de botão aqui ao invés de lá

        // Função do botão limpar
        limparBTN?.setOnClickListener {
            pesoEDTX.text.clear()
            alturaEDTX.text.clear()
            resultadoTXT.setText("")

//            pesoEDTX.clearFocus()
//            alturaEDTX.clearFocus()
            pesoEDTX.setError(null)
            alturaEDTX.setError(null)

            // Esconder teclado
            esconderTeclado()
        }

        // Função do botão calcular
        calcularBTN?.setOnClickListener {
            // Pega os valores da Tela e faz o cálculo
            getValues()

            // Esconder teclado
            esconderTeclado()
        }

    }

    private fun getValues(){
        var imc: Float

        when {

            pesoEDTX.text.toString().isNullOrEmpty() -> pesoEDTX.setError("Digite seu peso!")
            pesoEDTX.text.toString().equals("0") -> pesoEDTX.setError("Digite um valor válido!")
            alturaEDTX.text.toString().isNullOrEmpty() -> alturaEDTX.setError("Digite sua altura!")
            alturaEDTX.text.toString().equals("0") -> alturaEDTX.setError("Digite um valor válido!")

            else -> {
                var peso = pesoEDTX.text.toString().toFloat()
                var altura = alturaEDTX.text.toString().toFloat()//
                imc = calcIMC(altura, peso)

                //Seta o resultado
                resultadoTXT?.text = when (imc) {
                    in 0f..18.49f -> "Abaixo do Peso"
                    in 18.5f..29.99f -> "Peso Normal"
                    else -> "Acima do Peso"
                }
            }
        }

    }

    private fun calcIMC(altura: Float, peso: Float) = peso / (altura*altura)



    fun toastTest(text:String)=
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


    //    override fun onStart() {
//        super.onStart()
//        toastTest("Let's Start!")
//
//    }


//    override fun onRestart() {
//        super.onRestart()
//        toastTest("RESTARTing")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        toastTest("RESUME: Voltando!")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        toastTest("2 ALTOS! PAUSE!")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        toastTest("Vamo parar!")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        toastTest("Meu App Morreu!")
//    }

}
