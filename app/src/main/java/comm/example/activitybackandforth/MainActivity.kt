package comm.example.activitybackandforth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("ACTBF", "==== MAIN onCreate ======")
        if( savedInstanceState == null ) {
            Log.d("ACTBF", "Bundle is empty in onCreate()")
        }
        else {
            Log.d("ACTBF", "Bundle is NON-empty in onCreate()")
            var keys = savedInstanceState.keySet()
            for (i in keys) Log.d("ACTBF", "i = " + i)
        }
    }
    fun toSecond(v: View) {
        Toast.makeText(this, "Button Pressed", Toast.LENGTH_SHORT).show()
        var intext = findViewById<EditText>(R.id.text_to_send)
        var s = intext.getText().toString()
        // make an intent to send this String to other screen
        val secondIntent = Intent(this, SecondScreen::class.java)
        secondIntent.putExtra("String1_key", s)
        startActivity(secondIntent)

    }
}