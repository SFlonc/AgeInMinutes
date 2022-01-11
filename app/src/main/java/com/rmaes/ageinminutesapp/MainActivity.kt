package com.rmaes.ageinminutesapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rmaes.ageinminutesapp.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectDateBtn.setOnClickListener { view -> clickDatePicker(view) }
    }
    fun clickDatePicker(view:View){
        val myCalendar=Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, { view, selectedyear, selectedmonth, selecteddayOfMonth ->
            val selectedDate="$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
            binding.selectedDateTv.text=selectedDate
            var date=SimpleDateFormat("dd/MM/yyyy").parse(selectedDate)
            var today=Date()
            var inDays=(today.time - date.time)/86400000
            binding.ageInMinutesTv.setText("You are $inDays days old :)")
        },year, month,day).show()
    }
}