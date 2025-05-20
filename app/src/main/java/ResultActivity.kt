package com.brunafenali.calculadoradegorjetas

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Recuperar os dados da Intent
        val valorConta = intent.getDoubleExtra("valorConta", 0.0)
        val numeroPessoas = intent.getIntExtra("numeroPessoas", 1)
        val porcentagem = intent.getIntExtra("porcentagem", 10)

        // Calcular gorjeta, total e valor por pessoa
        val gorjeta = valorConta * porcentagem / 100
        val total = valorConta + gorjeta
        val porPessoa = total / numeroPessoas

        // Mostrar os valores formatados
        findViewById<TextView>(R.id.tvValorGorjeta).text = "Gorjeta: R$ %.2f".format(gorjeta)
        findViewById<TextView>(R.id.tvTotalConta).text = "Total: R$ %.2f".format(total)
        findViewById<TextView>(R.id.tvValorPorPessoa).text = "Por Pessoa: R$ %.2f".format(porPessoa)

        // Botão para voltar
        findViewById<Button>(R.id.btnVoltar).setOnClickListener {
            finish() // fecha a activity atual e volta para a MainActivity
        }
    }
}
