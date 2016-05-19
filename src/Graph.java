import java.util.*;

public class Graph {

    private HashMap<String,Vertex> vertices;

    private HashMap<Integer,Edge> edges = new HashMap<Integer, Edge>();

    public Graph(){
        this.vertices = new HashMap<>();
        this.edges = new HashMap<>();
    }

    public void addVertex (Vertex v){
        this.vertices.put(v.getLabel(), v);
    }

    public void removeVertex (String s){
        guardAgainstNoVertices();
        this.vertices.remove(s);
    }

    public void removeVertex(Vertex v){
        guardAgainstNoVertices();
        if (this.vertices.containsValue(v)){
            this.vertices.remove(v.getLabel());
        }
    }

    public void addEdge (Edge e){
        this.guardAgainstDuplicate(e);
        this.edges.put(e.hashCode(), e);
    }

    public void addEdge (Vertex vertexOne, Vertex vertexTwo,int weight){
        Edge e = new Edge(vertexOne, vertexTwo, weight);
        this.addEdge(e);
    }

    public void addEdge(Vertex one, Vertex two){
        addEdge(one, two, 1);
    }

    public void removeEdge(Edge e){
        guardAgainstNoEdges();
        if (this.containsEdge(e)){
            this.edges.remove(e.hashCode());
        }
    }

    public void removeEdge(Vertex one, Vertex two){
        Edge e = new Edge(one, two);
        this.removeEdge(e);
    }

    public HashMap<Integer,Edge> getEdges(){
        return this.edges;
    }

    public HashMap<String,Vertex> getVertices(){
        return this.vertices;
    }

    public boolean containsVertex (Vertex v){
        if (this.vertices.containsValue(v)){
            return true;
        }
        return false;
    }
    public boolean containsEdge(Edge e){
        Collection<Edge> values = this.edges.values();
        Iterator<Edge> it = values.iterator();
        while(it.hasNext()) {
            Edge next = it.next();
            if (next.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public  boolean containsEdge (Vertex one, Vertex two){
        Edge e = new Edge(one, two);
        return containsEdge(e);
    }

    public Set vertexKeys(){
        return vertices.keySet();
    }

    public void guardAgainstDuplicate(Edge e){
        if (this.containsEdge(e)) {
            throw new DuplicateEdgeException();
        }
    }

    public void guardAgainstNoEdges(){
        if (this.edges.size() == 0){
            throw new NoEdgeException();
        }
    }

    public void guardAgainstNoVertices(){
        if (this.vertices.size() == 0){
            throw  new NoVertexException();
        }
    }

//
//    public void guardAgainstLoop(){
//        if()
//            throw new EdgeLoopException();
//    }
}
