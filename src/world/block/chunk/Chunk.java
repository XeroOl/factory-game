package world.block.chunk;

import world.block.Block;


public class Chunk {
	public static final int CHUNK_SIZE = 16;
	public Block[][] blocks =new Block[CHUNK_SIZE][CHUNK_SIZE];
	int x;
	int y;
	public Chunk(String data){
		
	}
}	
