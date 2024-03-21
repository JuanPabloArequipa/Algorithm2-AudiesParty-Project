package AudiesParty;

import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphParser {
    private Graph<String> graph;
    private final BufferedReader bufferedReader;
    public GraphParser(String filePath){
        try {
            graph = new Graph<String>();
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Graph<String> createGraph(int x){
        try {
            setInfoInGraph(x);
            setHeavierGraph();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return graph;
    }

    private void setInfoInGraph(int x) throws IOException {
        String line;
        String[] items;
        StringTokenizer tokenizer;
        Edge<String> currentEdge;
        ArrayList<Edge<String>> arrayList = new ArrayList<>();
        do {
            line = bufferedReader.readLine();
            tokenizer = new StringTokenizer(line);
        } while (tokenizer.countTokens()==1);

        do {
            items = line.split(" ");
            currentEdge = new Edge<>(items[0], items[1], Integer.parseInt(items[2]));
            if (currentEdge.getWeight()>x)
                arrayList.add(currentEdge);
        } while((line = bufferedReader.readLine())!=null);
        graph.setEdges(arrayList);
        
    }

    private void setHeavierGraph(){
        GraphsHandler<String> subGraphsCounter = new GraphsHandler<String>(graph);
        ArrayList<Graph<String>> graphList = subGraphsCounter.getSubGraphs();
        Graph<String> heavierGraph = graphList.get(0);
        for (int i = 1; i < graphList.size(); i++) {
            if (heavierGraph.getWeight() < graphList.get(i).getWeight())
                heavierGraph = graphList.get(i);
        }
        graph = heavierGraph;
    }
}
