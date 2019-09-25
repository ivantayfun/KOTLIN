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

class CenacosRound :
    AppCompatActivity() {
    internal var editText_trybok_v_kose: EditText? = null
    internal var editText_dlina_ovala: EditText? = null
    internal var editText_shirina_ovala: EditText? = null
    internal var editText_skidka: EditText? = null
    internal var dlina_blije_k_vbIbr_kose = 0
    internal var dlina_cosu = 0.0
    internal var skidka = 0.0
    internal var chislo = 0.0
    internal var osnovanie = 0.0
    internal var ccc = 0.0
    internal var skidka_rezylbtat = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cenacosround)
        val toolbar: Toolbar =
            findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        dlina_blije_k_vbIbr_kose = 1
        val tvName: Button = findViewById(R.id.button2)
        editText_trybok_v_kose = findViewById<EditText?>(R.id.editText_trybok_v_kose)
        editText_dlina_ovala = findViewById<EditText?>(R.id.editText_dlina_ovala)
        editText_shirina_ovala = findViewById<EditText?>(R.id.editText_shirina_ovala)
        editText_skidka = findViewById<EditText?>(R.id.editText_skidka)
        tvName.setOnClickListener {
            skidka = 0.0
            if (editText_skidka!!.text.toString() != "") {
                skidka =
                    Integer.parseInt(editText_skidka!!.text.toString()).toDouble()
            }
            dlina_cosu =
                if (Integer.parseInt(editText_dlina_ovala!!.text.toString()) < Integer.parseInt(
                        editText_shirina_ovala!!.text.toString()
                    )
                ) {
                    Integer.parseInt(editText_dlina_ovala!!.text.toString()) * 3.14 + (Integer.parseInt(
                        editText_shirina_ovala!!.text.toString()
                    ) - Integer.parseInt(editText_dlina_ovala!!.text.toString())) * 2
                }
                //master
                else {
                    Integer.parseInt(editText_shirina_ovala!!.text.toString()) * 3.14 + (Integer.parseInt(
                        editText_dlina_ovala!!.text.toString()
                    ) - Integer.parseInt(editText_shirina_ovala!!.text.toString())) * 2
                }

            val ggg_dlina = "$dlina_cosu см"
            val textView1: TextView =
                findViewById(R.id.textView_rezylbtat_dlina)
            textView1.text = ggg_dlina
            chislo =
                dlina_cosu * Integer.parseInt(editText_trybok_v_kose!!.text.toString())
            osnovanie = 5008.0
            ccc =
                (2.48178 - Math.log(chislo * 100) / Math.log(osnovanie)) * chislo
            val ggg = DecimalFormat("#0.00").format(ccc) + " грн"
            val textView: TextView =
                findViewById(R.id.textView_rezylbtat)
            textView.text = ggg
            skidka_rezylbtat = ccc * (100 - skidka) / 100
            val ggg2 =
                DecimalFormat("#0.00").format(skidka_rezylbtat) + " грн"
            val textView_skidka: TextView =
                findViewById(R.id.textView_skidka_rezylbtat)
            textView_skidka.text = ggg2
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
            11 -> {
            }
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