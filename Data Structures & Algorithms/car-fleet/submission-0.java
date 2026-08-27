
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Pair each car's position with its time to reach target
        double[][] cars = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // position
            cars[i][1] = (double)(target - position[i]) / speed[i]; // time
        }
        
        // Sort cars by starting position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double maxTime = 0.0;
        
        // Traverse from closest to farthest
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (time > maxTime) {
                fleets++;        // new fleet formed
                maxTime = time;  // update max time
            }
            // else: merges into fleet ahead
        }
        
        return fleets;
    }
}
