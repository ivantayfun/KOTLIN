package com.example.kotlin

//import android.content.Intent
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
//import androidx.preference.PreferenceFragmentCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings, SettingsFragment())
            .commit()
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_settingsactivity, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.glavnaya -> mainactivityfynk()
            R.id.cenacos_raund -> cenacosroundfynk()
            R.id.foto_tkanb -> fototkanbfynk()
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
    private fun fototkanbfynk() {
        val intent = Intent(
            this,
            FotoActivity::class.java
        )
        startActivity(intent)
    }
}