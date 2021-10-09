import java.util.Scanner;
import java.util.regex.*;

public class Solution{

	String [] endingStatement (Scanner toolInput) {

		String homeStatus="on";
		String modeStatus="on";

		String[] endingReturn= new String [2];
		boolean outerLoop=true;
		while(outerLoop){
			String exitStatement="";
			String exitStatement2="";
			System.out.println("Apakah ingin mengakhiri aplikasi ? (Y/N)");

			while(exitStatement.equals("")) exitStatement = toolInput.nextLine();
			if (exitStatement.equals("Y")) {
				homeStatus="off"; modeStatus="off"; outerLoop=false;
			}
			else if (exitStatement.equals("N")) {
				while(true){
					exitStatement2="";
					System.out.println("Apakah ingin kembali ke home atau hitung lagi pada mode yang sama ? (home/hitung)");
					while(exitStatement2.equals("")) exitStatement2= toolInput.nextLine();
					if (exitStatement2.equals("home")) {
						modeStatus="off"; outerLoop=false; break;
					} else if (exitStatement2.equals("hitung")) {
							outerLoop=false;
							break; 
						}
					else {
						System.out.println("======================================");
						System.out.println("Masukan anda invalid. Pastikan ketik home atau hitung");
						System.out.println("======================================");
					}
				}
			} 
			else {
				System.out.println("======================================");
				System.out.println("Masukan anda invalid. Pastikan ketik Y atau N");
				System.out.println("======================================");
			}
		}
		endingReturn[0]=homeStatus; endingReturn[1]=modeStatus;
		return endingReturn;
	}

	 String countLetter (Scanner toolInput) {
		String input = "";
		String homeStatus="on";
		String modeStatus="on";

		while(modeStatus.equals("on")){
			input="";

			System.out.println("Selamat datang di mode 1");
			System.out.println("Masukkan kalimat yang ingin dihitung hurufnya : ");
			while (input.equals("")) input = toolInput.nextLine();
			
			String [] inputSplit  = input.split(" ");
			int totalLetter = 0;
			for (String subInput:inputSplit) totalLetter+=subInput.length();
			System.out.println("Jumlah huruf : " + totalLetter);
			
			String [] endingVar = endingStatement(toolInput);
			homeStatus = endingVar[0]; modeStatus = endingVar[1];
		}
		return homeStatus;
	}

	String countWord (Scanner toolInput) {
		String input = "";
		String homeStatus="on";
		String modeStatus="on";
		while(modeStatus.equals("on")){
			input="";
	
			System.out.println("Selamat datang di mode 2");
			System.out.println("Masukkan kalimat yang ingin dihitung jumlah katanya : ");
			while (input.equals("")) input = toolInput.nextLine();
			System.out.println("Jumlah kata : " + input.split(" ").length);
	
			String [] endingVar = endingStatement(toolInput);
			homeStatus = endingVar[0]; modeStatus = endingVar[1];
		}
		return homeStatus;
	}
	
	String countVowels(Scanner toolInput) {
		String input = "";
		String homeStatus="on";
		String modeStatus="on";
		while(modeStatus.equals("on")){
			input="";

			System.out.println("Selamat datang di mode 2");
			System.out.println("Masukkan kalimat yang ingin dihitung jumlah huruf vokalnya : ");
			while (input.equals("")) input = toolInput.nextLine();
			
			Pattern pattern  = Pattern.compile("[AIUEOaioueo]");
			Matcher matcher  = pattern.matcher(input);
			int totalVowels = 0;
			while(matcher.find()) ++totalVowels;
			System.out.println("Jumlah huruf vokal : " + totalVowels);

			String [] endingVar = endingStatement(toolInput);
			homeStatus = endingVar[0]; modeStatus = endingVar[1];
		}
		return homeStatus;
	}

	public static void main(String[] args){
		Solution solution = new Solution ();

		Scanner toolInput = new Scanner (System.in);	
		String homeStatus = "on";
		
		while (homeStatus.equals("on")) {
			String mode="0";

			System.out.println("Silahkan masukkan mode perhitungan : ");
			System.out.printf("1. Jumlah huruf\n2. Jumlah kata\n3. Jumlah huruf vokal\n");
			while(Integer.parseInt(mode)==0) {
				mode = toolInput.nextLine();
				if (Integer.parseInt(mode)>3 || Integer.parseInt(mode)<0) {
					System.out.println("======================================");
					System.out.println("Pastikan pilihan anda dari 1-3.");
					System.out.println("Silahkan masukkan kembali pilhan anda.");
					System.out.println("======================================");
					mode="0";
				}
			}
			System.out.println("------------------------------------");

			switch (mode){
				case "1" :
					homeStatus= solution.countLetter(toolInput);
					break;
				case "2" :
					homeStatus= solution.countWord(toolInput);
					break;
				case "3" :
					homeStatus= solution.countVowels(toolInput);
					break;
			}

		}
		toolInput.close();		
	}
}
