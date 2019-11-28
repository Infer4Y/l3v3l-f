package inferno.l3v3l_f.client.rendering;

import inferno.l3v3l_f.client.Run;
import inferno.l3v3l_f.client.models.ModelCube;
import inferno.l3v3l_f.client.world.ClientWorld;
import inferno.l3v3l_f.common.utils.math.Vector3f;
import inferno.l3v3l_f.common.world.chunks.Chunk;

import java.awt.*;

public class RendererGame {
    private ClientWorld world;
    private Camera camera;


    public RendererGame(ClientWorld world) {
        camera = new Camera(180f, 45f, new Vector3f(100,100,100));
        this.world = world;
    }

    public void draw(Graphics2D graphics2D) {

        Vector3f last = new Vector3f(0f,0f,0f);
        Vector3f first = last;
        Vector3f na = last;
        Vector3f current;
        ModelCube cube;
        Chunk[][] chunks = world.getChunks();

        graphics2D.setColor(Color.BLACK);

        graphics2D.fillRect(0,0, Run.window.getWidth(), Run.window.getHeight());

        graphics2D.translate(Run.window.getWidth()/2, Run.window.getHeight()/2);

        for (int i = 0; i < chunks.length; i++) {
            for (int j = 0; j < chunks[i].length; j++) {
                for (int k = 0; k < 16; k++) {
                    for (int l = 0; l < 16; l++) {
                        for (int m = 0; m < 16; m++) {
                            cube = new ModelCube((float)(-128)+(k+(128*i)), (-64)+l, (-128)+(k+(128*j)), 8f);
                            for (int f = 0; f < cube.getShapes().length; f++){
                                for (int g= 0; g < cube.getShapes()[f].getVertexes().length; g++){
                                    if (first == na) {
                                        current = camera.trasformPoint(cube.getShapes()[f].getVertexes()[g]);
                                        last = current;
                                        first = current;

                                    } else {
                                        graphics2D.setColor(Color.white);
                                        current = camera.trasformPoint(cube.getShapes()[f].getVertexes()[g]);
                                        graphics2D.drawLine(((int) last.getX()), (int) last.getY(), (int) current.getX(), (int) current.getY());
                                        graphics2D.setColor(Color.BLACK);
                                        last = current;
                                    }
                                }
                                last = na;
                                first = na;
                            }
                        }
                    }
                }
            }
        }
        camera.cameraUpdate();
    }

}