package ListScreenHandler;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import UserButton.userButton;

public class listScreenHandler<M> implements Serializable{

	private int maxSlots;
	
	public ArrayList<M> savedList;
	
	public userButton BackButton;
	
	public int getMaxNoOfSlots()
	{
		return this.maxSlots;
	}
	
	public void clickSlotButton(int slot)
	{
		
	}
	
	public void showList(Object user)
	{
		
	}
	
	public void serialize() throws IOException
	{
		
	}
	
	public void deserialize() throws ClassNotFoundException,IOException
	{
		
	}
	
	public listScreenHandler()
	{
		this.savedList = new ArrayList<M>();
	}
	

}
