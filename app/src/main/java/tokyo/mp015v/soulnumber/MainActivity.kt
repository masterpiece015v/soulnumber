package tokyo.mp015v.soulnumber

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        var soulnumber : Int = 0
        var birthday : String? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Viewの変数化
        val btn_birthday = findViewById<Button>(R.id.btn_birthday)
        val btn_comp = findViewById<Button>(R.id.btn_comp)
        val txt_birthday = findViewById<TextView>(R.id.txt_birthday)
        val txt_soulnumber = findViewById<TextView>(R.id.txt_soulnumber)

        //イベント登録
        btn_birthday.setOnClickListener {
            val dialog = DatePickerDialog(
                    this,
                    {view, year, month, dayOfMonth ->
                        txt_birthday.text = "誕生日:${year}年${month+1}月${dayOfMonth}日"
                        //ソウルナンバーの算出
                        val strbirthday = year.toString()+(month+1).toString()+dayOfMonth
                        strbirthday.forEach{
                            soulnumber = soulnumber + (it.toInt() - 48)
                        }
                        txt_soulnumber.text = "ソウルナンバー:${soulnumber}"
                    },2000,1,1
            )
            dialog.show()
        }

        btn_comp.setOnClickListener {


        }
    }
}
