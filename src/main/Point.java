package main;

public class Point {
	private int i;
	private int j;
	private boolean status;
	private int activeNeighbor;
	
	public Point(int i, int j, boolean status) {
		super();
		this.i = i;
		this.j = j;
		this.status = status;
		this.activeNeighbor = 0;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getActiveNeighbor() {
		return activeNeighbor;
	}
	public void setActiveNeighbor(int activeN) {
		this.activeNeighbor = activeN;
	}
	public void nextStatus() {
		
		if(activeNeighbor < 2 || activeNeighbor > 3) {
			status = false;
		}
		else if(activeNeighbor == 3) {
			status = true ;
		}
		
		
		
	}
	
	

}
