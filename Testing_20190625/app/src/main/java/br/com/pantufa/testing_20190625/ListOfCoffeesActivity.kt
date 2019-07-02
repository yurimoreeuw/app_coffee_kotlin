package br.com.pantufa.testing_20190625

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_of_coffees.*

class ListOfCoffeesActivity : AppCompatActivity() {

    val coffeeBeanRepository = CoffeeBeanRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_coffees)

        coffeeBeanRepository.getCoffeeList ({
            Toast.makeText(this, it.first().producer, Toast.LENGTH_SHORT).show()

            text_variety.text = it.first().variety
        }, {
            Toast.makeText(this, "Puts, erro no servico", Toast.LENGTH_SHORT).show()
        })
    }
}
