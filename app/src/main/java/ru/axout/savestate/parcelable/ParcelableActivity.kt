package ru.axout.savestate.parcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ru.axout.savestate.R

class ParcelableActivity : AppCompatActivity(R.layout.activity_save_state) {

    private var state: CounterState? = null
    private lateinit var counterTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state = if (savedInstanceState != null) {
            savedInstanceState.getParcelable(KEY_COUNTER)
        } else {
            CounterState(count = 0)
        }

        counterTextView = findViewById(R.id.tv_count)
        updateCountText()

        findViewById<TextView>(R.id.tv_title).text = "This is Parcelable Activity"

        findViewById<Button>(R.id.bt_increase).setOnClickListener {
            state = state?.copy(count = (state?.count ?: 0) + 1)
            updateCountText()
        }

        findViewById<Button>(R.id.bt_decrease).setOnClickListener {
            state = state?.copy(count = (state?.count ?: 0) - 1)
            updateCountText()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_COUNTER, state)
    }

    private fun updateCountText() {
        counterTextView.text = "Count: " + state?.count?.toString().orEmpty()
    }

    companion object {
        private const val KEY_COUNTER = "KEY_COUNTER"
    }
}