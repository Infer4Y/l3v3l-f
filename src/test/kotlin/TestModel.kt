import inferno.l3v3l_f.client.models.ModelCube
import inferno.l3v3l_f.common.utils.math.Vector3f
import java.awt.Color
import java.awt.Dimension
import java.util.*
import javax.swing.JFrame
import kotlin.concurrent.schedule
import kotlin.math.ceil

class TestModel : JFrame("Test Model") {
    var model = ModelCube(1f,1f,1f)
    var camara = Vector3f(2f,2f,2f)

    init {
        size = Dimension(300,300)
        isResizable = true
        isVisible = true
        defaultCloseOperation = 3
        setLocationRelativeTo(null)
    }

    fun draw() {
        var last = Vector3f(0f,0f,0f)
        if (bufferStrategy == null) createBufferStrategy(4)
        var g = bufferStrategy.drawGraphics
        if (g==null)return
        g.color = Color.WHITE
        g.fillRect(0,0,width, height)
        for (i in model.vertexes) {
            g.color = Color.BLACK
            g.drawLine(
                (ceil(last.toVector2F(camara).x.toDouble()) * 25).toInt(),
                (ceil(last.toVector2F(camara).y.toDouble()) * 25).toInt(),
                (ceil(i.toVector2F(camara).x.toDouble()) * 25).toInt(),
                (ceil(i.toVector2F(camara).y.toDouble()) * 25).toInt()
            )
            last = i
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