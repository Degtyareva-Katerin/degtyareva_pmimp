package com.example.lab3_version2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn_0: TextView = findViewById(R.id.btn_0) as TextView;
        var btn_1: TextView = findViewById(R.id.btn_1) as TextView;
        var btn_2: TextView = findViewById(R.id.btn_2) as TextView;
        var btn_3: TextView = findViewById(R.id.btn_3) as TextView;
        var btn_4: TextView = findViewById(R.id.btn_4) as TextView;
        var btn_5: TextView = findViewById(R.id.btn_5) as TextView;
        var btn_6: TextView = findViewById(R.id.btn_6) as TextView;
        var btn_7: TextView = findViewById(R.id.btn_7) as TextView;
        var btn_8: TextView = findViewById(R.id.btn_8) as TextView;
        var btn_9: TextView = findViewById(R.id.btn_9) as TextView;

        var btn_minus: TextView = findViewById(R.id.btn_minus) as TextView;
        var btn_plus: TextView = findViewById(R.id.btn_plus) as TextView;
        var btn_procent: TextView = findViewById(R.id.btn_procent) as TextView;
        var btn_del: TextView = findViewById(R.id.btn_del) as TextView;
        var btn_mult: TextView = findViewById(R.id.btn_mult) as TextView;
        var btn_res: TextView = findViewById(R.id.btn_res) as TextView;
        var btn_ac: TextView = findViewById(R.id.btn_ac) as TextView;
        var btn_znak: TextView = findViewById(R.id.btn_znak) as TextView;
        var btn_zap: TextView = findViewById(R.id.btn_zap) as TextView;
        var result_text: TextView = findViewById(R.id.result_text) as TextView;

        var num1 = 0.0;
        var num2 = 0.0;
        var znak = "";
        var check_text= "";

        fun setTextField(str: String){
            val res_txt = findViewById<TextView>(R.id.result_text).text.toString();
            if (check_text == "" && (res_txt != "0" || str == ".")) {
                result_text.text = res_txt+str
            }
            else{
                result_text.text = str
                check_text = ""
            }
        }

        btn_0.setOnClickListener{ setTextField("0") }
        btn_1.setOnClickListener{ setTextField("1") }
        btn_2.setOnClickListener{ setTextField("2") }
        btn_3.setOnClickListener{ setTextField("3") }
        btn_4.setOnClickListener{ setTextField("4") }
        btn_5.setOnClickListener{ setTextField("5") }
        btn_6.setOnClickListener{ setTextField("6") }
        btn_7.setOnClickListener{ setTextField("7") }
        btn_8.setOnClickListener{ setTextField("8") }
        btn_9.setOnClickListener{ setTextField("9") }

        fun smena_znak(str: String){
            num1 = result_text.text.toString().toDouble()
            znak = str
            check_text = str
        }
        btn_minus.setOnClickListener{ smena_znak("-") }
        btn_plus.setOnClickListener{ smena_znak("+") }
        btn_mult.setOnClickListener{ smena_znak("*") }
        btn_del.setOnClickListener{ smena_znak("/") }

        btn_zap.setOnClickListener{
            if (!("." in result_text.text.toString())){
                setTextField(".")
            }
        }
        btn_procent.setOnClickListener {
            if (result_text.text != "0" && result_text.text != "Ошибка!"){
                result_text.text = (result_text.text.toString().toDouble() / 100).toString();
            }
        }
        btn_znak.setOnClickListener {
            val c = -1*result_text.text.toString().toDouble()
            result_text.text = CheckforInt(c).toString()
        }

        btn_res.setOnClickListener{
            try {
                if (znak == "+"){
                    num2 = result_text.text.toString().toDouble()
                    var num_res = num1+num2
                    result_text.text = CheckforInt(num_res).toString();
                    znak = "="
                    check_text = "="
                }
                else if (znak == "-"){
                    num2 = result_text.text.toString().toDouble()
                    var num_res = num1-num2
                    result_text.text = CheckforInt(num_res).toString();
                    znak = "="
                    check_text = "="
                }else if (znak == "*"){
                    num2 = result_text.text.toString().toDouble()
                    var num_res = num2*num1
                    result_text.text = CheckforInt(num_res).toString();
                    znak = "="
                    check_text = "="
                }else if (znak == "/"){
                    num2 = result_text.text.toString().toDouble()
                    if (num2==0.0 && num1!=0.0){
                        result_text.text = "Ошибка!";
                        znak = "="
                        check_text = "="
                    }else {
                        var num_res = num1 / num2
                        result_text.text = CheckforInt(num_res).toString();
                        znak = "="
                        check_text = "="
                    }
                }else{
                    result_text.text = "Ошибка!";
                    znak = "="
                    check_text = "="
                }
            }
            catch (e: Exception){
                result_text.text = "Ошибка!";
                znak = "="
                check_text = "="
            }
        }
        btn_ac.setOnClickListener{
            result_text.text = "0"
        }

    }
    fun CheckforInt(double: Double): Any {
        return if(double == double.roundToInt().toDouble()){
            double.roundToInt()
        }else{
            double
        }
    }
}