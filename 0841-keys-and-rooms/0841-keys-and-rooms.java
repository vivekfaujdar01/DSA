class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];

        dfs(0, rooms, visit);

        for(boolean room : visit){
            if(!room){
                return false;
            }
        }

        return true;
    }

    public void dfs(int room, List<List<Integer>> rooms, boolean[] visit){
        visit[room] = true;

        for(int nei : rooms.get(room)){
            if(!visit[nei]){
                dfs(nei, rooms, visit);
            }
        }
    }
}