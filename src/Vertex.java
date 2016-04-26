import java.util.ArrayList;

public class Vertex {

    private String label;

    private ArrayList<Edge> incidenceNeighbourhood;

    public Vertex (String s){
        this.setLabel(s);
    }

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

    public void removeNeighbour(Edge e){
        if (this.incidenceNeighbourhood.contains(e)){
            this.incidenceNeighbourhood.remove(e);
        }
    }

    public boolean containsNeighbour(Edge e){
        if (incidenceNeighbourhood.contains(e)){
            return true;
        }
        return false;
    }

    public int getNeighbourCount(){
        return incidenceNeighbourhood.size();
    }

    public int hashCode(){
        return this.getLabel().hashCode();
    }

    public String toString(){
        return "Vertex: "+this.getLabel();
    }
}
