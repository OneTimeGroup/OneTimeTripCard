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
public class UserCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userCardId;			//pk
	private Long userId;
	private char cardNo;				//ī��ѹ�
	private Long managerId;  			// nullable ���� ������ ����
	private char nickName;  			// ī�庰Ī
	private char level;  				// ī����
	private Integer balance; 			// ī���ܾ�
	private Integer discountAmount; 	// ���� ���� �Ѿ�
	private Integer rechargeCount; 	 	// ������ Ƚ��
	private Boolean status; 			// ī�� ���� ���� Y, N
	private LocalDateTime createAt;		//ī�� ������¥
	private LocalDateTime expiredAt;	//���ᳯ¥
	private Boolean isGroup; 			// Y, N
	// �������� ������ Ȱ��ȭ�� user_card ���ε���
	// status�� ���� ��Ȱ��ȭ �����ش�.
	private Boolean isDefault; 			// Y, N �⺻ī��

}
