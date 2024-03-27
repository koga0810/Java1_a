package model;

import java.sql.Timestamp;

public class EquipmentBeans {
    private long id;
    private String itemName;
    private int quantity;
    private String location;
    private String updaterId;
    private Timestamp lastUpdated;
	
    
    
    public long getId() {
		return id;
	}
    
	public void setId(long id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getUpdaterId() {
		return updaterId;
	}
	
	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}
	
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}

    
