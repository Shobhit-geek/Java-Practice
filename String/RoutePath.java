package String;

// Question 2 -> Given a route containing 4 directions (E, W, N, S),
// find the shortest path to reach the destination.
// Example Input: "WNEESENNN"

// Theory:
// The problem can be solved by calculating the displacement in each direction.
// Directions are mapped to changes in coordinates:
// - N (North) -> y + 1
// - S (South) -> y - 1
// - E (East) -> x + 1
// - W (West) -> x - 1
// The shortest path is the straight-line distance from the initial point (0, 0)
// to the final point (x, y), which can be calculated using the distance formula:
// Distance = sqrt((x - 0)^2 + (y - 0)^2)

public class RoutePath {
    public static void RoutePathh(String s) {
        int x = 0; // x-coordinate
        int y = 0; // y-coordinate

        // Loop through the string to calculate the final coordinates
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'N':
                    y += 1; // Move north
                    break;
                case 'S':
                    y -= 1; // Move south
                    break;
                case 'E':
                    x += 1; // Move east
                    break;
                case 'W':
                    x -= 1; // Move west
                    break;
                default:
                    break; // Ignore invalid characters
            }
        }

        // Calculate the shortest path using the distance formula
        double shortestPath = Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0));
        System.out.println("The shortest path is: " + shortestPath);
    }

    public static void main(String[] args) {
        // Example input
        String inputString = "WNEESENNN";
        RoutePathh(inputString);
    }
}
