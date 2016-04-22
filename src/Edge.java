
public class Edge {

    private Vertex vertexOne;

    private Vertex vertexTwo;

    private int weight;

    public Edge (Vertex one, Vertex two){
        Edge e = new Edge(one, two, 1);
    }

    public Edge (Vertex one, Vertex two, int i){
        int result = one.getLabel().compareToIgnoreCase(two.getLabel());
        if(result == 0){
            //throw a baby
        }
        if(result < 0){
            this.setVertexOne(one);
            this.setVertexTwo(two);
            this.setWeight(i);
        }
        else if (result > 0) {
        this.setVertexOne(two);
        this.setVertexTwo(one);
        this.setWeight(i);
        }
    }

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

    private void guardAgainstBeingTheSame(){

    }
}
