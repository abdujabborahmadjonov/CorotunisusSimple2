package dev.abdujabbor.kotlincorotunius

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.abdujabbor.kotlincorotunius.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        GlobalScope.launch(Dispatchers.Main) {

            val a1 = randomNumber()
            binding.textview.text = a1.toString()
            val a2 = randomNumber()
            binding.textview.text = a2.toString()
            val a3 = randomNumber()
            binding.textview.text = a3.toString()
            val a4 = randomNumber()
            binding.textview.text = a4.toString()
            val a5 = randomNumber()
            binding.textview.text = a5.toString()
            val a =(a1+a2+a3+a4+a5)/5
            binding.textview.text = "$a= $a1+ $a2 +$a3 +$a4 +$a5 /5"
        }
    }

    suspend fun randomNumber(): Int {

        return GlobalScope.async(Dispatchers.IO) {
            Thread.sleep(3000)
            Random.nextInt(1000)

        }.await()
    }
}