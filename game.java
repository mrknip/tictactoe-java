class TicTacToe {
	private static TicTacToeRunner runner = new TicTacToeRunner();

	public static void main (String [] args) {
		System.out.println("TicTacToe time!");
		runner.initialise();
		runner.startGame();
	}
}
