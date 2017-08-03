package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    
    //DBに新規登録
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    
    //DBから検索
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            //何もない場合は全件表示
            String sql = "SELECT * FROM user_t";
            
            //分岐判断用変数
            boolean flag = false;
            boolean flagName = false;
            boolean flagBirth = false;
            boolean flagType = false;
            
            //検索条件がある場合のsql文の分岐
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag = true;
                flagName = true;
            }
            if (ud.getBirthday()!=null) {
                if(!flag){
                    sql += " WHERE birthday like ?";
                    flag = true;
                }else{
                    sql += " AND birthday like ?";
                }
                flagBirth = true;
            }
            if (ud.getType()!=0) {
                if(!flag){
                    sql += " WHERE type like ?";
                }else{
                    sql += " AND type like ?";
                }
                flagType = true;
            }
            
            st = con.prepareStatement(sql);
            
            //検索条件がある場合の?の値セットの分岐
            if(flagName){
                st.setString(1, "%"+ud.getName()+"%");
                
                if(flagBirth){
                    st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                        
                    if(flagType){
                        st.setInt(3, ud.getType());
                    }
                }else{
                    if(flagType){
                        st.setInt(2, ud.getType());
                    }
                }
            }else{
                if(flagBirth){
                    st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");

                    if(flagType){
                        st.setInt(2, ud.getType());
                    }
                }else{
                    if(flagType){
                        st.setInt(1, ud.getType());
                    }
                }
            }
            
            ResultSet rs = st.executeQuery();
            
            //返却用arraylistを作成
            ArrayList<UserDataDTO> UDL = new ArrayList<UserDataDTO>();
            
            while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                UDL.add(resultUd);
            }
            System.out.println("search completed");
            return UDL;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    /*
        データの更新処理を行う
    */
        public void update(UserDataDTO ud) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;
            try{
                con = DBManager.getConnection();
                
                String sql = "UPDATE user_t SET name = ?, birthday = ?, tell = ?, type = ?, comment = ?, newDate = ? WHERE userID = ?";
                st = con.prepareStatement(sql);
                st.setString(1, ud.getName());
                st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));   //sql用に変換
                st.setString(3, ud.getTell());
                st.setInt(4, ud.getType());
                st.setString(5, ud.getComment());
                st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                st.setInt(7, ud.getUserID());
                st.executeUpdate();
                System.out.println("update completed");
            }
            catch(SQLException e){
                System.out.print(e.getMessage());
                throw new SQLException(e);
            }
            finally{
                if(con != null){
                    con.close();
                }
            }
        }
    
    /*
        データの削除処理を行う
    */
        public void delete(UserDataDTO ud) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;
            try{
                con = DBManager.getConnection();
                
                String sql = "DELETE FROM user_t WHERE userID = ?";
                
                st = con.prepareStatement(sql);
                st.setInt(1, ud.getUserID());
                st.executeUpdate();
                System.out.println("delete completed");
            }
            catch(SQLException e){
                System.out.print(e.getMessage());
                throw new SQLException(e);
            }
            finally{
                if(con != null){
                    con.close();
                }
            }
        }
}
