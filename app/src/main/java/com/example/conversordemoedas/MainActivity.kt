package com.example.conversordemoedas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Declara nossas variáveis
    lateinit var btn_conversor : Button
    lateinit var editText: EditText
    lateinit var radioGroup: RadioGroup
    lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Passa os elementos do layout
        btn_conversor = findViewById(R.id.btn_converter)
        editText = findViewById(R.id.edit_price)
        radioGroup = findViewById(R.id.radio_group)
        resultText = findViewById(R.id.txt_result)

        // Ativar o click do botão
        btn_conversor.setOnClickListener(){

            // Realizar a conversão
            var valorConversao = ConverterMoeda(editText.text.toString(), radioGroup.checkedRadioButtonId)

            resultText.text = valorConversao
        }
    }

    // Função de conversão
    fun ConverterMoeda(valor : String, radioSelected : Int) : String{

        // Valor da conversao
        var conversao = 0.00

        // Identificar o valor da moeda
        val dolar = 0.2
        val euro = 0.18
        val libra = 0.16

        if (valor.toString().isNotEmpty()){

            // Dolar
            if(radioSelected == R.id.radio_dolar){
                conversao = valor.toDouble() * dolar
                return "${"%.2f".format(conversao)}"
            }else if(radioSelected == R.id.radio_euro){
                conversao = valor.toDouble() * euro
                return "${"%.2f".format(conversao)}"
            }else{
                conversao = valor.toDouble() * libra
                return "${"%.2f".format(conversao)}"
            }


        }
        return ""
    }
}