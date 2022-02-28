package ru.axout.savestate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.axout.savestate.parcelable.ParcelableActivity
import ru.axout.savestate.save_state.SaveStateActivity
import ru.axout.savestate.viewmodel.ViewModelActivity
import timber.log.Timber

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("hello timber")

        findViewById<Button>(R.id.bt_saveInstanceState).setOnClickListener{
            val intent = Intent(this, SaveStateActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.bt_parcelable).setOnClickListener {
            val intent = Intent(this, ParcelableActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.bt_viewModel).setOnClickListener {
            val intent = Intent(this, ViewModelActivity::class.java)
            startActivity(intent)
        }
    }
}