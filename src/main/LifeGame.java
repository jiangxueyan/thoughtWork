package main;

public class LifeGame {
	 private Grid lifeGame;
	 private int cycleTimes;
	 private int row ;
	 private int col;
	 
	 public static void main(String[] args) {
			LifeGame lifeGame = new LifeGame();
			lifeGame.initialize(3,3,10);
			lifeGame.play();
		}


	private void initialize(int n,int m,int cycleTimes){
		boolean lifeStatusGrid[][] = new boolean[n][m];
		this.cycleTimes = cycleTimes;
		this.row = n;
		this.col = m;
		initRandomLifeStatusGrid(n, m, lifeStatusGrid);
		showInitLifeStatusGrid(lifeStatusGrid);
		lifeGame = new Grid(n, m, lifeStatusGrid);
		
	}

	private void showInitLifeStatusGrid(boolean[][] lifeStatusGrid) {
		System.out.println("初始化状态：(-代表死，*代表活)");
		printResult(lifeStatusGrid);
		
	}

	private void initRandomLifeStatusGrid(int n, int m, boolean[][] lifeStatusGrid) {
		for(int i = 0 ;i < n;i++){
			for(int j = 0;j < m;j++){
				if(Math.random() > 0.5){
					lifeStatusGrid[i][j] = true;
				}
				else {
					lifeStatusGrid[i][j] = false;
				}
			}
		}
	}
	
	private void play(){
		int count = 0;
		while(++count <= cycleTimes){
			System.out.println("迭代次数: "+count);
			lifeGame.refrush();
			printResult(lifeGame.getLifeStatusGrid());
		}
	}


	private void printResult(boolean[][] lifeStatusGrid) {
		for(int i = 0;i < row;i++){
			for(int j = 0;j < col;j++){
				if(lifeStatusGrid[i][j]){
					System.out.print("* ");
				}
				else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
	
	
}
