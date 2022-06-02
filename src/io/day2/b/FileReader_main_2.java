package io.day2.b;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.util.FileManager;

public class FileReader_main_2 {

	public static void main(String[] args) {
		// 읽어들일 파일명은 명령프롬포트에서 파라미터로 주겠다.
/*
		String str1 = args[0];
		String str2 = args[1];
		
		System.out.println("str1 => " + str1);
		System.out.println("str2 => " + str2);
*/
	
	// 특정파일명에 해당하는 내용들을 읽어다가 화면에 출력하고자 한다
	// 그런데 그 특정파일명의 내용은 글자로만 이루어진 파일이다.
		
		String str = null;
		try {
			str = FileManager.reading_2(args[0]);
		} catch (FileNotFoundException e) {
			System.out.println("파일 "+ args[0] + " 이 존재하지 않습니다.");
		//	e.printStackTrace();
		} catch (IOException e) {
			System.out.println("파일 "+ args[0] + " 이 손상되었습니다.");
		//	e.printStackTrace();
		}
		// args[0] 에 C:/iotestdata/애국가.txt로 할 것이다.
		
		System.out.println(str);
		
	} // end of main-----------------------------
/* 
실행은 명령프롬프트에서 아래와 같이 한다.
C:\NCS\workspace(java)\IO\bin>java io.day2.b.FileReader_main_2 C:/iotestdata/애국가2.txt
C:/iotestdata/애국가2.txt 파일은 인코딩을 ANSI로 저장한다.
*/
}
