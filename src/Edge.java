
public class Edge {

    private Vertex vertexOne;

    private Vertex vertexTwo;

    private int weight;

    public void setWeight(int i){
        this.weight = i;
    }

    public void setVertexOne(Vertex v){
        this.vertexOne = v;
    }

    public void setVertexTwo(Vertex v){
        this.vertexTwo = v;
    }

    public int getWeight(){
        return this.weight;
    }

    public Vertex getVertexOne(){
        return this.vertexOne;
    }

    public Vertex getVertexTwo(){
        return this.vertexTwo;
    }

    public Vertex getNeighbour(Vertex v){
        if (v == this.vertexOne){
            return vertexTwo;
        }
        if (v == this.vertexTwo){
            return vertexOne;
        }
        else {return null;}
    }
}
