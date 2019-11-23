package inferno.l3v3l_f.client.models;

import inferno.l3v3l_f.common.utils.math.Vector3f;


public class ModelCube extends Model {
    public ModelCube(float x, float y, float z, float scale){
        float l = ((!Float.isNaN(scale)) || scale != ((float) 0)) ? scale : 1f;
        this.vertexes = new Vector3f[] {
                new Vector3f(x,y,z),              //0,0,0
                new Vector3f(x, y, z+l),       //0,0,1
                new Vector3f(x+l, y, z+l),  //1,0,1
                new Vector3f(x+l,y,z),         //1,0,0
                new Vector3f(x,y,z),              //0,0,0

                new Vector3f(x,y,z),              //0,0,0
                new Vector3f(x, y, z+l),       //0,0,1
                new Vector3f(x, y+l, z+l),  //0,1,1
                new Vector3f(x,y+l,z),         //0,1,0
                new Vector3f(x,y,z),              //0,0,0

                new Vector3f(x,y,z),              //0,0,0
                new Vector3f(x+l, y, z),       //1,0,0
                new Vector3f(x+l, y+l, z),  //1,1,0
                new Vector3f(x,y+l,z),         //0,1,0
                new Vector3f(x,y,z),              //0,0,0

                new Vector3f(x,y,z),                    //0,0,0
                new Vector3f(x+l, y, z),             //1,0,0
                new Vector3f(x+l, y+l, z+l),   //1,1,1
                new Vector3f(x,y+l,z+l),          //0,1,1
                new Vector3f(x,y,z),                    //0,0,0

                new Vector3f(x,y,z+l),              //0,0,0
                new Vector3f(x, y+l, z+l),
                new Vector3f(x+l, y+l, z+l),
                new Vector3f(x+l,y,z+l),
                new Vector3f(x,y,z+l),              //0,0,0

                new Vector3f(x,y+l,z),
                new Vector3f(x, y+l, z+l),
                new Vector3f(x+l, y+l, z+l),
                new Vector3f(x+l,y+l,z),
                new Vector3f(x,y+l,z),
        };
    }

    public ModelCube(float x, float y, float z, float scale ,Vector3f off){
        this(x + off.getX(), y + off.getY(), z + off.getZ(), scale);
    }
}
