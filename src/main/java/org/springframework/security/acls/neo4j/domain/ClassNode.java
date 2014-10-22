package org.springframework.security.acls.neo4j.domain;

import java.util.Objects;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.support.index.IndexType;

@NodeEntity
public class ClassNode extends BaseNode {

	@GraphId
	private Long graphId;
	
	@Indexed(indexName="class_name", indexType=IndexType.FULLTEXT)
	private String className;
	
	public ClassNode() {}	

	public ClassNode(String className) {
		this();
		this.className = className;
	}

	public Long getGraphId() {
		return graphId;
	}

	public void setGraphId(Long graphId) {
		this.graphId = graphId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(o == this) {
			return true;
		}
		
		if(o instanceof ClassNode) {
			ClassNode other = (ClassNode) o;
			return getClassName().equals(other.getClassName());
		}
		
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(getClassName());
	}
	
}
