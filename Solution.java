import java.util.Scanner;
import java.util.regex.*;

public class Solution{

	String [] endingStatement (Scanner toolInput,
				String exitStatement, String exitStatement2,
				String homeStatus, String modeStatus) {

		String[] endingReturn= new String [4];
		boolean outerLoop=true;
		while(outerLoop){
			endingReturn[0]=exitStatement; endingReturn[1]=exitStatement2; endingReturn[2]=homeStatus;
			endingReturn[3]=modeStatus;
			System.out.println("Apakah ingin mengakhiri aplikasi ? (Y/N)");

			while(endingReturn[0].equals("")) endingReturn[0] = toolInput.nextLine();
			if (endingReturn[0].equals("Y")) {
				endingReturn[2]="off"; endingReturn[3]="off"; outerLoop=false;
			}
			else if (endingReturn[0].equals("N")) {
				while(true){
					endingReturn[1]=exitStatement2;
					System.out.println("Apakah ingin kembali ke home atau hitung lagi pada mode yang sama ? (home/hitung)");
					while(endingReturn[1].equals("")) endingReturn[1]= toolInput.nextLine();
					if (endingReturn[1].equals("home")) {
						endingReturn[3]="off"; outerLoop=false; break;
					} else if (endingReturn[1].equals("hitung")) {
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
		return endingReturn;
	}

	public static void main(String[] args){
		Solution solution = new Solution ();

		Scanner toolInput = new Scanner (System.in);	
		String homeStatus = "on";
		
		while (homeStatus.equals("on")) {
			int mode=0;
			String modeStatus = "on";
			String input="";
			String exitStatement="";
			String exitStatement2="";

			System.out.println("Silahkan masukkan mode perhitungan : ");
			System.out.printf("1. Jumlah huruf\n2. Jumlah kata\n3. Jumlah huruf vokal\n");
			while(mode==0) {
				mode = toolInput.nextInt();
				if (mode>3 || mode<0) {
					System.out.println("======================================");
					System.out.println("Pastikan pilihan anda dari 1-3.");
					System.out.println("Silahkan masukkan kembali pilhan anda.");
					System.out.println("======================================");
					mode=0;
				}
			}
			System.out.println("------------------------------------");

			while(mode==1 && modeStatus.equals("on")){
				input=""; exitStatement=""; exitStatement2="";

				System.out.println("Selamat datang di mode 1");
				System.out.println("Masukkan kalimat yang ingin dihitung hurufnya : ");
				while (input.equals("")) input = toolInput.nextLine();
				
				String [] inputSplit  = input.split(" ");
				int totalLetter = 0;
				for (String subInput:inputSplit) totalLetter+=subInput.length();
				System.out.println("Jumlah huruf : " + totalLetter);
				
				String [] endingVar = solution.endingStatement(toolInput, exitStatement, 
								exitStatement2, homeStatus, modeStatus);
				exitStatement = endingVar[0]; exitStatement2 = endingVar[1]; homeStatus = endingVar[2];
				modeStatus = endingVar[3];
			}
			while(mode==2  && modeStatus.equals("on")){
				input=""; exitStatement=""; exitStatement2="";

				System.out.println("Selamat datang di mode 2");
				System.out.println("Masukkan kalimat yang ingin dihitung jumlah katanya : ");
				while (input.equals("")) input = toolInput.nextLine();
				System.out.println("Jumlah kata : " + input.split(" ").length);

				String [] endingVar = solution.endingStatement(toolInput, exitStatement, 
								exitStatement2, homeStatus, modeStatus);
				exitStatement = endingVar[0]; exitStatement2 = endingVar[1]; homeStatus = endingVar[2];
				modeStatus = endingVar[3];
			}
			while(mode==3 && modeStatus.equals("on")){
				input=""; exitStatement=""; exitStatement2="";

				System.out.println("Selamat datang di mode 2");
				System.out.println("Masukkan kalimat yang ingin dihitung jumlah huruf vokalnya : ");
				while (input.equals("")) input = toolInput.nextLine();
				
				Pattern pattern  = Pattern.compile("[AIUEOaioueo]");
				Matcher matcher  = pattern.matcher(input);
				int totalVowels = 0;
				while(matcher.find()) ++totalVowels;
				System.out.println("Jumlah huruf vokal : " + totalVowels);

				String [] endingVar = solution.endingStatement(toolInput, exitStatement, 
				exitStatement2, homeStatus, modeStatus);
				exitStatement = endingVar[0]; exitStatement2 = endingVar[1]; homeStatus = endingVar[2];
				modeStatus = endingVar[3];
			}
		}
		toolInput.close();		
	}
}
