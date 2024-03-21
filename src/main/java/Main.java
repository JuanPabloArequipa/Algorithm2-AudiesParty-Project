import AudiesParty.Graph;
import AudiesParty.GraphParser;

import static AudiesParty.AudiesParty.getGuestsGroup;
import static AudiesParty.AudiesParty.getGuestsList;

public class Main {
    public static void main(String[] args) {
        //E.g 1
        // Case 1
        executeExample("src/main/resources/example1.txt", 7, 2);

        /*********************************************************************************/

        // E.g 2
        // Case 1
        executeExample("src/main/resources/example2.txt", 10, 4);
        // Case 2
        executeExample("src/main/resources/example2.txt", 10, 3);
        // Case 3
        executeExample("src/main/resources/example2.txt", 14, 3);
        /*********************************************************************************/

        // E.g 3
        // Case 1
        executeExample("src/main/resources/example3.txt", 14, 4);
    }

    private static void executeExample(String filePath, int x, int k){
        GraphParser parser = new GraphParser(filePath);

        Graph<String> graph = parser.createGraph(x);
        System.out.println("Guests List: ");
        getGuestsList(graph);

        System.out.println("Groups: ");
        getGuestsGroup(graph, k);
    }
}
