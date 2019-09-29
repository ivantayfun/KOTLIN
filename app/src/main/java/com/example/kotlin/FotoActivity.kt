package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
//import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_foto.*

//import kotlinx.android.synthetic.main.activity_foto.*

class FotoActivity : AppCompatActivity() {
   private lateinit var dbOpenHelper: ExternalDbOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto)
        setSupportActionBar(toolbar)
        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        dbOpenHelper = ExternalDbOpenHelper(this, "mydatabase.sqlite")
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
            R.id.foto_tkanb -> mainactivityfynk()
        }
        return super.onOptionsItemSelected(item)
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    }
    private fun mainactivityfynk() {
        val intent = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intent)
        finish()
    }
    private fun cenacosroundfynk() {
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
}
