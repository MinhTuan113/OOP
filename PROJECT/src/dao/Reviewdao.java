package dao;
import model.Review;
import java.util.*;
import java.sql.*;

public class Reviewdao
{
    public void add(Review r)
    {
        try(Connection conn=DBconnection.getConnection())
        {
            String sql="INSERT INTO review(userId,shopId,rating,comment) VALUES(?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,r.getUserId());
            ps.setInt(2,r.getShopId());
            ps.setInt(3,r.getRating());
            ps.setString(4,r.getComment());
            ps.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public List<Review> getAll(int shopId)
    {
        List<Review> list=new ArrayList<>();
        try(Connection conn=DBconnection.getConnection())
        {
            String sql="SELECT * FROM review WHERE shopId=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,shopId);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Review r=new Review();
                r.setId(rs.getInt("id"));
                r.setUserId(rs.getInt("userId"));
                r.setShopId(rs.getInt("shopId"));
                r.setRating(rs.getInt("rating"));
                r.setComment(rs.getString("comment"));
                list.add(r);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }
    public void upadte(Review r)
    {
        try(Connection conn=DBconnection.getConnection())
        {
            String sql="UPDATE review SET rating=?, comment=? WHERE id=? AND userId=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, r.getRating());
            ps.setString(2, r.getComment());
            ps.setInt(3, r.getId());
            ps.setInt(4, r.getUserId());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void delete(int id, int userId)
    {
        try (Connection conn = DBconnection.getConnection())
        {
            String sql = "DELETE FROM review WHERE id=? AND user_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, userId);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
