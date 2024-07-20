package com.dickbriabu.scheduler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.dickbriabu.scheduler.database.FarmEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TableFragment : Fragment() {
    private lateinit var tableLayout: TableLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.table_fragment, container, false)
        tableLayout = view.findViewById(R.id.table_layout)
        return view
    }

    fun updateTable(entries: List<FarmEntry>) {
        tableLayout.removeAllViews()

        // Add header row
        val headerRow = TableRow(requireContext())
        val headers = listOf("Farm Name", "Block Count", "Bushes Count")
        headers.forEach { header ->
            headerRow.addView(TextView(requireContext()).apply {
                text = header
                setPadding(8, 8, 8, 8)
            })
        }
        tableLayout.addView(headerRow)

        // Add data rows
        entries.forEach { entry ->
            val dataRow = TableRow(requireContext())
            listOf(entry.farmName, entry.blockCount.toString(), entry.bushesCount.toString()).forEach { data ->
                dataRow.addView(TextView(requireContext()).apply {
                    text = data
                    setPadding(8, 8, 8, 8)
                })
            }
            tableLayout.addView(dataRow)
        }
    }
}
