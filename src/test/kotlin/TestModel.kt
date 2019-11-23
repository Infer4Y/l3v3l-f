import inferno.l3v3l_f.client.models.ModelCube
import inferno.l3v3l_f.common.utils.math.Vector2f
import inferno.l3v3l_f.common.utils.math.Vector3f
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D
import java.util.*
import javax.swing.InputMap
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.KeyStroke
import kotlin.concurrent.schedule
import kotlin.math.ceil

class TestModel : JFrame("Test Model") {
    var model = ModelCube(0.toFloat(),11.toFloat(),5.toFloat(), 50f)
    var model1 = ModelCube(50.toFloat(),35.toFloat(),7.toFloat(),30f)
    var model2 = ModelCube(90.toFloat(),32.toFloat(),3.toFloat(),10f)
    var camara = Vector3f(4.toFloat(),4.toFloat(),4.toFloat())


    init {
        size = Dimension(300,300)
        isResizable = true
        isVisible = true
        defaultCloseOperation = 3
        setLocationRelativeTo(null)
    }

    fun draw() {
        var last = Vector2f(0f,0f)
        var na = last
        var x = 0
        var current: Vector2f
        if (bufferStrategy == null) createBufferStrategy(4)
        var g : Graphics2D = bufferStrategy.drawGraphics as Graphics2D? ?: return
        g.color = Color.BLACK
        g.fillRect(0,0,width, height)
        g.translate(800,800)

        for (i in model.vertexes) {
            current = i.toVector2F(camara)

            if (x == 5) {x =0 ; last = na}

            if (last != na) {
                g.color = Color.WHITE

                g.drawLine(
                    ((last.x.toDouble())).toInt()*5,
                    ((last.y.toDouble())).toInt()*5,
                    ((current.x.toDouble())).toInt()*5,
                    ((current.y.toDouble())).toInt()*5
                )
            }

            last = current
            x++
            g.color = Color.BLACK
        }

        last = na

        for (i in model1.vertexes) {
            current = i.toVector2F(camara)

            if (x == 5) {x =0 ; last = na}

            if (last != na) {
                g.color = Color.WHITE

                g.drawLine(
                    ((last.x.toDouble())).toInt()*5,
                    ((last.y.toDouble())).toInt()*5,
                    ((current.x.toDouble())).toInt()*5,
                    ((current.y.toDouble())).toInt()*5
                )
            }

            last = current
            x++
            g.color = Color.BLACK
        }

        last = na

        for (i in model2.vertexes) {
            current = i.toVector2F(camara)

            if (x == 5) {x =0 ; last = na}

            if (last != na) {
                g.color = Color.WHITE

                g.drawLine(
                    ((last.x.toDouble())).toInt()*5,
                    ((last.y.toDouble())).toInt()*5,
                    ((current.x.toDouble())).toInt()*5,
                    ((current.y.toDouble())).toInt()*5
                )
            }

            last = current
            x++
            g.color = Color.BLACK
        }

        g.translate(-800,-800)
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