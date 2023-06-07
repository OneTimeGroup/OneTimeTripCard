package com.shinhan.OneTimeTripCard.vo;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor  
@Table
@Entity
public class UserCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userCourseId;		//pk
	private Long userId; 	 		//����id
	private Long courseId;	 		//�ڽ�id
	private Date createdAt; 		//�ڽ�������¥
	private Boolean completed; 		// Y / N

}
