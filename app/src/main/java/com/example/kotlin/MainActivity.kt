package com.example.kotlin

//import com.google.android.material.snackbar.Snackbar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import kotlin.math.ln

class MainActivity : AppCompatActivity() {
    private lateinit var editTextTrybokVKose: EditText
    private lateinit var editTextDlinaKosbI: EditText
    private lateinit var editTextSkidka: EditText
    //var editText = EditText(this)
    private var osnovanie = 0.0
    private var chislo = 0.0
    private var ccc = 0.0
    private var skidka: Double = 0.0
    private var skidkaRezylbtat = 0.0
    //private val git_hub2 = 0

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
        editTextTrybokVKose = findViewById(R.id.editText_trybok_v_kose)
        editTextDlinaKosbI = findViewById(R.id.editText_dlina_kosbI)
        editTextSkidka = findViewById(R.id.editText_skidka)
        tvName.setOnClickListener {
            skidka = 0.0

            if (editTextSkidka.text.toString() != "") {
                skidka = editTextSkidka.text.toString().toDouble()
            }

            chislo = (editTextDlinaKosbI.text.toString().toInt() *
                    editTextTrybokVKose.text.toString().toInt()
                ).toDouble()

            osnovanie = 5008.0
            ccc =
                (2.48178 - ln(chislo * 100) / ln(osnovanie)) * chislo
            val ggg = DecimalFormat("#0.00").format(ccc) + " грн"
            val textView: TextView =
                findViewById(R.id.textView_rezylbtat)
            textView.text = ggg
            skidkaRezylbtat = ccc * (100 - skidka) / 100
            val ggg1 =
                DecimalFormat("#0.00").format(skidkaRezylbtat) + " грн"

            val textViewSkidka: TextView =
                findViewById(R.id.textView_skidka_rezylbtat)
            textViewSkidka.text = ggg1
        }
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
        when (item.itemId) {
            R.id.action_settings -> settingfynk()
            R.id.cenacos_raund -> cenacosroundfynk()
            R.id.foto_tkanb -> fototkanbfynk()
        }

        return super.onOptionsItemSelected(item)
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    }
    private fun fototkanbfynk() {
        val intent = Intent(
            this,
            CenacosRound::class.java
        )
        startActivity(intent)
    }
    private fun settingfynk() {
        val intent = Intent(
            this,
            SettingsActivity::class.java
        )
        startActivity(intent)
    }
    private fun cenacosroundfynk() {
        val intent = Intent(
            this,
            CenacosRound::class.java
        )
        startActivity(intent)
    }
}
