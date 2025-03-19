package RST;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Letter extends Label {

	public static final char blank = ' ';
	public static final char incorrect = 'X';
	public static final char correct = 'O';
	public static final char inWord = 'I';

	char value;

	private static final Image imgBLANK = new Image("/images/BLANK.png");
	private static final Image imgGreenA = new Image("/images/greenA.png");
	private static final Image imgGreenB = new Image("/images/greenB.png");
	private static final Image imgGreenC = new Image("/images/greenC.png");
	private static final Image imgGreenD = new Image("/images/greenD.png");
	private static final Image imgGreenE = new Image("/images/greenE.png");
	private static final Image imgGreenF = new Image("/images/greenF.png");
	private static final Image imgGreenG = new Image("/images/greenG.png");
	private static final Image imgGreenH = new Image("/images/greenH.png");
	private static final Image imgGreenI = new Image("/images/greenI.png");
	private static final Image imgGreenJ = new Image("/images/greenI.png");
	private static final Image imgGreenK = new Image("/images/greenK.png");
	private static final Image imgGreenL = new Image("/images/greenL.png");
	private static final Image imgGreenM = new Image("/images/greenM.png");
	private static final Image imgGreenN = new Image("/images/greenN.png");
	private static final Image imgGreenO = new Image("/images/greenO.png");
	private static final Image imgGreenP = new Image("/images/greenP.png");
	private static final Image imgGreenQ = new Image("/images/greenQ.png");
	private static final Image imgGreenR = new Image("/images/greenR.png");
	private static final Image imgGreenS = new Image("/images/greenS.png");
	private static final Image imgGreenT = new Image("/images/greenT.png");
	private static final Image imgGreenU = new Image("/images/greenU.png");
	private static final Image imgGreenV = new Image("/images/greenV.png");
	private static final Image imgGreenW = new Image("/images/greenW.png");
	private static final Image imgGreenX = new Image("/images/greenY.png");
	private static final Image imgGreenY = new Image("/images/greenX.png");
	private static final Image imgGreenZ = new Image("/images/greenZ.png");
	private static final Image imgGrayA = new Image("/images/grayA.png");
	private static final Image imgGrayB = new Image("/images/grayB.png");
	private static final Image imgGrayC = new Image("/images/grayC.png");
	private static final Image imgGrayD = new Image("/images/grayD.png");
	private static final Image imgGrayE = new Image("/images/grayE.png");
	private static final Image imgGrayF = new Image("/images/grayF.png");
	private static final Image imgGrayG = new Image("/images/grayG.png");
	private static final Image imgGrayH = new Image("/images/grayH.png");
	private static final Image imgGrayI = new Image("/images/grayI.png");
	private static final Image imgGrayJ = new Image("/images/grayJ.png");
	private static final Image imgGrayK = new Image("/images/grayK.png");
	private static final Image imgGrayL = new Image("/images/grayL.png");
	private static final Image imgGrayM = new Image("/images/grayM.png");
	private static final Image imgGrayN = new Image("/images/grayN.png");
	private static final Image imgGrayO = new Image("/images/grayO.png");
	private static final Image imgGrayP = new Image("/images/grayP.png");
	private static final Image imgGrayQ = new Image("/images/grayQ.png");
	private static final Image imgGrayR = new Image("/images/grayR.png");
	private static final Image imgGrayS = new Image("/images/grayS.png");
	private static final Image imgGrayT = new Image("/images/grayT.png");
	private static final Image imgGrayU = new Image("/images/grayU.png");
	private static final Image imgGrayV = new Image("/images/grayV.png");
	private static final Image imgGrayW = new Image("/images/grayW.png");
	private static final Image imgGrayX = new Image("/images/grayX.png");
	private static final Image imgGrayY = new Image("/images/grayY.png");
	private static final Image imgGrayZ = new Image("/images/grayZ.png");
	private static final Image imgYellowA = new Image("/images/yellowA.png");
	private static final Image imgYellowB = new Image("/images/yellowB.png");
	private static final Image imgYellowC = new Image("/images/yellowC.png");
	private static final Image imgYellowD = new Image("/images/yellowD.png");
	private static final Image imgYellowE = new Image("/images/yellowE.png");
	private static final Image imgYellowF = new Image("/images/yellowF.png");
	private static final Image imgYellowG = new Image("/images/yellowG.png");
	private static final Image imgYellowH = new Image("/images/yellowH.png");
	private static final Image imgYellowI = new Image("/images/yellowI.png");
	private static final Image imgYellowJ = new Image("/images/yellowJ.png");
	private static final Image imgYellowK = new Image("/images/yellowK.png");
	private static final Image imgYellowL = new Image("/images/yellowL.png");
	private static final Image imgYellowM = new Image("/images/yellowM.png");
	private static final Image imgYellowN = new Image("/images/yellowN.png");
	private static final Image imgYellowO = new Image("/images/yellowO.png");
	private static final Image imgYellowP = new Image("/images/yellowP.png");
	private static final Image imgYellowQ = new Image("/images/yellowQ.png");
	private static final Image imgYellowR = new Image("/images/yellowR.png");
	private static final Image imgYellowS = new Image("/images/yellowS.png");
	private static final Image imgYellowT = new Image("/images/yellowT.png");
	private static final Image imgYellowU = new Image("/images/yellowU.png");
	private static final Image imgYellowV = new Image("/images/yellowV.png");
	private static final Image imgYellowW = new Image("/images/yellowW.png");
	private static final Image imgYellowX = new Image("/images/yellowX.png");
	private static final Image imgYellowY = new Image("/images/yellowY.png");
	private static final Image imgYellowZ = new Image("/images/yellowZ.png");

	public Letter() {
		super();
		value = blank;
		setGraphic(new ImageView(imgBLANK));
	}

	public void setA(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayA));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenA));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowA));
			break;
		}
	}

	public void setB(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayB));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenB));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowB));
			break;
		}
	}

	public void setC(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayC));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenC));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowC));
			break;
		}
	}

	public void setD(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayD));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenD));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowD));
			break;
		}
	}

	public void setE(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayE));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenE));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowE));
			break;
		}
	}

	public void setF(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayF));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenF));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowF));
			break;
		}
	}

	public void setG(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayG));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenG));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowG));
			break;
		}
	}

	public void setH(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayH));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenH));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowH));
			break;
		}
	}

	public void setI(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayI));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenI));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowI));
			break;
		}
	}

	public void setJ(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayJ));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenJ));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowJ));
			break;
		}
	}

	public void setK(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayK));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenK));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowK));
			break;
		}
	}

	public void setL(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayL));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenL));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowL));
			break;
		}
	}

	public void setM(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayM));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenM));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowM));
			break;
		}
	}

	public void setN(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayN));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenN));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowN));
			break;
		}
	}

	public void setO(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayO));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenO));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowO));
			break;
		}
	}

	public void setP(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayP));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenP));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowP));
			break;
		}
	}

	public void setQ(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayQ));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenQ));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowQ));
			break;
		}
	}

	public void setR(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayR));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenR));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowR));
			break;
		}
	}

	public void setS(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayS));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenS));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowS));
			break;
		}
	}

	public void setT(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayT));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenT));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowT));
			break;
		}
	}

	public void setU(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayU));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenU));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowU));
			break;
		}
	}

	public void setV(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayV));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenV));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowV));
			break;
		}
	}

	public void setW(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayW));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenW));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowW));
			break;
		}
	}

	public void setX(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayX));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenX));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowX));
			break;
		}
	}

	public void setY(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayY));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenY));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowY));
			break;
		}
	}

	public void setZ(char val) {
		value = val;
		switch (value) {
		case incorrect:
			setGraphic(new ImageView(imgGrayZ));
			break;
		case correct:
			setGraphic(new ImageView(imgGreenZ));
			break;
		case inWord:
			setGraphic(new ImageView(imgYellowZ));
			break;
		}
	}

	public char getValue() {
		return value;
	}

	public void reset() {
		value = blank;
		setGraphic(new ImageView(imgBLANK));

	}

}
