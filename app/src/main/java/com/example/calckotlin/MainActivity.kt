package com.example.calckotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zeroButton.setOnClickListener { setTextFields("0") }
        openButton.setOnClickListener{ setTextFields("(")}
        closeButton.setOnClickListener{ setTextFields(")")}
        divideButton.setOnClickListener{ setTextFields("/")}
        sevenButton.setOnClickListener{ setTextFields("7")}
        eightButton.setOnClickListener{ setTextFields("8")}
        nineButton.setOnClickListener{ setTextFields("9")}
        multiplyButton.setOnClickListener{ setTextFields("*")}
        fourButton.setOnClickListener{ setTextFields("4")}
        fiveButton.setOnClickListener{ setTextFields("5")}
        sixButton.setOnClickListener{ setTextFields("6")}
        plusButton.setOnClickListener{ setTextFields("+")}
        oneButton.setOnClickListener{ setTextFields("1")}
        twoButton.setOnClickListener{ setTextFields("2")}
        threeButton.setOnClickListener{ setTextFields("3")}
        minusButton.setOnClickListener{ setTextFields("-")}
        dotButton.setOnClickListener{ setTextFields(".")}
        zeroButton.setOnClickListener{ setTextFields("0")}
        backButton.setOnClickListener{
            val str = mathOperationTextView.text.toString();
            if (str.isNotEmpty()){
                mathOperationTextView.text = str.substring(0, str.length - 1)
            }
            resultTextView.text = ""
        }
        acButton.setOnClickListener{ mathOperationTextView.text = ""
        resultTextView.text = ""}

        equalButton.setOnClickListener{
            try {
               val ex = ExpressionBuilder(mathOperationTextView.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble()){
                    resultTextView.text = longRes.toString()
                } else {
                    resultTextView.text = result.toString()
                }
            } catch (e: Exception){
                Log.d("Error", "message: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        if (resultTextView.text.isNotEmpty()){
            mathOperationTextView.text = resultTextView.text
        } 
        mathOperationTextView.append(str)
    }
}