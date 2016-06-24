package com.piratesgame.helpers;

import com.piratesgame.graph.Edge;
import com.piratesgame.graph.Graph;
import com.piratesgame.graph.vertices.PortVertex;
import com.piratesgame.graph.vertices.Vertex;
import com.sun.xml.internal.ws.wsdl.writer.document.Port;

public class RunProgram {
    public static void main(String[] args) {
        PortVertex vE = new PortVertex("England");
        PortVertex vI = new PortVertex("Ireland");
        PortVertex vW = new PortVertex("Wales");
        PortVertex vS = new PortVertex("Scotland");

        Edge vEvI = new Edge(vE,vI);
        Edge vEvW = new Edge(vE,vW);
        Edge vIvS = new Edge(vI, vS);
        Edge vWvS = new Edge(vW,vS);

        Graph g = new Graph();
        g.addVertex(vE);
        g.addVertex(vI);
        g.addVertex(vW);
        g.addVertex(vS);
        g.addEdge(vEvI);
        g.addEdge(vEvW);
        g.addEdge(vIvS);
        g.addEdge(vWvS);
    }
}
