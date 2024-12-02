package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//공통코드 작성해보기
//반복되는 코드 줄이기
//메소드는 슬림하게 하나의 책임만 진다 - 재사용성이 좋다.
//Db서버는 하나이고 여러 개발자들이 바라본다.
//하나의 객체를 가지고 공유(싱글톤 패턴-Spring지원)
//클래스 선언에 static을 붙임-얕복=원본 하나
//
public class DBconnectionMgr {
    static DBconnectionMgr dbmgr = null;
    //서버(정보제공측)-클라이언트(제공된 정보를 활용) - 2-tier
    //서버-미들웨어서버-클라이언트 - 3-tier =< multi tier
    //java.sql.* or javax.sql.*참조함
    //모두 인터페이스이다.(Connection,PreparedStatement,ResultSet)-결정불가
    //왜? - 디바이스마다 다르게 동작해야함.-구현체클래스가 구현함.
    //아래 인터페이스는 모두 메소드로 객체를 생성함.
    Connection con;
    PreparedStatement pstmt;//동적쿼리
    ResultSet rs;//커서조작하는 api제공
    public final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
    public final static String _URL = "jdbc:oracle:thin:@localhost:1521:orcl11";
    public final static String _USER = "scott";
    public final static String _PW = "tiger";
    public DBconnectionMgr() {}
    //메소드를 활용하여 객체를 생성하기-세련된코드-싱글톤패턴
    //선택(조건문-if)적 객체 생성
    public static DBconnectionMgr getInstance() {
        if(dbmgr == null) {//if문 조건절에서 null을 체크
            dbmgr = new DBconnectionMgr();
        }
        return dbmgr;
    }

    public Connection getConnection() {
        try {
            Class.forName(_DRIVER);
            con = DriverManager.getConnection(_URL, _USER, _PW);
        } catch (Exception e) {

        }
        return con;
    }
    //insert,update,delete -> connection, preparedStatement
    //select -> connection, preparedStatement, resultSet
    public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if(rs != null){rs.close();}
            if(pstmt != null){pstmt.close();}
            if(con != null){con.close();}
        }catch (Exception e) {
        }
    }
    public void freeConnection(Connection con, PreparedStatement pstmt) {
        try {
            if(pstmt != null){pstmt.close();}
            if(con != null){con.close();}
        }catch (Exception e) {
        }
    }
}

