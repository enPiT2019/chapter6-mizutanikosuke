package npaka.net.mysize

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editNeck = pref.getString("NECK","")
        val editSleeve = pref.getString("SLEEVE","")
        val editWaist = pref.getString("WAIST","")
        val editInseam = pref.getString("INSEAM","")

        neck.setText(editNeck)
        sleeve.setText(editSleeve)
        waist.setText(editWaist)
        inseam.setText(editInseam)

        save.setOnClickListener { onSaveTapped() }

        heightButton.setOnClickListener {
            val intent = Intent(this,HeightActivity::class.java)
            startActivity(intent)

        }
    }

    private fun onSaveTapped(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putString("NECK",neck.text.toString())
            putString("SLEEVE",sleeve.text.toString())
            putString("WAIST",waist.text.toString())
            putString("INSEAM",inseam.text.toString())
        }
    }
}
