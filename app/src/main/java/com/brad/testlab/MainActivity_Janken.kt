package com.brad.testlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_lab_janken.*
import kotlin.math.pow

class MainActivity_Janken : AppCompatActivity(), View.OnClickListener,
    RadioGroup.OnCheckedChangeListener {
    private val JANKEN_ROCK = 0
    private val JANKEN_PAPER = 1
    private val JANKEN_SCISSORS = 2

    var janken = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_lab_janken)
        radioGroup.setOnCheckedChangeListener(this)
        btn_janken.setOnClickListener(this)
        radioGroup.clearCheck()

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btn_janken.id -> {
                radioGroup.clearCheck()
                if (janken == -1) {
                    tv_end.text = "請選擇要出的拳"

                } else if (et_name.text.isEmpty()) {
                    tv_end.text = "請輸入玩家姓名"

                } else if(janken == JANKEN_ROCK) {
                    judgment(JANKEN_SCISSORS, janken)

                } else if(janken == JANKEN_SCISSORS) {
                    judgment(JANKEN_PAPER, janken)

                } else if(janken == JANKEN_PAPER) {
                    judgment(JANKEN_ROCK, janken)

                }
            }

        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (group?.id) {
            radioGroup.id -> {
                when (checkedId) {
                    radioButton.id -> {
                        janken = JANKEN_SCISSORS
                    }
                    radioButton2.id -> {
                        janken = JANKEN_ROCK
                    }
                    radioButton3.id -> {
                        janken = JANKEN_PAPER
                    }

                }
            }
        }

    }

    fun judgment(computer: Int, self: Int) {
        val name = et_name.text;
        when (computer) {
            JANKEN_ROCK -> {
                if (self == JANKEN_ROCK) {
                    tv_end.text = "平手 電腦: 石頭, $name: 石頭 "
                }else  if (self == JANKEN_PAPER) {
                    tv_end.text = "$name 勝 電腦: 石頭, $name: 布 "
                }else  if (self == JANKEN_SCISSORS) {
                    tv_end.text = "$name 敗 電腦: 石頭, $name: 剪刀 "
                }
            }
            JANKEN_PAPER -> {
                if (self == JANKEN_ROCK) {
                    tv_end.text = "$name 敗 電腦: 布, $name: 石頭 "
                }else  if (self == JANKEN_PAPER) {
                    tv_end.text = "平手 電腦: 布, $name: 布 "
                }else  if (self == JANKEN_SCISSORS) {
                    tv_end.text = "$name 勝 電腦: 布, $name: 剪刀 "
                }
            }
            JANKEN_SCISSORS -> {
                if (self == JANKEN_ROCK) {
                    tv_end.text = "$name 勝 電腦: 剪刀, $name: 石頭 "
                }else  if (self == JANKEN_PAPER) {
                    tv_end.text = "$name 敗 電腦: 剪刀, $name: 布 "
                }else  if (self == JANKEN_SCISSORS) {
                    tv_end.text = "平手 電腦: 剪刀, $name: 剪刀 "
                }
            }
        }
    }

}

