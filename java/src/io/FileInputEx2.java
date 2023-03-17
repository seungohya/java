package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputEx2 {
	public static void main(String[] args) {
		// copy ( C:\\temp\\file1.txt => C:\\temp\\file2.txt )
		
//		FileInputStream fis = null;
//		FileOutputStream fos = null;
//		
//		
//		try {
//			// 원본 파일 읽기
//			// 읽어온 내용을 새로운 파일에 쓰기
//			
//			// 텍스트
////			fis = new FileInputStream("C:\\temp\\file1.txt");
////			fos = new FileOutputStream("C:\\temp\\file2.txt");
//			
//			// 이미지
////			fis = new FileInputStream("C:\\temp\\pexels-christian-heitz-842711.jpg");
////			fos = new FileOutputStream("C:\\temp\\copy.jpg");
//			
//			//동영상
//			fis = new FileInputStream("C:\\temp\\iu.mp4");
//			fos = new FileOutputStream("C:\\temp\\iucopy.mp4");
//			
//			
//			int data = 0;
//			while((data=fis.read())!=-1) {
//				fos.write(data);
//			}	
//			
//			// FileNotFoundException 은 IOException 이 처리 가능
//		} catch (IOException e) {			
//			e.printStackTrace();
//		} finally {
//			try {
//				fis.close();
//				fos.close();
//			} catch (IOException e) {				
//				e.printStackTrace();
//			}
//		}	
		
		try(FileInputStream fis = new FileInputStream("C:\\temp\\iu.mp4");
				FileOutputStream fos = new FileOutputStream("C:\\temp\\iucopy.mp4")) {
			// 원본 파일 읽기
			// 읽어온 내용을 새로운 파일에 쓰기
			
			// 텍스트
//			fis = new FileInputStream("C:\\temp\\file1.txt");
//			fos = new FileOutputStream("C:\\temp\\file2.txt");
			
			// 이미지
//			fis = new FileInputStream("C:\\temp\\pexels-christian-heitz-842711.jpg");
//			fos = new FileOutputStream("C:\\temp\\copy.jpg");
			
			//동영상
			
			
			
			int data = 0;
			while((data=fis.read())!=-1) {
				fos.write(data);
			}	
			
			// FileNotFoundException 은 IOException 이 처리 가능
		} catch (IOException e) {			
			e.printStackTrace();
		} 
		

	}
}
















