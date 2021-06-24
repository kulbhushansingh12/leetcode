package leetcode;

import java.util.List;

//https://leetcode.com/problems/keys-and-rooms/
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 0)
            return true;
        boolean[] isVisited = new boolean[rooms.size()];
        isVisited[0] = true;
        visitAllNeighbours(rooms, isVisited, 0);
        for (boolean visited : isVisited) {
            if (!visited)
                return false;
        }
        return true;
    }

    private void visitAllNeighbours(List<List<Integer>> neighbours, boolean[] isVisited, int roomNumber) {
        List<Integer> neighbour = neighbours.get(roomNumber);
        for (Integer room : neighbour) {
            if (!isVisited[room]) {
                isVisited[room] = true;
                visitAllNeighbours(neighbours, isVisited, room);
            }
        }
    }

    public static void main(String[] args) {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
        System.out.println(keysAndRooms.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(keysAndRooms.canVisitAllRooms(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0))));
    }
}
