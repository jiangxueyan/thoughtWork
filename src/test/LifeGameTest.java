package test;

import static org.junit.Assert.*;

import main.Grid;
import main.Point;

import org.hamcrest.core.Is;
import org.junit.Test;

public class LifeGameTest {
	
	private Grid lifeGame;



	@Test
	public void shouldReturnActiveNeighborNum3ifIsCornerPointAndhas3ActiveNeighbor(){
		
		boolean life[][] = {{false,true,false},{true,true,false}};
		lifeGame = new Grid(2, 3, life);
		Point point = new Point(0, 0, life[0][0]);
		
		int activeNeighborNum = lifeGame.getActiveCount(point);
		
		assertThat(activeNeighborNum, Is.is(3));
	}
	@Test
	public void shouldReturnActiveNeighborNum2ifIsbounderPointAndhas2ActiveNeighbo(){
		
		boolean life[][] = {{false,true,false},{true,true,false}};
		lifeGame = new Grid(2, 3, life);
		Point point = new Point(0, 1, life[0][1]);
		
		int activeNeighborNum = lifeGame.getActiveCount(point);
		
		assertThat(activeNeighborNum, Is.is(2));
	}
	@Test
	public void shouldReturnActiveNeighborNum4ifIsMiddlePointAndhas4ActiveNeighbo(){
		
		boolean life[][] = {{true,false,false},{false,false,false},{true,false,true}};
		lifeGame = new Grid(3, 3, life);
		Point point = new Point(1, 1, life[1][1]);
		
		int activeNeighborNum = lifeGame.getActiveCount(point);
		
		assertThat(activeNeighborNum, Is.is(3));
	}

	
	@Test 
	public void shouldChangeAllPointSatus(){
		boolean life[][] = {{false,true,false},{true,true,false}};
		lifeGame = new Grid(2, 3, life);
		lifeGame.refrush();
		boolean expected[][] = {{true,true,false},{true,true,false}};
		assertThat(life, Is.is(expected));
	}

}
