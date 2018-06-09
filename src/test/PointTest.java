package test;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;

import main.Point;

public class PointTest {
	
	@Test
	public void shouldChangePointStatusToFalseifActiveNeighborlessThan2() {
		Point point = new Point(1,1,true);
		point.setActiveNeighbor(1);
		point.nextStatus();
		assertThat(point.getStatus(), Is.is(false));
	}
	@Test
	public void shouldkeepPointStatusAstrueifActiveNeighborequals2AndOriginalStatusIstrue() {
		Point point = new Point(1,1,true);
		point.setActiveNeighbor(2);
		point.nextStatus();
		assertThat(point.getStatus(), Is.is(true));
		
	}
	@Test
	public void shouldkeepPointStatusAsFalseifActiveNeighborequals2AndOriginalStatusIsfalse() {
		Point point = new Point(1,1,false);
		point.setActiveNeighbor(2);
		point.nextStatus();
		assertThat(point.getStatus(), Is.is(false));
		
	}
	@Test
	public void shouldChangePointStatusToTrueifActiveNeighborequals3() {
		Point point = new Point(1,1,false);
		point.setActiveNeighbor(3);
		point.nextStatus();
		assertThat(point.getStatus(), Is.is(true));
	}
	@Test
	public void shouldChangePointStatusToFalseifActiveNeighborMoreThan3() {
		Point point = new Point(1,1,true);
		point.setActiveNeighbor(4);
		point.nextStatus();
		assertThat(point.getStatus(), Is.is(false));
	}
	

	
}
