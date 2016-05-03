import javax.xml.bind.ValidationEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Graph {

    //private ArrayList<Vertex> Vertices = new ArrayList<Vertex>();

    private HashMap<String,Vertex> Vertices = new HashMap<String, Vertex>();

    //private ArrayList<Edge> Edges = new ArrayList<Edge>();

    private HashMap<String,Edge> Edges = new HashMap<String, Edge>();

    public void addVertex (Vertex v){
        this.Vertices.put(v.getLabel(), v);
    }

    public void removeVertex (String s){
        this.Vertices.remove(s);
    }

    public void removeVertex(Vertex v){
        if (this.Vertices.containsValue(v)){
            this.Vertices.remove(v.getLabel());
        }
    }

    public void addEdge (Edge e){
        this.Edges.put(e.getVertexOne().getLabel()+e.getVertexTwo().getLabel(),e);
    }

    public void addEdge (Vertex vertexOne, Vertex vertexTwo,int i){
        Edge e = new Edge(vertexOne, vertexTwo, i);
        this.Edges.put(e.getVertexOne().getLabel()+e.getVertexTwo().getLabel(),e);
    }

    public void addEdge (Vertex one, Vertex two){
        addEdge(one, two, 1);
    }

    public void removeEdge(Edge e){
        if (this.Edges.containsValue(e)){
            this.Edges.remove(e.getVertexOne().getLabel()+e.getVertexTwo().getLabel());
        }
    }

    public void removeEdge(Vertex one, Vertex two){
        Edge e = new Edge(one, two);
        this.removeEdge(e);
    }

    public HashMap<String,Edge> getEdges(){
        return this.Edges;
    }

    public HashMap<String,Vertex> getVertices(){
        return this.Vertices;
    }

    public boolean containsVertex (Vertex v){
        if (this.Vertices.containsValue(v)){
            return true;
        }
        return false;
    }
    public boolean containsEdge (Edge e){
        if (this.Edges.containsValue(e)){
            return true;
        }
        return false;
    }

    public  boolean containsEdge (Vertex one, Vertex two){
        Edge e = new Edge(one, two);
        return containsEdge(e);
    }

    public Set vertexKeys(){
        return Vertices.keySet();
    }

    public void quardAgainstDuplicate(){
        if ()

            throw new DuplicazxteEdgeException();
    }

    public void guardAgainstLoop(){
        if()
            throw new EdgeLoopException();
    }
}
