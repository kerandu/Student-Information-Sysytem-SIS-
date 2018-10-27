package student.information.system;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
public class StudentDao {
	public static Connection getCon(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_information_system","root","");
		}catch(ClassNotFoundException | SQLException e){System.out.println(e);}
			
	return con;
}
				
		public static int save(Student s){
				int status=0;
				try {
					Connection con = getCon();
                    PreparedStatement ps=con.prepareStatement("insert into student(regno, name, gender, department, courseid, program, year) values(?,?,?,?,?,?,?)");
                    ps.setString(1, s.getRegno());
                    ps.setString(2,s.getName());
                    ps.setString(3,s.getGender());
                    ps.setString(4,s.getDepartment());
                    ps.setString(5,s.getCourseid());
                    ps.setString(6,s.getProgram());
                    ps.setInt(7,s.getYear());
                    status=ps.executeUpdate();
                    con.close(); 
   		}catch(Exception e){System.out.println(e);}
		return status;
}
		
		public static int saveMarks(Student s){
			int status=0;
			try {
				Connection con = getCon();
                PreparedStatement ps=con.prepareStatement("insert into exam(regno, name, courseid, unit1, unit2, unit3,"
                		+ "unit4, unit5, unit6, unit7, total, average, grade) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, s.getRegno());
                ps.setString(2,s.getName());
                ps.setString(3,s.getCourseid());
                ps.setInt(4,s.getUnit1());
                ps.setInt(5,s.getUnit2());
                ps.setInt(6,s.getUnit3());
                ps.setInt(7,s.getUnit4());
                ps.setInt(8,s.getUnit5());
                ps.setInt(9,s.getUnit6());
                ps.setInt(10,s.getUnit7());
                ps.setInt(11,s.getTotal());
                ps.setFloat(12,s.getAverage());
                ps.setString(13,s.getGrade());
                status=ps.executeUpdate();
                con.close(); 
		}catch(Exception e){System.out.println(e);}
	return status;
}
	
		public static int updateMarks(Student s){
			int status=0;
			try {
				Connection con = getCon();
                PreparedStatement ps=con.prepareStatement("update exam set name=?, courseid=?, unit1=?, unit2=?, unit3=?,"
                		+ "unit4=?, unit5=?, unit6=?, unit7=?, total=?, average=?, grade=? where regno=?");
                ps.setString(1, s.getRegno());
                ps.setString(2,s.getName());
                ps.setString(3,s.getCourseid());
                ps.setInt(4,s.getUnit1());
                ps.setInt(5,s.getUnit2());
                ps.setInt(6,s.getUnit3());
                ps.setInt(7,s.getUnit4());
                ps.setInt(8,s.getUnit5());
                ps.setInt(9,s.getUnit6());
                ps.setInt(10,s.getUnit7());
                ps.setInt(11,s.getTotal());
                ps.setFloat(12,s.getAverage());
                ps.setString(13,s.getGrade());
                status=ps.executeUpdate();
                con.close(); 
		}catch(Exception e){System.out.println(e);}
	return status;
}
		
		public static int deleteMark(Student s){
			int status=0;
			try {
				Connection con = getCon();
                PreparedStatement ps=con.prepareStatement("delete from exam name=?, courseid=?, unit1=?, unit2=?, unit3=?,"
                		+ "unit4=?, unit5=?, unit6=?, unit7=?, total=?, average=?, grade=? where regno=?");
                ps.setString(1, s.getRegno());
                ps.setString(2,s.getName());
                ps.setString(3,s.getCourseid());
                ps.setInt(4,s.getUnit1());
                ps.setInt(5,s.getUnit2());
                ps.setInt(6,s.getUnit3());
                ps.setInt(7,s.getUnit4());
                ps.setInt(8,s.getUnit5());
                ps.setInt(9,s.getUnit6());
                ps.setInt(10,s.getUnit7());
                ps.setInt(11,s.getTotal());
                ps.setFloat(12,s.getAverage());
                ps.setString(13,s.getGrade());
                status=ps.executeUpdate();
                con.close(); 
		}catch(Exception e){System.out.println(e);}
	return status;
}
	
		
	public static List<Student> view(){
		List<Student> list=new ArrayList<Student>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setRegno(rs.getString("regno"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getString("gender"));
				s.setDepartment(rs.getString("department"));
				s.setCourseid(rs.getString("courseid"));
				s.setProgram(rs.getString("program"));
				s.setYear(rs.getInt("year"));
				list.add(s);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Student> viewResult(){
		List<Student> list=new ArrayList<Student>();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from exam");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setRegno(rs.getString("regno"));
				s.setName(rs.getString("name"));
				s.setCourseid(rs.getString("courseid"));
				s.setUnit1(rs.getInt("unit1"));
				s.setUnit2(rs.getInt("unit2"));
				s.setUnit3(rs.getInt("unit3"));
				s.setUnit4(rs.getInt("unit4"));
				s.setUnit5(rs.getInt("unit5"));
				s.setUnit6(rs.getInt("unit6"));
				s.setUnit7(rs.getInt("unit7"));
				s.setTotal(rs.getInt("total"));
				s.setAverage(rs.getFloat("average"));
				s.setGrade(rs.getString("grade"));
				list.add(s);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	//does processing to add new marks entry *NEW MARK ENTRY
	public static Student getStudentByRegNo(String regno){
		Student s=new Student();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from student where regno=?");
			ps.setString(1,regno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setRegno(rs.getString("regno"));
				s.setName(rs.getString("name"));
				s.setCourseid(rs.getString("courseid"));
				s.setUnit1(rs.getInt("unit1"));
				s.setUnit2(rs.getInt("unit2"));
				s.setUnit3(rs.getInt("unit3"));
				s.setUnit4(rs.getInt("unit4"));
				s.setUnit5(rs.getInt("unit5"));
				s.setUnit6(rs.getInt("unit6"));
				s.setUnit7(rs.getInt("unit7"));
				s.setTotal(rs.getInt("total"));
				s.setAverage(rs.getFloat("average"));
				s.setGrade(rs.getString("grade"));
			}
			con.close();
		}catch(SQLException e){System.out.println(e);}
		return s;
	}
	
	public static Student getStudentByRegNoMark(String regno){
		Student s=new Student();
		try{
			Connection con=getCon();
			PreparedStatement ps=con.prepareStatement("select * from exam where regno=?");
			ps.setString(1,regno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				s.setRegno(rs.getString("regno"));
				s.setName(rs.getString("name"));
				s.setCourseid(rs.getString("courseid"));
				s.setUnit1(rs.getInt("unit1"));
				s.setUnit2(rs.getInt("unit2"));
				s.setUnit3(rs.getInt("unit3"));
				s.setUnit4(rs.getInt("unit4"));
				s.setUnit5(rs.getInt("unit5"));
				s.setUnit6(rs.getInt("unit6"));
				s.setUnit7(rs.getInt("unit7"));
				s.setTotal(rs.getInt("total"));
				s.setAverage(rs.getFloat("average"));
				s.setGrade(rs.getString("grade"));
			}
			con.close();
		}catch(SQLException e){System.out.println(e);}
		return s;
	}
}