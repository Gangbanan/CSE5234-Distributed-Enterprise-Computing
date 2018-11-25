package edu.osu.cse5234.batch;

import java.awt.RenderingHints.Key;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InventoryUpdater {
	public static void main(String[] args) {

		System.out.println("Starting Inventory Update ...");
		try {
			Connection conn = createConnection();
			Collection<Integer> newOrderIds = getNewOrders(conn);
			Map<Integer, Integer> orderedItems = getOrderedLineItems(newOrderIds, conn);
			udpateInventory(orderedItems, conn);
			udpateOrderStatus(newOrderIds, conn);
			conn.close();
			System.out.println("Successful Update!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection createConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:/Users/xuxin/Develop/distrComp/cse5234/h2db/MyCapDB", "sa", "");
		return conn;
	}

	private static Collection<Integer> getNewOrders(Connection conn) throws SQLException {
		Collection<Integer> orderIds = new ArrayList<Integer>();
		ResultSet rset = conn.createStatement().executeQuery(
                     "select ID from CUSTOMER_ORDER where STATUS = 'New'");
		while (rset.next()) {
			orderIds.add(new Integer(rset.getInt("ID")));
		}
		return orderIds;
	}

	private static Map<Integer, Integer> getOrderedLineItems(Collection<Integer> newOrderIds,
                Connection conn)  throws SQLException {
		// TODO Auto-generated method stub
		// This method returns a map of two integers. The first Integer is item ID, and 
                 // the second is cumulative requested quantity across all new orders
		Map<Integer, Integer> orderedItems = new HashMap<Integer, Integer>();
		for (Integer orderId : newOrderIds) {
			ResultSet rset = conn.createStatement().executeQuery(
					"SELECT * FROM CUSTOMER_ORDER_LINE_ITEM WHERE CUSTOMER_ORDER_ID_FK = " + Integer.toString(orderId));
			while (rset.next()) {
				Integer itemId = rset.getInt("ITEM_NUMBER");
				Integer quantity = rset.getInt("QUANTITY");
				if (!orderedItems.containsKey(itemId)) {
					orderedItems.put(itemId, quantity);
				} else {
					orderedItems.put(itemId, orderedItems.get(itemId) + quantity);
				}
			}
		}
		return orderedItems;
	}

	private static void udpateInventory(Map<Integer, Integer> orderedItems, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		try {
			for (Integer itemId : orderedItems.keySet()) {
				Integer quantity = orderedItems.get(itemId);
				// create our java preparedstatement using a sql update query
				PreparedStatement ps = conn.prepareStatement(
						"UPDATE ITEM SET AVAILABLE_QUANTITY = AVAILABLE_QUANTITY - ? WHERE ID = ?");
				
				// set the preparedstatement parameters
				ps.setInt(1, quantity);
				ps.setInt(2, itemId);
				
				// call executeUpdate to execute our sql update statement
				ps.executeUpdate();
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void udpateOrderStatus(Collection<Integer> newOrderIds, 
                Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		try {
			for (Integer orderId : newOrderIds) {
				// create our java preparedstatement using a sql update query
				PreparedStatement ps = conn.prepareStatement(
						"UPDATE CUSTOMER_ORDER SET STATUS = 'Processed' WHERE ID = ?");
				
				// set the preparedstatement parameters
				ps.setInt(1, orderId);
				
				// call executeUpdate to execute our sql update statement
				ps.executeUpdate();
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
