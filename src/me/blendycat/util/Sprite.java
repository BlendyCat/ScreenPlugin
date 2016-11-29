package me.blendycat.util;

import org.bukkit.Location;

public class Sprite {
	private Location location;
	private float vx;
	private float vy;
	
	public Sprite(Location location){
		this.location = location;
	}
	
	public void update(long timePassed){
		location = location.add(vx*timePassed,vy*timePassed,0);
	}
	
	public void setX(double x){
		location.setX(x);
	}
	
	public void setY(double y){
		location.setY(y);
	}
	
	public void setVX(float vx){
		this.vx = vx;
	}
	
	public void setVY(float vy){
		this.vy = vy;
	}
	
	public double getX(){
		return location.getBlockX();
	} 
	
	public double getY(){
		return location.getBlockY();
	}
	
	public Location getLocation(){
		return location;
	}
	
	public float getVX(){
		return vx;
	}
	
	public float getVY(){
		return vy;
	}
	
	public Location getBlockLocation(){
		Location loc = new Location(
				location.getWorld(),
				location.getBlockX(),
				location.getBlockY(),
				location.getBlockZ());
		return loc;
	}
	
}
