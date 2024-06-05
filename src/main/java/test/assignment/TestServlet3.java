package test.assignment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dopamines3")
public class TestServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        List<Human> humanList = new ArrayList<>();
//        Snack snack1 = new Snack("맛동산",1000,"달달구리");
//        Snack snack2 = new Snack("꼬깔콘",1000,"짭쪼롬");
//        Snack snack3 = new Snack("도리토스",1000,"짭쫄쌈@뽕");
//        Snack snack4 = new Snack("미쯔블랙",1000,"초코존맛");
//        Snack snack5 = new Snack("스윙칩",1000,"스윙스돈까스");
//        Snack snack6 = new Snack("오!감자",1000,"오오");
//        Snack snack7 = new Snack("태양의 맛! 썬",1000,"이건 뭔 과자여");
//
//        humanList.add(new Human("곽동현",99));
//        humanList.get(0).addSnacks(snack1);
//        humanList.get(0).addSnacks(snack2);
//
//        humanList.add(new Human("최수빈",01));
//        humanList.get(1).addSnacks(snack3);
//        humanList.get(1).addSnacks(snack4);
//
//        humanList.add(new Human("최승은",98));
//        humanList.get(2).addSnacks(snack1);
//        humanList.get(2).addSnacks(snack3);
//        humanList.get(2).addSnacks(snack2);
//        humanList.get(2).addSnacks(snack5);
//        humanList.get(2).addSnacks(snack4);
//
//         BaseResponse3 baseResponse = new BaseResponse3(null,humanList);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonResponse = objectMapper.writeValueAsString(baseResponse);
//
//        //응답 설정
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(jsonResponse);

    }

    public static void main(String[] args) throws JsonProcessingException {
        List<Human> humanList = new ArrayList<>();
        Snack snack1 = new Snack("맛동산",1000,"달달구리");
        Snack snack2 = new Snack("꼬깔콘",1000,"짭쪼롬");
        Snack snack3 = new Snack("도리토스",1000,"짭쫄쌈@뽕");
        Snack snack4 = new Snack("미쯔블랙",1000,"초코존맛");
        Snack snack5 = new Snack("스윙칩",1000,"스윙스돈까스");
        Snack snack6 = new Snack("오!감자",1000,"오오");
        Snack snack7 = new Snack("태양의 맛! 썬",1000,"이건 뭔 과자여");

        humanList.add(new Human("곽동현",99));
        humanList.get(0).addSnacks(snack1);
        humanList.get(0).addSnacks(snack2);

        humanList.add(new Human("최수빈",01));
        humanList.get(1).addSnacks(snack3);
        humanList.get(1).addSnacks(snack4);

        humanList.add(new Human("최승은",98));
        humanList.get(2).addSnacks(snack1);
        humanList.get(2).addSnacks(snack3);
        humanList.get(2).addSnacks(snack2);
        humanList.get(2).addSnacks(snack5);
        humanList.get(2).addSnacks(snack4);

        for (Human human : humanList) {
            System.out.println("이름 :"+ human.getName());
            System.out.println("나이 :"+ human.getAge() + " 년생");
            System.out.println("먹고있는 과자 :"+ human.getSnacks().toString());
            System.out.println();
        }




    }
}
