package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.ConfigurationCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            //TODO: Get all inputs from user and perform calculations
            //TODO: Add validation using function
            //calculateLoan()

            val carPrice = editTextCarPrice.text.toString().toInt()
            val downPayment = editTextDownPayment.text.toString().toInt()
            val loanPeriod = editTextLoanPeriod.text.toString().toInt()
            val interestRate = editTextInterestRate.text.toString().toFloat()

            val loan = carPrice - downPayment
            val interest = loan * interestRate * loanPeriod
            val monthlyRepayment = (loan + interest)/loanPeriod/12
            val currentLocale =  ConfigurationCompat.getLocales(resources.configuration)[0]
            //TODO Display the outputs
            textViewLoan.setText(getString(R.string.loan) + "${Currency.getInstance(currentLocale).getSymbol() + loan}")//a part of reference to variable like JSP
            textViewInterest.setText(getString(R.string.interest) + "${interest}")
            textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${Currency.getInstance(currentLocale).getSymbol() + monthlyRepayment}")
        }
    }
    fun calculateLoan(){

    }
    fun resetInput(view: View) {
        //TODO: Clear all inputs and outputs
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        textViewInterest.setText(R.string.interest)
        textViewLoan.setText(R.string.loan)
        textViewMonthlyRepayment.setText(R.string.monthly_repayment)
    }
}