class RowOfCells {
	private Player[] cells;

	public RowOfCells (Player cellA, Player cellB, Player cellC) {
		cells = new Player[3];
		cells[0] = cellA;
		cells[1] = cellB;
		cells[2] = cellC;
	}

	public boolean isAWinningLine () {
		if (
				cells[0] == cells[1] && 
				cells[1] == cells[2] && 
				cells[2] != Player.EMPTY
			) {
				return true;
			}
		return false;
	}
}
