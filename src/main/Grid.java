package main;

public class Grid {
	private  int n;
	private int m;
	private boolean[][] life;
	private Point[][] points;
	
	public Grid(int n, int m, boolean[][] life) {
		
		this.n = n;
		this.m = m;
		this.life = life;
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
			if(life[i-1][j-1] == true) count++;
		}
		if(i-1 >= 0){
			if(life[i-1][j] == true) count++;
		}
		if(i-1 >= 0 && j+1 < m){
			if(life[i-1][j+1] == true) count++;	
		}
		
		//中
		if(j-1 >= 0){
			if(life[i][j-1] == true) count++;	
		}
		if(j+1 < m){
			if(life[i][j+1] == true) count++;	
		}
		
		//下
		if(i+1 < n && j-1 >= 0){
			if(life[i+1][j-1] == true) count++;	
		}
		if(i+1 < n ){
			if(life[i+1][j] == true) count++;	
		}
		if(i+1 < n && j+1 < m){
			if(life[i+1][j+1] == true) count++;	
		}
		return count;
		
	}
	
	public void changeAllNextStatus(){
		for (int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				points[i][j].setActiveNeighbor(getActiveCount(points[i][j]));
				points[i][j].nextStatus();
				
			}
		}
		for (int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				life[i][j] = points[i][j].getStatus();
			}
		}
		
	}
	
	public void printNewStatus(){
		int count = 0;
		while(count++ < 10){
			System.out.println("true 代表存活，false 代表死亡");
			changeAllNextStatus();
			for(int i = 0;i < n;i++){
				for(int j = 0;j < m;j++){
					System.out.print(life[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
		
	

	

}
