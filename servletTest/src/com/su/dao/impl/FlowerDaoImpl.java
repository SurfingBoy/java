package com.su.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;

import com.su.dao.FlowerDao;
import com.su.model.Flower;
import com.sun.crypto.provider.RSACipher;
import com.sun.media.sound.ModelAbstractChannelMixer;

import sun.net.www.content.audio.x_aiff;

public class FlowerDaoImpl implements FlowerDao{

	@Override
	public List<Flower> selAll() {
		// TODO Auto-generated method stub
		List<Flower> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
			ps= conn.prepareStatement("select * from flower");
			rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Flower(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	@Override
	public int add(Flower flower) {
		int index=0;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
			ps= conn.prepareStatement("insert into flower values(default,?,?,?)");
			ps.setObject(1, flower.getName());
			ps.setObject(2, flower.getPrice());
			ps.setObject(3, flower.getDesc());
			index=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return index;
	}


}
