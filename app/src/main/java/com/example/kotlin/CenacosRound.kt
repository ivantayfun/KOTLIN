package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.text.DecimalFormat
import kotlin.math.ln

class CenacosRound :
    AppCompatActivity() {
    private lateinit var editTextTtrybokVKose: EditText
    private lateinit var editTextDlinaOvala: EditText
    private lateinit var editTextShirinaOvala: EditText
    private lateinit var editTextSkidka: EditText
    private lateinit var textViewSkidka: TextView
    private var dlinaBlijeKVbIbrKose = 0
    private var dlinacosu = 0.0
    private var skidka = 0.0
    private var chislo = 0.0
    private var osnovanie = 0.0
    private var ccc = 0.0
    private var skidkarezylbtat = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cenacosround)
        val toolbar: Toolbar =
            findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        dlinaBlijeKVbIbrKose = 1
        val tvName: Button = findViewById(R.id.button2)
        editTextTtrybokVKose = findViewById(R.id.editText_trybok_v_kose)
        editTextDlinaOvala = findViewById(R.id.editText_dlina_ovala)
        editTextShirinaOvala = findViewById(R.id.editText_shirina_ovala)
        editTextSkidka = findViewById(R.id.editText_skidka)
        textViewSkidka = findViewById(R.id.textView_skidka_rezylbtat)
        tvName.setOnClickListener {
            skidka = 0.0
            if (editTextSkidka.text.toString() != "") {
                skidka = editTextSkidka.text.toString().toDouble()
            }
            dlinacosu =
                if (editTextDlinaOvala.text.toString().toInt() <
                    editTextShirinaOvala.text.toString().toInt()
                ) {
                    editTextDlinaOvala.text.toString().toInt() * 3.14 + (
                            editTextShirinaOvala.text.toString().toInt()
                                - editTextDlinaOvala.text.toString().toInt()) * 2
                }
                //master
                else {
                    editTextShirinaOvala.text.toString().toInt() * 3.14 + (
                            editTextDlinaOvala.text.toString().toInt()
                                - editTextShirinaOvala.text.toString().toInt()) * 2
                }

            val textView1: TextView =
                findViewById(R.id.textView_rezylbtat_dlina)
            textView1.text = ("$dlinacosu см")
            chislo =
                dlinacosu * editTextTtrybokVKose.text.toString().toInt()
            osnovanie = 5008.0
            ccc =
                (2.48178 - ln(chislo * 100) / ln(osnovanie)) * chislo
            val ggg = DecimalFormat("#0.00").format(ccc) + " грн"
            val textView: TextView =
                findViewById(R.id.textView_rezylbtat)
            textView.text = ggg
            skidkarezylbtat = ccc * (100 - skidka) / 100



            val ggg2 =
                DecimalFormat("#0.00").format(skidkarezylbtat) + " грн"

            textViewSkidka.text = ggg2
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        menuInflater.inflate(R.menu.menu_cenacosround, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        when (item.itemId) {
            R.id.glavnaya -> mainactivityfynk()
                    }
        return super.onOptionsItemSelected(item)
    }

    //ЗАПУСК АКТИВИТИ НАСТРОЙКИ
    /*private void nastroikifynk() {
        Intent intent = new Intent(this, PrefActivity.class);
        startActivity(intent);
        finish();

    }*/
    private fun mainactivityfynk() {
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intent)
        finish()
    }
}