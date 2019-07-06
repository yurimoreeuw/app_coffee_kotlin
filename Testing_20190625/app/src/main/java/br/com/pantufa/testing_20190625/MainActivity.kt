package br.com.pantufa.testing_20190625

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_of_coffees.setOnClickListener {
            // Handler code here.
            val intent = Intent(this, ListOfCoffeesActivity::class.java)
            startActivity(intent);
        }

    }





}
