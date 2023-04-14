package com.example.tema_1_dam

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_onscreen1 = findViewById<Button>(R.id.button_istoric)
        val history = findViewById<EditText>(R.id.history)
        var historyLines: MutableList<String> = mutableListOf()
        var token = 0;
        var button_select_baza = findViewById<Button>(R.id.button_selectare_baza)
        var token_baza = 16;
        val buttonA = findViewById<Button>(R.id.buttonA)
        val buttonB = findViewById<Button>(R.id.buttonB)
        val buttonC = findViewById<Button>(R.id.buttonC)
        val buttonD = findViewById<Button>(R.id.buttonD)
        val buttonE = findViewById<Button>(R.id.buttonE)
        val buttonF = findViewById<Button>(R.id.buttonF)



        var baraText = findViewById<TextView>(R.id.bara_text_sus)
        var baraText2 = findViewById<TextView>(R.id.bara_text_sus_2)


        var token_screen2 = intent.getStringExtra("token")
        if(token_screen2 == "1") {
            baraText.text = intent.getStringExtra("bara1")
            baraText2.text = intent.getStringExtra("bara2")
            history.setText(intent.getStringExtra("istoric"))
            token_screen2 = "0"
        }


        // SELECTARE BAZA IMPLEMENTARE (10 / 16)


        fun decimalToHexadecimal(decimal: Int): String {
            var n = decimal
            var hexadecimal = ""
            while (n > 0) {
                val remainder = n % 16
                hexadecimal = when {
                    remainder < 10 -> "$remainder$hexadecimal"
                    remainder == 10 -> "A$hexadecimal"
                    remainder == 11 -> "B$hexadecimal"
                    remainder == 12 -> "C$hexadecimal"
                    remainder == 13 -> "D$hexadecimal"
                    remainder == 14 -> "E$hexadecimal"
                    remainder == 15 -> "F$hexadecimal"
                    else -> hexadecimal
                }
                n /= 16
            }
            return hexadecimal
        }

