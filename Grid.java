class Grid {
	private Player[] cells;

	public void init() {
		cells = new Player[9];

		for (int i = 0 ; i < 9; ++i) {
			cells[i] = Player.EMPTY;
		}
	}

	public String render() {
		String result = "\n";

		for (int i = 0; i < 9; i++) {
			switch (cells[i]) {
				case X: 		result += "X";
										break;
				case O: 		result += "O";
										break;
				case EMPTY: result += " ";
										break;
			}

			if ((i+1) % 3 == 0) {
				result += "\n";
			} else if (i != 8) {
				result += "|"; 
			}
		}

		result += "\n";
		return result; 
	}

	public void setSymbolAtPosition (Player player, int position) {
		cells[position] = player;
	}

	public Player getSymbolAtPosition (int position) {
		return cells[position];
	}

	public boolean isFull () {
		for (int i = 0; i < cells.length; i++) {
			if (cells[i] == Player.EMPTY) {
				return false;
			}
		}
		return true;
	}

	public boolean hasLine () {
		if (hasHorizontalLine() || hasVerticalLine() || hasDiagonalLine()) {
			return true;
		}
		return false;
	}

	private boolean hasHorizontalLine () {
		RowOfCells[] rows = { 
							new RowOfCells(cells[0], cells[1], cells[2]),
							new RowOfCells(cells[3], cells[4], cells[5]),
							new RowOfCells(cells[6], cells[7], cells[8])
							};

		for (RowOfCells row : rows) {
			if (row.isAWinningLine()) {
				return true;
			}
		}

		return false;
	}	

	private boolean hasDiagonalLine () {
		RowOfCells[] diagonals = { 
							new RowOfCells(cells[0], cells[4], cells[8]),
							new RowOfCells(cells[2], cells[4], cells[6])
						};

		for (RowOfCells diagonal : diagonals) {
			if (diagonal.isAWinningLine()) {
				return true;
			}
		}

		return false;
	}	

	private boolean hasVerticalLine () {
		RowOfCells[] columns = { 
							new RowOfCells(cells[0], cells[3], cells[6]),
							new RowOfCells(cells[1], cells[4], cells[7]),
							new RowOfCells(cells[2], cells[5], cells[8])};

		for (RowOfCells column : columns) {
			if (column.isAWinningLine()) {
				return true;
			}
		}
		return false;
	}
}
