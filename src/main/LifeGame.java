package main;

public class LifeGame {
	private int n;
	private int m; 
	public void initialize(){
		boolean life[][] = new boolean[n][m];
		for(int i = 0 ;i < n;i++){
			for(int j = 0;j < m;j++){
				if(Math.random() > 0.5){
					life[i][j] = true;
				}
				else {
					life[i][j] = false;
				}
			}
		}
		System.out.println("³õÊ¼»¯×´Ì¬£º");
		for(int i = 0;i < n;i++){
			for(int j = 0;j < m;j++){
				System.out.print(life[i][j]+" ");
			}
			System.out.println();
		}
		Grid lifeGame = new Grid(n, m, life);
		lifeGame.printNewStatus();
	}
	public void play(int n, int m) {
		this.n = n;
		this.m = m;
		initialize();
		
	}
	public static void main(String[] args) {
		
		LifeGame lifeGame = new LifeGame();
		lifeGame.play(1,1);

	}

}
