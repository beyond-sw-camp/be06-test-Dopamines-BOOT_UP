package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse3;
import config.BaseResponseMessage;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //클라이언트의 요청을 받아서, DTO에 저장하는 부분
        BufferedReader br = req.getReader();
        StringBuilder json = new StringBuilder();
        String line;
        while((line = br.readLine()) != null){
            json.append(line);
        }
        ObjectMapper objectMapper = new ObjectMapper();

        // 객체형태로 받아라?
        MemberSignupRequestDto dto = objectMapper.readValue(json.toString(), MemberSignupRequestDto.class);

        // 회원 가입하는 DAO의 메소드 실행
        Boolean result = true;


        // 결과를 json형식의 응답
        String jsonResponse;
        if(result){
            BaseResponse3 response = new BaseResponse3(BaseResponseMessage.MEMBER_REGISTER_SUCCESS);
            jsonResponse = objectMapper.writeValueAsString(response);
        } else{
            BaseResponse3 response = new BaseResponse3(BaseResponseMessage.MEMBER_REGISTER_FAIL_PASSWORD_COMPLEXITY);
            jsonResponse = objectMapper.writeValueAsString(response);
        }
        //응답 설정
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);

    }
}
