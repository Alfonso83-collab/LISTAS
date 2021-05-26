package com.example.animales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //creando arreglo de elementos
        var animales:ArrayList<Animales> = ArrayList()

        animales.add(Animales("Perro:"+"\n"+"Es un animal cuadrúpedo y mamífero que pertenece a la familia de los caninos.",R.drawable.perro))
        animales.add(Animales("Gato:"+"\n"+"Se trata de un mamífero de contextura pequeña, carnívoro y cuyos rasgos salientes son: cabeza redonda, lengua áspera, patas cortas, uñas importantes, filosas y retráctiles, abundante pelaje y más bien suave,",R.drawable.gato))
        animales.add(Animales("Conejo"+"\n"+"Se caracteriza por tener un cuerpo cubierto de un pelaje espeso y lanudo, de color pardo pálido a gris, cabeza ovalada y ojos grandes. ",R.drawable.conejo))
        animales.add(Animales("Borrego"+"\n"+"Su estatura promedio es de 60-80 cm. a un metro, producen grandes cantidades de fibra de lana, su peso es acorde a la altura del animal.", R.drawable.borrego))
        animales.add(Animales("Burro"+"\n"+"Es empleado como animal de compañía o incluso como atracción turística. Una de las cosas que se suelen desconocer es que el burro es un animal en peligro de extinción.",R.drawable.burro))
        animales.add(Animales("Caballo"+"\n"+"Es animal doméstico tiene una cabeza amplia, cuello largo y grueso, cola larga y peluda, orejas cortas y erguidas y patas relativamente largas, que terminan en pezuñas.",R.drawable.caballo))
        animales.add(Animales("Pollo"+"\n"+"Este animal, domesticado, suele ser criado para aprovechar su carne y los huevos que ponen las gallinas.",R.drawable.pollo))
        animales.add(Animales("Cerdo"+"\n"+"Tiene un cuerpo pesado y redondeado, hocico comparativamente largo y flexible, patas cortas con pezuñas (cuatro dedos) y una cola corta.",R.drawable.cerdo))


        val lista1 = findViewById<ListView>(R.id.lista1)

        //val adaptador = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, frutas)
        val adaptador = Adaptor(this,animales)
        lista1.adapter = adaptador

        //configurar nuestro listener de la lista
        lista1.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, animales.get(position).nombre, Toast.LENGTH_SHORT).show()
        }
    }
}