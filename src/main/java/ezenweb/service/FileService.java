package ezenweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.UUID;

@Service
/* 파일 관련 메소드 정의 */
public class FileService {
    
    // 파일 경로 [배포전]
    private String fileRootPath = "C:\\java\\";
    
    // 1. 업로드
    public String fileUpload(MultipartFile multipartFile){
        
        // 유효성 검사
            // 파일이 비어있는 경우 return
        if( multipartFile.isEmpty() )   return null;

        // 1. 파일명
            // UUID를 이용한 파일 식별자 만들기
        String fileName = UUID.randomUUID().toString()+"_"
                +multipartFile.getOriginalFilename().replaceAll("_", "-");
            // 파일명-UUID 간 구분을 위해 '_'를 '-'로 변경
        
        // 2. 파일 경로
        File file = new File( fileRootPath + fileName );
        
        // 3. 업로드
        try {
            multipartFile.transferTo( file );
            return fileName;    // 성공시 파일명 리턴 [ DB에 저장하기 위함 ]
        } catch ( Exception e ){
            System.out.println( "업로드 실패 : "+e );
            return null;    // 실패시 null 리턴
        }

    }

    @Autowired
    private HttpServletResponse response;
    // 2. 다운로드
    public void fileDownload( String uuidFile ){

        // 1. 다운로드할 파일명 찾기
        String downloadFilePath = fileRootPath + uuidFile;
        // 2. uuid 제거된 순수 파일명 [ uuid 제거 ]
        String fileName = uuidFile.split("_")[1];   // _ 기준으로 쪼갠 후 뒷자리 파일명만 호출

        try {

            // 3. 다운로드 형식 구성
            response.setHeader( "Content-Disposition", "attachment; filename="+ URLEncoder.encode(fileName, "UTF-8"));

            // 4. 다운로드
            // ---------------------------- 서버가 해당 파일 읽어오기
                // 1. 서버가 해당 파일 읽어오기
            File file = new File( downloadFilePath );
                // 2. 버퍼스트림을 이용한 바이트로 파일 읽어오기
            BufferedInputStream fin = new BufferedInputStream( new FileInputStream( file ) );
                // 3. 파일의 용량[바이트] 만큼 바이트배열에 선언
            byte[] bytes = new byte[ (int) file.length() ];
                // 4. 버퍼스트림이 읽어온 바이트들을 바이트배열에 저장
            fin.read( bytes );

            // --------------------------- 서버가 읽어온 파일을 클라이언트에게 응답하기
                // 1. 버퍼스트림 이용한 response 으로 응답하기
            BufferedOutputStream fout = new BufferedOutputStream( response.getOutputStream() );
                // 2. 읽어온 바이트[파일] 내보내기
            fout.write( bytes );        // bytes 배열의 데이터를 클라이언트에게 전달
                // 3. 안전하게 스트림 닫기
            fout.flush();               // 출력 스트림에 있는 모든 버퍼를 비우고, 아직 버퍼에 남아있는 데이터를 클라이언트에게 보냄
            fout.close();               // 출력 스트림을 닫음으로써 데이터를 더 이상 보내지 않음
            fin.close();

        } catch (Exception e) {
            System.out.println( "다운로드 실패" );
            System.out.println(e);
        }



    }
    
    
}
