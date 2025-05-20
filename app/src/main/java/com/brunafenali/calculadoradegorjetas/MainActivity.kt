package com.brunafenali.calculadoradegorjetas

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declarar as views
    private lateinit var etValorConta: EditText
    private lateinit var etNumeroPessoas: EditText
    private lateinit var etPorcentagem: EditText
    private lateinit var btnCalcular: Button
    private lateinit var btn5: Button
    private lateinit var btn10: Button
    private lateinit var btn15: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar as views
        etValorConta = findViewById(R.id.etValorConta)
        etNumeroPessoas = findViewById(R.id.etNumeroPessoas)
        etPorcentagem = findViewById(R.id.etPorcentagem)
        btnCalcular = findViewById(R.id.btnCalcular)
        btn5 = findViewById(R.id.btn5)
        btn10 = findViewById(R.id.btn10)
        btn15 = findViewById(R.id.btn15)

        // Ação ao clicar em "Calcular"
        btnCalcular.setOnClickListener {
            val valorConta = etValorConta.text.toString().toDoubleOrNull()
            val numeroPessoas = etNumeroPessoas.text.toString().toIntOrNull()
            val porcentagem = etPorcentagem.text.toString().toIntOrNull()

            if (valorConta != null && numeroPessoas != null && porcentagem != null && numeroPessoas > 0) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("valorConta", valorConta)
                intent.putExtra("numeroPessoas", numeroPessoas)
                intent.putExtra("porcentagem", porcentagem)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show()
            }
        }

        // Botões de porcentagem fixa
        btn5.setOnClickListener { etPorcentagem.setText("5") }
        btn10.setOnClickListener { etPorcentagem.setText("10") }
        btn15.setOnClickListener { etPorcentagem.setText("15") }
    }
}
