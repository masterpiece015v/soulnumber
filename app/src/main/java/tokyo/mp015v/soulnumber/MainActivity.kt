package tokyo.mp015v.soulnumber

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

//グローバル関数
fun getSoulNumber( year:Int,month:Int,dayOfWeek:Int):Int{
    val str_birthday = year.toString() + month.toString() + dayOfWeek.toString()
    return getSoulNumber(str_birthday)
}

fun getSoulNumber( str_birthday : String):Int{
    var tempsoulnum = 0
    str_birthday.forEach{
        tempsoulnum = tempsoulnum + (it.toInt() - 48)
    }
    //ぞろ目以外で10以上
    if( tempsoulnum % 11 != 0 && tempsoulnum >= 10){
        tempsoulnum = tempsoulnum / 10 + tempsoulnum % 10
    }
    //それでも10以上
    if( tempsoulnum % 11 != 0 && tempsoulnum >= 10 ){
        tempsoulnum = tempsoulnum /10 + tempsoulnum % 10
    }

    return tempsoulnum
}

class MainActivity : AppCompatActivity() {
    companion object {
        var soulnumber : Int = 0
        var birthday : String? = null

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Viewの変数化
        val btn_birthday = findViewById(R.id.btn_birthday) as Button
        val btn_comp = findViewById(R.id.btn_comp) as Button
        val btn_personal = findViewById(R.id.btn_personal) as Button
        val txt_birthday = findViewById(R.id.txt_birth) as TextView
        val txt_soulnumber = findViewById(R.id.txt_soulnum2) as TextView

        //イベント登録
        btn_birthday.setOnClickListener {

            val dialog = DatePickerDialog(
                    this,
                    {view, year, month, dayOfMonth ->
                        txt_birthday.text = "誕生日:${year}年${month+1}月${dayOfMonth}日"

                        soulnumber = getSoulNumber( year,month+1,dayOfMonth )

                        txt_soulnumber.text = "ソウルナンバー:${soulnumber}"
                    },2000,1,1
            )
            dialog.show()
        }

        //気になるあの人と
        btn_comp.setOnClickListener {
            val intent = Intent(applicationContext,Main2Activity::class.java)
            startActivity( intent )
        }

        //あなたの性格
        btn_personal.setOnClickListener {
            val intent = Intent(applicationContext,Main3Activity::class.java)
            startActivity( intent )

        }
    }
}