// Inside the button click listener
        button_select_baza.setOnClickListener {
            if (token_baza == 10) {

                if(baraText.text != "") {
                    baraText.text =
                        decimalToHexadecimal(baraText.text.toString().toIntOrNull() ?: 0)
                }
                if(baraText2.text != "") baraText2.text = decimalToHexadecimal(baraText2.text.toString().toIntOrNull() ?: 0)

                token_baza = 16
                val valoareNoua = "selectare baza 16"
                // Update the historyLines list with the new value
                historyLines.add(valoareNoua)

                // Set the color of the specific line to red
                val start = history.text.length
                val end = start + valoareNoua.length
                val spannable = SpannableStringBuilder(valoareNoua)
                spannable.setSpan(
                    ForegroundColorSpan(Color.MAGENTA),
                    0,
                    valoareNoua.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                history.append("\n")
                history.append(spannable)

                button_select_baza.text = "BAZA-16"
                button_select_baza.setBackgroundColor(Color.MAGENTA)
                Toast.makeText(this@MainActivity, "Baza 16", Toast.LENGTH_SHORT).show()
            } else {
                token_baza = 10
                if(baraText.text != "") {
                    baraText.text = Integer.parseInt(baraText.text.toString(), 16).toString()
                }
                if(baraText2.text != "") baraText2.text = Integer.parseInt(baraText2.text.toString(), 16).toString()
                val valoareNoua = "selectare baza 10"

                // Update the historyLines list with the new value
                historyLines.add(valoareNoua)

                // Set the color of the specific line to green
                val start = history.text.length
                val end = start + valoareNoua.length
                val spannable = SpannableStringBuilder(valoareNoua)
                spannable.setSpan(
                    ForegroundColorSpan(Color.GREEN),
                    0,
                    valoareNoua.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                history.append("\n")
                history.append(spannable)

                button_select_baza.text = "BAZA-10"
                button_select_baza.setBackgroundColor(Color.GREEN)
                Toast.makeText(this@MainActivity, "Baza 10", Toast.LENGTH_SHORT).show()
            }




            if (token_baza == 10) {
                buttonA.visibility = View.INVISIBLE
                buttonB.visibility = View.INVISIBLE
                buttonC.visibility = View.INVISIBLE
                buttonD.visibility = View.INVISIBLE
                buttonE.visibility = View.INVISIBLE
                buttonF.visibility = View.INVISIBLE
            } else if (token_baza == 16) {
                buttonA.visibility = View.VISIBLE
                buttonB.visibility = View.VISIBLE
                buttonC.visibility = View.VISIBLE
                buttonD.visibility = View.VISIBLE
                buttonE.visibility = View.VISIBLE
                buttonF.visibility = View.VISIBLE
            }
        }



        val button1 = findViewById<Button>(R.id.button1)

        button1.setOnClickListener {

            if (token == 0) {
                baraText.setText(baraText.text.toString() + button1.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button1.text.toString())
            }

        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + button2.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button2.text.toString())
            }
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + button3.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button3.text.toString())
            }
        }

        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + button4.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button4.text.toString())
            }
        }

        val button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + button5.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button5.text.toString())
            }
        }

        val button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + button6.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button6.text.toString())
            }
        }

        val button7 = findViewById<Button>(R.id.button7)
        button7.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + button7.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button7.text.toString())
            }
        }

        val button8 = findViewById<Button>(R.id.button8)
        button8.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + button8.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button8.text.toString())
            }
        }

        val button9 = findViewById<Button>(R.id.button9)
        button9.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + button9.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + button9.text.toString())
            }
        }

        val button0 = findViewById<Button>(R.id.button0)
        button0.setOnClickListener {
            if (token == 0) {
                if(baraText.text != "") {
                    baraText.setText(baraText.text.toString() + button0.text.toString())
                }
            } else {
                if(baraText.text != "") {
                    baraText2.setText(baraText2.text.toString() + button0.text.toString())
                }
            }
        }


        buttonA.setOnClickListener {

            if (token == 0) {
                baraText.setText(baraText.text.toString() + buttonA.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + buttonA.text.toString())
            }
        }


        buttonB.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + buttonB.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + buttonB.text.toString())
            }
        }


        buttonC.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + buttonC.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + buttonC.text.toString())
            }
        }


        buttonD.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + buttonD.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + buttonD.text.toString())
            }
        }

        buttonE.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + buttonE.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + buttonE.text.toString())
            }
        }

        buttonF.setOnClickListener {
            if (token == 0) {
                baraText.setText(baraText.text.toString() + buttonF.text.toString())
            } else {
                baraText2.setText(baraText2.text.toString() + buttonF.text.toString())
            }
        }



        // history.setSelection(history.length())//placing cursor at the end of the text


        // buton BACK functionalitate

        val buttonBack = findViewById<Button>(R.id.button_back)
        buttonBack.setOnClickListener {
            baraText.text = baraText.text.dropLast(1)
        }


        // IMPLEMENTARE OPERATII - ADUNARE +

        var operatie = "";
        var buton_operatie = findViewById<Button>(R.id.afisare_operatie)
        val buton_plus = findViewById<Button>(R.id.button_plus)
        val butonEgal = findViewById<Button>(R.id.button_selectare_egal)

        buton_plus.setOnClickListener {
            if (baraText.text.toString() != "" ) {
                token = 1
                operatie = "+"
                buton_operatie.text = "+"
            }
        }
            // implementare buton scadere -

            val buton_minus = findViewById<Button>(R.id.button_selectare_minus)

            buton_minus.setOnClickListener {
                if (baraText.text.toString() != "") {
                    token = 1
                    operatie = "-"
                    buton_operatie.text = "-"
                }
            }

            // implementare buton inmultire *

            val buton_inmultire = findViewById<Button>(R.id.button_inmultire)

            buton_inmultire.setOnClickListener {
                if (baraText.text.toString() != "") {
                    token = 1
                    operatie = "*"
                    buton_operatie.text = "*"
                }
            }



            // implementare buton egal =


            butonEgal.setOnClickListener {
                if (operatie == "+") {

                    var op1 = baraText.text.toString().toIntOrNull() ?: 0
                    var op2 = baraText2.text.toString().toIntOrNull() ?: 0
                    var result = op1 + op2
                    baraText.setText(result.toString())
                    if(token_baza == 16) {
                        val op1_converted = Integer.parseInt(op1.toString(), 16)
                        val op2_converted = Integer.parseInt(op2.toString(), 16)
                        val valoareNoua =  op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString()

                        // Update the historyLines list with the new value
                        historyLines.add(valoareNoua)

                        // Set the color of the specific line to red
                        val start = history.text.length
                        val end = start + valoareNoua.length
                        val spannable = SpannableStringBuilder(valoareNoua)
                        val pinkColor = Color.parseColor("#FFC0CB")
                        spannable.setSpan(

                            ForegroundColorSpan(Color.MAGENTA),
                            0,
                            valoareNoua.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        history.append("\n")
                        history.append(spannable)
                    } else if (token_baza == 10) {
                        val valoareNoua =  op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString()

                        // Update the historyLines list with the new value
                        historyLines.add(valoareNoua)


                        val start = history.text.length
                        val end = start + valoareNoua.length
                        val spannable = SpannableStringBuilder(valoareNoua)
                        spannable.setSpan(
                            ForegroundColorSpan(Color.GREEN),
                            0,
                            valoareNoua.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        history.append("\n")
                        history.append(spannable)
                    }
                    //history.setText(history.text.toString() + op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString() + "\n")
                }
                else if (operatie == "-") {
                    var op1 = baraText.text.toString().toIntOrNull() ?: 0
                    var op2 = baraText2.text.toString().toIntOrNull() ?: 0
                    var result = op1 - op2
                    baraText.setText(result.toString())
                    if(token_baza == 16) {
                        val valoareNoua =  op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString() + "\n"

                        // Update the historyLines list with the new value
                        historyLines.add(valoareNoua)

                        // Set the color of the specific line to red
                        val start = history.text.length
                        val end = start + valoareNoua.length
                        val spannable = SpannableStringBuilder(valoareNoua)
                        spannable.setSpan(
                            ForegroundColorSpan(Color.MAGENTA),
                            0,
                            valoareNoua.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        history.append("\n")
                        history.append(spannable)
                    } else if (token_baza == 10) {
                        val valoareNoua =  op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString() + "\n"

                        // Update the historyLines list with the new value
                        historyLines.add(valoareNoua)

                        // Set the color of the specific line to red
                        val start = history.text.length
                        val end = start + valoareNoua.length
                        val spannable = SpannableStringBuilder(valoareNoua)
                        spannable.setSpan(
                            ForegroundColorSpan(Color.GREEN),
                            0,
                            valoareNoua.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        history.append("\n")
                        history.append(spannable)
                    }
                    //history.setText(history.text.toString() + op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString() + "\n")

                }
                else if (operatie == "*") {

                    var op1 = baraText.text.toString().toIntOrNull() ?: 0
                    var op2 = baraText2.text.toString().toIntOrNull() ?: 0
                    var result = op1 * op2
                    baraText.setText(result.toString())
                    if(token_baza == 16) {
                        val valoareNoua =  op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString() + "\n"

                        // Update the historyLines list with the new value
                        historyLines.add(valoareNoua)

                        // Set the color of the specific line to red
                        val start = history.text.length
                        val end = start + valoareNoua.length
                        val spannable = SpannableStringBuilder(valoareNoua)
                        spannable.setSpan(
                            ForegroundColorSpan(Color.MAGENTA),
                            0,
                            valoareNoua.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        history.append("\n")
                        history.append(spannable)
                    } else if (token_baza == 10) {
                        val valoareNoua =  op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString() + "\n"

                        // Update the historyLines list with the new value
                        historyLines.add(valoareNoua)

                        // Set the color of the specific line to red
                        val start = history.text.length
                        val end = start + valoareNoua.length
                        val spannable = SpannableStringBuilder(valoareNoua)
                        spannable.setSpan(
                            ForegroundColorSpan(Color.GREEN),
                            0,
                            valoareNoua.length,
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        history.append("\n")
                        history.append(spannable)
                    }
                   // history.setText(history.text.toString() + op1.toString() + operatie.toString() + op2.toString() + butonEgal.text + result.toString() + "\n")

                }
               // history.setText(history.text.toString() + op1.toString() + operatie.toString() + op2.toString())

                baraText2.text = baraText.text.drop(999)
                token = 0

                operatie = ""
                buton_operatie.text = buton_operatie.text.drop(999)
            }


        button_onscreen1.setOnClickListener {
            val info = history.text.toString()
            val info_baraText1 = baraText.text.toString()
            val info_baraText2 = baraText2.text.toString()

            // Get the SpannableStringBuilder object with red or green lines


            // Convert the SpannableStringBuilder object to string


            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra("key", info) // Pass historyWithColorsString as string
            intent.putExtra("key1", info_baraText1)
            intent.putExtra("key2", info_baraText2)

            startActivity(intent)
        }





    }
}





