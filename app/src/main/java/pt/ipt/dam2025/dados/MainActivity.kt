package pt.ipt.dam2025.dados

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pt.ipt.dam2025.dados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btn.setOnClickListener {
            RolaDado()
        }
    }

    /**
     * Roda o dado e dá update na tela com o resultado
     * */
    private fun RolaDado() {
        /*
        1 - Create new random value entre 1 e 6
         */
        val randomNumber = (1..6).random()


        //2
        val drawbleResource = when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        //3

        binding.ImageView.setImageResource(drawbleResource)

        //4 atualiza o texto


            binding.TextView2.text = randomNumber.toString()

        //5


        val textNumber = when (randomNumber) {
            1 -> R.string.n1
            2 -> R.string.n2
            3 -> R.string.n3
            4 -> R.string.n4
            5 -> R.string.n5
            6 -> R.string.n6
            else -> R.string.n
        }

        //dar o texto a textview

        val txt= getString(textNumber)
        binding.valordolado.text = " ($txt)"
        }


    }


