package com.infoviaan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.infoviaan.dto.Donor;

public class AdminModel {
	public static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public Connection createConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVER_NAME);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	public int checkLogin(String u, String pwd) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from admin where username = ? and password =?");
			ps.setString(1, u);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				i = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public int registerDonor(Donor d) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("insert into donor values(?,?,?,?,?,?)");
			ps.setString(1, d.getName());
			ps.setInt(2, d.getAge());
			ps.setString(3, d.getBloodgroup());
			ps.setBoolean(4, d.isDiseas());
			ps.setString(5, d.getGender());
			ps.setString(6, d.getMobile());

			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Donor> getAllDonors() {
		ArrayList<Donor> al = new ArrayList<>();
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from donor");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Donor dd = new Donor(rs.getString("name"), rs.getInt("age"), rs.getString("bloodgroup"),
						rs.getBoolean("disease"), rs.getString("gender"), rs.getString("mobile"));
				al.add(dd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public int deleteDonor(String mobile) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("delete from donor where mobile=?");
			ps.setString(1, mobile);
			i = ps.executeUpdate();
			System.out.println("Value from Delete Donor -- @AdminModel --> " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public Donor getDonorRecord(String mobile) {
		Donor dn = null;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement("select * from donor where mobile = ?");
			ps.setString(1, mobile);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dn = new Donor(rs.getString("name"), rs.getInt("age"), rs.getString("bloodgroup"),
						rs.getBoolean("disease"), rs.getString("gender"), rs.getString("mobile"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dn;
	}

	public int updateDonorDetails(Donor dd) {
		int i = 0;
		Connection con = null;
		try {
			con = createConnection();
			PreparedStatement ps = con.prepareStatement(
					"update donor set name=?, age = ?, bloodgroup=?, disease = ?, gender= ? where mobile = ?");
			ps.setString(1, dd.getName());
			ps.setInt(2, dd.getAge());
			ps.setString(3, dd.getBloodgroup());
			ps.setBoolean(4, dd.isDiseas());
			ps.setString(5, dd.getGender());
			ps.setString(6, dd.getMobile());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}