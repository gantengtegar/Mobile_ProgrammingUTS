package id.ac.politeknikharber.UTS_mobile_Tegar.menu

import id.ac.politeknikharber.UTS_mobile_Tegar.R

object IsiMenuApp {
    private val foto = intArrayOf(
        R.drawable.kalkulator,
        R.drawable.informasi,
        R.drawable.keluar
    )
    private val nama = arrayOf(

        "Calculator",
        "information",
        "Close"
    )

    val data:ArrayList<MenuApp>
        get() {
            val listGambar:ArrayList<MenuApp> = arrayListOf()
            for(i in foto.indices){
                val menuApp = MenuApp()
                menuApp.foto = foto[i]
                menuApp.nama = nama[i]
                listGambar.add(menuApp)
            }
            return listGambar
        }
}