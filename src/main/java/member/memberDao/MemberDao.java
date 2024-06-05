package member.memberDao;

import com.zaxxer.hikari.HikariDataSource;
import config.BaseResponse;
import config.BaseResponse3;
import config.BaseResponseMessage;
import config.DataSourceConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import member.request.MemberLoginRequestDto;
import member.request.MemberSignupRequestDto;

public class MemberDao {
    HikariDataSource dataSourceConfig;

    public MemberDao() {
        dataSourceConfig = DataSourceConfig.getInstance();
    }

    public BaseResponse create(MemberSignupRequestDto dto) {
        //히카리풀 연동
        System.out.println(dataSourceConfig);
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            connection = dataSourceConfig.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM boot_up.user WHERE email='"+dto.getEmail()+"'");

            int count = 0;
            while(rs.next()){
                count++;
            }

            if(count>=1){
                System.out.println("회원있음 Error");
                BaseResponse response = new BaseResponse(BaseResponseMessage.MEMBER_REGISTER_FAIL_EMAIL_DUPLICATE);
                return response;
//                jsonResponse = objectMapper.writeValueAsString(response);
            }
            else {
                System.out.println("회원가입 성공!!(추후 DB 저장 필요) ");
                BaseResponse response = new BaseResponse(BaseResponseMessage.MEMBER_REGISTER_SUCCESS);
                return response;
            }
            // 결과를 json형식의 응답
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 중복 이메일 확인

    }

    public BaseResponse login(MemberLoginRequestDto dto) {
        //히카리풀 연동
        System.out.println(dataSourceConfig);
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            connection = dataSourceConfig.getConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM boot_up.user WHERE email='"+dto.getEmail()+"' AND password='"+dto.getPassword()+"'");

            int count = 0;
            while(rs.next()){
                count++;
            }

            if(count==1){
                System.out.println("로그인 성공");
                BaseResponse response = new BaseResponse(BaseResponseMessage.MEMBER_LOGIN_SUCCESS);
                return response;
//                jsonResponse = objectMapper.writeValueAsString(response);
            }
            else {
                System.out.println("로그인 실패");
                BaseResponse response = new BaseResponse(BaseResponseMessage.MEMBER_LOGIN_FAIL);
                return response;
            }
            // 결과를 json형식의 응답
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
