package com.example.homework5firebase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var EmailRegister : EditText
    private lateinit var PasswordRegister: EditText
    private lateinit var ButtonRegister2 : Button
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mAuth= FirebaseAuth.getInstance()

        EmailRegister=findViewById(R.id.EmailRegister)
        PasswordRegister=findViewById(R.id.PasswordRegister)
        ButtonRegister2=findViewById(R.id.buttonRegister2)

        ButtonRegister2.setOnClickListener {
            val email=EmailRegister.text.toString()
            val password=PasswordRegister.text.toString()

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"empty",Toast.LENGTH_SHORT).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener {task ->
                            if (task.isSuccessful){
                                val intent = intent
                                finish()
                                startActivity(intent)

                            }else{
                                Toast.makeText(this,"Error!",Toast.LENGTH_SHORT).show()

                            }
                        }

            }

        }


    }
}