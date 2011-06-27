package org.goldenorb.algorithms.singleSourceShortestPath;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.IntWritable;
import org.goldenorb.Vertex;

/*
 * Start of non-generated import declaration code -- any code written outside of this block will be
 * removed in subsequent code generations.
 */

/* End of non-generated import declaraction code */

/**
 * This class represents a path to the source
 */
@SuppressWarnings("rawtypes")
public class PathWritable implements org.apache.hadoop.io.WritableComparable {

	/**
	 * the total weight of this path
	 */
	private IntWritable weight = new IntWritable(Integer.MAX_VALUE);

	/**
	 * the vertices on this path
	 */
	private ArrayWritable vertices = new ArrayWritable(new String[0]);

	/*
	 * Start of non-generated variable declaration code -- any code written
	 * outside of this block will be removed in subsequent code generations.
	 */

	/* End of non-generated variable declaraction code */

	/**
   * 
   */
	public PathWritable() {
		
	}

	/*
	 * Start of non-generated method code -- any code written outside of this
	 * block will be removed in subsequent code generations.
	 */

	/* End of non-generated method code */

	/**
	 * gets the total weight of this path
	 * 
	 * @return
	 */
	public IntWritable getWeight() {
		return weight;
	}

	/**
	 * sets the total weight of this path
	 * 
	 * @param weight
	 */
	public void setWeight(IntWritable weight) {
		this.weight = weight;
	}

	/**
	 * gets the vertices on this path
	 * 
	 * @return
	 */
	public ArrayWritable getVertices() {
		return vertices;
	}

	/**
	 * sets the vertices on this path
	 * 
	 * @param vertices
	 */
	public void setVertices(ArrayWritable vertices) {
		this.vertices = vertices;
	}

	/**
	 * adds a vertex to this path
	 * 
	 * @param vertices
	 */
	public void addVertex(Vertex vertex) {
		this.vertices = vertices;
		String[] path = vertices.toStrings();
		String[] newpath = new String[path.length+1];
		for(int i=0; i < path.length; i++) {
			newpath[i] = path[i];
		}
		newpath[path.length] = vertex.vertexID();
	}

	// /////////////////////////////////////
	// Writable
	// /////////////////////////////////////
	public void readFields(DataInput in) throws IOException {
		weight.readFields(in);
		vertices.readFields(in);
	}

	public void write(DataOutput out) throws IOException {
		weight.write(out);
		vertices.write(out);
	}

	// /////////////////////////////////////
	// Comparable
	// /////////////////////////////////////
	public int compareTo(Object o) {
		return weight.compareTo(((PathWritable) o).weight);
	}

	public boolean equals(Object o) {
		return weight.equals(((PathWritable) o).weight)
				&& vertices.equals(((PathWritable) o).vertices);
	}
}
