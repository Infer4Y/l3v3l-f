package inferno.l3v3l_f.client

import inferno.l3v3l_f.client.gui.Window
import java.util.*

import kotlin.concurrent.schedule

object Run {
    @kotlin.jvm.JvmField
    var window : Window = Window("Game")

    var timer = Timer()
    var timer1 = Timer()
    var fps = 0

    fun late(){
        timer.schedule(1000/60) {
            window.draw()
            fps++
            late()
        }
    }

    fun title(){
        window.title = "Game | FPS: $fps"
        fps = 0
        timer1.schedule(1000) {
            title()
        }
    }

    @JvmStatic
    fun main(args: Array<String>){
        late()
        title()
    }
}