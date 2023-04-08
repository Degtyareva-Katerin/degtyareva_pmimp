package com.example.lab2_discriminant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.*
import java.text.DecimalFormat
import java.math.RoundingMode
import android.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var valueA: TextView = findViewById(R.id.a_coef) as TextView;
        var valueB: TextView = findViewById(R.id.b_coef) as TextView;
        var valueC: TextView = findViewById(R.id.c_coef) as TextView;
        var button: Button = findViewById(R.id.btn) as Button;
        var result_info: TextView? = null
        result_info=findViewById(R.id.textView2)
        fun sqr(x: Double): Double = x * x
        fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - (4 * a * c)
        fun quadraticEquationRoot(a: Double, b: Double, c: Double): Double {

                var df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.DOWN //округление
                val sd: Double = sqrt(discriminant(a, b, c))
                var x1 = (-b + sd) / (2 * a)
                var x2 = (-b - sd) / (2 * a)
                if (a == 0.0 && b != 0.0) {
                    x1 = -c/b
                    val valX1 = df.format(x1)
                    var editTxt="Линейное уравнение \n x1 = $valX1"
                    result_info?.text =editTxt.toString()
                }
                else if (a == 0.0 && b == 0.0 && c == 0.0){
                    var editTxt="При любых значениях x будет верное равенство"
                    result_info?.text =editTxt.toString()
                }
                else if (discriminant(a, b, c) < 0){
                    var editTxt="Корней нет"
                    result_info?.text =editTxt.toString()
                }
                else if (a == 0.0 && b == 0.0 && c != 0.0){
                    val x = (-b + sqrt(discriminant(a, b, c))) / (2 * a)
                    var editTxt="Корней нет"
                    result_info?.text =editTxt.toString()
                }
                else if (discriminant(a, b, c) == 0.0){
                    val x = (-b - sqrt(discriminant(a, b, c))) / (2 * a)
                    var editTxt="Уравнение имеет 2 корня x1 = x2 = $x "
                    result_info?.text =editTxt.toString()
                }
                else{
                    val valX1 = df.format(x1)
                    val valX2 = df.format(x2)
                    var editTxt="Уравнение имеет 2 корня \n  x1 = $valX1 x2 = $valX2 "
                    result_info?.text =editTxt.toString()
                }
            return 1.0
        }
        button.setOnClickListener{
            quadraticEquationRoot(valueA.text.toString().toDouble(),
                valueB.text.toString().toDouble(), valueC.text.toString().toDouble())
        });
 */
        }

    }

