package ca.cem.tapelelapin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import ca.cem.tapelelapin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding;

    private lateinit var listeBoutons : List<Button>

    var scoreTops = 0
    var scoreFlops = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvTops.setOnClickListener(View.OnClickListener {
            println("Coucou")
            binding.tvTops.setText("Lapin")
        })
        listeBoutons = listOf(
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6,
            binding.btn7,
            binding.btn8,
            binding.btn9,
        )
        for (btn in listeBoutons) {
            btn.setOnClickListener(View.OnClickListener {
                reagirAuClic(it)
            })
        }

        initialiser()
    }

    fun initialiser() {
        // mettre tous les autres à taupe
        for (btn in listeBoutons) {
            btn.setText("Taupe")
        }
        // choisir un bouton au hasard dans la liste
        val boutonLapin : Button = listeBoutons.random()
        boutonLapin.setText("Lapin")
        // Choisir une case pour le lapin au hasard
    }

    fun reagirAuClic(it: View ) {
        // détecter si le bouton appuyé est le lapin
        val boutonClique : Button = it as Button
        if (boutonClique.text == "Lapin") {
            boutonClique.setText("Taupe")
            initialiser()
            scoreTops++
        } else {
            scoreFlops++
            // sinon, perdre un point
        }
        // mettre à jour l'affichage du score
        binding.tvTops.setText("Tops: $scoreTops")
        binding.tvFlops.setText("Flops: $scoreFlops")

    }
}