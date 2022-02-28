package ru.axout.savestate.save_state

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ru.axout.savestate.R

class SaveStateActivity : AppCompatActivity(R.layout.activity_save_state) {

    private var count = 0
    private lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        counterTextView = findViewById(R.id.tv_count)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNTER)
        }

        updateCountText()

        findViewById<Button>(R.id.bt_increase).setOnClickListener {
            count++
            updateCountText()
        }

        findViewById<Button>(R.id.bt_decrease).setOnClickListener {
            count--
            updateCountText()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, count)
    }

    private fun updateCountText() {
        counterTextView.text = "Count: $count"
    }

    companion object {
        private const val KEY_COUNTER = "KEY_COUNTER"
    }
}