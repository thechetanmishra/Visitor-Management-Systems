package com.example.vms.utils;
//package com.example.utils;
//
//
//import java.io.Serializable;
//import java.sql.*;
//import org.hibernate.HibernateException;
//import org.hibernate.engine.spi.SessionImplementor;
//import org.hibernate.engine.spi.SharedSessionContractImplementor;
//import org.hibernate.id.IdentifierGenerator;
//
//public class VisitorIdGenerator implements IdentifierGenerator{
//	@Override
//	public Serializable generate(SharedSessionContractImplementor session, Object object)
//            throws HibernateException {
//
//        String prefix = "VISITOR-";
//        Connection connection = session.connection();
//
//        try {
//            Statement statement=connection.createStatement();
//
//            ResultSet rs=statement.executeQuery("select count(id) as Id from vms.VENDER_DETAILS");
//
//            if(rs.next())
//            {
//                int id=rs.getInt(1)+101;
//                String generatedId = prefix + new Integer(id).toString();
//                System.out.println("Generated Id: " + generatedId);
//                return generatedId;
//            }
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }
//
////	@Override
////	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
////		// TODO Auto-generated method stub
////		return null;
////	}
//
//}
