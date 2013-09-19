package com.alasershark.dragon;

import java.util.ArrayList;
import java.util.Collections;

/**
 * I'M ON A PLANE
 */
public class Plane {

    ArrayList<Coordinate> coords = new ArrayList<>();
    ArrayList<Coordinate> coordsWithDupes = new ArrayList<>();
    Coordinate last;
    Coordinate center = new Coordinate(0,0);
    long top = 0;
    long bot = 0;
    long left = 0;
    long right = 0;

    public Plane(Coordinate c){
        last = c;
        coords.add(c);
        coordsWithDupes.add(c);
    }

    public void add(Coordinate c) throws Exception{
        if(!coords.contains(c)) coords.add(c);
        coordsWithDupes.add(c);
        c = coords.get(coords.indexOf(c));
        if(last.x + 1 == c.x && last.y == c.y){
            c.left = true;
            last.right = true;
        }else if(last.x - 1 == c.x && last.y == c.y){
            c.right = true;
            last.left = true;
        }else if(last.y + 1 == c.y && last.x == c.x){
            c.down = true;
            last.up = true;
        }else if(last.y - 1 == c.y && last.x == c.x){
            c.up = true;
            last.down = true;
        }else{
            throw new Exception("Invalid point. " + c.x + " " + c.y);
        }
        if(c.y > top){
            top = c.y;
        }else if(c.y < bot){
            bot = c.y;
        }
        if(c.x < left){
            left = c.x;
        }else if(c.x > right){
            right = c.x;
        }
        last = c;
    }

    public ArrayList<Coordinate> getReverse(){
        ArrayList<Coordinate> reversed = (ArrayList<Coordinate>) coordsWithDupes.clone();
        Collections.reverse(reversed);
        return reversed;
    }

    public void center(Coordinate c){
        center = c;
    }

    public Coordinate center(){
        return center;
    }

    public void draw() {
        for(long i = top + 1; i >= bot; i--){
            String line1 = "";
            String line2 = "";
            String line3 = "";
            for(long ii = left; ii <= right; ii++){
                //System.out.println("checking");
                //System.out.println(ii);
                //System.out.println(i);
                boolean charadded = false;
                if(coords.contains(new Coordinate(ii, i))){
                    //System.out.println("contains");
                    Coordinate c = coords.get(coords.indexOf(new Coordinate(ii, i)));
                    if(c.left && c.right) line2 += "- -";
                    else if(c.left) line2 += "-  ";
                    else if(c.right) line2 += "  -";
                    else line2 += "   ";
                    if(c.up) line1 += " | ";
                    else line1 += "   ";
                    if(c.down) line3 += " | ";
                    else line3 += "   ";
                    charadded = true;
                }
                if(!charadded){
                    line1 += "   ";
                    line2 += "   ";
                    line3 += "   ";
                }
            }
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);
        }
    }
}
