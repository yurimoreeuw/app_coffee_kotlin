package br.com.pantufa.testing_20190625

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_of_coffees.*

class ListOfCoffeesActivity : AppCompatActivity() {

    val coffeeBeanRepository = CoffeeBeanRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_coffees)



        coffeeBeanRepository.getCoffeeList ({ list ->
            //o recyclerView nao sabe sozinho como mostrar os dados de uma lista qualquer num layout qualquer.
            //aqui mandamos ele usar o nosso adapter que diz exatamente como criar nossos items e como vincular os dados às views.
            listOfCoffesRecycler.adapter = ListOfCoffeesAdapter(list)

            //esse cara diz pro recyclerView exibir nossos dados linearmente. tambem poderiamos passar GridLayoutManager aqui.
            listOfCoffesRecycler.layoutManager = LinearLayoutManager(this)
        }, {
            Toast.makeText(this, "Puts, erro no servico", Toast.LENGTH_SHORT).show()
        })
    }
}
