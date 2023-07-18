import java.util.Scanner;

class Guesser {
	int guessNum;

	int getNumFromGuesser() {
		System.out.println("Guesser guess the Number between 0 and 10 only");
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		int checkNum = checkNum(temp);
		if (checkNum == 0) { 
			getNumFromGuesser(); 
		} else {
			guessNum = temp;
		}
		return guessNum;
	}

	int checkNum(int num) {
		int checkNum = num;
		if (checkNum >= 0 && checkNum <= 10) {
			return checkNum;
		} else {
			return 0;
		}
	}

}

class Player {
	int guessNum;

	int getNumFromPlayer1() {
		System.out.println("Player 1 guess the Number between 0 and 10 only");
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		int checkNum = checkNum(temp);
		if (checkNum == 0) {
			getNumFromPlayer1();
		} else {
			guessNum = temp;
		}
		return guessNum;
	}

	int getNumFromPlayer2() {
		System.out.println("Player 2 guess the Number between 0 and 10 only");
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		int checkNum = checkNum(temp);
		if (checkNum == 0) {
			getNumFromPlayer2();
		} else {
			guessNum = temp;
		}
		return guessNum;
	}

	int getNumFromPlayer3() {
		System.out.println("Player 3 guess the Number between 0 and 10 only");
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt();
		int checkNum = checkNum(temp);
		if (checkNum == 0) {
			getNumFromPlayer3();
		} else {
			guessNum = temp;
		}
		return guessNum;
	}

	int checkNum(int num) {
		int checkNum = num;
		if (checkNum >= 0 && checkNum <= 10) {
			return checkNum;
		} else {
			return 0;
		}
	}
}

class Umpire {
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	int[] resArray = new int[3];

	void getGuesserNum() {
		Guesser g = new Guesser();
		numFromGuesser = g.getNumFromGuesser();
	}

