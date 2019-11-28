package inferno.l3v3l_f.client.gui

import inferno.l3v3l_f.common.utils.math.Vector3f
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class WindowHelper : KeyListener {
    var north: Boolean = false
    var east: Boolean = false
    var south: Boolean = false
    var west: Boolean = false

    fun move() : Vector3f{
        var transformLocation = Vector3f(0f,0f,0f)
        when (true){
            north -> transformLocation.add(0f,0f,0.5f)
            east -> transformLocation.add(0.5f,0f,0f)
            south -> transformLocation.add(0f,0f,-0.5f)
            west -> transformLocation.add(-0.5f,0f,0f)
        }
        return transformLocation
    }

    override fun keyTyped(e: KeyEvent?) {
    }

    override fun keyPressed(e: KeyEvent?) {
        when (e?.keyCode){
            KeyEvent.VK_W -> {north=true; south=false}
            KeyEvent.VK_A -> {east=false; west=true}
            KeyEvent.VK_S -> {north=false; south=true}
            KeyEvent.VK_D -> {east=true; west=false}
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        when (e?.keyCode){
            KeyEvent.VK_W -> {north=false}
            KeyEvent.VK_A -> {west=false}
            KeyEvent.VK_S -> {south=false}
            KeyEvent.VK_D -> {east=false}
        }
    }
}