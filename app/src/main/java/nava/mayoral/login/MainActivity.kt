package nava.mayoral.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val USUARIO_REGISTRADO ="Nava"
    val PASS_USUARIO = "aguado"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIngresar.setOnClickListener(){
            //Obteniendo los datos de la vista
            val usuario = editTextUsuario.text.toString()
            val pass = editTextPassword.text.toString()

            if (!cadenaVacia(usuario) and !cadenaVacia(pass)){
                if (verificarDatos(usuario,pass)){
                    mensaje("Bienvenido")
                } else{
                    mensaje("Datos Incorrectos")
                }  //verificar los datos

            }
            else{
                //Mensaje de datos vacios
                mensaje("Datos vacios")
            }
        }
    }

    fun verificarDatos(usuario:String, pass:String):Boolean{
        return  usuario.equals(USUARIO_REGISTRADO) and pass.equals(PASS_USUARIO)
    }
    /*Metodo que nos ayuda a mostrar toasts*/
    fun mensaje(mensaje:String){//Mostrar mensajes
        Toast.makeText(this,mensaje, Toast.LENGTH_LONG).show()
    }
    /*Metodo para verificar que una cadena este vacia */
    fun cadenaVacia(cadenaVerificar:String):Boolean{
        return cadenaVerificar.isEmpty()
    }

    /*
    * 1 leer uusuario
    * 2 leer contraseña
    * 3 Verificar que no esten vacios
    * 4 comprar el usuario con un usuario permitido
    * 5 comparar la contraseña con la contraaseña del usuario
    * 6 si los datos son correctos damos un mensaje de bienvenida
    * de lo contrario, pedimos nuevamente los datos.*/
}
