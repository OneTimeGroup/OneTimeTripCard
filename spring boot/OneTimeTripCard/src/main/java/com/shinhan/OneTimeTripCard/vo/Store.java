package com.shinhan.OneTimeTripCard.vo;

import java.time.LocalDateTime;

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
public class Store {
	@Id
	private char storeNo;			//��������ȣ
	private char storeName;			//�������̸�
	private Integer courseNodeId;	//�ش��ڽ����̵�

}
