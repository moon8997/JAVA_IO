package io.day2.b;

import java.io.*;

public class OutputStreamWriter_main_5 {
/*
    소스 - "C:/iotestdata/오늘의날씨.txt"
    FileReader ==> 2byte기반
    
    브릿지 스트림 OutputStreamReader => 1byte 를 12yte 로 변경 
    목적지 - 출력노드 스트림 System.out => 1byte기반
*/
	public static void main(String[] args) {
		
		try {
			String srcFileName = "C:/iotestdata/오늘의날씨.txt";
			FileReader fr = new FileReader(srcFileName);
			// fr 은 2byte 기반임
			
			OutputStreamWriter ostReader = new OutputStreamWriter(System.out);
			// 모니터에서 출력되는 것은 1byte 기반인데 이것은 2byte 기반으로 변경해주는 것이다.
			
			int input = 0;
			
			while( (input = fr.read()) != -1){
				ostReader.write(input);
				ostReader.flush();
			} // end of while
			
			ostReader.close();
			fr.close();
			
			
		} catch(IOException e){
			e.printStackTrace();
		}
	}	// end of main -=============================
/*
실행은 아래와 같이 명령프롬프트에서 한다.
C:\NCS\workspace(java)\IO\bin>java io.day2.b.OutputStreamWriter_main_5
오늘은 아침부터 춥다가 오후는 좀 풀리겠습니다

 */
}
