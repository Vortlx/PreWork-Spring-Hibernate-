package jdbcproj;

import java.sql.SQLException;
import java.util.List;

import jdbcproj.databaseservice.dao.DAOTeacher;
import jdbcproj.databaseservice.dao.daoteacher.DAOTeacherHibernate;

import jdbcproj.databaseservice.dao.DAOGroup;
import jdbcproj.databaseservice.dao.DAOStudent;
import jdbcproj.databaseservice.dao.daogroup.DAOGroupHibernate;
import jdbcproj.databaseservice.dao.daostudent.DAOStudentHibernate;
import jdbcproj.data.Teacher;
import jdbcproj.databaseservice.hibernateutil.HibernateUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This Class using for testing other classes.
 * 
 * @author Lebedev Alexander
 * @since 2016-09-19
 * */
public class Main{
	public static void main(String[] args){

		ApplicationContext context = new ClassPathXmlApplicationContext("spring\\Spring.cfg.xml");

	    DAOTeacher daoTeacher = (DAOTeacher)context.getBean("daoTeacherHibernate");
		DAOGroup daoGroup = (DAOGroup)context.getBean("daoGroupHibernate");
		DAOStudent daoStudent = (DAOStudent)context.getBean("daoStudentHibernate");

	    try{
	        List<Teacher> teachers = daoTeacher.getByGroup("666");

			System.out.println("Test");

	        for(Teacher teacher: teachers){
	            System.out.println(teacher.getName() + " " + teacher.getFamilyName());
	        }
	        
	    }catch(SQLException e){
	        e.printStackTrace();
	    }finally{
	    	//HibernateUtil.closeSessionFactory();
		}
	}
}