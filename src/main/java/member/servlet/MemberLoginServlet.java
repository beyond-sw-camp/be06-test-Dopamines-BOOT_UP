package member.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse;
import member.memberDao.MemberDao;
import member.request.MemberLoginRequestDto;
import member.request.MemberSignupRequestDto;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/login")
public class MemberLoginServlet extends HttpServlet {
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
        MemberLoginRequestDto dto = objectMapper.readValue(json.toString(), MemberLoginRequestDto.class);

        MemberDao memberDao = new MemberDao();
        BaseResponse response = memberDao.login(dto);

        String jsonResponse;
        jsonResponse = objectMapper.writeValueAsString(response);
        //응답 설정
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }
}