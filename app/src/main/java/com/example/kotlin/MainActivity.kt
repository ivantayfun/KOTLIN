package com.example.kotlin

//import com.google.android.material.snackbar.Snackbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var editText_trybok_v_kose: EditText? = null
    private var editText_dlina_kosbI: EditText? = null
    private var editText_skidka: EditText? = null
    private val osnovanie = 0.0
    private val chislo = 0.0
    private val ccc = 0.0
    private val skidka = 0.0
    private val skidka_rezylbtat = 0.0
    private val git_hub2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //pri sozdanii sozdalosb
        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        val tvName: Button = findViewById(R.id.button2)
        editText_trybok_v_kose = findViewById(R.id.editText_trybok_v_kose)
        editText_dlina_kosbI = findViewById(R.id.editText_dlina_kosbI)
        editText_skidka = findViewById(R.id.editText_skidka)

    }















    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
