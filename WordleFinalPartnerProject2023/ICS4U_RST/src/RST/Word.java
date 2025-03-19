package RST;

public class Word {

	private String word;

	public String[] fiveLetter = { "APPLE", "ABOVE", "AGENT", "AWARE", "ABOUT", "ARGUE", "BLOCK", "BUNCH", "BLAME",
			"BELOW", "BREAK", "CRAZY", "CHECK", "CYCLE", "CRIME", "COLOR", "CABLE", "DELAY", "DRIVE", "DOUBT", "DRESS",
			"ENJOY", "EQUAL", "ENTER", "FAITH", "FRAME", "FOCUS", "FINAL", "GHOST", "GUARD", "GIANT", "GLASS", "HEAVY",
			"HOUSE", "HORSE", "HUMAN", "INDEX", "IMAGE", "ISSUE", "JUDGE", "JOINT", "JUICE", "KNOCK", "KNIFE", "LUNCH",
			"LEVEL", "LIGHT", "LEMON", "LOWER", "MIGHT", "MONEY", "MAYOR", "MUSIC", "MAYBE", "NORTH", "NEVER", "NERVE",
			"NURSE", "OWNER", "OFTEN", "ONION", "OCEAN", "POWER", "PAPER", "POINT", "PAINT", "PRIME", "PIANO", "PRESS",
			"POUND", "QUICK", "QUIET", "QUOTE", "RELAX", "REPLY", "RADIO", "ROUGH", "RIVER", "REACH", "START", "SORRY",
			"STARE", "SEVEN", "SHOUT", "SHOCK", "SHARP", "STORM", "SPORT", "SMELL", "SLEEP", "THINK", "TITAN", "TRUTH",
			"TOWER", "TABLE", "TOTAL", "TROOP", "UPPER", "UNDER", "USUAL", "VOICE", "VIDEO", "VALUE", "WATCH", "WHITE",
			"WASTE", "WRONG", "WOULD", "YOUNG", "YIELD", "ZEBRA" };

	public String[] sixLetter = { "FATHER", "RHYTHM", "DESIGN", "FABRIC", "SUMMIT", "IMPACT", "YELLOW", "PURPLE",
			"POLISH", "COFFEE", "WINTER", "GARDEN", "SILVER", "SQUARE", "BRIGHT", "SCHOOL", "PARROT", "BEACON",
			"BUCKET", "SINGER", "BATTLE", "PENCIL", "ROBBER", "FRIDGE", "CIRCLE", "ORANGE", "WINDOW", "MARKET",
			"HAMMER", "BANANA", "TOWARD", "GUITAR", "CAMERA", "LETTER", "SPRING", "BUTTON", "TURTLE", "DESERT",
			"YELLOW", "CHAIRS", "GARDEN", "BOTTLE", "MONKEY", "LIZARD", "CANDLE", "FLOWER", "CHURCH", "SCHOOL",
			"COWBOY", "BASKET", "PALACE", "ISLAND", "CASTLE", "BIKING", "PARROT", "BRIGHT", "RABBIT", "ROCKET",
			"STRONG", "SECRET", "DOCTOR", "SUMMER", "POETRY", "BUTTON", "RAINOW", "CIRCUS", "MONKEY", "WINTER",
			"BOTTLE", "SILVER", "SQUARE", "SPRING", "TURTLE", "DESERT", "PURPLE", "CAMERA", "YELLOW", "FATHER",
			"LETTER", "BRIGHT", "SCHOOL", "GARDEN", "RHYTHM", "DESIGN", "CIRCLE", "ORANGE", "MARKET", "CHAIRS",
			"HAMMER", "BANANA", "COWBOY", "CASTLE", "SECRET", "PARROT", "FRIDGE", "TOWARD", "BUTTON", "SPRING",
			"SILVER", "MONKEY", "CANDLE", "BRIGHT", "STRONG", "WINDOW", "BOTTLE", "PURPLE", "SQUARE", "DESERT",
			"RHYTHM", "FATHER", "CAMERA" };

	public String[] sevenLetter = { "FRIENDS", "MYSTERY", "CHANGES", "TRAVELS", "JOURNEY", "HEAVENS", "OUTCOME",
			"PRESENT", "VICTORY", "PASSAGE", "WEALTHY", "KINGDOM", "PROMISE", "VIBRANT", "TROUBLE", "FAILURE",
			"EXPLORE", "CAPTAIN", "RADIANT", "COMMAND", "FLOWERS", "ELEVATE", "REVEALS", "WARRIOR", "BELIEVE",
			"HARMONY", "WISDOMS", "HEALING", "HORIZON", "QUALITY", "WONDERS", "BALANCE", "GROWTHS", "SPARKLE",
			"BLESSING", "GLORIOUS", "TREASON", "APPLIED", "THRIVES", "MIRACLE", "BRILLIA", "POWERFU", "PURPOSE",
			"SUNSETS", "TRUSTED", "MAJESTY", "TRAPPED", "PROTECT", "DISCORD", "GENTLEM", "JEWELRY", "REWARDS",
			"BEAUTIE", "FORGIVE", "CAPTURE", "MYSTERY", "CARRIES", "PROMISE", "SECURED", "WANDERS", "CONTENT",
			"ETERNAL", "SENSORY", "CAPABLE", "RESTORE", "VENTURE", "GLANCES", "SAILING", "CONQUER", "PLEASED",
			"SERVING", "LIGHTER", "SINCERE", "CERTAIN", "SOARING", "NATURAL", "GRANITE", "COURAGE", "FEELING",
			"SPRINGS", "BOULDER", "HOLDING", "CLASSIC", "DAZZLED", "BUNDLED", "POETRY", "ABSURDS", "FIREMAN", 
			"CHARGER", "FORWARD", "QUICKLY" };

	public Word() {

	}

	public String fiveLetterWord(int random) {
		random = randomNumber(0, 110);
		word = fiveLetter[random];
		return word;
	}

	public String sixLetterWord(int random) {
		random = randomNumber(0, 110);
		word = sixLetter[random];
		return word;
	}

	public String sevenLetterWord(int random) {
		random = randomNumber(0, 110);
		word = sevenLetter[random];
		return word;
	}

	private static int randomNumber(int a, int b) {
		int highNum = Math.max(a, b);
		int lowNum = Math.min(a, b);
		int range = highNum - lowNum + 1;
		return (int) (Math.random() * range) + lowNum;
	}

}
