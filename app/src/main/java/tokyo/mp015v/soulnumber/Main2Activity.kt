package tokyo.mp015v.soulnumber

import android.app.DatePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Button
import android.widget.TextView


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //ソウルナンバー
        var soulnum = 0

        //Viewを変数にする
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        val btn_birthday2 = findViewById(R.id.btn_birthday2) as Button
        val txt_birthday2 = findViewById(R.id.txt_birthday2) as TextView
        val txt_soulnum2 = findViewById(R.id.txt_soulnum2) as TextView
        val txt_soulnum3 = findViewById(R.id.txt_soulnum3) as TextView

        //戻るボタンの設定
        setSupportActionBar( toolbar )

        supportActionBar?.let{
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
        }?:IllegalAccessException("Toolber cannot be null")

        //自分のソウルナンバーを表示する

        txt_soulnum2.text = "あなたのソウルナンバー:${MainActivity.soulnumber}"

        //イベント
        btn_birthday2.setOnClickListener {
            soulnum = 0
            val dialog = DatePickerDialog(this,{view, year, month, dayOfMonth ->
                txt_birthday2.text = "相手の誕生日:${year}年${month+1}月${dayOfMonth}日"
                soulnum = getSoulNumber(year,month+1,dayOfMonth)
                txt_soulnum3.text = "相手のソウルナンバー:${soulnum}"
            },2000,1,1)

            dialog.show()
        }
    }
}
