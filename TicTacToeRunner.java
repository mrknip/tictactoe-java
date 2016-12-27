import java.io.*;

class TicTacToeRunner {
	private Grid grid = new Grid();
	private String input;
	private GameState gameState;

	private Player currentPlayer = Player.X;

	public void initialise() {
		grid.init();
	}

	public void startGame () {
		while (!grid.isFull() && !grid.hasLine()) {
			switchPlayer();
			displayGrid();
			input = getMoveFromPlayer();
			grid.setSymbolAtPosition(currentPlayer, convertToCellReference(input));
		}

		displayGrid();
		displayEndMessage();
	}

	private void displayGrid () {
		System.out.println(grid.render());
	}

	private void displayEndMessage () {
		if (grid.hasLine()) {
			switch (currentPlayer) {
				case X: System.out.println("X wins");
								break;
				case O: System.out.println("O wins");
								break;
			}

		} else if (grid.isFull()) {
			System.out.println("Is a draw");
		};
	}

	private int convertToCellReference (String input) {
		return Integer.parseInt(input) - 1;
	}

	private String getMoveFromPlayer () {
		System.out.println("Select a move\n===========\n1|2|3\n4|5|6\n7|8|9\n");
		
		do {
			input = System.console().readLine();
		} while (!isValidInput(input));

		return input;
	}

	private boolean isValidInput (String input) {
		if (
			input.isEmpty() || 
			input.length() > 1 ||
			Character.digit(input.charAt(0), 10) < 0
			) {
			return false;
		}
		if (grid.getSymbolAtPosition(convertToCellReference(input)) != Player.EMPTY) {
			System.out.println("cell taken");
			return false;
		}
		if (convertToCellReference(input) < 0 || 
			  convertToCellReference(input) > 8	) {
			System.out.println("not on board");
			return false;
		}
		return true;
	}

	private void switchPlayer () {
		currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
	}
}
