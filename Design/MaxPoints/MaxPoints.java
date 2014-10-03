// Max Points on a Line

// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.


// Definition for a point.
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPoints {
    public int maxPoints(Point[] points) {
        if(points.length < 3)
           return points.length;
   
        int maxcount = 0;
        for(int i=0;i<points.length;i++){
            java.util.Map<String, Integer> sl = new java.util.HashMap<String, Integer>();
            int duplicate = 1;
            for(int j=0;j<points.length;j++){
                if(points[i].x==points[j].x && points[i].y==points[j].y && i!=j)
                    duplicate++;
                
                else if(i != j){
                    if(points[i].x==points[j].x){
                        int count = sl.containsKey("v") ? sl.get("v") : 0;
			sl.put("v", count + 1);
                    }
                    else if(points[i].y==points[j].y){
                        int count = sl.containsKey("h") ? sl.get("h") : 0;
			sl.put("h", count + 1);
                    }
                    else{
                        float slope = (float)(points[i].y-points[j].y)/(points[i].x-points[j].x);
                        int count = sl.containsKey(Float.toString(slope)) ? sl.get(Float.toString(slope)) : 0;
			sl.put(Float.toString(slope), count + 1);
                    }
                } 
            }
            if(sl.size()>0){
            int maxvalue = 0;
                for(int value:sl.values())
                    maxvalue = Math.max(maxvalue,value);
                maxcount = Math.max(maxcount,maxvalue+duplicate);
            }
            else      
                maxcount = Math.max(maxcount,duplicate);
        }
        return maxcount;
    }
    public static void main(String args[]){
	Point p1 = new Point();
    	Point p2 = new Point(-1,-1);
    	Point p3 = new Point(2,2);
    	Point p4 = new Point(1,-1);
    	Point p5 = new Point(1,1);
        Point[] points0 = {p1};
    	Point[] points1 = {};
        Point[] points2 = {p1,p1};
    	Point[] points3 = {p1,p2,p3};
    	Point[] points4 = {p1,p4,p2};
    	Point[] points5 = {p1,p5,p1};
        MaxPoints sol = new MaxPoints();
        System.out.println(sol.maxPoints(points0));  // 1
	System.out.println(sol.maxPoints(points1));  // 0
	System.out.println(sol.maxPoints(points2));  // 2
        System.out.println(sol.maxPoints(points3));  // 3
	System.out.println(sol.maxPoints(points4));  // 2
  	System.out.println(sol.maxPoints(points5));  // 3
    }
}
