package com.example.pregunta2

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R
import com.example.myapplication.adaptador.AdaptadorProveedor
import com.example.pregunta2.bean.ProveedorBean
import kotlinx.android.synthetic.main.activity_listado_proveedor.*
import java.util.ArrayList

class ListadoProveedor : AppCompatActivity() {

    lateinit var oListaproveedor:ArrayList<ProveedorBean>
    lateinit var oAdaptadorproveedor:AdaptadorProveedor
    lateinit var oDialog:Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_listado_proveedor)

        oListaproveedor=ArrayList<ProveedorBean>()
        oListaproveedor.add(ProveedorBean(0,"10716564814","CIBERTEC SAC","AV IZAGUIRRE"))
        oListaproveedor.add(ProveedorBean(0,"10716564814","METRO SAC","AV IZAGUIRRE"))

        oAdaptadorproveedor= AdaptadorProveedor(oListaproveedor.toList(),this)

        lvListaProveedor.adapter=oAdaptadorproveedor
    }
    public  fun CargarVentanaDialogo(v:View)
    {
        oDialog= Dialog(this)
        oDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        oDialog.setCancelable(false)
        oDialog.setContentView(R.layout.activity_nuevo_proveedor)
        val obtnagregarNuevoprov=oDialog.findViewById(R.id.btnagregarNuevoprov) as Button
        val obtncancelarNuevoprov=oDialog.findViewById(R.id.btncancelarNuevoprov) as Button

        obtnagregarNuevoprov.setOnClickListener {
            GrabarRegistro()
            oDialog.dismiss()}

        obtncancelarNuevoprov.setOnClickListener{oDialog.dismiss()
        }
        oDialog.show()
    }
    public  fun GrabarRegistro()
    {
     var oedtrucnuevo:EditText=(oDialog.findViewById(R.id.edtrucnuevo) as EditText)
       var oedtdireccionnuevo:EditText=(oDialog.findViewById(R.id.edtdireccionnuevo)as EditText)
        var oedtrazonsocialnuevo:EditText=(oDialog.findViewById(R.id.edtrazonsocialnuevo) as EditText)

        oListaproveedor.add(ProveedorBean(oListaproveedor.size,oedtrucnuevo.text.toString(),
        oedtdireccionnuevo.text.toString(),
        oedtrazonsocialnuevo.text.toString()))

        oAdaptadorproveedor= AdaptadorProveedor(oListaproveedor.toList(),this)
        lvListaProveedor.setAdapter(oAdaptadorproveedor)
    }
}
