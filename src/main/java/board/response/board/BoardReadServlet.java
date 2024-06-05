package board.response.board;

import board.response.PostsDtoResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import config.BaseResponse;
import config.BaseResponseMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet("/board")
public class BoardReadServlet extends HttpServlet {
//    BoardDao dao;
//    ObjectMapper mapper;

//    @Override
//    public void init() {
//        dao = new BoardDao();
//        mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardDao dao = new BoardDao();
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        Long idx = Long.parseLong(req.getParameter("idx"));
        PostsDtoResponse post = dao.readPosts(idx);
        String jsonResponse = mapper.writeValueAsString(post);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    }
}

//
//@WebServlet("/board")
//public class BoardServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String action = req.getParameter("action");
//        String postIdx = req.getParameter("idx");
//
//        resp.setContentType("text/html;charset=UTF-8");
////        PrintWriter out = resp.getWriter();
//            Connection connection = null;
//            Statement stmt = null;
//            ResultSet rs = null;
//
//        BoardDao dao = new BoardDao();
//        List<PostsDtoResponse> postsDtoResponses = dao.readAllPosts();
////        System.out.println("가나다라마바사");
//        System.out.println(postsDtoResponses);
//
//
//            try {
//                stmt = connection.createStatement();
//                rs = stmt.executeQuery("SELECT * FROM free_board");
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

//package board.response.board;
//
//import board.response.PostsDtoResponse;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet("/board")
//public class BoardServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = resp.getWriter();
//
//        BoardDao dao = new BoardDao();
//        List<PostsDtoResponse> posts = dao.readAllPosts();
//
//        out.close();
//    }
//}
