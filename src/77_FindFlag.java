/**
 * You're given a maze (that is not necessarily square shaped). The maze is
 * composed of square rooms. In one of these rooms there is a flag. You have a
 * robot that you can control using the following APIs: 1. void Go() - drives
 * the robot straight. 2. void Turn(int degrees) - turns the robot x degrees to
 * the right (x has to be a multiple of 90). 3. bool IsWall() - returns true if
 * the robot is facing a wall (you can't move from one room to the other). 4.
 * bool IsFlag - returns true if the room has the flag in it. 5. void
 * PutBreadCrumb() - throws a single breadcrumb in the room. 6. bool
 * HasBreadCrumb()- returns true if the room contains a breadcrumb. Using these
 * Apis only, write a program to navigate the robot through the maze until it
 * finds the flag.
 * 
 * @author pkjoshi
 *
 */

class Robot{
	void go(){
		
	}
	void turn(int degrees){
		
	}
	
	boolean isWall(){
		return false;
	}	
	
	boolean isFlag(){
		return false;
	}
	
	void putBreadCrumb(){
		
	}
	
	boolean hasBreadCrumb(){
		return false;
	}
}

public class FindCheese {

	Robot robot;
	
	public void dfs() {
		if(robot.hasBreadCrumb()){
			return;
		}
		if(robot.isFlag()){
			return;
		}
		robot.putBreadCrumb();
		for(int i=0;i<3;++i){
			if(!robot.isWall()){
				robot.go();
				dfs();
			}
			robot.turn(90);
		}
	}
}
