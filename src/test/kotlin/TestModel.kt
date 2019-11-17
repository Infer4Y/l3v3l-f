import inferno.l3v3l_f.client.models.ModelCube
import inferno.l3v3l_f.common.utils.math.Vector2f
import inferno.l3v3l_f.common.utils.math.Vector3f
import java.awt.Color
import java.awt.Dimension
import java.util.*
import javax.swing.JFrame
import kotlin.concurrent.schedule
import kotlin.math.ceil

class TestModel : JFrame("Test Model") {
    var model = ModelCube(2.toFloat(),2.toFloat(),2.toFloat(), Vector3f(5.toFloat(),3.toFloat(),5.toFloat()))
    var camara = Vector3f(7.toFloat(),10.toFloat(),0.toFloat())

    init {
        size = Dimension(300,300)
        isResizable = true
        isVisible = true
        defaultCloseOperation = 3
        setLocationRelativeTo(null)
    }

    fun draw() {
        var last = Vector2f(0f,0f)
        var current = Vector2f(0f,0f)
        if (bufferStrategy == null) createBufferStrategy(4)
        var g = bufferStrategy.drawGraphics ?: return
        g.color = Color.WHITE
        g.fillRect(0,0,width, height)
        for (i in model.vertexes) {
            current = i.toVector2F(camara)
            if (last != Vector2f(0f,0f)) {
                g.color = Color.BLACK
                g.drawLine(
                    ((last.x.toDouble()) * 10).toInt(),
                    ((last.y.toDouble()) * 10).toInt(),
                    ((current.x.toDouble()) * 10).toInt(),
                    ((current.y.toDouble()) * 10).toInt()
                )
            }
            last = current
            g.color = Color.WHITE
        }
        g.dispose()
        bufferStrategy.show()

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
        testModel.title = "Test Model | FPS: ${fps}"
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