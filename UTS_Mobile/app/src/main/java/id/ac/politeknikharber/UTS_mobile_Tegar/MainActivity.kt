package id.ac.politeknikharber.UTS_mobile_Tegar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.politeknikharber.UTS_mobile_Tegar.about.TentangUTS
import id.ac.politeknikharber.UTS_mobile_Tegar.calculator.Calculator
import id.ac.politeknikharber.UTS_mobile_Tegar.menu.AdapterMenuApp
import id.ac.politeknikharber.UTS_mobile_Tegar.menu.IsiMenuApp
import id.ac.politeknikharber.UTS_mobile_Tegar.menu.MenuApp


class MainActivity : AppCompatActivity() {

    private lateinit var rv :RecyclerView
    private lateinit var viewManger:RecyclerView.LayoutManager
    private lateinit var viewAdapter:RecyclerView.Adapter<*>
    val isi:ArrayList<MenuApp> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv_menu)
        isi.addAll(IsiMenuApp.data)
        viewManger = GridLayoutManager(this, 2)
        viewAdapter = AdapterMenuApp(isi)

        rv.apply {
            layoutManager = viewManger
            adapter = viewAdapter

            (viewAdapter as AdapterMenuApp).setOnItemClickCallback(object:AdapterMenuApp.OnItemClickCallback{
                override fun onItemClicked(menuApp: MenuApp) {
                    pindahHalaman(menuApp)
                }
            })
        }
    }

    private fun pindahHalaman(menuApp: MenuApp){
        when(menuApp.nama){
            "Calculator"->{
                val intent = Intent(this, Calculator::class.java)
                startActivity(intent)
            }
            "information" -> {
                val intent = Intent(this, TentangUTS::class.java)
                startActivity(intent)
            }
            "Close" -> finish()
        }
    }
}