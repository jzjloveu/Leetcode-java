/*
Dungeon Game

The demons had captured the princess (P) and imprisoned her in the bottom-right 
corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. 
Our valiant knight (K) was initially positioned in the top-left room and must fight 
his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any 
point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) 
upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that 
increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only 
rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to 
rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at 
least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
______________________
|      |      |      |
| -2(K)|  -3  |   3  |
|      |      |      |
----------------------
|      |      |      |
|  -5  |  -10 |   1  |
|      |      |      |
----------------------
|      |      |      |
|  10  |  30  | -5(P)|
|      |      |      |
----------------------

Notes:

The knight's health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and 
the bottom-right room where the princess is imprisoned.
*/

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length, cols = dungeon[0].length;
        // initial
        int[][] dp = new int[rows][cols]; 
        dp[rows-1][cols-1] = Math.max(1-dungeon[rows-1][cols-1],1);
        for(int i=rows-2;i>=0;i--) { dp[i][cols-1]=Math.max(dp[i+1][cols-1]-dungeon[i][cols-1],1);}
        for(int i=cols-2;i>=0;i--) { dp[rows-1][i]=Math.max(dp[rows-1][i+1]-dungeon[rows-1][i],1);}
        // dp process
        for(int i=rows-2;i>=0;i--)
             for(int j=cols-2;j>=0;j--)
                dp[i][j]=Math.max(Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j],1);
        return dp[0][0];
    }
    
    public static void main(String args[]){
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println((new DungeonGame()).calculateMinimumHP(dungeon));
    }
}

/*
Using DP. This problem is similar as 'Minimum Path Sum', but this one is bottom-up DP.
Formula: dp[i][j] = max(min(dp[i][j+1], dp[i+1][j])-dungeon[i][j], 0)
*/