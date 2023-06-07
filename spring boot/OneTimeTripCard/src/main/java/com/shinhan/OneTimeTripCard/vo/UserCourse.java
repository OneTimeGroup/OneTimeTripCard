package com.shinhan.OneTimeTripCard.vo;

import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
	@EmbeddedId
	MultiKeyUserCourse UserCourseID;
	
//	Long userId; 	 //����id
//	Long courseId;	 //�ڽ�id
	Date createdAt; //�ڽ�������¥
	Boolean completed;  // Y / N

}
