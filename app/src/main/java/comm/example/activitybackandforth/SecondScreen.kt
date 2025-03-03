package comm.example.activitybackandforth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        Log.d("ACTBF", "==== SECOND onCreate ======")
        if( savedInstanceState == null ) {
            Log.d("ACTBF", "Bundle is empty in onCreate()")
        }
        else {
            Log.d("ACTBF", "Bundle is NON-empty in onCreate()")
            var keys = savedInstanceState.keySet()
            for (i in keys) Log.d("ACTBF", "i = " + i)
        }
        var intent :Intent = getIntent()
        var s = intent.getStringExtra("String1_key");
        var textV = findViewById<TextView>(R.id.top_label)
        textV.append( "\n" + s )
    }
    fun toFirst(v: View)
    {
        var backIntent = Intent(this, MainActivity::class.java)
        backIntent.putExtra("String1_key", "Hello")
        startActivity(backIntent)
    }
}