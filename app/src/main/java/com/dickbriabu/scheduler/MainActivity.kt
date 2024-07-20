package com.dickbriabu.scheduler

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.dickbriabu.scheduler.database.FarmDatabase
import com.dickbriabu.scheduler.database.FarmEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.room.RoomDatabase


class MainActivity : AppCompatActivity() {
    private lateinit var database: FarmDatabase
    private lateinit var farmNameEditText: EditText
    private lateinit var blockCountEditText: EditText
    private lateinit var bushesCountEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var tableFragment: TableFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        farmNameEditText = findViewById(R.id.et_farm_name)
        blockCountEditText = findViewById(R.id.et_block_count)
        bushesCountEditText = findViewById(R.id.et_bushes_count)
        saveButton = findViewById(R.id.btn_save)

        // Initialize database in coroutine
        lifecycleScope.launch {
            database = FarmDatabase.getDatabase(this@MainActivity)
            initFragment()
        }

        saveButton.setOnClickListener {
            saveEntry()
        }
    }

    private fun initFragment() {
        // Initialize and add the TableFragment
        tableFragment = TableFragment()
        supportFragmentManager.commit {
            replace(R.id.fragment_container, tableFragment)
        }
    }

    private fun saveEntry() {
        val farmName = farmNameEditText.text.toString()
        val blockCount = blockCountEditText.text.toString().toIntOrNull() ?: 0
        val bushesCount = bushesCountEditText.text.toString().toIntOrNull() ?: 0

        val entry = FarmEntry(farmName = farmName, blockCount = blockCount, bushesCount = bushesCount)

        lifecycleScope.launch(Dispatchers.IO) {
            if (::database.isInitialized) {
                database.farmEntryDao().insert(entry)
                withContext(Dispatchers.Main) {
                    clearInputFields()
                    loadEntries()
                }
            }
        }
    }

    private fun clearInputFields() {
        farmNameEditText.text.clear()
        blockCountEditText.text.clear()
        bushesCountEditText.text.clear()
    }

    private fun loadEntries() {
        lifecycleScope.launch(Dispatchers.IO) {
            if (::database.isInitialized) {
                val entries = database.farmEntryDao().getAllEntries()
                withContext(Dispatchers.Main) {
                    tableFragment.updateTable(entries)
                }
            }
        }
    }
}
