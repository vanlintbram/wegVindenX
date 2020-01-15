package be.brussel.vanlintbram.wegvindenx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val intro = intro()
    private val kaart = kaart()
    private val navigatie = navigatie()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Display First Fragment initially */
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.wegVindenFragment, intro )
        fragmentTransaction.commit()
    }

    fun btnOne(v: View){
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.wegVindenFragment, intro)
        fragmentTransaction.commit()
    }

    fun btnTwo(v: View){
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.wegVindenFragment, kaart)
        fragmentTransaction.commit()
    }

    fun btnThree(v: View){
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.wegVindenFragment, navigatie )
        fragmentTransaction.commit()
    }


}
