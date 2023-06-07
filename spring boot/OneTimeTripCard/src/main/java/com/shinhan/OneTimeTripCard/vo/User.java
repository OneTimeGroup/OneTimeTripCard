package com.shinhan.OneTimeTripCard.vo;

import java.time.LocalDateTime;

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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;  
	private char email; 
	private char firstName;
	private char lastName;
	private char password; 
	private char phone; 
	private char preferredCurrency;		//����ȯ��
	private Boolean status;				//����� Y Ż�� N
	private char accountNo;				//������ �ڱ� ���� ��ȣ
	private char bankName;				//������ �ڱ� ���� �̸�

}
