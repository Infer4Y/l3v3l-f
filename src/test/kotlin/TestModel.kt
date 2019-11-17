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
    var model = ModelCube(2f,2f,2f, Vector3f(5f,3f,5f))
    var camara = Vector3f(20f,30f,20f)

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
                    ((last.x.toDouble()) * 1).toInt(),
                    ((last.y.toDouble()) * 1).toInt(),
                    ((current.x.toDouble()) * 1).toInt(),
                    ((current.y.toDouble()) * 1).toInt()
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

    fun late(){
        timer.schedule(1000/60) {
            testModel.draw()
            late()
        }
    }

    @JvmStatic
    fun main(args: Array<String>){
        late()
    }
}