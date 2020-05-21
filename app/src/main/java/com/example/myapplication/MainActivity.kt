package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var Costo:Double=0.0;
    var Cantidad:Double=0.0;
    var Total:Double=0.0;
    var Descuento:Double=0.0;
    var TotalPagar:Double=0.0;
    var CostoDelivery:Double=0.0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun CalcularTotales():Boolean
    {
        if (edtCosto.text.isEmpty()||edtCosto.text.equals("0"))
        {
            Toast.makeText(baseContext,"Por favor ingresar el costo",Toast.LENGTH_LONG).show()
            return false
        }
        if (edtCantidad.text.isEmpty()||edtCantidad.text.equals("0"))
        {
            Toast.makeText(baseContext,"Por favor ingresar la cantidad",Toast.LENGTH_LONG).show()
            return false
        }
        Costo=edtCosto.text.toString().toDouble()
        Cantidad=edtCantidad.text.toString().toDouble()
        Total=Costo*Cantidad

        if (Total > 200 && Total<500)
        {
            Descuento = Total*0.05
        }
        else if(Total>=500 && Total<1000){
            Descuento = Total*0.10
        }
        else{
            Descuento = Total*0.12
        }
        if (chkDelivery.isChecked)
        {
            CostoDelivery=20.0
        }
        TotalPagar=(Total-Descuento)+CostoDelivery
        return true;
    }
    public fun btnCalcularClick(v:View){
        if (CalcularTotales()){
            //Mostrar los datos calculados
            edtTotal.setText(Total.toString())
            edtDescuento.setText(Descuento.toString())
            edtTotalPagar.setText(TotalPagar.toString())
        }
    }
    public fun imprimir(v:View){
        if (CalcularTotales()){
            //Mostrar los datos calculados
            edtTotal.setText(Total.toString())
            edtDescuento.setText(Descuento.toString())
            edtTotalPagar.setText(TotalPagar.toString())
        }
        var oVentanaImprimir:Intent=Intent(this,ConfirmarMenu::class.java)
        oVentanaImprimir.putExtra("DetallePedido", edtDetallePedido.text)
        oVentanaImprimir.putExtra("Costo", edtCosto.text)
        oVentanaImprimir.putExtra("Cantidad", edtCantidad.text)
        oVentanaImprimir.putExtra("Total", edtTotal.text)
        oVentanaImprimir.putExtra("Descuento", edtDescuento.text)
        oVentanaImprimir.putExtra("Delivery", CostoDelivery.toString())
        oVentanaImprimir.putExtra("TotalPagar", edtTotalPagar.text)

        startActivity(oVentanaImprimir)
    }
}
