package com.company;
import java.sql.*;
/*
jdbc connectivity
1.import the package->java.sql.*
2.load and register the driver-->com.mysql.jdbc.Driver
3.Create Connection-->Connection
4.create a statement-->Statement
5.execute the query
6.process the Query
7.close the connection
*/

public class Connect{
    Statement st;
    Connection conn;

    Connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");//register the jdbc connector
        String url = "jdbc:mysql://localhost:3307/agriculture?useTimezone=true&serverTimezone=UTC";
        String username = "root";
        String password = "";
        String query = "select * from lands";
        conn = DriverManager.getConnection(url, username, password);
        st = conn.createStatement();
    }
}
/*
 int flag=0;
 ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            if(rs.getString=="Akash")
                flag=1;
        }
        if(flag==1){
            int k=st.executeUpdate("Delete from myTable where name='Akash'");
            if(k>0)
                System.out.println("Deleted");
        }else if(flag==0){
            boolean b=st.execute("insert into myTable values('Akash')");
            if(b==false)
                System.out.println("Inserted");
        }
        PreparedStatement st=conn.prepareStatement("insert into myTable values(?)");
        st.setString("Bhanu");
        st.setString("Trishala");
        st.setString("Anshu");
        st.executeUpdate();

        CallableStatement st=conn.prepareCall("{call myTable.add(?)}");
        st.setString("Bhanu");
        st.setString("Monu");
        st.executeUpdate();
        st.close();
        conn.close();
        }
        public static void main(String args[])
        {
            new Connect();
        }
        }
*/