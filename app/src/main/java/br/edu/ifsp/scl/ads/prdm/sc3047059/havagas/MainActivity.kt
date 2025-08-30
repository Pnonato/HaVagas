package br.edu.ifsp.scl.ads.prdm.sc3047059.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.scl.ads.prdm.sc3047059.havagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private val activityMainBinding: ActivityMainBinding by lazy {
    ActivityMainBinding.inflate(layoutInflater)
}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)


        activityMainBinding.limparBt.setOnClickListener {
            activityMainBinding.nomeEt.setText("")
            activityMainBinding.emailEt.setText("")
            activityMainBinding.telefoneEt.setText("")
            activityMainBinding.sexoEt.setText("")
            activityMainBinding.dataNascEt.setText("")
            activityMainBinding.vagasInteresseEt.setText("")
            activityMainBinding.formacaoSp.setSelection(0)

            activityMainBinding.fundamentalMedioLy.visibility = View.GONE
            activityMainBinding.graduacaoEspecializacaoLy.visibility = View.GONE
            activityMainBinding.mestradoDouturadoLy.visibility = View.GONE

            activityMainBinding.anoFormaturaEt.setText("")
            activityMainBinding.anoConclusaoEt.setText("")
            activityMainBinding.instituicaoEt.setText("")
            activityMainBinding.tituloMonografiaEt.setText("")
            activityMainBinding.orientadorEt.setText("")
        }


        activityMainBinding.salvarBt.setOnClickListener {


            val nome = activityMainBinding.nomeEt.text.toString()
            val email = activityMainBinding.emailEt.text.toString()
            val telefone = activityMainBinding.telefoneEt.text.toString()
            val sexo = activityMainBinding.sexoEt.text.toString()
            val dataNasc = activityMainBinding.dataNascEt.text.toString()
            val vagasInteresse = activityMainBinding.vagasInteresseEt.text.toString()
            val formacaoSelecionada = activityMainBinding.formacaoSp.selectedItem.toString()

            val anoFormatura = activityMainBinding.anoFormaturaEt.text.toString()
            val anoConclusao = activityMainBinding.anoConclusaoEt.text.toString()
            val instituicao = activityMainBinding.instituicaoEt.text.toString()
            val tituloMonografia = activityMainBinding.tituloMonografiaEt.text.toString()
            val orientador = activityMainBinding.orientadorEt.text.toString()

            val dados = StringBuilder().apply {

                append("Nome: $nome\n")
                append("E-mail: $email\n")
                append("Telefone: $telefone\n")
                append("Sexo: $sexo\n")
                append("Data de Nascimento: $dataNasc\n")
                append("Formação: $formacaoSelecionada\n")

                when (formacaoSelecionada) {
                    "Fundamental", "Médio" -> {
                        append("Ano de Formatura: $anoFormatura\n")
                    }
                    "Graduação", "Especialização" -> {
                        append("Ano de Conclusão: $anoConclusao\n")
                        append("Instituição: $instituicao\n")
                    }
                    "Mestrado", "Doutorado" -> {
                        append("Ano de Conclusão: $anoConclusao\n")
                        append("Instituição: $instituicao\n")
                        append("Título da Monografia: $tituloMonografia\n")
                        append("Orientador: $orientador\n")
                    }
                }

                append("Vagas de Interesse: $vagasInteresse")
            }

            AlertDialog.Builder(this)
                .setTitle("Dados Cadastrados")
                .setMessage(dados.toString())
                .setPositiveButton("OK", null)
                .show()

        }


        activityMainBinding.formacaoSp.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val formacaoSelecionada = resources.getStringArray(R.array.estado_formacao)[position]

               when(formacaoSelecionada){

                    "Fundamental", "Médio" -> {
                        activityMainBinding.fundamentalMedioLy.visibility = View.VISIBLE
                        activityMainBinding.graduacaoEspecializacaoLy.visibility = View.GONE
                        activityMainBinding.mestradoDouturadoLy.visibility = View.GONE

                    }
                   "Graduação", "Especialização" -> {
                       activityMainBinding.graduacaoEspecializacaoLy.visibility = View.VISIBLE
                       activityMainBinding.fundamentalMedioLy.visibility = View.GONE
                       activityMainBinding.mestradoDouturadoLy.visibility = View.GONE

                   }
                   "Mestrado", "Doutorado" -> {
                       activityMainBinding.mestradoDouturadoLy.visibility = View.VISIBLE
                       activityMainBinding.fundamentalMedioLy.visibility = View.GONE
                       activityMainBinding.graduacaoEspecializacaoLy.visibility = View.GONE
2
                   }

               }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

                //NSA
            }
        }

    }


}