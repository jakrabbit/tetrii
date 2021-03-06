package org.jakrabbit.tetris;

import com.google.common.base.Function;

public class Block {
	public enum Color {
		RED(0xBB0000), ORANGE(0xff950c), LIGHT_BLUE(0x2ea4ff), DARK_BLUE(0x0000BB), GREEN(0x2dd400), VIOLET(
				0x4b0063);

		int colorHexValue;

		private Color(int color) {
			this.colorHexValue = color;
		}
	}

	public final int x, y;
	public final Color color;

	public Block(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public Block down() {
		return down.apply(this);
	}

	public Block left() {
		return left.apply(this);
	}

	public Block right() {
		return right.apply(this);
	}

	public static Function<Block, Block> down = new Function<Block, Block>() {
		@Override
		public Block apply(Block old) {
			return new Block(old.x, old.y + 1, old.color);
		}
	};

	public static Function<Block, Block> left = new Function<Block, Block>() {
		@Override
		public Block apply(Block old) {
			return new Block(old.x - 1, old.y, old.color);
		}
	};

	public static Function<Block, Block> right = new Function<Block, Block>() {
		@Override
		public Block apply(Block old) {
			return new Block(old.x + 1, old.y, old.color);
		}
	};
}
