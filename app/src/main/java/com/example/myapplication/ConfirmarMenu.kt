package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class ConfirmarMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar_menu)
        edtDetallePedido.setText(intent.extras!!["DetallePedido"]!!.toString())
        edtCosto.setText(intent.extras!!["Costo"]!!.toString())
        edtDescuento.setText(intent.extras!!["Descuento"]!!.toString())
        edtTotal.setText(intent.extras!!["Total"]!!.toString())
        edtTotalPagar.setText(intent.extras!!["TotalPagar"]!!.toString())
    }
}
