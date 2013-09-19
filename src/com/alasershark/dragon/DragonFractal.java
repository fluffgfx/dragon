package com.alasershark.dragon;

/**
 * Fractals are cool.
 */
public class DragonFractal {

    public static void main(String[] args){
        Plane p = new Plane(new Coordinate(0, 0));
        // Truck t = new Truck();
        // Boat b = new Boat();
        try{
            p.add(new Coordinate(1, 0));
            p.center(new Coordinate(1, 0));
            for(int i = 0; i < 11; i++){
                Coordinate last = null;
                for(Coordinate c:p.getReverse()){
                    if(!(c.equals(p.center()))){
                        Coordinate r = c.rotate(p.center);
                        p.add(r);
                        last = r;
                    }
                }
                p.center(last);
                //System.out.println("Iteration " + i + " completed.");

            }
        }catch(Exception e){
            System.out.println("Error adding a point: " + e.toString());
            for(Coordinate c:p.getReverse()){
                System.out.println(c.x + " " + c.y + " - Up: " + c.up + " Down: " + c.down + " Left: " + c.left + " Right: " + c.right);
            }
            e.printStackTrace();
            return;
        }finally{
            p.draw();
            System.out.println("Done!");
        }
    }

}
