package Player;
import java.util.*;
import java.io.*;
import java.lang.*;
public class player implements Serializable {
	
	private String username;
	
	private static int id = 0;
	
	private int PLAYERID;
 	
	private boolean tobeSaved = false;
	
	public int highScore=0;
	
	public String getUserName()
	{
		return this.username;
	}
	
	public void setUserName(String str)
	{
		this.username = str;
	}
	
	public int getID()
	{
		return this.PLAYERID;
	}
	
	public boolean getTobeSaved()
	{
		return this.tobeSaved;
		
	}
	
	private boolean setTobeSaved()
	{
		return this.tobeSaved = false;
	}

	public player()
	{
		this.PLAYERID = id+1;
		this.id++;
	}
}
