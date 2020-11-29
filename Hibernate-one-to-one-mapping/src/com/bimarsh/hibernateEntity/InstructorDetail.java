package com.bimarsh.hibernateEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// annotate class as entity
@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	// define the fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	// add new field for Bidirectional Relationship
	/* mappedBy --> Check instructorDetail Property of Instructor class
	 * 		@OneToOne(cascade=CascadeType.ALL)
	 * //Which attribute is related?
	 * 		@JoinColumn(name="instructor_detail_id")
	 * // In database foreign key is configured to reference id field in instructor_detail table
	 * 		private InstructorDetail instructorDetail;
	 */
	
	@OneToOne(mappedBy="instructorDetail", 
			cascade= {CascadeType.DETACH, CascadeType.MERGE, 
					  CascadeType.PERSIST, CascadeType.REFRESH})
	private Instructor instructor;
	
	
	
	//no-args constructor 
	public InstructorDetail() {
		
	}
	
	//constructor
	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	// getters and setters for Bidirectional Relationship
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}
	
}
