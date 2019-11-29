package inferno.l3v3l_f.client.world;

import inferno.l3v3l_f.common.Game;
import inferno.l3v3l_f.common.utils.math.Vector3f;
import inferno.l3v3l_f.common.world.World;
import inferno.l3v3l_f.common.world.chunks.Chunk;

public class ClientWorld extends World {
    private Chunk[][] chunks = new Chunk[2][2];

    public Chunk[][] getChunks() {
        return chunks;
    }

    public static ClientWorld genWorld() {
        ClientWorld temp = new ClientWorld();

        for (int i = 0; i < temp.chunks.length; i++) {
            for (int j = 0; j < temp.chunks[i].length; j++) {
                Chunk chunk = new Chunk();
                for (int k = 0; k < 16; k++) {
                    for (int l = 0; l < 16; l++) {
                        for (int m = 0; m < 16; m++) {
                            chunk.setContent(m, l, k, Game.air);
                        }
                    }
                }
                temp.chunks[i][j] = chunk;
            }
        }

        return temp;
    }

    public boolean isVisible(Vector3f camera, Vector3f block){
         if (camera.getX() > block.getX() || camera.getY() > block.getY() || camera.getZ() > block.getZ()){
             return true;
         }
         System.out.println(block.getX()+","+block.getY()+","+ block.getZ() + " " +camera.getX()+","+camera.getY()+","+camera.getZ());
        return false;
    }
}
