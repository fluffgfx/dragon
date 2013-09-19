package com.alasershark.dragon;

/**
 * Created with IntelliJ IDEA.
 * User: 0605132364
 * Date: 8/22/13
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class Coordinate {

    public long x,y;
    public boolean up,down,left,right;

    public Coordinate(long x, long y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Coordinate)) return false;
        Coordinate c = (Coordinate) o;
        if(c.x == this.x && c.y == this.y) return true;
        return false;
    }

    public Coordinate rotate(Coordinate c) throws NullPointerException{
//        System.out.println("Rotating a new point.");
//        System.out.println("Coordinate: " + this.x + " " + this.y);
        Coordinate relative = new Coordinate(this.x - c.x, this.y - c.y);
        Coordinate relativeAnswer = new Coordinate(relative.y, -relative.x);
        Coordinate answer = new Coordinate(relative.y + c.x, -relative.x + c.y);
//        System.out.println("Center: " + c.x + " " + c.y);
//        System.out.println("Relative to base: " + relative.x + " " + relative.y);
//        System.out.println("Relative answer: " + relativeAnswer.x + " " + relativeAnswer.y);
//        System.out.println("Answer: " + answer.x + " " + answer.y);
        return answer;
    }

}
