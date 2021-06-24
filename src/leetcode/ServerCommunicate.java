package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-servers-that-communicate/
public class ServerCommunicate {
    public int countServers(int[][] grid) {
        int[] compId = new int[grid.length * grid[0].length];
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        Map<Integer, Integer> connServerCount = new HashMap<>();

        // update componentId
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                compId[i*grid[i].length + j] = i*grid[i].length+j; // 1,2    1*4+2
            }
        }

        for (int row=0; row<grid.length; row++) {
            for (int col = 0; col<grid[row].length; col++) {
                int temp = row*grid[row].length + col;
                int missingCount = 0;
                if (grid[row][col] == 1) {
                    if (rowMap.containsKey(row)) {
                        compId[temp] = rowMap.get(row);
                        missingCount = connServerCount.getOrDefault(col, 0) > 1 ? 0 : 1;
                    } else if (colMap.containsKey(col)) {
                        compId[temp] = colMap.get(col);
                    }

                    rowMap.put(row, compId[temp]);
                    colMap.put(col, compId[temp]);

                    connServerCount.put(compId[temp], connServerCount.getOrDefault(compId[temp], 0) + 1 + missingCount);
                }
            }
        }

        int totalConnServer = 0;
        // traverse map
        for (Integer value : connServerCount.values()) {
            if (value > 1) {
                totalConnServer += value;
            }
        }

        return totalConnServer;
    }

    public int countServers1(int[][] grid) {
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];

        // fill row and col count of the server
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    ++rowCount[row];
                    ++colCount[col];
                }
            }
        }

        // decide which elements to include for each element
        int server = 0;
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col < grid[row].length; col++) {
                if (grid[row][col] == 1 && (rowCount[row] >1 || colCount[col] > 1)) {
                    ++server;
                }
            }
        }

        return server;
    }

    public static void main(String[] args) {
        ServerCommunicate serverCommunicate = new ServerCommunicate();
        System.out.println(serverCommunicate.countServers(new int[][] {{0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0}, {0,0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0,1}, {0,0,1,0,1,0,0,0,0}})); //6
    }
}
