package com.example.snake

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_game.view.*
import java.util.*
import kotlin.concurrent.schedule
import android.os.Looper




class GameFragment : Fragment() {

    private lateinit var rootView: View
    private lateinit var gameView: GameFieldView

    private var x: Int = 0
    private var y: Int = 0

    private var prevX: Int = 0
    private var prevY: Int = 0

    init {
        val mainHandler = Handler(Looper.getMainLooper())

        mainHandler.post(object : Runnable {
            override fun run() {




                var r = Random().nextInt(7)
                if (r < 2 && x < 9)
                    x += 1
                else if (r < 4 && y < 9)
                    y += 1
                else if (r < 6 && x > 0)
                    x -= 1
                else if (r < 8&& y > 0)
                    y -= 1

                

                if (prevX == x && prevY == y) {
                    prevX = x
                    prevY = y
                } else {
                    gameView.setSnakePosition(arrayListOf(Pair(x, y)))
                    gameView.invalidate()
                }


                mainHandler.postDelayed(this, 100)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_game, container, false)
        gameView = rootView.gameView

        rootView.button1.setOnClickListener {

        }
//


        return rootView
    }
}