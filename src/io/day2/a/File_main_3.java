package io.day2.a;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class File_main_3 {

/*
 	>>> File 클래스 <<<
 	자바에서 File 클래스 객체이라함은 파일 및 폴더(디렉토리)를 다 포함한다.
 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print
		("탐색기에 존재하는 파일명을 입력하세요 : ");
		String fileName = sc.nextLine();
		// C:/iotestdata/원본/쉐보레전면.jpg
		
		File file1 = new File(fileName);
		
		System.out.println("파일명만 : " + file1.getName());
		// file1.getName() ; 파일명만 알려주는것
		// 파일명만 : 쉐보레전면.jpg
		
		long fileSize = file1.length();
		System.out.println("파일크기 : "+ fileSize + " byte");
		// 파일크기 : 131110 byte

		String absolutePath = file1.getAbsolutePath();
		System.out.println("파일의 절대경로 : " + absolutePath);
		// 파일의 절대경로 : C:\iotestdata\원본\쉐보레전면.jpg
		
		String path = file1.getPath();
		System.out.println("파일의 경로 : " + path);
		// 파일의 경로 : C:\iotestdata\원본\쉐보레전면.jpg

		
		System.out.println("============================\n");
		
		System.out.println(">>> 디렉토리(폴더) 생성하기 <<<");
		
		File dir = new File("C:/iotestdata/Mydir");
		
		boolean bool = false;
		
		if( !dir.exists() ) {
			// 해당 디렉토리가 없으면
			bool = dir.mkdir();// 해당 디렉토리를 생성해라.
		
			String result = bool?"디렉토리(폴더) 생성 성공!!":"디렉토리(폴더) 생성 실패!!";
		
			System.out.println("C:/iotestdata/MyDir "+result);
		}
		
		// >> dir이 디렉토리인지 알아오기 <<
		if(dir.isDirectory()) {
			System.out.println("C:/iotestdata/MyDir 은 디렉토리(폴더) 입니다.");
		}
		
		System.out.println("============================\n");
		
		System.out.println(">>> 파일 생성하기 <<<");
		
		File file2 = new File("C:/iotestdata/Mydir/테스트1.txt");
		
		if( !file2.exists() ) {
			// 해당 파일이 존재하지 않으면
			
			try {
				bool = file2.createNewFile(); // 파일생성하기
		
				if(bool) {
					// 해당파일이 정상적으로 생성되었다면,
					System.out.println("테스트1.txt 의 절대경로 :" + file2.getAbsolutePath());
				}
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		// >> file2 가 파일인지 알아오기 <<
				if(file2.isFile()) {
					System.out.println("C:/iotestdata/Mydir/테스트1.txt 은 파일 입니다.");
				}
		
				
		System.out.println("============================\n");
		
		System.out.println(">>> 파일 삭제하기 <<<");		
	
		bool = file2.delete();// 파일 삭제하기
		String result = bool?"삭제 성공!!":"삭제 실패!!";
		System.out.println(result);
		
		System.out.println("============================\n");
		
		System.out.println(">>> 텅빈디렉토리(폴더) 삭제하기 <<<");		
		
		if(dir.exists()) {
			dir.delete(); // 텅빈디렉토리 삭제하기
			result = bool?"C:\\iotestdata\\Mydir 폴더 삭제 성공!!":"C:\\iotestdata\\Mydir 폴더 삭제 실패!!";
			System.out.println(result);
		}
		
		System.out.println("============================\n");
		
		System.out.println(">>> 내용물이 들어있는 디렉토리(폴더) 삭제하기 실패한 예제 <<<");		
		// 먼저 아래의 실습을 하려면 탐색기에서 C:\iotestdata\ 밑에 images 라는 폴더를 생성하고
	    // images 폴더 속에 파일을 몇 개 올려둔다.
		
		File imagesDir = new File("C:/iotestdata/images");
		
		if(imagesDir.exists()) {
			bool = imagesDir.delete(); // 디렉토리 삭제하기
			result = bool?"C:\\iotestdata\\images 폴더 삭제 성공!!":"C:\\iotestdata\\images 폴더 삭제 실패!!";
			System.out.println(result);
		}
		
		
		System.out.println("============================\n");
		
		System.out.println(">>> 내용물이 들어있는 디렉토리(폴더) 삭제하기 성공한 예제 <<<");		
		// 1. 내용물이 들어있는 디렉토리(폴더)내에 존재하는 내용물을 파악한다.
		File[] deleteFileArr = imagesDir.listFiles();
		
		for(int i=0; i<deleteFileArr.length;i++) {
			String absolutePath_2 = deleteFileArr[i].getAbsolutePath();
			System.out.println(absolutePath_2);
		} // end of for ---------------
		
		/*
		C:\iotestdata\images\쉐보레전면.jpg
		C:\iotestdata\images\스크린샷(1).png
		C:\iotestdata\images\스크린샷(2).png
		*/
		
		// C:\\iotestdata\images 폴더내에 파일들을 모두 삭제한다.
		for(int i=0; i<deleteFileArr.length;i++) {
			deleteFileArr[i].delete();
		} // end of for ---------------
		bool = imagesDir.delete();
		// C:\iotestdata\images 폴더는 텅빈디렉토리(폴더)이므로 폴더가 삭제가 가능해진다.
		
		result = bool?"C:\\iotestdata\\images 폴더 삭제 성공!!":"C:\\iotestdata\\images 폴더 삭제 실패!!";
		System.out.println(result);
		//C:\iotestdata\images 폴더 삭제 성공!!

		
		
		sc.close();
		
	} // end of main --------------------

}
