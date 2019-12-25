package inferno.l3v3l_f.client.rendering

import inferno.l3v3l_f.common.utils.math.Matrix3f
import inferno.l3v3l_f.common.utils.math.Vector3f
import kotlin.math.*

class Camera ( var rotationX: Float = 0f, var rotationY: Float = 0f, var pos: Vector3f = Vector3f(0f,0f,0f)){

    private lateinit var cameraRotX : Matrix3f
    private lateinit var cameraRotY : Matrix3f

    lateinit var cameraTransform : Matrix3f

    init {
        cameraUpdate()
    }

    fun cameraUpdate(){
        if (rotationX >= 360f) rotationX =0f
        if (rotationY >= 90f) rotationY = -90f
        if (rotationX <= 0f) rotationX = 360f
        if (rotationY <= -90f) rotationY = 90f

        cameraRotX = Matrix3f(
            floatArrayOf(
                cos(rotationX), 0.toFloat(), -sin(rotationX),
                0.toFloat(), 1.toFloat(), 0.toFloat(),
                sin(rotationX), 0.toFloat(), cos(rotationX)
            ))

        cameraRotY = Matrix3f(
            floatArrayOf(
                1.toFloat(), 0.toFloat(), 0.toFloat(),
                0.toFloat(), cos(rotationY), sin(rotationY),
                0.toFloat(), -sin(rotationY), cos(rotationY)
            ))

        cameraTransform = cameraRotX.multiply(cameraRotY)
    }

    fun check(vector3f: Vector3f) : Boolean{
        val x = cameraTransform.transform(vector3f)
        if (-(x.x) in pos.x-320f..pos.x+320f && (x.z) in pos.z-320f..pos.z+320f ){
            return true
        }

        return false
    }

    fun trasformPoint(vector3f: Vector3f) : Vector3f{
        val temp = Vector3f(vector3f.x, vector3f.y, vector3f.z)
        return cameraTransform.transform(temp.add(pos))
    }
}