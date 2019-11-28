package inferno.l3v3l_f.common.world.chunks;

import inferno.l3v3l_f.common.blocks.Block;

public class Chunk {
    private Block[][][] content = new Block[16][16][16];

    public void setContent(int x, int y, int z, Block block){
        if ( x >= 16 || y >= 16 || z >= 16 ) return;

        content[x][y][z] = block;
    }
}
