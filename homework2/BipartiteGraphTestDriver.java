package homework2;

import java.util.*;

/**
 * This class implements a testing driver for BipartiteGraph. The driver
 * manages BipartiteGraphs whose nodes and edges are Strings.
 */
public class BipartiteGraphTestDriver {

    private Map<String, BipartiteGraph<String>> graphs;

    /**
     * @modifies this
     * @effects Constructs a new test driver.
     */
    public BipartiteGraphTestDriver () {
    	// TODO: Implement this constructor
       this.graphs = new HashMap<String, BipartiteGraph<String>>();
    }

    
    /**
     * @requires graphName != null
     * @modifies this
     * @effects Creates a new graph named graphName. The graph is initially
     * 			empty.
     */
    public void createGraph(String graphName) {
        // TODO: Implement this method
      BipartiteGraph<String> graph = new BipartiteGraph<String>(graphName);
    	this.graphs.put(graphName, graph);
    }

    
    /**
     * @requires createGraph(graphName)
     *           && nodeName != null
     *           && neither addBlackNode(graphName,nodeName) 
     *                  nor addWhiteNode(graphName,nodeName)
     *                      has already been called on this
     * @modifies graph named graphName
     * @effects Adds a black node represented by the String nodeName to the
     * 			graph named graphName.
     */
    public void addBlackNode(String graphName, String nodeName) {
    	// TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	try {
				graph.addNode(nodeName, false);
			} catch (Exception e) {
				e.printStackTrace();
			}
    }

    
    /**
     * @requires createGraph(graphName)
     *           && nodeName != null
     *           && neither addBlackNode(graphName,nodeName) 
     *                  nor addWhiteNode(graphName,nodeName)
     *                      has already been called on this
     * @modifies graph named graphName
     * @effects Adds a white node represented by the String nodeName to the
     * 			graph named graphName.
     */
    public void addWhiteNode(String graphName, String nodeName) {
    	//TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	try {
				graph.addNode(nodeName, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
    }

    
    /**
     * @requires createGraph(graphName)
     *           && ((addBlackNode(parentName) && addWhiteNode(childName))
     *              || (addWhiteNode(parentName) && addBlackNode(childName)))
     *           && edgeLabel != null
     *           && node named parentName has no other outgoing edge labeled
     * 				edgeLabel
     *           && node named childName has no other incoming edge labeled
     * 				edgeLabel
     * @modifies graph named graphName
     * @effects Adds an edge from the node parentName to the node childName
     * 			in the graph graphName. The new edge's label is the String
     * 			edgeLabel.
     */
    public void addEdge(String graphName,
    					String parentName, String childName, 
                        String edgeLabel) {
    	//TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	try {
				graph.addEdge(edgeLabel, parentName, childName);
			} catch (Exception e) {
				e.printStackTrace();
			}
    }

    
    /**
     * @requires createGraph(graphName)
     * @return a space-separated list of the names of all the black nodes
     * 		   in the graph graphName, in alphabetical order.
     */
    public String listBlackNodes(String graphName) {
    	//TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> blackNodes = graph.getColorNodes(false);
    	blackNodes.sort( Comparator.naturalOrder() );;
    	String result = String.join(" ", blackNodes);
    	return result;
    }

    
    /**
     * @requires createGraph(graphName)
     * @return a space-separated list of the names of all the white nodes
     * 		   in the graph graphName, in alphabetical order.
     */
    public String listWhiteNodes(String graphName) {
    	//TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> blackNodes = graph.getColorNodes(true);
    	blackNodes.sort( Comparator.naturalOrder() );;
    	String result = String.join(" ", blackNodes);
    	return result;
    }

    
    /**
     * @requires createGraph(graphName) && createNode(parentName)
     * @return a space-separated list of the names of the children of
     * 		   parentName in the graph graphName, in alphabetical order.
     */
    public String listChildren(String graphName, String parentName) {
    	//TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> children = new ArrayList<String>();
    	try {
    		children = graph.getChildrens(parentName);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	children.sort(Comparator.naturalOrder());
    	String result = String.join(" ", children);
    	return result;
    }

    
    /**
     * @requires createGraph(graphName) && createNode(childName)
     * @return a space-separated list of the names of the parents of
     * 		   childName in the graph graphName, in alphabetical order.
     */
    public String listParents(String graphName, String childName) {
    	//TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	List<String> parents = new ArrayList<String>();
    	try {
    		parents = graph.getParents(childName);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	parents.sort(Comparator.naturalOrder());
    	String result = String.join(" ", parents);
    	return result;    	
    }

    
    /**
     * @requires addEdge(graphName, parentName, str, edgeLabel) for some
     * 			 string str
     * @return the name of the child of parentName that is connected by the
     * 		   edge labeled edgeLabel, in the graph graphName.
     */
    public String getChildByEdgeLabel(String graphName, String parentName,
    								   String edgeLabel) {
    	//TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	String result = new String();
    	try {
				result = graph.getChildEdge(edgeLabel, parentName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	return result;
    }

    
    /**
     * @requires addEdge(graphName, str, childName, edgeLabel) for some
     * 			 string str
     * @return the name of the parent of childName that is connected by the 
     * 		   edge labeled edgeLabel, in the graph graphName.
     */
    public String getParentByEdgeLabel(String graphName, String childName,
    									String edgeLabel) {
    	//TODO: Implement this method
    	BipartiteGraph<String> graph = this.graphs.get(graphName);
    	String result = new String();
    	try {
				result = graph.getParentEdge(edgeLabel, childName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	return result;
    	
    }
}
