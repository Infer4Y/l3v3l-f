package inferno.l3v3l_f.client

import inferno.l3v3l_f.client.gui.Window
import java.util.*

import kotlin.concurrent.schedule

object Run {
    @kotlin.jvm.JvmField
    var window : Window = Window("Game")

    var timer = Timer()
    var timer1 = Timer()
    var timer2 = Timer()
    var fps = 0
    var ticks = 0

    fun late(){
        timer.schedule(1000/60) {
            window.draw()
            fps++
            late()
        }
    }

    fun update(){
        timer2.schedule(1000/20) {
            window.update()
            ticks++
            update()
        }
    }

    fun title(){
        window.title = "Game | FPS: $fps | Ticks : $ticks"
        fps = 0
        ticks = 0
        timer1.schedule(1000) {
            title()
        }
    }

    @JvmStatic
    fun main(args: Array<String>){
        late()
        update()
        title()
    }
}