	void getPlayerNum() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		/*
		 * numFromPlayer1 = p1.getNumFromPlayer1(); numFromPlayer2 =
		 * p2.getNumFromPlayer2(); numFromPlayer3 = p3.getNumFromPlayer3();
		 */
		resArray[0] = p1.getNumFromPlayer1();
		resArray[1] = p2.getNumFromPlayer2();
		resArray[2] = p3.getNumFromPlayer3();

	}

	void results(int[] semiArr) {
		for (int i = 0; i < semiArr.length; i++) {
			if (semiArr[i] == 1) {
				int res = i + 1;
				System.out.println("Player  " + res + " " + "won the game!");
			}
		}
	}

	void Final(int[] semiArr) {
		int semiCount = 0;
		int[] resArr = new int[2];
		for (int i = 0; i < semiArr.length; i++) {
			if (semiArr[i] == 1) {
				resArr[semiCount++] = i + 1;
			}
		}
		/*
		 * for(int res:resArr) { System.out.println(res+"semi"); }
		 */
		int p1ForSemi = resArr[0];
		int p2ForSemi = resArr[1];
		if (p1ForSemi == 1 && p2ForSemi == 2) {
			checkResult(p1ForSemi, p2ForSemi);

		} else if (p1ForSemi == 2 && p2ForSemi == 3) {
			checkResult(p1ForSemi, p2ForSemi);
		} else {
			checkResult(p1ForSemi, p2ForSemi);

		}
	}

	void checkResult(int p1, int p2) {

		Guesser g = new Guesser();
		int semiNumFromGuesser;
		int sp1Num, sp2Num, sp3Num;
		Player sp1, sp2, sp3;
		if (p1 == 1 && p2 == 2) {
			System.out.println("Player 3 is out of race for Finals");
			System.out.println("Final begins between Player 1 and 2");
			semiNumFromGuesser = g.getNumFromGuesser();
			sp1 = new Player();
			sp1Num = sp1.getNumFromPlayer1();
			sp2 = new Player();
			sp2Num = sp2.getNumFromPlayer2();
			if (semiNumFromGuesser == sp1Num) {
				if (semiNumFromGuesser == sp2Num) {
					System.out.println("Player 1 & 2 both won the Final");
				} else {
					System.out.println("Player 1 won the Final Match!!!!");
					// semiFinal(resArray);
				}

			} else if (semiNumFromGuesser == sp2Num) {
				System.out.println("Player 2 won the Final Match!!!!");
			} else {
				System.out.println("Players you have guessed the wrong number!!!!");
				System.out.println("Do you want to play final once again?Yes/No");
				Scanner sc = new Scanner(System.in);
				String res = sc.nextLine();
				if (res.equalsIgnoreCase("Yes")) {
					checkResult(p1, p2);
				} else if (res.equalsIgnoreCase("No")) {
					System.out.println("There is a tie between Player 1 and Player 2");
				}

			}

		} else if (p1 == 2 && p2 == 3) {
			System.out.println("Player 1 is out of race for Finals");
			System.out.println("Final begins between Player 2 and 3");
			semiNumFromGuesser = g.getNumFromGuesser();
			sp2 = new Player();
			sp2Num = sp2.getNumFromPlayer2();
			sp3 = new Player();
			sp3Num = sp3.getNumFromPlayer3();
			if (semiNumFromGuesser == sp2Num) {
				if (semiNumFromGuesser == sp3Num) {
					System.out.println("Player 2 & 3 both won the Final");
				} else {
					System.out.println("Player 2 won the Final Match!!!!");
					// semiFinal(resArray);
				}

			} else if (semiNumFromGuesser == sp3Num) {
				System.out.println("Player 3 won the Final Match!!!!");
			} else {
				System.out.println("Players you have guessed the wrong number!!!!");
				System.out.println("Do you want to play final once again?Yes/No");
				Scanner sc = new Scanner(System.in);
				String res = sc.nextLine();
				if (res.equalsIgnoreCase("Yes")) {
					checkResult(p1, p2);
				} else if (res.equalsIgnoreCase("No")) {
					System.out.println("There is a tie between Player 2 and Player 3");
				}
			}
		} else {
			System.out.println("Player 2 is out of race for Finals");
			System.out.println("Final begins between Player 1 and 3");
			semiNumFromGuesser = g.getNumFromGuesser();
			sp1 = new Player();
			sp1Num = sp1.getNumFromPlayer1();
			sp3 = new Player();
			sp3Num = sp3.getNumFromPlayer2();
			if (semiNumFromGuesser == sp1Num) {
				if (semiNumFromGuesser == sp3Num) {
					System.out.println("Player 1 & 3 both won the Final");
				} else {
					System.out.println("Player 1 won the Final Match!!!!");
					// semiFinal(resArray);
				}

			} else if (semiNumFromGuesser == sp3Num) {
				System.out.println("Player 3 won the Final Match!!!!");
			} else {
				System.out.println("Players you have guessed the wrong number!!!!");
				System.out.println("Do you want to play final once again?Yes/No");
				Scanner sc = new Scanner(System.in);
				String res = sc.nextLine();
				if (res.equalsIgnoreCase("Yes")) {
					checkResult(p1, p2);
				} else if (res.equalsIgnoreCase("No")) {
					System.out.println("There is a tie between Player 1 and Player 3");
				}
			}
		}
	}

	void playOnceMore() {
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		/*
		 * numFromPlayer1 = p1.getNumFromPlayer1(); numFromPlayer2 =
		 * p2.getNumFromPlayer2(); numFromPlayer3 = p3.getNumFromPlayer3();
		 */

		resArray[0] = p1.getNumFromPlayer1();
		resArray[1] = p2.getNumFromPlayer2();
		resArray[2] = p3.getNumFromPlayer3();
		checkResult();
	}

	void checkResult() {
		int wrongCount = 0;
		int rightCount = 0;
		for (int i = 0; i < 3; i++) {

			if (resArray[i] == numFromGuesser) {
				resArray[i] = 1;
				rightCount++;
			} else {
				wrongCount++;
				resArray[i] = 0;
				// System.out.println("All guessed the wrong number");
			}
		}
		/*
		 * for (int i = 0; i < 3; i++) { if(resArray[i]==0) { count++;
		 * System.out.println(count); } }
		 */
		// System.out.println(count);
		if (wrongCount == 3) {
			System.out.println("All guessed the wrong number! Restarting the Game!!!!!!");
			playOnceMore();
			// wrongCount=0;
		} else if (rightCount == 2) {
			Final(resArray);
		} else if (rightCount == 1) {
			// System.out.println("Player 1 won the match");
			results(resArray);

		} else {
			System.out.println("All won the game!!!!");
		}

	}

}

public class ProjectGame {

	public static void main(String[] args) {
		Umpire u = new Umpire();
		u.getGuesserNum();
		u.getPlayerNum();
		u.checkResult();
	}

}
