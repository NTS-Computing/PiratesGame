import java.util.ArrayList;

public class Vertex {

    private String label;

    private ArrayList<Edge> incidenceNeighbourhood;

    public void setLabel(String s){
        this.label = s;
    }

    public void addNeighbour(Edge e){
        this.incidenceNeighbourhood.add(e);
    }

    public String getLabel(){
        return this.label;
    }

    public ArrayList getNeighbourhood(){
        return this.incidenceNeighbourhood;
    }

    public Edge getNeighbour(int i){
        return this.incidenceNeighbourhood.get(i);
    }

    public void removeNeighbour(int i){
        this.incidenceNeighbourhood.remove(i);
    }

    public void removeNeighboir(Edge e){
        if (this.incidenceNeighbourhood.contains(e)){ this.incidenceNeighbourhood.remove(e); }
    }
}
