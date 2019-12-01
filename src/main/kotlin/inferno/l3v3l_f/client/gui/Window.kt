package inferno.l3v3l_f.client.gui

import inferno.l3v3l_f.common.utils.math.Vector2f
import inferno.l3v3l_f.common.utils.math.Vector3f
import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class WindowHelper : KeyListener {
    var north: Boolean = false
    var east: Boolean = false
    var south: Boolean = false
    var west: Boolean = false
    var up: Boolean = false
    var down: Boolean = false
    var rotUp: Boolean = false
    var rotDown: Boolean = false
    var left: Boolean = false
    var right: Boolean = false
    var increase: Boolean = false
    var decrease: Boolean = false

    fun move() : Vector3f{
        var transformLocation = Vector3f(0f,0f,0f)

        if (north) transformLocation.add(0f,0f,0.5f)
        if (east)  transformLocation.add(-0.5f,0f,0f)
        if (south) transformLocation.add(0f,0f,-0.5f)
        if (west)  transformLocation.add(0.5f,0f,0f)
        if (up)  transformLocation.add(0f,0.5f,0f)
        if (down)  transformLocation.add(0f,-0.5f,0f)

        return transformLocation
    }

    fun rotate(x : Float, y : Float) : Vector2f{
        var rot = Vector2f(x, y)

        if (left) rot.add(-0.05f, 0f)
        if (right) rot.add(0.05f, 0f)

        if (rotUp) rot.add(0f,-0.05f )
        if (rotDown) rot.add(0f, 0.05f)

        return rot
    }

    fun scale(old : Float) : Float{
        var new : Float = old

        if (increase) new +=0.5f
        if (decrease) new -=0.5f

        return new
    }

    override fun keyTyped(e: KeyEvent?) {
    }


    override fun keyPressed(e: KeyEvent?) {
        when (e?.keyCode){
            KeyEvent.VK_W -> {north=true; south=false}
            KeyEvent.VK_A -> {east=false; west=true}
            KeyEvent.VK_S -> {north=false; south=true}
            KeyEvent.VK_D -> {east=true; west=false}
            KeyEvent.VK_Q -> {left=true; right=false}
            KeyEvent.VK_E -> {right=true; left=false}
            KeyEvent.VK_SHIFT -> {up=true; down=false}
            KeyEvent.VK_CONTROL-> {down=true; up=false}
            KeyEvent.VK_R -> {increase=true; decrease=false}
            KeyEvent.VK_F -> {decrease=true; increase=false}
            KeyEvent.VK_PAGE_UP -> {rotUp=true; rotDown=false}
            KeyEvent.VK_PAGE_DOWN -> {rotDown=true; rotUp=false}
        }
    }

    override fun keyReleased(e: KeyEvent?) {
        when (e?.keyCode){
            KeyEvent.VK_W -> {north=false}
            KeyEvent.VK_A -> {west=false}
            KeyEvent.VK_S -> {south=false}
            KeyEvent.VK_D -> {east=false}
            KeyEvent.VK_Q -> {left=false}
            KeyEvent.VK_E -> {right=false}
            KeyEvent.VK_SHIFT -> {up=false}
            KeyEvent.VK_CONTROL-> {down=false}
            KeyEvent.VK_R -> {increase=false}
            KeyEvent.VK_F -> {decrease=false}
            KeyEvent.VK_PAGE_UP -> {rotUp=false}
            KeyEvent.VK_PAGE_DOWN -> {rotDown=false}
        }
    }
}