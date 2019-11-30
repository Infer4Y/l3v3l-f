package inferno.l3v3l_f.client.world;

import inferno.l3v3l_f.common.Game;
import inferno.l3v3l_f.common.blocks.Block;
import inferno.l3v3l_f.common.utils.math.Vector3f;
import inferno.l3v3l_f.common.world.World;
import inferno.l3v3l_f.common.world.chunks.Chunk;

import java.util.Random;

public class ClientWorld extends World {
    private Chunk[][][] chunks = new Chunk[4][4][4];

    public Chunk[][][] getChunks() {
        return chunks;
    }

    public static ClientWorld genWorld() {
        ClientWorld temp = new ClientWorld();

        for (int i = 0; i < temp.chunks.length; i++) {
            for (int j = 0; j < temp.chunks[i].length; j++) {
                for (int k = 0; k < temp.chunks[i][j].length; k++) {
                    Chunk chunk = new Chunk();
                    for (int l = 0; l < 16; l++) {
                        for (int m = 0; m < 16; m++) {
                            for (int n = 0; n < 16; n++) {
                                chunk.setContent(n, m, l, getBlock());
                            }
                        }
                    }
                    temp.chunks[i][j][k] = chunk;
                }
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

    private static Block getBlock(){
        if (Game.r.nextInt(64) >= 1) return Game.air;
        return Game.stone;
    }

    public boolean isVisible(int i, int j, int n, int k, int l, int m) {
        if (i >= 0 && i < chunks.length){
            if (j >= 0 && j < chunks[i].length) {
                if (n >= 0 && n < chunks[i][j].length) {
                    Block[][][] content = chunks[i][j][0].getContent();
                    if (k >= 0 && k < content.length) {
                        if (l >= 0 && l < content[k].length) {
                            if (m >= 0 && m < content[l].length) {
                                if (content[k][l][m] == Game.air) return false;
                                if (l == 15) {
                                    if (i == chunks.length - 1) {
                                        return true;
                                    } else return chunks[i + 1][j][n].getContent()[k][0][m] == Game.air;
                                } else return content[k][l + 1][m] == Game.air;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
