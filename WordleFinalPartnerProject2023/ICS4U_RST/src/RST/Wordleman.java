package RST;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Wordleman extends Application {

	static final int GAP = 15;
	static final int XTRA_LARGE_FONT = 50;
	static final int LARGE_FONT = 30;
	static final int MEDIUM_FONT = 25;
	static final int SMALL_FONT = 20;
	static final int TINY_FONT = 15;
	static final char BLANK = '-';
	static final char EMPTY = ' ';
	static final String BLANKFIVE = "- - - - -";
	static final String BLANKSIX = "- - - - - -";
	static final String BLANKSEVEN = "- - - - - - -";

	public String guess;
	public String secretWord;
	public int wordLength = 0;
	public int random = 0;
	public int column;

	private String userInput;
	private char pressed, letter, letter1 = BLANK, letter2 = BLANK, letter3 = BLANK, letter4 = BLANK, letter5 = BLANK,
			letter6 = ' ', letter7 = ' ', secretLetter1, secretLetter2, secretLetter3, secretLetter4,
			secretLetter5, secretLetter6, secretLetter7;
	private int guesses = 0;
	private boolean gameOver = false;
	private boolean gameWon = false;
	private boolean gameLost = false;
	private Letter[][] screen;

	final Image level0 = new Image("/images/level0.png");
	final Image level1 = new Image("/images/level1.png");
	final Image level2 = new Image("/images/level2.png");
	final Image level3 = new Image("/images/level3.png");
	final Image level4 = new Image("/images/level4.png");
	final Image level5 = new Image("/images/level5.png");
	final Image level6 = new Image("/images/level6.png");
	final Image youWin = new Image("/images/youwin!.png");

	Label lblTitlePage, lblStart, lblGuess, lblTitle, lblInst, lblLength, lblResult;

	Button btnPlay, btnStart, btnFive, btnSix, btnSeven, btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ,
			btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ, btnGuess,
			btnDelete, btnReset;

	Tab titleTab, gameTab, instTab;

	ImageView hangman;

	GridPane title, inst, game;
	TabPane tabs;

	@Override
	public void start(Stage myStage) throws Exception {

		title = new GridPane();
		inst = new GridPane();
		game = new GridPane();
		tabs = new TabPane();

		titleTab = new Tab("Title Page");
		instTab = new Tab("Instructions");
		gameTab = new Tab("Game");

		titleTab.setClosable(false);
		instTab.setClosable(false);
		instTab.setDisable(true);
		gameTab.setClosable(false);
		gameTab.setDisable(true);

		hangman = new ImageView(getClass().getResource("/images/level0.png").toString());
		game.add(hangman, 8, 0, 10, 3);

		title.setHgap(GAP);
		title.setVgap(GAP);
		title.setPadding(new Insets(GAP, GAP, GAP, GAP));

		inst.setHgap(GAP);
		inst.setVgap(GAP);
		inst.setPadding(new Insets(GAP, GAP, GAP, GAP));

		game.setHgap(GAP);
		game.setVgap(GAP);
		game.setPadding(new Insets(GAP, GAP, GAP, GAP));
		game.setAlignment(Pos.CENTER);

		lblTitlePage = new Label("Wordle X Hangman");
		lblTitlePage.setFont(Font.font("Bomber Escort Outline", XTRA_LARGE_FONT));
		title.add(lblTitlePage, 1, 2, 4, 3);

		lblStart = new Label("Click Play To Begin!");
		lblStart.setFont(Font.font(LARGE_FONT));
		title.add(lblStart, 1, 4, 4, 4);

		lblInst = new Label(instructions());
		lblInst.setFont(Font.font(MEDIUM_FONT));
		inst.add(lblInst, 0, 0, 4, 4);

		lblLength = new Label("Pick Word Length:");
		lblLength.setFont(Font.font(MEDIUM_FONT));
		inst.add(lblLength, 0, 5, 1, 1);

		lblTitle = new Label("Wordle X Hangman");
		lblTitle.setFont(Font.font("Bomber Escort Outline", LARGE_FONT));
		game.add(lblTitle, 0, 0, 6, 1);

		lblResult = new Label("");
		lblResult.setFont(Font.font("Bomber Escort Outline", SMALL_FONT));
		game.add(lblResult, 3, 0, 8, 1);

		lblGuess = new Label();
		lblGuess.setFont(Font.font(LARGE_FONT));
		game.add(lblGuess, 8, 3, 10, 1);

		// ImageView hangman = new
		// ImageView(getClass().getResource("/images/level0.png").toString());
		// root.add(hangman, 0, 1, 4, 5);

		btnPlay = new Button("Play");
		btnPlay.setFont(Font.font(MEDIUM_FONT));
		title.add(btnPlay, 1, 9, 1, 1);
		btnPlay.setOnAction(event -> closeTab(titleTab));

		btnStart = new Button("Start");
		btnStart.setFont(Font.font(MEDIUM_FONT));
		inst.add(btnStart, 0, 7, 1, 1);
		btnStart.setOnAction(event -> closeTab(instTab));
		btnStart.setDisable(true);

		btnFive = new Button("5");
		btnFive.setFont(Font.font(TINY_FONT));
		inst.add(btnFive, 1, 5, 1, 1);
		btnFive.setOnAction(event -> fiveLong());

		btnSix = new Button("6");
		btnSix.setFont(Font.font(TINY_FONT));
		inst.add(btnSix, 2, 5, 1, 1);
		btnSix.setOnAction(event -> sixLong());

		btnSeven = new Button("7");
		btnSeven.setFont(Font.font(TINY_FONT));
		inst.add(btnSeven, 3, 5, 1, 1);
		btnSeven.setOnAction(event -> sevenLong());

		btnA = new Button("A");
		// btnA.setGraphic();
		btnA.setFont(Font.font(TINY_FONT));
		game.add(btnA, 9, 4, 1, 1);
		btnA.setOnAction(event -> pressA());

		btnB = new Button("B");
		// btnB.setGraphic();
		btnB.setFont(Font.font(TINY_FONT));
		game.add(btnB, 10, 4, 1, 1);
		btnB.setOnAction(event -> pressB());

		btnC = new Button("C");
		// btnC.setGraphic();
		btnC.setFont(Font.font(TINY_FONT));
		game.add(btnC, 11, 4, 1, 1);
		btnC.setOnAction(event -> pressC());

		btnD = new Button("D");
		// btnD.setGraphic();
		btnD.setFont(Font.font(TINY_FONT));
		game.add(btnD, 12, 4, 1, 1);
		btnD.setOnAction(event -> pressD());

		btnE = new Button("E");
		// btnE.setGraphic();
		btnE.setFont(Font.font(TINY_FONT));
		game.add(btnE, 13, 4, 1, 1);
		btnE.setOnAction(event -> pressE());

		btnF = new Button("F");
		// btnF.setGraphic();
		btnF.setFont(Font.font(TINY_FONT));
		game.add(btnF, 14, 4, 1, 1);
		btnF.setOnAction(event -> pressF());

		btnG = new Button("G");
		// btnG.setGraphic();
		btnG.setFont(Font.font(TINY_FONT));
		game.add(btnG, 15, 4, 1, 1);
		btnG.setOnAction(event -> pressG());

		btnH = new Button("H");
		// btnH.setGraphic();
		btnH.setFont(Font.font(TINY_FONT));
		game.add(btnH, 16, 4, 1, 1);
		btnH.setOnAction(event -> pressH());

		btnI = new Button("I");
		// btnI.setGraphic();
		btnI.setFont(Font.font(TINY_FONT));
		game.add(btnI, 17, 4, 1, 1);
		btnI.setOnAction(event -> pressI());

		btnJ = new Button("J");
		// btnJ.setGraphic();
		btnJ.setFont(Font.font(TINY_FONT));
		game.add(btnJ, 9, 5, 1, 1);
		btnJ.setOnAction(event -> pressJ());

		btnK = new Button("K");
		// btnK.setGraphic();
		btnK.setFont(Font.font(TINY_FONT));
		game.add(btnK, 10, 5, 1, 1);
		btnK.setOnAction(event -> pressK());

		btnL = new Button("L");
		// btnL.setGraphic();
		btnL.setFont(Font.font(TINY_FONT));
		game.add(btnL, 11, 5, 1, 1);
		btnL.setOnAction(event -> pressL());

		btnM = new Button("M");
		// btnM.setGraphic();
		btnM.setFont(Font.font(TINY_FONT));
		game.add(btnM, 12, 5, 1, 1);
		btnM.setOnAction(event -> pressM());

		btnN = new Button("N");
		// btnN.setGraphic();
		btnN.setFont(Font.font(TINY_FONT));
		game.add(btnN, 13, 5, 1, 1);
		btnN.setOnAction(event -> pressN());

		btnO = new Button("O");
		// btnO.setGraphic();
		btnO.setFont(Font.font(TINY_FONT));
		game.add(btnO, 14, 5, 1, 1);
		btnO.setOnAction(event -> pressO());

		btnP = new Button("P");
		// btnP.setGraphic();
		btnP.setFont(Font.font(TINY_FONT));
		game.add(btnP, 15, 5, 1, 1);
		btnP.setOnAction(event -> pressP());

		btnQ = new Button("Q");
		// btnQ.setGraphic();
		btnQ.setFont(Font.font(TINY_FONT));
		game.add(btnQ, 16, 5, 1, 1);
		btnQ.setOnAction(event -> pressQ());

		btnR = new Button("R");
		// btnR.setGraphic();
		btnR.setFont(Font.font(TINY_FONT));
		game.add(btnR, 17, 5, 1, 1);
		btnR.setOnAction(event -> pressR());

		btnS = new Button("S");
		// btnS.setGraphic();
		btnS.setFont(Font.font(TINY_FONT));
		game.add(btnS, 9, 6, 1, 1);
		btnS.setOnAction(event -> pressS());

		btnT = new Button("T");
		// btnE.setGraphic();
		btnT.setFont(Font.font(TINY_FONT));
		game.add(btnT, 10, 6, 1, 1);
		btnT.setOnAction(event -> pressT());

		btnU = new Button("U");
		// btnU.setGraphic();
		btnU.setFont(Font.font(TINY_FONT));
		game.add(btnU, 11, 6, 1, 1);
		btnU.setOnAction(event -> pressU());

		btnV = new Button("V");
		// btnV.setGraphic();
		btnV.setFont(Font.font(TINY_FONT));
		game.add(btnV, 12, 6, 1, 1);
		btnV.setOnAction(event -> pressV());

		btnW = new Button("W");
		// btnW.setGraphic();
		btnW.setFont(Font.font(TINY_FONT));
		game.add(btnW, 13, 6, 1, 1);
		btnW.setOnAction(event -> pressW());

		btnX = new Button("X");
		// btnX.setGraphic();
		btnX.setFont(Font.font(TINY_FONT));
		game.add(btnX, 14, 6, 1, 1);
		btnX.setOnAction(event -> pressX());

		btnY = new Button("Y");
		// btnY.setGraphic();
		btnY.setFont(Font.font(TINY_FONT));
		game.add(btnY, 15, 6, 1, 1);
		btnY.setOnAction(event -> pressY());

		btnZ = new Button("Z");
		// btnZ.setGraphic();
		btnZ.setFont(Font.font(TINY_FONT));
		game.add(btnZ, 16, 6, 1, 1);
		btnZ.setOnAction(event -> pressZ());

		btnGuess = new Button("GUESS");
		// btnGuess.setGraphic();
		btnGuess.setFont(Font.font(MEDIUM_FONT));
		game.add(btnGuess, 17, 3, 8, 1);
		btnGuess.setOnAction(event -> setGuess(event));
		btnGuess.setDisable(true);

		btnDelete = new Button("DELETE");
		// btnDelete.setGraphic();
		btnDelete.setFont(Font.font(TINY_FONT));
		game.add(btnDelete, 17, 6, 2, 1);
		btnDelete.setOnAction(event -> delete(event));
		btnDelete.setDisable(true);

		btnReset = new Button("RESET");
		btnReset.setFont(Font.font(TINY_FONT));
		game.add(btnReset, 6, 0, 6, 1);
		btnReset.setOnAction(e -> {
			try {
				reset(myStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		btnReset.setVisible(false);

		gameTab.setContent(game);
		instTab.setContent(inst);
		titleTab.setContent(title);
		tabs.getTabs().addAll(titleTab, instTab, gameTab);

		Scene scene = new Scene(tabs, 1400, 800);
		tabs.setStyle("-fx-background-color: #ACB5B3;");

		myStage.setTitle("Wordle X Hangman");
		myStage.setScene(scene);
		myStage.show();

	}

	private void setScreen() {

		screen = new Letter[wordLength][6];

		for (int row = 0; row <= wordLength - 1; row++) {
			for (int col = 0; col <= 5; col++) {
				screen[row][col] = new Letter();
				game.add(screen[row][col], row + 1, col + 1);

			}

		}
	}

	private void delete(ActionEvent event) {

		if (letter7 != BLANK && letter7 != EMPTY) {
			letter7 = BLANK;
			btnGuess.setDisable(true);
		} else if (letter6 != BLANK && letter6 != EMPTY && letter7 == EMPTY
				|| letter6 != BLANK && letter6 != EMPTY && letter7 == BLANK) {
			if (wordLength == 5) {
				letter6 = EMPTY;
			} else if (wordLength == 6 || wordLength == 7) {
				letter6 = BLANK;
				btnGuess.setDisable(true);
			}
		} else if (letter5 != BLANK && letter6 == BLANK || letter5 != BLANK && letter6 == EMPTY) {
			if (wordLength == 5) {
				letter5 = BLANK;
				btnGuess.setDisable(true);
			} else if (wordLength == 6 || wordLength == 7) {
				letter5 = BLANK;
			}
		} else if (letter4 != BLANK && letter5 == BLANK) {
			letter4 = BLANK;
		} else if (letter3 != BLANK && letter4 == BLANK) {
			letter3 = BLANK;
		} else if (letter2 != BLANK && letter3 == BLANK) {
			letter2 = BLANK;
		} else if (letter1 != BLANK && letter2 == BLANK) {
			letter1 = BLANK;
			btnDelete.setDisable(true);

		} else {
			userInput = "";
		}
		userInput = letter1 + " " + letter2 + " " + letter3 + " " + letter4 + " " + letter5 + " " + letter6 + " "
				+ letter7;
		lblGuess.setText(" Your guess: " + userInput);
	}

	private void pressLetter() {

		if (letter1 == BLANK) {
			letter1 = pressed;
			btnDelete.setDisable(false);
		} else if (letter1 != BLANK && letter2 == BLANK) {
			letter2 = pressed;
		} else if (letter2 != BLANK && letter3 == BLANK) {
			letter3 = pressed;
		} else if (letter3 != BLANK && letter4 == BLANK) {
			letter4 = pressed;
		} else if (letter4 != BLANK && letter5 == BLANK) {
			letter5 = pressed;
			if (wordLength == 5) {
				btnGuess.setDisable(false);
			}
		} else if (letter5 != BLANK && letter6 == BLANK) {
			letter6 = pressed;
			if (wordLength == 6) {
				btnGuess.setDisable(false);
			}
		} else if (letter6 != BLANK && letter7 == BLANK) {
			letter7 = pressed;
			if (wordLength == 7) {
				btnGuess.setDisable(false);
			}
		}
		userInput = letter1 + " " + letter2 + " " + letter3 + " " + letter4 + " " + letter5 + " " + letter6 + " "
				+ letter7;
		lblGuess.setText(" Your guess: " + userInput);
	}

	private void pressA() {
		pressed = 'A';
		pressLetter();
	}

	private void pressB() {
		pressed = 'B';
		pressLetter();
	}

	private void pressC() {
		pressed = 'C';
		pressLetter();
	}

	private void pressD() {
		pressed = 'D';
		pressLetter();
	}

	private void pressE() {
		pressed = 'E';
		pressLetter();
	}

	private void pressF() {
		pressed = 'F';
		pressLetter();
	}

	private void pressG() {
		pressed = 'G';
		pressLetter();
	}

	private void pressH() {
		pressed = 'H';
		pressLetter();
	}

	private void pressI() {
		pressed = 'I';
		pressLetter();
	}

	private void pressJ() {
		pressed = 'J';
		pressLetter();
	}

	private void pressK() {
		pressed = 'K';
		pressLetter();
	}

	private void pressL() {
		pressed = 'L';
		pressLetter();
	}

	private void pressM() {
		pressed = 'M';
		pressLetter();
	}

	private void pressN() {
		pressed = 'N';
		pressLetter();
	}

	private void pressO() {
		pressed = 'O';
		pressLetter();
	}

	private void pressP() {
		pressed = 'P';
		pressLetter();
	}

	private void pressQ() {
		pressed = 'Q';
		pressLetter();
	}

	private void pressR() {
		pressed = 'R';
		pressLetter();
	}

	private void pressS() {
		pressed = 'S';
		pressLetter();
	}

	private void pressT() {
		pressed = 'T';
		pressLetter();
	}

	private void pressU() {
		pressed = 'U';
		pressLetter();
	}

	private void pressV() {
		pressed = 'V';
		pressLetter();
	}

	private void pressW() {
		pressed = 'W';
		pressLetter();
	}

	private void pressX() {
		pressed = 'X';
		pressLetter();
	}

	private void pressY() {
		pressed = 'Y';
		pressLetter();
	}

	private void pressZ() {
		pressed = 'Z';
		pressLetter();
	}

	private void setGuess(ActionEvent event) {

		guess = Character.toString(letter1) + Character.toString(letter2) + Character.toString(letter3)
				+ Character.toString(letter4) + Character.toString(letter5) + Character.toString(letter6)
				+ Character.toString(letter7);

		letter1 = BLANK;
		letter2 = BLANK;
		letter3 = BLANK;
		letter4 = BLANK;
		letter5 = BLANK;
		pressed = BLANK;
		guesses++;

		if (wordLength == 5) {
			userInput = BLANKFIVE;
		} else if (wordLength == 6) {
			userInput = BLANKSIX;
			letter6 = BLANK;
		} else if (wordLength == 7) {
			userInput = BLANKSEVEN;
			letter6 = BLANK;
			letter7 = BLANK;
		} else {
			userInput = BLANKFIVE;
		}
		lblGuess.setText(" Your guess: " + userInput);
		btnGuess.setDisable(true);
		btnDelete.setDisable(true);
		checkWord();
	}

	private String instructions() {
		return ("You have six tries to guess the five, six or seven-letter Wordle to save the Hangman."
				+ "\nType in your guess and submit your word by hitting the GUESS key."
				+ "\nThe color of the tiles will change after you submit your word."
				+ "\nA yellow tile indicates that you picked a correct letter, but in the wrong spot."
				+ "\nThe green tile indicates that you picked a correct letter in the correct spot."
				+ "\nThe gray tile indicates that the letter is not included in the word at all."
				+ "\nContinue until you solve the Wordle or run out of guesses and kill the hangman. "
				+ "\nNow click 'Start!' to play! Good luck!");
	}

	public void fiveLong() {
		wordLength = 5;
		userInput = BLANKFIVE;
		letter6 = ' ';
		letter7 = ' ';
		secretWord = getWord();
		btnFive.setDisable(true);
		btnSix.setDisable(false);
		btnSeven.setDisable(false);
		btnStart.setDisable(false);
		lblGuess.setText(" Your guess: " + userInput);
	}

	public void sixLong() {
		wordLength = 6;
		userInput = BLANKSIX;
		letter6 = BLANK;
		letter7 = ' ';
		secretWord = getWord();
		btnFive.setDisable(false);
		btnSix.setDisable(true);
		btnSeven.setDisable(false);
		btnStart.setDisable(false);
		lblGuess.setText(" Your guess: " + userInput);
	}

	public void sevenLong() {
		wordLength = 7;
		userInput = BLANKSEVEN;
		letter6 = BLANK;
		letter7 = BLANK;
		secretWord = getWord();
		btnFive.setDisable(false);
		btnSix.setDisable(false);
		btnSeven.setDisable(true);
		btnStart.setDisable(false);
		lblGuess.setText(" Your guess: " + userInput);

	}

	private void closeTab(Tab tab) {
		if (tab == titleTab) {
			instTab.setDisable(false);
		} else if (tab == instTab) {
			gameTab.setDisable(false);
			setScreen();
		}

		EventHandler<Event> handler = tab.getOnClosed();
		if (null != handler) {
			handler.handle(null);
		} else {
			tab.getTabPane().getTabs().remove(tab);
		}
	}

	private String getWord() {
		Word theWord = new Word();
		String returnValue = "ERROR YOU SUCK";
		if (wordLength == 5) {
			returnValue = theWord.fiveLetterWord(random);
		} else if (wordLength == 6) {
			returnValue = theWord.sixLetterWord(random);
		} else if (wordLength == 7) {
			returnValue = theWord.sevenLetterWord(random);
		}
		return returnValue;
	}

	private void checkWinner() {

		if (gameOver == true) {
			if (gameWon == true) {
				if (guesses == 1) {
					lblResult.setText(
							"        You Win! You made " + guesses + " guess.\n        The word was " + secretWord);
				} else {
					lblResult.setText(
							"        You Win! You made " + guesses + " guesses.\n        The word was " + secretWord);
				}
				lblResult.setTextFill(Color.SEAGREEN);
				hangman.setImage(youWin);
			} else if (gameLost == true) {
				lblResult.setText("        You Lose! You made 6 guesses.\n        The word was " + secretWord);
				lblResult.setTextFill(Color.MAROON);
			} else {
				lblResult.setText("");
			}
			btnGuess.setDisable(true);
			btnA.setDisable(true);
			btnB.setDisable(true);
			btnC.setDisable(true);
			btnD.setDisable(true);
			btnE.setDisable(true);
			btnF.setDisable(true);
			btnG.setDisable(true);
			btnH.setDisable(true);
			btnI.setDisable(true);
			btnJ.setDisable(true);
			btnK.setDisable(true);
			btnL.setDisable(true);
			btnM.setDisable(true);
			btnN.setDisable(true);
			btnO.setDisable(true);
			btnP.setDisable(true);
			btnQ.setDisable(true);
			btnR.setDisable(true);
			btnS.setDisable(true);
			btnT.setDisable(true);
			btnU.setDisable(true);
			btnV.setDisable(true);
			btnW.setDisable(true);
			btnX.setDisable(true);
			btnY.setDisable(true);
			btnZ.setDisable(true);
			btnDelete.setDisable(true);
			btnReset.setVisible(true);
		}
	}

	private void reset(Stage myStage) throws Exception {
		start(myStage);
		setScreen();
		guesses = 0;
		gameOver = false;
		gameWon = false;
		gameLost = false;
	}

	private void checkWord() {

		letter1 = guess.charAt(0);
		letter2 = guess.charAt(1);
		letter3 = guess.charAt(2);
		letter4 = guess.charAt(3);
		letter5 = guess.charAt(4);

		secretLetter1 = secretWord.charAt(0);
		secretLetter2 = secretWord.charAt(1);
		secretLetter3 = secretWord.charAt(2);
		secretLetter4 = secretWord.charAt(3);
		secretLetter5 = secretWord.charAt(4);

		if (wordLength == 6) {
			secretLetter6 = secretWord.charAt(5);
			letter6 = guess.charAt(5);
		}

		if (wordLength == 7) {
			secretLetter6 = secretWord.charAt(5);
			secretLetter7 = secretWord.charAt(6);
			letter6 = guess.charAt(5);
			letter7 = guess.charAt(6);
		}

		for (int i = 0; i <= wordLength; i++) {
			switch (i) {
			case 1:
				letter = letter1;
				column = i - 1;
				break;
			case 2:
				letter = letter2;
				column = i - 1;
				break;
			case 3:
				letter = letter3;
				column = i - 1;
				break;
			case 4:
				letter = letter4;
				column = i - 1;
				break;
			case 5:
				letter = letter5;
				column = i - 1;
				break;
			case 6:
				letter = letter6;
				column = i - 1;
				break;
			case 7:
				letter = letter7;
				column = i - 1;
				break;
			}
			if (letter != secretLetter1 && letter != secretLetter2 && letter != secretLetter3 && letter != secretLetter4
					&& letter != secretLetter5 && letter != secretLetter6 && letter != secretLetter7) {
				checkIncorrect();
			} else if (letter == secretLetter1 && letter != letter1 || letter == secretLetter2 && letter != letter2
					|| letter == secretLetter3 && letter != letter3 || letter == secretLetter4 && letter != letter4
					|| letter == secretLetter5 && letter != letter5 || letter == secretLetter6 && letter != letter6
					|| letter == secretLetter7 && letter != letter7) {
				checkInWord();
			} else if (letter == secretLetter1 && letter == letter1 || letter == secretLetter2 && letter == letter2
					|| letter == secretLetter3 && letter == letter3 || letter == secretLetter4 && letter == letter4
					|| letter == secretLetter5 && letter == letter5 || letter == secretLetter6 && letter == letter6
					|| letter == secretLetter7 && letter == letter7) {
				checkCorrect();
			}
		}

		if (guesses == 6 || guess == secretWord || userInput == secretWord) {
			gameOver = true;
		}
		if (wordLength == 5) {
			if (letter1 == secretLetter1 && letter2 == secretLetter2 && letter3 == secretLetter3
					&& letter4 == secretLetter4 && letter5 == secretLetter5) {
				gameOver = true;
				gameWon = true;
			}
		} else if (wordLength == 6) {
			if (letter1 == secretLetter1 && letter2 == secretLetter2 && letter3 == secretLetter3
					&& letter4 == secretLetter4 && letter5 == secretLetter5 && letter6 == secretLetter6) {
				gameOver = true;
				gameWon = true;
			}
		} else if (wordLength == 7) {
			if (letter1 == secretLetter1 && letter2 == secretLetter2 && letter3 == secretLetter3
					&& letter4 == secretLetter4 && letter5 == secretLetter5 && letter6 == secretLetter6
					&& letter7 == secretLetter7) {
				gameOver = true;
				gameWon = true;
			}
		}
		if (guesses == 6 && guess != secretWord && userInput != secretWord) {
			gameLost = true;
		}

		letter1 = BLANK;
		letter2 = BLANK;
		letter3 = BLANK;
		letter4 = BLANK;
		letter5 = BLANK;

		if (wordLength == 5) {
			userInput = BLANKFIVE;
		} else if (wordLength == 6) {
			userInput = BLANKSIX;
			letter6 = BLANK;
		} else if (wordLength == 7) {
			userInput = BLANKSEVEN;
			letter6 = BLANK;
			letter7 = BLANK;
		}

		checkWinner();
		guess = "";
	}

	private void checkIncorrect() {
		if (letter == 'A') {
			screen[column][guesses - 1].setA(Letter.incorrect);
		}
		if (letter == 'B') {
			screen[column][guesses - 1].setB(Letter.incorrect);
		}
		if (letter == 'C') {
			screen[column][guesses - 1].setC(Letter.incorrect);
		}
		if (letter == 'D') {
			screen[column][guesses - 1].setD(Letter.incorrect);
		}
		if (letter == 'E') {
			screen[column][guesses - 1].setE(Letter.incorrect);
		}
		if (letter == 'F') {
			screen[column][guesses - 1].setF(Letter.incorrect);
		}
		if (letter == 'G') {
			screen[column][guesses - 1].setG(Letter.incorrect);
		}
		if (letter == 'H') {
			screen[column][guesses - 1].setH(Letter.incorrect);
		}
		if (letter == 'I') {
			screen[column][guesses - 1].setI(Letter.incorrect);
		}
		if (letter == 'J') {
			screen[column][guesses - 1].setJ(Letter.incorrect);
		}
		if (letter == 'K') {
			screen[column][guesses - 1].setK(Letter.incorrect);
		}
		if (letter == 'L') {
			screen[column][guesses - 1].setL(Letter.incorrect);
		}
		if (letter == 'M') {
			screen[column][guesses - 1].setM(Letter.incorrect);
		}
		if (letter == 'N') {
			screen[column][guesses - 1].setN(Letter.incorrect);
		}
		if (letter == 'O') {
			screen[column][guesses - 1].setO(Letter.incorrect);
		}
		if (letter == 'P') {
			screen[column][guesses - 1].setP(Letter.incorrect);
		}
		if (letter == 'Q') {
			screen[column][guesses - 1].setQ(Letter.incorrect);
		}
		if (letter == 'R') {
			screen[column][guesses - 1].setR(Letter.incorrect);
		}
		if (letter == 'S') {
			screen[column][guesses - 1].setS(Letter.incorrect);
		}
		if (letter == 'T') {
			screen[column][guesses - 1].setT(Letter.incorrect);
		}
		if (letter == 'U') {
			screen[column][guesses - 1].setU(Letter.incorrect);
		}
		if (letter == 'V') {
			screen[column][guesses - 1].setV(Letter.incorrect);
		}
		if (letter == 'W') {
			screen[column][guesses - 1].setW(Letter.incorrect);
		}
		if (letter == 'X') {
			screen[column][guesses - 1].setX(Letter.incorrect);
		}
		if (letter == 'Y') {
			screen[column][guesses - 1].setY(Letter.incorrect);
		}
		if (letter == 'Z') {
			screen[column][guesses - 1].setZ(Letter.incorrect);
		}

		switch (guesses) {

		case 1:
			hangman.setImage(level1);
			break;
		case 2:
			hangman.setImage(level2);

			break;
		case 3:
			hangman.setImage(level3);

			break;
		case 4:
			hangman.setImage(level4);

			break;
		case 5:
			hangman.setImage(level5);

			break;
		case 6:
			hangman.setImage(level6);

			break;
		}

	}

	private void checkInWord() {
		if (letter == 'A') {
			screen[column][guesses - 1].setA(Letter.inWord);
		}
		if (letter == 'B') {
			screen[column][guesses - 1].setB(Letter.inWord);
		}
		if (letter == 'C') {
			screen[column][guesses - 1].setC(Letter.inWord);
		}
		if (letter == 'D') {
			screen[column][guesses - 1].setD(Letter.inWord);
		}
		if (letter == 'E') {
			screen[column][guesses - 1].setE(Letter.inWord);
		}
		if (letter == 'F') {
			screen[column][guesses - 1].setF(Letter.inWord);
		}
		if (letter == 'G') {
			screen[column][guesses - 1].setG(Letter.inWord);
		}
		if (letter == 'H') {
			screen[column][guesses - 1].setH(Letter.inWord);
		}
		if (letter == 'I') {
			screen[column][guesses - 1].setI(Letter.inWord);
		}
		if (letter == 'J') {
			screen[column][guesses - 1].setJ(Letter.inWord);
		}
		if (letter == 'K') {
			screen[column][guesses - 1].setK(Letter.inWord);
		}
		if (letter == 'L') {
			screen[column][guesses - 1].setL(Letter.inWord);
		}
		if (letter == 'M') {
			screen[column][guesses - 1].setM(Letter.inWord);
		}
		if (letter == 'N') {
			screen[column][guesses - 1].setN(Letter.inWord);
		}
		if (letter == 'O') {
			screen[column][guesses - 1].setO(Letter.inWord);
		}
		if (letter == 'P') {
			screen[column][guesses - 1].setP(Letter.inWord);
		}
		if (letter == 'Q') {
			screen[column][guesses - 1].setQ(Letter.inWord);
		}
		if (letter == 'R') {
			screen[column][guesses - 1].setR(Letter.inWord);
		}
		if (letter == 'S') {
			screen[column][guesses - 1].setS(Letter.inWord);
		}
		if (letter == 'T') {
			screen[column][guesses - 1].setT(Letter.inWord);
		}
		if (letter == 'U') {
			screen[column][guesses - 1].setU(Letter.inWord);
		}
		if (letter == 'V') {
			screen[column][guesses - 1].setV(Letter.inWord);
		}
		if (letter == 'W') {
			screen[column][guesses - 1].setW(Letter.inWord);
		}
		if (letter == 'X') {
			screen[column][guesses - 1].setX(Letter.inWord);
		}
		if (letter == 'Y') {
			screen[column][guesses - 1].setY(Letter.inWord);
		}
		if (letter == 'Z') {
			screen[column][guesses - 1].setZ(Letter.inWord);
		}
	}

	private void checkCorrect() {
		if (letter == 'A') {
			screen[column][guesses - 1].setA(Letter.correct);
		}
		if (letter == 'B') {
			screen[column][guesses - 1].setB(Letter.correct);
		}
		if (letter == 'C') {
			screen[column][guesses - 1].setC(Letter.correct);
		}
		if (letter == 'D') {
			screen[column][guesses - 1].setD(Letter.correct);
		}
		if (letter == 'E') {
			screen[column][guesses - 1].setE(Letter.correct);
		}
		if (letter == 'F') {
			screen[column][guesses - 1].setF(Letter.correct);
		}
		if (letter == 'G') {
			screen[column][guesses - 1].setG(Letter.correct);
		}
		if (letter == 'H') {
			screen[column][guesses - 1].setH(Letter.correct);
		}
		if (letter == 'I') {
			screen[column][guesses - 1].setI(Letter.correct);
		}
		if (letter == 'J') {
			screen[column][guesses - 1].setJ(Letter.correct);
		}
		if (letter == 'K') {
			screen[column][guesses - 1].setK(Letter.correct);
		}
		if (letter == 'L') {
			screen[column][guesses - 1].setL(Letter.correct);
		}
		if (letter == 'M') {
			screen[column][guesses - 1].setM(Letter.correct);
		}
		if (letter == 'N') {
			screen[column][guesses - 1].setN(Letter.correct);
		}
		if (letter == 'O') {
			screen[column][guesses - 1].setO(Letter.correct);
		}
		if (letter == 'P') {
			screen[column][guesses - 1].setP(Letter.correct);
		}
		if (letter == 'Q') {
			screen[column][guesses - 1].setQ(Letter.correct);
		}
		if (letter == 'R') {
			screen[column][guesses - 1].setR(Letter.correct);
		}
		if (letter == 'S') {
			screen[column][guesses - 1].setS(Letter.correct);
		}
		if (letter == 'T') {
			screen[column][guesses - 1].setT(Letter.correct);
		}
		if (letter == 'U') {
			screen[column][guesses - 1].setU(Letter.correct);
		}
		if (letter == 'V') {
			screen[column][guesses - 1].setV(Letter.correct);
		}
		if (letter == 'W') {
			screen[column][guesses - 1].setW(Letter.correct);
		}
		if (letter == 'X') {
			screen[column][guesses - 1].setX(Letter.correct);
		}
		if (letter == 'Y') {
			screen[column][guesses - 1].setY(Letter.correct);
		}
		if (letter == 'Z') {
			screen[column][guesses - 1].setZ(Letter.correct);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
