package main;

public class Grid {
	private  int n;
	private int m;
	private boolean[][] lifeStatusGrid;
	private Point[][] points;
	
	public Grid(int n, int m, boolean[][] life) {
		
		this.n = n;
		this.m = m;
		this.lifeStatusGrid = life;
		points = new Point[n][m];
		for(int i = 0;i < n;i++){
			for(int j =0 ;j < m;j++){
				Point point = new Point(i, j, life[i][j]);
				points[i][j] = point;
			}
		}
	}
	
	public int getActiveCount(Point point){
		int count = 0;
		int i = point.getI();
		int j = point.getJ();
		//遍历8个邻居节点，统计存活个数
		//上
		if(i-1 >= 0 && j-1 >=0 ){
			if(lifeStatusGrid[i-1][j-1] == true) count++;
		}
		if(i-1 >= 0){
			if(lifeStatusGrid[i-1][j] == true) count++;
		}
		if(i-1 >= 0 && j+1 < m){
			if(lifeStatusGrid[i-1][j+1] == true) count++;	
		}
		
		//中
		if(j-1 >= 0){
			if(lifeStatusGrid[i][j-1] == true) count++;	
		}
		if(j+1 < m){
			if(lifeStatusGrid[i][j+1] == true) count++;	
		}
		
		//下
		if(i+1 < n && j-1 >= 0){
			if(lifeStatusGrid[i+1][j-1] == true) count++;	
		}
		if(i+1 < n ){
			if(lifeStatusGrid[i+1][j] == true) count++;	
		}
		if(i+1 < n && j+1 < m){
			if(lifeStatusGrid[i+1][j+1] == true) count++;	
		}
		return count;
		
	}
	
	public void refrush(){
		for (int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				points[i][j].setActiveNeighbor(getActiveCount(points[i][j]));
				points[i][j].nextStatus();
				
			}
		}
		copyPointNewStatusIntoLifeStatusGrid();
	}
	
	private void copyPointNewStatusIntoLifeStatusGrid() {
		for (int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				lifeStatusGrid[i][j] = points[i][j].getStatus();
			}
		}
	}

	public boolean[][] getLifeStatusGrid() {
		return lifeStatusGrid;
	}
}
