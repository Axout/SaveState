
package ru.axout.savestate.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import ru.axout.savestate.R

class ViewModelActivity : AppCompatActivity(R.layout.activity_save_state) {

    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<TextView>(R.id.tv_title).text = "This is ViewModel Activity"

        findViewById<Button>(R.id.bt_increase).setOnClickListener {
            viewModel.incrementCount()
        }

        findViewById<Button>(R.id.bt_decrease).setOnClickListener {
            viewModel.decrementCount()
        }

        viewModel.state.observe(this) { state ->
            findViewById<TextView>(R.id.tv_count).text = "Count " + state.count.toString()
        }
    }
}