import inferno.l3v3l_f.client.models.Model
import inferno.l3v3l_f.client.models.ModelCube
import inferno.l3v3l_f.common.utils.math.Matrix3f
import inferno.l3v3l_f.common.utils.math.Vector3f
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.util.*
import javax.swing.JFrame
import kotlin.concurrent.schedule
import kotlin.math.*
import java.awt.event.KeyEvent
import java.awt.event.KeyListener


class TestModel : JFrame("Test Model"), KeyListener{

    var model = ModelCube((-50).toFloat(),(-50).toFloat(),(-50).toFloat(), 50f)
    var model1 = ModelCube((0).toFloat(),(-50).toFloat(),(-50).toFloat(), 50f)
    var model2 = ModelCube((-50).toFloat(), (-50).toFloat(),0.toFloat(), 50f)
    var model3 = ModelCube(0.toFloat(),0.toFloat(),0.toFloat(), 50f)

    var models : Array<Model> = arrayOf(model, model1, model2, model3)

    var north = false
    var east = false
    var south = false
    var west = false

    var r = 180.toFloat()
    var q = 10.toFloat()

    var camerax = Matrix3f(
        floatArrayOf(
            cos(r), 0.toFloat(), -sin(r),
            0.toFloat(), 1.toFloat(), 0.toFloat(),
            sin(r), 0.toFloat(), cos(r)
        ))
    var cameray = Matrix3f(
        floatArrayOf(
            1.toFloat(), 0.toFloat(), 0.toFloat(),
            0.toFloat(), cos(q), sin(q),
            0.toFloat(), -sin(q), cos(q)
        ))

    var camera = camerax.multiply(cameray)
    var transformLoc = Vector3f(10.toFloat(),0.toFloat(),10.toFloat())

    init {
        size = Dimension(300,300)
        isResizable = true
        isVisible = true
        defaultCloseOperation = 3
        setLocationRelativeTo(null)
        addKeyListener(this)
    }

    fun cameraUpdate(){
        if (r >= 360f) r =0f
        if (q >= 90f) q = -90f


        camerax = Matrix3f(
            floatArrayOf(
                cos(r), 0.toFloat(), -sin(r),
                0.toFloat(), 1.toFloat(), 0.toFloat(),
                sin(r), 0.toFloat(), cos(r)
            ))
        cameray = Matrix3f(
            floatArrayOf(
                1.toFloat(), 0.toFloat(), 0.toFloat(),
                0.toFloat(), cos(q), sin(q),
                0.toFloat(), -sin(q), cos(q)
            ))
        camera = camerax.multiply(cameray)
        r+= 0.005f;
        q+= 0.05f;
    }

    fun move(){
        when (true){
            north -> transformLoc.add(0f,0f,0.5f)
            east -> transformLoc.add(0.5f,0f,0f)
            south -> transformLoc.add(0f,0f,-0.5f)
            west -> transformLoc.add(-0.5f,0f,0f)
        }
    }

    fun draw() {
        var last = Vector3f(0.toFloat(),0.toFloat(),0.toFloat())
        var first = Vector3f(0.toFloat(),0.toFloat(),0.toFloat())
        val na = last
        var current: Vector3f
        if (bufferStrategy == null) createBufferStrategy(4)
        val g : Graphics2D = bufferStrategy.drawGraphics as Graphics2D? ?: return
        g.color = Color.BLACK
        g.fillRect(0,0,width, height)
        g.translate(width/2,height/2)

        for (l in models) {
            for (f in l.shapes) {
                for (i in f.vertexes) {
                    val x = Vector3f(i.x, i.y, i.z)
                    current = camera.transform(x.add(transformLoc))

                    if (last != na) {
                        g.color = Color.WHITE

                        g.drawLine(
                            (floor(last.x)).toInt(),
                            (floor(last.y)).toInt(),
                            (floor(current.x)).toInt(),
                            (floor(current.y)).toInt()
                        )
                    } else {
                        first = current
                    }


                    last = current
                    g.color = Color.BLACK
                }
                g.color = Color.WHITE
                g.drawLine(
                    (floor(last.x)).toInt(),
                    (floor(last.y)).toInt(),
                    (floor(first.x)).toInt(),
                    (floor(first.y)).toInt()
                )
                g.color = Color.BLACK
                last = na
            }
        }
        cameraUpdate()
        move()
        g.dispose()
        bufferStrategy.show()
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

object Run{
    var testModel = TestModel()

    var timer = Timer()
    var timer1 = Timer()
    var fps = 0

    fun late(){
        timer.schedule(1000/60) {
            testModel.draw()
            fps++
            late()
        }
    }

    fun title(){
        testModel.title = "Test Model | FPS: $fps"
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