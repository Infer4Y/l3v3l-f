package inferno.l3v3l_f.client.rendering;

import inferno.l3v3l_f.client.Run;
import inferno.l3v3l_f.client.models.ModelCube;
import inferno.l3v3l_f.client.world.ClientWorld;
import inferno.l3v3l_f.common.Game;
import inferno.l3v3l_f.common.utils.math.Vector3f;
import inferno.l3v3l_f.common.world.chunks.Chunk;

import java.awt.*;

public class RendererGame {
    private ClientWorld world;
    private Camera camera;
    private float scale;

    public RendererGame(ClientWorld world) {
        camera = new Camera(270f, -45f, new Vector3f(-128,-128,-128));
        this.world = world;
        scale = 16.0f;
    }

    public void draw(Graphics2D graphics2D) {

        Vector3f last = new Vector3f(0f,0f,0f);
        Vector3f first = last;
        Vector3f na = last;
        Vector3f current;
        ModelCube cube;
        Chunk[][][] chunks = world.getChunks();

        graphics2D.setColor(Color.BLACK);

        graphics2D.fillRect(0,0, Run.window.getWidth(), Run.window.getHeight());

        graphics2D.translate(Run.window.getWidth()/2, Run.window.getHeight()/2);

        for (int i = 0; i < chunks.length; i++) {
            for (int j = 0; j < chunks[i].length; j++) {
                for (int n = 0; n < chunks[i][j].length; n++) {
                    for (int k = 0; k < 16; k++) {
                        for (int l = 0; l < 16; l++) {
                            for (int m = 0; m < 16; m++)  {
                                if (world.isVisible(i, j, n, k, l, m)) {
                                    cube = new ModelCube(
                                            (-16*scale)+((l*scale)+(16*scale*j)),
                                            (-16*scale)+((k*scale)+(16*scale*i)),
                                            (-16*scale)+((m*scale)+(16*scale*n)),
                                            scale);
                                    for (int f = 0; f < cube.getShapes().length; f++) {
                                        for (int g = 0; g < cube.getShapes()[f].getVertexes().length; g++) {
                                            if (first == na) {
                                                current = camera.trasformPoint(cube.getShapes()[f].getVertexes()[g]);
                                                last = current;
                                                first = current;
                                            } else {
                                                graphics2D.setColor(Color.GREEN);
                                                current = camera.trasformPoint(cube.getShapes()[f].getVertexes()[g]);
                                                if ((current.getX() <= ((Run.window.getWidth() / 2f) + 20f) && current.getX() >= (-(Run.window.getWidth() / 2f) - 20f)) &&
                                                        (current.getY() <= ((Run.window.getHeight() / 2f) + 20f) && current.getY() >= (-(Run.window.getHeight() / 2f) - 20f))) {
                                                    graphics2D.drawLine(((int) last.getX()), (int) last.getY(), (int) current.getX(), (int) current.getY());
                                                    graphics2D.setColor(Color.BLACK);
                                                }
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
            }
        }

        camera.cameraUpdate();
    }

    public void moveCamera(Vector3f vector3f){
        camera.setPos(camera.getPos().add(vector3f));
    }

    public Camera getCamera() {
        return camera;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }
}
