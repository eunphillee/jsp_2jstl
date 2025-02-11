package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.FanItemVO;
import vo.Product;

public class FanItemDao {
	private static FanItemDao dao = new FanItemDao();
	private FanItemDao() { }
	public static FanItemDao getInstance() {
		return dao;
	}
	
	 // db 연결 정보를 상수로 정의합니다.
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    // db 연결 객체 만드는 메소드 dao 에서만 사용할 수 있도록 정의
    private Connection getConnection() throws SQLException{
    	try {
			Class.forName(DRIVER);  //jsp 사용하는 웹프로젝트에서는 생략 못합니다.
		} catch (ClassNotFoundException e) {
			System.out.println("예외 : " + e.getMessage());
		}
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    // 1개 행 조회 : List 사용 안합니다.
    public FanItemVO selectByPk(int seq) {
    	FanItemVO vo = null;
    	String sql ="SELECT * FROM tbl_fanitem WHERE seq = ?";
    	try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);
            ){
                pstmt.setInt(1, seq);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    vo = new FanItemVO(rs.getInt(1),  
                                          rs.getString(2),   
                                          rs.getInt(3),  
                                          rs.getInt(4),
                                          rs.getInt(5),
                                          rs.getString(6));    
                }
            }catch (SQLException e) {
                System.out.println("예외 : " + e.getMessage());
            }
    	return vo;
    }
    
    
    
    // 여러개 행 조회 : List 사용 합니다.
    public List<FanItemVO> selectAllItems(){
    	List<FanItemVO>  list = null;
    	String sql = "SELECT * FROM tbl_fanitem ORDER BY seq";
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
            list = new ArrayList<>();
     
            ResultSet rs = pstmt.executeQuery();
            FanItemVO vo = null;
            while (rs.next()) {
                vo = new FanItemVO(rs.getInt(1),  
                                      rs.getString(2),   
                                      rs.getInt(3),  
                                      rs.getInt(4),
                                      rs.getInt(5),
                                      rs.getString(6));    
                list.add(vo);
            }
        }catch (SQLException e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return list;
    }
    
    
}